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
package org.crossmobile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Version {

    public static final String VERSION;
    public static final int RELEASE;

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
