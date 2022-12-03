import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    java
    kotlin("jvm") version "+"
}

version = "1.0.0"
description = "Advent of Code 2022"




repositories {
    mavenCentral()
}
dependencies {

}

java {
    // Configure the java toolchain. This allows gradle to auto-provision JDK 17 on systems that only have JDK 8 installed for example.
    toolchain.languageVersion.set(JavaLanguageVersion.of(19))
}

tasks {
compileJava {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
    options.release.set(18)
}
javadoc {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
}
processResources {
    filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
}
withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf(
            "-Xuse-k2",
            "-Xjdk-release=19"
        )
        jvmTarget = "19"
        languageVersion = "1.8"
    }
}
test {
    useJUnitPlatform()
}
}