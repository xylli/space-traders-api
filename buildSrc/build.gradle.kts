
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

val spotBugsVersion = "6.1.10"
val springBootVersion = "3.4.5"
val springBootDependencyManagementVersion = "1.1.7"

dependencies {
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:${spotBugsVersion}")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    implementation("io.spring.gradle:dependency-management-plugin:${springBootDependencyManagementVersion}")


    //kotlin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    // required for K2JVMCompiler::class - will be provided at runtime by Gradle
    compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.9.10")

}