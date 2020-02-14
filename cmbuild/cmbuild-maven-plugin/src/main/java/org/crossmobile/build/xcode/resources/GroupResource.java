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
import org.crossmobile.build.xcode.*;
import org.crossmobile.utils.XcodeTarget;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GroupResource extends AnyResource {

    private String[] filerRefs;

    public GroupResource(String name, Collection<AnyResource> resources, String fileref) {
        super(name, null, fileref);
        Objects.requireNonNull(resources, "Grouped resources can be empty but not null");
        filerRefs = resources.stream().map(AnyResource::getFileref).distinct().toArray(String[]::new);
    }

    @Override
    public String family() {
        return "Materials";
    }

    @Override
    protected String filetype() {
        return null;
    }

    @Override
    protected boolean isText() {
        return false;
    }

    @Override
    protected boolean isInSDK() {
        return false;
    }

    @Override
    public boolean isBuildable() {
        return true;
    }

    @Override
    protected Map<String, Object> dataMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("isa", "PBXVariantGroup");
        data.put("children", filerRefs);
        data.put("name", name());
        data.put("sourceTree", "<group>");
        return data;
    }

    @Override
    public PBXFileReference fileReference() {
        return null;
    }

    public PBXGroup group() {
        return new PBXGroup(getFileref(), NSObject.wrap(dataMap()));
    }

    @Override
    public PBXBuildFile buildFile(String ref) {
        return new PBXBuildFile(ref, NSObject.wrap(buildMap()));
    }

    @Override
    protected boolean belongsToTarget(String resourceName, XcodeTarget target) {
        return XcodeTargetRegistry.materialBelongsToTarget(resourceName, target);
    }
}
