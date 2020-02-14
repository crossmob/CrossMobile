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
package org.crossmobile.build.xcode;

import com.dd.plist.NSObject;
import org.crossmobile.build.xcode.resources.AnyResource;
import org.crossmobile.build.xcode.resources.FileResource;
import org.crossmobile.build.xcode.resources.GroupResource;
import org.crossmobile.build.xcode.resources.LibResource;
import org.crossmobile.utils.CollectionUtils;
import org.crossmobile.utils.XcodeTarget;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static org.crossmobile.build.tools.InfoPListCreator.getPlist;
import static org.crossmobile.utils.FileUtils.*;

public class XCodeCreator {

    //input
    private final String appName;
    private final Collection<String> headerSearchPath;
    private final File plistDir;
    private final XCodeWrapper wrapper;
    private final String projectType;
    private final File projectPath;
    private String mainGroup;
    private Collection<AnyResource> resources = new ArrayList<>();
    private final File xcodeProject;

    private Collection<String> plistIds = new LinkedHashSet<>();
    private Map<String, String> productRefs = new HashMap<>();
    private Collection<String> buildPhases;
    private Map<String, String> buildConfLists = new LinkedHashMap<>();
    private String productRefGroup;

    public XCodeCreator(String appName, Collection<File> sources, Collection<String> libs, File projectPath, File plistDir, Collection<String> headerSearchPath, String projectType) {
        this.appName = appName;
        this.headerSearchPath = headerSearchPath;
        this.plistDir = plistDir;
        this.projectPath = projectPath;
        this.xcodeProject = new File(projectPath, appName + ".xcodeproj" + File.separator + "project.pbxproj");
        this.xcodeProject.getParentFile().mkdirs();
        this.projectType = projectType;
        this.wrapper = XCodeWrapper.load(xcodeProject.getPath());
        if (wrapper == null)
            throw new NullPointerException("Unable to locate Xcode project at " + xcodeProject.getAbsolutePath());
        addResources(sources, projectPath);
        libs.forEach(lib -> resources.add(new LibResource(lib, wrapper.getNextID())));
    }

    private void addResources(Collection<File> sources, File projectPath) {
        sources.forEach(source -> {
            if (source.isDirectory() && source.getName().endsWith(".lproj"))
                addResources(list(source), projectPath);
            else
                resources.add(new FileResource(source.getName(), source, wrapper.getNextID(), projectPath));
        });
    }

    private void removeOldReferences() {
        wrapper.removeType("PBXFileReference");
        wrapper.removeType("PBXBuildFile");
        wrapper.removeType("PBXVariantGroup");
        wrapper.removeType("PBXResourcesBuildPhase");
        wrapper.removeType("PBXSourcesBuildPhase");
        wrapper.removeType("PBXFrameworksBuildPhase");
        wrapper.removeObjectWithCondition("PBXGroup",
                (PBXObjectCondition<PBXGroup>) object -> object.getName().equals("Application"));
        //Kept to not brake old projects
        wrapper.removeObjectWithCondition("PBXGroup",
                (PBXObjectCondition<PBXGroup>) object -> object.getName().equals("Resources"));
        wrapper.removeObjectWithCondition("PBXGroup",
                (PBXObjectCondition<PBXGroup>) object -> object.getName().equals("Materials"));
        wrapper.removeObjectWithCondition("PBXGroup",
                (PBXObjectCondition<PBXGroup>) object -> object.getName().equals("System"));
        wrapper.removeObjectWithCondition("PBXGroup",
                (PBXObjectCondition<PBXGroup>) object -> object.getName().equals("Products"));
        wrapper.removeObjectWithCondition("PBXGroup", object -> object.id.equals(mainGroup));
    }

    private void addFileReferences() {
        Collection<PBXObject> collection = new ArrayList<>();
        for (AnyResource resource : resources)
            collection.add(resource.fileReference());
        collection.add(registerPlist(appName));
        productRefs.put("", wrapper.getNextID());
        collection.add(new PBXFileReference(productRefs.get(""), NSObject.wrap(appMap())));
        for (XcodeTarget target : XcodeTargetRegistry.getExtraTargets()) {
            productRefs.put(target.name, wrapper.getNextID());
            collection.add(new PBXFileReference(productRefs.get(target.name), NSObject.wrap(appexFileReferenceMap(target.name))));
            collection.add(registerPlist(target.name));
        }
        wrapper.addType("PBXFileReference", collection);
    }

    private void createGroups() {
        String[] list = new String[]{
                createGroup("Application", resources.stream().filter(resource -> resource.family().equals("Sources")).map(AnyResource::getFileref).collect(Collectors.toList()).toArray(new String[]{})),
                createGroup("Materials", resources.stream().filter(resource -> resource.family().equals("Materials")).map(AnyResource::getFileref).collect(Collectors.toList()).toArray(new String[]{})),
                createGroup("System", resources.stream().filter(resource -> resource.family().equals("Frameworks")).map(AnyResource::getFileref).collect(Collectors.toList()).toArray(new String[]{})),
                productRefGroup = createGroup("Products", productRefs.values().toArray(new String[0]))
        };
        PBXGroup systemGroup = (PBXGroup) wrapper.getObjectWithCondition("PBXGroup", (PBXObjectCondition<PBXGroup>) object -> object.getName().equals("System"));
        for (String plistId : plistIds)
            systemGroup.addChild(plistId);
        createGroup(null, list, mainGroup);
    }

    private String createGroup(String name, String[] list) {
        return createGroup(name, list, null);
    }

    private void addLocalizedGroups() {
        Map<String, List<AnyResource>> map = new HashMap<>();
        resources.stream().filter(AnyResource::isLocalized).forEach(r -> map.computeIfAbsent(r.abstractName(), k -> new ArrayList<>()).add(r));
        map.keySet().forEach(abstractName -> {
            String groupReference = wrapper.getNextID();
            GroupResource group;
            resources.add(group = new GroupResource(abstractName, map.get(abstractName), groupReference));
            wrapper.addObject(group.group());
        });
    }

    private String createGroup(String name, String[] list, String id) {
        String groupId;
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXGroup");
        data.put("children", list);
        if (name != null)
            data.put("name", name);
        data.put("sourceTree", "<group>");
        wrapper.addObject(new PBXGroup(groupId = (id == null ? wrapper.getNextID() : id), NSObject.wrap(data)));
        return groupId;
    }

    private String addBuildReference(AnyResource resource) {
        String buildRef = wrapper.getNextID();
        wrapper.addObject(resource.buildFile(buildRef));
        return buildRef;
    }

    private PBXNativeTarget updateMainTarget() {
        PBXNativeTarget nativeTarget = (PBXNativeTarget) wrapper.getObjectWithCondition("PBXNativeTarget",
                (PBXObjectCondition<PBXNativeTarget>) object -> object.productType.equals("com.apple.product-type.application"));
        nativeTarget.setName(appName);
        nativeTarget.setProductName(appName);
        nativeTarget.setProductReference(productRefs.get(""));
        nativeTarget.setBuildPhases(updateTargetBuildPhases(""));
        addCopyTargetsIfNeeded(nativeTarget);
        addDependenciesIfNeeded(nativeTarget);
        buildConfLists.put(nativeTarget.buildConfigurationList, getRelative(projectPath, getPlist(plistDir, appName)));
        return nativeTarget;
    }

    private void addDependenciesIfNeeded(PBXNativeTarget nativeTarget) {
        Collection<PBXNativeTarget> extensions = wrapper.getObjectsWithCondition(PBXNativeTarget.class,
                (PBXObjectCondition<PBXNativeTarget>) object -> object.productType.equals("com.apple.product-type.app-extension"));
        if (extensions.size() > 0) {
            List<String> list = new ArrayList<>();
            for (PBXNativeTarget extension : extensions) list.add(createDependency(extension));
            nativeTarget.setDependencies(list);
        }
    }

    private String createDependency(PBXNativeTarget extension) {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXTargetDependency");
        data.put("target", extension.getId());
        data.put("targetProxy", createItemProxy(extension));
        String id = wrapper.getNextID();
        wrapper.addObject(new PBXAny(id, NSObject.wrap(data)));
        return id;
    }

    private String createItemProxy(PBXNativeTarget extension) {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXContainerItemProxy");
        data.put("containerPortal", ((PBXProject) wrapper.getType("PBXProject").iterator().next()).id);
        data.put("proxyType", "1");
        data.put("remoteGlobalIDString", extension.getId());
        data.put("remoteInfo", extension.getName());
        String id = wrapper.getNextID();
        wrapper.addObject(new PBXAny(id, NSObject.wrap(data)));
        return id;
    }

    private void addCopyTargetsIfNeeded(PBXNativeTarget nativeTarget) {
        if (productRefs.size() > 1) {
            String id;
            PBXBuildPhase copy = new PBXBuildPhase(id = wrapper.getNextID(), NSObject.wrap(copyPhaseMap()));
            copy.setFiles(getAppexBuildRefs());
            wrapper.addObject(copy);
            nativeTarget.addBuildPhase(id);
        }
    }

    private Collection<String> getAppexBuildRefs() {
        List<String> list = new ArrayList<>();
        for (String appex : productRefs.keySet())
            if (!appex.equals("")) {
                String buildRef = wrapper.getNextID();
                wrapper.addObject(new PBXBuildFile(buildRef, NSObject.wrap(appexPBXBuildFileMap(appex, productRefs.get(appex)))));
                list.add(buildRef);
            }
        return list;
    }

    private String updateExtension(Collection<PBXNativeTarget> extensions, String name) {
        PBXNativeTarget extension = CollectionUtils.getWithCondition(extensions, e -> e.getName().equals(name));
        if (extension == null) {
            XCBuildConfiguration release = new XCBuildConfiguration(wrapper.getNextID(), "Release", true, true);
            XCBuildConfiguration debug = new XCBuildConfiguration(wrapper.getNextID(), "Debug", false, true);
            XCConfigurationList configurationList = new XCConfigurationList(wrapper.getNextID(), release, debug);

            extension = new PBXNativeTarget(wrapper.getNextID(), name, configurationList, true);
            extensions.add(extension);

            wrapper.addObject(release);
            wrapper.addObject(debug);
            wrapper.addObject(configurationList);
            wrapper.addObject(extension);
        }
        extension.setBuildPhases(updateTargetBuildPhases(extension.getName()));
        extension.setProductReference(productRefs.get(name));
        return extension.getId();
    }

    private List<String> updateTargets() {
        List<String> list = new ArrayList<>();
        Collection<PBXNativeTarget> extensions = wrapper.getObjectsWithCondition(PBXNativeTarget.class,
                (PBXObjectCondition<PBXNativeTarget>) object -> object.productType.equals("com.apple.product-type.app-extension"));
        // Remove unused extension targets
        for (PBXNativeTarget extension : extensions)
            if (!XcodeTargetRegistry.hasTarget(extension.getName()))
                wrapper.removeObject("PBXNativeTarget", extension);
        // Create target List
        for (XcodeTarget target : XcodeTargetRegistry.getExtraTargets()) {
            list.add(updateExtension(extensions, target.name));
            for (PBXNativeTarget extTarget : extensions)
                buildConfLists.put(extTarget.buildConfigurationList, getRelative(projectPath, getPlist(plistDir, extTarget.getName())));
        }
        list.add(updateMainTarget().id);
        return list;
    }

    public void updateProject() {
        PBXProject project = (PBXProject) wrapper.getType("PBXProject").iterator().next();
        removeOldReferences();
        addFileReferences();
        // Must be after addFileReferences and before addBuildReference
        addLocalizedGroups();
        mainGroup = project.getMainGroup();
        project.setTargets(updateTargets());
        createGroups();
        project.setProductRefGroup(productRefGroup);
        updateBuildConfigurations();
        //xcodeProject.setKnownRegions(knownregions);
        wrapper.save(this.xcodeProject);
    }

    private void updateBuildConfigurations() {
        for (String configurationList : buildConfLists.keySet()) {
            PBXObject buildConfList = wrapper.getObjectWithID(configurationList);
            if (buildConfList != null)
                for (String buildConfiguration : ((XCConfigurationList) buildConfList).buildConfigurations) {
                    XCBuildConfiguration bc = (XCBuildConfiguration) wrapper.getObjectWithID(buildConfiguration);
                    bc.putToBuildSettings("HEADER_SEARCH_PATHS", headerSearchPath.toArray());
                    bc.putToBuildSettings("INFOPLIST_FILE", "$(SRCROOT)/" + buildConfLists.get(configurationList));
                    bc.putToBuildSettings("TARGETED_DEVICE_FAMILY", projectType);
                }
        }
    }

    private List<String> updateTargetBuildPhases(String target) {
        String resID = wrapper.getNextID();
        PBXBuildPhase res = new PBXBuildPhase(resID, NSObject.wrap(buildPhaseMap("PBXResourcesBuildPhase")));
        res.setFiles(resources.stream().
                filter(resource -> resource.family().equals("Materials") && resource.isBuildable() && resource.belongsToTarget(target)).
                map(this::addBuildReference).collect(Collectors.toList()));

        String sourceID = wrapper.getNextID();
        PBXBuildPhase sources = new PBXBuildPhase(sourceID, NSObject.wrap(buildPhaseMap("PBXSourcesBuildPhase")));
        sources.setFiles(resources.stream().
                filter(resource -> resource.family().equals("Sources") && resource.isBuildable() && resource.belongsToTarget(target)).
                map(this::addBuildReference).collect(Collectors.toList()));

        String frameworksID = wrapper.getNextID();
        PBXBuildPhase framework = new PBXBuildPhase(frameworksID, NSObject.wrap(buildPhaseMap("PBXFrameworksBuildPhase")));
        framework.setFiles(resources.stream().
                filter(resource -> resource.family().equals("Frameworks") && resource.isBuildable() && resource.belongsToTarget(target)).
                map(this::addBuildReference).collect(Collectors.toList()));

        wrapper.addObject(res);
        wrapper.addObject(sources);
        wrapper.addObject(framework);

        // Needs to be mutable
        return new ArrayList<>(Arrays.asList(resID, sourceID, frameworksID));
    }

    private Map<String, Object> buildPhaseMap(String isa) {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", isa);
        data.put("buildActionMask", "2147483647");
        data.put("files", new ArrayList<>());
        data.put("runOnlyForDeploymentPostprocessing", "0");
        return data;
    }

    private Map<String, Object> copyPhaseMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXCopyFilesBuildPhase");
        data.put("buildActionMask", "2147483647");
        data.put("dstPath", "");
        data.put("dstSubfolderSpec", "13");
        data.put("files", new ArrayList<>());
        data.put("name", "Embed App Extensions");
        data.put("runOnlyForDeploymentPostprocessing", "0");
        return data;
    }

    private Map<String, Object> appMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXFileReference");
        data.put("explicitFileType", "wrapper.application");
        data.put("includeInIndex", "0");
        data.put("path", appName.toLowerCase() + ".app");
        data.put("sourceTree", "BUILT_PRODUCTS_DIR");
        return data;
    }

    private Map<String, Object> appexFileReferenceMap(String name) {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXFileReference");
        data.put("explicitFileType", "wrapper.app-extension");
        data.put("includeInIndex", "0");
        data.put("path", name.toLowerCase() + ".appex");
        data.put("sourceTree", "BUILT_PRODUCTS_DIR");
        return data;
    }

    private Map<String, Object> appexPBXBuildFileMap(String name, String fileRef) {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXBuildFile");
        data.put("fileRef", fileRef);
        Map<String, Object> map = new HashMap<>();
        map.put("ATTRIBUTES", Collections.singletonList("RemoveHeadersOnCopy"));
        data.put("settings", NSObject.wrap(map));
        return data;
    }


    private Map<String, Object> plistMap(File plist) {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXFileReference");
        data.put("fileEncoding", "4");
        data.put("lastKnownFileType", "text.plist.xml");
        data.put("name", plist.getName());
        data.put("path", getRelative(projectPath, plist));
        data.put("sourceTree", "<group>");
        return data;
    }

    private PBXFileReference registerPlist(String name) {
        String nextId = wrapper.getNextID();
        plistIds.add(nextId);
        return new PBXFileReference(nextId, NSObject.wrap(plistMap(getPlist(plistDir, name))));
    }
}
