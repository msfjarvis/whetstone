@file:Suppress("UnstableApiUsage")

rootProject.name = "whetstone-gradle-plugin"

pluginManagement {
    repositories {
        exclusiveContent {
            forRepository { maven("https://oss.sonatype.org/content/repositories/snapshots/") }
            filter { includeGroup("dev.msfjarvis.whetstone") }
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
            forRepository { maven("https://oss.sonatype.org/content/repositories/snapshots/") }
            filter { includeGroup("dev.msfjarvis.whetstone") }
        }
        google()
        mavenCentral()
    }
}
