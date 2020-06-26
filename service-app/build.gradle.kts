plugins {
    application
    id("com.github.johnrengelman.shadow") version "4.0.3"
}

application {
    mainClassName = "com.roger.service.Launcher"
}

tasks {
    withType(com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar::class.java) {
        baseName = "service-fat"
    }
}

dependencies {
    implementation("com.expediagroup:graphql-kotlin-spring-server:3.2.0")
}