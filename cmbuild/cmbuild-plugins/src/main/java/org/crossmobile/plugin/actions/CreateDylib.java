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

import com.dd.plist.NSDictionary;
import com.dd.plist.NSString;
import com.dd.plist.PropertyListParser;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.build.ArtifactInfo;
import org.crossmobile.build.utils.PlistUtils.*;
import org.crossmobile.plugin.objc.ReverseImportRegistry;
import org.crossmobile.plugin.reg.Plugin;
import org.crossmobile.utils.Commander;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.PluginPod;
import org.crossmobile.utils.XcodeTarget;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.io.File.separator;
import static java.util.Collections.singletonList;
import static org.crossmobile.build.utils.PlistUtils.*;
import static org.crossmobile.utils.CollectionUtils.asList;
import static org.crossmobile.utils.FileUtils.readResourceSafe;
import static org.crossmobile.utils.FileUtils.write;
import static org.crossmobile.utils.TextUtils.plural;

public class CreateDylib extends CreateLib {

    public CreateDylib(Function<ArtifactInfo, File> resolver, File target, File cache, File vendor, File IDELocation, ReverseImportRegistry handleRegistry, boolean build) throws IOException {
        super(resolver, target, cache, vendor, IDELocation, handleRegistry, true, build);
    }

    @Override
    protected void runEmitters(Function<String, File> prodResolv, AtomicBoolean hasSwift) throws IOException {
        emitPlatformFiles(prodResolv, true, hasSwift);
    }

    @Override
    protected File createProj(File target, String plugin) {
        String project = readResourceSafe("org/crossmobile/plugin/project.pbxproj");
        if (project == null)
            throw new RuntimeException("Unable to retrieve project template");
        project = project.replaceAll(LIB_ANCHOR, plugin);
        File projDestFile = new File(target, "native" + separator + plugin + separator + plugin + ".xcodeproj" + separator + "project.pbxproj");
        Log.debug("Creating project " + projDestFile.getParent());
        if (write(projDestFile, project) == null)
            throw new RuntimeException("Unable to store project file");
        return projDestFile;
    }

    @SuppressWarnings("UseSpecificCatch")
    @Override
    protected void updateProj(File xcodeproj, Plugin plugin, Collection<File> includes, Collection<File> headerSearchPaths, Collection<File> compiled, Collection<String> deps, boolean createSwift) {
        if (plugin.hasPods())
            PluginPod.create(xcodeproj.getParentFile().getParentFile(), plugin.getName(), singletonList(XcodeTarget.Main), plugin.getPods());
        try {
            NSDictionary root = (NSDictionary) PropertyListParser.parse(xcodeproj);
            NSDictionary objects = (NSDictionary) getPath(root, "objects");
            SafeRef objRef = new SafeRef(objects);
            int comCount = 0;
            List<NSString> filerefs = new ArrayList<>();
            List<NSString> buildrefs = new ArrayList<>();
            comCount += addRefs(includes, objRef, filerefs, buildrefs);
            findEntryWithChild(objects, "path", plugin.getName()).put("children", filerefs.toArray(new NSString[0]));
            findEntryWithChild(objects, "isa", "PBXSourcesBuildPhase").put("files", buildrefs.toArray(new NSString[0]));

            // Store include paths
            List<NSString> incPaths = asList(headerSearchPaths, f -> new NSString(f.getAbsolutePath()));
            for (NSDictionary buildobj : findEntriesWithChild(objects, "isa", "XCBuildConfiguration"))
                ((NSDictionary) buildobj.get("buildSettings")).
                        put("HEADER_SEARCH_PATHS", incPaths.toArray(new NSString[incPaths.size()]));

            if (createSwift) {
                String bridge = getSwiftBridge(includes, plugin.getName());
                for (NSDictionary buildobj : findEntriesWithChild(objects, "isa", "XCBuildConfiguration")) {
                    NSDictionary buildSettings = ((NSDictionary) buildobj.get("buildSettings"));
                    buildSettings.put("SWIFT_OBJC_BRIDGING_HEADER", bridge);
                    buildSettings.put("SWIFT_OPTIMIZATION_LEVEL", "-Onone");
                    buildSettings.put("SWIFT_VERSION", "4.0");
                }
            }

            PropertyListParser.saveAsASCII(root, xcodeproj);

            Log.info("Compiling " + comCount + " native source file" + plural(comCount) + " for plugin " + plugin);
        } catch (Exception ex) {
            BaseUtils.throwException(ex);
        }
    }

    // Generic file reference
    private static String addFile(File file, SafeRef ref) {
        NSDictionary fdic = new NSDictionary();
        fdic.put("isa", "PBXFileReference");
        fdic.put("fileEncoding", "4");
        fdic.put("lastKnownFileType", getFileType(file.getName()));
        fdic.put("name", file.getName());
        fdic.put("path", file.getAbsolutePath());
        fdic.put("sourceTree", "SOURCE_ROOT");
        return ref.put(fdic);
    }
    // Add compilable file reference

    private static String addCompilable(String fileref, SafeRef ref) {
        NSDictionary buildfile = new NSDictionary();
        buildfile.put("isa", "PBXBuildFile");
        buildfile.put("fileRef", fileref);
        return ref.put(buildfile);
    }

    private String getSwiftBridge(Collection<File> filelist, String plugin) {
        String bridge = "";
        for (File file : filelist) {
            if (file.isDirectory())
                bridge = getSwiftBridge(asList(file.listFiles()), plugin);
            else if (file.getName().endsWith(plugin + "-Bridging-Header.h"))
                bridge = file.getAbsolutePath();
            if (!bridge.isEmpty())
                return bridge;
        }
        return "";
    }

    public int addRefs(Collection<File> filelist, SafeRef objRef, List<NSString> filerefs, List<NSString> buildrefs) {
        int count = 0;
        for (File file : filelist)
            if (file.isDirectory() && !file.getName().equals("uwpinclude"))
                count += addRefs(asList(file.listFiles()), objRef, filerefs, buildrefs);
            else if (isCompilable(file.getName()) || isInclude(file.getName())) {
                String fileref = addFile(file, objRef);
                filerefs.add(new NSString(fileref));
                if (isCompilable(file.getName())) {
                    buildrefs.add(new NSString(addCompilable(fileref, objRef)));
                    count++;
                }
            }
        return count;
    }

    enum CTypes {
        iphoneos, iphonesimulator
    }

    @Override
    protected void compile(File proj, File lib, Plugin plugin, String libname) {
        File projRoot = proj.getParentFile().getParentFile();
        for (CTypes t : CTypes.values()) {
            List<String> arg = new ArrayList<>();
            arg.add("xcodebuild");
            arg.add(plugin.hasPods() ? "-workspace" : "-project");
            arg.add(plugin.getName() + (plugin.hasPods() ? ".xcworkspace" : ".xcodeproj"));
            arg.add(plugin.hasPods() ? "-scheme" : "-target");
            arg.add(plugin.getName());
            arg.add("ONLY_ACTIVE_ARCH=NO");
            arg.add("-configuration");
            arg.add("Release");
            arg.add("-sdk");
            arg.add(t.name());
            if (plugin.hasPods()) {
                arg.add("-derivedDataPath");
                arg.add(".");
            }
            if (!exec(projRoot, arg))
                throw new RuntimeException("Unable to compile plugin " + plugin.getName() + " (" + t.name() + ")");
        }
        String buildLoc = plugin.hasPods() ? "Build" + separator + "Products" : "build";
        File iosNat = new File(projRoot, buildLoc + separator + "Release-iphonesimulator" + separator + libname);
        if (!iosNat.exists())
            Log.error("Unable to locate library " + iosNat.getAbsolutePath());
        File iosSim = new File(projRoot, buildLoc + separator + "Release-iphoneos" + separator + libname);
        if (!iosSim.exists())
            Log.error("Unable to locate library " + iosSim.getAbsolutePath());
        if (!iosNat.exists() && !iosSim.exists())
            throw new RuntimeException("Unable to find any link libraries");
        lib.getParentFile().mkdirs();
        if (!exec(projRoot, Arrays.asList("lipo", "-create", "-output", lib.getAbsolutePath(),
                iosSim.exists() ? iosSim.getAbsolutePath() : null,
                iosNat.exists() ? iosNat.getAbsolutePath() : null)))
            throw new RuntimeException("Unable to link plugin " + plugin);
    }

    private static boolean exec(File cdir, List<String> args) {
        Commander cmd = new Commander(args);
        cmd.setCurrentDir(cdir);
        cmd.setOutListener(Log::debug);
        cmd.setErrListener((Consumer<String>) Log::error);
        Log.debug("Executing: " + cmd.toString());
        cmd.exec();
        cmd.waitFor();
        return cmd.exitValue() == 0;
    }


}
