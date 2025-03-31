plugins {
    alias(libs.plugins.robondroid.android.library)
    alias(libs.plugins.robondroid.compose)
}

android {
    namespace = "com.core.common.navigation"
}

dependencies {
    implementation(projects.feature.register.ui.main)
    implementation(projects.feature.signin.ui.main)
    implementation(projects.feature.home.ui.main)
}