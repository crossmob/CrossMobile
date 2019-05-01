/*
 * ExtPath.java
 *
 * Created on June 18, 2007, 4:30 PM
 *
 * This file is part of Jubler.
 *
 * Jubler is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 *
 * Jubler is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jubler; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
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
