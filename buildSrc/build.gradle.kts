
plugins {
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}


gradlePlugin {
    plugins {
        create("javaConventions") {
            id = "com.deatr.xylli.java-conventions"
            implementationClass = "com.deatr.xylli.JavaConventionPlugin"
        }
        create("springCconventions") {
            id = "com.deatr.xylli.spring-conventions"
            implementationClass = "com.deatr.xylli.SpringConventionPlugin"
        }
    }
}

dependencies {
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:6.0.0-rc.2")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.1.5")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.3")

    //kotlin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    // required for K2JVMCompiler::class - will be provided at runtime by Gradle
    compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.9.10")
}