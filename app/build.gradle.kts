plugins {
    alias(libs.plugins.robondroid.application)
    alias(libs.plugins.robondroid.compose)
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        JavaVersion.VERSION_17.toString()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    flavorDimensions += "platform"
    productFlavors {
        create("mobile") {
            dimension = "platform"
            applicationIdSuffix = ".mobile"
            versionNameSuffix = "-mobile"
        }
        create("tv") {
            dimension = "platform"
            applicationIdSuffix = ".tv"
            versionNameSuffix = "-tv"
        }
    }

    sourceSets {
        getByName("mobile") {
            manifest.srcFile("src/mobile/AndroidManifest.xml")
        }
        getByName("tv") {
            manifest.srcFile("src/tv/AndroidManifest.xml")
        }
    }

}

dependencies {
    implementation(project(":feature:home:tv"))
    implementation(project(":feature:home:mobile"))
}
