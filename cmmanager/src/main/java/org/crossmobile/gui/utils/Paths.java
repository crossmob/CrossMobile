/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.gui.utils;

import org.crossmobile.Version;
import org.crossmobile.utils.SystemDependent;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.crossmobile.utils.SystemDependent.Execs.MVN;
import static org.crossmobile.utils.SystemDependent.getHome;

public final class Paths {

    private static final String DEV_LIB_INSTALL2 = "../../resources/lib";   // location of libraries when debugging
    private static final String MVNPATH = "apache-maven" + File.separator + "bin";

    private static File APPFILE;
    private static final String MYLIBS;

    static {
        try {
            APPFILE = new File(Paths.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException ignore) {
            APPFILE = new File(Paths.class.getProtectionDomain().getCodeSource().getLocation().getFile());
        }
        if (APPFILE.isDirectory()) {
            MYLIBS = new File(APPFILE.getParent(), DEV_LIB_INSTALL2).getAbsolutePath();
        } else
            MYLIBS = getPath(APPFILE.getParentFile().getAbsoluteFile(), HomeReference.NO_OVERRIDE);
    }

    public static String getApplicationPath() {
        return APPFILE.getPath();
    }

    public static String getPath(File path, HomeReference overrideHome) {
        try {
            return getPath(path.getCanonicalPath(), overrideHome);
        } catch (IOException ex) {
            return getPath(path.getAbsolutePath(), overrideHome);
        }
    }

    public static String getPath(String path, HomeReference overrideHome) {
        path = path.replace('\\', '/');
        if (overrideHome != null && overrideHome != HomeReference.NO_OVERRIDE)
            if (overrideHome == HomeReference.PROP_TO_ABS) {
                if (path.startsWith("${user.home}"))
                    path = getHome() + path.substring("${user.home}".length());
            } else if (path.startsWith(getHome() + "/"))
                path = (overrideHome == HomeReference.PROPERTY_STYLE ? "${user.home}" : "~")
                        + ((getHome().length() + 1) < path.length() ? ("/" + path.substring(getHome().length() + 1)) : "");
        return path;
    }

    public static File getAbsolutePath(String path, String currentDir) {
        return getAbsolutePath(new File(path), currentDir == null ? null : new File(currentDir));
    }

    public static File getAbsolutePath(File path, File currentDir) {
        if (!path.isAbsolute()) {
            if (currentDir == null)
                currentDir = new File(System.getProperty("user.dir"));
            path = new File(currentDir, path.getPath());
        }
        try {
            return path.getCanonicalFile();
        } catch (IOException ex) {
            return path;
        }
    }

    public static String getPathSimple(File path) {
        if (path == null)
            return null;
        return path.getPath().replace('\\', '/');
    }

    public static String getMavenLocation() {
        return MYLIBS + File.separator + MVNPATH + File.separator + MVN.filename();
    }

    public static String getXRayPath() {
        File cmxray = new File(SystemDependent.getPluginsDir(), "cmxray.jar");
        return cmxray.exists() ? cmxray.getAbsolutePath() : null;
    }

    private Paths() {
    }

    public enum HomeReference {

        NO_OVERRIDE,
        PROPERTY_STYLE,
        PATH_STYLE,
        PROP_TO_ABS
    }
}
