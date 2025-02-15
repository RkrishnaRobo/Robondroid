plugins {
    alias(libs.plugins.robondroid.android.library)
    alias(libs.plugins.robondroid.compose)
}

android {
    namespace = "com.core.ui"
}

dependencies {
    implementation(projects.core.designSystem)
}