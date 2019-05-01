/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.uikit;


import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

import static crossmobile.ios.coregraphics.$coregraphics.color;
import static crossmobile.ios.coregraphics.$coregraphics.context;
import static org.crossmobile.bind.graphics.Theme.Slider.THUMB_SIZE;

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
    //
    private UIColor minimumTrackTintColor = null;
    private UIColor maximumTrackTintColor = Theme.Color.TOOLBACK;
    private UIColor thumbTintColor = Theme.Color.THUMB;
    private UIColor thumbDownTintColor = pressedColor(thumbTintColor);
    //
    //
    private boolean isDown = false;

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
    }

    private void setValueFromTouch(UITouch touch) {
        double where = touch.locationInView(this).getX() - THUMB_SIZE / 2f;
        double track_moving_area = getWidth() - THUMB_SIZE;
        if (where < 0)
            where = 0;
        if (where > track_moving_area)
            where = track_moving_area;
        setValue((float) (minimumValue + (maximumValue - minimumValue) * where / track_moving_area));
        Native.graphics().refreshDisplay();
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        isDown = true;
        setValueFromTouch(touches.iterator().next());
        if (continuous)
            sendActionsForControlEvents(UIControlEvents.ValueChanged, event);
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        touchesBegan(touches, event);
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        isDown = false;
        setValueFromTouch(touches.iterator().next());
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
        Native.graphics().refreshDisplay();
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
        Native.graphics().refreshDisplay();
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
        Native.graphics().refreshDisplay();
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
        Native.graphics().refreshDisplay();
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
        Native.graphics().refreshDisplay();
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
        Native.lifecycle().notImplemented();
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
        Native.lifecycle().notImplemented();
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
        Native.lifecycle().notImplemented();
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
        Native.lifecycle().notImplemented();
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
        Native.lifecycle().notImplemented();
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
        Native.lifecycle().notImplemented();
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
        Native.graphics().refreshDisplay();
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
        Native.graphics().refreshDisplay();
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
        thumbDownTintColor = pressedColor(thumbTintColor);
        Native.graphics().refreshDisplay();
    }

    @Override
    public final void drawRect(CGRect rect) {
        CGContext cx = UIGraphics.getCurrentContext();
        GraphicsContext gcx = context(cx);
        double percent = value / (maximumValue - minimumValue);

        int offset = Theme.Slider.ISBORDERED ? 1 : 0;
        double track_moving_area = rect.getSize().getWidth() - THUMB_SIZE;
        double track_minimum = THUMB_SIZE / 2 + track_moving_area * percent;
        float dy = (Theme.Slider.THUMB_SIZE - Theme.Slider.HEIGHT) / 2;
        if (Theme.Slider.ISSQUARED) {
            gcx.setFillColorWithColor(color(maximumTrackTintColor.cgcolor));
            if (Theme.Slider.ISBORDERED)
                gcx.fillRect(rect.getOrigin().getX(), rect.getOrigin().getY() + dy, rect.getSize().getWidth(), Theme.Slider.HEIGHT);
            else
                gcx.fillRect(rect.getOrigin().getX() + offset + track_minimum, rect.getOrigin().getY() + dy, rect.getSize().getWidth() - offset - track_minimum, Theme.Slider.HEIGHT);
            gcx.setFillColorWithColor(color(minimumTrackTintColor().cgcolor));
            gcx.fillRect(rect.getOrigin().getX() + offset, rect.getOrigin().getY() + dy + offset, track_minimum, Theme.Slider.HEIGHT - offset * 2);
        } else {
            if (Theme.Slider.ISBORDERED)
                gcx.fillRoundRodBar(rect.getOrigin().getX(), rect.getOrigin().getY() + dy, rect.getSize().getWidth(), Theme.Slider.HEIGHT, color(maximumTrackTintColor.cgcolor));
            else
                gcx.fillHalfRoundRodBar(rect.getOrigin().getX() + offset + track_minimum, rect.getOrigin().getY() + dy, rect.getSize().getWidth() - offset - track_minimum, Theme.Slider.HEIGHT, color(maximumTrackTintColor.cgcolor), true, false);
            gcx.fillHalfRoundRodBar(rect.getOrigin().getX() + offset, rect.getOrigin().getY() + dy + offset, track_minimum, Theme.Slider.HEIGHT - offset * 2, color(minimumTrackTintColor().cgcolor), true, true);
        }

        gcx.setFillColorWithColor(color(isDown ? thumbDownTintColor.cgcolor : thumbTintColor.cgcolor));
        gcx.fillEllipse(rect.getOrigin().getX() + track_minimum - Theme.Slider.THUMB_SIZE / 2, rect.getOrigin().getY(), Theme.Slider.THUMB_SIZE, Theme.Slider.THUMB_SIZE);
        gcx.setFillColorWithColor(color(Theme.Color.SHADOW.cgcolor));
        gcx.drawEllipse(rect.getOrigin().getX() + track_minimum - Theme.Slider.THUMB_SIZE / 2, rect.getOrigin().getY(), Theme.Slider.THUMB_SIZE, Theme.Slider.THUMB_SIZE);

        cmButtonStates.thumb().drawInRect(new CGRect(rect.getOrigin().getX() + track_minimum - Theme.Slider.THUMB_SIZE / 2, rect.getOrigin().getY(), Theme.Slider.THUMB_SIZE, Theme.Slider.THUMB_SIZE));
    }

}
