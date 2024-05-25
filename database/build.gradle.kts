apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "kapt"(Room.compiler)
    "implementation"(Room.ktx)
    "implementation"(Room.runtime)
}