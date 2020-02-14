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
package org.crossmobile.build.ng;

import org.crossmobile.utils.ParamSet;
import org.crossmobile.utils.launcher.Flavour;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;
import java.util.Properties;
import java.util.function.Supplier;

import static org.crossmobile.prefs.Config.MATERIALS_PATH;
import static org.crossmobile.utils.ParamsCommon.DEBUG_PROFILE;

public class CMBuildEnvironment {

    private final File basedir;
    private final File builddir;
    private final File materials;
    private final Flavour flavour;
    private final Properties properties;
    private final ParamSet paramset;
    private final String relativeTobase;
    private final String version;
    private final String appId;
    private final String artifactId;
    private final boolean release;
    private final Supplier<File> xmlvm;
    private final Supplier<File> retrolambda;
    private final DependencyItem root;
    private final String debugprofile;
    private File xmlvm_file;
    private File retrolambda_file;

    private static CMBuildEnvironment current;

    public static CMBuildEnvironment environment() {
        return current;
    }

    public static void create(File basedir, File builddir, Flavour flavour, Properties properties, ParamSet paramset, Supplier<File> xmlvm, Supplier<File> retrolambda, String groupId, String artifactId, String version, DependencyItem root, boolean release, String debugprofile) {
        current = new CMBuildEnvironment(basedir, builddir, flavour, properties, paramset, xmlvm, retrolambda, groupId, artifactId, version, root, release, debugprofile);
    }

    private CMBuildEnvironment(File basedir, File builddir, Flavour flavour, Properties properties, ParamSet paramset, Supplier<File> xmlvm, Supplier<File> retrolambda, String groupId, String artifactId, String version, DependencyItem root, boolean release, String debugprofile) {
        this.basedir = basedir;
        this.builddir = builddir;
        this.materials = new File(basedir, MATERIALS_PATH);
        this.flavour = flavour;
        this.properties = properties;
        this.xmlvm = xmlvm;
        this.retrolambda = retrolambda;
        this.relativeTobase = new File(basedir.getAbsolutePath()).toURI().relativize(new File(builddir.getAbsolutePath()).toURI()).getPath();
        this.artifactId = artifactId;
        this.appId = groupId + '.' + artifactId;
        this.version = version;
        this.paramset = paramset;
        this.root = root;
        this.release = release;
        this.debugprofile = debugprofile == null ? DEBUG_PROFILE.tag().deflt : debugprofile;
    }

    public File getBasedir() {
        return basedir;
    }

    public File getBuilddir() {
        return builddir;
    }

    public File getMaterialsDir() {
        return materials;
    }

    public String getRelativeBuildToBase() {
        return relativeTobase;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public Properties getProperties() {
        return properties;
    }

    public ParamSet getParamset() {
        return paramset;
    }

    public File getXMLVM() {
        if (xmlvm_file == null)
            xmlvm_file = xmlvm.get();
        return xmlvm_file;
    }

    public File getRetroLambda() {
        if (retrolambda_file == null)
            retrolambda_file = retrolambda.get();
        return retrolambda_file;
    }

    public String getVersion() {
        return version;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getAppId() {
        return appId;
    }

    public boolean isRelease() {
        return release;
    }

    public DependencyItem root() {
        return root;
    }

    public String getDebugProfile() {
        return debugprofile;
    }
}
