plugins {
    java
    checkstyle
    id("com.github.spotbugs")
    id("io.spring.dependency-management")
}

repositories {
    mavenCentral()
}

java.sourceCompatibility = JavaVersion.VERSION_20
java.targetCompatibility = JavaVersion.VERSION_20

tasks.spotbugsMain {
    reports.create("html") {
        required.set(true)
        outputLocation.set(file("$buildDir/reports/spotbugs.html"))
        setStylesheet("fancy-hist.xsl")
    }
}