/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bind.system.Promise;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;
import org.crossmobile.bridge.system.Pair;

import java.io.File;

import static crossmobile.ios.uikit.UIButtonType.System;
import static crossmobile.ios.uikit.UIButtonType.*;
import static crossmobile.ios.uikit.UIControlState.*;
import static crossmobile.ios.uikit.cmCommonFonts.getButtonFont;
import static crossmobile.ios.uikit.cmCommonFonts.getSystemFont;

/**
 * UIButton class defines a button element that is displayed on screen and
 * changes state and appearance according on finger tapping.
 */
@CMClass
public class UIButton extends UIControl {

    private final int buttonType;
    private final UILabel label;
    private final UIImageView imageView;
    private boolean dirtyVisuals = true;
    private final UIEdgeInsets imageEdgeInsets = UIEdgeInsets.zero();
    private final UIEdgeInsets contentEdgeInsets = UIEdgeInsets.zero();
    private final UIEdgeInsets titleEdgeInsets = UIEdgeInsets.zero();
    cmButtonStates states = new cmButtonStates();   // not private so that UIButtonFactory can access it

    /**
     * Constructs a UIButton object initialized with the given type.
     *
     * @param UIButtonType Specifies the style of a button.
     * @return A newly created button.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("+ (instancetype)buttonWithType:(UIButtonType)buttonType;")
    public static UIButton buttonWithType(int UIButtonType) {
        return new UIButton(UIButtonType);
    }

    /**
     * Changes the type of this button according to the specified type.
     *
     * @param UIButtonType Specifies the new type of the button.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    UIButton(int UIButtonType) {
        this.buttonType = UIButtonType;
        setContentVerticalAlignment(UIControlContentVerticalAlignment.Center);

        imageView = new UIImageView();
        imageView.setHidden(true);
        imageView.setContentMode(UIViewContentMode.ScaleToFill);
        addSubview(imageView);

        label = new UILabel();
        label.setHidden(true);
        label.setFont(getButtonFont());
        label.setBackgroundColor(null); // Need to do this to bypass UIAppearance settings
        addSubview(label);

        switch (UIButtonType) {
            case System:
                label.setFont(getSystemFont());
                if (Theme.Button.IS_SYSTEM) {
                    String location = Native.file().getSystemCacheLocation() + File.separator;
                    setBackgroundImage(UIImage.getMidStretchedImage(location + Theme.Images.ROUNDRECT_RELEASED), UIControlState.Normal);
                    setBackgroundImage(UIImage.getMidStretchedImage(location + Theme.Images.ROUNDRECT_PRESSED), UIControlState.Highlighted);
                }
                break;
            case DetailDisclosure:
                setSystemButtonType("detaildisclosure");
                break;
            case ContactAdd:
                setSystemButtonType("contactadd");
                break;
            case InfoDark:
                setSystemButtonType("infodark");
                break;
            case InfoLight:
                setSystemButtonType("infolight");
                break;
        }
    }

    private void setSystemButtonType(String name) {
        setTitleColor(UIColor.whiteColor(), UIControlState.Normal);
        setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + name), Normal);
    }

    @Override
    public void setFrame(CGRect frame) {
        super.setFrame(frame);
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    /**
     * Set the insets of the foreground image
     *
     * @param imageEdgeInsets The image insets
     */
    @CMSetter("@property(nonatomic) UIEdgeInsets imageEdgeInsets;")
    public void setImageEdgeInsets(UIEdgeInsets imageEdgeInsets) {
        this.imageEdgeInsets.set(imageEdgeInsets);
    }

    /**
     * Retrieve the insets of the foreground image. This value is zero if not
     * defined
     *
     * @return The image insets
     */
    @CMGetter("@property(nonatomic) UIEdgeInsets imageEdgeInsets;")
    public UIEdgeInsets imageEdgeInsets() {
        return new UIEdgeInsets(imageEdgeInsets);
    }

    /**
     * Set the insets of the view content
     *
     * @param contentEdgeInsets The content insets
     */
    @CMSetter("@property(nonatomic) UIEdgeInsets contentEdgeInsets;")
    public void setContentEdgeInsets(UIEdgeInsets contentEdgeInsets) {
        this.contentEdgeInsets.set(contentEdgeInsets);
    }

    /**
     * Retrieve the insets of the view content. This value is zero if not
     * defined
     *
     * @return The content view insets
     */
    @CMGetter("@property(nonatomic) UIEdgeInsets contentEdgeInsets;")
    public UIEdgeInsets contentEdgeInsets() {
        return new UIEdgeInsets(contentEdgeInsets);
    }

    /**
     * Set the insets of the text
     *
     * @param titleEdgeInsets The image insets
     */
    @CMSetter("@property(nonatomic) UIEdgeInsets titleEdgeInsets;")
    public void setTitleEdgeInsets(UIEdgeInsets titleEdgeInsets) {
        this.imageEdgeInsets.set(imageEdgeInsets);
    }

    /**
     * Retrieve the insets of the text. This value is zero if not defined
     *
     * @return The text insets
     */
    @CMGetter("@property(nonatomic) UIEdgeInsets titleEdgeInsets;")
    public UIEdgeInsets titleEdgeInsets() {
        return new UIEdgeInsets(titleEdgeInsets);
    }

    @Override
    public void layoutSubviews() {
        super.layoutSubviews();
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    /**
     * Returns the button type.
     *
     * @return The button type.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMGetter("@property(nonatomic, readonly) UIButtonType buttonType;")
    public int buttonType() {
        return buttonType;
    }

    /**
     * Returns a label that displays button’s title.
     *
     * @return A view that displays the value of the currentTitle property for a
     * button.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UILabel *titleLabel;")
    public UILabel titleLabel() {
        return label;
    }

    /**
     * Returns button’s image view.
     *
     * @return The button’s image view.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIImageView *imageView;")
    public UIImageView imageView() {
        return imageView;
    }

    /**
     * Returns title the displayed on this button.
     *
     * @return The current title that is displayed on the button.
     */
    @CMGetter("@property(nonatomic, readonly, strong) NSString *currentTitle;")
    public String currentTitle() {
        return states.getTitle();
    }

    /**
     * Returns the title for the specified state.
     *
     * @param UIControlState The state that uses the specified title.
     * @return The title for the specified state.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (NSString *)titleForState:(UIControlState)state;")
    public String titleForState(int UIControlState) {
        return states.getTitle((byte) (UIControlState & MASK));
    }

    /**
     * Sets the title for the specified state.
     *
     * @param title          The title for the specified state.
     * @param UIControlState The state that uses the specified title.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (void)setTitle:(NSString *)title \n"
            + "        forState:(UIControlState)state;")
    public void setTitle(String title, int UIControlState) {
        states.setTitle((byte) (UIControlState & MASK), title, label.font());
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    /**
     * Returns the color of the title.
     *
     * @return The color of the title.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIColor *currentTitleColor;")
    public UIColor currentTitleColor() {
        return states.getTitleColor(tintColor());
    }

    /**
     * Returns the color of the title for the specified state.
     *
     * @param UIControlState The state that uses the specified color.
     * @return The color of the title for the specified state.
     */
    @CMSelector("- (UIColor *)titleColorForState:(UIControlState)state;")
    public UIColor titleColorForState(int UIControlState) {
        return states.getTitleColor((byte) (UIControlState & MASK));
    }

    /**
     * Sets the color for title to use for the specified state.
     *
     * @param titleColor     The color of the title for the specified state.
     * @param UIControlState The specified state that uses the specified color.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (void)setTitleColor:(UIColor *)color \n"
            + "             forState:(UIControlState)state;")
    public void setTitleColor(UIColor titleColor, int UIControlState) {
        states.setTitleColor((byte) (UIControlState & MASK), titleColor);
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    /**
     * Returns the color of title shadow for the specified state.
     *
     * @param UIControlState The state that uses the specified color.
     * @return The shadow color of the title used for the specified state.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (UIColor *)titleShadowColorForState:(UIControlState)state;")
    public UIColor titleShadowColorForState(int UIControlState) {
        return states.getShadowColor((byte) (UIControlState & MASK));
    }

    /**
     * Returns the color of the title’s shadow.
     *
     * @return The color of the title’s shadow.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIColor *currentTitleShadowColor;")
    public UIColor currentTitleShadowColor() {
        return states.getShadowColor();
    }

    /**
     * Sets the color for title shadow to use for the specified state.
     *
     * @param shadowcolor    The color of the title shadow.
     * @param UIControlState The specified state that uses the specified color.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (void)setTitleShadowColor:(UIColor *)color \n"
            + "                   forState:(UIControlState)state;")
    public void setTitleShadowColor(UIColor shadowcolor, int UIControlState) {
        states.setShadowColor((byte) (UIControlState & MASK), shadowcolor);
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    /**
     * Returns the image displayed on the button.
     *
     * @return The image displayed on the button.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIImage *currentImage;")
    public UIImage currentImage() {
        return maybeSource(states.getFore());
    }

    /**
     * Returns a image that is used for the specified state of this button.
     *
     * @param UIControlState The specified state of the button.
     * @return The image that is used for the specified state.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (UIImage *)imageForState:(UIControlState)state;")
    public UIImage imageForState(int UIControlState) {
        return maybeSource(states.getFore((byte) (UIControlState & MASK)));
    }

    /**
     * Sets the image to use for the specified state of this button.
     *
     * @param img            The image to use for the specified state.
     * @param UIControlState The specified state that uses the specified image.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (void)setImage:(UIImage *)image \n"
            + "        forState:(UIControlState)state;")
    public void setImage(UIImage img, int UIControlState) {
        setImage(new Promise<>(img, null), UIControlState);
    }

    void setImage(Promise<UIImage> pimage, int controlstate) {
        states.setFore((byte) (controlstate & MASK), pimage);
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    /**
     * Returns the background image of this button.
     *
     * @return The background image of this button.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIImage *currentBackgroundImage;")
    public UIImage currentBackgroundImage() {
        return maybeSource(states.getBack());
    }

    /**
     * Returns a background image that is used for the specified state of this
     * button.
     *
     * @param UIControlState The specified state of the button.
     * @return The background image that is used for the specified state.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (UIImage *)backgroundImageForState:(UIControlState)state;")
    public UIImage backgroundImageForState(int UIControlState) {
        return maybeSource(states.getBack((byte) (UIControlState & MASK)));
    }

    /**
     * Sets a background image to use for a specified state of this button.
     *
     * @param img            The background image to use for the specified state.
     * @param UIControlState The specified state that uses the specified image.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (void)setBackgroundImage:(UIImage *)image \n"
            + "                  forState:(UIControlState)state;")
    public void setBackgroundImage(UIImage img, int UIControlState) {
        states.setBack((byte) (UIControlState & MASK), img == null ? null : img.cacheTinted(false, this));
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    /**
     * Returns a value that shows this button changes image when it is disabled.
     *
     * @return A Boolean value that defines whether this button changes image
     * when it is disabled.
     */
    @CMGetter("@property(nonatomic) BOOL adjustsImageWhenDisabled;d;")
    public boolean adjustsImageWhenDisabled() {
        return states.adjustsImageWhenDisabled;
    }

    /**
     * Sets a value that defines whether this button changes image when it is
     * disabled.
     *
     * @param adjustsImageWhenDisabled A Boolean value that defines whether this
     *                                 button changes image when it is disabled.
     */
    @CMSetter("@property(nonatomic) BOOL adjustsImageWhenDisabled;")
    public void setAdjustsImageWhenDisabled(boolean adjustsImageWhenDisabled) {
        states.adjustsImageWhenDisabled = adjustsImageWhenDisabled;
    }

    /**
     * Returns a value that shows this button changes image when it is
     * highlighted.
     *
     * @return A Boolean value that defines whether this button changes image
     * when it is highlighted.
     */
    @CMGetter("@property(nonatomic) BOOL adjustsImageWhenHighlighted;")
    public boolean adjustsImageWhenHighlighted() {
        return states.adjustsImageWhenHighlighted;
    }

    /**
     * Sets a value that defines whether this button changes image when it is
     * highlighted.
     *
     * @param adjustsImageWhenHighlighted A Boolean value that defines whether
     *                                    this button changes image when it is highlighted.
     */
    @CMSetter("@property(nonatomic) BOOL adjustsImageWhenHighlighted;")
    public void setAdjustsImageWhenHighlighted(boolean adjustsImageWhenHighlighted) {
        states.adjustsImageWhenHighlighted = adjustsImageWhenHighlighted;
    }

    /**
     * Returns a value that shows whether this button is highlighted or not
     * after tapping.
     *
     * @return A Boolean that defines whether the button is highlighted or not.
     */
    @CMGetter("@property(nonatomic) BOOL showsTouchWhenHighlighted;")
    public boolean showsTouchWhenHighlighted() {
        return states.showsTouchWhenHighlighted;
    }

    /**
     * Sets a value that defines whether this button is highlighted or not when
     * tapped.
     *
     * @param showsTouchWhenHighlighted A Boolean that defines whether the
     *                                  button is highlighted or not.
     */
    @CMSetter("@property(nonatomic) BOOL showsTouchWhenHighlighted;")
    public void setShowsTouchWhenHighlighted(boolean showsTouchWhenHighlighted) {
        states.showsTouchWhenHighlighted = showsTouchWhenHighlighted;
    }

    @Override
    public void setHighlighted(boolean highlighted) {
        super.setHighlighted(highlighted);
        if (highlighted)
            states.setState((byte) Highlighted);
        else
            states.clearState((byte) Highlighted);
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected)
            states.setState((byte) Selected);
        else
            states.clearState((byte) Selected);
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled)
            states.clearState((byte) Disabled);
        else
            states.setState((byte) Disabled);
        dirtyVisuals = true;
        setNeedsDisplay();
    }

    @Override
    public void drawRect(CGRect rect) {
        if (dirtyVisuals)
            updateVisuals();
        Promise<UIImage> img = states.getBack();
        if (img != null)
            if (buttonType == UIButtonType.Custom && !isEnabled()) {
                CGContext cx = UIGraphics.getCurrentContext();
                cx.setAlpha(0.5);
                img.get().drawInRect(rect);
                cx.setAlpha(alpha());
            } else
                img.get().drawInRect(rect);
    }

    @Override
    public CGSize intrinsicContentSize() {
        if (dirtyVisuals)
            updateVisuals();
        return super.intrinsicContentSize();
    }

    @Override
    public UIView viewForLastBaselineLayout() {
        return label; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UIView viewForFirstBaselineLayout() {
        return label; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setContentHorizontalAlignment(int UIControlContentHorizontalAlignment) {
        super.setContentHorizontalAlignment(UIControlContentHorizontalAlignment);
        switch (UIControlContentHorizontalAlignment) {
            case crossmobile.ios.uikit.UIControlContentHorizontalAlignment.Center:
                label.setTextAlignment(UITextAlignment.Center);
                break;
            case crossmobile.ios.uikit.UIControlContentHorizontalAlignment.Left:
                label.setTextAlignment(UITextAlignment.Left);
                break;
            case crossmobile.ios.uikit.UIControlContentHorizontalAlignment.Right:
                label.setTextAlignment(UITextAlignment.Right);
                break;
            default:
                label.setTextAlignment(UITextAlignment.Center);
        }
    }

    @Override
    public void tintColorDidChange() {
        super.tintColorDidChange();
        states.invalidate();
        dirtyVisuals = true;
    }

    private UIImage maybeSource(Promise<UIImage> source) {
        return source == null ? null : source.source();
    }

    void updateVisuals() {
        if (!dirtyVisuals)
            return;
        Promise<UIImage> imagePromise = states.getFore();
        CGSize imageSize = imagePromise == null || imagePromise.source() == null ? null : imagePromise.source().size();
        String labelText = states.getTitle();
        CGSize labelSize = labelText == null ? null : label.intrinsicContentSize;

        if (imageSize == null)
            imageView.setHidden(true);
        else {
            imageView.setHidden(false);
            imageView.setImage(imagePromise);
        }
        if (labelText == null)
            label.setHidden(true);
        else {
            label.setHidden(false);
            label.setText(labelText);
            label.setShadowColor(states.getShadowColor());
            label.setTextColor(isEnabled() ? states.getTitleColor(tintColor()) : UIColor.grayColor());
        }

        double hasWidth = cframe().getSize().getWidth();
        double hasHeight = cframe().getSize().getHeight();
        if (labelSize != null && imageSize != null && hasWidth <= imageSize.getWidth()) {
            // when both text & image exists, and the width is not big enough, hide the label
            labelSize = null;
            label.setHidden(true);
        }
        double needsWidth = (imageSize == null ? 0 : imageSize.getWidth()) + (labelSize == null ? 0 : labelSize.getWidth());
        double needsHeight = (imageSize == null ? 0 : imageSize.getHeight()) + (labelSize == null ? 0 : labelSize.getHeight());
        setIntrinsicContentSize(needsWidth, needsHeight);
        if (imageSize != null) {
            CGRect frame = getInternalViewFrame(needsWidth, hasWidth, needsHeight, hasHeight);
            if (labelSize == null)
                imageView.setFrame(frame);
            else {
                double imgWidth = imageSize.getWidth();
                if (contentHorizontalAlignment() == UIControlContentHorizontalAlignment.Fill) {
                    // how to distribute additional horizontal space, when content should fill the place
                    double extra = hasWidth - needsWidth;
                    if (extra > 0)
                        imgWidth += extra * imageSize.getWidth() / (imageSize.getWidth() + labelSize.getWidth());
                }
                int vertical = contentVerticalAlignment();
                Pair<Double, Double> imgVert = calcLocation(imageSize.getHeight(), hasHeight,
                        vertical == UIControlContentVerticalAlignment.Fill,
                        vertical == UIControlContentVerticalAlignment.Top,
                        vertical == UIControlContentVerticalAlignment.Center,
                        vertical == UIControlContentVerticalAlignment.Bottom);
                Pair<Double, Double> lblVert = calcLocation(labelSize.getHeight(), hasHeight,
                        vertical == UIControlContentVerticalAlignment.Fill,
                        vertical == UIControlContentVerticalAlignment.Top,
                        vertical == UIControlContentVerticalAlignment.Center,
                        vertical == UIControlContentVerticalAlignment.Bottom);
                imageView.setFrame(new CGRect(frame.getOrigin().getX(), imgVert.a, imgWidth, imgVert.b));
                label.setFrame(new CGRect(frame.getOrigin().getX() + imageSize.getWidth(), lblVert.a,
                        frame.getSize().getWidth() - imgWidth, lblVert.b));
            }
        } else if (labelSize != null)
            label.setFrame(getInternalViewFrame(needsWidth, hasWidth, needsHeight, hasHeight));
        dirtyVisuals = false;
    }

    private Pair<Double, Double> calcLocation(double needs, double has, boolean fill, boolean leading, boolean center, boolean trailing) {
        double origin;
        double size = fill ? has : Math.min(needs, has);
        if (leading)
            origin = 0;
        else if (trailing)
            origin = needs > has ? 0 : has - needs;
        else if (center)
            origin = needs > has ? 0 : (has - needs) / 2;
        else // fill
            origin = has;
        return new Pair<>(origin, size);
    }

    private CGRect getInternalViewFrame(double needsWidth, double hasWidth, double needsHeight, double hasHeight) {
        int horizontal = contentHorizontalAlignment();
        if (horizontal == UIControlContentHorizontalAlignment.Leading)
            horizontal = userInterfaceLayoutDirection() == UIUserInterfaceLayoutDirection.LeftToRight
                    ? UIControlContentHorizontalAlignment.Left : UIControlContentHorizontalAlignment.Right;
        else if (horizontal == UIControlContentHorizontalAlignment.Trailing)
            horizontal = userInterfaceLayoutDirection() == UIUserInterfaceLayoutDirection.LeftToRight
                    ? UIControlContentHorizontalAlignment.Right : UIControlContentHorizontalAlignment.Left;
        int vertical = contentVerticalAlignment();
        Pair<Double, Double> hLoc = calcLocation(needsWidth, hasWidth,
                horizontal == UIControlContentHorizontalAlignment.Fill,
                horizontal == UIControlContentHorizontalAlignment.Left,
                horizontal == UIControlContentHorizontalAlignment.Center,
                horizontal == UIControlContentHorizontalAlignment.Right);
        Pair<Double, Double> vLoc = calcLocation(needsHeight, hasHeight,
                vertical == UIControlContentVerticalAlignment.Fill,
                vertical == UIControlContentVerticalAlignment.Top,
                vertical == UIControlContentVerticalAlignment.Center,
                vertical == UIControlContentVerticalAlignment.Bottom);
        return new CGRect(hLoc.a, vLoc.a, hLoc.b, vLoc.b);
    }
}
