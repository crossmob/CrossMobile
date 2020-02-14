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
package org.crossmobile.utils;

public class ExtPath {

    private final String path;
    private final int recursive;
    public static final int FILE_ONLY = 0;
    public static final int BUNDLE_ONLY = 50;

    /*
     * Creates a new instance of ExtPath
     */
    public ExtPath(String path, int rec) {
        this.path = path;
        recursive = rec;
    }

    @Override
    public String toString() {
        return path + ":" + recursive;
    }

    public boolean searchForFile() {
        return (recursive == FILE_ONLY);
    }

    public String getPath() {
        return path;
    }

    public int getRecursive() {
        return recursive;
    }
}
