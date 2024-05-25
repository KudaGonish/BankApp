object Build {

    object Version {

        const val androidBuildToolsVersion = "7.4.1"

        const val kotlinVersion = "1.8.10"
    }


    const val androidBuildTools =
        "com.android.tools.build:gradle:${Version.androidBuildToolsVersion}"

    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"

    const val hiltAndroidGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${DaggerHilt.Version.version}"
}