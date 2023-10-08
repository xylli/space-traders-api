plugins {
    id("java")
    id("checkstyle")
    id("com.github.spotbugs")
    id("io.spring.dependency-management")
}

repositories {
    mavenCentral()
}

java {
    //sourceCompatibility = JavaVersion.VERSION_20
    //targetCompatibility = JavaVersion.VERSION_20
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.spotbugsMain {
    reports.create("html") {
        required.set(true)
        outputLocation.set(file("${layout.buildDirectory}/reports/spotbugs.html"))
        setStylesheet("fancy-hist.xsl")
    }
}