/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import crossmobile.ios.uikit.UIScrollView;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bridge.SystemBridge;

import java.util.Collection;
import java.util.HashSet;

public abstract class AbstractSystemBridge implements SystemBridge {
    private final Collection<Class<? extends UIView>> scrollables = new HashSet<>();

    {
        scrollables.add(UIScrollView.class);
    }

    @Override
    public void registerScrollable(Class<? extends UIView> scrollableClass) {
        scrollables.add(scrollableClass);
    }

    @Override
    public Iterable<Class<? extends UIView>> getScrollables() {
        return scrollables;
    }
}
