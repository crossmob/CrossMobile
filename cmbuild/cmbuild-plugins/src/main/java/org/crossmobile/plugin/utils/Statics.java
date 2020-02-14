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
package org.crossmobile.plugin.utils;

import java.util.Calendar;

public class Statics {

    public static final String COPYRIGHT;
    public static final String POM_GROUPID = "__POM_GROUPID__";
    public static final String POM_ARTIFACTID = "__POM_ARTIFACTID__";
    public static final String POM_VERSION = "__POM_VERSION__";
    public static final String POM_PACKAGING = "__POM_PACKAGING__";
    public static final String POM_DEPENDENCIES = "__POM_DEPENDENCIES__";
    public static final String POM_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n"
            + "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
            + "    <modelVersion>4.0.0</modelVersion>\n"
            + "    <groupId>" + POM_GROUPID + "</groupId>\n"
            + "    <artifactId>" + POM_ARTIFACTID + "</artifactId>\n"
            + "    <version>" + POM_VERSION + "</version>\n"
            + "    <packaging>" + POM_PACKAGING + "</packaging>\n"
            + POM_DEPENDENCIES
            + "</project>\n";

    static {
        COPYRIGHT = "// (c) " + Calendar.getInstance().get(Calendar.YEAR) + " under LGPL by CrossMobile plugin tools\n\n";
    }
}
