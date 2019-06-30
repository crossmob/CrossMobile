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
package org.crossmobile.gui.codehound.bin;

public enum PermissionsFinderLevel {

    CLEAN("Clean and prepare project"),
    COMPILE("Compiling project"),
    PARSE("Gathering dependencies"),
    CLEAN2("Clean project"),
    FINISH("Dependency permissions gathered and will be added to the currently selected permissions");

    private final String descr;

    private PermissionsFinderLevel(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return descr;
    }

}
