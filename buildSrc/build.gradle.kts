plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:6.0.0-beta.4")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.1.4")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.3")
}