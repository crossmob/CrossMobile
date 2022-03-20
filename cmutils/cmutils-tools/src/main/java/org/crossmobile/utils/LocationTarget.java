/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.utils.SystemDependent.Execs;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LocationTarget {

    private final String appName;
    private final Collection<LocationEntry> paths = new ArrayList<>();

    public LocationTarget(String... morePaths) {
        this(null, null, morePaths);
    }

    public LocationTarget(Execs exec, String... morePaths) {
        this(exec, null, morePaths);
    }

    public LocationTarget(Predicate<File> predicate, String... morePaths) {
        this(null, predicate, morePaths);
    }

    private LocationTarget(Execs exec, Predicate<File> predicate, String... morePaths) {
        this.appName = exec == null ? null : exec.name().toLowerCase();
        if (appName != null)
            paths.add(new LocationEntry(appName, false, predicate));
        if (morePaths != null && morePaths.length > 0)
            for (String path : morePaths)
                paths.add(new LocationEntry(path, exec == null, predicate));
    }

    public LocationRequest makeRequest(String oldLocation, Consumer<File> foundFile) {
        return new LocationRequest(this, oldLocation, foundFile);
    }

    public LocationRequest makeRequest(Consumer<File> foundFile) {
        return makeRequest(null, foundFile);
    }

    String getApplicationName() {
        return appName;
    }

    void checkFile(File file, Consumer<File> foundFile) {
        for (LocationEntry entry : paths) {
            File found = entry.matches(file);
            if (found != null)
                foundFile.accept(found);
        }
    }

    private static class LocationEntry {
        private final String[] fileParts;
        private final boolean asContainer;
        private Predicate<File> predicate;

        private LocationEntry(String path, boolean asContainer, Predicate<File> predicate) {
            fileParts = path.split("/");
            this.asContainer = asContainer;
            this.predicate = predicate;
        }

        private File matches(File file) {
            File orig = file;
            for (int i = fileParts.length - 1; i >= 0; i--) {
                if (file == null || !fileParts[i].equals(file.getName().toLowerCase()))
                    return null;
                orig = file;
                file = file.getParentFile();
            }
            File result = asContainer ? file : orig;
            return predicate != null && !predicate.test(result) ? null : result;
        }
    }
}