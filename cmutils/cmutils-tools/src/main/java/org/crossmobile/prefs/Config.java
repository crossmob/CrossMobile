/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.prefs;

import static org.crossmobile.bridge.system.RuntimeCommons.MATERIALS_TAG;

public class Config {

    /**
     * NOTE: Should finish with path, to denote the contents of this location. Use
     * instead of File.separator, since this could be a (multi-platform)
     * property.
     */
    public final static String MATERIALS_PATH = "src/main/" + MATERIALS_TAG + "/";
    public final static String ICON_DIR = "src/main/icons/";
    public final static String FORE_ICONS = ICON_DIR + "foreground/";
    public final static String BACK_ICONS = ICON_DIR + "background/";
    public final static String MASK_ICONS = ICON_DIR + "mask/";
    public final static String REVERSE_INF = "META-INF/REVERSE.INF";

    public final static String MIN_JAVA_VERSION = "1.8";
    public final static String MIN_JAVA_VERSION_FULL = "1.8.0_111";
    public final static String MAX_JAVA_VERSION = "15";
    public final static String JAVA_RANGE = "(" + MIN_JAVA_VERSION + " up to " + MAX_JAVA_VERSION + ")";

    public final static String CMPLUGIN_MAVEN_PLUGIN_SIGNATURE = "cmplugin-maven-plugin";

}
