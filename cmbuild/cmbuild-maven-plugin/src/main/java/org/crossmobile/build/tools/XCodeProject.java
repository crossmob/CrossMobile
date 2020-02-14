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

import org.crossmobile.build.xcode.XCodeCreator;
import org.crossmobile.build.xcode.resources.ObjCLibrary;
import org.crossmobile.build.xcode.resources.ResourceItem;
import org.crossmobile.utils.Log;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class XCodeProject {

    private final String name;
    private final File plistDir;
    private final String projectType; // defaults to iphone
    private final File basedir;
    private Set<File> resources = new TreeSet<>();
    private ObjCLibrary libs;

    public XCodeProject(String name, File plistDir, String project, File basedir) {
        if (name == null || name.isEmpty())
            throw new RuntimeException("Please provide a valid project name under attribute 'name'.");

        this.name = name;
        this.plistDir = plistDir;
        this.basedir = basedir;

        switch (project.toLowerCase().trim()) {
            case "ipad":
                this.projectType = "2";
                break;
            case "ios":
                this.projectType = "1,2";
                break;
            case "iphone":
            default:
                this.projectType = "1";
                break;
        }
    }

    public void addConfiguredResource(ResourceItem item) {
        item.update(basedir);
        resources.addAll(item.getResources());
    }

    public void setConfiguredLibrary(ObjCLibrary plugin) {
        libs = plugin;
    }

    public void execute() {
        Log.info("Creating project for " + name);

        File base = basedir;

//        int count_libs = items.getLibraries().size();
//        if (count_libs > 0)
//            Log.info("Plugins require " + count_libs + " native " + (count_libs == 1 ? "library" : "libraries"));
        new XCodeCreator(name, resources, libs.getLibraries(), base, plistDir, libs.getIncludes(), projectType).updateProject();
//        FileUtils.write(new File(base, name + ".xcodeproj" + File.separator + "project.pbxproj"),
//                XCodeCreator.createProject(name, projectType, infoplist, items));
//
//        FileUtils.write(new File(base, name + ".xcodeproj" + File.separator + "xcshareddata" + File.separator + "xcschemes" + File.separator + name + ".xcscheme"),
//                XCodeCreator.createScheme(name));
    }
}
