apply{
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(":core-ui"))
    "implementation"(project(":shareMisc"))

    "implementation"(Compose.extensionLifecycleFunc)


    "implementation"(project(":settings:domain"))

    "implementation"(project(mapOf("path" to ":settings:navigationApi")))
    "implementation"(project(mapOf("path" to ":registrationForBankClients:navigationApi")))

    "implementation"(project(mapOf("path" to ":navigationApi")))

}
