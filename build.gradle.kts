plugins {
    kotlin("jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.8"
}

val maven_group: String by project
val project_version: String by project

group = maven_group
version = project_version

repositories {
    maven("https://repo.opencollab.dev/maven-snapshots")
    maven("https://repo.opencollab.dev/maven-releases")

    mavenCentral()
}

dependencies {
    val nukkit_version: String by project

    compileOnly("cn.nukkit:nukkit:${nukkit_version}")
}

kotlin {
    jvmToolchain(8)
}

tasks {
    jar { archiveClassifier.set("noshade") }
    shadowJar {
        archiveClassifier.set("")
        archiveBaseName.set(archiveBaseName.get())
        archiveVersion.set(version.toString())
    }
    build { dependsOn(shadowJar) }
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}