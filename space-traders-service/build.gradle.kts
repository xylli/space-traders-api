plugins {
	id("xylli.spring-conventions")

	id("org.graalvm.buildtools.native") version "0.9.27"
}

group = "com.deatr.xylli"
version = "0.0.2-SNAPSHOT"


dependencies {
	implementation(project(":space-traders-client"))
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
