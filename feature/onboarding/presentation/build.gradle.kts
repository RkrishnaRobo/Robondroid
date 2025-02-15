plugins {
    alias(libs.plugins.robondroid.feature)
}

android {
    namespace = "com.feature.onboarding.presentation"
}

dependencies {
    api(projects.core.common.general)
    implementation(projects.core.domain.onboarding)
    implementation(projects.core.data.onboarding)
}