/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import crossmobile.ios.foundation.CFType;
import crossmobile.ios.uikit.UIFont;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

/**
 * CGFont class defines an object that incorporates information related to
 * fonts.
 */
@CMReference
public class CGFont extends CFType {

    final NativeFont nfont;


    CGFont(NativeFont font) {
        this.nfont = font;
    }

    /**
     * Constructs a font object according to the specified CGDataProvider.
     *
     * @param provider The CGDataProvider of the new font object.
     * @return The new font object.
     * @see crossmobile.ios.coregraphics.CGDataProvider
     */
    @CMFunction(" CGFontRef CGFontCreateWithDataProvider ( CGDataProviderRef provider ); ")
    public static CGFont createWithDataProvider(CGDataProvider provider) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Constructs a font object according to the specified font name.
     *
     * @param fontname The name of the font object.
     * @return The new font object.
     */
    @CMFunction(" CGFontRef CGFontCreateWithFontName ( CFStringRef name ); ")
    public static CGFont createWithFontName(String fontname) {
        return new CGFont(Native.graphics().getFont(fontname, UIFont.labelFontSize()));
    }

    /**
     * Returns the ascent of this font.
     *
     * @return The ascent of this font.
     */
    @CMFunction(" int CGFontGetAscent ( CGFontRef font ); ")
    public int getAscent() {
        return nfont.getAscent();
    }

    /**
     * Returns the decent of this font.
     *
     * @return The decent of this font.
     */
    @CMFunction(" int CGFontGetDescent ( CGFontRef font ); ")
    public int getDescent() {
        return nfont.getDescent();
    }

    /**
     * Returns the number of glyph space units per em for the provided font.
     *
     * @return The number of glyph space units per em for the provided font.
     */
    @CMFunction(" int CGFontGetUnitsPerEm ( CGFontRef font ); ")
    public int getUnitsPerEm() {
        return nfont.getUnitsPerEm();
    }


    @Override
    public String toString() {
        return "CGFont " + NativeFont.Helper.toString(nfont);
    }
}
