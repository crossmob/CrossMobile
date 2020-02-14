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

import difflib.DiffUtils;
import difflib.Patch;
import difflib.PatchFailedException;
import org.crossmobile.build.ArtifactInfo;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.objc.ReverseImportRegistry;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.reg.Plugin;
import org.crossmobile.utils.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.io.File.separator;
import static org.crossmobile.build.utils.PlistUtils.isInclude;
import static org.crossmobile.plugin.reg.PluginRegistry.getPlugin;
import static org.crossmobile.plugin.reg.TypeRegistry.isReference;
import static org.crossmobile.plugin.utils.Templates.LIB_DEF;
import static org.crossmobile.utils.NamingUtils.toObjC;
import static org.crossmobile.plugin.utils.Texters.toObjCTypeForLibDef;
import static org.crossmobile.utils.FileUtils.*;
import static org.crossmobile.utils.TimeUtils.time;

public class CreateDll extends CreateLib {

    public CreateDll(Function<ArtifactInfo, File> resolver, File target, File cache, File vendor, File IDELocation, ReverseImportRegistry handleRegistry, boolean build) throws IOException {
        super(resolver, target, cache, vendor, IDELocation, handleRegistry, false, build);
    }

    @Override
    protected void runEmitters(Function<String, File> prodResolv, AtomicBoolean hasSwift) throws IOException {
        emitPlatformFiles(prodResolv, false, hasSwift);
        emitIncludeHeaders(prodResolv, hasSwift);
        libDef(prodResolv);
    }

    private static Collection<File> getHeaders(Collection<File> includes) {
        Collection<File> headers = new LinkedHashSet<>();
        includes.forEach(include -> forAll(include, f -> (isInclude(f.getName()) && !f.getParent().contains("uwpinclude")), (p, f) -> headers.add(f)));
        return headers;
    }


    private static Collection<String> getHeaderPaths(Collection<File> includes, String plugin) {
        Set<String> headerpaths = new HashSet<>();
        includes.forEach(include -> {
            if (include.isDirectory()
                    && (include.getPath().endsWith(plugin + separator + PLATFORM.apply(false))
                    || include.getName().endsWith(plugin)))
                headerpaths.add(include.getPath());
            else if (include.isDirectory())
                Arrays.stream(include.listFiles())
                        .filter(p -> p.isDirectory() && p.getName().endsWith("uwpinclude"))
                        .forEach(i -> headerpaths.add(i.getPath()));
        });
        return headerpaths;
    }

    @Override
    protected Collection<File> getCompiled(File cached, File vendorFiles, File src) {
        Collection<File> compiled = super.getCompiled(cached, vendorFiles, src);
        compiled.forEach(f -> {
            File out = new File(src, f.getName());
            if (!out.exists())
                try {
                    Files.copy(f.toPath(), out.toPath());
                } catch (IOException e) {
                }
        });
        return compiled;
    }

    private static void emitIncludeHeaders(Function<String, File> prodResolv, AtomicBoolean hasSwift) throws IOException {
        objectEmitter(prodResolv, true, hasSwift);
    }

    private static void libDef(Function<String, File> prodResolv) {
        for (NObject obj : ObjectRegistry.retrieveAll()) {
            String plugin = getPlugin(obj.getType().getName());
            if (plugin != null) {
                StringBuilder builder = new StringBuilder();
                File pluginRoot = prodResolv.apply(plugin);
                File libdef = new File(pluginRoot, "lib.def");
                StandardOpenOption openOption = StandardOpenOption.APPEND;
                if (!libdef.exists()) {
                    builder.append("LIBRARY ").append(plugin).append("\n")
                            .append("EXPORTS\n").append("\n");
                    if (plugin.equals("cmioslayer"))
                        builder.append(LIB_DEF).append("\n").append("\n");
                    openOption = StandardOpenOption.CREATE;
                }
                if (obj.isCBased())
                    builder.append("\t").append("_OBJC_CLASS_").append(toObjCTypeForLibDef(obj.getType()).replaceAll("\\*", "")).append(" ").append("DATA").append("\n")
                            .append("\t").append("__objc_class_name_").append(toObjCTypeForLibDef(obj.getType()).replaceAll("\\*", "")).append(" ").append("CONSTANT").append("\n");
                if (obj.isStruct())
                    for (Field f : obj.getType().getFields()) {
                        String fieldName = toObjC(f.getType());
                        builder.append("\t").append("__objc_ivar_offset_").append(toObjCTypeForLibDef(obj.getType()).replaceAll("\\*", "")).append(".").append(f.getName()).append("_").append(fieldName).append("\n");
                    }
                else if (obj.isCBased() && obj.isReference() && (obj.isStruct() || (obj.isReference() && !isReference(obj.getType().getSuperclass()))))
                    builder.append("\t").append("__objc_ivar_offset_").append(toObjCTypeForLibDef(obj.getType()).replaceAll("\\*", "")).append(".$reference").append("\n");
                if (!obj.isProtocol() && obj.needsOverrideBindings())
                    builder.append("\t").append("_OBJC_CLASS_").append(toObjCTypeForLibDef(obj.getType()).replaceAll("\\*", "")).append("$Ext").append(" ").append("DATA").append("\n")
                            .append("\t").append("__objc_class_name_").append(toObjCTypeForLibDef(obj.getType()).replaceAll("\\*", "")).append("$Ext").append(" ").append("CONSTANT").append("\n");
                try {
                    Files.write(libdef.toPath(), builder.toString().getBytes(), openOption);
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    @Override
    protected File createProj(File target, String plugin) {
        File projTarget = new File(target, PLATFORM.apply(false) + separator + plugin);
        if (!projTarget.mkdirs() && !projTarget.exists())
            throw new RuntimeException("Unable to create project directories");

        String token = updateSolution(projTarget, plugin);
        renameAndCopy("packages.config", projTarget, "packages.config");
        renameAndCopy("pch.h", projTarget, "pch.h");
        renameAndCopy("pch.cpp", projTarget, "pch.cpp");
        renameAndCopy("targetver.h", projTarget, "targetver.h");

        findAndReplace(LIB_ANCHOR, plugin, "org/crossmobile/plugin/" + LIB_ANCHOR + ".h", new File(projTarget, plugin + ".h"));
        findAndReplace(LIB_ANCHOR, plugin, "org/crossmobile/plugin/" + LIB_ANCHOR + ".cpp", new File(projTarget, plugin + ".cpp"));
        File project;
        findAndReplace(LIB_ANCHOR, plugin, "org/crossmobile/plugin/" + LIB_ANCHOR + ".vcxproj", project = new File(projTarget, plugin + ".vcxproj"));
        updateProjectToken(project, token);

        restoreNuget(projTarget.getParentFile());
        return project;
    }

    private static void restoreNuget(File solutionDir) {
        if (new File(solutionDir, "packages").exists())
            return;
        time(() -> {
            Commander cmd = new Commander("nuget", "restore");
            cmd.setCurrentDir(solutionDir);
            cmd.setOutListener(Log::debug);
            cmd.setErrListener((Consumer<String>) Log::error);
            cmd.exec();
            cmd.waitFor();
            applyPatches(solutionDir.getParentFile().getParentFile(), new File(solutionDir, "packages"));
        }, "Restoring NuGets  ");
    }

    private static void updateProjectToken(File project, String token) {
        XMLWalker walker = XMLWalker.load(project);
        walker.path("/Project/PropertyGroup/ProjectGuid").setText("{" + token + "}");
        walker.store(project, true);
    }

    @Override
    protected void updateProj(File project, Plugin plugin, Collection<File> includes, Collection<File> headerSearchPaths, Collection<File> sources, Collection<String> deps, boolean hasSwift) {
        Collection<String> headerPaths = getHeaderPaths(headerSearchPaths, plugin.getName());
        Collection<String> headers = getHeaderPaths(includes, plugin.getName());
        XMLWalker walker = XMLWalker.load(project);
        walker.node("Project").tag("root").nodes("ItemGroup", xmlWalker -> {
            if (xmlWalker.nodeExists("ClInclude"))
                xmlWalker.remove();
            if (xmlWalker.nodeExists("ClangCompile"))
                walker.remove();
        }).toTag("root").add("ItemGroup")
                //                .exec(xmlWalker -> headers.stream().forEach(
                //                header -> xmlWalker.add("ClInclude").setAttribute("Include", header.getName()).parent()))
                .add("ClInclude").setAttribute("Include", plugin + ".h").parent()
                .add("ClInclude").setAttribute("Include", "pch.h").parent()
                .add("ClInclude").setAttribute("Include", "targetver.h")
                .parent()
                .exec(xmlWalker -> getHeaders(includes).forEach(
                        header -> xmlWalker.add("ClInclude").setAttribute("Include", header.getPath()).parent()))
                .toTag("root").add("ItemGroup").exec(xmlWalker -> sources.stream().forEach(
                source -> xmlWalker.add("ClangCompile").setAttribute("Include", source.getPath()).parent()))
                .toTag("root").nodes("ItemDefinitionGroup", n -> n.nodes("ClCompile", c -> {
            if (c.nodeExists("AdditionalIncludeDirectories"))
                c.node("AdditionalIncludeDirectories");
            else
                c.add("AdditionalIncludeDirectories");
            StringBuilder text = new StringBuilder();
            for (String path : headerPaths)
                text.append(path).append(";");
            for (String path : headers)
                text.append(path).append(";");
            text.append("%(AdditionalIncludeDirectories)");
            c.setText(text.toString());
        })).toTag("root").nodes("ItemDefinitionGroup", n -> n.nodes("Link", l -> {
            if (l.nodeExists("AdditionalDependencies"))
                l.node("AdditionalDependencies");
            else
                l.add("AdditionalDependencies");
            StringBuilder text = new StringBuilder("libGLESv2.lib;libEGL.lib;");
            for (String path : deps)
                text.append("..").append(separator).append("..").append(separator).append("..").append(separator).append("gen").append(separator).append("lib").append(separator).append("lib").append(path).append(".lib").append(";");
            text.append("%(AdditionalDependencies)");
            l.setText(text.toString());
        }));
        walker.store(project, true);
    }

    private static String updateSolution(File projTarget, String plugin) {

        File solution = new File(projTarget.getParentFile(), PLATFORM.apply(false) + ".sln");
        if (!solution.exists())
            renameAndCopy("CMPLUGIN.sln", projTarget.getParentFile(), PLATFORM.apply(false) + ".sln");

        final List<String> list;
        try (Stream<String> lines = Files.lines(solution.toPath())) {
            list = lines.collect(Collectors.toList());

            for (String line : list)
                if (line.contains(plugin)) {
                    String token = line.split(",")[line.split(",").length - 1].trim();
                    return token.substring(2, token.lastIndexOf('}'));
                }

            int index = 0;
            for (String line : list)
                if (line.contains("GlobalSection(ProjectConfigurationPlatforms) = postSolution")) {
                    index = list.indexOf(line);
                    break;
                }
            index++;

            String guid = getGUID(plugin);
            String projectConfigurationPlatforms
                    = "\t\t{TOKEN}.Debug|ARM.ActiveCfg = Debug|ARM\n"
                    + "\t\t{TOKEN}.Debug|ARM.Build.0 = Debug|ARM\n"
                    + "\t\t{TOKEN}.Debug|Win32.ActiveCfg = Debug|Win32\n"
                    + "\t\t{TOKEN}.Debug|Win32.Build.0 = Debug|Win32\n"
                    + "\t\t{TOKEN}.Release|ARM.ActiveCfg = Release|ARM\n"
                    + "\t\t{TOKEN}.Release|ARM.Build.0 = Release|ARM\n"
                    + "\t\t{TOKEN}.Release|Win32.ActiveCfg = Release|Win32\n"
                    + "\t\t{TOKEN}.Release|Win32.Build.0 = Release|Win32";
            list.add(index, projectConfigurationPlatforms.replaceAll("TOKEN", guid));
            list.add(list.size(), "Project(\"{8BC9CEB8-8B4A-11D0-8D11-00A0C91BC942}\") = \"" + plugin + "\", \"" + plugin + "\\" + plugin + ".vcxproj\", \"{" + guid + "}\"");
//            if (deps.size() > 0) {
//                list.add(list.size(), "ProjectSection(ProjectDependencies) = postProject\n");
//                deps.forEach(dep -> {
//                    String token = getGUID(dep);
//                    list.add(list.size(), "{" + token + "} = {" + token + "}");
//                });
//            }
            list.add(list.size(), "EndProject");

            Files.write(solution.toPath(), list);
            return guid;
        } catch (IOException e) {

        }
        return null;
    }

    private static String getGUID(String plugin) {
        String source = "crossmobile.ios" + plugin;
        byte[] bytes = new byte[0];
        bytes = source.getBytes(StandardCharsets.UTF_8);
        UUID guid = UUID.nameUUIDFromBytes(bytes);
        return guid.toString();
    }

    private static void renameAndCopy(String origin, File targetFile, String destination) {
        try {
            copyResource("org/crossmobile/plugin/" + origin, new File(targetFile, destination).getPath());
        } catch (ProjectException e) {
            throw new RuntimeException("Unable to copy resource " + destination);
        }
    }

    private static void findAndReplace(String find, String replace, String resource, File output) {
        String project = readResourceSafe(resource);
        if (project == null)
            throw new RuntimeException("Unable to retrieve project template");
        project = project.replaceAll(find, replace);
//        Log.debug("Creating recourse " + output.getName());
        if (write(output, project) == null)
            throw new RuntimeException("Unable to store project file");
    }

    public static void cleanSolution(File solution, File IDELocation) {
        msbuild(solution, "clean", IDELocation);
    }

    @Override
    protected void compile(File project, File IDELocation, Plugin plugin, String libname) {
        msbuild(project, "build", IDELocation);
    }

    private static void msbuild(File project, String action, File IDELocation) {
        Commander cmd = new Commander("CMD.exe", "/C", "vcvars32.bat", "&&",
                "msbuild", project.getAbsolutePath(), "/m",
                "/t:" + action, "/p:Configuration=Debug",
                "/p:Platform=Win32");
        cmd.setCurrentDir(IDELocation);
        cmd.setOutListener(message -> {
            if (message.contains("Build succeeded"))
                Log.info(project.getName() + " " + message);
            if (message.contains("Build FAILED"))
                Log.error(project.getName() + " " + message);
            if (message.contains("fatal error "))
                throw new RuntimeException(message);
            if (message.contains("error "))
                Log.error(message);
        });
        cmd.setErrListener(message -> {
            if (message.contains("error"))
                Log.error(message);
        });
        System.out.println(cmd.toString());
        cmd.exec();
        cmd.waitFor();
    }

    // Helper method for get the file content
    private static List fileToLines(File file) {
        if (!file.exists())
            return Collections.EMPTY_LIST;
        List lines = new LinkedList();
        String line = "";
        if (!file.exists()) {
            Log.error("When creating DLL, file " + file.getAbsolutePath() + " does not exist");
            return Collections.emptyList();
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            while ((line = in.readLine()) != null)
                lines.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String... args) {
//        applyPatches(new File("/Users/arktouros/crossmobile/cmioslayer/patches"));

        new File("/Users/arktouros/crossmobile/cmioslayer/", "patches").delete();
        String root = "/Users/arktouros/crossmobile/cmioslayer/target/uwp/packages/";
        Map<String, String> map = new HashMap<>();
        map.put("include/LocalAuthentication/LAContext.h", "WinObjC.Frameworks.0.2.180220/build/");
        map.put("include/UIKit/UINavigationBar.h", "WinObjC.Frameworks.0.2.180220/build/");
        map.put("include/UIKit/UIPageControl.h", "WinObjC.Frameworks.0.2.180220/build/");
        map.put("include/UIKit/UIView.h", "WinObjC.Frameworks.0.2.180220/build/");
        map.put("include/UIKit/UIViewController.h", "WinObjC.Frameworks.0.2.180220/build/");
        map.put("include/Foundation/NSURLSession.h", "WinObjC.Frameworks.Core.0.2.180220/build/");
        createDiff(root, map);

    }


    private static void applyPatches(File dir, File packages) {
        if (dir.listFiles() == null || dir.listFiles().length == 0)
            return;
        File patchDir = new File(dir, "patches");
        if (patchDir.listFiles() == null || patchDir.listFiles().length == 0)
            return;
        Map<String, File> patchMap = new HashMap<>();
        for (File patch : patchDir.listFiles())
            if (patch.getName().endsWith(".diff")) {
                Patch p = DiffUtils.parseUnifiedDiff(fileToLines(patch));
                try {
                    File out;
                    List<String> result = p.applyTo(fileToLines(out = new File(packages, patch.getName().replace("_", "/").replace(".diff", ""))));
                    linestoFile(result, out);
                } catch (PatchFailedException e) {
                    Log.error("PatchFailedException: Incorrect Chunk: the chunk content doesn't match the target : " + patch.getName());
                }
            }
    }

    private static void createDiff(String root, Map<String, String> map) {
        for (String item : map.keySet()) {
            String from = root + map.get(item) + item;
            String to = root + item;
            String filename = (map.get(item) + item).replaceAll("/", "_");

            List<String> original = fileToLines(new File(from));
            List<String> revised = fileToLines(new File(to));

            // Compute diff. Get the Patch object. Patch is the container for computed deltas.
            Patch patch;
            patch = DiffUtils.diff(original, revised);
            List list = DiffUtils.generateUnifiedDiff(from.substring(from.lastIndexOf(".") + 1), to.substring(to.lastIndexOf(".") + 1), original, patch, 0);
            if (!list.isEmpty())
                linestoFile(list, new File("/Users/arktouros/crossmobile/cmioslayer/patches", filename + ".diff"));
        }
    }

    private static void linestoFile(List<String> list, File file) {
        StringBuilder tofile = new StringBuilder();
        list.forEach(line -> {
            tofile.append(line).append("\n");
        });
        file.getParentFile().mkdirs();
        FileUtils.write(file, tofile.toString());
    }

}
