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
package org.crossmobile.build.xcode.resources;

import com.dd.plist.NSObject;
import org.crossmobile.build.ib.i18n.LocalizedType;
import org.crossmobile.build.xcode.PBXBuildFile;
import org.crossmobile.build.xcode.PBXFileReference;
import org.crossmobile.build.xcode.XcodeTargetRegistry;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.XcodeTarget;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileResource extends AnyResource {

    private static final HashMap<String, String> sourcefiles;
    private static final HashMap<String, String> hiddensourcefiles;
    private static final HashMap<String, String> knownbinaryfiles;
    private static final HashMap<String, String> knowntextfiles;

    static {
        sourcefiles = new HashMap<>();
        sourcefiles.put("c", "sourcecode.c.c");
        sourcefiles.put("m", "sourcecode.c.objc");
        sourcefiles.put("mm", "sourcecode.cpp.objcpp");
        sourcefiles.put("c++", "sourcecode.cpp.cpp");
        sourcefiles.put("cpp", "sourcecode.cpp.cpp");
        sourcefiles.put("swift", "sourcecode.swift");

        hiddensourcefiles = new HashMap<>();
        hiddensourcefiles.put("h", "sourcecode.c.h");

        knownbinaryfiles = new HashMap<>();
        knownbinaryfiles.put("png", "image.png");
        knownbinaryfiles.put("mp3", "audio.mp3");
        knownbinaryfiles.put("wav", "audio.wav");

        knowntextfiles = new HashMap<>();
        knowntextfiles.put("txt", "text");
        knowntextfiles.put("strings", "text.plist.strings");
        knowntextfiles.put("storyboard", "file.storyboard");
    }

    private final boolean isSource;
    private final boolean isBuildable;
    private final String filetype;
    private final boolean isText;
    private final boolean isLocalized;

    public FileResource(String fname, File fpath, String fileref, File projectPath) {
        super(FileUtils.getRelative(projectPath, fpath), fileref);
        int point = fname.lastIndexOf(".");
        String ext = point < 0 ? "" : fname.substring(point + 1);
        if (fpath.isDirectory() && fname.contains(".xcassets")) {
            isSource = false;
            isBuildable = true;
            filetype = "folder.assetcatalog";
            isText = false;
            isLocalized = false;
        } else if (fpath.isDirectory() && LocalizedType.getLocalized(fpath, projectPath) != null) {
            isSource = false;
            isBuildable = true;
            filetype = "";
            isLocalized = true;
            isText = false;
        } else if (fpath.isDirectory()) {
            isSource = false;
            isBuildable = true;
            filetype = "folder";
            isLocalized = false;
            isText = false;
        } else if (LocalizedType.getLocalized(fpath, projectPath) != null) {
            isSource = false;
            isBuildable = false;
            filetype = sourcefiles.get(ext);
            isLocalized = true;
            isText = true;
        } else if (sourcefiles.containsKey(ext)) {
            isSource = true;
            isBuildable = true;
            filetype = sourcefiles.get(ext);
            isLocalized = false;
            isText = true;
        } else if (hiddensourcefiles.containsKey(ext)) {
            isSource = true;
            isBuildable = false;
            filetype = hiddensourcefiles.get(ext);
            isLocalized = false;
            isText = true;
        } else if (knownbinaryfiles.containsKey(ext)) {
            isSource = false;
            isBuildable = true;
            filetype = knownbinaryfiles.get(ext);
            isLocalized = false;
            isText = false;
        } else if (knowntextfiles.containsKey(ext)) {
            isSource = false;
            isBuildable = true;
            filetype = knowntextfiles.get(ext);
            isLocalized = false;
            isText = true;
        } else {
            isSource = false;
            isBuildable = true;
            filetype = "file";
            isLocalized = false;
            isText = false;
        }
    }

    @Override
    public String family() {
        return isLocalized ? "Localized" : isSource ? "Sources" : "Materials";
    }

    @Override
    protected String filetype() {
        return filetype;
    }

    @Override
    protected boolean isText() {
        return isText;
    }

    @Override
    protected boolean isInSDK() {
        return false;
    }

    @Override
    protected Map<String, Object> dataMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXFileReference");
        data.put("fileEncoding", isSource ? "4" : null);
        data.put("lastKnownFileType", filetype);
        data.put("name", name());
        data.put("path", path());
        data.put("sourceTree", "<group>");
        return data;
    }

    @Override
    public boolean isBuildable() {
        return isBuildable;
    }

    @Override
    public boolean isLocalized() {
        return isLocalized;
    }

    @Override
    public PBXFileReference fileReference() {
        return new PBXFileReference(getFileref(), NSObject.wrap(dataMap()));
    }

    @Override
    public PBXBuildFile buildFile(String ref) {
        return isBuildable ? new PBXBuildFile(ref, NSObject.wrap(buildMap())) : null;
    }

    @Override
    protected boolean belongsToTarget(String resourceName, XcodeTarget target) {
        return isSource
                ? XcodeTargetRegistry.classBelongsToTarget(resourceName.replace('.', '_'), target)
                : XcodeTargetRegistry.materialBelongsToTarget(resourceName, target);
    }
}
