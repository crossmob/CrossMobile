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
package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGFont;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;

import static crossmobile.ios.coregraphics.$coregraphics.cgfont;
import static crossmobile.ios.coregraphics.$coregraphics.font;

/**
 * UIFont class contains all the information related to fonts such size, family
 * and type.
 */
@CMClass
public class UIFont extends NSObject {

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
        return new UIFont(cgfont(Native.graphics().getFont(Theme.Font.FONTNAME, fontSize, false, false)));
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
        return new UIFont(cgfont(Native.graphics().getFont(Theme.Font.FONTNAME, fontSize, true, false)));
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
        return new UIFont(cgfont(Native.graphics().getFont(Theme.Font.FONTNAME, fontSize, false, true)));
    }

    /**
     * Returns a font object with the defined font and size.
     *
     * @param familyname The familyname of the font.
     * @param fontsize   The size of the font.
     * @return A font object with the defined font and size.
     */
    @CMSelector("+ (UIFont *)fontWithName:(NSString *)fontName \n"
            + "                    size:(CGFloat)fontSize;")
    public static UIFont fontWithName(String familyname, double fontsize) {
        return new UIFont(cgfont(Native.graphics().getFont(familyname, fontsize)));
    }

    /**
     * Returns a number that represents the default font size for buttons.
     *
     * @return A number that represents the default font size for buttons.
     */
    @CMSelector("+ (CGFloat)buttonFontSize;")
    public static double buttonFontSize() {
        return Theme.Font.BUTTONSIZE;
    }

    /**
     * Returns a number that represents the default font size for labels.
     *
     * @return A number that represents the default font size for labels.
     */
    @CMSelector("+ (CGFloat)labelFontSize;")
    public static double labelFontSize() {
        return Theme.Font.LABELSIZE;
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
        return Theme.Font.SMALLSYSTEMSIZE;
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
        return Theme.Font.SYSTEMSIZE;
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
        return new UIFont(cgfont(Native.graphics().getFont(font.getFamily(), fontSize, font.isBold(), font.isItalic())));
    }

    @CMSelector("+ (NSArray<NSString *>*) familyNames;")
    public static List<String> familyNames() {
        return Native.graphics().listFontFamilies();
    }

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
        boolean b = font(cgfont).isBold();
        boolean i = font(cgfont).isItalic();
        return font(cgfont).getFamily() + ((b | i) ? (" " + (b ? "Bold" : "") + (i ? "Italic" : "")) : "");
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

    @Override
    public String toString() {
        return "UIFont " + NativeFont.Helper.toString(font(cgfont));
    }
}
