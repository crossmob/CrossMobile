/* (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.plugin.actions;

import org.crossmobile.build.utils.DependencyJarResolver;
import org.crossmobile.plugin.reg.PackageRegistry;
import org.crossmobile.plugin.reg.PluginRegistry;
import org.crossmobile.plugin.reg.TypeRegistry;
import org.crossmobile.plugin.utils.ClassCollection;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

import static org.crossmobile.plugin.utils.ClassCollection.resolveClasses;
import static org.crossmobile.utils.CollectionUtils.asList;
import static org.crossmobile.utils.ReflectionUtils.setClassLoader;

/**
 * @author teras
 */
public class ProjectRegistry {

    private static Collection<File> libjars;
    private static Collection<File> embedjars;
    private static Collection<File> appjars;
    private static Collection<File> allbljars;

    public static void register(DependencyItem root, String[] embedlibs, ClassCollection cc) {
        if (libjars != null)
            return;

        libjars = new TreeSet<>();
        embedjars = new TreeSet<>();
        appjars = new TreeSet<>();
        allbljars = new TreeSet<>();

        DependencyJarResolver.gatherProgramAndEmbeddedLibs(root, true, embedlibs, libjars, embedjars, allbljars);
        appjars.add(root.getFile());
        appjars.addAll(embedjars);
        allbljars.addAll(libjars);

        cc.resolve(asList(getAppjars(), File::getAbsolutePath));
        setClassLoader(cc.getClass().getClassLoader());
        for (Class cls : cc.getAllClasses())
            PluginRegistry.register(cls);
        for (Class cls : cc.getAllNativeClasses())
            TypeRegistry.register(cls);

        // Resolve all classes: required for type checking in plugins. Otherwise plugins will not be able to find base types
        Collection<Package> packages = new HashSet<>();
        Collection<Class<?>> classes = new HashSet<>();
        resolveClasses(asList(libjars, File::getAbsolutePath), packages::add, classes::add, true);
        packages.forEach(PackageRegistry::registerDependencies);
        classes.forEach(PluginRegistry::registerDependencies);
        classes.forEach(TypeRegistry::registerDependencies);
    }

    public static Collection<File> getAppjars() {
        return appjars;
    }

    public static Collection<File> getEmbedjars() {
        return embedjars;
    }

    public static Collection<File> getLibjars() {
        return libjars;
    }

    public static Collection<File> getLibAndBlacklistedJars() {
        return allbljars;
    }
}
