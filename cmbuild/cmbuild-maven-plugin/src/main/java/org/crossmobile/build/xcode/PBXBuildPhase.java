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

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;

import java.util.Collection;

import static org.crossmobile.build.utils.PlistUtils.arrayToCollection;
import static org.crossmobile.build.utils.PlistUtils.getPath;

public class PBXBuildPhase extends PBXAny {

    private Collection<String> files;

    public PBXBuildPhase(String id, NSDictionary data) {
        super(id, data);
        files = arrayToCollection((NSArray) getPath(data, "files"));
    }

    @Override
    public String toString() {
        return id + " PBXBuildPhase{"
                + getData()
                + ", files=" + files
                + '}';
    }

    public void setFiles(Collection<String> files) {
        this.files = files;
    }

    @Override
    public NSDictionary getData() {
        data.put("files", NSObject.wrap(files.toArray()));
        return data;
    }
}
