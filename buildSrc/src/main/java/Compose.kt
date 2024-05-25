object Compose {

    object Version {

        const val UI = "1.3.3"

        const val Material = "1.3.1"

        const val composeCompilerVersion = "1.4.2"

        const val navigationVersion = "2.6.0-alpha07"

        const val hiltNavigationComposeVersion = "1.0.0-beta01"

        const val activityComposeVersion = "1.6.1"

        const val lifecycleVersion = "2.5.1"

        const val extensionLifecycleFunc = "2.6.0"

        const val coilVersion = "2.2.2"

    }


    const val material = "androidx.compose.material:material:${Version.Material}"

    const val ui = "androidx.compose.ui:ui:${Version.UI}"

    const val uiUtil = "androidx.compose.ui:ui-util:${Version.UI}"

    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.UI}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Version.UI}"

    const val runtime = "androidx.compose.runtime:runtime:${Version.UI}"

    const val compiler = "androidx.compose.compiler:compiler:${Version.composeCompilerVersion}"

    const val navigation = "androidx.navigation:navigation-compose:${Version.navigationVersion}"

    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Version.hiltNavigationComposeVersion}"

    const val activityCompose =
        "androidx.activity:activity-compose:${Version.activityComposeVersion}"

    const val viewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycleVersion}"

    const val extensionLifecycleFunc = "androidx.lifecycle:lifecycle-runtime-compose:${Version.extensionLifecycleFunc}"

    const val coilCompose = "io.coil-kt:coil-compose:${Version.coilVersion}"

}
