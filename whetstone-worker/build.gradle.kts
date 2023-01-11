@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.anvil)
    alias(libs.plugins.mavenPublish)
}

anvil {
    generateDaggerFactories.set(true)
}

android { namespace = "com.deliveryhero.whetstone.worker" }

dependencies {
    implementation(projects.whetstone)
    implementation(libs.dagger)
    api(libs.androidxWorkRuntime)

    testImplementation(kotlin("test-junit"))
    testImplementation(testFixtures(libs.anvilCompilerUtils))
    testImplementation(projects.whetstoneCompiler)
}
