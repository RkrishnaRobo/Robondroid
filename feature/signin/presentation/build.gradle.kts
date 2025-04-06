plugins {
    alias(libs.plugins.robondroid.feature)
}

android {
    namespace = "com.feature.signin.presentation"
}

dependencies {
    api(projects.core.common.general)
    implementation(projects.core.domain.onboarding)
}