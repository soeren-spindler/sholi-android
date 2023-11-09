import ShoLiDependencies.Libraries.addAppCompat
import ShoLiDependencies.Libraries.addCompose
import ShoLiDependencies.Libraries.addComposeTesting
import ShoLiDependencies.Libraries.addCoreTesting
import ShoLiDependencies.Libraries.addHilt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.spindler.sholi.app"
    compileSdk = ShoLiDependencies.AndroidSdk.compileSdk

    defaultConfig {
        applicationId = "com.spindler.sholi.app"
        minSdk = ShoLiDependencies.AndroidSdk.minSdk
        targetSdk = ShoLiDependencies.AndroidSdk.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file("./keystore/sholi-release.jks")
            storePassword = System.getenv("SIGNING_RELEASE_KEYSTORE_PASSWORD")
            keyAlias = System.getenv("SIGNING_RELEASE_KEY_ALIAS")
            keyPassword = System.getenv("SIGNING_RELEASE_KEY_PASSWORD")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            signingConfig = signingConfigs.getByName("release")
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {
    implementation(project(":domain"))
    implementation(project(":usecase"))
    implementation(project(":data"))

    addAppCompat()
    addHilt()
    addCompose()
    addCoreTesting()
    addComposeTesting()
}
