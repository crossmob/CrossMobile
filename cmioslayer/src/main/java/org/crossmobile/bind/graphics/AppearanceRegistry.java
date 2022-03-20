/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.uikit.UIAppearance;
import crossmobile.ios.uikit.UIAppearanceContainer;
import crossmobile.ios.uikit.UIView;
import org.robovm.objc.block.VoidBlock1;

import java.util.*;

import static org.crossmobile.bind.system.SystemUtilities.construct;

@SuppressWarnings({"unchecked", "Java8MapApi"})
public class AppearanceRegistry {
    private static final Map<Class<? extends UIAppearance>, Map<List<Class<? extends UIAppearanceContainer>>, UIAppearance>> containerConstrained = new HashMap<>();
    private static final Map<Class<? extends UIAppearance>, UIAppearance> containerSimple = new HashMap<>();
    private static final Map<String, Map<UIAppearance, VoidBlock1<? extends UIAppearance>>> properties = new HashMap<>();

    public static <T extends UIAppearance> T requestAppearance(Class<? extends UIAppearance> baseClass, Class<T> appearanceClass) {
        T app = (T) containerSimple.get(baseClass);
        if (app == null)
            containerSimple.put(baseClass, app = construct(appearanceClass));
        return app;
    }

    public static <T extends UIAppearance> T requestAppearance(Class<? extends UIAppearance> baseClass, List<Class<? extends UIAppearanceContainer>> list, Class<T> appearanceClass) {
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

    public static void registerValue(UIAppearance appearance, String propertyName, VoidBlock1<? extends UIAppearance> apply) {
        Map<UIAppearance, VoidBlock1<? extends UIAppearance>> propertyMap = properties.get(propertyName);
        if (propertyMap == null)
            properties.put(propertyName, propertyMap = new HashMap<>());
        propertyMap.put(appearance, apply);
    }

    public static void didMoveToWindow(UIView container) {
        container.didMoveToWindow();
        Collection<? extends UIAppearance> affected = getAffected(container);
        if (!affected.isEmpty()) {
            Map<String, VoidBlock1<UIAppearance>> currentProperties = new HashMap<>();
            for (String propertyName : properties.keySet()) {
                Map<UIAppearance, VoidBlock1<? extends UIAppearance>> currentActions = properties.get(propertyName);
                for (UIAppearance appearance : affected) {
                    VoidBlock1<? extends UIAppearance> action = currentActions.get(appearance);
                    if (action != null)
                        currentProperties.put(propertyName, (VoidBlock1<UIAppearance>) action);
                }
            }
            for (VoidBlock1<UIAppearance> action : currentProperties.values())
                action.invoke(container);
        }
    }

    private static Collection<? extends UIAppearance> getAffected(UIAppearance container) {
        if (containerSimple.isEmpty())
            return Collections.emptyList();
        List<UIAppearance> result = new ArrayList<>();
        Class<? extends UIAppearance> containerClass = container.getClass();
        while (containerClass != null) {
            UIAppearance appearance = containerSimple.get(containerClass);
            if (appearance != null)
                result.add(appearance);
            Class superclass = containerClass.getSuperclass();
            containerClass = UIAppearance.class.isAssignableFrom(superclass)
                    ? (Class<? extends UIAppearance>) superclass
                    : null;
        }
        Collections.reverse(result);
        return result;
    }
}
