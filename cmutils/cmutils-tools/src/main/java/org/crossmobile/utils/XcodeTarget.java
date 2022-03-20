/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
