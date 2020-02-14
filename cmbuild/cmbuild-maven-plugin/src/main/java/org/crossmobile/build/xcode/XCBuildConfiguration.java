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

import java.util.Collection;
import java.util.Map;

import static org.crossmobile.build.utils.PlistUtils.getPath;

public class XCBuildConfiguration extends PBXAny {

    private final Map<String, Object> buildSettings;
    public final String name;

    public XCBuildConfiguration(String id, String name, boolean release, boolean module) {
        this(id, getConfigurationData(name, release, module));
    }

    public XCBuildConfiguration(String id, NSDictionary data) {
        super(id, data);
        name = getPath(data, "name").toString();
        buildSettings = (Map<String, Object>) getPath(data, "buildSettings").toJavaObject();
    }

    public void putToBuildSettings(String key, Object value) {
        buildSettings.put(key, NSObject.wrap(value));
    }

    @Override
    public NSDictionary getData() {
        NSDictionary data = super.getData();
        data.put("buildSettings", NSObject.wrap(buildSettings));
        data.put("name", name);
        return data;
    }


    private static NSDictionary getConfigurationData(String name, boolean release, boolean module) {
        NSDictionary data = new NSDictionary();
        data.put("isa", "XCBuildConfiguration");
        data.put("name", name);

        NSDictionary buildSettings = new NSDictionary();
        if (module) {
            buildSettings.put("COPY_PHASE_STRIP", "NO");
            buildSettings.put("LD_RUNPATH_SEARCH_PATHS", "$(inherited) @executable_path/Frameworks @executable_path/../../Frameworks");
            buildSettings.put("PRODUCT_NAME", "$(TARGET_NAME)");
            buildSettings.put("SKIP_INSTALL", "YES");
        }
        buildSettings.put("DEBUG_INFORMATION_FORMAT", release ? "dwarf-with-dsym" : "dwarf");
        buildSettings.put("MTL_ENABLE_DEBUG_INFO", release ? "NO" : "INCLUDE_SOURCE");
        buildSettings.put("MTL_FAST_MATH", "YES");
        buildSettings.put("CLANG_ENABLE_MODULES", "YES");
        buildSettings.put("OTHER_LDFLAGS", "-ObjC");

        data.put("buildSettings", buildSettings);
        return data;
    }

}
