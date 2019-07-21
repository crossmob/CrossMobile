/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.bind.graphics;

import crossmobile.ios.uikit.UIAppearance;
import crossmobile.ios.uikit.UIAppearanceContainer;

import java.util.*;

import static org.crossmobile.bind.system.SystemUtilities.construct;

@SuppressWarnings({"unchecked", "Java8MapApi"})
public class AppearanceRegistry {
    private static final Map<Class<? extends UIAppearanceContainer>, Map<List<Class<? extends UIAppearanceContainer>>, UIAppearance>> appReg = new HashMap<>();
    private static final Map<Class<? extends UIAppearanceContainer>, UIAppearance> appRegCond = new HashMap<>();

    private static final Map<UIAppearance, Map<String, Object>> properties = new HashMap<>();


    public static <T extends UIAppearance> T requestAppearance(Class<? extends UIAppearanceContainer> baseClass, Class<T> appearanceClass) {
        T app = (T) appRegCond.get(baseClass);
        if (app == null)
            appRegCond.put(baseClass, app = construct(appearanceClass));
        return app;
    }

    public static <T extends UIAppearance> T requestAppearance(Class<? extends UIAppearanceContainer> baseClass, List<Class<? extends UIAppearanceContainer>> list, Class<T> appearanceClass) {
        if (list == null || list.isEmpty())
            return requestAppearance(baseClass, appearanceClass);
        list = new ArrayList<>(list);

        Map<List<Class<? extends UIAppearanceContainer>>, UIAppearance> subRegistry = appReg.get(baseClass);
        if (subRegistry == null)
            appReg.put(baseClass, subRegistry = new LinkedHashMap<>());
        T app = (T) subRegistry.get(list);
        if (app == null)
            subRegistry.put(list, app = construct(appearanceClass));
        return app;
    }

    public static void registerValue(UIAppearance appearance, String propertyName, Object... data) {
        Map<String, Object> appProp = properties.get(appearance);
        if (appProp == null)
            properties.put(appearance, appProp = new HashMap<>());
        appProp.put(propertyName, data);
    }
}
