plugins {
    alias(libs.plugins.robondroid.android.library)
    alias(libs.plugins.robondroid.compose)
}

android {
    namespace = "com.core.common.navigation"
}

dependencies {
    implementation(projects.feature.onboarding.ui.main)
}