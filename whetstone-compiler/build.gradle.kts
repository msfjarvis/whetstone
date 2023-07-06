plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.mavenPublish)
}

kotlin.jvmToolchain {
    languageVersion.set(JavaLanguageVersion.of("17"))
}

dependencies {
    implementation(libs.anvilCompiler)
    implementation(libs.anvilCompilerUtils)
    implementation(libs.anvilAnnotations)
    implementation(libs.dagger)
    implementation(libs.autoServiceAnnotations)
    kapt(libs.autoServiceCompiler)
}
