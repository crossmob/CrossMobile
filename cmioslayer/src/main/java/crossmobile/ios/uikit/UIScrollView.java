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
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.foundation.NSTimer;
import org.crossmobile.bind.graphics.Geometry;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.curve.InterpolationCurve;
import org.crossmobile.bind.system.Ticker;
import org.crossmobile.bind.system.TickerConsumer;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;
import org.crossmobile.support.cassowary.*;
import org.crossmobile.support.cassowary.clconstraint.ClConstraint;
import org.crossmobile.support.cassowary.clconstraint.ClLinearInequality;
import org.crossmobile.support.cassowary.clconstraint.ClStayConstraint;

import java.util.*;

import static crossmobile.ios.coregraphics.$coregraphics.context;
import static org.crossmobile.bind.graphics.Geometry.meter;
import static org.crossmobile.bind.graphics.Theme.Scroll.*;

/**
 * UIScrollView class extends UIView and defines an object of a customized view
 * that is used in order to display content that exceeds the size of the
 * window.It provides options for altering the visible content using swiping
 * gestures within the view.
 */
@CMClass
public class UIScrollView extends UIView {

    private static final double SELECTION_THRESHOLD = 5;
    private final UIEdgeInsets scrollIndicatorInsets = UIEdgeInsets.zero();
    // Used in UITable view: for optimization reasons this is friendly
    CGPoint contentOffset = new CGPoint(0, 0);
    CGSize contentSize = new CGSize(0, 0);
    UIEdgeInsets contentInset = UIEdgeInsets.zero();
    private boolean scrollEnabled = true;
    private boolean directionalLockEnabled = false;
    private boolean scrollsToTop = true;
    private boolean pagingEnabled = false;
    private boolean bounces = true;
    private boolean alwaysBounceVertical = false;
    private boolean alwaysBounceHorizontal = false;
    private boolean canCancelContentTouches = true;
    private boolean delaysContentTouches = true;
    private double decelerationRate = UIScrollViewDecelerationRate.Normal;
    private boolean dragging = false;
    private boolean tracking = false;
    private boolean decelerating = false;
    //
    private int indicatorStyle = UIScrollViewIndicatorStyle.Default;
    private boolean showsHorizontalScrollIndicator = true;
    private boolean showsVerticalScrollIndicator = true;
    private float flashAlpha = 1;
    private boolean flashing = false;
    private UIView lastHit;
    //
    private UIScrollViewDelegate delegate = null;
    //
    private NSTimer scroller = null;
    private NSTimer flasher = null;
    private NSTimer taptimer = null;
    private NSTimer swipe = null;
    private NSTimer animatedScroll = null;
    private boolean yieldTouches = false;

    private final Map<Integer, ClVariable> contentVariableMap = new HashMap<>();
    private final List<NSLayoutConstraint> contentConstraints = new ArrayList<>();
    private final List<NSLayoutConstraint> generalConstraints = new ArrayList<>();
    //

    private boolean began = true;
    private UIPanGestureRecognizer pan = new UIPanGestureRecognizer(new NSSelector<UIGestureRecognizer>() { // Should be friendly, so that the tableview can prevent it
        @Override
        public void exec(UIGestureRecognizer arg) {
            switch (pan.state()) {
                case UIGestureRecognizerState.Cancelled:
                    yieldTouches = false;
                    tracking = false;
                    dragging = false;
                    if (delegate != null)
                        delegate.didEndDragging(UIScrollView.this, false);
                    invalidateTimers();
                    taptimer = null;
                    touchesCancelled(arg.touchList, arg.touchEvent);
                    break;
                case UIGestureRecognizerState.Began:
                    yieldTouches = false;
                    began = true;
                    invalidateTimers();
                    pan.setTranslation(new CGPoint(-contentOffset.getX(), -contentOffset.getY()), UIScrollView.this);
                    dragging = false;
                    if (delegate != null)
                        delegate.willBeginDragging(UIScrollView.this);
                    taptimer = NSTimer.scheduledTimerWithTimeInterval(0.1, timer -> {
                        invalidateTimers();
                        yieldTouches = true;
                        touchesBegan(arg.touchList, arg.touchEvent);
                    }, null, false);
                    break;
                default:
                    tracking = false;
                    CGPoint transl = pan.translationInView(UIScrollView.this);
                    CGPoint scrollVelocity = pan.velocityInView(UIScrollView.this);
                    boolean shouldSpring = false;
                    double x = -transl.getX();
                    double y = -transl.getY();
                    double unprocessedX = x;
                    double unprocessedY = y;
                    if ((contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) <= getWidth())
                        x = contentOffset.getX();
                    if ((contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) <= getHeight())
                        y = contentOffset.getY();
                    if (x < 0)
                        if (bounces) {
                            shouldSpring = true;
                            x = x * SPRING_FACTOR;
                        } else
                            x = 0;
                    else if (x > (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - getWidth())
                        if (bounces) {
                            shouldSpring = true;
                            x = (x + (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - getWidth()) * SPRING_FACTOR;
                        } else
                            x = (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - getWidth();
                    if (y < 0)
                        if (bounces) {
                            shouldSpring = true;
                            y = y * SPRING_FACTOR;
                        } else
                            y = 0;
                    else if (y > (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - getHeight())
                        if (bounces) {
                            shouldSpring = true;
                            y = (y + (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - getHeight()) * SPRING_FACTOR;
                        } else
                            y = (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - getHeight();
                    if (pan.state() != UIGestureRecognizerState.Ended) { // UIGestureRecognizerState.Changed
                        if (Math.sqrt(Math.pow(contentOffset.getX() - x, 2) + Math.pow(contentOffset.getY() - y, 2)) > SELECTION_THRESHOLD && !yieldTouches) {
                            invalidateTimers();
                            touchesCancelled(arg.touchList, arg.touchEvent);
                            dragging = true;
                            tracking = true;
                            began = false;
                            setContentOffset(x, y); // no special animation
                            //TODO SHOULD GO TO GESTURES IMPLEMENTATION!!!!!!
                        } else if (!yieldTouches && began && firstAncestorScrollView(UIScrollView.this) != null && ((x > -0.1 && x < 0.1 && Math.abs(x) < Math.abs(unprocessedX)) || (y > -0.1 && y < 0.1 && Math.abs(unprocessedY) > Math.abs(y)))) {
                            began = false;
                            invalidateTimers();
                            touchesCancelled(arg.touchList, arg.touchEvent);
                            disabled = true;
                            Set<UITouch> touches = new HashSet<>();
                            for (UITouch t : arg.touchList)
                                touches.add(new UITouch(t.locationInWindow, t.pointerID, t.window, UITouchPhase.Began));
                            window().sendEvent(new UIEvent(touches.toArray(new UITouch[0]), arg.touchEvent, UITouchPhase.Began));
                            pan.setState(UIGestureRecognizerState.Cancelled);
                            window().sendEvent(new UIEvent(arg.touchList.toArray(new UITouch[0]), arg.touchEvent, UITouchPhase.Cancelled));
                            disabled = false;
                        } else touchesMoved(arg.touchList, arg.touchEvent);
                    }
                    if (pan.state() == UIGestureRecognizerState.Ended) {
                        yieldTouches = false;
                        if (taptimer != null && taptimer.isValid())
                            taptimer.fire();
                        touchesEnded(arg.touchList, arg.touchEvent);
                        if (dragging) {
                            invalidateTimers();
                            dragging = false;
                            if (scroller != null)
                                scroller.invalidate();
                            if (delegate != null)
                                delegate.didEndDragging(UIScrollView.this, false);
                            if (shouldSpring && (x < 0 || x > (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - getWidth() || y < 0 || y > (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - getHeight())) {
                                float newX = (float) (x < 0 ? 0
                                        : Math.min(x, (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - getWidth()));
                                float newY = (float) (y < 0 ? 0
                                        : Math.min(y, (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - getHeight()));
                                setContentOffset(new CGPoint(newX, newY), true);
                            } else if (meter(scrollVelocity) > 1) {
                                if (scroller != null)
                                    scroller.invalidate();
                                scroller = Ticker.add(new SwipeContent(scrollVelocity), InterpolationCurve.EaseOut, 0.5F);
                            } else if (pagingEnabled)
                                setContentOffset(new CGPoint(x + 0.5, y + 0.5), true);
                        }
                    }
                    break;
            }
        }
    });
    private boolean disabled = false;

    /**
     * Constructs a default UIScrollView object located at (0,0) with 0 weight
     * and 0 height.
     */
    public UIScrollView() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIScrollView object initialized with the dimensions and
     * position specified in the frame parameter.
     *
     * @param frame CGRect that defines dimension and position of the
     *              UIScrollView.
     */
    @SuppressWarnings("LeakingThisInConstructor")
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UIScrollView(CGRect frame) {
        this(frame, null);
    }

    UIScrollView(CGRect frame, UIColor backgroundColor) {
        super(frame, backgroundColor);
        setClipsToBounds(true);
        pan.setCancelsTouchesInView(true);
        addGestureRecognizer(pan);
    }

    private void invalidateTimers() {
        if (flasher != null && flasher.isValid())
            flasher.invalidate();
        flasher = null;
        if (swipe != null && swipe.isValid())
            swipe.invalidate();
        swipe = null;
        if (animatedScroll != null && animatedScroll.isValid())
            animatedScroll.invalidate();
        animatedScroll = null;
        if (taptimer != null && taptimer.isValid())
            taptimer.invalidate();
        taptimer = null;
        if (scroller != null && scroller.isValid())
            scroller.invalidate();
        scroller = null;
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        lastHit = super.hitTest(touches.iterator().next().locationInView(this), event);
        if (lastHit == this)
            lastHit = null; // We don't care for self hits
        if (lastHit != null)
            lastHit.touchesBegan(touches, event);
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        if (lastHit != null)
            lastHit.touchesEnded(touches, event);
        lastHit = null;
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        if (lastHit != null)
            lastHit.touchesCancelled(touches, event);
        lastHit = null;
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        if (lastHit != null)
            lastHit.touchesMoved(touches, event);
    }

    @Override
    public UIView hitTest(CGPoint point, UIEvent event) {
        UIView view = super.hitTest(point, event);
        if (disabled) return null;
        return view == null ? null : view instanceof UIScrollView || view == this ? view : firstAncestorScrollView(view);
    }

    private UIView firstAncestorScrollView(UIView view) {
        UIView firstAncestorScrollView;
        firstAncestorScrollView = view;
        while ((firstAncestorScrollView = firstAncestorScrollView.superview()) != null)
            if (firstAncestorScrollView instanceof UIScrollView)
                return firstAncestorScrollView;
        return firstAncestorScrollView;
    }

    /**
     * It is used by subclasses in order to customize the behavior of a touch.
     *
     * @param touches     The set of UITouch instances that consist the touching
     *                    phase.
     * @param event       The event to which the UITouch instances belong.
     * @param contentView The subview within which the gesture occurred.
     * @return FALSE when the scroll view is not preferred to send event
     * messages to view.
     */
    @CMSelector("- (BOOL)touchesShouldBegin:(NSSet<UITouch *> *)touches \n"
            + "                 withEvent:(UIEvent *)event \n"
            + "             inContentView:(UIView *)view;")
    public boolean touchesShouldBegin(Set<UITouch> touches, UIEvent event, UIView contentView) {
        return true;
    }

    /**
     * Returns a Boolean that shows whether touches on the content subview are
     * canceled so that dragging starts.
     *
     * @param view The view that was touched.
     * @return A Boolean that shows whether touches on the content subview are
     * canceled so that dragging starts.
     */
    @CMSelector("- (BOOL)touchesShouldCancelInContentView:(UIView *)view;")
    public boolean touchesShouldCancelInContentView(UIView view) {
        return !(view instanceof UIControl);
    }

    @Override
    void parentPointTransformations(CGPoint point, boolean isInverse) {
        if (isInverse) {
            point.setX(point.getX() + (contentOffset.getX() - contentInset.getLeft()));
            point.setY(point.getY() + (contentOffset.getY() - contentInset.getTop()));
        } else {
            point.setX(point.getX() - (contentOffset.getX() - contentInset.getLeft()));
            point.setY(point.getY() - (contentOffset.getY() - contentInset.getTop()));
        }
    }

    /**
     * Returns the size of the content view.
     *
     * @return The size of the content view.
     */
    @CMGetter("@property(nonatomic) CGSize contentSize;")
    public CGSize contentSize() {
        return new CGSize(contentSize.getWidth(), contentSize.getHeight());
    }

    /**
     * Sets the size of the content view.
     *
     * @param contentSize The size of the content view.
     */
    @CMSetter("@property(nonatomic) CGSize contentSize;")
    public void setContentSize(CGSize contentSize) {
        setContentSize(contentSize, true);
    }

    void setContentSize(CGSize contentSize, boolean shouldUpdateLayout) {
        // UITableView manipulates ContentSize, thus no optimization should be performed here
        Geometry.set(this.contentSize, contentSize);
        if (shouldUpdateLayout)
            layoutSubviews(); // LayoutSubviews might use setContentSize, thus do this trick to prevent cycles
    }

    /**
     * Moves this UIScrollView according to the specified offset.
     *
     * @param offset The offset from the original content view position.
     */
    @CMSetter("@property(nonatomic) CGPoint contentOffset;")
    public void setContentOffset(CGPoint offset) {
        setContentOffset(offset, false);
    }

    /**
     * Moves this UIScrollView according to the specified offset using optional
     * animation.
     *
     * @param offset   The offset from the original content view position.
     * @param animated TRUE use animation for the change.
     */
    @CMSelector("- (void)setContentOffset:(CGPoint)contentOffset \n"
            + "                animated:(BOOL)animated;")
    public void setContentOffset(CGPoint offset, boolean animated) {
        if (!contentOffset.equals(offset))
            if (animated) {
                invalidateTimers();
                animatedScroll = Ticker.add(new ScrollContent(offset.getX(), offset.getY()), InterpolationCurve.EaseInOut, 0.3);
            } else
                setContentOffset(offset.getX(), offset.getY());
    }

    void setContentOffset(double x, double y) {
        if ((contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) <= getWidth())
            x = contentOffset.getX();
        if ((contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) <= getHeight())
            y = contentOffset.getY();
        contentOffset.setX((int) (x + 0.5));
        contentOffset.setY((int) (y + 0.5));
        if (delegate != null)
            delegate.didScroll(UIScrollView.this);
        layoutNativeFromRoot();
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns the offset for the origin of the content, inside a scroll view,
     * relative to the origin of the scroll view.
     *
     * @return The offset for the origin of the content, inside a scroll view,
     * relative to the origin of the scroll view.
     */
    @CMGetter("@property(nonatomic) CGPoint contentOffset;")
    public CGPoint contentOffset() {
        return new CGPoint(contentOffset.getX(), contentOffset.getY());
    }

    /**
     * Returns the distance that the content of the scroll view is inset inside
     * of the scroll view(expressed in points).
     *
     * @return The distance that the content of the scroll view is inset inside
     * of the scroll view(expressed in points).
     */
    @CMGetter("@property(nonatomic) UIEdgeInsets contentInset;")
    public UIEdgeInsets contentInset() {
        return new UIEdgeInsets(contentInset);
    }

    /**
     * Sets the distance that the content of the scroll view is inset inside of
     * the scroll view(expressed in points).
     *
     * @param contentInset The distance that the content of the scroll view is
     *                     inset inside of the scroll view(expressed in points). .
     */
    @CMSetter("@property(nonatomic) UIEdgeInsets contentInset;")
    public void setContentInset(UIEdgeInsets contentInset) {
        if (!this.contentInset.equals(contentInset)) {
            this.contentInset.set(contentInset);
            layoutSubviews();
        }
    }

    /**
     * Returns a Boolean that shows whether scrolling is enabled.
     *
     * @return A Boolean that shows whether scrolling is enabled.
     */
    @CMGetter("@property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;\n"
            + "")
    public boolean isScrollEnabled() {
        return this.scrollEnabled;
    }

    /**
     * Sets a Boolean that defines whether scrolling is enabled.
     *
     * @param scrollEnabled A Boolean that defines whether scrolling is enabled.
     */
    @CMSetter("@property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;")
    public void setScrollEnabled(boolean scrollEnabled) {
        if (this.scrollEnabled == scrollEnabled)
            return;
        if (scrollEnabled)
            addGestureRecognizer(pan);
        else
            removeGestureRecognizer(pan);
        this.scrollEnabled = scrollEnabled;
    }

    /**
     * Returns a Boolean that shows whether paging is enabled.
     *
     * @return A Boolean that shows whether paging is enabled.
     */
    @CMGetter("@property(nonatomic, getter=isPagingEnabled) BOOL pagingEnabled;")
    public boolean isPagingEnabled() {
        return pagingEnabled;
    }

    /**
     * Sets a Boolean that defines whether paging is enabled.
     *
     * @param pagingEnabled A Boolean that defines whether paging is enabled.
     */
    @CMSetter("@property(nonatomic, getter=isPagingEnabled) BOOL pagingEnabled;")
    public void setPagingEnabled(boolean pagingEnabled) {
        this.pagingEnabled = pagingEnabled;
    }

    /**
     * Returns the delegate of this scroll view.
     *
     * @return The delegate of this scroll view.
     */
    @CMGetter("@property(nonatomic, weak) id<UIScrollViewDelegate> delegate;")
    public UIScrollViewDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this scroll view.
     *
     * @param delegate The delegate for this scroll view.
     */
    @CMSetter("@property(nonatomic, weak) id<UIScrollViewDelegate> delegate;")
    public void setDelegate(UIScrollViewDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns a Boolean that shows whether the scroll view moves to the top
     * after a tap on the status bar.
     *
     * @return A Boolean that shows whether the scroll view moves to the top
     * after a tap on the status bar.
     */
    @CMGetter("@property(nonatomic) BOOL scrollsToTop;")
    public boolean scrollsToTop() {
        return scrollsToTop;
    }

    /**
     * Sets a Boolean that defines whether the scroll view moves to the top
     * after a tap on the status bar.
     *
     * @param scrollsToTop TRUE then the scroll view moves to the top after a
     *                     tap on the status bar.
     */
    @CMSetter("@property(nonatomic) BOOL scrollsToTop;")
    public void setScrollsToTop(boolean scrollsToTop) {
        this.scrollsToTop = scrollsToTop;
    }

    /**
     * Returns a Boolean that shows whether the horizontal indicator is visible.
     *
     * @return A Boolean that shows whether the horizontal indicator is visible.
     */
    @CMGetter("@property(nonatomic) BOOL showsHorizontalScrollIndicator;")
    public boolean showsHorizontalScrollIndicator() {
        return showsHorizontalScrollIndicator;
    }

    /**
     * Sets a Boolean that defines whether the horizontal indicator is visible.
     *
     * @param showsHorizontalScrollIndicator TRUE the horizontal indicator is
     *                                       visible only when tracking.
     */
    @CMSetter("@property(nonatomic) BOOL showsHorizontalScrollIndicator;")
    public void setShowsHorizontalScrollIndicator(boolean showsHorizontalScrollIndicator) {
        this.showsHorizontalScrollIndicator = showsHorizontalScrollIndicator;
    }

    /**
     * Returns a Boolean that shows whether the vertical indicator is visible.
     *
     * @return TRUE the vertical indicator is visible only when tracking.
     */
    @CMGetter("@property(nonatomic) BOOL showsVerticalScrollIndicator;")
    public boolean showsVerticalScrollIndicator() {
        return showsVerticalScrollIndicator;
    }

    /**
     * Sets a Boolean that defines whether the vertical indicator is visible.
     *
     * @param showsVerticalScrollIndicator TRUE the vertical indicator is
     *                                     visible only when tracking.
     */
    @CMSetter("@property(nonatomic) BOOL showsVerticalScrollIndicator;")
    public void setShowsVerticalScrollIndicator(boolean showsVerticalScrollIndicator) {
        this.showsVerticalScrollIndicator = showsVerticalScrollIndicator;
    }

    /**
     * Returns a Boolean that shows whether the content is scrolling even after
     * the finger was lifted.
     *
     * @return TRUE then scrolling continuous after the finger was lifted.
     */
    @CMGetter("@property(nonatomic, readonly, getter=isDecelerating) BOOL decelerating;")
    public boolean isDecelerating() {
        return decelerating;
    }

    /**
     * Returns a Boolean that show whether the user has started a scrolling
     * gesture.
     *
     * @return TRUE then the user has started a scrolling gesture.
     */
    @CMGetter("@property(nonatomic, readonly, getter=isDragging) BOOL dragging;")
    public boolean isDragging() {
        return dragging;
    }

    /**
     * Returns a Boolean that shows whether the user has touched the content(a
     * scrolling gesture is about to be recognized)
     *
     * @return TRUE then the user has touched the content(a scrolling gesture is
     * about to be recognized)
     */
    @CMGetter("@property(nonatomic, readonly, getter=isTracking) BOOL tracking;")
    public boolean isTracking() {
        return tracking;
    }

    /**
     * Returns a Boolean that shows whether there is bouncing of the content
     * when horizontal scrolling reaches the bounds of the content.
     *
     * @return A Boolean that shows whether there is bouncing of the content
     * when horizontal scrolling reaches the bounds of the content.
     */
    @CMGetter("@property(nonatomic) BOOL alwaysBounceHorizontal;")
    public boolean alwaysBounceHorizontal() {
        return alwaysBounceHorizontal;
    }

    /**
     * Sets a Boolean that defines whether there is bouncing of the content when
     * horizontal scrolling reaches the bounds of the content.
     *
     * @param alwaysBounceHorizontal A Boolean that defines whether there is
     *                               bouncing of the content when horizontal scrolling reaches the bounds of
     *                               the content.
     */
    @CMSetter("@property(nonatomic) BOOL alwaysBounceHorizontal;")
    public void setAlwaysBounceHorizontal(boolean alwaysBounceHorizontal) {
        this.alwaysBounceHorizontal = alwaysBounceHorizontal;
    }

    /**
     * Returns a Boolean that shows whether there is bouncing of the content
     * when vertical scrolling reaches the bounds of the content.
     *
     * @return A Boolean that shows whether there is bouncing of the content
     * when vertical scrolling reaches the bounds of the content.
     */
    @CMGetter("@property(nonatomic) BOOL alwaysBounceVertical;")
    public boolean alwaysBounceVertical() {
        return alwaysBounceVertical;
    }

    /**
     * Sets a Boolean that defines whether there is bouncing of the content when
     * vertical scrolling reaches the bounds of the content.
     *
     * @param alwaysBounceVertical A Boolean that defines whether there is
     *                             bouncing of the content when vertical scrolling reaches the bounds of the
     *                             content.
     */
    @CMSetter("@property(nonatomic) BOOL alwaysBounceVertical;")
    public void setAlwaysBounceVertical(boolean alwaysBounceVertical) {
        this.alwaysBounceVertical = alwaysBounceVertical;
    }

    /**
     * Returns a Boolean that shows whether touches within the scroll view,
     * specifically touches on subviews, can trigger a scrolling or stop the
     * current scrolling. Scrolling touches elsewhere cause regular scrolling.
     *
     * @return FALSE then a scrolling touch on a subview is ignored(when the
     * view is not scrolling) or stops the current scrolling.
     */
    @CMGetter("@property(nonatomic) BOOL canCancelContentTouches;")
    public boolean canCancelContentTouches() {
        return canCancelContentTouches;
    }

    /**
     * Sets a Boolean that determines whether touches within the scroll view,
     * specifically touches on subviews, can trigger a scrolling or stop the
     * current scrolling. Scrolling touches elsewhere cause regular scrolling.
     *
     * @param canCancelContentTouches FALSE then a scrolling touch on a subview
     *                                is ignored(when the view is not scrolling) or stops the current
     *                                scrolling.
     */
    @CMSetter("@property(nonatomic) BOOL canCancelContentTouches;")
    public void setCanCancelContentTouches(boolean canCancelContentTouches) {
        this.canCancelContentTouches = canCancelContentTouches;
    }

    /**
     * Returns a Boolean that shows whether the scrolling view handles scrolling
     * gestures with a delay.
     *
     * @return A Boolean that shows whether the scrolling view handles scrolling
     * gestures with a delay.
     */
    @CMGetter("@property(nonatomic) BOOL delaysContentTouches;")
    public boolean delaysContentTouches() {
        return delaysContentTouches;
    }

    /**
     * Sets a Boolean that defines whether the scrolling view handles scrolling
     * gestures with a delay.
     *
     * @param delaysContentTouches TRUE then the scrolling view handles
     *                             scrolling gestures with a delay.
     */
    @CMSetter("@property(nonatomic) BOOL delaysContentTouches;")
    public void setDelaysContentTouches(boolean delaysContentTouches) {
        this.delaysContentTouches = delaysContentTouches;
    }

    /**
     * Returns a Boolean that shows whether the scrolling is permitted only for
     * one direction.
     *
     * @return A Boolean that shows whether the scrolling is permitted only for
     * one direction.
     */
    @CMGetter("@property(nonatomic, getter=isDirectionalLockEnabled) BOOL directionalLockEnabled;")
    public boolean isDirectionalLockEnabled() {
        return directionalLockEnabled;
    }

    /**
     * Sets a Boolean that defines whether the scrolling is permitted only for
     * one direction.
     *
     * @param directionalLockEnabled A Boolean that defines whether the
     *                               scrolling is permitted only for one direction.
     */
    @CMSetter("@property(nonatomic, getter=isDirectionalLockEnabled) BOOL directionalLockEnabled;")
    public void setDirectionalLockEnabled(boolean directionalLockEnabled) {
        this.directionalLockEnabled = directionalLockEnabled;
    }

    /**
     * Returns the distance of the scroll indicator from the edges of the view.
     *
     * @return The distance of the scroll indicator from the edges of the view.
     */
    @CMGetter("@property(nonatomic) UIEdgeInsets scrollIndicatorInsets;")
    public UIEdgeInsets scrollIndicatorInsets() {
        return new UIEdgeInsets(scrollIndicatorInsets);
    }

    /**
     * Sets the distance of the scroll indicator from the edges of the view.
     *
     * @param scrollIndicatorInsets The distance of the scroll indicator from
     *                              the edges of the view.
     */
    @CMSetter("@property(nonatomic) UIEdgeInsets scrollIndicatorInsets;")
    public void setScrollIndicatorInsets(UIEdgeInsets scrollIndicatorInsets) {
        this.scrollIndicatorInsets.set(contentInset);
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns the deceleration rate after the finger is lifted.
     *
     * @return The deceleration rate after the finger is lifted.
     */
    @CMGetter("@property(nonatomic) CGFloat decelerationRate;")
    public double decelerationRate() {
        return decelerationRate;
    }

    /**
     * Sets the deceleration rate after the finger is lifted.
     *
     * @param decelerationRate The deceleration rate after the finger is lifted.
     */
    @CMSetter("@property(nonatomic) CGFloat decelerationRate;")
    public void setDecelerationRate(double decelerationRate) {
        this.decelerationRate = decelerationRate;
    }

    /**
     * Returns the style of the indicator.
     *
     * @return The style of the indicator.
     */
    @CMGetter("@property(nonatomic) UIScrollViewIndicatorStyle indicatorStyle;")
    public int indicatorStyle() {
        return indicatorStyle;
    }

    /**
     * Sets the style of the indicator.
     *
     * @param indicatorStyle The style of the indicator.
     */
    @CMSetter("@property(nonatomic) UIScrollViewIndicatorStyle indicatorStyle;")
    public void setIndicatorStyle(int indicatorStyle) {
        this.indicatorStyle = indicatorStyle;
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns a Boolean that shows whether the scroll view bounces when it
     * reaches the edge boundary.
     *
     * @return A Boolean that shows whether the scroll view bounces when it
     * reaches the edge boundary.
     */
    @CMGetter("@property(nonatomic) BOOL bounces;")
    public boolean bounces() {
        return bounces;
    }

    /**
     * Sets a Boolean that defines whether the scroll view bounces when it
     * reaches the edge boundary.
     *
     * @param bounces A Boolean that defines whether the scroll view bounces
     *                when it reaches the edge boundary.
     */
    @CMSetter("@property(nonatomic) BOOL bounces;")
    public void setBounces(boolean bounces) {
        this.bounces = bounces;
    }

    /**
     * Scrolls the specified area in order to be visible using animation or not.
     *
     * @param rect     The area that scrolled to be visible.
     * @param animated TRUE the scrolling is animated.
     */
    @CMSelector("- (void)scrollRectToVisible:(CGRect)rect \n"
            + "                   animated:(BOOL)animated;")
    public void scrollRectToVisible(CGRect rect, boolean animated) {
        double dx;
        if ((contentOffset.getX() >= rect.getOrigin().getX() && (contentOffset.getX() + getWidth()) <= (rect.getOrigin().getX() + rect.getSize().getWidth()))
                || (contentOffset.getX() <= rect.getOrigin().getX() && (contentOffset.getX() + getWidth()) >= (rect.getOrigin().getX() + rect.getSize().getWidth())))
            dx = 0;
        else {
            double dx1 = rect.getOrigin().getX() - contentOffset.getX();
            double dx2 = rect.getOrigin().getX() + rect.getSize().getWidth() - contentOffset.getX() - getWidth();
            dx = Math.abs(dx1) < Math.abs(dx2) ? dx1 : dx2;
        }

        double dy;
        if ((contentOffset.getY() >= rect.getOrigin().getY() && (contentOffset.getY() + getHeight()) <= (rect.getOrigin().getY() + rect.getSize().getHeight()))
                || (contentOffset.getY() <= rect.getOrigin().getY() && (contentOffset.getY() + getHeight()) >= (rect.getOrigin().getY() + rect.getSize().getHeight())))
            dy = 0;
        else {
            double dx1 = rect.getOrigin().getY() - contentOffset.getY();
            double dx2 = rect.getOrigin().getY() + rect.getSize().getHeight() - contentOffset.getY() - getHeight();
            dy = Math.abs(dx1) < Math.abs(dx2) ? dx1 : dx2;
        }

        setContentOffset(new CGPoint(contentOffset.getX() + dx, contentOffset.getY() + dy), animated);
    }

    /**
     * Displays the scroll indicators instantly.
     */
    @CMSelector("- (void)flashScrollIndicators;")
    public void flashScrollIndicators() {
        if (flasher != null)
            flasher.invalidate();
        flasher = Ticker.add(new FlashIndicator(), InterpolationCurve.Linear, 0.6);
    }

    @Override
    CGPoint locationRelativeToRoot(CGPoint rloc) {
        rloc.setX(rloc.getX() - contentOffset.getX() + contentInset.getLeft());
        rloc.setY(rloc.getY() - contentOffset.getY() + contentInset.getTop());
        return super.locationRelativeToRoot(rloc);
    }

    @Override
    void drawingChildren(CGContext ctx) {
        double dx = -contentOffset.getX() + contentInset.getLeft();
        double dy = -contentOffset.getY() + contentInset.getTop();
        ctx.translateCTM(dx, dy);
        super.drawingChildren(ctx);
        ctx.translateCTM(-dx, -dy);
    }

    @Override
    boolean shouldDrawOnTop() {
        return true;
    }

    @Override
    void drawOnTop(CGContext cx, CGRect rect) {
        if (!(dragging || tracking || decelerating || flashing))
            return;
        boolean willShowHorizontal = showsHorizontalScrollIndicator && (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) > getWidth();
        boolean willShowVertical = showsVerticalScrollIndicator && (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) > getHeight();
        double guiWidth = rect.getSize().getWidth()
                - scrollIndicatorInsets.getLeft()
                - scrollIndicatorInsets.getRight()
                - INDICATOR_INSET - INDICATOR_INSET
                - (willShowVertical ? INDICATOR_THICKNESS : 0);
        double guiHeight = rect.getSize().getHeight()
                - scrollIndicatorInsets.getTop()
                - scrollIndicatorInsets.getBottom()
                - INDICATOR_INSET - INDICATOR_INSET
                - (willShowHorizontal ? INDICATOR_THICKNESS : 0);
        if (guiWidth >= INDICATOR_THICKNESS && guiHeight >= INDICATOR_THICKNESS) {
            float c_alpha = dragging || tracking || decelerating ? 1 : flashAlpha;
            int fillColor = (int) (0xFF * c_alpha * 0.25f) << 24;
            int drawColor = ((int) (0xFF * c_alpha) << 24);
            GraphicsContext ctx = context(cx);
            if (willShowHorizontal) {
                double offsetCorrection = contentOffset.getX() < 0 ? -contentOffset.getX() : 0; // too small offset
                double sizeCorrection = Math.max((contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()), contentOffset.getX() + getWidth());  // too big offset
                double size = guiWidth * getWidth() / (sizeCorrection + offsetCorrection);
                double offset = guiWidth * (contentOffset.getX() + offsetCorrection) / (sizeCorrection + offsetCorrection);
                if (size < INDICATOR_THICKNESS)
                    size = INDICATOR_THICKNESS;
                if (offset + size > guiWidth)
                    offset = guiWidth - size;

                double x = rect.getOrigin().getX() + scrollIndicatorInsets.getLeft() + INDICATOR_INSET + offset;
                double y = rect.getOrigin().getY() + rect.getSize().getHeight() - scrollIndicatorInsets.getBottom() - INDICATOR_THICKNESS - INDICATOR_INSET;
                ctx.fillRoundRodBar(x, y, size, INDICATOR_THICKNESS, fillColor);
                ctx.drawRoundRodBar(x, y, size, INDICATOR_THICKNESS, drawColor);
            }
            if (willShowVertical) {
                double offsetCorrection = contentOffset.getY() < 0 ? -contentOffset.getY() : 0;
                double sizeCorrection = Math.max((contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()), contentOffset.getY() + getHeight());
                double size = guiHeight * getHeight() / (sizeCorrection + offsetCorrection);
                double offset = guiHeight * (contentOffset.getY() + offsetCorrection) / (sizeCorrection + offsetCorrection);
                if (size < INDICATOR_THICKNESS)
                    size = INDICATOR_THICKNESS;
                if (offset + size > guiHeight)
                    offset = guiHeight - size;

                double x = rect.getOrigin().getX() + rect.getSize().getWidth() - scrollIndicatorInsets.getRight() - INDICATOR_THICKNESS - INDICATOR_INSET;
                double y = rect.getOrigin().getY() + scrollIndicatorInsets.getTop() + INDICATOR_INSET + offset;
                ctx.fillRoundRodBar(x, y, INDICATOR_THICKNESS, size, fillColor);
                ctx.drawRoundRodBar(x, y, INDICATOR_THICKNESS, size, drawColor);
            }
        }
    }

    @Override
    public void drawRect(CGRect rect) {
        super.drawRect(rect);
    }

    private class ScrollContent implements TickerConsumer {

        final double xFrom, yFrom, xTo, yTo;

        public ScrollContent(double xTo, double yTo) {
            this.xFrom = contentOffset.getX();
            this.yFrom = contentOffset.getY();

            xTo = xTo < 0
                    ? 0
                    : (xTo > (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - getWidth()
                    ? (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - getWidth()
                    : pagingEnabled
                    ? ((int) ((xTo > xFrom + getWidth()
                    ? xFrom + getWidth()
                    : xTo) / getWidth() + 0.5)) * getWidth() + contentInset.getLeft() + contentInset.getRight()
                    : xTo);
            yTo = yTo < 0
                    ? 0
                    : (yTo > (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - getHeight()
                    ? (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - getHeight()
                    : pagingEnabled
                    ? ((int) ((yTo > yFrom + getHeight()
                    ? yFrom + getHeight()
                    : yTo) / getHeight() + 0.5)) * getHeight() + contentInset.getTop() + contentInset.getBottom()
                    : yTo);
            this.xTo = xTo;
            this.yTo = yTo;
        }

        @Override
        public void start() {
            flashScrollIndicators();
        }

        @Override
        public void apply(double progress) {
            setContentOffset((float) (xFrom + (xTo - xFrom) * progress), (float) (yFrom + (yTo - yFrom) * progress));
        }

        @Override
        public void end() {
            if (delegate != null)
                delegate.didEndDecelerating(UIScrollView.this);

            if (delegate != null)
                delegate.didEndScrollingAnimation(UIScrollView.this);
            invalidateTimers();
        }
    }

    private class SwipeContent implements TickerConsumer {

        private final double duration;
        private final double x, y;
        private double dx, dy;

        private SwipeContent(CGPoint scrollVelocity) {
            x = contentOffset.getX();
            y = contentOffset.getY();
            duration = 0.1f;
            dx = (float) (scrollVelocity.getX() > 0 ? -Math.pow(scrollVelocity.getX(), 1f / 1.2f) : Math.pow(-scrollVelocity.getX(), 1 / 1.2f));
            dx = pagingEnabled
                    ? -dx / 2 > getWidth() / 2
                    ? -(int) x % getWidth() - 20f
                    : dx / 2 > getWidth() / 2
                    ? (int) x % getWidth() + 20f
                    : 0
                    : x + dx < 0 - getWidth() / 4
                    ? contentInset.getLeft() + contentInset.getRight() - getWidth() / 4 - x
                    : x + dx > contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight() - getWidth() / 4
                    ? contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight() - 3 * getWidth() / 4 - x
                    : dx;
            dy = (float) (scrollVelocity.getY() > 0 ? -Math.pow(scrollVelocity.getY(), 1f / 1.2f) : Math.pow(-scrollVelocity.getY(), 1f / 1.2f));
            dy = pagingEnabled
                    ? -dy / 2 > getHeight() / 2
                    ? -(int) y % getHeight() - 20f
                    : dy / 2 > getHeight() / 2 ? (int) y % getHeight() + 20f
                    : 0
                    : y + dy < -getHeight() / 4
                    ? contentInset.getTop() + contentInset.getBottom() - getHeight() / 4 - y
                    : y + dy > contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom() - getHeight() / 4
                    ? contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom() - 3 * getHeight() / 4 - y
                    : dy;
        }

        @Override
        public void start() {
            decelerating = true;
            if (delegate != null)
                delegate.willBeginDecelerating(UIScrollView.this);
        }

        @Override
        public void apply(double progress) {
            if (Math.abs(dx) > 50 || Math.abs(dy) > 50)
                if (bounces)
                    setContentOffset((float) (x + dx * progress), (float) (y + dy * progress));
                else {
                    float newx = (float) (x + dx * progress < 0 ? 0
                            : x + dx * progress > contentSize.getWidth() - getWidth() ? contentSize.getWidth() - getWidth()
                            : x + dx * progress);
                    float newy = (float) (y + dy * progress < 0 ? 0
                            : y + dy * progress > contentSize.getHeight() - getHeight() ? contentSize.getHeight() - getHeight()
                            : (y + dy * progress));
                    setContentOffset(newx, newy);
                    if ((newx == 0 || newx == contentSize.getWidth() - getWidth()) && (newy == 0 || newy == contentSize.getHeight() - getHeight()))
                        if (scroller != null)
                            scroller.invalidate();
                }
        }

        @Override
        public void end() {
            decelerating = false;
            if (delegate != null)
                delegate.didEndDecelerating(UIScrollView.this);
            scroller = null;
            invalidateTimers();
            swipe = Ticker.add(new UIScrollView.ScrollContent(contentOffset.getX(), contentOffset.getY()), InterpolationCurve.EaseOut);
        }
    }

    private class FlashIndicator implements TickerConsumer {

        @Override
        public void start() {
            flashing = true;
        }

        @Override
        public void apply(double progress) {
            flashAlpha = (float) (1 - progress);
            Native.graphics().refreshDisplay();
        }

        @Override
        public void end() {
            flashing = false;
            flashAlpha = 1;
        }
    }

    @Override
    void applyLayout() {
        super.applyLayout();
        if (contentSolver != null) {
            List<ClConstraint> toRemove = new ArrayList<>();
            for (ClConstraint constraint : contentSolver.getConstraintMap().keySet())
                if (constraint instanceof ClStayConstraint)
                    toRemove.add(constraint);
            for (ClConstraint constraint : toRemove)
                contentSolver.removeConstraint(constraint);
            for (ClConstraint constraint : solver().getConstraintMap().keySet())
                if (constraint instanceof ClStayConstraint)
                    contentSolver.addConstraint(constraint);
            for (UIView child : subviews())
                if (!child.translatesAutoresizingMaskIntoConstraints())
                    addContentConstraints(child.relevantConstraints(this));
            applyContentSize();
        }
    }

    private void addContentConstraints(List<NSLayoutConstraint> constraints) {
        for (NSLayoutConstraint constraint : constraints) addContentConstraint(constraint);
    }

    private ClSimplexSolver contentSolver = null;


    private ClVariable getContentVariable(int attribute) {
        return contentVariableMap.get(attribute);
    }

    private void initContentVars() {
        contentVariableMap.put(NSLayoutAttribute.Left, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Content_Left"));
        contentVariableMap.put(NSLayoutAttribute.Top, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Content_Top"));
        contentVariableMap.put(NSLayoutAttribute.Width, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Content_Width"));
        contentVariableMap.put(NSLayoutAttribute.Height, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Content_Height"));
        contentSolver.beginEdit();
        for (Integer attr : contentVariableMap.keySet())
            contentSolver.addEditVar(getContentVariable(attr), new ClStrength("", new ClSymbolicWeight(new double[]{0})));
        contentSolver.addConstraint(new ClLinearInequality(new ClLinearExpression(getContentVariable(NSLayoutAttribute.Width), 1, 0), CL.GEQ, new ClLinearExpression(1), new ClStrength("Required", new ClSymbolicWeight(new double[]{749}))));
        contentSolver.addConstraint(new ClLinearInequality(new ClLinearExpression(getContentVariable(NSLayoutAttribute.Height), 1, 0), CL.GEQ, new ClLinearExpression(1), new ClStrength("Required", new ClSymbolicWeight(new double[]{749}))));
        contentSolver.resolve();
    }

    private void initContentSolver() {
        if (contentSolver == null) {
            contentSolver = new ClSimplexSolver();
            initContentVars();
        }
    }

    @Override
    public void addConstraint(NSLayoutConstraint constraint) {
        if ((constraint.firstItem() != null && constraint.secondItem() != null && constraint.firstItem() == this && isChild((UIView) constraint.secondItem())) ||
                (constraint.firstItem() != null && constraint.secondItem() != null && constraint.secondItem() == this && isChild((UIView) constraint.firstItem()))) {
            addContentConstraint(constraint);
        } else
            super.addConstraint(constraint);
    }

    private void addContentConstraint(NSLayoutConstraint constraint) {
        if (contentConstraints.contains(constraint))
            return;
        initContentSolver();
        initItemsIfNeeded(constraint);
        contentConstraints.add(constraint);
        addingContentConstraint = true;
        constraint.addToSolver(contentSolver);
        addingContentConstraint = false;
    }

    private boolean addingContentConstraint = false;

    @Override
    ClVariable getVariable(int attribute) {
        if (addingContentConstraint)
            return getContentVariable(attribute);
        return super.getVariable(attribute);
    }

    private boolean isChild(UIView item) {
        for (UIView child : subviews())
            if (child.equals(item)) {
                return true;
            }
        return false;
    }

    private void applyContentSize() {
        if (contentSolver == null)
            return;
        setContentSize(new CGSize((float) getContentVariable(NSLayoutAttribute.Width).getValue(),
                (float) getContentVariable(NSLayoutAttribute.Height).getValue()), false);
    }

    @Override
    public List<NSLayoutConstraint> constraints() {
        List<NSLayoutConstraint> constraints = new ArrayList<>(super.constraints());
        constraints.addAll(contentConstraints);
        return constraints;
    }
}
