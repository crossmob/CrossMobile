// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.utils;

public class DesktopSkin implements ParamDisplay {

    public final String name;
    public final String info;
    public final String description;

    public DesktopSkin(String name, String info, String description) {
        this.name = name;
        this.info = info;
        this.description = description;
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
