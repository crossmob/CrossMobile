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
package org.crossmobile.gui.actives;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public class ThemeNotifier {

    private static final HashSet<WeakReference<ThemeChanged>> listeners = new HashSet<>();

    static void register(ThemeChanged themeListener) {
        listeners.add(new WeakReference<>(themeListener));
    }

    public static void notifyListeners(boolean dark) {
        Iterator<WeakReference<ThemeChanged>> it = listeners.iterator();
        while (it.hasNext()) {
            WeakReference<ThemeChanged> next = it.next();
            ThemeChanged listener = next.get();
            if (listener == null)
                it.remove();
            else
                listener.themeChanged(dark);
        }
    }
}
