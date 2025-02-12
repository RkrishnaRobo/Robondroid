import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree.Companion.test

plugins {
    id("kotlin")
    alias(libs.plugins.robondroid.java.library)
    alias(libs.plugins.robondroid.hilt)
    id("kotlinx-serialization")
}
dependencies {
    // ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.serialization.json)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.ktor.logging)

    api(projects.core.common.general)

    //test
    testImplementation(libs.junit)

    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.serialization.json)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.ktor.client.core)
    testImplementation(libs.ktor.client.mock)
    testImplementation(libs.kotlinx.coroutines.test)


    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("org.slf4j:slf4j-simple:2.0.0")  // Lightweight logger

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.3")
}