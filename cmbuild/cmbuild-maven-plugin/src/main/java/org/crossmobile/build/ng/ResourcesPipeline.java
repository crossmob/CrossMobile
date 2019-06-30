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

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.build.AnnotationConfig;
import org.crossmobile.build.ib.helper.XIBList;
import org.crossmobile.build.tools.*;
import org.crossmobile.utils.MaterialsUtils;

import java.io.File;
import java.util.Collection;

import static org.crossmobile.build.ng.CMBuildEnvironment.environment;
import static org.crossmobile.build.utils.Config.*;
import static org.crossmobile.prefs.Config.ICONS;
import static org.crossmobile.prefs.Config.MATERIALS_PATH;
import static org.crossmobile.utils.CollectionUtils.asList;
import static org.crossmobile.utils.FileUtils.delete;
import static org.crossmobile.utils.FileUtils.write;
import static org.crossmobile.utils.ParamsCommon.*;
import static org.crossmobile.utils.TemplateUtils.copyTemplateIfMissing;

public class ResourcesPipeline implements Runnable {

    @Override
    public void run() {
        new PID().exec();
        switch (environment().getFlavour()) {
            case IOS:
                resourcesIOS();
                break;
            case ANDROID:
                resourcesAndroid();
                break;
            case UWP:
                resourcesUWP();
            default:
                resourcesDesktop();
                break;
        }
        ExtProjectLauncher.store(environment().getBuilddir(),
                environment().getFlavour(),
                "theme",
                null,
                environment().getArtifactId(),
                environment().getProperties().getProperty(GROUP_ID.tag().name) + "." + environment().getProperties().getProperty(ARTIFACT_ID.tag().name),
                environment().getProperties().getProperty(MAIN_CLASS.tag().name),
                environment().isRelease());
    }

    private void resourcesUWP() {
        resourcesIOS();
    }

    private void resourcesDesktop() {
        CMBuildEnvironment env = environment();
        File baseMaterials = new File(env.getBasedir(), MATERIALS_PATH);
        Collection<File> materials = MaterialsUtils.getMaterials(env.getBasedir(), MATERIALS_PATH);
        File generated = new File(env.getBuilddir(), GENERATED_CMSOURCES);
        File app = new File(env.getBuilddir(), APP);
        File ann = new File(env.getBuilddir(), AnnotationConfig.ANN_LOCATION);
        File propertiesOut = new File(app, CROSSMOBILE_PROPERTIES);
        File info = new File(app, "Info.plist");
        File cacheBase = new File(env.getBuilddir(), PROJECT_CACHES);

        XIBList xibList = IBObjectsCreator.parse(new File(env.getBasedir(), MATERIALS_PATH), ann);
        MaterialsCopier.copyMaterials(materials, baseMaterials, new File(env.getBuilddir(), APP), xibList.getMeta());
        IBObjectsCreator.createJavaSource(xibList, new File(generated, IBOBJECTS), new File(cacheBase, IBOBJECTS));

        IconsCopier.copyIcons(new File(env.getBuilddir(), ICONS), new File(env.getBuilddir(), SYS), IconsCopier.DesktopIcons);
        new PropertiesCreator(env.getProperties(),
                env.getProperties().getProperty(MAIN_CLASS.tag().name), propertiesOut, env.getBasedir()).execute(env);
        new InfoPListCreator(env.getProperties(), info, null, env.getProperties().getProperty(INJECTED_INFOPLIST.tag().name),
                env.getBasedir()).execute(env);
        new PluginsLauncher(env.root().getPluginMetaData(), generated, cacheBase).execute();
    }

    private void resourcesAndroid() {
        CMBuildEnvironment env = environment();

        new AdbLauncher(env.getProperties().getProperty("sdk.dir")).exec("devices", "-l"); // Early launching of ADB devices

        File baseMaterials = new File(env.getBasedir(), MATERIALS_PATH);
        Collection<File> materials = MaterialsUtils.getMaterials(env.getBasedir(), MATERIALS_PATH);
        File andrRes = new File(env.getBuilddir(), ANDROID_RES);
        File andrAsset = new File(env.getBuilddir(), ANDROID_ASSET);
        File generated = new File(env.getBuilddir(), GENERATED_CMSOURCES);
        File ann = new File(env.getBuilddir(), AnnotationConfig.ANN_LOCATION);
        File cacheBase = new File(env.getBuilddir(), PROJECT_CACHES);
        UpdateAndroidDependencies.execute(new File(env.getBuilddir(), CROSSMOBILE_GRADLE),
                env.getProperties().getProperty(GROUP_ID.tag().name) + "." + env.getProperties().getProperty(ARTIFACT_ID.tag().name),
                env.root());
        AndroidProjectCreator.execute(env);

        XIBList xibList = IBObjectsCreator.parse(baseMaterials, ann);
        MaterialsCopier.copyMaterials(materials, baseMaterials, andrAsset, xibList.getMeta());
        IBObjectsCreator.createJavaSource(xibList, new File(generated, IBOBJECTS), new File(cacheBase, IBOBJECTS));

        MaterialsCopier.copyAndroidSys(asList(env.root().getRuntimeDependencies(true), d -> d.getFile()), andrAsset, andrRes);
        IconsCopier.copyIcons(new File(env.getBasedir(), ICONS), andrRes, IconsCopier.AndroidIcons);
        new PropertiesCreator(env.getProperties(), env.getProperties().getProperty(MAIN_CLASS.tag().name),
                new File(env.getBuilddir(), ANDROID_PROP), env.getBasedir()).execute(env);
        new InfoPListCreator(env.getProperties(),
                new File(env.getBuilddir(), ANDROID_PLIST), null, env.getProperties().getProperty(INJECTED_INFOPLIST.tag().name),
                env.getBasedir()).execute(env);
        new PluginsLauncher(env.root().getPluginMetaData(), generated, cacheBase).execute();
        ann.mkdirs();

        write(new File(env.getBuilddir(), ANDROID_FONTLIST), FontExtractor.getFontDataAsResource(FontExtractor.findFonts(materials)));
        GradleManager.createAndUpdate(env.getBasedir());
        LocalPropertiesManager.createIfNotExist(env.getBasedir());
    }

    private void resourcesIOS() {
        try {
            delete(new File(environment().getBuilddir(), "classes")); // Needed by retrolambda to work properly
            copyTemplateIfMissing("project.pbxproj",
                    new File(environment().getBasedir(), environment().getProperties().getProperty(ARTIFACT_ID.tag().name) + ".xcodeproj" + File.separator + "project.pbxproj"),
                    "Creating missing Xcode project file");
        } catch (Throwable ex) {
            BaseUtils.throwException(ex);
        }
    }
}
