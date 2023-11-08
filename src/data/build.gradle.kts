import ShoLiDependencies.Libraries.addAppCompat
import ShoLiDependencies.Libraries.addCoreTesting
import ShoLiDependencies.Libraries.addHilt
import ShoLiDependencies.Libraries.addRoom

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.spindler.sholi.data"
    compileSdk = ShoLiDependencies.AndroidSdk.compileSdk

    defaultConfig {
        minSdk = ShoLiDependencies.AndroidSdk.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = ShoLiDependencies.JavaSdk.compatibility
        targetCompatibility = ShoLiDependencies.JavaSdk.compatibility
    }
    kotlinOptions {
        jvmTarget = ShoLiDependencies.JavaSdk.jvmTarget
    }
}

dependencies {
    implementation(project(":domain"))

    addAppCompat()
    addHilt()
    addRoom()
    addCoreTesting()
}