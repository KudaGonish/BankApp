apply{
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(":core-ui"))
    "implementation"(project(":shareMisc"))

    "implementation"(Compose.extensionLifecycleFunc)


    "implementation"(project(":mappedListView:domain"))
    "implementation"(project(mapOf("path" to ":mappedListView:navigationApi")))

    "implementation"(project(mapOf("path" to ":navigationApi")))

}
