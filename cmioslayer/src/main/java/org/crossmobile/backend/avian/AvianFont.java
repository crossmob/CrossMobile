/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import org.crossmobile.bind.graphics.NativeFont;

public class AvianFont implements NativeFont {

    public AvianFont(String fontName, double size) {
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getFamily() {
        return null;
    }

    @Override
    public double getSize() {
        return 0;
    }

    @Override
    public double getAscent() {
        return 0;
    }

    @Override
    public double getDescent() {
        return 0;
    }

    @Override
    public double getLeading() {
        return 0;
    }

    @Override
    public double getCapHeight() {
        return 0;
    }

    @Override
    public double getXHeight() {
        return 0;
    }
}
