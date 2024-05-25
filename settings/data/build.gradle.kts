apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(":database"))
    "implementation"(project(":shareMisc"))
    "implementation"(project(":settings:domain"))
}