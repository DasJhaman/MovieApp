pluginManagement {
    val kotlinVersion: String by settings
    val composeVersion: String by settings
    val agpVersion: String by settings

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion
        id("com.android.application") version agpVersion
        id("com.android.library") version agpVersion
        id("org.jetbrains.compose") version composeVersion
        id("org.jetbrains.kotlin.android") version kotlinVersion

    }

}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}
rootProject.name = "MovieApp"
include(":androidApp")
include(":shared")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")