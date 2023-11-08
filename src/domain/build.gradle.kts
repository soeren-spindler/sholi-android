import ShoLiDependencies.Libraries.addAppCompat
import ShoLiDependencies.Libraries.addCoreTesting

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.spindler.sholi.domain"
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
    addAppCompat()
    addCoreTesting()
}
