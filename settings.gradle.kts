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
include(":data")
include(":data:authorization")
include(":core:config:state-management")
include(":data:authorization:remote")
include(":core:config")
include(":core:config:http")
include(":data:authorization:impl")
include(":core:config:shared")
include(":features:todo_list")
include(":features:account")
include(":features:todo-details")
include(":features:todo-details:impl")
include(":features:todo_list:impl")
include(":features:account:impl")
