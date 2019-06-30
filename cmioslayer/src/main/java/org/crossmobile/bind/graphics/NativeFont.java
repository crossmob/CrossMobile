/*
 * (c) 2019 by Panayotis Katsaloulis
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
