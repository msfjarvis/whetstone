plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.whetstone)
}

whetstone.addOns {
    compose.set(true)
    workManager.set(true)
}

android {
    namespace = "com.deliveryhero.whetstone.sample"
    defaultConfig {
        versionCode = 1
        versionName = "1.0"
        applicationId = "com.deliveryhero.whetstone.sample"
    }
    namespace = "com.deliveryhero.whetstone.sample"
    buildFeatures.compose = true
    buildFeatures.viewBinding = true
    composeOptions.kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
}

dependencies {
    implementation(libs.androidxActivity)
    implementation(libs.androidxCore)
    implementation(libs.androidxAppCompat)
    implementation(libs.androidxComposeMaterial)
    implementation(libs.androidxComposeUi)
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
