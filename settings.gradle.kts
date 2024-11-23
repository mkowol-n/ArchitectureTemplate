pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ArchitectureTemplate"

includeBuild("build-logic")

include(":app")
include(":features:login")
include(":features:login:impl")
include(":core:navigation:api")
include(":core:navigation:impl")
include(":features:dashboard")
include(":features:dashboard:impl")
include(":core:navigation:graphs:base")
include(":core:navigation:graphs:main-graph")
