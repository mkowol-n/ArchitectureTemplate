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

include(":core:config:http")
include(":core:config:shared")

include(":core:navigation")
include(":core:navigation:impl")

include(":core:common")
include(":core:common:impl")
include(":core:state-management")

include(":coreUi")

include(":core:settings:local-impl")
include(":core:config:http:impl")
include(":core:config:database")
include(":data:todo")
include(":data:todo:impl")
include(":data:todo:local")
include(":usacases")
