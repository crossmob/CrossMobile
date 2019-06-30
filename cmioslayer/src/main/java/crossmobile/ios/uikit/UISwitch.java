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

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.Geometry;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

import static crossmobile.ios.coregraphics.$coregraphics.color;
import static crossmobile.ios.coregraphics.$coregraphics.context;
import static org.crossmobile.bind.graphics.Theme.Switch.*;

/**
 * UISwitch class defines an object that is a button which acts as a switch of
 * two states,on and off. The user of the application can change the state of it
 * controlling that way a particular operation.
 */
@CMClass
public class UISwitch extends UIControl {

    private static final UIColor offColor = UIColor.colorWithWhiteAlpha(1, 0.85);

    private boolean on;
    private UIColor tintColor = Theme.Color.TOOLBACK;
    private UIColor onTintColor = null;
    private UIColor thumbTintColor = Theme.Color.THUMB;
    private UIColor thumbDownTintColor = null;
    private double sliderLoc;
    private boolean isDown;
    private CGPoint originalTouchPoint;
    private boolean dealAsClick;

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
        super(fixRect(rect));
        setOn(false, false);
    }

    @Override
    public void setFrame(CGRect frame) {
        super.setFrame(fixRect(frame));
    }

    @Override
    void setSize(double width, double height) {
    }

    @Override
    void setFrameImpl(double x, double y, double width, double height) {
        super.setFrameImpl(x, y, WIDTH, HEIGHT);
    }

    private void setVisualsFromTouch(UITouch touch) {
        double where = touch.locationInView(this).getX() - INSET - THUMB_SIZE / 2f;
        if (where < 0)
            where = 0;
        if (where > TRACK_MOVING_AREA)
            where = TRACK_MOVING_AREA;
        sliderLoc = where / TRACK_MOVING_AREA;
        Native.graphics().refreshDisplay();
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        UITouch core = touches.iterator().next();
        setVisualsFromTouch(core);
        isDown = true;
        originalTouchPoint = core.locationInView(this);
        dealAsClick = true;
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        UITouch core = touches.iterator().next();
        setVisualsFromTouch(core);
        if (dealAsClick && !Geometry.similarTo(originalTouchPoint, core.locationInView(this), 3))
            dealAsClick = false;
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        isDown = false;
        setVisualsFromTouch(touches.iterator().next());
        boolean newValue = dealAsClick ? !on : sliderLoc > 0.5;
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
        sliderLoc = on ? 1 : 0;
        Native.graphics().refreshDisplay();
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

    private UIColor thumbDownTintColor() {
        if (thumbDownTintColor == null)
            thumbDownTintColor = pressedColor(thumbTintColor);
        return thumbDownTintColor;
    }

    /**
     * Sets the color of the thumb.
     *
     * @param thumbTintColor The color of the thumb.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *thumbTintColor;")
    public void setThumbTintColor(UIColor thumbTintColor) {
        this.thumbTintColor = thumbTintColor;
        thumbDownTintColor = null;
        Native.graphics().refreshDisplay();
    }

    @Override
    public UIColor tintColor() {
        return tintColor;
    }

    @Override
    public void setTintColor(UIColor tintColor) {
        this.tintColor = tintColor;
        Native.graphics().refreshDisplay();
    }

    private UIColor superTintColor() {
        return super.tintColor();
    }

    /**
     * Returns the color of the switch used when it is turned on.
     *
     * @return The color of the switch used when it is turned on.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *onTintColor;")
    public UIColor onTintColor() {
        return onTintColor == null ? superTintColor() : onTintColor;
    }

    /**
     * Sets the color of the switch used when it is turned on.
     *
     * @param onTintColor The color of the switch used when it is turned on.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *onTintColor;")
    public void setOnTintColor(UIColor onTintColor) {
        this.onTintColor = onTintColor;
        Native.graphics().refreshDisplay();
    }

    @Override
    public final void drawRect(CGRect rect) {
        int onColor = color(onTintColor().cgcolor);
        int thumbColor = color(isDown ? thumbDownTintColor().cgcolor : thumbTintColor().cgcolor);
        GraphicsContext gcx = context(UIGraphics.getCurrentContext());
        int sliderArea = (int) (TRACK_MOVING_AREA * sliderLoc);

        gcx.fillRoundRodBar(rect.getOrigin().getX(), rect.getOrigin().getY(), WIDTH, HEIGHT, onColor);
        gcx.fillHalfRoundRodBar(sliderArea + INSET + THUMB_SIZE / 2, rect.getOrigin().getY() + INSET, TRACK_MOVING_AREA - sliderArea + THUMB_SIZE / 2, THUMB_SIZE, color(offColor.cgcolor), true, false);
//        gcx.fillHalfRoundRodBar(rect.getOrigin().getX(), rect.getOrigin().getY(), sliderArea + INSET + THUMB_SIZE / 2, HEIGHT, (color?)), true, true);
        if (ISBORDERED)
            gcx.drawRoundRodBar(rect.getOrigin().getX(), rect.getOrigin().getY(), WIDTH, HEIGHT, color(Theme.Color.SHADOW.cgcolor));

        // draw thumb
        int buttonLocation = (int) (rect.getOrigin().getX() + INSET + sliderArea);

        if (USE_THUMB_IMAGE)
            cmButtonStates.thumb().drawInRect(new CGRect(buttonLocation, INSET, THUMB_SIZE, THUMB_SIZE));
        else {
            gcx.setFillColorWithColor(thumbColor);
            gcx.fillEllipse(buttonLocation, INSET, THUMB_SIZE, THUMB_SIZE);
            gcx.setLineWidth(2);
            gcx.setDrawColorWithColor(onColor);
            gcx.drawEllipse(buttonLocation, INSET + 0.5, THUMB_SIZE, THUMB_SIZE);
        }
    }

    private static CGRect fixRect(CGRect frame) {
        return new CGRect(frame.getOrigin().getX(), frame.getOrigin().getY(), WIDTH, HEIGHT);
    }
}
