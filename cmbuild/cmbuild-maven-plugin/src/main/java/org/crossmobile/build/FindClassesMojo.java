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
package org.crossmobile.build;

import javassist.CtClass;
import javassist.NotFoundException;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.utils.ClasspathUtils;
import org.crossmobile.utils.ReverseCodeCollection;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

import static org.crossmobile.build.utils.Config.CLASSES;
import static org.crossmobile.utils.ClasspathUtils.CLASS_USAGE_SIGNATURE;

@Mojo(name = "findclasses", defaultPhase = LifecyclePhase.COMPILE, requiresDependencyResolution = ResolutionScope.COMPILE)
public class FindClassesMojo extends GenericMojo {

    @Override
    public void exec() throws MojoExecutionException, MojoFailureException {
        File classesDir = new File(getBuildDir(), CLASSES);
        for (String className : findAllImports(Collections.singleton(classesDir)))
            System.out.println(CLASS_USAGE_SIGNATURE + className);
    }

    public static Collection<String> findAllImports(Collection<File> classpath) {
        Collection<String> classes = new TreeSet<>();
        ReverseCodeCollection dbn = new ReverseCodeCollection(classpath);
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
