import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java-gradle-plugin")
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.mavenPublish).apply(false)
}

loadParentProperties()
pluginManager.apply(com.vanniktech.maven.publish.MavenPublishPlugin::class)

kotlin.jvmToolchain(11)

tasks.withType<KotlinCompile>().configureEach {
    dependsOn(generateBuildConfig)
    compilerOptions.jvmTarget = JvmTarget.JVM_11
    compilerOptions.freeCompilerArgs.add("-Xexplicit-api=strict")
}

gradlePlugin {
    plugins {
        create("whetstone") {
            id = "dev.msfjarvis.whetstone"
            implementationClass = "com.deliveryhero.whetstone.gradle.WhetstonePlugin"
        }
    }
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(libs.anvilGradle)
    compileOnly(libs.androidGradle)
    compileOnly(libs.autoServiceAnnotations)
    kapt(libs.autoServiceCompiler)
}

val generateBuildConfig by tasks.registering(GenerateBuildConfigTask::class) {
    val props = mapOf(
        "GROUP" to project.property("GROUP").toString(),
        "VERSION" to project.property("VERSION_NAME").toString(),
    )
    properties.set(props)
    generatedSourceDir.set(layout.buildDirectory.dir("generated/wgp/kotlin/main"))
}

sourceSets.main.configure { java.srcDir(generateBuildConfig) }

abstract class GenerateBuildConfigTask : DefaultTask() {
    @get:Input
    abstract val properties: MapProperty<String, String>

    @get:OutputDirectory
    abstract val generatedSourceDir: DirectoryProperty

    @TaskAction
    fun taskAction() {
        val buildFile = generatedSourceDir.file("com/deliveryhero/whetstone/gradle/BuildConfig.kt")

        buildFile.get().asFile.run {
            parentFile.mkdirs()
            val content = buildString {
                appendLine("package com.deliveryhero.whetstone.gradle")
                appendLine()
                appendLine("internal object BuildConfig {")
                properties.get().forEach { (k, v) -> appendLine("  const val $k = \"$v\"") }
                appendLine("}")
            }
            writeText(content)
        }
    }
}

fun loadParentProperties() {
    val properties = Properties()
    file("../gradle.properties").inputStream().use { properties.load(it) }

    properties.forEach { (k, v) ->
        val key = k.toString()
        val value = providers.gradleProperty(name).getOrElse(v.toString())
        extra.set(key, value)
    }
}

afterEvaluate {
    with(tasks) {
        findByName("kaptGenerateStubsKotlin")?.dependsOn(findByName("generateBuildConfig"))
    }
}
