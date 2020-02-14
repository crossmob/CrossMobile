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
package org.crossmobile.build.ng;

import org.crossmobile.build.AnnotationConfig;
import org.crossmobile.build.ib.AnnotationHelpers;
import org.crossmobile.build.ib.helper.XIBList;
import org.crossmobile.build.tools.*;
import org.crossmobile.build.tools.images.IosIconRegistry;
import org.crossmobile.build.tools.images.IconBuilder;
import org.crossmobile.build.tools.images.IconBuilder.IconType;
import org.crossmobile.build.xcode.XcodeTargetRegistry;
import org.crossmobile.build.xcode.resources.ObjCLibrary;
import org.crossmobile.build.xcode.resources.ResourceItem;
import org.crossmobile.utils.*;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;
import java.util.Map;

import static java.io.File.separator;
import static org.crossmobile.build.AnnotationConfig.ANN_LOCATION;
import static org.crossmobile.build.ng.CMBuildEnvironment.environment;
import static org.crossmobile.build.tools.InfoPListCreator.getPlist;
import static org.crossmobile.build.utils.Config.*;
import static org.crossmobile.build.utils.DependencyJarResolver.gatherLibs;
import static org.crossmobile.build.utils.JavaVersionDowngrader.convertToJava7;
import static org.crossmobile.prefs.Config.MATERIALS_PATH;
import static org.crossmobile.utils.CollectionUtils.asList;
import static org.crossmobile.utils.ParamsCommon.*;

public class PostCompilePipeline implements Runnable {

    @Override
    public void run() {
        switch (environment().getFlavour()) {
            case IOS:
                postcompileIOS();
                break;
            case UWP:
                postcompileUwp();
                break;
        }
    }

    private void postcompileUwp() {
        CMBuildEnvironment env = environment();
        File ann = new File(env.getBuilddir(), AnnotationConfig.ANN_LOCATION);
        String projectName = env.getProperties().getProperty(ARTIFACT_ID.tag().name);

        File xcodeLibs = new File(env.getBuilddir(), XCODE_BASE + separator + XCODE_EXT_LIB);
        File xcodeSource = new File(env.getBuilddir(), XCODE_BASE + separator + XCODE_EXT_APP);
        File xcodeInclude = new File(env.getBuilddir(), XCODE_BASE + separator + XCODE_EXT_INC);
        File plistDir = new File(env.getBuilddir(), XCODE_BASE + separator + XCODE_EXT_PLIST);

        File classesDir = new File(env.getBuilddir(), CLASSES);
        File cacheBase = new File(env.getBuilddir(), PROJECT_CACHES);
        File cacheClasses = new File(cacheBase, "classes");
        File cacheDiffClasses = new File(cacheBase, "diff");

        convertToJava7(env.getRetroLambda(), classesDir, gatherLibs(env.root(), false), false);

        // Copy external Java plugins
        CopyLibClasses.exec(classesDir, env.root());

        GenerateSreenSizeSettings.exec(xcodeSource, env.getProperties());

        // Gather targets early, in order to know which are valid
        Map<String, AnnotationHelpers.CodeAnnotations> annotations = XcodeTargetRegistry.gatherTargets(env, new File(env.getBuilddir(), ANN_LOCATION));

        // Construct ObjC files
        if (DiffSync.exec(classesDir, cacheClasses, cacheDiffClasses)) {
            File cacheSource = new File(cacheBase, XCODE_EXT_APP);
            XMLVMLauncher.exec(cacheDiffClasses, cacheSource, env.getXMLVM(), true);

            // Post-process ObjC files
            AnnConnXcode.exec(annotations, cacheSource);
            ObjCPostProcess.exec(cacheSource, env.getProperties().getProperty(OBJC_IGNORE_INCLUDES.tag().name));
            ReverseCodeInjector.exec(classesDir, asList(env.root().getCompileOnlyDependencies(true), DependencyItem::getFile), cacheSource);

            SyncObjCFiles.exec(classesDir, cacheSource, xcodeSource);
        }

        // Extract binary libraries and include files
        ObjCLibrary objCLibrary = ObjCLibrary.extract(env.root(), xcodeLibs, xcodeInclude, env.getRelativeBuildToBase());
        Log.debug("Xcode Lib List : " + objCLibrary.getLibraries());

        //        <!-- Update needed source files -->
        new JavaCleanFiles(classesDir, xcodeSource).execute();

        //        <!-- create Xcode project -->
        Map<String, File> xmfontsValue = FontExtractor.findFonts(env.getMaterialsDir());

        // Parse IB to check for errors & update localizations
        XIBList xibList = IBObjectsCreator.parse(env.getMaterialsDir(), ann);
        MaterialsManager.parseMaterials(xibList.getMeta(), env.getMaterialsDir(), null);

        // Create Info.plist files
        new InfoPListCreator(env.getProperties(),
                getPlist(plistDir, projectName),
                xmfontsValue.keySet(),
                env.getProperties().getProperty(INJECTED_INFOPLIST.tag().name),
                env.getBasedir()).execute(env);
        for (XcodeTarget target : XcodeTargetRegistry.getExtraTargets())
            InfoPListCreator.createExtensionPlist(plistDir, env.getAppId(), target);

        XCodeProject xCodeProject = new XCodeProject(projectName, plistDir, env.getProperties().getProperty(CM_PROJECT.tag().name, ""), env.getBasedir());
        xCodeProject.addConfiguredResource(new ResourceItem("Application", env.getBuilddir() + separator + XCODE_BASE + separator + XCODE_EXT_APP + separator));
        xCodeProject.addConfiguredResource(new ResourceItem("Materials", MATERIALS_PATH));
        xCodeProject.setConfiguredLibrary(objCLibrary);
        xCodeProject.execute();
        Commander cmd = new Commander("vsimporter.exe");
        cmd.setCurrentDir(env.getBasedir());
        cmd.setOutListener(Log::info);
        cmd.setErrListener(Log::warning);
        cmd.exec();
        cmd.waitFor();
        tweakProject(env, xcodeLibs);
    }

    private void tweakProject(CMBuildEnvironment env, File xcodeLibs) {
        File project = new File(env.getArtifactId() + ".vsimporter" + separator
                + env.getArtifactId() + "-WinStore10" + separator
                + env.getArtifactId() + ".vcxproj");
        XMLWalker walker = XMLWalker.load(project);
        walker.path("/Project").tag("root").node("ItemGroup").exec(ig -> {
            for (File lib : xcodeLibs.listFiles())
                if (lib.getName().endsWith(".dll"))
                    ig.add("None").setAttribute("Include", lib.getPath()).add("DeploymentContent").setText("true").parent().parent();
        }).toTag("root").nodes("ItemDefinitionGroup",
                idg -> idg.node("Link").add("AdditionalLibraryDirectories").setText(".." + separator + ".." + separator + "target" + separator + "xcode" + separator + "plugins" + separator + "lib"));
        walker.store(project, true);
    }

    private void postcompileIOS() {
        CMBuildEnvironment env = environment();
        File ann = new File(env.getBuilddir(), AnnotationConfig.ANN_LOCATION);
        String projectName = env.getProperties().getProperty(ARTIFACT_ID.tag().name);

        File xcodeLibs = new File(env.getBuilddir(), XCODE_BASE + separator + XCODE_EXT_LIB);
        File xcodeSource = new File(env.getBuilddir(), XCODE_BASE + separator + XCODE_EXT_APP);
        File xcodeResources = new File(env.getBuilddir(), XCODE_BASE + separator + XCODE_EXT_MAT);
        File xcodeInclude = new File(env.getBuilddir(), XCODE_BASE + separator + XCODE_EXT_INC);
        File plistDir = new File(env.getBuilddir(), XCODE_BASE + separator + XCODE_EXT_PLIST);

        File classesDir = new File(env.getBuilddir(), CLASSES);
        File cacheBase = new File(env.getBuilddir(), PROJECT_CACHES);
        File cacheClasses = new File(cacheBase, "classes");
        File cacheDiffClasses = new File(cacheBase, "diff");

        convertToJava7(env.getRetroLambda(), classesDir, gatherLibs(env.root(), false), false);

        // Copy external Java plugins
        CopyLibClasses.exec(classesDir, env.root());

        // Gather targets early, in order to know which are valid
        Map<String, AnnotationHelpers.CodeAnnotations> annotations = XcodeTargetRegistry.gatherTargets(env, new File(env.getBuilddir(), ANN_LOCATION));

        // Construct ObjC files
        if (DiffSync.exec(classesDir, cacheClasses, cacheDiffClasses)) {
            File cacheSource = new File(cacheBase, XCODE_EXT_APP);
            XMLVMLauncher.exec(cacheDiffClasses, cacheSource, env.getXMLVM(), Boolean.parseBoolean(env.getProperties().getProperty("cm.objc.safemembers", "true")));
            SyncObjCFiles.exec(classesDir, cacheSource, xcodeSource);
            new JavaCleanFiles(classesDir, xcodeSource).execute();

            // Post-process ObjC files
            ObjCPostProcess.exec(xcodeSource, env.getProperties().getProperty(OBJC_IGNORE_INCLUDES.tag().name));
            AnnConnXcode.exec(annotations, xcodeSource);
            ReverseCodeInjector.exec(classesDir, asList(env.root().getCompileOnlyDependencies(true), DependencyItem::getFile), xcodeSource);
        }

        // Extract binary libraries and include files
        ObjCLibrary objCLibrary = ObjCLibrary.extract(env.root(), xcodeLibs, xcodeInclude, env.getRelativeBuildToBase());
        Log.debug("Xcode Lib List : " + objCLibrary.getLibraries());

        //        <!-- create Xcode project -->
        Map<String, File> xmfontsValue = FontExtractor.findFonts(env.getMaterialsDir());

        // Parse IB to check for errors & update localizations
        XIBList xibList = IBObjectsCreator.parse(env.getMaterialsDir(), ann);
        MaterialsManager.parseMaterials(xibList.getMeta(), env.getMaterialsDir(), null);

        // Create Info.plist files
        new InfoPListCreator(env.getProperties(),
                getPlist(plistDir, projectName),
                xmfontsValue.keySet(),
                env.getProperties().getProperty(INJECTED_INFOPLIST.tag().name),
                env.getBasedir()).execute(env);
        for (XcodeTarget target : XcodeTargetRegistry.getExtraTargets())
            InfoPListCreator.createExtensionPlist(plistDir, env.getAppId(), target);

        File appIconSet = new File(xcodeResources, "CrossImages.xcassets" + separator + "CrossIcon.appIconSet");
        IconBuilder.copyIcons(IconBuilder.getDefaultHound(env.getBasedir()), appIconSet, IconType.valueOf(env.getProperties().getProperty("cm.project").toUpperCase()));
        IosIconRegistry.exec(appIconSet);
        XCodeProject xCodeProject = new XCodeProject(projectName, plistDir, env.getProperties().getProperty(CM_PROJECT.tag().name, ""), env.getBasedir());
        xCodeProject.addConfiguredResource(new ResourceItem("Application", env.getRelativeBuildToBase() + XCODE_BASE + separator + XCODE_EXT_APP + separator));
        xCodeProject.addConfiguredResource(new ResourceItem("Materials", MATERIALS_PATH, xcodeResources.getPath() + separator));
        xCodeProject.setConfiguredLibrary(objCLibrary);
        xCodeProject.execute();

        if (!objCLibrary.getPods().isEmpty())
            PluginPod.create(env.getBasedir(), projectName, XcodeTargetRegistry.getAllTargets(), objCLibrary.getPods());
    }
}
