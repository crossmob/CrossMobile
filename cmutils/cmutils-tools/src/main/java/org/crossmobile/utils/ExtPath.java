/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

public class ExtPath {

    private final String path;
    private final int recursive;
    private final boolean retrieveCanonical;
    public static final int FILE_ONLY = 0;
    public static final int BUNDLE_ONLY = 50;

    /*
     * Creates a new instance of ExtPath
     */
    public ExtPath(String path, int rec) {
        this(path, rec, true);
    }

    public ExtPath(String path, int rec, boolean retrieveCanonical) {
        this.path = path;
        recursive = rec;
        this.retrieveCanonical = retrieveCanonical;
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

    public boolean getRetrieveCanonical() {
        return retrieveCanonical;
    }
}
