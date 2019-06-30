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

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

public class ExecLocator {
    private static final Collection<String> paths = new LinkedHashSet<>(Arrays.asList("/bin", "/usr/bin", "/usr/local/bin", "/opt/bin", "/optX11/bin"));

    static {
        String path = System.getenv("PATH");
        if (path != null)
            paths.addAll(Arrays.asList(path.split(File.pathSeparator)));
    }

    public static File findPath(String exec) {
        for (String path : paths) {
            File test = new File(path, exec);
            if (test.isFile())
                return test;
        }
        return null;
    }
}
