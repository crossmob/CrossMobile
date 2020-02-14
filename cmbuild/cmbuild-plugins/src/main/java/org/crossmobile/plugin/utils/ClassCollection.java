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
package org.crossmobile.plugin.utils;

import javassist.ClassPool;
import javassist.NotFoundException;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.crossmobile.bridge.system.ClassWalker;
import org.crossmobile.plugin.reg.PackageRegistry;
import org.crossmobile.plugin.reg.TargetRegistry;
import org.crossmobile.utils.Log;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.util.*;
import java.util.function.Consumer;

import static java.io.File.pathSeparator;
import static org.crossmobile.utils.ReflectionUtils.getClassLoader;
import static org.crossmobile.utils.TextUtils.iterableToString;
import static org.crossmobile.utils.TextUtils.plural;

public class ClassCollection {
    private final Collection<String> paths = new HashSet<>();
    private final Collection<Class<?>> allClasses = new HashSet<>();
    private final Collection<Class<?>> iosnativeClasses = new HashSet<>();
    private final Collection<Class<?>> uwpnativeClasses = new HashSet<>();
    private final Collection<Class<?>> allnativeClasses = new HashSet<>();
    private final Collection<Class<?>> compileClasses = new HashSet<>();
    private final Collection<Class<?>> builddepClasses = new HashSet<>();
    private final ClassPool cp = ClassPool.getDefault();

    public static void gatherClasses(Collection<String> paths, Consumer<Package> packages, Consumer<Class<?>> classes, boolean silently) {
        ClassWalker.getClasspathEntries(iterableToString(paths, pathSeparator), item -> {
            if (!item.contains("/$")) {
                item = item.replace('/', '.');
                Class cls;
                try {
                    if ((cls = Class.forName(item, false, getClassLoader())) != null) {
                        if (packages != null)
                            packages.accept(cls.getPackage());
                        if (Modifier.isPublic(cls.getModifiers()) || item.endsWith("package-info") && classes != null)
                            classes.accept(cls);
                    }
                } catch (Throwable ex) {
                    if (!silently)
                        Log.warning("While instantiating class " + item + ": " + ex.toString());
                }
            }
        }, "class");
    }

    private static void addClassPaths(ClassPool cp, Collection<String> paths, Iterable<String> appPaths) {
        for (String path : appPaths)
            if (paths == null || paths.add(path))
                try {
                    cp.appendClassPath(path);
                    getClassLoader().addURL(new File(path).toURI().toURL());
                } catch (NotFoundException | MalformedURLException ex) {
                    Log.error("Unable to append class path " + path + " to ClassPool", ex);
                }
    }

    public static void addClassPaths(ClassPool cp, Iterable<String> appPaths) {
        addClassPaths(cp, null, appPaths);
    }

    public void addClassPaths(Iterable<String> appPaths) {
        addClassPaths(cp, paths, appPaths);
    }

    public void register(boolean silently) {
        Collection<Package> packages = new LinkedHashSet<>();
        Collection<Class<?>> classes = new LinkedHashSet<>();
        gatherClasses(paths, packages::add, classes::add, silently);
        register(packages, classes);
        Log.debug("Registered " + packages.size() + " package" + plural(packages.size()) + " and " + classes.size() + " application class" + plural(classes.size()));

    }

    public void register(Iterable<Package> packages, Iterable<Class<?>> classes) {
        if (packages != null)
            for (Package p : packages)
                PackageRegistry.register(p);
        if (classes != null)
            for (Class<?> cls : classes) {
                allClasses.add(cls);
                CMLibTarget target = TargetRegistry.register(cls);
                if (target.compile)
                    compileClasses.add(cls);
                if (target.builddep)
                    builddepClasses.add(cls);
                if (target.iosnative)
                    iosnativeClasses.add(cls);
                if (target.uwpnative)
                    uwpnativeClasses.add(cls);
                if (target.iosjava || target.uwpnative)
                    allnativeClasses.add(cls);
            }
    }

    public Iterable<Class<?>> getAllClasses() {
        return allClasses;
    }

    public Iterable<Class<?>> getIOsNativeClasses() {
        return iosnativeClasses;
    }

    public Iterable<Class<?>> getUWPNativeClasses() {
        return uwpnativeClasses;
    }

    public Iterable<Class<?>> getAllNativeClasses() {
        return allnativeClasses;
    }

    public Iterable<Class<?>> getCompileTimeClasses() {
        return compileClasses;
    }

    public Iterable<Class<?>> getBuildDependencyClasses() {
        return builddepClasses;
    }

    @Override
    public String toString() {
        return paths.toString();
    }

    public ClassPool getClassPool() {
        return cp;
    }
}
