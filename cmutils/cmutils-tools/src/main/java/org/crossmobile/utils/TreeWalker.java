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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TreeWalker {

    public static void searchExecutable(Collection<TreeWalkerEntry> entries, Collection<String> specific_locations, boolean auto, AtomicBoolean active) {
        try {
            List<ExtPath> paths = new ArrayList<>();
            if (specific_locations != null && !specific_locations.isEmpty())
                for (String location : specific_locations)
                    paths.add(new ExtPath(location, ExtPath.BUNDLE_ONLY));
            else
                for (TreeWalkerEntry entry : entries)
                    if (entry.origLocations != null && !entry.origLocations.isEmpty())
                        for (String oloc : entry.origLocations)
                            if (oloc != null)
                                paths.add(new ExtPath(oloc, ExtPath.BUNDLE_ONLY));
            if (auto) {
                for (TreeWalkerEntry entry : entries) {
                    if (!active.get())
                        return;
                    SystemDependent.appendSpotlightApplication(entry.twg.application.iterator().next(), paths);
                }
                SystemDependent.appendPathApplication(paths);
            }

            for (ExtPath path : paths) {
                if (!active.get())
                    return;
                Log.debug("Wizard is looking inside " + path.getPath());
                File f = new File(path.getPath());
                if (path.searchForFile() && (!f.isFile()))
                    continue;   // If we want a file and this is not, ignore this entry
                walkPath(f, entries, path.getRecursive(), active);
            }
        } catch (Exception ex) {
            Log.debug("Error while searching executables: " + ex.toString());
        }
    }

    /* filename is already in lower case */
    @SuppressWarnings("UseSpecificCatch")
    private static void walkPath(File root, Collection<TreeWalkerEntry> entries, int recursive, AtomicBoolean active) {
        try {
            if (!root.exists()) {
            } else if (root.isFile()) {
                if (active.get() && root.canRead())
                    for (TreeWalkerEntry entry : entries)
                        for (String progname : entry.twg.application)
                            if (entry.foundFile != null
                                    && root.getName().toLowerCase().equals(progname)
                                    && execIsValid(root, entry.twg.otherfiles))
                                entry.foundFile.accept(getFilteredFile(root, entry.twg.foldersToGoUp));
                /* No valid executable found */
            } else if (root.isDirectory())
                if (active.get() && recursive >= ExtPath.FILE_ONLY) {// More recursive could be done
                    recursive--;
                    File[] children = root.listFiles();
                    if (children != null)
                        for (File child : children)
                            walkPath(child, entries, recursive, active);
                }
        } catch (Exception ex) {
            Log.debug("Error while searching executables: " + ex.toString());
        }
    }

    /* when no parameters are set, while checking executable,
     * no real execution of the application is required */
    private static boolean execIsValid(File exec, Collection<String> otherfiles) {
        if (!exec.isFile())
            return false;
        if (otherfiles == null || otherfiles.isEmpty())
            return true;
        for (String other : otherfiles)
            if (new File(exec.getParent() + File.separator + other).exists())
                return true;
        return false;
    }

    private static File getFilteredFile(File root, int foldersToGoUp) throws IOException {
        root = root.getCanonicalFile();
        for (int i = 0; i < foldersToGoUp; i++)
            root = root.getParentFile();
        return root;
    }
}
