/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
