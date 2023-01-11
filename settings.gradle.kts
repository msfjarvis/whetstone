enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "pd-whetstone"

pluginManagement {
    includeBuild("whetstone-gradle-plugin")
    repositories {
        exclusiveContent {
            forRepository { maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
            filter { includeGroup("com.squareup.anvil") }
        }
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        exclusiveContent {
            forRepository { maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
            filter { includeGroup("com.squareup.anvil") }
        }
        exclusiveContent {
            forRepository { maven("https://androidx.dev/storage/compose-compiler/repository/") }
            filter { includeGroup("androidx.compose.compiler") }
        }
        google()
        mavenCentral()
    }
}

include(":sample")
include(":whetstone")
include(":whetstone-compiler")
include(":whetstone-compose")
include(":whetstone-worker")
