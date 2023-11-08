import org.gradle.api.JavaVersion
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object ShoLiDependencies {

    object JavaSdk {
        val compatibility = JavaVersion.toVersion(17)
        const val jvmTarget = "17"
    }

    object AndroidSdk {
        const val minSdk = 29
        const val compileSdk = 34
        const val targetSdk = 34
    }

    object Libraries {

        object Versions {
            object Androidx {
                const val APP_COMPAT = "1.6.1"
                const val CORE_KTX = "1.12.0"
                const val LIFECYCLE = "2.6.2"
                const val EXT_JUNIT = "1.1.5"
                const val ESPRESSO = "3.5.1"
                const val ROOM = "2.6.0"
                const val HILT = "1.0.0"
                const val WORK = "2.8.1"
                const val NAVIGATION = "2.7.4"

                object Compose {
                    const val BOM = "2023.10.00"
                    const val UI = "1.5.4"
                    const val MATERIAL3 = "1.1.2"
                }
            }

            const val HILT_ANDROID = "2.48"
            const val JUNIT = "4.13.2"
        }

        fun DependencyHandler.addAppCompat() {
            implementation("androidx.core:core-ktx:${Versions.Androidx.CORE_KTX}")
            implementation("androidx.appcompat:appcompat:${Versions.Androidx.APP_COMPAT}")
        }

        fun DependencyHandler.addCompose() {
            implementation(platform("androidx.compose:compose-bom:${Versions.Androidx.Compose.BOM}"))
            // Lifecycle
            implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Androidx.LIFECYCLE}")
            implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.LIFECYCLE}")
            implementation("androidx.lifecycle:lifecycle-runtime-compose:${Versions.Androidx.LIFECYCLE}")
            // Material Design 3
            implementation("androidx.compose.material3:material3:${Versions.Androidx.Compose.MATERIAL3}")
            // Android Studio Preview support
            implementation("androidx.compose.ui:ui-tooling-preview:${Versions.Androidx.Compose.UI}")
            debugImplementation("androidx.compose.ui:ui-tooling:${Versions.Androidx.Compose.UI}")
            // Navigation
            implementation("androidx.navigation:navigation-compose:${Versions.Androidx.NAVIGATION}")
            implementation("androidx.hilt:hilt-navigation-compose:${Versions.Androidx.HILT}")

            //implementation("androidx.activity:activity-compose:1.8.0")
        }

        fun DependencyHandler.addHilt() {
            implementation("com.google.dagger:hilt-android:${Versions.HILT_ANDROID}")
            kapt("com.google.dagger:hilt-android-compiler:${Versions.HILT_ANDROID}")
            implementation("androidx.hilt:hilt-work:${Versions.Androidx.HILT}")
            kapt("androidx.hilt:hilt-compiler:${Versions.Androidx.HILT}")
            //implementation("androidx.hilt:hilt-navigation-compose:${Versions.Androidx.HILT}")
            implementation("androidx.work:work-runtime-ktx:${Versions.Androidx.WORK}")
        }

        fun DependencyHandler.addRoom() {
            implementation("androidx.room:room-runtime:${Versions.Androidx.ROOM}")
            kapt("androidx.room:room-compiler:${Versions.Androidx.ROOM}")
            implementation("androidx.room:room-ktx:${Versions.Androidx.ROOM}")
        }

        fun DependencyHandler.addCoreTesting() {
            testImplementation("junit:junit:${Versions.JUNIT}")
            androidTestImplementation("androidx.test.ext:junit:${Versions.Androidx.EXT_JUNIT}")
            androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.Androidx.ESPRESSO}")
        }

        fun DependencyHandler.addComposeTesting() {
            androidTestImplementation(platform("androidx.compose:compose-bom:${Versions.Androidx.Compose.BOM}"))
            androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.Androidx.Compose.UI}")
            debugImplementation("androidx.compose.ui:ui-test-manifest:${Versions.Androidx.Compose.UI}")
        }

        private fun DependencyHandler.implementation(dependency: String) {
            add("implementation", dependency)
        }

        private fun DependencyHandler.debugImplementation(dependency: String) {
            add("debugImplementation", dependency)
        }

        private fun DependencyHandler.implementation(dependency: Dependency) {
            add("implementation", dependency)
        }

        private fun DependencyHandler.testImplementation(dependency: String) {
            add("testImplementation", dependency)
        }

        private fun DependencyHandler.androidTestImplementation(dependency: String) {
            add("androidTestImplementation", dependency)
        }

        private fun DependencyHandler.androidTestImplementation(dependency: Dependency) {
            add("androidTestImplementation", dependency)
        }

        private fun DependencyHandler.kapt(dependency: String) {
            add("kapt", dependency)
        }
    }
}
