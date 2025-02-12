plugins {
    id("kotlin")
    alias(libs.plugins.robondroid.java.library)
}
dependencies {
    api(projects.core.domain.general)
    implementation(libs.javax.inject)
}
