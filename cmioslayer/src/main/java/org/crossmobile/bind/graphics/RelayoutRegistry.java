/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.uikit.UIView;
import org.crossmobile.bridge.Native;

import java.util.Collection;
import java.util.HashSet;

public class RelayoutRegistry implements Runnable {

    private Collection<UIView> registry = new HashSet<>();
    private Collection<UIView> buffer = new HashSet<>();

    private static final RelayoutRegistry current = new RelayoutRegistry();

    public static void register(UIView view) {
        if (Native.lifecycle().isEventThread())
            current.registerView(view);
        else
            Native.lifecycle().runOnEventThread(() -> current.registerView(view));
        Native.lifecycle().runLaterOnceOnEventThread(current);
    }

    private void registerView(UIView given) {
        UIView toRemove = null;
        for (UIView registered : registry) {
            if (registered == given)
                return;
            else if (isViewParentOf(registered, given))
                return;
            else if (isViewParentOf(given, registered)) {
                toRemove = registered;
                break;
            }
        }
        if (toRemove != null)
            registry.remove(toRemove);
        registry.add(given);
    }

    private boolean isViewParentOf(UIView parent, UIView child) {
        child = child.superview();
        while (child != null) {
            if (parent == child)
                return true;
            child = child.superview();
        }
        return false;
    }

    @Override
    public void run() {
        if (!registry.isEmpty()) {
            Collection<UIView> swap = registry;
            registry = buffer;
            buffer = swap;
            for (UIView view : buffer)
                view.layoutIfNeeded();
            buffer.clear();
        }
    }
}
