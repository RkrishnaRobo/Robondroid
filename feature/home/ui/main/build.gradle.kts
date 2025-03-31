plugins {
    alias(libs.plugins.robondroid.feature)
    alias(libs.plugins.robondroid.compose)
}

android {
    namespace = "com.feature.home.ui.main"
}

dependencies {
    implementation(projects.feature.home.presentation)
    implementation(projects.core.ui)
}
