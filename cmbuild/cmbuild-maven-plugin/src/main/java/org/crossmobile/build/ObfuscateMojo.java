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

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.crossmobile.build.tools.Obfuscator;
import org.crossmobile.build.utils.Versions;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.crossmobile.utils.FileUtils.copyResource;

@Mojo(name = "obfuscate", defaultPhase = LifecyclePhase.PACKAGE, requiresDependencyResolution = ResolutionScope.COMPILE)
public class ObfuscateMojo extends GenericMojo {

    @Parameter(defaultValue = "${version.proguard}", readonly = true)
    private String versionProguard = Versions.ProGuard.VERSION;

    @Parameter(defaultValue = "${project.build.directory}/${project.artifactId}-${project.version}.map", readonly = true)
    private File proguardMap;

    @Parameter(defaultValue = "${project.build.directory}/${project.artifactId}-${project.version}-desktop.jar", readonly = true)
    private File inputJar;

    @Parameter(defaultValue = "${project.build.directory}/${project.artifactId}-${project.version}-trimmed.jar", readonly = true)
    private File outputJar;

    @Parameter(defaultValue = "${project.basedir}/proguard-rules.pro", readonly = true)
    private File proguardConfig;

    @Parameter(defaultValue = "false", readonly = true)
    private boolean obfuscate;

    @Parameter(defaultValue = "false", readonly = true)
    private boolean copyProguardFilesOnly;

    @Override
    public void exec() throws MojoExecutionException {
        if (!obfuscate)
            return;
        File crossMobConf = createOrError("crossmobile.pro");
        if (!proguardConfig.exists() && proguardConfig.equals(new File(getProject().getBasedir(), "proguard-rules.pro")))
            createOrError(proguardConfig.getName());

        if (!copyProguardFilesOnly)
            Obfuscator.obfuscate(
                    resolveArtifact(new ArtifactInfo(Versions.ProGuard.GROUP, Versions.ProGuard.ARTIFACT, versionProguard, "jar"))
                    , proguardMap, inputJar, outputJar, asList(crossMobConf, proguardConfig));
    }

    private File createOrError(String template) throws MojoExecutionException {
        File config = new File(getProject().getBasedir(), template);
        if (!copyResource("template/" + config.getName(), config))
            throw new MojoExecutionException("Unable to extract proguard configuration file " + template + " at " + config.getAbsolutePath());
        else {
            Log.info("Creating file " + config.getAbsolutePath());
            return config;
        }
    }
}
