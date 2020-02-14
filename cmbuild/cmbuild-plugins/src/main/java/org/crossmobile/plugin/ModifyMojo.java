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
package org.crossmobile.plugin;

import javassist.ClassPool;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.crossmobile.build.GenericMojo;
import org.crossmobile.build.utils.MojoLogger;
import org.crossmobile.plugin.actions.AppearanceInjections;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.utils.ClassCollection;
import org.crossmobile.utils.ReflectionUtils;
import org.robovm.objc.block.VoidBlock1;

import java.io.File;
import java.util.*;

import static java.util.Arrays.asList;
import static org.crossmobile.utils.TimeUtils.time;

@Mojo(name = "modify", defaultPhase = LifecyclePhase.PROCESS_CLASSES, requiresDependencyResolution = ResolutionScope.COMPILE)
public class ModifyMojo extends GenericMojo {
    private final static Comparator<Class<?>> classComparator = (o1, o2) -> {
        if (o1 == o2)
            return 0;
        if (o1.isAssignableFrom(o2))
            return -1;
        if (o2.isAssignableFrom(o1))
            return 1;
        return o1.getName().compareTo(o2.getName());
    };

    @Override
    public void exec() {
        MojoLogger.register(getLog());
        time(() -> {
            File classes = new File(getProject().getBuild().getDirectory(), "classes");
            ReflectionUtils.resetClassLoader();
            ClassPool cp = ClassPool.getDefault();
            Collection<Class<?>> appearanceClasses = new TreeSet<>(classComparator);

            List<String> classPath = asList(classes.getAbsolutePath(), VoidBlock1.class.getProtectionDomain().getCodeSource().getLocation().getFile());
            ClassCollection.addClassPaths(cp, classPath);
            ClassCollection.gatherClasses(classPath, null, e -> {
                if (ObjectRegistry.isUIAppearanceClass(e) && !e.isInterface())
                    appearanceClasses.add(e);
            }, true);
            AppearanceInjections injections = new AppearanceInjections(cp, classes.getAbsolutePath());
            injections.cleanup(classes);
            for (Class<?> cls : appearanceClasses)
                injections.makeAppearance(cls);

        }, "Post-process classes");
    }
}
