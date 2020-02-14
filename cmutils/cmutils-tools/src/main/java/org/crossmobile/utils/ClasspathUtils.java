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
package org.crossmobile.utils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClasspathUtils {

    private static final String CLASS_SIG = ".class";
    private static final int CLASS_SIG_SIZE = CLASS_SIG.length();

    public static final String CLASS_USAGE_SIGNATURE = "Project uses class: ";

    public static Set<String> getClasspathClasses(Collection<File> classpath, boolean canonicalNames) {
        Set<String> names = new TreeSet<>();
        for (File cp : classpath) {
            if (cp.isFile()) {
                ZipFile jar;
                try {
                    jar = new ZipFile(cp);
                } catch (IOException ex) {
                    continue;
                }
                Enumeration<? extends ZipEntry> entries = jar.entries();
                while (entries.hasMoreElements()) {
                    String entryName = entries.nextElement().getName();
                    if (entryName.toLowerCase().endsWith(CLASS_SIG))
                        names.add(convert(entryName, canonicalNames));
                }
            } else if (cp.isDirectory()) {
                File[] list = cp.listFiles();
                if (list != null && list.length > 0)
                    for (File ccp : list)
                        walkDir("", ccp, names, canonicalNames);
            }
        }
        return names;
    }

    private static void walkDir(String pckg, File entry, Set<String> names, boolean canonicalNames) {
        String cname = entry.getName();
        if (entry.isFile()) {
            if (cname.toLowerCase().endsWith(CLASS_SIG))
                names.add(convert(pckg + "/" + cname, canonicalNames));
        } else if (entry.isDirectory()) {
            File[] entries = entry.listFiles();
            pckg = (pckg.isEmpty() ? "" : pckg + "/") + entry.getName();
            if (entries != null && entries.length > 0)
                for (File subentry : entries)
                    walkDir(pckg, subentry, names, canonicalNames);
        }
    }

    private static String convert(String entryName, boolean canonicalNames) {
        String entryNameClear = entryName.substring(0, entryName.length() - CLASS_SIG_SIZE);
        return canonicalNames
                ? entryNameClear.replace('/', '.').replace('\\', '.')
                : entryNameClear;
    }
}
