plugins {
    `java-library`
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(16))

tasks.compileJava {
    options.release.set(8)
}

// if you force it, it does compile just fine
// configurations["compileClasspath"].attributes.attribute(
//    TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 16
// )

dependencies {
    implementation(project(":java16-lib"))
}
