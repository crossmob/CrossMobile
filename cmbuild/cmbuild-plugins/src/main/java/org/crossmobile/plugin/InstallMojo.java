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
package org.crossmobile.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.settings.Settings;
import org.crossmobile.build.ArtifactInfo;
import org.crossmobile.build.GenericMojo;
import org.crossmobile.build.utils.DependencyDigger;
import org.crossmobile.build.utils.MojoLogger;
import org.crossmobile.plugin.actions.PluginAssembler;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.SystemDependent;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;

import static org.crossmobile.plugin.DeployMojo.deployableArtifacts;
import static org.crossmobile.utils.FileUtils.toURL;

@Mojo(name = "install", defaultPhase = LifecyclePhase.INSTALL)
public class InstallMojo extends GenericMojo {

    @Parameter(defaultValue = "${settings}", readonly = true)
    private Settings settings;

    @Parameter(readonly = true)
    @SuppressWarnings("FieldMayBeFinal")
    private String[] embedlibs = new String[]{};

    @Parameter(readonly = true)
    private Packages[] packages;

    @Parameter(defaultValue = "false", readonly = true)
    private boolean skipDesktop;

    @Parameter(defaultValue = "false", readonly = true)
    private boolean skipIos;

    @Parameter(defaultValue = "false", readonly = true)
    private boolean skipAndroid;

    @Parameter(defaultValue = "false", readonly = true)
    private boolean skipUwp;

    @Parameter(defaultValue = "false", readonly = true)
    private boolean skipRvm;

    @Parameter(defaultValue = "false", readonly = true)
    private boolean skipCore;

    @Parameter(defaultValue = "gen/report.txt", readonly = true)
    File report;

    @Parameter(defaultValue = "C:\\Program Files (x86)\\Microsoft Visual Studio\\2017\\Community\\VC\\Auxiliary\\Build", readonly = true)
    private File VStudioLocation;

    @Parameter(readonly = true)
    private Repository repository;

    @Override
    public void exec() throws MojoExecutionException {
        MojoLogger.register(getLog());

        skipIos |= !SystemDependent.canMakeIos();
        skipUwp |= !SystemDependent.canMakeUwp();
        if (skipDesktop && skipIos && skipAndroid && skipUwp) {
            Log.info("Skipping all targets");
            return;
        }
        // Append classpaths - maybe should be done otherwise?
        DependencyItem dependencies = DependencyDigger.getDependencyTree(getProject(), getSession(), getDependencyGraph(), this::resolveArtifact, true);
        getPluginDescriptor().getClassRealm().addURL(FileUtils.toURL(new File(getProject().getBuild().getOutputDirectory())));
        for (DependencyItem dep : dependencies.getCompiletimeDependencies(true))
            getPluginDescriptor().getClassRealm().addURL(toURL(dep.getFile()));

        PluginAssembler.assemble(new File(getProject().getBuild().getDirectory()), dependencies,
                embedlibs, new File(new File(getProject().getBuild().getSourceDirectory()).getParent(), "objc"),
                new File(getProject().getBasedir(), "lib/main/vendor"),
                this::installAndKeepJar, this::resolveArtifact, new File(getProject().getBasedir(), "gen"), packages,
                !skipDesktop, !skipIos, !skipAndroid, !skipUwp, !skipRvm, !skipCore,
                VStudioLocation, report, repository
        );
    }

    private boolean installAndKeepJar(ArtifactInfo info) {
        synchronized (deployableArtifacts) {
            deployableArtifacts.add(info);
        }
        return installArtifact(info);
    }
}
