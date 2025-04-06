plugins {
    alias(libs.plugins.robondroid.feature)
}

android {
    namespace = "com.feature.register.presentation"
}

dependencies {
    api(projects.core.common.general)
    implementation(projects.core.domain.onboarding)
}