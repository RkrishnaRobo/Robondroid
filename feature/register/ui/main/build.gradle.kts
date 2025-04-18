plugins {
    alias(libs.plugins.robondroid.feature)
    alias(libs.plugins.robondroid.compose)
}

android {
    namespace = "com.feature.register.ui.main"
}

dependencies {
    implementation(projects.feature.register.presentation)
    implementation(projects.core.ui)
}
