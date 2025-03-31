plugins {
    alias(libs.plugins.robondroid.feature)
    alias(libs.plugins.robondroid.compose)
}

android {
    namespace = "com.feature.signin.ui.main"
}

dependencies {
    implementation(projects.feature.signin.presentation)
    implementation(projects.core.ui)
}
