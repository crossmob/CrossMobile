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
package org.crossmobile.build.utils;

import org.crossmobile.utils.CollectionUtils;
import org.crossmobile.utils.FilteredConsumer;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;

import static org.crossmobile.utils.CollectionUtils.asList;

public class DependencyJarResolver {

    public static final FilteredConsumer<String> ERROR = new FilteredConsumer<>(Log::error, t -> !t.contains("Class JavaLaunchHelper is implemented"));

    public static Collection<File> gatherLibs(DependencyItem root, boolean asRuntime) {
        Collection<File> jars = new TreeSet<>();
        gatherProgramAndEmbeddedLibs(root, asRuntime, null, jars, null, null);
        return jars;
    }

    public static void gatherProgramAndEmbeddedLibs(DependencyItem root, boolean asRuntime, String[] embedlibs, Collection<File> libraryjars, Collection<File> embeddedjars, Collection<File> bljars) {
        Collection<Pattern> patterns = new ArrayList<>();
        if (embedlibs != null && embedlibs.length > 0)
            for (String embedlib : embedlibs)
                if (embedlib != null && !embedlib.trim().isEmpty())
                    try {
                        patterns.add(Pattern.compile(embedlib));
                    } catch (Exception ex) {
                    }
        Collection<DependencyItem> embeditems = CollectionUtils.asCollection(TreeSet.class, asRuntime ? root.getRuntimeDependencies(true) : root.getCompiletimeDependencies(true));
        Collection<DependencyItem> libitems = new TreeSet<>();
        addLibs(root, asRuntime, patterns, libitems);
        embeditems.removeAll(libitems);
        if (libraryjars != null) {
            libraryjars.addAll(asList(libitems, DependencyItem::getFile));
            Log.debug("JARs registered as library: " + libraryjars);
        }
        if (embeddedjars != null) {
            embeddedjars.addAll(asList(embeditems, DependencyItem::getFile));
            Log.debug("JARs registered as embedded: " + embeddedjars);
        }
        if (bljars != null) {
            List<File> blacklisted = asList(root.getBlacklisted(), DependencyItem::getFile);
            bljars.addAll(blacklisted);
            Log.debug("JARs registered as blacklisted: " + blacklisted);
        }
    }

    private static void addLibs(DependencyItem parent, boolean asRuntime, Collection<Pattern> patterns, Collection<DependencyItem> libraryjars) {
        for (DependencyItem item : asRuntime ? parent.getRuntimeDependencies(false) : parent.getCompiletimeDependencies(false)) {
            boolean found = false;
            for (Pattern pattern : patterns)
                if (pattern.matcher(item.toString()).matches()) {
                    found = true;
                    break;
                }
            if (!found) {
                libraryjars.add(item);
                addLibs(item, asRuntime, patterns, libraryjars);
            }
        }
    }
}
