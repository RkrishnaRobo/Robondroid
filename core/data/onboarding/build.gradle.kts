plugins {
    id("kotlin")
    id("kotlinx-serialization")
    alias(libs.plugins.robondroid.java.library)
    alias(libs.plugins.robondroid.hilt)
}

dependencies {
    api(projects.core.network)
    api(projects.core.common.general)
    implementation(projects.core.domain.onboarding)
    implementation(projects.core.data.general)
    implementation(libs.kotlinx.serialization.json)
}
