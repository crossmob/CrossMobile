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

public abstract class PBXObject {

    public final String id;
    public final String isa;

    public PBXObject(String id, NSDictionary data) {
        this.id = id;
        this.isa = getPath(data, "isa").toString();
    }

    public abstract NSDictionary getData();

    public String getId() {
        return id;
    }
}
