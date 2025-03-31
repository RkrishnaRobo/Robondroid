plugins {
    id("kotlinx-serialization")
    alias(libs.plugins.robondroid.android.library)
    alias(libs.plugins.robondroid.hilt)
}

android {
    namespace = "com.core.data.onboarding"
}
dependencies {
    api(projects.core.network)
    api(projects.core.common.general)
    implementation(projects.core.domain.onboarding)
    implementation(projects.core.data.general)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.firebase.auth.ktx)
}
