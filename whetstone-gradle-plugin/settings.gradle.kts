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

plugins { id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0" }

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
