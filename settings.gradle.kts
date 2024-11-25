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
include(":features:main")
include(":features")
include(":features:login")
include(":features:login:impl")
include(":features:dashboard")
include(":features:dashboard:impl")
include(":features:todo-details")
include(":features:todo-details:impl")
include(":features:account")
include(":features:account:impl")
include(":features:todo-list")
include(":features:todo-list:impl")

include(":data:authorization")
include(":data:authorization:remote")
include(":data:authorization:impl")

include(":core:navigation")
include(":core:navigation:impl")

include(":core:common")
include(":core:common:impl")
include(":core:state-management")

include(":coreUi")

include(":core:settings:local-impl")
include(":data:todo")
include(":data:todo:impl")
include(":data:todo:local")
include(":usecases")
include(":usecases:combined")
include(":usecases:combined:impl")
include(":usecases:emailvalidator")
include(":usecases:emailvalidator:impl")

include(":infrastructure:database")
include(":infrastructure:http:impl")
include(":infrastructure:http")
include(":infrastructure:shared")
