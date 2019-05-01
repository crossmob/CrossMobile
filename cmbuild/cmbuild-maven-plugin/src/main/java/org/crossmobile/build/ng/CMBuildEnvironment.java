/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, getVersion 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.build.ng;

import org.crossmobile.utils.ParamSet;
import org.crossmobile.utils.launcher.Flavour;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;
import java.util.Properties;
import java.util.function.Supplier;

public class CMBuildEnvironment {

    private final File basedir;
    private final File builddir;
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
    private File xmlvm_file;
    private File retrolambda_file;

    private static CMBuildEnvironment current;

    public static CMBuildEnvironment environment() {
        return current;
    }

    public static void create(File basedir, File builddir, Flavour flavour, Properties properties, ParamSet paramset, Supplier<File> xmlvm, Supplier<File> retrolambda, String groupId, String artifactId, String version, DependencyItem root, boolean release) {
        current = new CMBuildEnvironment(basedir, builddir, flavour, properties, paramset, xmlvm, retrolambda, groupId, artifactId, version, root, release);
    }

    private CMBuildEnvironment(File basedir, File builddir, Flavour flavour, Properties properties, ParamSet paramset, Supplier<File> xmlvm, Supplier<File> retrolambda, String groupId, String artifactId, String version, DependencyItem root, boolean release) {
        this.basedir = basedir;
        this.builddir = builddir;
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
    }

    public File getBasedir() {
        return basedir;
    }

    public File getBuilddir() {
        return builddir;
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
}
