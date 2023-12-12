plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()
    jvm()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = libs.versions.jvmTarget.get()
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(project(":shared"))

                // Compose Libraries
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material3)

                // Decompose Libraries
                implementation(libs.decompose.decompose)
                implementation(libs.decompose.extensionsComposeJetbrains)
            }
        }

    }
}

android {
    namespace = "com.example.myapplication.compose"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.4"
//    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
//    buildFeatures {
//        compose = true
//    }

    dependencies {
        implementation(project(":shared"))

        implementation(compose.preview)

        implementation(compose.ui)
        implementation(compose.foundation)
        implementation(compose.material3)

        implementation(libs.decompose.decompose)
        implementation(libs.decompose.extensionsComposeJetbrains)
    }
}