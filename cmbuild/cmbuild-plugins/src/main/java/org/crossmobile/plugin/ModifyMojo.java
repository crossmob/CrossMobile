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
package org.crossmobile.plugin;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.crossmobile.build.GenericMojo;
import org.crossmobile.build.utils.MojoLogger;
import org.crossmobile.plugin.actions.AppearanceInjections;
import org.crossmobile.plugin.actions.CreateBeanAPI;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.utils.ClassCollection;
import org.crossmobile.utils.ReflectionUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.crossmobile.utils.TimeUtils.time;

@Mojo(name = "modify", defaultPhase = LifecyclePhase.PROCESS_CLASSES, requiresDependencyResolution = ResolutionScope.COMPILE)
public class ModifyMojo extends GenericMojo {


    @Override
    public void exec() {
        MojoLogger.register(getLog());
        time(() -> {
            File classes = new File(getProject().getBuild().getDirectory(), "classes");
            ClassCollection cc = new ClassCollection();
            ReflectionUtils.resetClassLoader();

            cc.resolve(Collections.singleton(classes.getAbsolutePath()), true);
            AppearanceInjections injections = new AppearanceInjections(cc.getClassPool(), classes.getAbsolutePath());

            injections.cleanup(classes);
            for (Class<?> cls : cc.getIOsNativeClasses())
                if (ObjectRegistry.isUIAppearanceClass(cls) && !cls.isInterface())
                    injections.makeAppearance(cls);

        }, "Post-process classes");
    }
}
