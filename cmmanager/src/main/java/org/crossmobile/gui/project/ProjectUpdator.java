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
package org.crossmobile.gui.project;

import org.crossmobile.gui.parameters.impl.GroupIdParameter;
import org.crossmobile.utils.*;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

import static org.crossmobile.gui.project.ProjectInfo.OLD_ANT;
import static org.crossmobile.gui.project.ProjectInfo.OLD_XMLVM;
import static org.crossmobile.prefs.Config.*;
import static org.crossmobile.utils.ParamsCommon.*;
import static org.crossmobile.utils.TemplateUtils.copyTemplate;

public class ProjectUpdator {

    private static final String[] OBSOLETE_FILES = {
            "manifest.mf",
            "AndroidManifest.xml",
            OLD_XMLVM,
            OLD_ANT,
            ".classpath",
            ".project",
            "nbproject/crossmobile.xml",
            "nbproject/project.xml",
            "nbproject/project.properties",
            "nbproject/genfiles.properties",
            "nbproject/build-Android.xml",
            "nbproject/build-android.xml",
            "nbproject/build-Swing.xml",
            "nbproject/build-swing.xml",
            "nbproject/build-Desktop.xml",
            "nbproject/build-desktop.xml",
            "nbproject/build-Xcode.xml",
            "nbproject/build-xcode.xml",
            "nbproject/build-Java.xml",
            "nbproject/build-java.xml",
            "nbproject/build-helpers.xml",
            "nbproject/xmlvm.xml",
            "nbproject/build-impl.xml",
            "nbproject/configs/NetBeans.properties",
            "nbproject/configs/Java.properties",
            "nbproject/configs/Swing.properties",
            "nbproject/configs/Android.properties",
            "nbproject/configs/Xcode.properties",
            "nbproject/configs/Android Device.properties",
            "nbproject/configs/Swing Pad.properties",
            "nbproject/configs/Swing Phone.properties",
            "nbproject/configs/Swing PhoneShort.properties",
            "nbproject/configs/Xcode Device.properties",
            "nbproject/configs/Xcode Pad.properties",
            "nbproject/configs/Xcode Phone.properties",
            "nbproject/configs/Xcode PhoneShort.properties",
            "nbproject/configs/Xcode Project.properties",
            ".settings/org.eclipse.jdt.core.prefs",
            "build.xml",
            "ant.properties",
            "build.properties",
            "project.properties",
            "default.properties"
    };

    public static void update(File basedir, ParamList list) throws ProjectException {
        // Remove obsolete files
        for (String file : OBSOLETE_FILES)
            FileUtils.delete(new File(basedir, file), null);

        // Create pom
        File pom = new File(basedir, "pom.xml");
        if (!pom.isFile())
            copyTemplate("pom_xml", pom, list, null);

        // Move source files
        new File(basedir, "src" + File.separator + "main" + File.separator + "java").mkdirs();
        File old;
        if ((old = new File(basedir, "src" + File.separator + "java")).exists()) {
            FileUtils.copy(old, new File(basedir, "src" + File.separator + "main" + File.separator + "java"));
            FileUtils.delete(old);
        }

        // Move old artwork
        if ((old = new File(basedir, "artwork")).exists()) {
            FileUtils.copy(old, new File(basedir, "src/main/artwork"));
            FileUtils.delete(old);
        }
        // Move icons (after artwork relocation)
        File iconDir = new File(basedir, ICON_DIR);
        FileUtils.list(new File(basedir, "src/main/artwork"), (dir, name) -> name.toLowerCase().startsWith("icon") && name.toLowerCase().endsWith(".png"))
                .forEach(icon -> FileUtils.move(icon, new File(iconDir, icon.getName()), null));

        // Move old src/main/artwork
        if ((old = new File(basedir, "src/main/artwork")).exists()) {
            FileUtils.copy(old, new File(basedir, MATERIALS_PATH));
            FileUtils.delete(old);
        }

        // Update to adaptive icons
        File iconFore = new File(basedir, FORE_ICONS);
        FileUtils.list(iconDir, ((dir, name) -> new File(dir, name).isFile() && name.toLowerCase().endsWith(".png")))
                .forEach(icon -> FileUtils.move(icon, new File(iconFore, icon.getName()), null));

        // Maybe obsolete
        if ((old = new File(basedir, "src/main/cmresources")).exists()) {
            FileUtils.copy(old, new File(basedir, MATERIALS_PATH));
            FileUtils.delete(old);
        }
    }

    public static void updateOldToNew(Properties props) {
        String group = "", artifact = "", displayname;
        String id = props.getProperty("bundle.identifier");
        if (id != null) {
            int dot = id.lastIndexOf(".");
            group = dot < 0 ? GroupIdParameter.DEFAULT_GROUP_ID : id.substring(0, dot);
            artifact = dot < 0 ? id : id.substring(dot + 1);
        }
        displayname = props.getProperty("bundle.displayname");
        if (displayname == null || displayname.isEmpty())
            displayname = props.getProperty("application.name");
        if (displayname == null || displayname.isEmpty())
            displayname = artifact;

        mightUpdateProperty(props, DISPLAY_NAME.tag(), displayname);
        mightUpdateProperty(props, ARTIFACT_ID.tag(), artifact);
        mightUpdateProperty(props, GROUP_ID.tag(), group);
        mightUpdateProperty(props, CM_PLUGINS.tag(), Pom.packDependencies(Arrays.asList(Dependency.getSystemTheme(null))));
    }

    private static void mightUpdateProperty(Properties props, Param tag, String newvalue) {
        if (newvalue == null || newvalue.isEmpty())
            return;
        String cvalue = props.getProperty(tag.name);
        if (cvalue != null && !cvalue.isEmpty())
            return;
        props.setProperty(tag.name, newvalue);
    }

}
