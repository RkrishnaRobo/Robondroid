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
include(":core:network")
include(":core:common:general")
include(":core:data:onboarding")
include(":core:data:general")
include(":core:domain:general")
include(":core:domain:onboarding")
include(":feature:onboarding:presentation")
include(":feature:onboarding:ui")
include(":feature:onboarding:ui:mobile")
include(":feature:onboarding:ui:tv")
include(":feature:onboarding:ui:main")

include(":core:design-system")
