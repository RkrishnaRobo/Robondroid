pluginManagement {
    includeBuild("build-logic")
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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
// added to avoid re build issue
gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))
rootProject.name = "Robondroid"
include(":app-mobile")
include(":app-tv")
include(":core:ui")
include(":core:network")
include(":core:common:general")
include(":core:data:onboarding")
include(":core:data:general")
include(":core:domain:general")
include(":core:domain:onboarding")
include(":core:design-system")
include(":core:common:navigation")

include(":feature:register:presentation")
include(":feature:register:ui:mobile")
include(":feature:register:ui:tv")
include(":feature:register:ui:main")

include(":feature:signin:presentation")
include(":feature:signin:ui:mobile")
include(":feature:signin:ui:tv")
include(":feature:signin:ui:main")

include(":feature:home:presentation")
include(":feature:home:ui:mobile")
include(":feature:home:ui:tv")
include(":feature:home:ui:main")
