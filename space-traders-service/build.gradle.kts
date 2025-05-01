
plugins {
    id("com.deatr.xylli.spring-conventions")

	id("org.graalvm.buildtools.native") version "0.10.6"
	id("org.openapi.generator") version "7.13.0"
}


group = "com.deatr.xylli"
version = "0.0.2-SNAPSHOT"

sourceSets {
	main {
		java {
			srcDirs(layout.buildDirectory.dir("generated/src/main/java"))
		}
	}
}

dependencies {
	implementation(project(":space-traders-client"))
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("org.springframework.session:spring-session-core")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.session:spring-session-jdbc")
	implementation("org.liquibase:liquibase-core")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:postgresql")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testRuntimeOnly("com.h2database:h2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.compileJava {
	dependsOn(tasks.named("openApiGenerate"))
}

openApiGenerate {
	generatorName.set("java")
	remoteInputSpec.set("https://spacetraders.io/SpaceTraders.json")
	outputDir.set(layout.buildDirectory.dir("generated").get().asFile.absolutePath)
	apiPackage.set("com.deatr.speatr.api")
	invokerPackage.set("com.deatr.speatr.invoker")
	modelPackage.set("com.deatr.speatr.model")
	configOptions.put("useJakartaEe", "true")
	configOptions.put("openApiNullable", "false")
	configOptions.put("useBeanValidation", "true")
	library.set("webclient")
}