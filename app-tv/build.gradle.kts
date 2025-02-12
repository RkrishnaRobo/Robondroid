plugins {
    alias(libs.plugins.robondroid.application)
    alias(libs.plugins.robondroid.compose)
    alias(libs.plugins.robondroid.hilt)
}

val applicationName: String = libs.versions.applicationName.get()
val appId: String = libs.versions.applicationId.get()
val appVersion: String = libs.versions.versionName.get()

android {
    namespace = appId

    defaultConfig {
        applicationId = appId
        versionCode = 1
        versionName = appVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    tasks.withType<Test> {
        jvmArgs(
            "-Djava.util.logging.ConsoleHandler.level=SEVERE"
        )
        useJUnitPlatform()
    }

}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(projects.core.designSystem)
}
