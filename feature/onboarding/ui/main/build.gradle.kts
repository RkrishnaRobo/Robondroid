plugins {
    alias(libs.plugins.robondroid.feature)
    alias(libs.plugins.robondroid.compose)
}

android {
    namespace = "com.feature.onboarding.ui.main"
}

dependencies {
    implementation(projects.feature.onboarding.presentation)
    implementation(projects.core.ui)
}
