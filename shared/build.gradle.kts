import com.codingfeline.buildkonfig.compiler.FieldSpec

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
    id("com.codingfeline.buildkonfig")
    kotlin("plugin.serialization")
}

kotlin {
    androidTarget()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                api(libs.kermit)
                api(libs.kotlinx.coroutines.core)
                api(libs.bundles.ktor.common)
                api(libs.koin.core)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.runtime)
                implementation(libs.bundles.voyager.common)
                api(libs.moko.resourcesCompose)
                api(libs.kotlinx.serialization.json.okio)
                api(libs.androidx.datastore)
                api(libs.image.loader)
            }
        }

        androidMain {
            dependsOn(commonMain.get()) // this is quick hack for moko resource library
            dependencies {
                api(libs.koin.android)
                api(libs.koin.compose)
                api(libs.compose.activity)
                implementation(libs.ktor.client.okhttp)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        iosMain {
            dependsOn(commonMain.get())
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

buildkonfig {
    packageName = "das.jhaman.moviedbapp"
    val localProperties =
        com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir)
    defaultConfigs {
        buildConfigField(
            FieldSpec.Type.STRING,
            "API_BASE_URL",
            localProperties["API_BASE_URL"]?.toString().orEmpty()
        )
        buildConfigField(
            FieldSpec.Type.STRING,
            "AUTH_TOKEN",
            localProperties["AUTH_TOKEN"]?.toString().orEmpty()
        )
        buildConfigField(
            FieldSpec.Type.STRING,
            "IMAGE_BASE_URL",
            localProperties["IMAGE_BASE_URL"]?.toString().orEmpty()
        )
    }
}

android {
    namespace = "das.jhaman.movieapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "moviedb.app"
}