/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGColor;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMParamMod;
import org.crossmobile.bridge.ann.CMSelector;

import static crossmobile.ios.coregraphics.GraphicsDrill.cgcolor;
import static crossmobile.ios.coregraphics.GraphicsDrill.color;

/**
 * UIColor class defines a color object used to store color data.
 */
@CMClass
public class UIColor extends NSObject implements NSSecureCoding {

    final static UIColor blackColor = new UIColor(0xFF000000);
    final static UIColor darkGrayColor = new UIColor(0xFF444444);
    final static UIColor lightGrayColor = new UIColor(0xFFAAAAAA);
    final static UIColor whiteColor = new UIColor(0xFFFFFFFF);
    final static UIColor grayColor = new UIColor(0xFF808080);
    final static UIColor redColor = new UIColor(0xFFFF0000);
    final static UIColor greenColor = new UIColor(0xFF00FF00);
    final static UIColor blueColor = new UIColor(0xFF0000FF);
    final static UIColor cyanColor = new UIColor(0xFF00FFFF);
    final static UIColor yellowColor = new UIColor(0xFFFFFF00);
    final static UIColor magentaColor = new UIColor(0xFFFF00FF);
    final static UIColor orangeColor = new UIColor(0xFFFF8000);
    final static UIColor purpleColor = new UIColor(0xFF800080);
    final static UIColor brownColor = new UIColor(0xFF996633);
    final static UIColor clearColor = new UIColor(0x00000000);
    final static UIColor lightTextColor = new UIColor(0xFFB7B7B7);
    final static UIColor darkTextColor = new UIColor(0xFF000000);
    final static UIColor groupTableViewBackgroundColor = new UIColor(0xFFC5CCD4);
    final static UIColor viewFlipsideBackgroundColor = new UIColor(0xFF000000);

    //
    UIImage image;
    final CGColor cgcolor;

    /**
     * Creates a UIColor object of black color..
     *
     * @return A UIColor object of black color.
     */
    @CMSelector("+ (UIColor *)blackColor;")
    public static final UIColor blackColor() {
        return blackColor;
    }

    /**
     * Creates a UIColor object of dark gray color.
     *
     * @return A UIColor object of dark gray color.
     */
    @CMSelector("+ (UIColor *)darkGrayColor;")
    public static final UIColor darkGrayColor() {
        return darkGrayColor;
    }

    /**
     * Creates a UIColor object of light gray color.
     *
     * @return A UIColor object of light gray color.
     */
    @CMSelector("+ (UIColor *)lightGrayColor;")
    public static final UIColor lightGrayColor() {
        return lightGrayColor;
    }

    /**
     * Creates a UIColor object of white color.
     *
     * @return A UIColor object of white color.
     */
    @CMSelector("+ (UIColor *)whiteColor;")
    public static final UIColor whiteColor() {
        return whiteColor;
    }

    /**
     * Creates a UIColor object of gray color.
     *
     * @return A UIColor object of gray color.
     */
    @CMSelector("+ (UIColor *)grayColor;")
    public static final UIColor grayColor() {
        return grayColor;
    }

    /**
     * Creates a UIColor object of rec color.
     *
     * @return A UIColor object of red color.
     */
    @CMSelector("+ (UIColor *)redColor;")
    public static final UIColor redColor() {
        return redColor;
    }

    /**
     * Creates a UIColor object of green color.
     *
     * @return A UIColor object of green color.
     */
    @CMSelector("+ (UIColor *)greenColor;")
    public static final UIColor greenColor() {
        return greenColor;
    }

    /**
     * Creates a UIColor object of blue color.
     *
     * @return A UIColor object of blue color.
     */
    @CMSelector("+ (UIColor *)blueColor;")
    public static final UIColor blueColor() {
        return blueColor;
    }

    /**
     * Creates a UIColor object of cyan color.
     *
     * @return A UIColor object of cyan color.
     */
    @CMSelector("+ (UIColor *)cyanColor;")
    public static final UIColor cyanColor() {
        return cyanColor;
    }

    /**
     * Creates a UIColor object of yellow color.
     *
     * @return A UIColor object of yellow color.
     */
    @CMSelector("+ (UIColor *)yellowColor;")
    public static final UIColor yellowColor() {
        return yellowColor;
    }

    /**
     * Creates a UIColor object of magenta color.
     *
     * @return A UIColor object of magenta color.
     */
    @CMSelector("+ (UIColor *)magentaColor;")
    public static final UIColor magentaColor() {
        return magentaColor;
    }

    /**
     * Creates a UIColor object of orange color.
     *
     * @return A UIColor object of orange color.
     */
    @CMSelector("+ (UIColor *)orangeColor;")
    public static final UIColor orangeColor() {
        return orangeColor;
    }

    /**
     * Creates a UIColor object of purple color.
     *
     * @return A UIColor object of purple color.
     */
    @CMSelector("+ (UIColor *)purpleColor;")
    public static final UIColor purpleColor() {
        return purpleColor;
    }

    /**
     * Creates a UIColor object of brown color.
     *
     * @return A UIColor object of brown color.
     */
    @CMSelector("+ (UIColor *)brownColor;")
    public static final UIColor brownColor() {
        return brownColor;
    }

    /**
     * Returns a UIColor object with grayscale's value 0 and alpha value 0.
     *
     * @return A UIColor object with grayscale's value 0 and alpha value 0.
     */
    @CMSelector("+ (UIColor *)clearColor;")
    public static final UIColor clearColor() {
        return clearColor;
    }

    /**
     * Returns a UIColor object used in order to display text on a dark
     * background.
     *
     * @return A UIColor object used in order to display text on a dark
     * background.
     */
    @CMSelector("+ (UIColor *)lightTextColor;")
    public static final UIColor lightTextColor() {
        return lightTextColor;
    }

    /**
     * Returns a UIColor object used in order to display text on a light
     * background.
     *
     * @return A UIColor object used in order to display text on a light
     * background.
     */
    @CMSelector("+ (UIColor *)darkTextColor;")
    public static final UIColor darkTextColor() {
        return darkTextColor;
    }

    /**
     * Returns a UIColor object used when the background is a grouped table.
     *
     * @return A UIColor object used when the background is a grouped table.
     */
    @CMSelector("+ (UIColor *)groupTableViewBackgroundColor;")
    public static final UIColor groupTableViewBackgroundColor() {
        return groupTableViewBackgroundColor;
    }

    /**
     * Returns a UIColor object used for the back side of view when it is
     * flipped.
     *
     * @return A UIColor object used for the back side of view when it is
     * flipped.
     */
    @Deprecated
    @CMSelector("+ (UIColor *)viewFlipsideBackgroundColor;")
    public static final UIColor viewFlipsideBackgroundColor() {
        return viewFlipsideBackgroundColor;
    }

    UIColor(int color) {
        image = null;
        this.cgcolor = cgcolor(color);
    }

    private UIColor(CGColor color) {
        image = null;
        this.cgcolor = color;
    }

    private UIColor(UIImage image) {
        this.image = image;
        cgcolor = cgcolor(0);
    }

    private UIColor(double red, double green, double blue, double alpha) {
        this(Native.graphics().colorRGBA(red, green, blue, alpha));
    }

    /**
     * Returns a UIColor object with the given values for opacity and alpha.
     *
     * @param white The grayscale of the UIColor object.
     * @param alpha The alpha value of the UIColor object.
     * @return A UIColor object with the given values for opacity and alpha.
     */
    @CMSelector(value = "+ (UIColor *)colorWithWhite:(CGFloat)white alpha:(CGFloat)alpha;")
    public static UIColor colorWithWhiteAlpha(double white, @CMParamMod(concatName = true) double alpha) {
        return new UIColor(white, white, white, alpha);
    }

    /**
     * Returns a UIColor object with the given RGB and alpha values.
     *
     * @param red   The red value of RGBof the UIColor object.
     * @param green The green value of RGB.
     * @param blue  The blue value of RGB of the UIColor object.
     * @param alpha The alpha value of the UIColor object.
     * @return UIColor object with the given RGB and alpha values.
     */
    @CMSelector(value = "+ (UIColor *)colorWithRed:(CGFloat)red green:(CGFloat)green blue:(CGFloat)blue alpha:(CGFloat)alpha;")
    public static UIColor colorWithRedGreenBlueAlpha(double red, @CMParamMod(concatName = true) double green, @CMParamMod(concatName = true) double blue, @CMParamMod(concatName = true) double alpha) {
        return new UIColor(red, green, blue, alpha);
    }

    /**
     * Returns a UIColor object with the given HSB and alpha values.
     *
     * @param h The hue value of the UIColor object.
     * @param s The saturation value of the UIColor object.
     * @param b The brightness value of the UIColor object.
     * @param a The alpha value of the UIColor object.
     * @return UIColor object with the given HSB and alpha values.
     */
    @CMSelector(value = "+ (UIColor *)colorWithHue:(CGFloat)hue saturation:(CGFloat)saturation brightness:(CGFloat)brightness alpha:(CGFloat)alpha;")
    public static UIColor colorWithHueSaturationBrightnessAlpha(double h, @CMParamMod(concatName = true) double s, @CMParamMod(concatName = true) double b, @CMParamMod(concatName = true) double a) {
        return new UIColor(Native.graphics().colorHSBAtoRGBA(h, s, b, a));
    }

    /**
     * Returns a UIColor object using the image parameter.
     *
     * @param patternImage The image parameter used for the creation of the
     *                     UIColor.
     * @return A UIColor object created using the image parameter.
     */
    @CMSelector("+ (UIColor *)colorWithPatternImage:(UIImage *)image;")
    public static UIColor colorWithPatternImage(UIImage patternImage) {
        return new UIColor(patternImage);
    }

    /**
     * Returns a UIColor object with the defined CGColor parameter.
     *
     * @param color The CGColor parameter.
     * @return UIColor object created with the defined CGColor parameter.
     */
    @CMSelector("+ (UIColor *)colorWithCGColor:(CGColorRef)cgColor;")
    public static UIColor colorWithCGColor(CGColor color) {
        return new UIColor(color);
    }

    /**
     * Returns a CGColor.
     *
     * @return A CGColor.
     */
    @CMGetter("@property(nonatomic, readonly) CGColorRef CGColor;")
    public CGColor CGColor() {
        return cgcolor;
    }

    @Override
    public String toString() {
        return "UIColor " + Native.graphics().colorToString(color(cgcolor));
    }

    @Override
    public int hashCode() {
        return cgcolor.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UIColor other = (UIColor) obj;
        return this.cgcolor.equals(other.cgcolor);
    }

}
