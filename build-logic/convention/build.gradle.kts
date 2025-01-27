import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.master.robondroid.build-logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.ktlint.gradlePlugin)
}

gradlePlugin {
    /**
     * Register convention plugins so they are available in the build scripts of the application
     */

    plugins {
        register("robondroidAndroidApplication") {
            id = "robondroid.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("robondroidAndroidLibrary") {
            id = "robondroid.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("robondroidCompose") {
            id = "robondroid.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("robondroidHilt") {
            id = "robondroid.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("robondroidRoom") {
            id = "robondroid.room"
            implementationClass = "RoomConventionPlugin"
        }
        register("robondroidFeature") {
            id = "robondroid.feature"
            implementationClass = "FeatureConventionPlugin"
        }
        register("robondroidDestinations") {
            id = "robondroid.destinations"
            implementationClass = "DestinationsConventionPlugin"
        }
        register("robondroidKtLint") {
            id = "robondroid.ktlint"
            implementationClass = "KtLintConventionPlugin"
        }
    }
}