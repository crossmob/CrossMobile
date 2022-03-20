/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.UIGuidelinesBridge;

public class DesktopUIGuidelinesBridge implements UIGuidelinesBridge {

    @Override
    public boolean shouldDisplayStatusBar() {
        return ((DesktopDrawableMetrics) Native.graphics().metrics()).isWithStatusBar();
    }

    @Override
    public boolean isTabBarOnTop() {
        return false;
    }

}
