apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(":shareMisc"))
    "implementation"(project(":mappedListView:domain"))
    "implementation"("com.google.code.gson:gson:2.11.0")
}