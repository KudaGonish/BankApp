apply{
    from("$rootDir/navigation-api.gradle")
}
dependencies{
    "implementation"(project(":navigationApi"))
}