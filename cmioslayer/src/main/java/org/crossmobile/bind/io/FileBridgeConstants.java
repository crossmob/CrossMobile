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
package org.crossmobile.bind.io;

import java.io.File;

public final class FileBridgeConstants {

    public static final String[] DEFAULTPATHS = {
            null,
            File.separator + "Applications",
            File.separator + "Applications" + File.separator + "Demos",
            File.separator + "Developer" + File.separator + "Applications",
            File.separator + "Applications" + File.separator + "Utilities",
            File.separator + "Library",
            File.separator + "Developer",
            "",
            File.separator + "Library" + File.separator + "Documentation",
            File.separator + "Documents",
            null,
            File.separator + "Library" + File.separator + "Autosave Information",
            File.separator + "Desktop",
            File.separator + "Library" + File.separator + "Caches",
            File.separator + "Library" + File.separator + "Application Support",
            File.separator + "Downloads",
            File.separator + "Library" + File.separator + "Input Methods",
            File.separator + "Movies",
            File.separator + "Music",
            File.separator + "Pictures",
            null,
            File.separator + "Public",
            File.separator + "Library" + File.separator + "PreferencePanes"};

    private FileBridgeConstants() {
    }

}
