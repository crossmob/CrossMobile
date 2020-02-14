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
package org.crossmobile.bridge.system;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClassWalker {

    private static String classpath;

    public static void getClasspathEntries(String classpath, Consumer<String> classConsumer, String... fileExtensions) {
        if (classConsumer == null)
            return;
        if (classpath == null)
            classpath = getClassPath();
        Collection<String> extensions = new HashSet<>();
        if (fileExtensions != null)
            for (String ext : fileExtensions) {
                if (ext == null)
                    continue;
                ext = ext.trim();
                if (ext.isEmpty())
                    continue;
                extensions.add((ext.startsWith(".") ? "" : ".") + ext.toLowerCase());
            }
        StringTokenizer tok = new StringTokenizer(classpath, File.pathSeparator);
        while (tok.hasMoreElements()) {
            File cp = new File(tok.nextToken());
            if (cp.isDirectory())
                checkClasses("", cp, classConsumer, extensions);
            else
                try {
                    ZipFile jar = new ZipFile(cp);
                    Enumeration<? extends ZipEntry> entries = jar.entries();
                    while (entries.hasMoreElements()) {
                        String entryName = findName(entries.nextElement().getName(), extensions);
                        if (entryName != null)
                            classConsumer.accept(entryName);
                    }
                } catch (IOException ignore) {
                }
        }
    }

    public static String getClassPath() {
        if (classpath == null) {
            ClassLoader classLoader = ClassWalker.class.getClassLoader();
            if (classLoader instanceof URLClassLoader) {
                StringBuilder out = new StringBuilder();
                URLClassLoader cl = (URLClassLoader) classLoader;
                for (URL url : cl.getURLs()) {
                    try {
                        File file = new File(url.toURI().getSchemeSpecificPart());
                        if (file.exists())
                            out.append(File.pathSeparator).append(file.getAbsolutePath());
                    } catch (URISyntaxException ignore) {
                    }
                }
                classpath = out.length() == 0 ? "" : out.substring(1);
            } else
                classpath = System.getProperty("java.class.path");
        }
        return classpath;
    }

    private static String findName(String entryName, Collection<String> extensions) {
        if (extensions.isEmpty())
            return entryName;
        int lastDot = entryName.lastIndexOf('.');
        return lastDot < 0 || !extensions.contains(entryName.substring(lastDot).toLowerCase())
                ? null : entryName.substring(0, lastDot);
    }

    // Recursively check classes
    private static void checkClasses(String packagePrefix, File currentPath, Consumer<String> classConsumer, Collection<String> extensions) {
        File[] children = currentPath.listFiles();
        if (children == null || children.length == 0)
            return;
        for (File child : children) {
            String entryName = packagePrefix.isEmpty() ? child.getName() : packagePrefix + "/" + child.getName();
            if (child.isDirectory())
                checkClasses(entryName, child, classConsumer, extensions);
            else if (child.isFile() && (entryName = findName(entryName, extensions)) != null)
                classConsumer.accept(entryName);
        }
    }
}
