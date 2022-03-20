/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

public class DesktopSkin implements ParamDisplay {

    public final String name;
    public final String info;
    public final String description;
    public final int priority;

    public DesktopSkin(String name, String info, String description, int priority) {
        this.name = name;
        this.info = info;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String parameter() {
        return name;
    }

    @Override
    public String display() {
        return info;
    }

    @Override
    public String definition() {
        return description;
    }

}
