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
package org.crossmobile.build.tools;

import org.crossmobile.utils.Commander;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdbLauncher {

    private static final boolean isWindows = System.getProperty("os.name", "").toLowerCase().contains("windows");
    private final File adb;

    public AdbLauncher(String sdk) {
        this.adb = sdk == null ? null : new File(sdk + File.separator + "platform-tools", isWindows ? "adb.exe" : "adb");
    }

    public Commander exec(String... args) {
        if (adb != null && !adb.isFile())
            return null;
        List<String> commands = new ArrayList<>();
        commands.add(adb.getAbsolutePath());
        if (args != null && args.length > 0)
            commands.addAll(Arrays.asList(args));
        Commander cmd = new Commander(commands).exec();
        return cmd;
    }
}
