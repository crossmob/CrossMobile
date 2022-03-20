/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.crossmobile.bridge.system.BaseUtils.listFiles;

public class TreeWalker {

    private static final Collection<File> BLACKLIST = SystemDependent.getBlacklistedLocations();

    public static void searchExecutable(Collection<LocationRequest> requests, Collection<String> specific_locations, boolean auto, Active active) {
        try {
            List<ExtPath> paths = new ArrayList<>();
            if (specific_locations != null && !specific_locations.isEmpty())
                for (String location : specific_locations)
                    paths.add(new ExtPath(location, ExtPath.BUNDLE_ONLY));
            else
                for (LocationRequest request : requests)
                    if (request.getCurrentLocation() != null)
                        paths.add(new ExtPath(request.getCurrentLocation(), ExtPath.BUNDLE_ONLY));
            if (auto) {
                for (LocationRequest request : requests) {
                    if (!active.isActive())
                        return;
                    if (request.getApplicationName() != null)
                        SystemDependent.appendSpotlightApplication(request.getApplicationName(), paths);
                }
                SystemDependent.appendPathApplication(paths);
            }

            for (ExtPath path : paths) {
                if (!active.isActive())
                    return;
                Log.debug("Wizard is looking inside " + path.getPath());
                File f = new File(path.getPath());
                if (path.searchForFile() && (!f.isFile()))
                    continue;   // If we want a file and this is not, ignore this entry
                walkPath(f, requests, path.getRecursive(), path.getRetrieveCanonical(), active);
            }
        } catch (Exception ex) {
            Log.debug("Error while searching executables: " + ex.toString());
        }
    }

    /* filename is already in lower case */
    @SuppressWarnings("UseSpecificCatch")
    private static void walkPath(File root, Collection<LocationRequest> requests, int recursive, boolean retrieveCanonical, Active active) {
        if (!root.exists() || !root.canRead() || !active.isActive())
            return;
        try {
            if (root.isFile())
                for (LocationRequest request : requests)
                    request.checkFile(root);
            else if (root.isDirectory())
                if (active.isActive() && recursive >= ExtPath.FILE_ONLY) {// More recursive could be done
                    recursive--;
                    for (File child : listFiles(root)) {
                        if (retrieveCanonical)
                            child = child.getCanonicalFile();
                        if (BLACKLIST == null || !BLACKLIST.contains(child))
                            walkPath(child, requests, recursive, retrieveCanonical, active);
                    }
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

    public interface Active {
        boolean isActive();
    }
}
