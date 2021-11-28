plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0-beta5"
}

group = "com.severett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "com.severett.kotlincalculator.MainKt"
    }
}

tasks {
    val jvmVersion = "16"
    val kotlinAPIVersion = "1.5"
    withType(org.gradle.api.tasks.compile.JavaCompile::class.java).configureEach {
        version = jvmVersion
    }
    withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).configureEach {
        kotlinOptions {
            jvmTarget = jvmVersion
            apiVersion = kotlinAPIVersion
            languageVersion = kotlinAPIVersion
            freeCompilerArgs = listOf("-Xjvm-default=all")
        }

    }
    test {
        useJUnitPlatform()
    }
}
