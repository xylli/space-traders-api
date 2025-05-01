package com.deatr.xylli;

import com.github.spotbugs.snom.SpotBugsPlugin;
import com.github.spotbugs.snom.SpotBugsTask;
import io.spring.gradle.dependencymanagement.DependencyManagementPlugin;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.dsl.RepositoryHandler;
import org.gradle.api.file.RegularFile;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.plugins.PluginContainer;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.testing.Test;
import org.gradle.jvm.toolchain.JavaLanguageVersion;


public class JavaConventionPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        PluginContainer plugins = project.getPlugins();
        plugins.apply(JavaPlugin.class);
        plugins.apply(SpotBugsPlugin.class);
        //plugins.apply(CheckstylePlugin.class);
        plugins.apply(DependencyManagementPlugin.class);

        RepositoryHandler repositories = project.getRepositories();
        repositories.add(repositories.mavenCentral());

        var javaPlugin = plugins.findPlugin("java");
        if (javaPlugin instanceof JavaPluginExtension java) {
            java.getToolchain().getLanguageVersion().set(JavaLanguageVersion.of(21));
        }

        project.getTasks().withType(SpotBugsTask.class).named("spotbugsMain").configure(it -> {
            it.setIgnoreFailures(true);
            it.reports(reports -> {
               reports.create("html").configure(htmlReport -> {
                    htmlReport.getRequired().set(true);
                    Property<RegularFile> location = (Property<RegularFile>) htmlReport.getOutputLocation();
                    location.set(project.getLayout().getBuildDirectory().file("reports/spotbugs.html"));
               });
            });
        });

        project.getTasks().withType(Test.class).all(Test::useJUnitPlatform);
    }
}
