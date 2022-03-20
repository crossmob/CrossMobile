/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

public class BrightThemeFont implements ThemeFont {

    @Override
    public int buttonSize() {
        return 18;
    }

    @Override
    public int systemButtonSize() {
        return 15;
    }

    @Override
    public int labelSize() {
        return 17;
    }

    @Override
    public int systemSize() {
        return 14;
    }

    @Override
    public int smallSystemSize() {
        return 12;
    }

    @Override
    public String fontName() {
        return "Arial";
    }
}
