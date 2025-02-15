import com.android.build.api.dsl.LibraryExtension
import com.robondroid.configureKotlinAndroid
import com.robondroid.ext.implementation
import com.robondroid.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("robondroid.detekt")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(commonExtension = this)
            }

            dependencies {
                implementation(libs.findLibrary("kotlinx-serialization-json").get())
            }
        }
    }

}