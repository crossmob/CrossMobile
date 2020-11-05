/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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

import static crossmobile.ios.coregraphics.GraphicsDrill.cgfont;
import static crossmobile.ios.coregraphics.GraphicsDrill.font;

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
        return new UIFont(cgfont(Native.graphics().getFont(Theme.Font.FONTNAME, fontSize)));
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
        return new UIFont(cgfont(Native.graphics().getFont(Theme.Font.FONTNAME + " Bold", fontSize)));
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
        return new UIFont(cgfont(Native.graphics().getFont(Theme.Font.FONTNAME + " Italic", fontSize)));
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
        return new UIFont(cgfont(Native.graphics().getFont(font.getName(), fontSize)));
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

    @Override
    public String toString() {
        return "UIFont " + font(cgfont).getName();
    }
}
