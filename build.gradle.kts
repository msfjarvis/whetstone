import com.android.build.gradle.BaseExtension
import org.gradle.api.tasks.compile.JavaCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinKapt) apply false
    alias(libs.plugins.mavenPublish) apply false
    alias(libs.plugins.kotlinBinaryCompatibilityValidator)
}

subprojects {
    afterEvaluate {
        tasks.withType<KotlinCompile> {
            configureTask()
        }
        tasks.withType<JavaCompile> {
            sourceCompatibility = JavaVersion.VERSION_11.toString()
            targetCompatibility = JavaVersion.VERSION_11.toString()
        }
        extensions.findByType<BaseExtension>()?.apply {
            configureExtension()
        }
    }
}

fun KotlinCompile.configureTask() {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11

        val compilerArgs = mutableListOf(
            "-Xassertions=jvm",
            "-opt-in=kotlin.RequiresOptIn",
            "-opt-in=com.squareup.anvil.annotations.ExperimentalAnvilApi",
        )
        if (project.name != "sample") compilerArgs += "-Xexplicit-api=strict"
        freeCompilerArgs.addAll(compilerArgs)
    }
}

fun BaseExtension.configureExtension() {
    compileSdkVersion(34)

    defaultConfig {
        minSdk = 21
        targetSdk = 34
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

apiValidation {
    ignoredProjects.addAll(listOf("sample", "whetstone-compiler"))
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
