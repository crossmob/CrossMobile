/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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

import static org.crossmobile.bridge.system.BaseUtils.listFiles;

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
            } else if (cp.isDirectory())
                for (File ccp : listFiles(cp))
                    walkDir("", ccp, names, canonicalNames);
        }
        return names;
    }

    private static void walkDir(String pckg, File entry, Set<String> names, boolean canonicalNames) {
        String cname = entry.getName();
        if (entry.isFile()) {
            if (cname.toLowerCase().endsWith(CLASS_SIG))
                names.add(convert(pckg + "/" + cname, canonicalNames));
        } else if (entry.isDirectory()) {
            pckg = (pckg.isEmpty() ? "" : pckg + "/") + entry.getName();
            for (File subEntry : listFiles(entry))
                walkDir(pckg, subEntry, names, canonicalNames);
        }
    }

    private static String convert(String entryName, boolean canonicalNames) {
        String entryNameClear = entryName.substring(0, entryName.length() - CLASS_SIG_SIZE);
        return canonicalNames
                ? entryNameClear.replace('/', '.').replace('\\', '.')
                : entryNameClear;
    }
}
