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
package org.crossmobile.utils;

public class XcodeTarget {

    public static final XcodeTarget Main = new XcodeTarget("", false);

    public final String name;
    private String meta;
    private String principalClass;

    public XcodeTarget(String name) {
        this(name, true);
    }

    private XcodeTarget(String name, boolean checkForErrors) {
        if (checkForErrors) {
            if (name == null)
                name = "";
            if (name.trim().isEmpty())
                throw new RuntimeException("Target name could not be empty");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return name.equals(((XcodeTarget) o).name);
    }

    public String getMeta() {
        return meta;
    }

    public String getPrincipalClass() {
        return principalClass;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public boolean isMain() {
        return name.isEmpty();
    }

    public boolean setPrincipalClass(String file) {
        if (principalClass == null) {
            this.principalClass = file;
            return true;
        } else
            return false;
    }
}
