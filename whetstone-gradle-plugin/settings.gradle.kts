@file:Suppress("UnstableApiUsage")

rootProject.name = "whetstone-gradle-plugin"

pluginManagement {
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
        google()
        mavenCentral()
    }
}
