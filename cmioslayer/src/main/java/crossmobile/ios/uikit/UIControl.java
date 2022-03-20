/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.*;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UIControlEvents.*;

/**
 * UIControl class's instances correspond to visual control elements, such as
 * buttons and sliders.These control elements are related to a specific user
 * interaction with the application.
 */
@CMClass
public class UIControl extends UIView {

    private List<EventDelegate> controldelegates;
    private boolean selected;
    private boolean enabled = true;
    private boolean highlighted;
    private boolean last_touch_inside = true;
    private int contentVerticalAlignment = UIControlContentVerticalAlignment.Top;
    private int contentHorizontalAlignment = UIControlContentHorizontalAlignment.Center;

    /**
     * Constructs a default UIControl object located at (0,0) with 0 weight and
     * 0 height.
     */
    public UIControl() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIControl object initialized with the dimensions and
     * position specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of UIControl
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UIControl(CGRect rect) {
        super(rect);
    }

    /**
     * Returns a Boolean that shows whether this control is in selected state.
     *
     * @return A Boolean that shows whether this control is in selected state.
     */
    @CMGetter("@property(nonatomic, getter=isSelected) BOOL selected;")
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets this control to selected state or not according to Boolean
     * parameter.
     *
     * @param selected A Boolean that defines whether this control is in
     *                 selected state.
     */
    @CMSetter("@property(nonatomic, getter=isSelected) BOOL selected;")
    public void setSelected(boolean selected) {
        if (this.selected == selected)
            return;
        this.selected = selected;
        setNeedsDisplay();
    }

    /**
     * Relates the specified UIControlEvents with the corresponding delegate.
     *
     * @param delegate        The delegate handing the event.
     * @param UIControlEvents The event associated to the delegate.
     */
    @CMSelector("- (void)addTarget:(id)target\n"
            + "           action:(SEL)action\n"
            + " forControlEvents:(UIControlEvents)controlEvents")
    public void addTarget(@CMJoinSEL(selector = "action", target = "target")
                          @CMParamMod(association = AssociationType.ADDSELF, shouldNotBeNull = true) UIControlDelegate delegate,
                          @CMParamMod(shouldNotBeNull = true) int UIControlEvents) {
        if (delegate == null)
            return;

        // Lazy initialization of delegates
        if (controldelegates == null)
            controldelegates = new ArrayList<>();
        controldelegates.add(new EventDelegate(UIControlEvents, delegate));
    }

    @CMSelector("- (void)removeTarget:(id)target \n"
            + "              action:(SEL)action \n"
            + "    forControlEvents:(UIControlEvents)controlEvents;")
    public void removeTarget(@CMJoinSEL(selector = "action", target = "target")
                             @CMParamMod(association = AssociationType.REMOVESELF, shouldNotBeNull = true) UIControlDelegate delegate,
                             @CMParamMod(shouldNotBeNull = true) int UIControlEvents) {
        if (controldelegates == null || UIControlEvents == 0)
            return;
        Iterator<EventDelegate> iterator = controldelegates.iterator();
        while (iterator.hasNext()) {
            EventDelegate current = iterator.next();
            if (delegate == null || delegate.equals(current.delegate)) {
                current.event &= ~UIControlEvents;
                if (current.event == 0)
                    iterator.remove();
            }
        }
        if (controldelegates.isEmpty())
            controldelegates = null;
    }

    /**
     * Returns all the objects that relate to with this control.
     *
     * @return The objects related to this control.
     */
    @CMGetter("@property(nonatomic, readonly) NSSet *allTargets;")
    public Set<UIControlDelegate> allTargets() {
        Set<UIControlDelegate> targets = new HashSet<>();
        if (controldelegates != null)
            for (EventDelegate item : controldelegates)
                targets.add(item.delegate);
        return targets;
    }

    /**
     * Returns a Boolean that shows whether the control is enabled or not.
     *
     * @return A Boolean that shows whether the control is enabled or not.
     */
    @CMGetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets a Boolean that defines whether the control is enabled or not.
     *
     * @param enabled A Boolean that defines whether the control is enabled or
     *                not.
     */
    @CMSetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public void setEnabled(boolean enabled) {
        if (this.enabled == enabled)
            return;
        this.enabled = enabled;
        setNeedsDisplay();
    }

    @Override
    public UIView hitTest(CGPoint point, UIEvent event) {
        if (!enabled)
            return null;
        return super.hitTest(point, event);
    }

    /**
     * Returns a Boolean that shows whether the control is highlighted or not.
     *
     * @return A Boolean that shows whether the control is highlighted or not.
     */
    @CMGetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;")
    public boolean isHighlighted() {
        return highlighted;
    }

    /**
     * Sets the control to highlighted state according to the Boolean parameter.
     *
     * @param highlighted A Boolean that defines whether the control is
     *                    highlighted or not.
     */
    @CMSetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;")
    public void setHighlighted(boolean highlighted) {
        if (this.highlighted == highlighted)
            return;
        this.highlighted = highlighted;
        setNeedsDisplay();
    }

    /**
     * Returns an integer that represents the horizontal alignment of the
     * content within the control.
     *
     * @return An integer that represents the horizontal alignment of the
     * content within the control.
     */
    @CMGetter("@property(nonatomic) UIControlContentHorizontalAlignment contentHorizontalAlignment;")
    public int contentHorizontalAlignment() {
        return contentHorizontalAlignment;
    }

    /**
     * Sets an integer that represents the horizontal alignment of the content
     * within the control.
     *
     * @param UIControlContentHorizontalAlignment An integer that represents the
     *                                            horizontal alignment of the content within the control.
     */
    @CMSetter("@property(nonatomic) UIControlContentHorizontalAlignment contentHorizontalAlignment;")
    public void setContentHorizontalAlignment(int UIControlContentHorizontalAlignment) {
        if (this.contentHorizontalAlignment == UIControlContentHorizontalAlignment)
            return;
        this.contentHorizontalAlignment = UIControlContentHorizontalAlignment;
        setNeedsDisplay();
    }

    /**
     * Returns an integer that represents the vertical alignment of the content
     * within the control.
     *
     * @return An integer that represents the vertical alignment of the content
     * within the control.
     */
    @CMGetter("@property(nonatomic) UIControlContentVerticalAlignment contentVerticalAlignment;")
    public int contentVerticalAlignment() {
        return contentVerticalAlignment;
    }

    /**
     * Sets an integer that represents the vertical alignment of the content
     * within the control.
     *
     * @param contentVerticalAlignment An integer that represents the vertical
     *                                 alignment of the content within the control.
     */
    @CMSetter("@property(nonatomic) UIControlContentVerticalAlignment contentVerticalAlignment;")
    public void setContentVerticalAlignment(int contentVerticalAlignment) {
        if (contentVerticalAlignment == this.contentVerticalAlignment)
            return;
        this.contentVerticalAlignment = contentVerticalAlignment;
        setNeedsDisplay();
    }

    /**
     * Returns an integer that represents the state of the control.
     *
     * @return An integer that represents the state of the control.
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMGetter("@property(nonatomic, readonly) UIControlState state;")
    public int state() {
        return (selected ? UIControlState.Selected : 0)
                | (enabled ? 0 : UIControlState.Disabled)
                | (highlighted ? UIControlState.Highlighted : 0);
    }

    /**
     * Send evens for this control for the provided event mask
     *
     * @param UIControlEvents The bit-mask of the events to send, as defined in {@link UIControlEvents}
     */
    @CMSelector("- (void)sendActionsForControlEvents:(UIControlEvents)controlEvents;")
    public void sendActionsForControlEvents(int UIControlEvents) {
        sendActionsForControlEvents(UIControlEvents, new UIEvent());
    }

    void sendActionsForControlEvents(int constrolState, UIEvent event) {
        if (controldelegates == null)
            return;
        for (EventDelegate item : controldelegates)
            if ((item.event & constrolState) > 0)
                item.delegate.exec(this, event);
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
//        Native.widget().resignFocus();
        setHighlighted(true);
        last_touch_inside = true;
        sendActionsForControlEvents(TouchDown, event);
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        if (pointInside(touches.iterator().next().locationInView(this), event)) {
            if (!last_touch_inside) {
                last_touch_inside = true;
                setHighlighted(true);
                sendActionsForControlEvents(TouchDragEnter, event);
            }
            sendActionsForControlEvents(TouchDragInside, event);
        } else {
            if (last_touch_inside) {
                last_touch_inside = false;
                setHighlighted(false);
                sendActionsForControlEvents(TouchDragExit, event);
            }
            sendActionsForControlEvents(TouchDragOutside, event);
        }
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        setHighlighted(false);
        sendActionsForControlEvents(pointInside(touches.iterator().next().locationInView(this), event) ? TouchUpInside : TouchUpOutside, event);
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        setHighlighted(false);
    }

    static class EventDelegate {

        int event;
        UIControlDelegate delegate;

        private EventDelegate(int event, UIControlDelegate delegate) {
            this.event = event;
            this.delegate = delegate;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final EventDelegate other = (EventDelegate) obj;
            if (this.event != other.event)
                return false;
            if (this.delegate == null)
                return other.delegate == null;
            return this.delegate.equals(other.delegate);
        }

    }

    UIColor pressedColor(UIColor other) {
        double[] hsba = Native.graphics().colorRGBAtoHSVA(color(other.cgcolor));
        hsba[2] *= 0.8f;
        return new UIColor(Native.graphics().colorHSBAtoRGBA(hsba[0], hsba[1], hsba[2], hsba[3]));
    }
}
