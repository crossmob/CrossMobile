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
import crossmobile.ios.uikit.UIView;

import java.util.*;
import java.util.function.Consumer;

import static org.crossmobile.bind.system.SystemUtilities.construct;

@SuppressWarnings({"unchecked", "Java8MapApi"})
public class AppearanceRegistry {
    private static final Map<Class<? extends UIAppearanceContainer>, Map<List<Class<? extends UIAppearanceContainer>>, UIAppearance>> containerConstrained = new HashMap<>();
    private static final Map<Class<? extends UIAppearanceContainer>, UIAppearance> containerSimple = new HashMap<>();
    private static final Map<String, Map<UIAppearance, Consumer<? extends UIAppearanceContainer>>> properties = new HashMap<>();

    public static <T extends UIAppearance> T requestAppearance(Class<? extends UIAppearanceContainer> baseClass, Class<T> appearanceClass) {
        T app = (T) containerSimple.get(baseClass);
        if (app == null)
            containerSimple.put(baseClass, app = construct(appearanceClass));
        return app;
    }

    public static <T extends UIAppearance> T requestAppearance(Class<? extends UIAppearanceContainer> baseClass, List<Class<? extends UIAppearanceContainer>> list, Class<T> appearanceClass) {
        if (list == null || list.isEmpty())
            return requestAppearance(baseClass, appearanceClass);
        list = new ArrayList<>(list);
        Map<List<Class<? extends UIAppearanceContainer>>, UIAppearance> subRegistry = containerConstrained.get(baseClass);
        if (subRegistry == null)
            containerConstrained.put(baseClass, subRegistry = new LinkedHashMap<>());
        T app = (T) subRegistry.get(list);
        if (app == null)
            subRegistry.put(list, app = construct(appearanceClass));
        return app;
    }

    public static void registerValue(UIAppearance appearance, String propertyName, Consumer<? extends UIAppearanceContainer> apply) {
        Map<UIAppearance, Consumer<? extends UIAppearanceContainer>> propertyMap = properties.get(propertyName);
        if (propertyMap == null)
            properties.put(propertyName, propertyMap = new HashMap<>());
        propertyMap.put(appearance, apply);
    }

    public static void didMoveToWindow(UIView container) {
        container.didMoveToWindow();
        Collection<? extends UIAppearance> affected = getAffected(container);
        if (!affected.isEmpty()) {
            Map<String, Consumer<UIAppearanceContainer>> currentProperties = new HashMap<>();
            for (String propertyName : properties.keySet()) {
                Map<UIAppearance, Consumer<? extends UIAppearanceContainer>> currentActions = properties.get(propertyName);
                for (UIAppearance appearance : affected) {
                    Consumer<? extends UIAppearanceContainer> action = currentActions.get(appearance);
                    if (action != null)
                        currentProperties.put(propertyName, (Consumer<UIAppearanceContainer>) action);
                }
            }
            for (Consumer<UIAppearanceContainer> action : currentProperties.values())
                action.accept(container);
        }
    }

    private static Collection<? extends UIAppearance> getAffected(UIAppearanceContainer container) {
        if (containerSimple.isEmpty())
            return Collections.emptyList();
        List<UIAppearance> result = new ArrayList<>();
        Class<?> containerClass = container.getClass();
        while (UIAppearanceContainer.class.isAssignableFrom(containerClass)) {
            UIAppearance appearance = containerSimple.get(containerClass);
            if (appearance != null)
                result.add(appearance);
            containerClass = containerClass.getSuperclass();
        }
        Collections.reverse(result);
        return result;
    }
}
