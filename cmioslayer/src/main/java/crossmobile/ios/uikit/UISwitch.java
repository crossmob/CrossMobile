/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.Geometry;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bind.graphics.theme.PainterExtraData;
import org.crossmobile.bind.graphics.theme.SwitchPainter;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

import static crossmobile.ios.coregraphics.GraphicsDrill.context;

/**
 * UISwitch class defines an object that is a button which acts as a switch of
 * two states,on and off. The user of the application can change the state of it
 * controlling that way a particular operation.
 */
@CMClass
public class UISwitch extends UIControl {

    private boolean on;
    private UIColor tintColor = Theme.Color.TOOLBACK;
    private UIColor onTintColor;
    private UIColor thumbTintColor;
    private CGPoint originalTouchPoint;
    private boolean dealAsClick;
    private final PainterExtraData extraData;

    /**
     * Constructs a default UISwitch object located at (0,0) with 0 weight and 0
     * height.
     */
    public UISwitch() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UISwitch object initialized with the dimensions and position
     * specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of the UISwitch.
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UISwitch(CGRect rect) {
        super(rect);
        extraData = painter().initExtraData();
        setOn(false, false);
        painter().setThumbColor(null, extraData);
    }

    @SuppressWarnings("unchecked")
    private SwitchPainter<PainterExtraData> painter() {
        return (SwitchPainter<PainterExtraData>) painter;
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        UITouch core = touches.iterator().next();
        originalTouchPoint = core.locationInView(this);
        painter().setPressed(true, extraData);
        painter().setSliderLocation(originalTouchPoint.getX(), extraData);
        dealAsClick = true;
        setNeedsDisplay();
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        UITouch core = touches.iterator().next();
        CGPoint location = core.locationInView(this);
        painter().setSliderLocation(location.getX(), extraData);
        if (dealAsClick && !Geometry.similarTo(originalTouchPoint, location, 3))
            dealAsClick = false;
        setNeedsDisplay();
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        painter().setPressed(false, extraData);
        boolean valueBasedOnLocation = painter().setSliderLocation(touches.iterator().next().locationInView(this).getX(), extraData);
        boolean newValue = dealAsClick ? !on : valueBasedOnLocation;
        boolean shouldSendEvent = newValue != on;
        setOn(newValue);
        if (shouldSendEvent)
            sendActionsForControlEvents(UIControlEvents.ValueChanged);
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        touchesEnded(touches, event);
    }

    /**
     * Returns a Boolean that defines whether the switch is on or off.
     *
     * @return TRUE the switch is on.
     */
    @CMGetter("@property(nonatomic, getter=isOn) BOOL on;")
    public boolean isOn() {
        return on;
    }

    /**
     * Sets the state of the switch (on or off).
     *
     * @param on TRUE sets the switch on.
     */
    @CMSetter("@property(nonatomic, getter=isOn) BOOL on;")
    public void setOn(boolean on) {
        setOn(on, false);
    }

    /**
     * Changes changes the state of switch ( on or off) using animation or not.
     *
     * @param on       TRUE sets the switch on.
     * @param animated TRUE animates the change.
     */
    @CMSelector("- (void)setOn:(BOOL)on \n"
            + "     animated:(BOOL)animated;")
    public void setOn(boolean on, boolean animated) {
        this.on = on;
        painter().setValue(on, extraData);
        setNeedsDisplay();
    }

    /**
     * Returns the color of the thumb.
     *
     * @return The color of the thumb.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *thumbTintColor;")
    public UIColor thumbTintColor() {
        return thumbTintColor;
    }

    /**
     * Sets the color of the thumb.
     *
     * @param thumbTintColor The color of the thumb.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *thumbTintColor;")
    public void setThumbTintColor(UIColor thumbTintColor) {
        this.thumbTintColor = thumbTintColor;
        painter().setThumbColor(thumbTintColor, extraData);
        setNeedsDisplay();
    }

    @Override
    public UIColor tintColor() {
        return tintColor;
    }

    @Override
    public void setTintColor(UIColor tintColor) {
        this.tintColor = tintColor;
        setNeedsDisplay();
    }

    /**
     * Returns the color of the switch used when it is turned on.
     *
     * @return The color of the switch used when it is turned on.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *onTintColor;")
    public UIColor onTintColor() {
        return onTintColor == null ? super.tintColor() : onTintColor;
    }

    /**
     * Sets the color of the switch used when it is turned on.
     *
     * @param onTintColor The color of the switch used when it is turned on.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *onTintColor;")
    public void setOnTintColor(UIColor onTintColor) {
        this.onTintColor = onTintColor;
        setNeedsDisplay();
    }

    @Override
    public final void drawRect(CGRect rect) {
        painter().draw(this, rect, extraData);
    }
}
