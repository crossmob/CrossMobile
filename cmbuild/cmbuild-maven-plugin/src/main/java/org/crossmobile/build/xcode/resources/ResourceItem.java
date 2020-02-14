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
package org.crossmobile.build.xcode.resources;

import org.crossmobile.build.utils.SynchronizeHelpers;
import org.crossmobile.utils.FileUtils;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class ResourceItem {

    private final String name;
    private final String[] elements;

    private final Set<File> files = new TreeSet<>();

    public ResourceItem(String name, String... elements) {
        this.name = name;
        this.elements = elements;
        SynchronizeHelpers.checkVariable("elements", elements);
        SynchronizeHelpers.checkVariable("name", name);
    }

    public void update(File base) {
        for (String path : elements) {
            path = path == null ? "" : path.trim();
            if (path.isEmpty())
                continue;

            // With relative paths, find actual target path
            File fpath = new File(path);
            if (!fpath.isAbsolute())
                fpath = new File(base, path);
            if (!fpath.exists())
                continue;

            FileUtils.fixLastModified(fpath);
            if (FileUtils.endsWithPathSeparator(path)) {   // File.separator - get children of this file
                File[] contents = fpath.listFiles();
                if (contents != null)
                    for (File item : contents)
                        if (!item.getName().equals(".DS_Store"))
                            files.add(item);
            } else
                files.add(fpath);
        }
    }

    public Set<File> getResources() {
        return files;
    }

}
