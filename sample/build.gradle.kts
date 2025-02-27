plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.whetstone)
    alias(libs.plugins.kotlinKapt)
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
    lint.baseline = file("lint-baseline.xml")
}

dependencies {
    kapt(libs.daggerCompiler)

    implementation(libs.androidxActivity)
    implementation(libs.androidxCore)
    implementation(libs.androidxAppCompat)
    implementation(libs.androidxComposeMaterial)
    implementation(libs.androidxComposeUi)
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}
