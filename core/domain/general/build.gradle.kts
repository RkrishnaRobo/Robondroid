plugins {
    alias(libs.plugins.robondroid.java.library)
    alias(libs.plugins.robondroid.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
