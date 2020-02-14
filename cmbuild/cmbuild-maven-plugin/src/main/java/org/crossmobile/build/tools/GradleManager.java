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
package org.crossmobile.build.tools;

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.build.ng.CMBuildEnvironment;
import org.crossmobile.utils.*;

import java.io.File;
import java.util.regex.Pattern;

import static org.crossmobile.build.utils.Config.GRADLE;
import static org.crossmobile.utils.TemplateUtils.copyTemplateIfMissing;

public class GradleManager {

    public static final String GRADLE_PLUGIN = "cmbuild-gradle-plugin";

    public static void createAndUpdate(CMBuildEnvironment env) {
        createAndUpdateBuild(env);
        createAndUpdateProperties(env.getBasedir());
    }

    @SuppressWarnings("UseSpecificCatch")
    private static void createAndUpdateBuild(CMBuildEnvironment env) {
        try {
            File gradle = new File(env.getBasedir(), GRADLE);
            if (gradle.isFile()) {
                String content = FileUtils.read(gradle);
                if (content != null && (content.contains("crossmobile-gradle-plugin:1") || !content.contains("google()")))
                    FileUtils.move(gradle, new File(gradle.getParentFile(), "build.v1.old.gradle"), null);
            }

            ParamList list = new ParamList();
            StringBuilder deps = new StringBuilder();
            StringBuilder groot = new StringBuilder();
            for (PluginMetaData info : env.root().getPluginMetaData()) {
                deps.append(info.getAndroidInjections().getGradleBuildDep());
                groot.append(info.getAndroidInjections().getGradleExt());
            }
            list.put(ParamsCommon.ANDROID_GRADLE_DEPS.tag(), deps.toString());
            list.put(ParamsCommon.ANDROID_GRADLE_ROOT.tag(), groot.toString());
            copyTemplateIfMissing(GRADLE, gradle, "Creating missing build.gradle file", list);
        } catch (Exception ex) {
            BaseUtils.throwException(ex);
        }
    }

    private static void createAndUpdateProperties(File basedir) {
        try {
            copyTemplateIfMissing("gradle.properties", new File(basedir, "gradle.properties"), "Creating missing gradle.properties file", null);
        } catch (ProjectException ex) {
            BaseUtils.throwException(ex);
        }
    }
}
