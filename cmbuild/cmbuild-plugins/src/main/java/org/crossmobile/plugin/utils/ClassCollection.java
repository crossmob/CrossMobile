/* Copyright (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static java.io.File.pathSeparator;
import static org.crossmobile.utils.TextUtils.iterableToString;

public class ClassCollection {

    private final Collection<String> paths = new HashSet<>();
    private Collection<Class> allClasses = new HashSet<>();
    private final Collection<Class> iosnativeClasses = new HashSet<>();
    private final Collection<Class> uwpnativeClasses = new HashSet<>();
    private final Collection<Class> allnativeClasses = new HashSet<>();
    private final Collection<Class> compileClasses = new HashSet<>();
    private final Collection<Class> builddepClasses = new HashSet<>();
    private final ClassPool cp = ClassPool.getDefault();

    public static void resolveClasses(Collection<String> paths, Consumer<Package> packages, Consumer<Class> classes, boolean silently) {
        ClassWalker.getClasspathEntries(iterableToString(paths, pathSeparator), item -> {
            if (!item.contains("/$")) {
                item = item.replace('/', '.');
                Class cls;
                try {
                    if ((cls = Class.forName(item, false, ClassCollection.class.getClassLoader())) != null) {
                        packages.accept(cls.getPackage());
                        if (Modifier.isPublic(cls.getModifiers()) || item.endsWith("package-info"))
                            classes.accept(cls);
                    }
                } catch (Throwable ex) {
                    if (!silently)
                        Log.warning("While instantiating class " + item + ": " + ex.toString());
                }
            }
        }, "class");
    }

    public void resolve(Iterable<String> appPaths) {
        StringBuilder appsLog = new StringBuilder();
        for (String path : appPaths)
            if (this.paths.add(path)) {
                try {
                    cp.appendClassPath(path);
                } catch (NotFoundException ex) {
                    Log.error("Unable to append class path " + path + " to ClassPool", ex);
                }
                appsLog.append(path).append(' ');
            }
        Collection<Package> packages = new LinkedHashSet<>();
        int oldClassesSize = allClasses.size();
        resolveClasses(paths, packages::add, allClasses::add, false);
        Log.debug("Registered " + packages.size() + " package(s) and " + (allClasses.size() - oldClassesSize) + " application class(es)");
        for (Package p : packages)
            PackageRegistry.register(p);
        for (Class cls : allClasses) {
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

    public Iterable<Class> getAllClasses() {
        return allClasses;
    }

    public Iterable<Class> getIOsNativeClasses() {
        return iosnativeClasses;
    }

    public Iterable<Class> getUWPNativeClasses() {
        return uwpnativeClasses;
    }

    public Iterable<Class> getAllNativeClasses() {
        return allnativeClasses;
    }

    public Iterable<Class> getCompileTimeClasses() {
        return compileClasses;
    }

    public Iterable<Class> getBuildDependencyClasses() {
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
