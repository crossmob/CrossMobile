/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGFont;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;

import static crossmobile.ios.coregraphics.GraphicsDrill.cgfont;
import static crossmobile.ios.coregraphics.GraphicsDrill.font;

/**
 * UIFont class contains all the information related to fonts such size, family
 * and type.
 */
@CMClass
public class UIFont extends NSObject {
    private static final String FONT_NAME = Native.graphics().themeManager().fonts().fontName();

    final CGFont cgfont;

    UIFont(CGFont font) {
        this.cgfont = font;
    }

    /**
     * Returns a font object with default font family and size that is defined.
     *
     * @param fontSize The size of the font object.
     * @return The font object.
     */
    @CMSelector("+ (UIFont *)systemFontOfSize:(CGFloat)fontSize;")
    public static UIFont systemFontOfSize(double fontSize) {
        return new UIFont(cgfont(Native.graphics().getFont(FONT_NAME, fontSize)));
    }

    /**
     * Returns a font object with default font family, size that is defined and
     * type bold.
     *
     * @param fontSize The size of the font object.
     * @return The font object.
     */
    @CMSelector("+ (UIFont *)boldSystemFontOfSize:(CGFloat)fontSize;")
    public static UIFont boldSystemFontOfSize(double fontSize) {
        return new UIFont(cgfont(Native.graphics().getFont(FONT_NAME + " Bold", fontSize)));
    }

    /**
     * Returns a font object with default font family, size that is defined and
     * type italic.
     *
     * @param fontSize The size of the font object.
     * @return The font object.
     */
    @CMSelector("+ (UIFont *)italicSystemFontOfSize:(CGFloat)fontSize;")
    public static UIFont italicSystemFontOfSize(double fontSize) {
        return new UIFont(cgfont(Native.graphics().getFont(FONT_NAME + " Italic", fontSize)));
    }

    /**
     * Returns a font object with the defined font and size.
     *
     * @param fontName The familyname of the font.
     * @param fontSize The size of the font.
     * @return A font object with the defined font and size.
     */
    @CMSelector("+ (UIFont *)fontWithName:(NSString *)fontName \n"
            + "                    size:(CGFloat)fontSize;")
    public static UIFont fontWithName(String fontName, double fontSize) {
        return new UIFont(cgfont(Native.graphics().getFont(fontName, fontSize)));
    }

    /**
     * Returns a number that represents the default font size for buttons.
     *
     * @return A number that represents the default font size for buttons.
     */
    @CMSelector("+ (CGFloat)buttonFontSize;")
    public static double buttonFontSize() {
        return Native.graphics().themeManager().fonts().buttonSize();
    }

    /**
     * Returns a number that represents the default font size for labels.
     *
     * @return A number that represents the default font size for labels.
     */
    @CMSelector("+ (CGFloat)labelFontSize;")
    public static double labelFontSize() {
        return Native.graphics().themeManager().fonts().labelSize();
    }

    /**
     * Returns a number that represents the default small size of font for this
     * system.
     *
     * @return A number that represents the default small size of font for this
     * system.
     */
    @CMSelector("+ (CGFloat)smallSystemFontSize;")
    public static double smallSystemFontSize() {
        return Native.graphics().themeManager().fonts().smallSystemSize();
    }

    /**
     * Returns a number that represents the default size of font for this
     * system.
     *
     * @return A number that represents the default size of font for this
     * system.
     */
    @CMSelector("+ (CGFloat)systemFontSize;")
    public static double systemFontSize() {
        return Native.graphics().themeManager().fonts().systemSize();
    }

    /**
     * Returns a font object which is the same with this object and new size is
     * passed as parameter.
     *
     * @param fontSize The size of font.
     * @return The font object with the specified size.
     */
    @CMSelector("- (UIFont *)fontWithSize:(CGFloat)fontSize;")
    public UIFont fontWithSize(double fontSize) {
        NativeFont font = font(cgfont);
        return new UIFont(cgfont(Native.graphics().getFont(font.getName(), fontSize)));
    }

    @SuppressWarnings("unchecked")
    @CMSelector("+ (NSArray<NSString *>*) familyNames;")
    public static List<String> familyNames() {
        return Native.graphics().listFontFamilies();
    }

    @SuppressWarnings("unchecked")
    @CMSelector("+ (NSArray<NSString *> *)fontNamesForFamilyName:(NSString *)familyName;")
    public static List<String> fontNamesForFamilyName(String familyName) {
        return Native.graphics().listFont(familyName);
    }

    /**
     * Returns the name of font family.
     *
     * @return The name of the font family.
     */
    @CMGetter("@property(nonatomic, readonly, strong) NSString *familyName;")
    public String familyName() {
        return font(cgfont).getFamily();
    }

    /**
     * Returns the name of the font.
     *
     * @return The name of the font.
     */
    @CMGetter("@property(nonatomic, readonly, strong) NSString *fontName;")
    public String fontName() {
        return font(cgfont).getName();
    }

    /**
     * Returns a number that represents the point size for this object.
     *
     * @return A number that represent the point size for this object.
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat pointSize;")
    public double pointSize() {
        return font(cgfont).getSize();
    }

    /**
     * Returns the ascent of this font.
     *
     * @return The ascent of this font.
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat ascender;")
    public double ascender() {
        return font(cgfont).getAscent();
    }

    /**
     * Returns the decent of this font.
     *
     * @return The decent of this font.
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat descender;")
    public double descender() {
        return font(cgfont).getDescent();
    }

    /**
     * Returns the leading space of the font.
     *
     * @return The leading space of the font
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat leading;")
    public double leading() {
        return font(cgfont).getLeading();
    }

    /**
     * Returns the cap height of the font.
     *
     * @return The cap height of the font
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat capHeight;")
    public double capHeight() {
        return font(cgfont).getCapHeight();
    }

    /**
     * Returns the height of the x character of the font.
     *
     * @return The height of the x character of the font
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat xHeight;")
    public double xHeight() {
        return font(cgfont).getXHeight();
    }

    @CMGetter("@property(nonatomic, readonly) CGFloat lineHeight;")
    public double lineHeight() {
        return ascender() - descender() + leading();
    }

    @Override
    public String toString() {
        return "UIFont " + font(cgfont).getName();
    }
}
