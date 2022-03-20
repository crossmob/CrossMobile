/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
