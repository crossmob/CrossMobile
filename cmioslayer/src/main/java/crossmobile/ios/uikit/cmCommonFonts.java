/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.Native;

class cmCommonFonts {
    private static UIFont LABEL_FONT;
    private static UIFont SYSTEM_FONT;
    private static UIFont SMALL_SYSTEM_FONT;
    private static UIFont BUTTON_FONT;

    static UIFont getLabelFont() {
        if (LABEL_FONT == null)
            LABEL_FONT = UIFont.systemFontOfSize(Native.graphics().themeManager().fonts().labelSize());
        return LABEL_FONT;
    }

    static UIFont getSystemFont() {
        if (SYSTEM_FONT == null)
            SYSTEM_FONT = UIFont.systemFontOfSize(Native.graphics().themeManager().fonts().systemSize());
        return SYSTEM_FONT;
    }

    static UIFont getSmallSystemFont() {
        if (SMALL_SYSTEM_FONT == null)
            SMALL_SYSTEM_FONT = UIFont.systemFontOfSize(Native.graphics().themeManager().fonts().smallSystemSize());
        return SMALL_SYSTEM_FONT;
    }

    static UIFont getButtonFont() {
        if (BUTTON_FONT == null)
            BUTTON_FONT = UIFont.systemFontOfSize(Native.graphics().themeManager().fonts().buttonSize());
        return BUTTON_FONT;
    }
}
