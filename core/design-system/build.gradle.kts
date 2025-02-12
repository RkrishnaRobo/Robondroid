plugins {
    alias(libs.plugins.robondroid.android.library)
    alias(libs.plugins.robondroid.compose)
}

android {
    namespace = "com.core.designsystem"
}

dependencies {
    implementation(libs.androidx.appcompat)
}
