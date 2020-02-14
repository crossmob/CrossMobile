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

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.PluginMetaData;
import org.crossmobile.utils.PluginPod;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.*;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static java.io.File.separator;
import static org.crossmobile.build.utils.Config.*;
import static org.crossmobile.build.utils.Locations.NATIVE_PATH;
import static org.crossmobile.utils.FileUtils.isNewer;

public class ObjCLibrary {

    private final Collection<String> incl = new TreeSet<>();
    private final Collection<String> libs = new TreeSet<>();
    private final Collection<PluginPod> pods = new TreeSet<>();


    private ObjCLibrary() {
    }

    private void addLibraries(Collection<String> libraries) {
        libs.addAll(libraries);
    }


    private void addPods(Collection<PluginPod> pods) {
        this.pods.addAll(pods);
    }

    private void addInclude(String include) {
        this.incl.add(include);
    }

    public Collection<String> getLibraries() {
        return libs;
    }

    public Collection<String> getIncludes() {
        return incl;
    }

    public Collection<PluginPod> getPods() {
        return pods;
    }

    private static final String NATIVE_PATH_SLASH = NATIVE_PATH + "/";

    public static ObjCLibrary extract(DependencyItem root, File libdest, File incdest, String basedir) {
        libdest.mkdirs();
        incdest.mkdirs();
        Collection<File> duplicates = new HashSet<>();
        ObjCLibrary library = new ObjCLibrary();
        library.addInclude(basedir + XCODE_BASE + separator + XCODE_EXT_INC + separator + "**");

        for (PluginMetaData in : root.getPluginMetaData()) {
            library.addLibraries(in.getObjCLibs());
            library.addPods(in.getPods());
        }
        for (DependencyItem dep : root.getRuntimeOnlyDependencies(true))
            extractFiles(dep.getFile(), library.libs, libdest, incdest, basedir, duplicates);

        StringBuilder libprop = new StringBuilder();
        for (String lib : library.libs)
            libprop.append(":").append(lib);
        String result = libprop.toString();
        if (!result.isEmpty())
            result = result.substring(1);
        return library;
    }

    private static void extractFiles(File libfile, Collection<String> libs, File libdest, File incdest, String basedir, Collection<File> duplicates) {
        JarFile file;
        try {
            file = new JarFile(libfile);
        } catch (IOException ex) {
            Log.error(ex);
            return;
        }
        String pluginname = file.getName();
        Enumeration<JarEntry> entries = file.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String path = entry.getName();
            if (!entry.isDirectory() && path.startsWith(NATIVE_PATH_SLASH)) {
                String name = path.substring(path.lastIndexOf('/') + 1);
                String lname = name.toLowerCase();
                if (lname.endsWith(".h") || lname.endsWith(".a") || lname.endsWith(".lib") || lname.endsWith(".dll"))
                    try {
                        InputStream in = file.getInputStream(entry);
                        boolean isLib = lname.endsWith(".a") || lname.endsWith(".lib") || lname.endsWith(".dll");
                        File outfile = new File(isLib ? libdest : incdest, (isLib ? "" : pluginname.split("-")[1] + File.separator) + name);
                        if (isNewer(libfile, outfile)) {
                            if (duplicates.contains(outfile))
                                Log.warning("Overwriting duplicate file " + outfile.getPath() + " in plugin " + file.getName());
                            duplicates.add(outfile);
                            outfile.getParentFile().mkdirs();
                            OutputStream out = new FileOutputStream(outfile);
                            if (!FileUtils.copyStream(in, out))
                                throw new RuntimeException("Unable to copy " + entry.getName());
                        }
                        if (isLib)
                            libs.add(basedir + separator + XCODE_BASE + separator + XCODE_EXT_LIB + File.separator + name);
                    } catch (IOException ex) {
                        BaseUtils.throwException(ex);
                    }
                else
                    Log.warning("Unknown file type in plugin " + pluginname + ": " + name);
            }
        }
    }
}
