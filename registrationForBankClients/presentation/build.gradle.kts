apply{
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(":registrationForBankClients:domain"))

    "implementation"(project(":core-ui"))
    "implementation"(project(":shareMisc"))

    "implementation"(Compose.extensionLifecycleFunc)

    "implementation"(project(mapOf("path" to ":navigationApi")))
    "implementation"(project(mapOf("path" to ":registrationForBankClients:navigationApi")))

}
