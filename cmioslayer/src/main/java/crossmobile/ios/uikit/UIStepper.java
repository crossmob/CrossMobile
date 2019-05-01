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
 * You should have received attr copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPathDrawingMode;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSTimer;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

/**
 * UIStepper class defines an object that is depicted as two buttons(plus and
 * minus). The user can press one of them in order to increase or decrease a
 * value.
 */
@CMClass
public class UIStepper extends UIControl {

    private static final int MAX_HEIGHT = 29;

    private boolean continuous = true;
    private boolean autorepeat = true;
    private boolean wraps = false;
    private double minimumValue = 0;
    private double maximumValue = 100;
    private double stepValue = 1;
    private double value = 0;
    private UIButton incrementButton;
    private UIButton decrementButton;
    private UIImageView backgroundImg;
    private NSTimer timer;
    private double changeRange;

    /**
     * Constructs a default UIStepper object located at (0,0) with 0 weight and
     * 0 height.
     */
    public UIStepper() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIStepper object initialized with the dimensions and
     * position specified in the frame parameter.
     *
     * @param frame CGRect that defines dimension and position of UIStepper.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UIStepper(CGRect frame) {
        super(frame);
        setBackgroundColor(UIColor.clearColor());
        addbuttons();
    }

    /**
     * Returns a Boolean that shows whether the value is sent immediately after
     * change.
     *
     * @return A Boolean that shows whether the value is sent immediately after
     * change.
     */
    @CMGetter("@property(nonatomic, getter=isContinuous) BOOL continuous;")
    public boolean isContinuous() {
        return continuous;
    }

    /**
     * Sets a Boolean that defines whether the value is sent immediately after
     * change.
     *
     * @param continuous A Boolean that defines whether the value is sent
     *                   immediately after change.
     */
    @CMSetter("@property(nonatomic, getter=isContinuous) BOOL continuous;")
    public void setContinuous(boolean continuous) {
        this.continuous = continuous;
    }

    /**
     * Returns a Boolean that shows what happens when the user presses and holds
     * the stepper.
     *
     * @return TRUE the value keeps changing when pressing and holding the
     * stepper.
     */
    @CMGetter("@property(nonatomic) BOOL autorepeat;")
    public boolean autorepeat() {
        return autorepeat;
    }

    /**
     * Sets a Boolean that defines what happens when the user presses and holds
     * the stepper.
     *
     * @param autorepeat TRUE the value keeps changing when pressing and holding
     *                   the stepper.
     */
    @CMSetter("@property(nonatomic) BOOL autorepeat;")
    public void setAutorepeat(boolean autorepeat) {
        this.autorepeat = autorepeat;
    }

    /**
     * Returns a Boolean that shows what happens when the user tries to exceed
     * the maximum or minimum values.
     *
     * @return TRUE when the user tries to exceed the maximum or minimum value,
     * the stepper value is set to opposite threshold.FALSE nothing happens.
     */
    @CMGetter("@property(nonatomic) BOOL wraps;")
    public boolean wraps() {
        return wraps;
    }

    /**
     * Sets a Boolean that defines what happens when the user tries to exceed
     * the maximum or minimum values.
     *
     * @param wraps TRUE when the user tries to exceed the maximum or minimum
     *              value, the stepper value is set to opposite threshold.FALSE nothing
     *              happens.
     */
    @CMSetter("@property(nonatomic) BOOL wraps;")
    public void setWraps(boolean wraps) {
        this.wraps = wraps;
        incrementButton.setEnabled(true);
        decrementButton.setEnabled(true);
    }

    /**
     * Returns the minimum value of this stepper.
     *
     * @return The minimum value of this stepper.
     */
    @CMGetter("@property(nonatomic) double minimumValue;")
    public double minimumValue() {
        return minimumValue;
    }

    /**
     * Sets the minimum value for this stepper.
     *
     * @param minimumValue The minimum value for this stepper.
     */
    @CMSetter("@property(nonatomic) double minimumValue;")
    public void setMinimumValue(double minimumValue) {
        try {
            if (minimumValue > maximumValue)
                throw new Exception(" NSInvalidArgumentException");
            this.minimumValue = minimumValue;
        } catch (Exception e) {
        }
    }

    /**
     * Returns the maximum value of this stepper.
     *
     * @return The maximum value of this stepper.
     */
    @CMGetter("@property(nonatomic) double maximumValue;")
    public double maximumValue() {
        return maximumValue;
    }

    /**
     * Sets the maximum value for this stepper.
     *
     * @param maximumValue The maximum value for this stepper.
     */
    @CMSetter("@property(nonatomic) double maximumValue;")
    public void setMaximumValue(double maximumValue) {
        try {
            if (minimumValue > maximumValue)
                throw new Exception(" NSInvalidArgumentException");
            this.maximumValue = maximumValue;
        } catch (Exception e) {
        }
    }

    /**
     * Returns the step value of this stepper.
     *
     * @return The step value of this stepper.
     */
    @CMGetter("@property(nonatomic) double stepValue;")
    public double stepValue() {
        return stepValue;
    }

    /**
     * Sets the step value for this stepper.
     *
     * @param stepValue The step value of this stepper.
     */
    @CMSetter("@property(nonatomic) double stepValue;")
    public void setStepValue(double stepValue) {
        try {
            if (stepValue <= 0)
                throw new Exception(" NSInvalidArgumentException");
            this.stepValue = stepValue;
        } catch (Exception e) {
        }
    }

    /**
     * Returns the current numeric value of this stepper.
     *
     * @return The current numeric value of this stepper.
     */
    @CMGetter("@property(nonatomic) double value;")
    public double value() {
        return value;
    }

    /**
     * Sets the numeric value of the stepper.
     *
     * @param value The numeric value of the stepper.
     */
    @CMSetter("@property(nonatomic) double value;")
    public void setValue(double value) {
        setValue(value, null);
    }

    void setValue(double value, UIEvent event) {
        this.value = (wraps)
                ? (value > maximumValue) ? minimumValue : (value < minimumValue) ? maximumValue : value
                : (value > maximumValue) ? maximumValue : (value < minimumValue) ? minimumValue : value;
        if (!wraps)
            if (this.value == maximumValue)
                incrementButton.setEnabled(false);
            else if (this.value == minimumValue)
                decrementButton.setEnabled(false);
            else {
                incrementButton.setEnabled(true);
                decrementButton.setEnabled(true);
            }
        sendActionsForControlEvents(UIControlEvents.ValueChanged);
    }

    @Override
    public UIColor tintColor() {
        return super.tintColor();
    }

    @Override
    public void setTintColor(UIColor tintColor) {
        incrementButton.setTintColor(tintColor);
        decrementButton.setTintColor(tintColor);
        super.setTintColor(tintColor);
    }

    @Override
    public final void drawRect(CGRect rect) {
        super.drawRect(rect);

    }

    /**
     * Returns the background image of the specified control state.
     *
     * @param UIControlState The control state for which the image is requested.
     * @return The image of the specified control state.
     */
    @CMSelector("- (UIImage *)backgroundImageForState:(UIControlState)state;")
    public UIImage backgroundImageForState(int UIControlState) {
        return null;
    }

    /**
     * Sets the background for the specified control state.
     *
     * @param image          The image used for the background.
     * @param UIControlState The control state for which the image is selected.
     */
    @CMSelector("- (void)setBackgroundImage:(UIImage *)image \n"
            + "                  forState:(UIControlState)state;")
    public void setBackgroundImage(UIImage image, int UIControlState) {
    }

    /**
     * Returns the image used for the decrement of the specified control state.
     *
     * @param UIControlState The control state for which the image is returned.
     * @return The image used for the decrement of the specified control state.
     */
    @CMSelector("- (UIImage *)decrementImageForState:(UIControlState)state;")
    public UIImage decrementImageForState(int UIControlState) {
        return decrementButton.imageForState(UIControlState);
    }

    /**
     * Sets the image to use for the decrement of the specified control state.
     *
     * @param image          The image used for the decrement.
     * @param UIControlState The control state for which the image is selected.
     */
    @CMSelector("- (void)setDecrementImage:(UIImage *)image \n"
            + "                 forState:(UIControlState)state;")
    public void setDecrementImage(UIImage image, int UIControlState) {
        decrementButton.setImage(image, UIControlState);
    }

    /**
     * Returns the divider image used for the specified control states.
     *
     * @param UIControlStateLeftState  The left control state for which the image
     *                                 is set.
     * @param UIControlStateRightstate The right control state for which the
     *                                 image is set.
     * @return The image used for the specified control states.
     */
    @CMSelector("- (UIImage *)dividerImageForLeftSegmentState:(UIControlState)state \n"
            + "                           rightSegmentState:(UIControlState)state;")
    public UIImage dividerImageForLeftSegmentState(int UIControlStateLeftState, int UIControlStateRightstate) {
        return null;
    }

    /**
     * Sets the divider image used for the specified control states.
     *
     * @param image                    The image used for the specified control states.
     * @param UIControlStateLeftState  The left control state for which the image
     *                                 is set.
     * @param UIControlStateRightstate The right control state for which the
     *                                 image is set.
     */
    @CMSelector("- (void)setDividerImage:(UIImage *)image \n"
            + "    forLeftSegmentState:(UIControlState)leftState \n"
            + "      rightSegmentState:(UIControlState)rightState;")
    public void setDividerImage(UIImage image, int UIControlStateLeftState, int UIControlStateRightstate) {

    }

    /**
     * Returns the image that corresponds to the specified control state.
     *
     * @param UIControlState The control state for which the image is requested.
     * @return The image for this control state.
     */
    @CMSelector("- (UIImage *)incrementImageForState:(UIControlState)state;")
    public UIImage incrementImageForState(int UIControlState) {
        return incrementButton.imageForState(UIControlState);
    }

    /**
     * Sets the specified image for the specified control state.
     *
     * @param image          The image for the specified control state.
     * @param UIControlState The control state for which the the image is set.
     */
    @CMSelector("- (void)setIncrementImage:(UIImage *)image \n"
            + "                 forState:(UIControlState)state;")
    public void setIncrementImage(UIImage image, int UIControlState) {
        incrementButton.setImage(image, UIControlState);
    }

    @Override
    public void layoutSubviews() {
        for (UIView v : subviews())
            v.removeFromSuperview();
        Native.system().runAndWaitOnEventThread(() -> {
            CGRect frame1 = frame();
            int actualX = 0;
            int actualWidth;
            double xRunner = 0;
            double desiredWidth = frame1.getSize().getWidth() / 2;
            double height = MAX_HEIGHT;
            /* Update metrics */
            xRunner += desiredWidth;
            actualWidth = (int) (xRunner - actualX + 0.5);
            decrementButton.setFrame(new CGRect(actualX, 0, actualWidth, height));
            addSubview(decrementButton);
            actualX += actualWidth;
            xRunner += desiredWidth;
            actualWidth = (int) (xRunner - actualX + 0.5);
            incrementButton.setFrame(new CGRect(actualX, 0, actualWidth, height));
            addSubview(incrementButton);
            actualX += actualWidth;
            Native.graphics().refreshDisplay();
        });
    }

    private void addbuttons() {
        incrementButton = new UIButton(UIButtonType.Custom) {
            @Override
            void drawOnTop(CGContext cx, CGRect rect) {
                if (imageForState(state()) == null) {
                    cx.setStrokeColorWithColor(tintColor().cgcolor);
                    cx.beginPath();
                    cx.moveToPoint(rect.getOrigin().getX(), rect.getOrigin().getY());
                    cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth() - 2, rect.getOrigin().getY());
                    cx.addCurveToPoint(rect.getOrigin().getX() + rect.getSize().getWidth() - 1, rect.getOrigin().getY() + 1, rect.getOrigin().getX() + rect.getSize().getWidth() - 1, rect.getOrigin().getY() + 1, rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY() + 2);
                    cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY() + rect.getSize().getHeight() - 2);
                    cx.addCurveToPoint(rect.getOrigin().getX() + rect.getSize().getWidth() - 1, rect.getOrigin().getY() + rect.getSize().getHeight() - 1, rect.getOrigin().getX() + rect.getSize().getWidth() - 1, rect.getOrigin().getY() + rect.getSize().getHeight() - 1, rect.getOrigin().getX() + rect.getSize().getWidth() - 2, rect.getOrigin().getY() + rect.getSize().getHeight());
                    cx.addLineToPoint(rect.getOrigin().getX(), rect.getOrigin().getY() + rect.getSize().getHeight());
                    cx.setLineWidth(1);
                    cx.drawPath(CGPathDrawingMode.Stroke);
                }
            }

            @Override
            boolean shouldDrawOnTop() {
                return true;
            }
        };
        incrementButton.setBackgroundColor(UIColor.clearColor());
        incrementButton.setTitle("+", UIControlState.Normal);
        incrementButton.addTarget((UIControl sender, UIEvent event) -> {
            if (timer.isValid())
                timer.invalidate();
            setValue(value + stepValue * ((changeRange > 0) ? changeRange : 1), event);
        }, UIControlEvents.TouchUpInside);
        incrementButton.titleLabel().setAdjustsFontSizeToFitWidth(true);
        incrementButton.addTarget(new UIControlDelegate() {
            @Override
            public void exec(UIControl sender, UIEvent event) {
                if (autorepeat)
                    timer = NSTimer.scheduledTimerWithTimeInterval(0.5, (NSTimer timer1) -> {
                        if (continuous)
                            setValue(value + stepValue, event);
                        else
                            changeRange++;
                        if (value == maximumValue && !wraps)
                            timer1.invalidate();
                    }, this, true);
            }
        }, UIControlEvents.TouchDown);
        decrementButton = new UIButton(UIButtonType.Custom) {
            @Override
            void drawOnTop(CGContext cx, CGRect rect) {
                if (imageForState(state()) == null) {

                    cx.setStrokeColorWithColor(tintColor().cgcolor);
                    cx.beginPath();
                    cx.moveToPoint(rect.getOrigin().getX() + 2, rect.getOrigin().getY());
                    cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY());
                    cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY() + rect.getSize().getHeight());
                    cx.addLineToPoint(rect.getOrigin().getX() + 2, rect.getOrigin().getY() + rect.getSize().getHeight());
                    cx.addCurveToPoint(rect.getOrigin().getX() + 1, rect.getOrigin().getY() + rect.getSize().getHeight() - 1, rect.getOrigin().getX() + 1, rect.getOrigin().getY() + rect.getSize().getHeight() - 1, rect.getOrigin().getX(), rect.getOrigin().getY() + rect.getSize().getHeight() - 2);
                    cx.addLineToPoint(rect.getOrigin().getX(), rect.getOrigin().getY() + 2);
                    cx.addCurveToPoint(rect.getOrigin().getX() + 1, rect.getOrigin().getY() + 1, rect.getOrigin().getX() + 1, rect.getOrigin().getY() + 1, rect.getOrigin().getX() + 2, rect.getOrigin().getY());
                    cx.setLineWidth(1);
                    cx.drawPath(CGPathDrawingMode.Stroke);
                }
            }

            @Override
            boolean shouldDrawOnTop() {
                return true;
            }

        };
        decrementButton.setBackgroundColor(UIColor.clearColor());
        decrementButton.setTitle("-", UIControlState.Normal);
        decrementButton.addTarget((UIControl sender, UIEvent event) -> {
            if (timer.isValid())
                timer.invalidate();
            setValue(value - stepValue * ((changeRange > 0) ? changeRange : 1), event);
        }, UIControlEvents.TouchUpInside);

        decrementButton.addTarget((UIControl sender, UIEvent event) -> {
            changeRange = 0;
            if (autorepeat)
                timer = NSTimer.scheduledTimerWithTimeInterval(0.5, (NSTimer timer1) -> {
                    if (continuous)
                        setValue(value - stepValue, event);
                    else
                        changeRange++;
                    if (value == minimumValue && !wraps)
                        timer1.invalidate();
                }, this, true);

        }, UIControlEvents.TouchDown);
        decrementButton.titleLabel().setAdjustsFontSizeToFitWidth(true);
        if (!wraps)
            decrementButton.setEnabled(false);
    }

}
