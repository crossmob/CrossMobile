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
package org.crossmobile.build.tools;

import org.crossmobile.utils.Log;
import org.crossmobile.utils.launcher.Flavour;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static java.io.File.separator;
import static org.crossmobile.bridge.system.LauncherCommons.OUTPUT_FILE;
import static org.crossmobile.bridge.system.LauncherCommons.OUTPUT_PACKAGE;

public class ExtProjectLauncher {

    private static final String OUTPUT_DIR = "classes";

    private static final String FLAVOUR_KEY = "flavour";
    private static final String BRIDGE_KEY = "bridge";
    private static final String TARGET_KEY = "target";
    private static final String RELEASE_KEY = "release";
    private static final String ID_KEY = "appId";
    private static final String BUNDLE_KEY = "bundleId";
    private static final String DEBUG_KEY = "debug.profile";
    private static final String MAIN_CLASS = "mainclass";

    public static void store(File builddir, Flavour flavour, String target, String bridge, String applicationid, String bundleid, String mainclass, boolean release, String debugprofile) {
        Properties props = new Properties();
        props.put(FLAVOUR_KEY, flavour.name());
        props.put(BRIDGE_KEY, bridge == null || bridge.isEmpty() ? flavour.launcher : bridge);
        props.put(TARGET_KEY, target);
        props.put(MAIN_CLASS, mainclass);
        props.put(ID_KEY, applicationid);
        props.put(BUNDLE_KEY, bundleid);
        props.put(RELEASE_KEY, Boolean.toString(release));
        props.put(DEBUG_KEY, debugprofile);
        File output = new File(builddir, OUTPUT_DIR + separator + OUTPUT_PACKAGE + separator + OUTPUT_FILE);
        try {
            output.getParentFile().mkdirs();
            props.store(new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8), "CrossMobile Launcher");
            Log.info("Storing launch properties under " + output.getAbsolutePath());
        } catch (IOException ex) {
            throw new RuntimeException("Unable to store launcher properties under " + output.getAbsolutePath(), ex);
        }
    }
}
