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
import org.crossmobile.build.xcode.PBXBuildFile;
import org.crossmobile.build.xcode.PBXFileReference;
import org.crossmobile.utils.XcodeTarget;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LibResource extends AnyResource {

    private final String filetype;
    private final boolean weak;
    private final String name;
    private final String path;
    private final boolean inSDK;

    public LibResource(String name, String fileref) {
        super(name, fileref);
        weak = name.endsWith("~");
        if (weak)
            name = name.substring(0, name.length() - 1);

        if (name.contains("/")) {
            File flib = new File(name);
            this.name = flib.getName();
            this.path = flib.getPath();
            this.inSDK = false;
        } else {
            this.name = name;
            path = name.toLowerCase().endsWith(".framework")
                    ? "System/Library/Frameworks/" + this.name
                    : "usr/lib/" + this.name;
            this.inSDK = true;
        }
        this.filetype = getFileType();
    }

    private String getFileType() {
        String lcase = name.toLowerCase();
        if (lcase.endsWith(".framework"))
            return "wrapper.framework";
        else if (lcase.endsWith(".dylib"))
            return "\"compiled.mach-o.dylib\"";
        else if (lcase.endsWith(".o"))
            return "\"compiled.mach-o.objfile\"";
        else if (lcase.endsWith(".a"))
            return "archive.ar";
        else
            return "file";
    }

    @Override
    public String family() {
        return "Frameworks";
    }

    @Override
    protected String filetype() {
        return filetype;
    }

    private Map<String, Object> buildSettings() {
        Map<String, Object> data = new HashMap<>();
        data.put("ATTRIBUTES", new String[]{"Weak"});
        return data;
    }

    @Override
    protected boolean isText() {
        return false;
    }

    @Override
    protected boolean isInSDK() {
        return inSDK;
    }

    @Override
    protected Map<String, Object> dataMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXFileReference");
        data.put("lastKnownFileType", filetype);
        data.put("name", name);
        data.put("path", path);
        data.put("sourceTree", inSDK ? "SDKROOT" : "<group>");
        return data;
    }

    @Override
    public PBXFileReference fileReference() {
        return new PBXFileReference(getFileref(), NSObject.wrap(dataMap()));
    }

    @Override
    public PBXBuildFile buildFile(String ref) {
        Map<String, Object> data = buildMap();
        if (weak)
            data.put("settings", buildSettings());
        return new PBXBuildFile(ref, NSObject.wrap(data));
    }

    @Override
    protected boolean belongsToTarget(String resourceName, XcodeTarget target) {
        return true;
    }

    @Override
    public int hashCode() {
        return 37 + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final LibResource other = (LibResource) obj;
        return other.name.equals(this.name);
    }

}
