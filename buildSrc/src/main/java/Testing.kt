object Testing {

    object Version {

        const val junitVersion = "4.13.2"

        const val junitAndroidExtVersion = "1.1.5"

        const val coroutinesTestVersion = "1.5.1"

        const val truthVersion = "1.1.3"

        const val mockkVersion = "1.13.3"

        const val espresso_version = "3.4.0"

        const val turbineVersion = "0.7.0"

        const val mockWebServerVersion = "4.9.3"

        const val testRunnerVersion = "1.4.0"

        const val androidNavigationTestVersion = "2.5.3"

    }

    const val junit4 = "junit:junit:${Version.junitVersion}"

    const val junitAndroidExt = "androidx.test.ext:junit:${Version.junitAndroidExtVersion}"

    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutinesTestVersion}"

    const val mockk = "io.mockk:mockk:${Version.mockkVersion}"

    const val mockkAndroid = "io.mockk:mockk-android:${Version.mockkVersion}"

    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Compose.Version.UI}"

    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Compose.Version.UI}"

    const val hiltTesting = "com.google.dagger:hilt-android-testing:${DaggerHilt.Version.version}"
}