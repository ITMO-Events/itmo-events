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

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }

    dependencies {
        implementation(project(":shared"))

        val composeBom = platform("androidx.compose:compose-bom:2023.10.01")
        implementation(composeBom)
        androidTestImplementation(composeBom)

        // Choose one of the following:
        // Material Design 3
        implementation("androidx.compose.material3:material3")
        // or skip Material Design and build directly on top of foundational components
        implementation("androidx.compose.foundation:foundation")
        // or only import the main APIs for the underlying toolkit systems,
        // such as input and measurement/layout
        implementation("androidx.compose.ui:ui")

        // Android Studio Preview support
        implementation("androidx.compose.ui:ui-tooling-preview")
        debugImplementation("androidx.compose.ui:ui-tooling")

        implementation(libs.decompose.decompose)
        implementation(libs.decompose.extensionsComposeJetbrains)
    }
}