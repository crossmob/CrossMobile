/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;


import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bind.graphics.theme.PainterExtraData;
import org.crossmobile.bind.graphics.theme.SliderPainter;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

/**
 * UISlider class defines an object that is used when there is a need to select
 * a specific value between a min and max value. Visually it is depicted as a
 * slider bar with a indicating point that the user is able to move increasing
 * or decreasing the selected value.
 */
@CMClass
public class UISlider extends UIControl {

    private float minimumValue = 0.0f;
    private float maximumValue = 1.0f;
    private float value = 0f;
    private boolean continuous = true;
    private UIImage minimumValueImage = null;
    private UIImage maximumValueImage = null;
    private UIImage currentMinimumTrackImage = null;
    private UIImage currentMaximumTrackImage = null;
    private UIImage currentThumbImage = null;

    private UIColor minimumTrackTintColor = null;
    private UIColor maximumTrackTintColor = Theme.Color.TOOLBACK;
    private UIColor thumbTintColor;

    private final PainterExtraData extraData;

    /**
     * Constructs a default slider object located at (0,0) with 0 weight and 0
     * height.
     */
    public UISlider() {
        this(CGRect.zero());
    }

    /**
     * Constructs a slider object initialized with the dimensions and position
     * specified in the frame parameter.
     *
     * @param rect CGRect that defines dimension and position of the slider.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UISlider(CGRect rect) {
        super(rect);
        extraData = painter().initExtraData();
        painter().setThumbColor(null, extraData);
    }

    @SuppressWarnings("unchecked")
    private SliderPainter<PainterExtraData> painter() {
        return (SliderPainter<PainterExtraData>) painter;
    }

    private void setValueFromTouch(Set<UITouch> touches) {
        double cValue = painter().setSliderLocation(touches.iterator().next().locationInView(this).getX(), cframe().getSize().getWidth(), extraData);
        setValue((float) (minimumValue + (maximumValue - minimumValue) * cValue));
        setNeedsDisplay();
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        painter().setPressed(true, extraData);
        setValueFromTouch(touches);
        if (continuous)
            sendActionsForControlEvents(UIControlEvents.ValueChanged, event);
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        touchesBegan(touches, event);
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        painter().setPressed(false, extraData);
        setValueFromTouch(touches);
        if (!continuous)
            sendActionsForControlEvents(UIControlEvents.ValueChanged, event);
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        touchesEnded(touches, event);
    }

    /**
     * Sets the current value for the control.
     *
     * @param val The current value for the control.
     */
    @CMSetter("@property(nonatomic) float value;")
    public void setValue(float val) {
        setValue(val, false);
    }

    /**
     * Sets the current value of the control using animation or not.
     *
     * @param val      The current value for the control.
     * @param animated TRUE if animation will be used for the change.
     */
    @CMSelector("- (void)setValue:(float)value \n"
            + "        animated:(BOOL)animated;")
    public void setValue(float val, boolean animated) {
        if (val < minimumValue)
            val = minimumValue;
        if (val > maximumValue)
            val = maximumValue;
        value = val;
        setNeedsDisplay();
    }

    /**
     * Returns the current value of the control.
     *
     * @return The current value of the control.
     */
    @CMGetter("@property(nonatomic) float value;\n"
            + "")
    public float value() {
        return value;
    }

    /**
     * Sets the minimum value of the control.
     *
     * @param min The minimum value of the control.
     */
    @CMSetter("@property(nonatomic) float minimumValue;\n"
            + "")
    public void setMinimumValue(float min) {
        minimumValue = min;
        if (maximumValue < minimumValue)
            maximumValue = minimumValue;
        if (value < minimumValue)
            value = minimumValue;
        setNeedsDisplay();
    }

    /**
     * Returns the minimum value of the control.
     *
     * @return The minimum value of the control.
     */
    @CMGetter("@property(nonatomic) float minimumValue;\n"
            + "")
    public float minimumValue() {
        return minimumValue;
    }

    /**
     * Sets the maximum value of the control.
     *
     * @param max The maximum value of the control.
     */
    @CMSetter("@property(nonatomic) float maximumValue;")
    public void setMaximumValue(float max) {
        maximumValue = max;
        if (minimumValue > maximumValue)
            minimumValue = maximumValue;
        if (value > maximumValue)
            value = minimumValue;
        setNeedsDisplay();
    }

    /**
     * Returns the maximum value of the control.
     *
     * @return The maximum value of the control.The default value is 1.0.
     */
    @CMGetter("@property(nonatomic) float maximumValue;")
    public float maximumValue() {
        return maximumValue;
    }

    /**
     * Returns a Boolean that shows whether change of the slider value causes
     * immediate update event.
     *
     * @return Contains a Boolean that shows whether change of the slider value
     * causes immediate update event.
     */
    @CMGetter("@property(nonatomic, getter=isContinuous) BOOL continuous;")
    public boolean isContinuous() {
        return continuous;
    }

    /**
     * Sets a Boolean that shows whether change of the slider value causes
     * immediate update event.
     *
     * @param continuous TRUE means immediate continuous updates.
     */
    @CMSetter("@property(nonatomic, getter=isContinuous) BOOL continuous;")
    public void setContinuous(boolean continuous) {
        this.continuous = continuous;
    }

    /**
     * Returns the image that is depicted on the side of the slider and
     * represents the maximum value of the control.
     *
     * @return The image that is depicted on the side of the slider and
     * represents the maximum value of the control.
     */
    @CMGetter("@property(nonatomic, strong) UIImage *maximumValueImage;")
    public UIImage maximumValueImage() {
        return maximumValueImage;
    }

    /**
     * Sets the image that will be depicted on the side of the slider and
     * represents the maximum value of the control.
     *
     * @param maximumValueImage The image that will be depicted on the side of
     *                          the slider and represents the maximum value of the control.
     */
    @CMSetter("@property(nonatomic, strong) UIImage *maximumValueImage;")
    public void setMaximumValueImage(UIImage maximumValueImage) {
        this.maximumValueImage = maximumValueImage;
        setNeedsDisplay();
    }

    /**
     * Returns the image that is depicted on the side of the slider and
     * represents the minimum value of the control.
     *
     * @return The image that is depicted on the side of the slider and
     * represents the minimum value of the control.
     */
    @CMGetter("@property(nonatomic, strong) UIImage *minimumValueImage;")
    public UIImage minimumValueImage() {
        return minimumValueImage;
    }

    /**
     * Sets the image that will be depicted on the side of the slider and
     * represents the minimum value of the control.
     *
     * @param minimumValueImage The image that will be depicted on the side of
     *                          the slider and represents the minimum value of the control.
     */
    @CMSetter("@property(nonatomic, strong) UIImage *minimumValueImage;")
    public void setMinimumValueImage(UIImage minimumValueImage) {
        this.minimumValueImage = minimumValueImage;
        setNeedsDisplay();
    }

    /**
     * Returns the current minimum track image
     *
     * @return The current minimum track image
     */
    @CMGetter("@property(nonatomic, readonly) UIImage *currentMinimumTrackImage;")
    public UIImage currentMinimumTrackImage() {
        return currentMinimumTrackImage;
    }

    /**
     * Returns the minimum track image that is used in the specified control
     * state.
     *
     * @param UIControlState The control state for which the image is requested.
     * @return The minimum thumb image that is associated with the specified
     * control state.
     */
    @CMSelector("- (UIImage *)minimumTrackImageForState:(UIControlState)state;")
    public UIImage minimumTrackImageForState(int UIControlState) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Sets the specified minimum thumb image to be used in the specified
     * control state.
     *
     * @param image          The specified minimum thumb image to be used in the
     *                       specified control state.
     * @param UIControlState The control state associated with the image.
     */
    @CMSelector("- (void)setMinimumTrackImage:(UIImage *)image \n"
            + "                    forState:(UIControlState)state;")
    public void setMinimumTrackImage(UIImage image, int UIControlState) {
        Native.system().notImplemented();
    }

    /**
     * Returns the maximum track image that is currently used.
     *
     * @return The maximum track image that is currently used.
     */
    @CMGetter("@property(nonatomic, readonly) UIImage *currentMaximumTrackImage;")
    public UIImage currentMaximumTrackImage() {
        return currentMaximumTrackImage;
    }

    /**
     * Returns the maximum track image that is used in the specified control
     * state.
     *
     * @param UIControlState The control state for which the image is requested.
     * @return The maximum thumb image that is associated with the specified
     * control state.NULL if it could not be found.
     */
    @CMSelector("- (UIImage *)maximumTrackImageForState:(UIControlState)state;")
    public UIImage maximumTrackImageForState(int UIControlState) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Sets the specified maximum thumb image to be used in the specified
     * control state.
     *
     * @param image          The specified maximum thumb image to be used in the
     *                       specified control state.
     * @param UIControlState The control state associated with the image.
     */
    @CMSelector("- (void)setMaximumTrackImage:(UIImage *)image \n"
            + "                    forState:(UIControlState)state;")
    public void setMaximumTrackImage(UIImage image, int UIControlState) {
        Native.system().notImplemented();
    }

    /**
     * Returns the thumb image that is associated with the current active
     * control state.
     *
     * @return The thumb image that is associated with the current active
     * control state.
     */
    @CMGetter("@property(nonatomic, readonly) UIImage *currentThumbImage;")
    public UIImage currentThumbImage() {
        return currentThumbImage;
    }

    /**
     * Returns the thumb image for the specified control state.
     *
     * @param UIControlState The control state for which the image is requested.
     * @return The thumb image that is associated with the specified control
     * state.
     */
    @CMSelector("- (UIImage *)thumbImageForState:(UIControlState)state;")
    public UIImage thumbImageForState(int UIControlState) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Sets the specified thumb image to be used in the specified control state.
     *
     * @param image          The thumb image to be used in the specified control state.
     * @param UIControlState The control state associated with the image.
     */
    @CMSelector("- (void)setThumbImage:(UIImage *)image \n"
            + "             forState:(UIControlState)state;")
    public void setThumbImage(UIImage image, int UIControlState) {
        Native.system().notImplemented();
    }

    /**
     * Returns the color of track images.
     *
     * @return The color of track images.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *minimumTrackTintColor;")
    public UIColor minimumTrackTintColor() {
        return minimumTrackTintColor == null ? tintColor() : minimumTrackTintColor;
    }

    /**
     * Sets the color of standard minimum track images.
     *
     * @param minimumTrackTintColor The color of standard minimum track images.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *minimumTrackTintColor;")
    public void setMinimumTrackTintColor(UIColor minimumTrackTintColor) {
        this.minimumTrackTintColor = minimumTrackTintColor;
        setNeedsDisplay();
    }

    /**
     * Returns the color of standard maximum track images.
     *
     * @return The color of standard maximum track images.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *maximumTrackTintColor;")
    public UIColor maximumTrackTintColor() {
        return maximumTrackTintColor;
    }

    /**
     * Sets the color of standard maximum track images.
     *
     * @param maximumTrackTintColor The color of standard maximum track images.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *maximumTrackTintColor;")
    public void setMaximumTrackTintColor(UIColor maximumTrackTintColor) {
        this.maximumTrackTintColor = maximumTrackTintColor;
        setNeedsDisplay();
    }

    /**
     * Returns the color of the thumb images.
     *
     * @return The color of the thumb images.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *thumbTintColor;")
    public UIColor thumbTintColor() {
        return thumbTintColor;
    }

    /**
     * Sets the color of the thumb images.
     *
     * @param thumbTintColor The color of the thumb images.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *thumbTintColor;")
    public void setThumbTintColor(UIColor thumbTintColor) {
        this.thumbTintColor = thumbTintColor;
        painter().setThumbColor(thumbTintColor, extraData);
        setNeedsDisplay();
    }

    @Override
    public final void drawRect(CGRect rect) {
        painter().draw(this, rect, extraData);
    }
}
