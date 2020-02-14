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
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.settings.Settings;
import org.crossmobile.build.ng.CMBuildEnvironment;
import org.crossmobile.build.utils.DependencyDigger;
import org.crossmobile.build.utils.MojoLogger;
import org.crossmobile.build.utils.Versions.RetroLambda;
import org.crossmobile.build.utils.Versions.XMLVM;
import org.crossmobile.utils.Dependency;
import org.crossmobile.utils.DependencyParam;
import org.crossmobile.utils.ParamSet;
import org.crossmobile.utils.launcher.Flavour;
import org.crossmobile.utils.lic.LicencedItems;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;
import java.util.*;

import static org.crossmobile.build.utils.Config.GENERATED_CMSOURCES;
import static org.crossmobile.utils.ParamsCommon.*;

public abstract class CrossMobileMojo extends GenericMojo {

    @Parameter(defaultValue = "${settings}", readonly = true)
    private Settings settings;

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void exec() throws MojoExecutionException {
        if (getProject().getArtifactId().equals("cmproject") || getProject().getArtifactId().equals("cmproject-debug"))
            return;
        MojoLogger.register(getLog());
        DependencyItem dependencies = DependencyDigger.getDependencyTree(getProject(), getSession(), getDependencyGraph(), this::resolveArtifact, false);
        File basedir = getProject().getBasedir();

        //Add generated sources directory for compile
        getProject().addCompileSourceRoot(new File(getBuildDir(), GENERATED_CMSOURCES).getAbsolutePath());
        Flavour flavour = Flavour.getFlavour(settings.getActiveProfiles());
        String appId = getProject().getGroupId() + "." + getProject().getArtifactId();
        LicencedItems.checkLicense(dependencies, appId, flavour);

        ParamSet set = getParamSet(dependencies);   // also removed invalid artifacts - needs dependencies to be populated
        Properties props = loadProperties(set);
        CMBuildEnvironment.create(basedir, getBuildDir(),
                flavour,
                props,
                set,
                () -> resolveArtifact(new ArtifactInfo(XMLVM.GROUP, XMLVM.ARTIFACT, XMLVM.VERSION, "jar")),
                () -> resolveArtifact(new ArtifactInfo(RetroLambda.GROUP, RetroLambda.ARTIFACT, RetroLambda.VERSION, "jar")),
                getProject().getGroupId(),
                getProject().getArtifactId(),
                getProject().getVersion(),
                dependencies,
                isRelease(settings.getActiveProfiles()),
                getSession().getUserProperties().getProperty(DEBUG_PROFILE.tag().name));
        if (settings == null)
            throw new MojoExecutionException("Unable to read maven settings");
        initCoreWorker().run();
    }

    protected abstract Runnable initCoreWorker();

    private boolean isRelease(List<String> profiles) {
        for (String prof : profiles)
            if ("release".equals(prof.toLowerCase()))
                return true;
        return false;
    }

    private Properties loadProperties(ParamSet paramset) {
        Properties prop = paramset.getDefaults();
        prop.putAll(getProject().getProperties());
        prop.put(DISPLAY_NAME.tag().name, getProject().getName());
        prop.put(ARTIFACT_ID.tag().name, getProject().getArtifactId());
        prop.put(GROUP_ID.tag().name, getProject().getGroupId());
        prop.put(BUNDLE_VERSION.tag().name, getProject().getVersion());
        return prop;
    }

    /* Implies Dependencies as parameter */
    private ParamSet getParamSet(DependencyItem root) {
        Map<String, Collection<DependencyParam>> possibleparams = new HashMap<>();
        for (Dependency dep : Dependency.getSystemPlugins())
            possibleparams.put(dep.groupId + "." + dep.artifactId, dep.getConfigParams());
        ParamSet p = new ParamSet();
        for (DependencyItem item : root.getCompiletimeDependencies(true))
            for (DependencyParam param : possibleparams.getOrDefault(item.getGroupID() + "." + item.getArtifactID(), (List<DependencyParam>) Collections.EMPTY_LIST))
                p.register(param.param);
        return p;
    }
}
