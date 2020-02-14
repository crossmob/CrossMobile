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
package org.crossmobile.plugin.actions;

import org.crossmobile.build.ArtifactInfo;
import org.crossmobile.plugin.reg.Plugin;
import org.crossmobile.plugin.reg.PluginDependency;
import org.crossmobile.plugin.reg.PluginRegistry;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.PluginMetaData;
import org.crossmobile.utils.plugin.DependencyItem;

import java.io.File;
import java.io.Writer;
import java.util.function.Consumer;

import static java.io.File.separator;
import static org.crossmobile.build.utils.Locations.NATIVE_PATH;
import static org.crossmobile.build.utils.PlistUtils.isInclude;
import static org.crossmobile.plugin.actions.PluginAssembler.*;
import static org.crossmobile.plugin.utils.Statics.*;
import static org.crossmobile.prefs.Config.REVERSE_INF;
import static org.crossmobile.utils.FileUtils.*;
import static org.crossmobile.utils.FileUtils.Predicates.extensions;
import static org.crossmobile.utils.JarUtils.createJar;
import static org.crossmobile.utils.PluginMetaData.PLUGIN_LOC;
import static org.crossmobile.utils.TextUtils.iterableToString;

public class CreateArtifacts {

    public static void installPlugin(Consumer<ArtifactInfo> installer,
                                     String plugin, File target, DependencyItem item, File cache, File vendorSrc, File vendorBin, ReverseCode rc,
                                     boolean buildDesktop, boolean buildIos, boolean buildUwp, boolean buildAndroid, boolean buildRvm, boolean buildCore,
                                     Writer report) {
        // Get plugin data
        Plugin pluginData = PluginRegistry.getPluginData(plugin);

        // Define targets
        File compileTarget = compileBase.apply(target, plugin);
        File builddepTarget = builddepBase.apply(target, plugin);
        File iosTarget = iosBase.apply(target, plugin);
        File desktopTarget = desktopBase.apply(target, plugin);
        File uwpTarget = uwpBase.apply(target, plugin);
        File androidTarget = androidBase.apply(target, plugin);
        File rvmTarget = rvmBase.apply(target, plugin);

        PluginMetaData meta = new PluginMetaData(pluginData.getLibs(), pluginData.getPermissions(), pluginData.getPods(), pluginData.getInjections(), pluginData.getInitializer(), pluginData.getAndroidExtraDependenciess());
        Log.debug("Meta data for " + plugin + ": " + meta.toString());
        copy(write(new File(compileTarget, PLUGIN_LOC), meta.getProperties("Plugin " + plugin)),
                new File(cache, plugin + File.separator + "plugin.txt"));

        if (buildIos || buildUwp) {
            Log.debug("Back references for " + plugin + ": " + iterableToString(rc.getListOfClasses(plugin), ";"));
            copy(write(new File(compileTarget, REVERSE_INF), rc.toString(plugin)),
                    new File(cache, plugin + File.separator + "reverse.txt"));
            Log.debug("Installing native files of plugin " + plugin);

            if (buildIos) {
                File lib = new File(cache, "lib" + separator + "lib" + plugin + ".a");
                if (copy(lib, new File(iosTarget, NATIVE_PATH + separator + plugin + ".a")) == 0)
                    if (pluginData.hasOptionalLibraryBinary())
                        Log.info("Native library not found but ignored as noted: " + lib.getAbsolutePath());
                    else
                        Log.error("Unable to copy native library " + lib.getAbsolutePath());
                forAll(new File(vendorBin, plugin), extensions(".a"), (p, f) -> copy(f, new File(iosTarget, NATIVE_PATH + separator + f.getName())));
            }
            if (buildUwp) {
                File dll = new File(cache, "lib" + separator + "lib" + plugin + ".dll");
                if (copy(dll, new File(uwpTarget, NATIVE_PATH + separator + plugin + ".dll")) == 0)
                    if (pluginData.hasOptionalLibraryBinary())
                        Log.info("Native library not found but ignored as noted: " + dll.getAbsolutePath());
                    else
                        Log.error("Unable to copy native library " + dll.getAbsolutePath());
                forAll(new File(vendorBin, plugin), extensions(".dll"), (p, f) -> copy(f, new File(iosTarget, NATIVE_PATH + separator + f.getName())));
            }

            forAll(new File(cache, plugin + separator + (buildIos ? "native" : "uwp" + separator + "uwpinclude")), f -> isInclude(f.getName()),
                    (p, f) -> copy(f, new File(buildIos ? iosTarget : uwpTarget, NATIVE_PATH + separator + f.getName())));
            forAll(new File(vendorSrc, plugin + (buildIos ? "" : (separator + "uwpinclude"))), f -> isInclude(f.getName()), (p, f) -> copy(f, new File(buildIos ? iosTarget : uwpTarget, NATIVE_PATH + separator + f.getName())));
        }

        Log.info("Installing plugin " + plugin + " artifacts in local repository");
        File artBase = new File(target, "artifacts");
        for (PluginDependency dep : PluginRegistry.getPluginData(plugin).getDependencies())
            Log.info("Found dependency " + dep.info() + " with targets " + dep.target().listTargets());
        if (buildCore) {
            install(installer, createJar(report, new File(artBase, "cmplugin-" + plugin + '-' + item.getVersion() + ".jar"), compileTarget),
                    plugin, "", item.getGroupID(), item.getVersion());
            install(installer, createJar(report, new File(artBase, "cmplugin-builddep-" + plugin + '-' + item.getVersion() + ".jar"), builddepTarget),
                    plugin, "builddep-", item.getGroupID(), item.getVersion());
        }
        if (buildIos)
            install(installer, createJar(report, new File(artBase, "cmplugin-ios-" + plugin + "-" + item.getVersion() + ".jar"), iosTarget),
                    plugin, "ios-", item.getGroupID(), item.getVersion());
        if (buildUwp)
            install(installer, createJar(report, new File(artBase, "cmplugin-uwp-" + plugin + "-" + item.getVersion() + ".jar"), uwpTarget),
                    plugin, "uwp-", item.getGroupID(), item.getVersion());
        if (buildDesktop)
            install(installer, createJar(report, new File(artBase, "cmplugin-desktop-" + plugin + "-" + item.getVersion() + ".jar"), desktopTarget),
                    plugin, "desktop-", item.getGroupID(), item.getVersion());
        if (buildAndroid)
            install(installer, createJar(report, new File(artBase, "cmplugin-android-" + plugin + "-" + item.getVersion() + ".jar"), androidTarget),
                    plugin, "android-", item.getGroupID(), item.getVersion());
        if (buildRvm)
            install(installer, createJar(report, new File(artBase, "cmplugin-rvm-" + plugin + "-" + item.getVersion() + ".jar"), rvmTarget),
                    plugin, "rvm-", item.getGroupID(), item.getVersion());
        Log.debug("Installing of plugin " + plugin + " terminated");
    }

    private static void install(Consumer<ArtifactInfo> installer, File fileToInstall, String plugin, String type, String groupid, String version) {
        if (fileToInstall == null)
            throw new NullPointerException("Unable to install null file");
        String packaging = getExtension(fileToInstall.getName());
        String artifactid = "cmplugin-" + type + plugin;

        StringBuilder deplist = new StringBuilder();
        for (PluginDependency dep : PluginRegistry.getPluginData(plugin).getDependencies())
            if (checkTarget(dep, type))
                addDependency(dep, groupid, type, version, packaging, deplist);
        if (type.equals("builddep-"))
            addDependency(groupid, "cmplugin-" + plugin, version, "jar", deplist);

        String dependencies = deplist.length() > 0 ? "    <dependencies>\n" + deplist.toString() + "    </dependencies>\n" : "";

        String pomData = POM_XML.
                replace(POM_GROUPID, groupid).
                replace(POM_ARTIFACTID, artifactid).
                replace(POM_VERSION, version).
                replace(POM_PACKAGING, packaging).
                replace(POM_DEPENDENCIES, dependencies);
        File pomFile = new File(fileToInstall.getParent(), artifactid + "-" + version + ".pom");
        write(pomFile, pomData);
        installer.accept(new ArtifactInfo(fileToInstall, groupid, artifactid, version, pomFile));
    }

    private static void addDependency(PluginDependency dep, String groupid, String type, String version, String packaging, StringBuilder deplist) {
        addDependency(
                dep.groupId().trim().isEmpty() ? groupid : dep.groupId().trim(),
                (dep.isCMPlugin() ? "cmplugin-" + type : "") + dep.pluginName().trim(),
                dep.version().trim().isEmpty() ? version :
                        (dep.isCMPlugin() && !dep.version().trim().equals(version)) ? "[" + dep.version().trim() + ",)" : dep.version().trim(),
                dep.type().trim().isEmpty() ? packaging : dep.type().trim(),
                deplist);
    }

    private static void addDependency(String groupid, String artifactid, String version, String type, StringBuilder deplist) {
        deplist.append("        <dependency>\n").
                append("            <groupId>").append(groupid).append("</groupId>\n").
                append("            <artifactId>").append(artifactid).append("</artifactId>\n").
                append("            <version>").append(version).append("</version>\n").
                append("            <type>").append(type).append("</type>\n").
                append("        </dependency>\n");
    }

    private static boolean checkTarget(PluginDependency dep, String type) {
        switch (type) {
            case "ios-":
                return dep.target().iosjava;
            case "android-":
                if (!dep.isCMPlugin())
                    return false;
                return dep.target().android;
            case "desktop-":
                return dep.target().desktop;
            case "uwp-":
                return dep.target().uwpjava;
            case "builddep-":
                return dep.target().builddep | dep.target().compile;
            default:
                return false;
        }
    }
}
