import com.android.build.gradle.BaseExtension
import org.gradle.api.tasks.compile.JavaCompile
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
            sourceCompatibility = JavaVersion.VERSION_17.toString()
            targetCompatibility = JavaVersion.VERSION_17.toString()
        }
        extensions.findByType<BaseExtension>()?.apply {
            configureExtension()
        }
    }
}

fun KotlinCompile.configureTask() {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()

        val compilerArgs = mutableListOf(
            "-Xassertions=jvm",
            "-opt-in=kotlin.RequiresOptIn",
            "-opt-in=com.squareup.anvil.annotations.ExperimentalAnvilApi",
        )
        if (project.name != "sample") compilerArgs += "-Xexplicit-api=strict"
        freeCompilerArgs = freeCompilerArgs + compilerArgs
    }
}

fun BaseExtension.configureExtension() {
    compileSdkVersion(33)

    defaultConfig {
        minSdk = 21
        targetSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

apiValidation {
    ignoredProjects.addAll(listOf("sample", "whetstone-compiler"))
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
