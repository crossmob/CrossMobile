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

import com.dd.plist.NSDictionary;

import static org.crossmobile.build.utils.PlistUtils.getPath;
import static org.crossmobile.build.utils.PlistUtils.getStringMaybe;

public class PBXFileReference extends PBXObject {

    private final String explicitFileType;
    private final String includeInIndex;
    private final String path;
    private final String sourceTree;
    private final String fileEncoding;
    private final String lastKnownFileType;
    private final String name;

    public PBXFileReference(String id, NSDictionary data) {
        super(id, data);
        this.path = getPath(data, "path").toString();
        this.sourceTree = getPath(data, "sourceTree").toString();
        this.explicitFileType = getStringMaybe(getPath(data, "explicitFileType"));
        this.includeInIndex = getStringMaybe(getPath(data, "includeInIndex"));
        this.fileEncoding = getStringMaybe(getPath(data, "fileEncoding"));
        this.lastKnownFileType = getStringMaybe(getPath(data, "lastKnownFileType"));
        this.name = getStringMaybe(getPath(data, "name"));
    }

    @Override
    public String toString() {
        return id + " PBXFileReference"
                + (path == null ? "" : " path=" + path)
                + (name == null ? "" : " name=" + name)
                + (explicitFileType == null ? "" : " explicitFileType=" + explicitFileType)
                + (lastKnownFileType == null ? "" : " lastKnownFileType=" + lastKnownFileType)
                + (sourceTree == null ? "" : " sourceTree=" + sourceTree)
                + (fileEncoding == null ? "" : " fileEncoding=" + fileEncoding)
                + (includeInIndex == null ? "" : " includeInIndex=" + includeInIndex);
    }

    @Override
    public NSDictionary getData() {
        NSDictionary data = new NSDictionary();
        data.put("isa", isa);
        if (path != null)
            data.put("path", path);
        if (sourceTree != null)
            data.put("sourceTree", sourceTree);
        if (explicitFileType != null)
            data.put("explicitFileType", explicitFileType);
        if (includeInIndex != null)
            data.put("includeInIndex", includeInIndex);
        if (fileEncoding != null)
            data.put("fileEncoding", fileEncoding);
        if (lastKnownFileType != null)
            data.put("lastKnownFileType", lastKnownFileType);
        if (name != null)
            data.put("name", name);
        return data;
    }

}
