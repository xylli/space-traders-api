package com.deatr.xylli;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.plugins.PluginContainer;
import org.springframework.boot.gradle.plugin.SpringBootPlugin;


public class SpringConventionPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        PluginContainer plugins = project.getPlugins();
        plugins.apply(SpringBootPlugin.class);
        plugins.apply(JavaConventionPlugin.class);

        ConfigurationContainer configurations = project.getConfigurations();
        Object compileOnlyExits = configurations.findByName("compileOnly");
        if (compileOnlyExits == null) {
            configurations.create("compileOnly", convention -> convention.extendsFrom(configurations.getByName("annotationProcessor")));
        }

        DependencyHandler dependencies = project.getDependencies();
        dependencies.add("implementation", "org.springframework.boot:spring-boot-starter-validation");
        dependencies.add("implementation", "org.springframework.boot:spring-boot-starter-web");
        dependencies.add("implementation", "org.springframework.boot:spring-boot-starter-webflux");
        dependencies.add("compileOnly", "org.projectlombok:lombok");
        dependencies.add("annotationProcessor", "org.springframework.boot:spring-boot-configuration-processor");
        dependencies.add("annotationProcessor", "org.projectlombok:lombok");
        dependencies.add("testImplementation", "org.springframework.boot:spring-boot-starter-test");
        dependencies.add("testImplementation", "io.projectreactor:reactor-test");
    }
}
