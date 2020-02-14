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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.crossmobile.prefs.Config.EXCEPTIONS;
import static org.crossmobile.utils.FileUtils.delete;
import static org.crossmobile.utils.TextUtils.plural;

public class JavaCleanFiles {

    private final File java;
    private final File objc;

    public JavaCleanFiles(File java, File objc) {
        this.java = java;
        this.objc = objc;
    }

    public void execute() {
        Set<String> javaFiles = new HashSet<>();
        for (File child : java.listFiles())
            findJavaFiles(child, "", javaFiles);
        javaFiles.addAll(Arrays.asList(EXCEPTIONS));
        int deleted = matchObjcFiles(javaFiles, objc);
        if (deleted > 0)
            Log.info("Cleaned " + deleted + " file" + plural(deleted));
    }

    private void findJavaFiles(File source, String prefix, Set<String> list) {
        if (source.isFile()) {
            String name = source.getName();
            if (name.toLowerCase().endsWith(".class")) {
                name = name.substring(0, name.length() - 6);
                if (!name.isEmpty())
                    list.add(getName(prefix, name));
            }
        } else if (source.isDirectory()) {
            prefix = getName(prefix, source.getName());
            File[] files = source.listFiles();
            if (files != null)
                for (File child : files)
                    findJavaFiles(child, prefix, list);
        }
    }

    private static String getName(String prefix, String name) {
        name = name.replace('$', '_');
        return prefix.isEmpty() ? name : prefix + "_" + name;
    }

    private int matchObjcFiles(Set<String> javaFiles, File objc) {
        int deleted = 0;
        File[] objcfiles = objc.listFiles();
        if (objcfiles != null)
            for (File file : objcfiles) {
                String name = file.getName();
                String lname = name.toLowerCase();
                if (lname.endsWith(".h") || lname.endsWith(".m")) {
                    String strippedName = name.substring(0, name.length() - 2);
                    if (!javaFiles.contains(strippedName)) {
                        delete(file);
                        deleted++;
                    }
                }
            }
        return deleted;
    }

}
