/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

public interface UIGuidelinesBridge {

    boolean shouldDisplayStatusBar();

    boolean isTabBarOnTop();

    default void setStatusBarDark(boolean dark) {
        // Do nothing by default
    }
}
