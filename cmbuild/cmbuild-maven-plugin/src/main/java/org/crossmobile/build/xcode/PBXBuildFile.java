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
import com.dd.plist.NSObject;

import static org.crossmobile.build.utils.PlistUtils.getPath;

public class PBXBuildFile extends PBXObject {

    private final String fileRef;
    private final NSObject settings;

    public PBXBuildFile(String id, NSDictionary data) {
        super(id, data);
        this.fileRef = getPath(data, "fileRef").toString();
        this.settings = getPath(data, "settings");
//        this.weak = containsElement((NSArray) getPath(data, "settings", "ATTRIBUTES"), "Weak");
    }

    @Override
    public String toString() {
        return id + " PBXBuildFile " + fileRef;
    }

    @Override
    public NSDictionary getData() {
        NSDictionary data = new NSDictionary();
        data.put("isa", isa);
        data.put("fileRef", fileRef);
        data.put("settings", settings);
        return data;
    }

}
