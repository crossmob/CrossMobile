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

import org.crossmobile.utils.Log;

import java.io.File;
import java.util.*;

import static org.crossmobile.prefs.Config.EXCEPTIONS;
import static org.crossmobile.utils.FileUtils.*;
import static org.crossmobile.utils.FileUtils.Predicates.extensions;
import static org.crossmobile.utils.FileUtils.Predicates.noHidden;

public class SyncObjCFiles {

    private static final List<String> WHITELIST = Collections.singletonList("Dummy.swift");


    public static void exec(File classesDir, File cacheSource, File xcodeSource) {
        sync(cacheSource, xcodeSource, false);

        Collection<String> existing = new LinkedHashSet<>();
        forAllRecursively(classesDir, extensions(".class"), (path, file) -> {
            String cname = path + '_' + file.getName().substring(0, file.getName().length() - 6);
            cname = cname.replace('/', '_').replace('\\', '_').replace('.', '_').replace('$', '_');
            existing.add(cname);
        });

        existing.addAll(Arrays.asList(EXCEPTIONS));

        StringBuilder willRemove = new StringBuilder();
        forAllRecursively(xcodeSource, noHidden(), (path, f) -> {
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
