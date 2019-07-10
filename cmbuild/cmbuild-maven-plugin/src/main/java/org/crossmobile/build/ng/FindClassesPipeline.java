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
package org.crossmobile.build.ng;

import javassist.CtClass;
import javassist.NotFoundException;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.utils.ClasspathUtils;
import org.crossmobile.utils.NativeCodeCollection;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

import static org.crossmobile.build.ng.CMBuildEnvironment.environment;
import static org.crossmobile.build.utils.Config.CLASSES;
import static org.crossmobile.utils.ClasspathUtils.CLASS_USAGE_SIGNATURE;

public class FindClassesPipeline implements Runnable {

    @Override
    public void run() {
        File classesDir = new File(environment().getBuilddir(), CLASSES);
        for (String className : findAllImports(Collections.singleton(classesDir)))
            System.out.println(CLASS_USAGE_SIGNATURE + className);
    }

    public static Collection<String> findAllImports(Collection<File> classpath) {
        Collection<String> classes = new TreeSet<>();
        NativeCodeCollection dbn = new NativeCodeCollection(classpath);
        for (String classname : ClasspathUtils.getClasspathClasses(classpath, true)) {
            try {
                CtClass cls = dbn.getClassPool().get(classname);
                classes.addAll(cls.getRefClasses());
            } catch (NotFoundException e) {
                BaseUtils.throwException(e);
            }
        }
        return classes;
    }
}
