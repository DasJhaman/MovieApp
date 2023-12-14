plugins {
    kotlin("jvm") apply (false)
    kotlin("multiplatform") apply (false)
    kotlin("android") apply (false)
    kotlin("plugin.serialization") apply (false)
    id("com.android.application") apply (false)
    id("com.android.library") apply (false)
    id("org.jetbrains.compose") apply (false)
}

subprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }

}

buildscript {
    dependencies {
        classpath(libs.moko.resourcesGradlePlugin)
        classpath(libs.buildConfig.gradle.plugin)
    }
}