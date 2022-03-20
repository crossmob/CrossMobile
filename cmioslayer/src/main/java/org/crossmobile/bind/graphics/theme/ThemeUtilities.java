/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import org.crossmobile.bridge.Native;

public class ThemeUtilities {
    public static int pressedColor(int base) {
        double[] hsba = Native.graphics().colorRGBAtoHSVA(base);
        hsba[2] *= 0.8f;
        return Native.graphics().colorHSBAtoRGBA(hsba[0], hsba[1], hsba[2], hsba[3]);
    }

    public static boolean isDark(int base) {
        double red = ((base >> 16) & 0xff) / 255.0;
        double green = ((base >> 8) & 0xff) / 255.0;
        double blue = (base & 0xff) / 255.0;
        return Math.sqrt(red * red * 0.299 + green * green * 0.587 + blue * blue * 0.114) < 0.5;
    }

    public static int getDuller(int base) {
        double[] hsv = Native.graphics().colorRGBAtoHSVA(base);
        hsv[1] *= 0.6;
        hsv[2] *= 0.8;
        return Native.graphics().colorHSBAtoRGBA(hsv[0], hsv[1], hsv[2], hsv[3]);
    }

    public static int getBrighter(int base) {
        double[] hsv = Native.graphics().colorRGBAtoHSVA(base);
        hsv[1] *= 0.6;
        hsv[2] *= 2;
        return Native.graphics().colorHSBAtoRGBA(hsv[0], hsv[1], hsv[2], hsv[3]);
    }

    public static int getControlColor() {
        return 0xFFB7B7B7;
    }
}
