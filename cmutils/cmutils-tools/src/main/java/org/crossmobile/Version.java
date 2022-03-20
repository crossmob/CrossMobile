/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Version {

    public static final String VERSION;
    public static final int RELEASE;
    public static final String GROUPID = "org.crossmobile";
    public static final String ARTIFACTID = "cmioslayer";

    static {
        Properties props = new Properties();
        try {
            InputStream resource = Version.class.getClassLoader().getResourceAsStream("org/crossmobile/version.properties");
            if (resource != null)
                props.load(new InputStreamReader(resource, StandardCharsets.UTF_8));
        } catch (IOException ignored) {
        }
        VERSION = props.getProperty("current.version", "-unknown-");
        int rel = 0;
        try {
            rel = Integer.parseInt(props.getProperty("current.release"));
        } catch (NumberFormatException ignored) {
        }
        RELEASE = rel;
    }
}
