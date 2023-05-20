plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:5.0.14")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.0.6")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.0")
}