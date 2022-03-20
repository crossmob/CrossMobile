/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import com.panayotis.ce.CEventManager;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSelector;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.ann.*;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.panayotis.ce.CEventCommons.DEBUG_TOUCH;
import static crossmobile.ios.uikit.UIGestureRecognizerState.*;
import static org.crossmobile.bind.system.Debug.ENABLE_DEBUG;
import static org.crossmobile.bind.system.Debug.Live_Touch_Debug;

/**
 * UIGestureRecognizer is an abstract class that recognizes series of touches as
 * gestures along with the changes that occur to these gestures. It is
 * responsible to send this information to related objects that will handle it
 * appropriately.
 */
@CMClass
public abstract class UIGestureRecognizer extends NSObject {

    static final float MAXRAD = 10;
    // These objects are required my event handling under UIWindow
    boolean enabled = true;
    boolean cancelsTouchesInView = true;
    boolean delaysTouchesBegan = false;
    boolean delaysTouchesEnded = true;
    UIGestureRecognizerDelegate delegate = null;
    private final Set<NSSelector<UIGestureRecognizer>> targets = new HashSet<>();
    // These objects are NOT required my event handling under UIWindow
    private WeakReference<UIView> view = null;
    //
    private final Set<UIGestureRecognizer> slaves = new HashSet<>();
    Set<UITouch> touchList;
    UIEvent touchEvent;
    //
    private int state;
    private final CGPoint initial = new CGPoint(0, 0);
    private final CGPoint current = new CGPoint(0, 0);
    private double timestamp;
    private int tapcount;

    /**
     * Constructs a UIGestureRecognizer and associates it with the specified
     * target.
     *
     * @param target The target of the new UIGestureRecognizer.
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithTarget:(id)target action:(SEL)action")
    public UIGestureRecognizer(@CMParamMod(association = AssociationType.ADDSELF) @CMJoinSEL(selector = "action", target = "target") NSSelector<UIGestureRecognizer> target) {
        addTarget(target);
        resetEverything();
    }

    /**
     * Adds the target defined as parameter to this UIGestureRecognizer.
     *
     * @param target The target to be added to the UIGestureRecognizer.
     */
    @CMSelector("- (void)addTarget:(id)target action:(SEL)action;")
    public void addTarget(@CMParamMod(association = AssociationType.ADDSELF) @CMJoinSEL(selector = "action", target = "target") NSSelector<UIGestureRecognizer> target) {
        if (target != null)
            targets.add(target);
    }

    /**
     * Removes the target defined as parameter from this UIGestureRecognizer.
     *
     * @param target The target to be removed from this UIGestureRecognizer.
     */
    @CMSelector("- (void)removeTarget:(id)target action:(SEL)action;")
    public void removeTarget(@CMParamMod(association = AssociationType.REMOVESELF) @CMJoinSEL(selector = "action", target = "target") NSSelector<UIGestureRecognizer> target) {
        targets.remove(target);
    }

    /**
     * Returns the location of the gesture for this receiver, expressed in the
     * coordinate system of the view that is passed as parameter.
     *
     * @param view The view in whose coordinate system the location is defined.
     * @return The location of the gesture for this receiver.
     */
    @CMSelector("- (CGPoint)locationInView:(UIView *)view;\n"
            + "")
    public CGPoint locationInView(UIView view) {
        return locationOfTouch(0, view);
    }

    /**
     * Returns the location of the touch parameter expressed in the coordinate
     * system of the view that is passed as parameter.
     *
     * @param touch The touch for which the location is computed.
     * @param view  The view in whose coordinate system the location is defined.
     * @return The location of the touch.
     */
    @CMSelector("- (CGPoint)locationOfTouch:(NSUInteger)touchIndex \n"
            + "                    inView:(UIView *)view;")
    public CGPoint locationOfTouch(int touch, UIView view) {
        if (touch < 0 || touch >= touchList.size())
            throw new RuntimeException("Unable to get touch with number " + touch);
        Iterator<UITouch> iterator = touchList.iterator();
        for (int i = 0; i < touch; i++)
            iterator.next();
        return iterator.next().locationInView(view);
    }

    /**
     * Returns the number of touches that constitute this gesture.
     *
     * @return The number of touches that constitute this gesture.
     */
    @CMSelector("- (NSUInteger)numberOfTouches;")
    public int numberOfTouches() {
        return touchList.size();
    }

    void setView(UIView view) {
        this.view = view == null ? null : new WeakReference<UIView>(view);
    }

    /**
     * Returns the view for this UIGestureRecognizer.
     *
     * @return The view for this UIGestureRecognizer.
     */
    @CMGetter("@property(nonatomic, readonly) UIView *view;")
    public UIView view() {
        return view == null ? null : view.get();
    }

    /**
     * Returns the delegate object for this UIGestureRecognizer.
     *
     * @return The delegate object for this UIGestureRecognizer.
     */
    @CMGetter("@property(nonatomic, weak) id<UIGestureRecognizerDelegate> delegate;")
    public UIGestureRecognizerDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate object for this UIGestureRecognizer.
     *
     * @param delegate The delegate object for this UIGestureRecognizer.
     */
    @CMSetter("@property(nonatomic, weak) id<UIGestureRecognizerDelegate> delegate;")
    public void setDelegate(UIGestureRecognizerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns a Boolean that shows whether this UIGestureRecognizer is enabled
     * or not.
     *
     * @return Boolean that shows whether this UIGestureRecognizer is enabled or
     * not.
     */
    @CMGetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets a Boolean that defines whether this UIGestureRecognizer is enabled
     * or not.
     *
     * @param enabled Boolean that defines whether this UIGestureRecognizer is
     *                enabled or not.
     */
    @CMSetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        setState(Cancelled);
    }

    /**
     * Returns a Boolean that shows whether touches are passed to a view when an
     * event is perceived as a gesture.
     *
     * @return Boolean that shows whether touches are passed to a view when an
     * event is perceived as a gesture.
     */
    @CMGetter("@property(nonatomic) BOOL cancelsTouchesInView;")
    public boolean cancelsTouchesInView() {
        return cancelsTouchesInView;
    }

    /**
     * Set a Boolean that defines whether touches are passed to a view when an
     * event is perceived as a gesture.
     *
     * @param cancelsTouchesInView Boolean that defines whether touches are
     *                             passed to a view when an event is perceived as a gesture.
     */
    @CMSetter("@property(nonatomic) BOOL cancelsTouchesInView;")
    public void setCancelsTouchesInView(boolean cancelsTouchesInView) {
        this.cancelsTouchesInView = cancelsTouchesInView;
    }

    /**
     * Returns a Boolean that shows whether there is an initial delay in sending
     * touches to the view for this UIGestureRecognizer.
     *
     * @return Boolean that shows whether there is an initial delay in sending
     * touches to the view for this UIGestureRecognizer.
     */
    @CMGetter("@property(nonatomic) BOOL delaysTouchesBegan;")
    public boolean delaysTouchesBegan() {
        return delaysTouchesBegan;
    }

    /**
     * Sets a Boolean that defines whether there is an initial delay in sending
     * touches to the view for this UIGestureRecognizer.
     *
     * @param delaysTouchesBegan Boolean that defines whether there is an
     *                           initial delay in sending touches to the view for this
     *                           UIGestureRecognizer.
     */
    @CMSetter("@property(nonatomic) BOOL delaysTouchesBegan;")
    public void setDelaysTouchesBegan(boolean delaysTouchesBegan) {
        this.delaysTouchesBegan = delaysTouchesBegan;
    }

    /**
     * Returns a Boolean that shows whether there is a delay in sending touches
     * to the view, at the end of the phase, for this UIGestureRecognizer.
     *
     * @return Boolean that shows whether there is a delay in sending touches to
     * the view, at the end of the phase, for this UIGestureRecognizer.
     */
    @CMGetter("@property(nonatomic) BOOL delaysTouchesEnded;")
    public boolean delaysTouchesEnded() {
        return delaysTouchesEnded;
    }

    /**
     * Sets a Boolean that defines whether there is a delay in sending touches
     * to the view, at the end of the phase, for this UIGestureRecognizer.
     *
     * @param delaysTouchesEnded Boolean that shows whether there is a delay in
     *                           sending touches to the view, at the end of the phase, for this
     *                           UIGestureRecognizer.
     */
    @CMSetter("@property(nonatomic) BOOL delaysTouchesEnded;")
    public void setDelaysTouchesEnded(boolean delaysTouchesEnded) {
        this.delaysTouchesEnded = delaysTouchesEnded;
    }

    /**
     * Returns the current state for this UIGestureRecognizer.
     *
     * @return The current state for this UIGestureRecognizer.
     */
    @CMGetter("@property(nonatomic, readonly) UIGestureRecognizerState state;")
    public int state() {
        return state;
    }

    /**
     * Use this method to change the state of a recognizer, which in parallel
     * will make sure that dependent gestures will be properly informed.
     *
     * @param newstate
     */
    protected void setState(int newstate) {
        if (newstate == state)
            return;
        state = newstate;
    }

    void performCallbacks() {
        if (ENABLE_DEBUG && Live_Touch_Debug)
            CEventManager.fireEvent(DEBUG_TOUCH, this);
        for (NSSelector<UIGestureRecognizer> selector : targets)
            selector.exec(this);
    }

    /**
     * Connects this UIGestureRecognizer with corresponding that is passed as
     * parameter.
     *
     * @param other The UIGestureRecognizer that is to be connected to this.
     */
    @CMSelector("- (void)requireGestureRecognizerToFail:(UIGestureRecognizer *)otherGestureRecognizer;")
    public void requireGestureRecognizerToFail(UIGestureRecognizer other) {
        if (other != null)
            other.slaves.add(this);
    }

    Iterable<UIGestureRecognizer> getSlaves() {
        return slaves;
    }

    void setTouchList(Set<UITouch> touches, UIEvent event) {
        this.touchList = touches;
        this.touchEvent = event;
    }

    void resetEverything() {
        touchList = null;
        touchEvent = null;
        state = Possible;
        reset();
    }

    protected void ignoreTouch(UITouch touch, UIEvent event) {
    }

    /**
     * Resets internal state when the gesture recognition is completed.
     */
    @CMSelector("- (void)reset")
    public void reset() {
        initial.setX(current.getX());
        initial.setY(current.getY());
    }

    @Override
    public String toString() {
        return SystemUtilities.getClassName(getClass()) + " from=" + initial + " current=" + current;
    }

    final CGPoint initial() {
        return initial;
    }

    final CGPoint current() {
        return current;
    }

    final double timestamp() {
        return timestamp;
    }

    int tapcount() {
        return tapcount;
    }

    void updateCurrent(Set<UITouch> touches) {
        if (state() < Ended) {
            float x = 0, y = 0;
            double time = 0;
            int howmany = 0;
            for (UITouch t : touches) {
                howmany++;
                CGPoint loc = t.locationInView(t.view);
                x += loc.getX();
                y += loc.getY();
                time += t.timestamp;
                tapcount = t.tapcount;
            }
            current.setX(x / howmany);
            current.setY(y / howmany);
            timestamp = time / howmany;
        }
    }

    /**
     * Informs this UIGestureRecognizer when one or more fingers touched down in
     * the associated UIView.
     *
     * @param touches The set of touches until the UITouchPhaseCancelled phase.
     * @param event   The event to which the touches belong.
     */
    @CMSelector("- (void)touchesBegan:(NSSet<UITouch *> *)touches\n"
            + "           withEvent:(UIEvent *)event")
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        updateCurrent(touches);
        initial.setX(current.getX());
        initial.setY(current.getY());
    }

    /**
     * Informs this UIGestureRecognizer when one or more fingers were moved
     * within the associated view.
     *
     * @param touches The set of touches until the UITouchPhaseCancelled phase.
     * @param event   The event to which the touches belong.
     */
    @CMSelector("- (void)touchesMoved:(NSSet<UITouch *> *)touches\n"
            + "           withEvent:(UIEvent *)event")
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        updateCurrent(touches);
    }

    /**
     * Informs this UIGestureRecognizer when one or more fingers were lifted
     * from the associated view.
     *
     * @param touches The set of touches until the UITouchPhaseCancelled phase.
     * @param event   The event to which the touches belong.
     */
    @CMSelector("- (void)touchesEnded:(NSSet<UITouch *> *)touches\n"
            + "           withEvent:(UIEvent *)event")
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        updateCurrent(touches);
    }

    /**
     * Informs this UIGestureRecognizer that a touch event was canceled due to
     * system event.
     *
     * @param touches The set of touches until the UITouchPhaseCancelled phase.
     * @param event   The event to which the touches belong.
     */
    @CMSelector("- (void)touchesCancelled:(NSSet<UITouch *> *)touches\n"
            + "               withEvent:(UIEvent *)event")
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        updateCurrent(touches);
    }

    /**
     * Override this method so that the specified UIGestureRecognizer prevents
     * this UIGestureRecognizer from recognizing a gesture.
     *
     * @param preventing The UIGestureRecognizer that prevents this gesture
     *                   recognizer from recognizing a gesture.
     * @return TRUE then the specified UIGestureRecognizer is able to prevent
     * the recognition of a gesture.
     */
    @CMSelector("- (BOOL)canBePreventedByGestureRecognizer:(UIGestureRecognizer *)preventingGestureRecognizer;")
    public abstract boolean canBePreventedByGestureRecognizer(UIGestureRecognizer preventing);

    /**
     * Override this method so that this UIGestureRecognizer prevents the
     * specified UIGestureRecognizer from recognizing a gesture.
     *
     * @param preventing The UIGestureRecognizer that is prevented from
     *                   recognizing a gesture.
     * @return TRUE then this UIGestureRecognizer is able to prevent the
     * recognition of a gesture.
     */
    @CMSelector("- (BOOL)canPreventGestureRecognizer:(UIGestureRecognizer *)preventedGestureRecognizer;")
    public abstract boolean canPreventGestureRecognizer(UIGestureRecognizer preventing);

}
