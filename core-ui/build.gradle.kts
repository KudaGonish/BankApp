apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {

    "implementation"(project(mapOf("path" to ":shareMisc")))
    "implementation" (Compose.uiUtil)

}