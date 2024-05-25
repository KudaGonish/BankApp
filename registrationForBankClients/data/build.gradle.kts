apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(":registrationForBankClients:domain"))
    "implementation"(project(":database"))
    "implementation"(project(":shareMisc"))
}