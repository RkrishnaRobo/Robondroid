import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

class KtLintConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jlleitschuh.gradle.ktlint")
            }

            extensions.configure<KtlintExtension> {
                apply {
                    verbose.set(true)
                    outputToConsole.set(true)
                    coloredOutput.set(true)
                    android.set(true)
                    ignoreFailures.set(false) // Fail the build if KtLint finds any issues
                    reporters {
                        reporter(ReporterType.CHECKSTYLE)
                        reporter(ReporterType.JSON)
                        reporter(ReporterType.HTML)
                    }
                }
            }

            tasks.register("runKtlintCheck") {
                group = "verification"
                description = "Runs ktlint checks."
                dependsOn("ktlintCheck")
            }

            subprojects {
                apply("org.jlleitschuh.gradle.ktlint")
                extensions.configure<KtlintExtension> {
                    apply {
                        verbose.set(true)
                        outputToConsole.set(true)
                        coloredOutput.set(true)
                        android.set(true)
                        ignoreFailures.set(false) // Fail the build if KtLint finds any issues
                        reporters {
                            reporter(ReporterType.CHECKSTYLE)
                            reporter(ReporterType.JSON)
                            reporter(ReporterType.HTML)
                        }
                    }
                }
            }
        }
    }
}
