/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.RUNTIME)
public interface NativeFont {

    String getFamily();

    float getSize();

    boolean isBold();

    boolean isItalic();

    int getAscent();

    int getDescent();

    int getUnitsPerEm();

    Object getFont();

    final class Helper {

        public static String toString(NativeFont font) {
            return font.getFamily() + (font.isBold() ? " Bold" : "") + (font.isItalic() ? " Italic" : "") + " " + font.getSize();
        }
    }
}
