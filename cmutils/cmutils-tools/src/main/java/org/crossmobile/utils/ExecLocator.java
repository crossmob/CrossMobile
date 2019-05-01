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
