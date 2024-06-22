plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.mavenPublish)
    alias(libs.plugins.kotlinComposeCompiler)
}

android {
    buildFeatures.compose = true
    namespace = "com.deliveryhero.whetstone.compose"
}

dependencies {
    implementation(projects.whetstone)
    implementation(libs.androidxComposeRuntime)
    implementation(libs.androidxLifecycleViewModelCompose)
}
