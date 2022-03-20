/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
