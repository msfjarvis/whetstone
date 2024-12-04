plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinComposeCompiler)
    alias(libs.plugins.mavenPublish)
}

android {
    buildFeatures.compose = true
    namespace = "com.deliveryhero.whetstone.compose"
    composeOptions.kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    namespace = "com.deliveryhero.whetstone.compose"
}

dependencies {
    implementation(projects.whetstone)
    implementation(libs.androidxComposeRuntime)
    implementation(libs.androidxLifecycleViewModelCompose)
}
