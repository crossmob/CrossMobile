/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.dependency.graph.DependencyGraphBuilder;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.resolution.ArtifactRequest;
import org.eclipse.aether.resolution.ArtifactResult;

import java.io.File;
import java.io.FileNotFoundException;

import static org.twdata.maven.mojoexecutor.MojoExecutor.*;

public abstract class GenericMojo extends AbstractMojo {

    @Component(hint = "default")
    protected DependencyGraphBuilder dependencyGraphBuilder;

    @Parameter(defaultValue = "${project}", readonly = true, property = "")
    protected MavenProject mavenProject;

    @Parameter(defaultValue = "${session}", readonly = true)
    protected MavenSession mavenSession;

    @Component
    protected BuildPluginManager pluginManager;

    @Component
    protected RepositorySystem repoSystem;

    @Parameter(defaultValue = "false", readonly = true)
    protected boolean skip;

    @Parameter(defaultValue = "${plugin}", readonly = true)
    protected PluginDescriptor pluginDescriptor;

    @Override
    public final void execute() throws MojoExecutionException, MojoFailureException {
        if (skip)
            return;
        exec();
    }

    public abstract void exec() throws MojoExecutionException, MojoFailureException;

    public File resolveArtifact(ArtifactInfo info) {
        ArtifactRequest request = new ArtifactRequest();
        request.setArtifact(new DefaultArtifact(info.groupId, info.artifactId, info.packaging, info.version));
        request.setRepositories(mavenProject.getRemoteProjectRepositories());
        try {
            ArtifactResult result = repoSystem.resolveArtifact(mavenSession.getRepositorySession(), request);
            return result.getArtifact().getFile();
        } catch (Exception ex) {
            throwException(ex);
            return null;
        }
    }

    public boolean installArtifact(ArtifactInfo info) {
        try {
            executeMojo(
                    plugin(
                            groupId("org.apache.maven.plugins"),
                            artifactId("maven-install-plugin"),
                            version("2.5.2")
                    ),
                    goal("install-file"),
                    configuration(
                            element(name("file"), info.source == null ? "" : info.source.getAbsolutePath()),
                            element(name("groupId"), info.groupId == null ? "" : info.groupId),
                            element(name("artifactId"), info.artifactId == null ? "" : info.artifactId),
                            element(name("version"), info.version == null ? "" : info.version),
                            element(name("packaging"), info.source == null ? "" : info.packaging),
                            element(name("pomFile"), info.pomFile == null ? "" : info.pomFile.getAbsolutePath())
                    ),
                    executionEnvironment(
                            mavenProject,
                            mavenSession,
                            pluginManager
                    )
            );
            return true;
        } catch (MojoExecutionException ex) {
            throwException(ex);
            return false;
        }
    }

    public boolean deployArtifact(ArtifactInfo info, String repositoryId, String url) {
        if (repositoryId == null || repositoryId.trim().isEmpty())
            throw new NullPointerException("repositoryId could not be null");
        if (url == null || url.trim().isEmpty())
            throw new NullPointerException("url could not be null");
        if (info == null || info.source == null)
            throwException(new FileNotFoundException("Source file should be present"));
        if (!info.source.isFile())
            throwException(new FileNotFoundException("File not found: " + info.source.getAbsolutePath()));

        try {
            executeMojo(
                    plugin(
                            groupId("org.apache.maven.plugins"),
                            artifactId("maven-deploy-plugin"),
                            version("2.8.2")
                    ),
                    goal("deploy-file"),
                    configuration(
                            element(name("file"), info.source == null ? "" : info.source.getAbsolutePath()),
                            element(name("groupId"), info.groupId == null ? "" : info.groupId),
                            element(name("artifactId"), info.artifactId == null ? "" : info.artifactId),
                            element(name("version"), info.version == null ? "" : info.version),
                            element(name("packaging"), info.source == null ? "" : info.packaging),
                            element(name("pomFile"), info.pomFile == null ? "" : info.pomFile.getAbsolutePath()),
                            element(name("repositoryId"), repositoryId),
                            element((name("url")), url)
                    ),
                    executionEnvironment(
                            mavenProject,
                            mavenSession,
                            pluginManager
                    )
            );
            return true;
        } catch (MojoExecutionException ex) {
            throwException(ex);
            return false;
        }
    }

    public MavenProject getProject() {
        return mavenProject;
    }

    public File getBuildDir() {
        return new File(getProject().getBuild().getDirectory());
    }

    public DependencyGraphBuilder getDependencyGraph() {
        return dependencyGraphBuilder;
    }

    public MavenSession getSession() {
        return mavenSession;
    }

    public PluginDescriptor getPluginDescriptor() {
        return pluginDescriptor;
    }

    private <R> R throwException(Throwable th) {
        return (R) GenericMojo.<RuntimeException>throwExceptionImpl(th);
    }

    private static <T extends Throwable> Object throwExceptionImpl(Throwable th) throws T {
        throw (T) th;
    }
}
