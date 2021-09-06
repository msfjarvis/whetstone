plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.squareup.anvil")
    id("kotlin-kapt")
}

android {
    defaultConfig {
        applicationId = "com.deliveryhero.whetstone.sample"
    }
}

dependencies {
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)
    implementation(":whetstone")
    anvil(":whetstone-compiler")

    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}
