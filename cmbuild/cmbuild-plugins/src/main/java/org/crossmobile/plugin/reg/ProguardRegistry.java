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
package org.crossmobile.plugin.reg;

import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ProguardRegistry {

    private static final Map<String, String> classes = new HashMap<>();

    public static void register(File mapfile) {
        AtomicInteger entries = new AtomicInteger();
        if (mapfile != null && mapfile.isFile())
            try {
                FileUtils.read(new FileInputStream(mapfile), mapfile.getAbsolutePath(), line -> {
                    if (!line.isEmpty() && line.charAt(0) != ' ') {
                        int dash = line.indexOf("-");
                        if (dash > 0 && dash < (line.length() + 2)) {
                            String orig = line.substring(0, dash - 1);
                            String enc = line.substring(dash + 3, line.length() - 1);
                            classes.put(enc, orig);
                            entries.incrementAndGet();
                        }
                    }
                });
                Log.debug("Found " + entries.get() + " proguard entries");
            } catch (Exception ex) {
                Log.error(ex);
            }
        else
            Log.error("Unable to locate proguard file " + mapfile);
    }

    public static String getOriginalName(String cname) {
        String name = classes.get(cname);
        return name == null ? cname : name;
    }
}
