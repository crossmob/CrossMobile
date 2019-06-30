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

import org.crossmobile.bridge.system.ClassWalker;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClasspathUtils {

    private static final String CLASS_SIG = ".class";
    private static final int CLASS_SIG_SIZE = CLASS_SIG.length();

    public static Set<String> getClasspathClasses(String classpath) {
        Set<String> names = new TreeSet<>();
        if (classpath == null)
            classpath = ClassWalker.getClassPath();

        StringTokenizer tok = new StringTokenizer(classpath, File.pathSeparator);
        while (tok.hasMoreElements()) {
            String pathname = tok.nextToken();
            File cp = new File(pathname);
            if (cp.isFile()) {
                ZipFile jar;
                try {
                    jar = new ZipFile(cp);
                } catch (IOException ex) {
                    continue;
                }
                Enumeration<? extends ZipEntry> entries = jar.entries();
                while (entries.hasMoreElements()) {
                    String entryname = entries.nextElement().getName().toLowerCase();
                    String entrynameTest = entryname.toLowerCase();
                    if (entrynameTest.endsWith(CLASS_SIG))
                        names.add(entryname.substring(0, entryname.length() - CLASS_SIG_SIZE));
                }
            } else if (cp.isDirectory()) {
                File[] list = cp.listFiles();
                if (list != null && list.length > 0)
                    for (File ccp : list)
                        walkDir("", ccp, names);
            }
        }
        return names;
    }

    private static void walkDir(String pckg, File entry, Set<String> names) {
        String cname = entry.getName();
        if (entry.isFile()) {
            if (cname.endsWith(CLASS_SIG))
                names.add(pckg + "/" + cname.substring(0, cname.length() - CLASS_SIG_SIZE));
        } else if (entry.isDirectory()) {
            File[] entries = entry.listFiles();
            pckg = (pckg.isEmpty() ? "" : pckg + "/") + entry.getName();
            if (entries != null && entries.length > 0)
                for (File subentry : entries)
                    walkDir(pckg, subentry, names);
        }
    }
}
