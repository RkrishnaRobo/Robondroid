package com.robondroid

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: BaseExtension,
) {
    commonExtension.apply {
        buildFeatures.apply {
            compose = true
            viewBinding = true
            buildConfig = true
        }

        dependencies {
            val bom = libs.findLibrary("compose-bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("implementation", libs.findLibrary("androidx-compose-ui").get())
            add("implementation", libs.findLibrary("androidx-compose-ui-viewbinding").get())
            add("implementation", libs.findLibrary("androidx-compose-ui-graphics").get())
            add("implementation", libs.findLibrary("androidx-compose-ui-tooling").get())
            add("implementation", libs.findLibrary("androidx-compose-ui-tooling-preview").get())
            add("implementation", libs.findLibrary("androidx-compose-foundation").get())
            add("implementation", libs.findLibrary("androidx-compose-animation-graphics").get())
            add("implementation", libs.findLibrary("androidx-compose-animation").get())
            add("implementation", libs.findLibrary("androidx-compose-material-icons-extended").get())
            add("implementation", libs.findLibrary("androidx-compose-material3").get())

            // tv
            add("implementation", libs.findLibrary("androidx-tv-material").get())
        }
    }
}
