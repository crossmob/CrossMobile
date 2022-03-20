/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.foundation.NSTimer;
import crossmobile.rt.StrongReference;
import org.crossmobile.bind.graphics.anim.Animation;
import org.crossmobile.bind.graphics.anim.AnimationAction;
import org.crossmobile.bind.graphics.anim.Animator;
import org.crossmobile.bind.graphics.anim.curve.CommonInterpolations;
import org.crossmobile.bind.graphics.theme.PainterExtraData;
import org.crossmobile.bind.graphics.theme.ScrollPainter;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;
import org.crossmobile.support.cassowary.*;
import org.crossmobile.support.cassowary.clconstraint.ClConstraint;
import org.crossmobile.support.cassowary.clconstraint.ClLinearInequality;
import org.crossmobile.support.cassowary.clconstraint.ClStayConstraint;

import java.util.*;

import static org.crossmobile.bind.graphics.Geometry.meter;

/**
 * UIScrollView class extends UIView and defines an object of a customized view
 * that is used in order to display content that exceeds the size of the
 * window.It provides options for altering the visible content using swiping
 * gestures within the view.
 */
@CMClass
public class UIScrollView extends UIView {

    private static final double SELECTION_THRESHOLD = 5;
    private static final double SPRING_FACTOR = 0.5;

    // Used in Theme and UITable view: for optimization reasons this is friendly
    final UIEdgeInsets scrollIndicatorInsets = UIEdgeInsets.zero();
    final CGPoint contentOffset = new CGPoint(0, 0);
    final CGSize contentSize = new CGSize(0, 0);
    final UIEdgeInsets contentInset = UIEdgeInsets.zero();
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

    private int rawState;

    private int indicatorStyle = UIScrollViewIndicatorStyle.Default;
    private boolean showsHorizontalScrollIndicator = true;
    private boolean showsVerticalScrollIndicator = true;
    private UIView lastHit;

    private UIScrollViewDelegate delegate = null;

    private NSTimer tapTimer = null;
    private Animation scroller = null;
    private Animation flasher = null;
    private Animation swipe = null;
    private Animation animatedScroll = null;
    private final PainterExtraData extraData;

    private final Map<Integer, ClVariable> contentVariableMap = new HashMap<>();
    private final List<NSLayoutConstraint> contentConstraints = new ArrayList<>();

    private double calculateNewPosition(double pos, double max, StrongReference<Boolean> shouldSpring) {
        if (max <= 0)
            return 0;
        if (pos < 0)
            if (bounces) {
                shouldSpring.set(true);
                pos = pos * SPRING_FACTOR;
            } else
                pos = 0;
        else if (pos > max)
            if (bounces) {
                shouldSpring.set(true);
                pos = max + (pos - max) * SPRING_FACTOR;
            } else
                pos = max;
        return pos;
    }

    private final UIPanGestureRecognizer pan = new UIPanGestureRecognizer(new NSSelector<UIGestureRecognizer>() { // Should be friendly, so that the tableview can prevent it
        @Override
        public void exec(UIGestureRecognizer arg) {
            switch (pan.state()) {
                case UIGestureRecognizerState.Cancelled:
                    tracking = dragging = false;
                    if (delegate != null)
                        delegate.didEndDragging(UIScrollView.this, false);
                    invalidateTimers();
                    tapTimer = null;
                    touchesCancelled(arg.touchList, arg.touchEvent);
                    break;
                case UIGestureRecognizerState.Began:
                    invalidateTimers();
                    pan.setTranslation(new CGPoint(-contentOffset.getX(), -contentOffset.getY()), UIScrollView.this);
                    dragging = false;
                    rawState = UIGestureRecognizerState.Possible;
                    if (delegate != null)
                        delegate.willBeginDragging(UIScrollView.this);
                    tapTimer = NSTimer.scheduledTimerWithTimeInterval(0.2, timer -> Native.lifecycle().runOnEventThread(()
                            -> touchesBegan(arg.touchList, arg.touchEvent)), null, false);
                    break;
                default:
                    tracking = false;
                    CGPoint transl = pan.translationInView(UIScrollView.this);
                    CGPoint scrollVelocity = pan.velocityInView(UIScrollView.this);
                    StrongReference<Boolean> shouldSpring = new StrongReference<>(false);
                    double x = calculateNewPosition(-transl.getX(), contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight() - cframe().getSize().getWidth(), shouldSpring);
                    double y = calculateNewPosition(-transl.getY(), contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom() - cframe().getSize().getHeight(), shouldSpring);
                    if (pan.state() != UIGestureRecognizerState.Ended) { // UIGestureRecognizerState.Changed
                        if (dragging)
                            setContentOffset(x, y, false); // no special animation
                        else if (Math.sqrt(Math.pow(contentOffset.getX() - x, 2) + Math.pow(contentOffset.getY() - y, 2)) > SELECTION_THRESHOLD) {
                            // Set dragging mode, disable component click mode
                            invalidateTimers();
                            touchesCancelled(arg.touchList, arg.touchEvent);
                            dragging = true;
                            tracking = true;
                            setContentOffset(x, y, false); // no special animation
                        }
                    } else {
                        // Ended
                        if (tapTimer != null && tapTimer.isValid())
                            tapTimer.fire();
                        touchesBegan(arg.touchList, arg.touchEvent);
                        touchesEnded(arg.touchList, arg.touchEvent);
                        if (dragging) {
                            invalidateTimers();
                            dragging = false;
                            if (scroller != null)
                                scroller.invalidate();
                            if (delegate != null)
                                delegate.didEndDragging(UIScrollView.this, false);
                            if (shouldSpring.get() && (x < 0 || x > (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - cframe().getSize().getWidth() || y < 0 || y > (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - cframe().getSize().getHeight())) {
                                float newX = (float) (x < 0 ? 0
                                        : Math.min(x, (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - cframe().getSize().getWidth()));
                                float newY = (float) (y < 0 ? 0
                                        : Math.min(y, (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - cframe().getSize().getHeight()));
                                startDecelerating();
                                setContentOffset(newX, newY, true);
                            } else if (meter(scrollVelocity) > 1) {
                                startDecelerating();
                                if (scroller != null)
                                    scroller.invalidate();
                                scroller = Animator.add(new SwipeContent(scrollVelocity), CommonInterpolations.EaseOut, 0.5F);
                            } else if (pagingEnabled) {
                                startDecelerating();
                                setContentOffset(x + 0.5, y + 0.5, true);
                            }
                        }
                    }
                    break;
            }
        }
    });

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
        extraData = painter().initExtraData();
        setClipsToBounds(true);
        pan.setCancelsTouchesInView(true);
        addGestureRecognizer(pan);
    }

    @SuppressWarnings("unchecked")
    private ScrollPainter<PainterExtraData> painter() {
        return (ScrollPainter<PainterExtraData>) painter;
    }

    private void invalidateTimers() {
        if (tapTimer != null && tapTimer.isValid())
            tapTimer.invalidate();
        tapTimer = null;
        if (flasher != null)
            flasher.invalidate();
        flasher = null;
        if (swipe != null)
            swipe.invalidate();
        swipe = null;
        if (animatedScroll != null)
            animatedScroll.invalidate();
        animatedScroll = null;
        if (scroller != null)
            scroller.invalidate();
        scroller = null;
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        if (rawState == UIGestureRecognizerState.Began)
            return; // Already fired this event through timer
        if (rawState == UIGestureRecognizerState.Possible) {
            lastHit = super.hitTest(touches.iterator().next().locationInView(this), event);
            if (lastHit == this)
                lastHit = null; // We don't care for self hits
        } else
            lastHit = null;
        if (lastHit != null) {
            rawState = UIGestureRecognizerState.Began;
            lastHit.touchesBegan(touches, event);
        } else
            rawState = UIGestureRecognizerState.Failed;
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        if (lastHit != null && rawState == UIGestureRecognizerState.Began) {
            rawState = UIGestureRecognizerState.Ended;
            lastHit.touchesEnded(touches, event);
        }
        lastHit = null;
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        if (lastHit != null && rawState == UIGestureRecognizerState.Began)
            lastHit.touchesCancelled(touches, event);
        rawState = UIGestureRecognizerState.Cancelled;
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
        return view == null ? null : view instanceof UIScrollView || view == this ? view : firstAncestorScrollView(view);
    }

    private UIView firstAncestorScrollView(UIView view) {
        UIView firstAncestorScrollView;
        firstAncestorScrollView = view;
        while ((firstAncestorScrollView = firstAncestorScrollView.superview()) != null)
            if (firstAncestorScrollView instanceof UIScrollView)
                return firstAncestorScrollView;
        return null;
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
        setContentSize(contentSize.getWidth(), contentSize.getHeight());
        setNeedsLayout();
    }

    void setContentSize(double width, double height) {
        contentSize.setWidth(width);
        contentSize.setHeight(height);
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
            setContentOffset(offset.getX(), offset.getY(), animated);
    }

    private void setContentOffset(double x, double y, boolean animated) {
        if (animated) {
            invalidateTimers();
            animatedScroll = Animator.add(new ScrollContent(x, y), CommonInterpolations.EaseInOut, 0.3);
        } else {
            if ((contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) <= cframe().getSize().getWidth())
                x = contentOffset.getX();
            if ((contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) <= cframe().getSize().getHeight())
                y = contentOffset.getY();
            contentOffset.setX((int) (x + 0.5));
            contentOffset.setY((int) (y + 0.5));
            if (delegate != null)
                delegate.didScroll(UIScrollView.this);
            layoutNativeFromRoot();
            setNeedsDisplay();
        }
    }

    private void startDecelerating() {
        if (!decelerating) {
            decelerating = true;
            if (delegate != null)
                delegate.willBeginDecelerating(this);
        }
    }

    private void endDecelerating() {
        if (decelerating) {
            decelerating = false;
            if (delegate != null)
                delegate.didEndDecelerating(this);
            flashScrollIndicators();
        }
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
     * the scroll view (expressed in points).
     *
     * @param contentInset The distance that the content of the scroll view is
     *                     inset inside of the scroll view
     *                     inset inside of the scroll view
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
        this.scrollIndicatorInsets.set(scrollIndicatorInsets);
        setNeedsDisplay();
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
        if ((contentOffset.getX() >= rect.getOrigin().getX() && (contentOffset.getX() + cframe().getSize().getWidth()) <= (rect.getOrigin().getX() + rect.getSize().getWidth()))
                || (contentOffset.getX() <= rect.getOrigin().getX() && (contentOffset.getX() + cframe().getSize().getWidth()) >= (rect.getOrigin().getX() + rect.getSize().getWidth())))
            dx = 0;
        else {
            double dx1 = rect.getOrigin().getX() - contentOffset.getX();
            double dx2 = rect.getOrigin().getX() + rect.getSize().getWidth() - contentOffset.getX() - cframe().getSize().getWidth();
            dx = Math.abs(dx1) < Math.abs(dx2) ? dx1 : dx2;
        }

        double dy;
        if ((contentOffset.getY() >= rect.getOrigin().getY() && (contentOffset.getY() + cframe().getSize().getHeight()) <= (rect.getOrigin().getY() + rect.getSize().getHeight()))
                || (contentOffset.getY() <= rect.getOrigin().getY() && (contentOffset.getY() + cframe().getSize().getHeight()) >= (rect.getOrigin().getY() + rect.getSize().getHeight())))
            dy = 0;
        else {
            double dx1 = rect.getOrigin().getY() - contentOffset.getY();
            double dx2 = rect.getOrigin().getY() + rect.getSize().getHeight() - contentOffset.getY() - cframe().getSize().getHeight();
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
        flasher = Animator.add(new AnimationAction() {
            @Override
            public void start() {
                painter().startFlashing(extraData);
            }

            @Override
            public void apply(double progress) {
                painter().setFlashPercent(progress, extraData);
                Native.graphics().refreshDisplay();
            }

            @Override
            public void end() {
                painter().endFlashing(extraData);
            }
        }, CommonInterpolations.Linear, 0.4);
    }

    @Override
    void locationRelativeToRoot(CGPoint rloc) {
        rloc.setX(rloc.getX() - contentOffset.getX() + contentInset.getLeft());
        rloc.setY(rloc.getY() - contentOffset.getY() + contentInset.getTop());
        super.locationRelativeToRoot(rloc);
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
        painter().draw(this, rect, extraData);
    }

    private class SwipeContent implements AnimationAction {

        private final double x, y;
        private double dx, dy;

        private SwipeContent(CGPoint scrollVelocity) {
            x = contentOffset.getX();
            y = contentOffset.getY();
            double width = cframe().getSize().getWidth();
            double height = cframe().getSize().getHeight();
            dx = (float) (scrollVelocity.getX() > 0 ? -Math.pow(scrollVelocity.getX(), 1f / 1.2f) : Math.pow(-scrollVelocity.getX(), 1 / 1.2f));
            dx = pagingEnabled
                    ? -dx / 2 > width / 2
                    ? -(int) x % width - 20f
                    : dx / 2 > width / 2
                    ? (int) x % width + 20f
                    : 0
                    : x + dx < 0 - width / 4
                    ? contentInset.getLeft() + contentInset.getRight() - width / 4 - x
                    : x + dx > contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight() - width / 4
                    ? contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight() - 3 * width / 4 - x
                    : dx;
            dy = (float) (scrollVelocity.getY() > 0 ? -Math.pow(scrollVelocity.getY(), 1f / 1.2f) : Math.pow(-scrollVelocity.getY(), 1f / 1.2f));
            dy = pagingEnabled
                    ? -dy / 2 > height / 2
                    ? -(int) y % height - 20f
                    : dy / 2 > height / 2 ? (int) y % height + 20f
                    : 0
                    : y + dy < -height / 4
                    ? contentInset.getTop() + contentInset.getBottom() - height / 4 - y
                    : y + dy > contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom() - height / 4
                    ? contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom() - 3 * height / 4 - y
                    : dy;
        }

        @Override
        public void start() {
        }

        @Override
        public void apply(double progress) {
            if (Math.abs(dx) > 50 || Math.abs(dy) > 50)
                if (bounces)
                    setContentOffset(x + dx * progress, y + dy * progress, false);
                else {
                    double width = cframe().getSize().getWidth();
                    double height = cframe().getSize().getHeight();
                    double newX = (x + dx * progress < 0 ? 0
                            : Math.min(x + dx * progress, contentSize.getWidth() - width));
                    double newY = (y + dy * progress < 0 ? 0
                            : Math.min(y + dy * progress, contentSize.getHeight() - height));
                    setContentOffset(newX, newY, false);
//                    if ((newX == 0 || newX == contentSize.getWidth() - width) && (newY == 0 || newY == contentSize.getHeight() - height))
//                        if (scroller != null)
//                            scroller.invalidate();
                }
        }

        @Override
        public void end() {
            invalidateTimers();
            swipe = Animator.add(new ScrollContent(contentOffset.getX(), contentOffset.getY()), CommonInterpolations.EaseOut);
        }
    }

    private class ScrollContent implements AnimationAction {

        final double xFrom, yFrom, xTo, yTo;

        ScrollContent(double xTo, double yTo) {
            this.xFrom = contentOffset.getX();
            this.yFrom = contentOffset.getY();
            xTo = xTo < 0
                    ? 0
                    : (xTo > (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - cframe().getSize().getWidth()
                    ? (contentSize.getWidth() + contentInset.getLeft() + contentInset.getRight()) - cframe().getSize().getWidth()
                    : pagingEnabled
                    ? ((int) (Math.min(xTo, xFrom + cframe().getSize().getWidth()) / cframe().getSize().getWidth() + 0.5)) * cframe().getSize().getWidth() + contentInset.getLeft() + contentInset.getRight()
                    : xTo);
            yTo = yTo < 0
                    ? 0
                    : (yTo > (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - cframe().getSize().getHeight()
                    ? (contentSize.getHeight() + contentInset.getTop() + contentInset.getBottom()) - cframe().getSize().getHeight()
                    : pagingEnabled
                    ? ((int) (Math.min(yTo, yFrom + cframe().getSize().getHeight()) / cframe().getSize().getHeight() + 0.5)) * cframe().getSize().getHeight() + contentInset.getTop() + contentInset.getBottom()
                    : yTo);
            this.xTo = xTo;
            this.yTo = yTo;
        }

        @Override
        public void start() {
        }

        @Override
        public void apply(double progress) {
            setContentOffset(xFrom + (xTo - xFrom) * progress, (yFrom + (yTo - yFrom) * progress), false);
        }

        @Override
        public void end() {
            invalidateTimers();
            endDecelerating();
            if (delegate != null)
                delegate.didEndScrollingAnimation(UIScrollView.this);
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
            setContentSize(getContentVariable(NSLayoutAttribute.Width).getValue(),
                    getContentVariable(NSLayoutAttribute.Height).getValue());
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

    @Override
    public List<NSLayoutConstraint> constraints() {
        List<NSLayoutConstraint> constraints = new ArrayList<>(super.constraints());
        constraints.addAll(contentConstraints);
        return constraints;
    }
}
