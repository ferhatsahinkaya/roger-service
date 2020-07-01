plugins {
    application
    id("org.springframework.boot") version "2.3.1.RELEASE"
}

application {
    mainClassName = "com.roger.service.Launcher"
}

dependencies {
    implementation("com.expediagroup:graphql-kotlin-spring-server:3.3.0")
}

tasks {
    bootJar {
        mainClassName = "com.roger.service.Launcher"
    }
}