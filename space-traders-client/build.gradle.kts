
plugins {
    id("com.deatr.xylli.spring-conventions")
}


tasks.getByName("bootJar") {
    enabled = false
}


tasks.getByName("jar") {
    enabled = true
}
