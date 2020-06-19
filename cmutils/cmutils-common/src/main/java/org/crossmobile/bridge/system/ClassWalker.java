/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.system;

import org.crossmobile.backend.desktop.DesktopImageLocations;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.crossmobile.bridge.system.BaseUtils.listFiles;

public class ClassWalker {

    public static Collection<String> getSkinFiles() {
        Collection<String> skins = new ArrayList<>();
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(DesktopImageLocations.SKINS.substring(1) + "catalog");
            while (resources.hasMoreElements()) {
                //noinspection CharsetObjectCanBeUsed
                try (BufferedReader in = new BufferedReader(new InputStreamReader(resources.nextElement().openStream(), "UTF-8"))) {
                    String data;
                    while ((data = in.readLine()) != null)
                        skins.add(data.trim());
                } catch (IOException ignored) {
                }
            }
        } catch (Exception ignored) {
        }
        return skins;
    }

    public static void getClasspathEntries(Consumer<String> classConsumer, String... fileExtensions) {
        getClasspathEntries(System.getProperty("java.class.path"), classConsumer, fileExtensions);
    }

    public static void getClasspathEntries(String classpath, Consumer<String> classConsumer, String... fileExtensions) {
        Objects.requireNonNull(classConsumer);
        Objects.requireNonNull(classpath);
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

    private static String findName(String entryName, Collection<String> extensions) {
        if (extensions.isEmpty())
            return entryName;
        int lastDot = entryName.lastIndexOf('.');
        return lastDot < 0 || !extensions.contains(entryName.substring(lastDot).toLowerCase())
                ? null : entryName.substring(0, lastDot);
    }

    // Recursively check classes
    private static void checkClasses(String packagePrefix, File currentPath, Consumer<String> classConsumer, Collection<String> extensions) {
        for (File child : listFiles(currentPath)) {
            String entryName = packagePrefix.isEmpty() ? child.getName() : packagePrefix + "/" + child.getName();
            if (child.isDirectory())
                checkClasses(entryName, child, classConsumer, extensions);
            else if (child.isFile() && (entryName = findName(entryName, extensions)) != null)
                classConsumer.accept(entryName);
        }
    }
}
