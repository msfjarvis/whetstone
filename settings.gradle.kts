enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "pd-whetstone"

pluginManagement {
    includeBuild("whetstone-gradle-plugin")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        exclusiveContent {
            forRepository { maven("https://androidx.dev/storage/compose-compiler/repository") }
            filter { includeGroup("androidx.compose.compiler") }
        }
    }
}

include(":sample")
include(":whetstone")
include(":whetstone-compiler")
include(":whetstone-compose")
include(":whetstone-worker")
