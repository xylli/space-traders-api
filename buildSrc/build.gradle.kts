plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

val spotBugsVersion = "6.1.10"
val springBootVersion = "3.4.5"
val springBootDependencyManagementVersion = "1.1.7"

dependencies {
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:$spotBugsVersion")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    implementation("io.spring.gradle:dependency-management-plugin:$springBootDependencyManagementVersion")
}