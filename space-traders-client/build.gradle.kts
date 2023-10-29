
plugins {
    id("xylli.spring-conventions")
}


dependencies {
}

tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}
