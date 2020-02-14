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
