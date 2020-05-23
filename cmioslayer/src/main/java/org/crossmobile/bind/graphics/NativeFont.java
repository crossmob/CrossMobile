/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

public interface NativeFont {

    public String getFamily();

    public float getSize();

    public boolean isBold();

    public boolean isItalic();

    public int getAscent();

    public int getDescent();

    public int getUnitsPerEm();

    public final static class Helper {

        public static String toString(NativeFont font) {
            return font.getFamily() + (font.isBold() ? " Bold" : "") + (font.isItalic() ? " Italic" : "") + " " + font.getSize();
        }
    }
}
