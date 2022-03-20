/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPathDrawingMode;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSTimer;
import org.crossmobile.bridge.ann.*;

/**
 * UIStepper class defines an object that is depicted as two buttons(plus and
 * minus). The user can press one of them in order to increase or decrease a
 * value.
 */
@CMClass
public class UIStepper extends UIControl {

    private static final int HEIGHT = 28;
    private static final int WIDTH = 48;

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
    private final StepperTimer timer = new StepperTimer();

    /**
     * Constructs a default UIStepper object located at (0,0) with 0 weight and
     * 0 height.
     */
    public UIStepper() {
        this(null);
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
        super(CGRect.zero());
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

        incrementButton.setTitle("+", UIControlState.Normal);
        incrementButton.addTarget((sender, event) -> timer.start(1), UIControlEvents.TouchDown);
        incrementButton.addTarget((sender, event) -> timer.stop(), UIControlEvents.TouchUpInside | UIControlEvents.TouchUpOutside);
        incrementButton.titleLabel().setAdjustsFontSizeToFitWidth(true);
        incrementButton.setFrame(new CGRect(WIDTH, 0, WIDTH, HEIGHT));

        decrementButton.setTitle("-", UIControlState.Normal);
        decrementButton.addTarget((sender, event) -> timer.start(-1), UIControlEvents.TouchDown);
        decrementButton.addTarget((sender, event) -> timer.stop(), UIControlEvents.TouchUpInside | UIControlEvents.TouchUpOutside);
        decrementButton.titleLabel().setAdjustsFontSizeToFitWidth(true);
        decrementButton.setFrame(new CGRect(0, 0, WIDTH, HEIGHT));
        decrementButton.setEnabled(wraps);

        addSubview(decrementButton);
        addSubview(incrementButton);
        setFrame(frame == null ? 0 : frame.getOrigin().getX(), frame == null ? 0 : frame.getOrigin().getY());
    }

    @Override
    public void setFrame(CGRect frame) {
        setFrame(frame.getOrigin().getX(), frame.getOrigin().getY());
    }

    private void setFrame(double x, double y) {
        super.setFrame(new CGRect(x, y, WIDTH * 2, HEIGHT));
    }

    /**
     * Determine whether the value is sent immediately after change.
     *
     * @return A Boolean that shows whether the value is sent immediately after
     * change.
     */
    @CMGetter("@property(nonatomic, getter=isContinuous) BOOL continuous;")
    public boolean isContinuous() {
        return continuous;
    }

    /**
     * Sets whether the value is sent immediately after change.
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
        setValue(value, false);
    }

    private void setValue(double value, boolean fireEvent) {
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
        if (fireEvent)
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

    private class StepperTimer {
        private NSTimer timer;
        private double cValue;
        private double sign;
        private int updateCycle;
        private int updateSteps;

        void start(double sign) {
            this.sign = sign;
            this.cValue = value + sign * stepValue;
            this.updateCycle = 10;
            this.updateSteps = 0;
            if (autorepeat) {
                synchronized (this) {
                    if (timer == null)
                        timer = NSTimer.scheduledTimerWithTimeInterval(0.05, t -> {
                            updateSteps++;
                            if (updateCycle <= 1 || (updateSteps % updateCycle) == 0) {
                                updateCycle--;
                                updateSteps = 0;
                                cValue += this.sign * stepValue;
                                if (continuous)
                                    updateValue();
                                if (!wraps)
                                    if (cValue < minimumValue || cValue > maximumValue)
                                        stop();
                            }
                        }, this, true);
                }
            }
            updateValue();
        }

        void stop() {
            synchronized (this) {
                if (timer != null) {
                    timer.invalidate();
                    timer = null;
                }
            }
            updateValue();
        }

        private void updateValue() {
            if (value != cValue)
                setValue(cValue, true);
        }
    }
}
