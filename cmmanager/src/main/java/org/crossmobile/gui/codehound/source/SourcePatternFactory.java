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
package org.crossmobile.gui.codehound.source;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SourcePatternFactory {

    private final static SourcePattern MAIN_PATTERN = new SourcePattern("Main", false, "publicstaticvoidmain", "staticpublicvoidmain");

    public static Set<SourcePattern> getMainClassPattern() {
        return new HashSet<>(Arrays.asList(MAIN_PATTERN.duplicate()));
    }

}
