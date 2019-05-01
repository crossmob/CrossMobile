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
package org.crossmobile.build.tools;

import org.crossmobile.utils.Log;

import java.io.File;
import java.util.*;

import static org.crossmobile.prefs.Config.EXCEPTIONS;
import static org.crossmobile.utils.FileUtils.*;

public class SyncObjCFiles {

    private static final List<String> WHITELIST = Collections.singletonList("Dummy.swift");


    public static void exec(File classesDir, File cacheSource, File xcodeSource) {
        sync(cacheSource, xcodeSource, false);

        Collection<String> existing = new LinkedHashSet<>();
        forAll(classesDir, f -> f.getName().toLowerCase().endsWith(".class"), (String p, File f) -> {
            String cname = p + '_' + f.getName().substring(0, f.getName().length() - 6);
            cname = cname.replace('/', '_').replace('\\', '_').replace('.', '_').replace('$', '_');
            existing.add(cname);
        });

        existing.addAll(Arrays.asList(EXCEPTIONS));

        StringBuilder willRemove = new StringBuilder();
        forEach(xcodeSource, null, (p, f) -> {
            if (!existing.contains(getBasename(f.getName())) && !WHITELIST.contains(f.getName())) {
                Log.warning("Removing missing file " + f.getName());
                f.delete();
                willRemove.append(' ').append(f.getName());
            }
        });
        if (willRemove.length() > 0)
            Log.warning("Removed missing files:" + willRemove.toString());
    }
}
