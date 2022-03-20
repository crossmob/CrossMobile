/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.*;
import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSTimer;
import crossmobile.ios.quartzcore.CALayer;
import crossmobile.ios.quartzcore.CAShapeLayer;
import org.crossmobile.bind.graphics.*;
import org.crossmobile.bind.graphics.theme.FixedSizeRequirement;
import org.crossmobile.bind.graphics.theme.ThemePainter;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bind.wrapper.NativeWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.support.cassowary.ClSimplexSolver;
import org.crossmobile.support.cassowary.ClVariable;
import org.robovm.objc.annotation.UIAppearanceSelector;
import org.robovm.objc.block.VoidBlock1;

import java.lang.ref.WeakReference;
import java.util.*;

import static crossmobile.ios.coregraphics.GraphicsDrill.*;
import static crossmobile.ios.uikit.UIViewContentMode.*;
import static org.crossmobile.bind.graphics.AbstractGraphicsBridge.DrawingDepth;
import static org.crossmobile.bind.system.Debug.ENABLE_DEBUG;
import static org.crossmobile.bind.system.Debug.Live_Graphics_Debug;

/**
 * UIView class defines a rectangular area on the screen that encloses the
 * visible content of an application. The class contains methods related to
 * modifications and controls over that area triggered by events such as user
 * interaction with that area.
 */
@SuppressWarnings({"ConstantConditions", "unchecked"})
@CMClass
public class UIView extends UIResponder implements UIAccessibilityIdentification, UIAppearance, UIAppearanceContainer {

    /* Constants */
    @SuppressWarnings("unused")
    public static final double NoIntrinsicMetric = 0;

    // Use this universal Runnable whenever we want to refresh display
    private static final Runnable refreshDisplay = () -> Native.graphics().refreshDisplay();

    private static final Object[] animationLock = new Object[0];
    private static cmViewAnimation pendingAnim;
    private static boolean animationsEnabled = true;
    private final List<UIView> children = new ArrayList<>();
    //parameters for auto layout
    private final List<NSLayoutConstraint> constraints = new ArrayList<>();
    //    private boolean initSolverFlag = true;
    private final Map<Integer, ClVariable> variableMap = new HashMap<>();
    final CGSize intrinsicContentSize = new CGSize(0, 0);
    final ThemePainter<?> painter;
    /*
     * These properties need to be addressed form the animations, so they
     * shouldn't be private
     */
    private final CGRect frame = CGRect.zero();
    private final CGRect oldFrame = CGRect.zero();
    double alpha = 1;
    private double parentAlpha = 1;
    private UIColor background;
    CGAffineTransform transform = null;
    /*
     * This property is used in UIWindow to optimize gestures
     */
    List<UIGestureRecognizer> gestures = null;
    /*
     * This variable is also used in MainActivity to support hardware back
     * button
     */
    UIViewController controller;
    //Guides
    private List<UILayoutGuide> layoutGuides;
    private UILayoutGuide layoutMarginsGuide;
    //Margin
    UIEdgeInsets layoutMargins = new UIEdgeInsets(8, 8, 8, 8);
    private boolean preservesSuperviewLayoutMargins;
    /*
     * These properties need to be addressed form the animations, so they
     * shouldn't be private
     */
    private String restorationIdentifier = null;
    private CGAffineTransform fullTransform = null;
    private CGAffineTransform inverseTransform = null;
    private Object nativeDrawingTransf = null;
    private Object nativeDrawingTransfCache = null;
    private WeakReference<UIView> parentRef = null;
    private int tag = 0;
    private boolean userInteraction = true;
    private boolean opaque = true;
    private boolean hidden = false;
    private UIColor tintColor = null;
    private int tintAdjustmentMode = -1;
    private boolean clearcontext = false;
    private boolean clipsToBounds = false;
    private int autoResizing = UIViewAutoresizing.None;
    private boolean autoresizesSubviews = true;
    private int contentMode;
    private boolean multipleTouchEnabled = false;
    private CALayer layer;
    private UIView maskView;
    private cmConstraints ARMconstraints;
    private WidgetWrapper<UIView, NativeWrapper<? extends GraphicsContext<?>>, GraphicsContext<?>> widget;
    // Debug variables
    private boolean translatesAutoresizingMaskIntoConstraints = true;
    private boolean needsUpdateConstraints = false;
    private ClSimplexSolver solver = null;
    private float horizontalHuggingPriority = 250;
    private float verticalHuggingPriority = 250;
    private float horizontalCompressionResistancePriority = 749;
    private float verticalCompressionResistancePriority = 749;
    private Map<String, NSLayoutConstraint> intrinsicConstraints;
    private Map<String, NSLayoutConstraint> systemConstraints;
    //Safe Area
    private UIEdgeInsets safeAreaInsets = UIEdgeInsets.zero();
    private UILayoutGuide safeAreaLayoutGuide;
    private boolean insetsLayoutMarginsFromSafeArea = true;
    private int overrideUserInterfaceStyle = UIUserInterfaceStyle.Unspecified;
    private String accessibilityIdentifier;
    private boolean debugSelf;

    private Anchor anchors;

    /**
     * Constructs a default UIWindow object located at (0,0) with 0 weight and 0
     * height.
     */
    public UIView() {
        this(CGRect.zero(), null);
    }

    /**
     * Initializes and returns a newly allocated view object with the specified
     * frame rectangle.
     *
     * @param frame The frame rectangle for the view
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UIView(CGRect frame) {
        this(frame, null);
    }

    UIView(CGRect frame, UIColor backgroundColor) {
        painter = Native.graphics().themeManager().getPainter(this);    // Should be done early, since some widgets require frame manipulation
        setFrameImpl(frame);
        this.background = backgroundColor;
    }

    private static CGPoint convertPoint(CGPoint point, UIView from, UIView to) {
        if (from == to)
            return point;

        point = Geometry.copy(point);
        // performCallbacks up the chain, from the source view up to screen
        UIView cur = from;
        while (cur != null) {
            point = cur.selfPointTransformations(point, false);
            cur = cur.superview();
        }
        // performCallbacks down the chain, from the screen to the destination view
        if (to != null) {
            ArrayList<UIView> path = new ArrayList<>();
            cur = to;
            while (cur != null) {
                path.add(cur);
                cur = cur.superview();
            }
            for (int i = path.size() - 1; i >= 0; i--)
                path.get(i).selfPointTransformations(point, true);
        }
        return point;
    }

    /**
     * Animates changes between views using the specified duration.
     *
     * @param duration   The duration of the animations measured in seconds.
     * @param animations The changes to commit to the views. Not NULL.
     */
    @CMSelector("+ (void)animateWithDuration:(NSTimeInterval)duration animations:(void (^)(void))animations")
    public static void animateWithDuration(double duration, Runnable animations) {
        animateWithDuration(duration, 0, UIViewAnimationOptions.CurveEaseInOut, animations, null);
    }

    @CMSelector("+ (void)animateWithDuration:(NSTimeInterval)duration \n"
            + "                 animations:(void (^)(void))animations \n"
            + "                 completion:(void (^)(BOOL finished))completion;")
    public static void animateWithDuration(double duration, Runnable animations, VoidBlock1<Boolean> completion) {
        animateWithDuration(duration, 0, UIViewAnimationOptions.CurveEaseInOut, animations, completion);
    }

    /**
     * Animates changes between views using the specified options.
     *
     * @param duration               The duration of the animations measured in seconds.
     * @param delay                  The delay before the beginning of the animations.
     * @param UIViewAnimationOptions Options to perform the animations.
     * @param animations             The changes to commit to the views. Not NULL.
     * @param completion             A block object to be executed when the animations ends.
     * @see crossmobile.ios.uikit.UIViewAnimationOptions
     */
    @CMSelector("+ (void)animateWithDuration:(NSTimeInterval)duration\n"
            + "                      delay:(NSTimeInterval)delay\n"
            + "                    options:(UIViewAnimationOptions)options\n"
            + "                 animations:(void (^)(void))animations\n"
            + "                 completion:(void (^)(BOOL finished))completion")
    public static void animateWithDuration(double duration, double delay, int UIViewAnimationOptions, Runnable animations, VoidBlock1<Boolean> completion) {
        if (animationsEnabled && animations != null) {
            synchronized (animationLock) {
                pendingAnim().setDuration(duration);
                pendingAnim.setDelay(delay);
                pendingAnim.setCurve((UIViewAnimationOptions >>> 16) & 0xF);
                pendingAnim.setTransition((UIViewAnimationOptions >>> 20) & 0x7);
                pendingAnim.setDelegate(completion);
            }
            animations.run();
            synchronized (animationLock) {
                pendingAnim.commit();
                pendingAnim = null;
            }
        }
    }

    /**
     * Sets the transition to be applied to a parent view during an animation block.
     * In the animation block, perform all required changes to the child views.
     *
     * @param view                   The view to which the transition will be applied.
     * @param duration               The duration of the animation
     * @param UIViewAnimationOptions The transition options. Usual values are UIViewAnimationOptions.Transition* values
     * @param animations             The changes to commit to the views. Not NULL.
     * @param completion             A block object to be executed when the animations ends.
     * @see UIViewAnimationOptions
     */
    @CMSelector("+ (void)transitionWithView:(UIView *)view \n" +
            "                  duration:(NSTimeInterval)duration \n" +
            "                   options:(UIViewAnimationOptions)options \n" +
            "                animations:(void (^)(void))animations \n" +
            "                completion:(void (^)(BOOL finished))completion;")
    public static void transitionWithView(UIView view, double duration, int UIViewAnimationOptions, Runnable animations, VoidBlock1<Boolean> completion) {
        if (animationsEnabled && animations != null) {
            pendingAnim().setParent(view);
            animateWithDuration(duration, 0, UIViewAnimationOptions, animations, completion);
        }
    }

    /**
     * Sets the time that the current animation block should begin.
     *
     * @param startTime The time that the current animation block should begin.
     */
    @CMSelector("+ (void)setAnimationStartDate:(NSDate *)startDate;")
    public static void setAnimationStartDate(NSDate startTime) {
        pendingAnim().setDelay(startTime.timeIntervalSinceReferenceDate() - NSDate.date().timeIntervalSinceReferenceDate());
    }

    /**
     * Sets a Boolean that defines whether the animations are enabled.
     *
     * @param animationsEnabled A Boolean that defines whether the animations
     *                          are enabled.
     */
    @CMSelector("+ (void)setAnimationsEnabled:(BOOL)enabled;")
    public static void setAnimationsEnabled(boolean animationsEnabled) {
        synchronized (animationLock) {
            UIView.animationsEnabled = animationsEnabled;
        }
    }

    /**
     * Sets the duration of the animations of a block.
     *
     * @param duration The duration of the animations of a block expressed in
     *                 seconds.
     */
    @CMSelector("+ (void)setAnimationDuration:(NSTimeInterval)duration;")
    public static void setAnimationDuration(double duration) {
        pendingAnim().setDuration(duration);
    }

    /**
     * Sets the amount of time (in seconds) to wait before animating property
     * changes within an animation block.
     *
     * @param delay The interval until the change of animation property within a
     *              block expressed in seconds.
     */
    @CMSelector("+ (void)setAnimationDelay:(NSTimeInterval)delay;")
    public static void setAnimationDelay(double delay) {
        pendingAnim().setDelay(delay);
    }

    /**
     * Sets the type of animation curve.
     *
     * @param UIViewAnimationCurve The type of animation curve.
     */
    @CMSelector("+ (void)setAnimationCurve:(UIViewAnimationCurve)curve;")
    public static void setAnimationCurve(int UIViewAnimationCurve) {
        pendingAnim().setCurve(UIViewAnimationCurve);
    }

    /**
     * Sets the number of repetitions for the animations of a block.
     *
     * @param repeatCount The number of repetitions for the animations of a
     *                    block.Zero means no repetition and this number can be a fraction for the
     *                    repetitions.
     */
    @CMSelector("+ (void)setAnimationRepeatCount:(float)repeatCount;\n"
            + "")
    public static void setAnimationRepeatCount(float repeatCount) {
        pendingAnim().setRepeats(repeatCount);
    }

    /**
     * Sets a Boolean value that defines whether the animations of an animation
     * block reverse themselves automatically.
     *
     * @param repeatAutoreverses A Boolean value that defines whether the
     *                           animations of an animation block reverse themselves automatically.
     */
    @CMSelector("+ (void)setAnimationRepeatAutoreverses:(BOOL)repeatAutoreverses;")
    public static void setAnimationRepeatAutoreverses(boolean repeatAutoreverses) {
        pendingAnim().setAutoReverse(repeatAutoreverses);
    }

    private static cmViewAnimation pendingAnim() {
        if (pendingAnim == null)
            pendingAnim = new cmViewAnimation();
        return pendingAnim;
    }

    /**
     * Sets a Boolean value that defines whether the animation should start
     * playing from its current state.
     *
     * @param fromCurrentState A Boolean value that defines whether the
     *                         animation should start playing from its current state.
     */
    @SuppressWarnings("unused")
    @CMSelector("+ (void)setAnimationBeginsFromCurrentState:(BOOL)fromCurrentState;")
    public static void setAnimationBeginsFromCurrentState(boolean fromCurrentState) {
        Native.system().notImplemented();
    }

    /**
     * Returns a Boolean that shows whether the animations are enabled.
     *
     * @return A Boolean that shows whether the animations are enabled.
     */
    @CMSelector("+ (BOOL)areAnimationsEnabled;")
    public static boolean areAnimationsEnabled() {
        synchronized (animationLock) {
            return animationsEnabled;
        }
    }

    /**
     * Returns a Boolean value that shows whether this view is based on the
     * constraint based layout system.
     *
     * @return A Boolean value that shows whether this view is based on the
     * constraint based layout system.
     */
    @CMSelector("+ (BOOL)requiresConstraintBasedLayout;")
    public static boolean requiresConstraintBasedLayout() {
        return false;
    }

    @Override
    public UIResponder nextResponder() {
        return controller == null ? superview() : controller;
    }

    /**
     * Returns a structure that is used to define view's dimensions and position
     * in the coordinate system of its superview.
     *
     * @return The structure that is used to define view's dimensions and
     * position in the coordinate system of its superview.
     */
    @CMGetter("@property(nonatomic) CGRect frame;")
    public CGRect frame() {
        return Geometry.copy(frame);
    }

    @SuppressWarnings("SpellCheckingInspection")
    CGRect cframe() {
        return frame;
    }

    /**
     * Sets view's dimensions and position according to the structure specified
     * as frame parameter.
     *
     * @param frame The structure that defines view's dimensions and position in
     *              the coordinate system of its superview.
     */
    @CMSetter("@property(nonatomic) CGRect frame;")
    public void setFrame(CGRect frame) {
        if (!this.frame.equals(frame))
            if (pendingAnim != null)
                pendingAnim.setFrame(this, frame);
            else {
                setFrameImpl(frame);
                layoutIfNeeded();
            }
    }

    /**
     * Get the current mask view of this view.
     *
     * @return The mask view, could be null
     * @see #setMaskView(UIView)
     */
    @CMGetter("@property(nullable, nonatomic, strong) UIView *maskView;")
    public UIView maskView() {
        return maskView;
    }

    /**
     * Set the mask of the current view. Use another view, not belonging to
     * any view hierarchy to define the mask of this view. From the mask view,
     * only the alpha channel would be taken into account.
     *
     * @param maskView The new mask view, could be null
     */
    @CMSetter("@property(nullable, nonatomic, strong) UIView *maskView;")
    public void setMaskView(UIView maskView) {
        this.maskView = maskView;
        setNeedsDisplay();
    }

    /**
     * Returns an integer bit bask that defines the way this view changes its
     * size on a superview size change.
     *
     * @return An integer bit bask that defines the way this view changes its
     * size on a superview size change.
     */
    @CMGetter("@property(nonatomic) UIViewAutoresizing autoresizingMask;")
    public int autoresizingMask() {
        return autoResizing;
    }

    /**
     * Sets an integer bit bask that defines the way this view changes its size
     * on a superview size change.
     *
     * @param UIViewAutoresizing integer bit bask that defines the way this view
     *                           changes its size on a superview size change.
     * @see crossmobile.ios.uikit.UIViewAutoresizing
     */
    @CMSetter("@property(nonatomic) UIViewAutoresizing autoresizingMask;")
    public void setAutoresizingMask(int UIViewAutoresizing) {
        if (autoResizing != UIViewAutoresizing) {
            autoResizing = UIViewAutoresizing;
            updateConstraints();
        }
    }

    /**
     * Returns a Boolean that defines if this view after a change on its size
     * automatically changes the size of its subviews.
     *
     * @return A Boolean that defines if this view after a change on its size
     * automatically changes the size of its subviews.
     */
    @CMGetter("@property(nonatomic) BOOL autoresizesSubviews;")
    public boolean autoresizesSubviews() {
        return autoresizesSubviews;
    }

    /**
     * Returns a Boolean that shows if this view after a change on its size
     * automatically changes the size of its subviews.
     *
     * @param autoresizesSubviews A Boolean that shows if this view after a
     *                            change on its size automatically changes the size of its subviews.
     */
    @CMSetter("@property(nonatomic) BOOL autoresizesSubviews;")
    public void setAutoresizesSubviews(boolean autoresizesSubviews) {
        if (this.autoresizesSubviews != autoresizesSubviews) {
            this.autoresizesSubviews = autoresizesSubviews;
            if (autoresizesSubviews)
                for (UIView child : children)
                    child.updateConstraints();
        }
    }

    /**
     * Sets a flag that indicates that the layout of this view's subviews need
     * to be updated and also defines that the update will take place on the
     * next update cycle.
     */
    @CMSelector("- (void)setNeedsLayout;")
    public void setNeedsLayout() {
        RelayoutRegistry.register(this);
    }

    /**
     * Forces the layout of this view's subviews to change immediately when
     * needed.
     */
    @CMSelector("- (void)layoutIfNeeded;")
    public void layoutIfNeeded() {
        boolean sameSize = oldFrame.equals(frame);
        boolean sameOrigin = oldFrame.getOrigin().equals(frame.getOrigin());
        Geometry.set(oldFrame, frame);
        if (!sameSize) {
            updateConstraints();
            layoutSubviews();
        } else if (!sameOrigin) {
            Geometry.set(oldFrame, frame);
            layoutNativeFromRoot();
            setNeedsDisplay();
        }
    }

    /* should be removed */
    void forceLayout() {
        updateConstraints();
        layoutSubviews();
    }

    /**
     * Changes the layout of this view's subviews.
     */
    @CMSelector("- (void)layoutSubviews;")
    public void layoutSubviews() {
        safeAreaInsets();
        if (autoresizesSubviews)
            applyLayout();
        layoutNativeFromRoot();
        setNeedsDisplay();
    }

    /**
     *
     */
    void layoutNativeFromRoot() {
        if (widget != null) {
            CGPoint loc = CGPoint.zero();
            locationRelativeToRoot(loc);
            widget.setFrame(loc.getX(), loc.getY(), frame.getSize().getWidth(), frame.getSize().getHeight());
        }
        for (UIView child : children)
            child.layoutNativeFromRoot();
    }

    /**
     * Update the constraints of this view
     */
    @CMSelector("- (void)updateConstraints;")
    public void updateConstraints() {
        ARMconstraints = cmConstraints.getConstraints(this, superview());
        if (!translatesAutoresizingMaskIntoConstraints)
            if (superview() != null) {
                superview().updateConstraints();
                superview().setNeedsLayout();
            } else
                setNeedsLayout();
    }

    @CMSelector("- (void)updateConstraintsIfNeeded;")
    public void updateConstraintsIfNeeded() {
        if (needsUpdateConstraints) {
            updateConstraints();
            needsUpdateConstraints = false;
        }
    }

    /**
     * Returns a Boolean value that shows whether the view's constraints need to
     * be updated.
     *
     * @return A Boolean value that shows whether the view's constraints need to
     * be updated.
     */
    @CMSelector("- (BOOL)needsUpdateConstraints;")
    public boolean needsUpdateConstraints() {
        return needsUpdateConstraints;
    }

    /**
     * Sets a Boolean value that defines whether the view's constraints need to
     * be updated.
     */
    @CMSelector("- (void)setNeedsUpdateConstraints;")
    public void setNeedsUpdateConstraints() {
        this.needsUpdateConstraints = true;
        updateConstraintsIfNeeded();
    }

    /**
     * Returns the bounds of this view in its own coordinate system expressed
     * using CGRect structure.
     *
     * @return The bounds of this view in its own coordinate system expressed
     * using CGRect structure.
     */
    @CMGetter("@property(nonatomic) CGRect bounds;")
    public CGRect bounds() {
        CGRect bounds = frame();
        bounds.getOrigin().setX(0);
        bounds.getOrigin().setY(0);
        return bounds;
    }

    /**
     * Sets the bounds for this view in its own coordinate system as described
     * by the CGRect structure parameter.
     *
     * @param rect The CGRect parameter that defines the bounds for this view in
     *             its own coordinate system.
     */
    @CMSetter("@property(nonatomic) CGRect bounds;")
    public void setBounds(CGRect rect) {
        setFrame(new CGRect(frame.getOrigin().getX(), frame.getOrigin().getY(), rect.getSize().getWidth(), rect.getSize().getHeight()));
    }

    /**
     * Returns the center of this view.
     *
     * @return The center of this view.
     */
    @CMGetter("@property(nonatomic) CGPoint center;")
    public CGPoint center() {
        return new CGPoint((frame.getOrigin().getX() + frame.getSize().getWidth()) / 2, (frame.getOrigin().getY() + frame.getSize().getWidth()) / 2);
    }

    /**
     * Sets the center for this view.
     *
     * @param center The center for this view.
     */
    @CMSetter("@property(nonatomic) CGPoint center;")
    public void setCenter(CGPoint center) {
        setFrame(new CGRect(center.getX() - frame.getSize().getWidth() / 2, center.getY() - frame.getSize().getHeight() / 2, frame.getSize().getWidth(), frame.getSize().getHeight()));
    }

    /**
     * Set the location of this view.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    void setLocation(double x, double y) {
        setFrame(new CGRect(x, y, frame.getSize().getWidth(), frame.getSize().getHeight()));
    }

    /**
     * Sets the size for this view.
     *
     * @param width  The width of this view.
     * @param height The height of this view.
     */
    void setSize(double width, double height) {
        setFrame(new CGRect(frame.getOrigin().getX(), frame.getOrigin().getY(), width, height));
    }

    /**
     * We could not support transformations yet (how?) ; just try to calculate the offset from the root window
     */
    void locationRelativeToRoot(CGPoint res) {
        UIView superview = superview();
        /*
         * Don't take into account UIWindow and its child is a dirty hack to get rid of transformations
         * of the view below UIWindow. By definition this view should be aligned at top left.
         * This view has affine transformations that rotate and translate it, and on top of this it is translated
         * with frame() to put it into real location.
         *
         * Since native widgets don't support affine transformations (yet?), in most cases the native widgets
         * location could be estimated by not taking into account the UIWindow and its parent (UIViewController's)
         * view.
         *
         *  Maybe the whole method is too complex and it should be simplified now.
         */
        if (superview != null && !(superview instanceof UIWindow)) {
            res.setX(res.getX() + frame.getOrigin().getX());
            res.setY(res.getY() + frame.getOrigin().getY());
            superview.locationRelativeToRoot(res);
        }
    }

    /**
     * Moves the subview defined as parameter behind the other subviews of this
     * view.
     *
     * @param subView The subview that is be moved behind the other subviews.
     */
    @CMSelector("- (void)sendSubviewToBack:(UIView *)view;")
    public void sendSubviewToBack(UIView subView) {
        insertSubviewAt(subView, 0);
    }

    /**
     * Moves the subview defined as parameter in front of the other subviews of
     * this view.
     *
     * @param subView The subview that is moved in front of the other subviews.
     */
    @CMSelector("- (void)bringSubviewToFront:(UIView *)view;")
    public void bringSubviewToFront(final UIView subView) {
        insertSubviewAt(subView, -1);
    }

    /**
     * Add the subview defined as parameter at this view's list of subviews.
     *
     * @param subView The subview that is added at this view's list of subviews.
     *                This subview is displayed above the other subviews.
     */
    @CMSelector("- (void)addSubview:(UIView *)view;")
    public void addSubview(UIView subView) {
        insertSubviewAt(subView, -1);
    }

    /**
     * Inserts the specified subview in the specified position of this view's
     * list of subviews.The subview is displayed above the subviews that come
     * before it in the list and below the subviews that come afterward.
     *
     * @param subView The subview to be inserted in the list.
     * @param idx     The index in the list. Indexing from 0 to number of subviews.
     */
    @CMSelector("- (void)insertSubview:(UIView *)view \n"
            + "              atIndex:(NSInteger)index;")
    public void insertSubview(UIView subView, int idx) {
        if (idx < 0)
            throw new IndexOutOfBoundsException("Unable to add view with a negative index");
        insertSubviewAt(subView, idx);
    }

    private void insertSubviewAt(UIView subView, int idx) {
        if (subView == null || subView == this)
            return;
        DelegateViews dv = new DelegateViews(subView, subView.superview(), this, idx);
        if (pendingAnim == null || !pendingAnim.viewToEnter(dv)) {
            dv.delegateBefore();
            dv.doAdd();
            dv.delegateAfter();
        }
        setNeedsDisplay();
    }

    /**
     * Removes this view and its subviews from its superview.
     */
    @CMSelector("- (void)removeFromSuperview;")
    public void removeFromSuperview() {
        UIView oldParent = superview();
        if (oldParent == null)
            return;
        DelegateViews dv = new DelegateViews(this, oldParent, null, -1);
        if (pendingAnim == null || !pendingAnim.viewToLeave(dv)) {
            dv.delegateBefore();
            dv.doRemove();
            dv.delegateAfter();
        }
    }

    boolean isAttachedToWindow() {
        UIView current = this;
        UIWindow keyWindow = UIApplication.keyWindowIfExists();
        while (current != null && current != keyWindow)
            current = current.superview();
        return current == keyWindow;
    }

    void attachWidget(boolean isAttached) {
        if (widget != null) {
            Native.widget().setAttached(widget.getNativeWidget(), isAttached);
            if (isAttached)
                layoutNativeFromRoot();
        }
        if (!isAttached)
            resignFirstResponder();

        if (!children.isEmpty())
            for (UIView child : children)
                child.attachWidget(isAttached);
    }

    void willAddSubview(UIView subview) {
    }

    void didRemoveSubview(UIView subview) {
    }

    /**
     * Informs this view that a subview was added.
     *
     * @param subview The subview that was added to this view.
     */
    @CMSelector("- (void)didAddSubview:(UIView *)subview;")
    public void didAddSubview(UIView subview) {
    }

    /**
     * Informs this view that a subview will be removed.
     *
     * @param subview The subview that will be removed.
     */
    @CMSelector("- (void)willRemoveSubview:(UIView *)subview;")
    public void willRemoveSubview(UIView subview) {
    }

    /**
     * Informs this view that its superview will change to the one specified as
     * parameter.
     *
     * @param newSuperview The new superview of this view.
     */
    @CMSelector("- (void)willMoveToSuperview:(UIView *)newSuperview;")
    public void willMoveToSuperview(UIView newSuperview) {
    }

    /**
     * Informs this view that its superview changed.
     */
    @CMSelector("- (void)didMoveToSuperview;")
    public void didMoveToSuperview() {
    }

    /**
     * Informs this view that its window will change.
     *
     * @param newWindow The new window object of this view.Null parameter is
     *                  accepted.
     */
    @CMSelector("- (void)willMoveToWindow:(UIWindow *)newWindow;")
    public void willMoveToWindow(UIWindow newWindow) {
    }

    /**
     * Informs this view that its window changed.
     */
    @CMSelector("- (void)didMoveToWindow;")
    public void didMoveToWindow() {
    }

    /**
     * Returns a List with this view's direct descendant subviews in the
     * hierarchy.
     *
     * @return The List of the direct descendant subviews.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSArray<__kindof UIView *> *subviews;")
    public List<UIView> subviews() {
        return new ArrayList<>(children);
    }

    UIView subview(Iterable<Class<? extends UIView>> viewclasses) {
        Class<?> viewClass = getClass();
        for (Class<? extends UIView> cls : viewclasses)
            if (cls.isAssignableFrom(viewClass))
                return this;
        for (UIView view : children) {
            viewClass = view.getClass();
            for (Class<? extends UIView> cls : viewclasses)
                if (cls.isAssignableFrom(viewClass))
                    return view;
        }
        for (UIView view : children)
            if (view != null) {
                view = view.subview(viewclasses);
                if (view != null)
                    return view;
            }
        return null;
    }

    /**
     * Retuns the superview of this view.Null if it has no superview.
     *
     * @return The superview of this view.Null if it has none.
     */
    @CMGetter("@property(nonatomic, readonly) UIView *superview;")
    public UIView superview() {
        return parentRef == null ? null : parentRef.get();
    }

    /**
     * Returns a Boolean that shows whether this view accepts multi-touch
     * events.
     *
     * @return A Boolean that shows whether this view accepts multi-touch
     * events.
     */
    @CMGetter("@property(nonatomic, getter=isMultipleTouchEnabled) BOOL multipleTouchEnabled;")
    public boolean isMultipleTouchEnabled() {
        return multipleTouchEnabled;
    }

    /**
     * Set a Boolean that defines whether this view accepts multi-touch events.
     *
     * @param multipleTouchEnabled A Boolean that defines whether this view
     *                             accepts multi-touch events.
     */
    @CMSetter("@property(nonatomic, getter=isMultipleTouchEnabled) BOOL multipleTouchEnabled;")
    public void setMultipleTouchEnabled(boolean multipleTouchEnabled) {
        this.multipleTouchEnabled = multipleTouchEnabled;
    }

    /**
     * Returns this view's window.
     *
     * @return The window of this view. Null if it has none.
     */
    @CMGetter("@property(nonatomic, readonly) UIWindow *window;")
    public UIWindow window() {
        UIView over = this;
        while ((over = over.superview()) != null)
            if (over instanceof UIWindow)
                return (UIWindow) over;
        return null;
    }

    /**
     * Sets an integer used as an id of this view.
     *
     * @param tag An integer used as id of the view.
     */
    @CMSetter("@property(nonatomic) NSInteger tag;")
    public void setTag(int tag) {
        this.tag = tag;
    }

    /**
     * Returns the id of this view.
     *
     * @return The id of this view.
     */
    @CMGetter("@property(nonatomic) NSInteger tag;")
    public int tag() {
        return tag;
    }

    /**
     * Marks this view to be redrawn on the next even cycle.
     */
    @CMSelector("- (void)setNeedsDisplay;")
    public void setNeedsDisplay() {
        Native.lifecycle().runLaterOnceOnEventThread(refreshDisplay);
    }

    /**
     * Set this view's background color.
     *
     * @param background The view’s background color.
     */
    @UIAppearanceSelector
    @CMSetter("@property(nonatomic, copy) UIColor *backgroundColor;")
    public void setBackgroundColor(UIColor background) {
        if (BaseUtils.equals(this.background, background))
            return;
        if (pendingAnim != null) {
            if (background != null)
                pendingAnim.setBackground(this, color(background.cgcolor));
        } else {
            setBackgroundColorImpl(background);
            setNeedsDisplay();
        }
    }

    void setBackgroundColorImpl(UIColor background) {
        this.background = background;
    }

    /**
     * Returns this view's background color.
     *
     * @return The view’s background color.
     */
    @CMGetter("@property(nonatomic, copy) UIColor *backgroundColor;")
    public UIColor backgroundColor() {
        return background;
    }

    /**
     * Sets the tint color of this view as defined by the specified parameter.
     *
     * @param tintColor The new tint color of this view.
     * @see crossmobile.ios.uikit.UIColor
     */
    @CMSetter("@property(nonatomic, strong) UIColor *tintColor;")
    public void setTintColor(UIColor tintColor) {
        this.tintColor = tintColor;
        tintColorDidChange();
        setNeedsDisplay();
    }

    /**
     * Returns the non-default tint color value of the short distant view in the
     * view hierarchy.
     *
     * @return The non-default tint color value of the short distant view in the
     * view hierarchy.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *tintColor;")
    public UIColor tintColor() {
        if (tintColor != null)
            return tintColor;
        UIView parent = superview();
        return parent == null ? Theme.Color.TINT : parent.tintColor();
    }

    @CMSelector("- (void)tintColorDidChange;")
    public void tintColorDidChange() {
        for (UIView child : children)
            child.tintColorDidChange();
    }

    /**
     * Sets the tint-adjustment mode value of this view as defined by the
     * specified parameter.
     *
     * @param UIViewTintAdjustmentMode The new tint-adjustment mode value of
     *                                 this view.
     * @see crossmobile.ios.uikit.UIViewTintAdjustmentMode
     */
    @CMSetter("@property(nonatomic) UIViewTintAdjustmentMode tintAdjustmentMode;")
    public void setTintAdjustmentMode(int UIViewTintAdjustmentMode) {
        this.tintAdjustmentMode = UIViewTintAdjustmentMode;
        for (UIView child : children)
            child.setTintAdjustmentMode(UIViewTintAdjustmentMode);
    }

    /**
     * Returns the non-default tint adjustment mode value of the short distant
     * view in the view hierarchy.
     *
     * @return The non-default tint adjustment mode value of the short distant
     * view in the view hierarchy.
     */
    @CMGetter("@property(nonatomic) UIViewTintAdjustmentMode tintAdjustmentMode;")
    public int tintAdjustmentMode() {
        return tintAdjustmentMode;
    }

    /**
     * Override the user style, whether be light or dark. This could be applied to the
     * UIWindow view of the application to affect the whole application.
     *
     * @param UIUserInterfaceStyle the new user interface style
     */
    @CMSetter(value = "@property(nonatomic) UIUserInterfaceStyle overrideUserInterfaceStyle;", sinceIos = "13.0")
    public void setOverrideUserInterfaceStyle(int UIUserInterfaceStyle) {
        this.overrideUserInterfaceStyle = UIUserInterfaceStyle;
    }

    /**
     * Retrieve the current user interface style. If it is unspecified, it inherits from
     * the parent UIView
     *
     * @return the current user interface style
     */
    @CMGetter(value = "@property(nonatomic) UIUserInterfaceStyle overrideUserInterfaceStyle;", sinceIos = "13.0")
    public int overrideUserInterfaceStyle() {
        return overrideUserInterfaceStyle;
    }

    /**
     * Returns the transform applied to this view relative to the center of its
     * bounds.
     *
     * @return The transform applied to this view relative to the center of its
     * bounds.
     */
    @CMGetter("@property(nonatomic) CGAffineTransform transform;")
    public CGAffineTransform transform() {
        return transform == null ? CGAffineTransform.identity() : Geometry.copy(transform);
    }

    /**
     * Sets the transform that will be applied to this view relative to the
     * center of its bounds.
     *
     * @param transform The transform that will be applied to this view relative
     *                  to the center of its bounds.
     */
    @CMSetter("@property(nonatomic) CGAffineTransform transform;")
    public void setTransform(CGAffineTransform transform) {
        if (transform != null && transform.isIdentity())
            transform = null;
        if (pendingAnim != null)
            pendingAnim.setTransformation(this, transform);
        else {
            setTransformImpl(transform);
            setNeedsDisplay();
        }
    }

    synchronized void setTransformImpl(CGAffineTransform transform) {
        nativeDrawingTransf = null;
        fullTransform = inverseTransform = null;
        this.transform = transform == null ? null : (this.transform == null ? Geometry.copy(transform) : Geometry.set(this.transform, transform));
    }

    private Object nativeTransformation() {
        if (transform == null)
            return null;
        if (nativeDrawingTransf == null)
            nativeDrawingTransfCache = nativeDrawingTransf = Native.graphics().targetToNative(fullTransformation(), nativeDrawingTransfCache);
        return nativeDrawingTransf;
    }

    private CGAffineTransform fullTransformation() {
        if (transform == null)
            return null;
        if (fullTransform == null) {
            double anchorX, anchorY;
            if (layer != null && layer.anchorPoint() != null) {
                anchorX = layer.anchorPoint().getX();
                anchorY = layer.anchorPoint().getY();
            } else {
                anchorX = 0.5;
                anchorY = 0.5;
            }
            double dx = frame.getSize().getWidth() * anchorX;
            double dy = frame.getSize().getHeight() * anchorY;
            fullTransform = translateConcatTranslate(CGAffineTransform.identity(), dx, dy, transform, -dx, -dy);
        }
        return fullTransform;
    }

    CGAffineTransform inverseTransform() {
        if (transform == null)
            return null;
        if (inverseTransform == null)
            inverseTransform = fullTransformation().invert();
        return inverseTransform;
    }

    /**
     * Returns this view’s alpha value.
     *
     * @return The view’s alpha value.
     */
    @CMGetter("@property(nonatomic) CGFloat alpha;")
    public double alpha() {
        return alpha;
    }

    /**
     * Sets this view’s alpha value.
     *
     * @param alpha The view’s alpha value.
     */
    @CMSetter("@property(nonatomic) CGFloat alpha;")
    public void setAlpha(double alpha) {
        if (this.alpha == alpha)
            return;

        if (alpha > 1)
            alpha = 1;
        if (alpha < 0)
            alpha = 0;
        if (pendingAnim != null)
            pendingAnim.setAlpha(this, alpha);
        else {
            this.alpha = alpha;
            setNeedsDisplay();
        }
    }

    /**
     * Returns a Boolean value that shows if the view is opaque or not.
     *
     * @return A Boolean value that shows if the view is opaque or not.
     */
    @CMGetter("@property(nonatomic, getter=isOpaque) BOOL opaque;")
    public boolean isOpaque() {
        return opaque;
    }

    /**
     * A Boolean value that determines whether the view is opaque. Sets a
     * Boolean value that defines whether the view will be opaque or not.
     *
     * @param opaque A Boolean value that defines whether the view will be
     *               opaque or not.
     */
    @CMSetter("@property(nonatomic, getter=isOpaque) BOOL opaque;")
    public void setOpaque(boolean opaque) {
        if (this.opaque == opaque)
            return;
        this.opaque = opaque;
        Native.graphics().refreshDisplay();
    }

    /**
     * Sets a Boolean value that defines whether the limits of this view will be
     * cleared before a new drawing.
     *
     * @param clearcontext A Boolean value that defines whether the limits of
     *                     this view will be cleared before a new drawing.
     */
    @CMSetter("@property(nonatomic) BOOL clearsContextBeforeDrawing;")
    public void setClearsContextBeforeDrawing(boolean clearcontext) {
        if (this.clearcontext == clearcontext)
            return;
        this.clearcontext = clearcontext;
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns a Boolean value that shows whether this view is hidden or not.
     *
     * @return A boolean value that shows whether this view is hidden or not.
     */
    @CMGetter("@property(nonatomic, getter=isHidden) BOOL hidden;")
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Sets a Boolean value that defines whether this view is hidden or not.
     *
     * @param hidden A Boolean value that defines whether this view is hidden or
     *               not.
     */
    @CMSetter("@property(nonatomic, getter=isHidden) BOOL hidden;")
    public void setHidden(boolean hidden) {
        if (this.hidden == hidden)
            return;
        this.hidden = hidden;
        attachWidget(!hidden);
        if (!hidden)
            updateNativeUserInteraction();
        Native.graphics().refreshDisplay();
    }

    /**
     * Sets an integer that defines how this view adjusts its content on a size
     * change.
     *
     * @param UIViewContentMode An integer that defines how this view adjusts
     *                          its content on a size change.
     */
    @CMSetter("@property(nonatomic) UIViewContentMode contentMode;")
    public void setContentMode(int UIViewContentMode) {
        if (this.contentMode != UIViewContentMode) {
            contentMode = UIViewContentMode;
            Native.graphics().refreshDisplay();
        }
    }

    /**
     * Returns an integer that shows how this view adjusts its content on a size
     * change.
     *
     * @return An integer that shows how this view adjusts its content on a size
     * change.
     */
    @CMGetter("@property(nonatomic) UIViewContentMode contentMode;")
    public int contentMode() {
        return contentMode;
    }

    private void updateNativeUserInteraction() {
        updateNativeUserInteractionImpl(true);
    }

    private void updateNativeUserInteractionImpl(boolean inheritedStatus) {
        inheritedStatus &= userInteraction;
        if (widget != null)
            widget.setUserInteraction(inheritedStatus);
        for (UIView child : children)
            child.updateNativeUserInteractionImpl(inheritedStatus);
    }

    /*
     * View animations with block methods
     */

    /**
     * Returns a Boolean that shows whether events triggered by user interaction
     * are ignored.
     *
     * @return A Boolean that shows whether events triggered by user interaction
     * are ignored.
     */
    @CMGetter("@property(nonatomic, getter=isUserInteractionEnabled) BOOL userInteractionEnabled;")
    public boolean isUserInteractionEnabled() {
        return userInteraction;
    }

    /**
     * Sets a Boolean that defines whether events triggered by user interaction
     * are ignored.
     *
     * @param userInteraction A Boolean that defines whether events triggered by
     *                        user interaction are ignored.
     */
    @CMSetter("@property(nonatomic, getter=isUserInteractionEnabled) BOOL userInteractionEnabled;")
    public void setUserInteractionEnabled(boolean userInteraction) {
        this.userInteraction = userInteraction;
        updateNativeUserInteraction();
    }

    /**
     * Returns a Boolean that shows whether the subviews of this view are
     * restricted within the view's boundaries.
     *
     * @param clipsToBounds A Boolean that shows whether the subviews of this
     *                      view are restricted within the view's boundaries.
     */
    @CMSetter("@property(nonatomic) BOOL clipsToBounds;")
    public void setClipsToBounds(boolean clipsToBounds) {
        this.clipsToBounds = clipsToBounds;
        Native.graphics().refreshDisplay();
    }

    /*
     * View animations with static methods
     */

    /**
     * A Boolean value that determines whether subviews are confined to the
     * bounds of the view. Returns a Boolean
     *
     * @return A Boolean value that determines whether subviews are confined to
     * the bounds of the view.
     */
    @CMGetter("@property(nonatomic) BOOL clipsToBounds;")
    public boolean clipsToBounds() {
        return clipsToBounds;
    }

    /**
     * Return the view that contains the point parameter and is remotest one in
     * the view hierarchy tree. This method is triggered by the specified event
     * parameter.
     *
     * @param point The point for which the test takes place.
     * @param event The event that triggers this method call.
     * @return The remotest view of hierarchy that contains the point.
     */
    @CMSelector("- (UIView *)hitTest:(CGPoint)point \n"
            + "          withEvent:(UIEvent *)event;")
    public UIView hitTest(CGPoint point, UIEvent event) {
        if (userInteraction && !hidden && alpha >= 0.1 && pointInside(point, event)) {
            UIView view;
            // Highest layer & highest Z-order, if required
            for (int i = children.size() - 1; i >= 0; i--) {
                view = children.get(i);
                view = view.hitTest(view.selfPointTransformations(Geometry.copy(point), true), event);
                if (view != null)
                    return firstAncestorThatUsesTouches(view);
            }
            if (event instanceof cmPrivateEvent) {
                if (((cmPrivateEvent) event).isHitAllowed(this))
                    return this;
            } else
                return this;
        }
        return null;
    }

    UIView firstAncestorThatUsesTouches(UIView view) {
        if (view != null) {
            for (boolean usesTouch : view.usesTouches)
                if (usesTouch)
                    return view;
            return firstAncestorThatUsesTouches(view.superview());
        }
        return null;
    }

    /**
     * Returns a Boolean value that shows whether the point parameter is in the
     * coordinate system of this view.This method is triggered by the specified
     * event parameter.
     *
     * @param point The point that is checked.
     * @param event The event that triggered this method call.
     * @return A Boolean value that shows whether this point belongs to this
     * view's coordinate system.
     */
    @SuppressWarnings("unused")
    @CMSelector("- (BOOL)pointInside:(CGPoint)point \n"
            + "          withEvent:(UIEvent *)event;")
    public boolean pointInside(CGPoint point, UIEvent event) {
        return !(point.getX() < 0 || point.getY() < 0 || point.getX() > frame.getSize().getWidth() - 1 || point.getY() > frame.getSize().getHeight() - 1);
    }

    /**
     * Returns the parameter point converted from this view's coordinate system
     * to the coordinate system of the parameter.
     *
     * @param point The point expressed in the coordinate system of this view.
     * @param view  The point to whose coordinate system the conversion will take
     *              place.
     * @return The final converted point.
     */
    @CMSelector("- (CGPoint)convertPoint:(CGPoint)point \n"
            + "                 toView:(UIView *)view;")
    public CGPoint convertPointToView(CGPoint point, UIView view) {
        return convertPoint(point, this, view);
    }

    /**
     * Returns the point parameter converted from the coordinate system of the
     * view parameter to this view's coordinate system.
     *
     * @param point The point expressed in the coordinate system of the view
     *              parameter.
     * @param view  The point to whose coordinate system the rectangle is
     *              expressed. If NULL then window's base coordinates are used.
     * @return The final converted point.
     */
    @CMSelector("- (CGPoint)convertPoint:(CGPoint)point \n"
            + "               fromView:(UIView *)view;")
    public CGPoint convertPointFromView(CGPoint point, UIView view) {
        return convertPoint(point, view, this);
    }

    final CGPoint selfPointTransformations(CGPoint p, boolean isInverse) {
        if (isInverse) {
            p.setX(p.getX() - frame.getOrigin().getX());
            p.setY(p.getY() - frame.getOrigin().getY());
            if (layer != null && layer.anchorPoint() != null) {
                p.setX(p.getX() - (frame.getSize().getWidth() * (0.5 - layer.anchorPoint().getX())));
                p.setY(p.getY() - (frame.getSize().getHeight() * (0.5 - layer.anchorPoint().getY())));
            }

            if (transform != null)
                Geometry.apply(inverseTransform(), p);
            UIView parent = superview();
            if (parent != null)
                parent.parentPointTransformations(p, isInverse);
        } else {
            UIView parent = superview();
            if (parent != null)
                parent.parentPointTransformations(p, isInverse);
            p.setX(p.getX() + frame.getOrigin().getX());
            p.setY(p.getY() + frame.getOrigin().getY());
            if (layer != null && layer.anchorPoint() != null) {
                p.setX(p.getX() + frame.getSize().getWidth() * (0.5 - layer.anchorPoint().getX()));
                p.setY(p.getY() + frame.getSize().getHeight() * (0.5 - layer.anchorPoint().getY()));
            }

            if (transform != null)
                Geometry.apply(fullTransformation(), p);
        }
        return p;
    }

    void parentPointTransformations(CGPoint point, boolean isInverse) {
    }

    /**
     * Returns the parameter rectangle converted from this view's coordinate
     * system to the coordinate system of the parameter.
     *
     * @param rect The rectangle expressed in the coordinate system of this
     *             view.
     * @param view The view to whose coordinate system the conversion will take
     *             place.
     * @return The final converted rectangle.
     */
    @SuppressWarnings("unused")
    @CMSelector("- (CGRect)convertRect:(CGRect)rect \n"
            + "               toView:(UIView *)view;")
    public CGRect convertRectToView(CGRect rect, UIView view) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the parameter rectangle converted from the parameter's view
     * coordinate system to this view coordinate system.
     *
     * @param rect The rectangle expressed in the coordinate system of the view
     *             parameter.
     * @param view The view to whose coordinate system the rectangle is
     *             expressed. If NULL then window's base coordinates are used.
     * @return The final converted rectangle.
     */
    @SuppressWarnings("unused")
    @CMSelector("- (CGRect)convertRect:(CGRect)rect \n"
            + "             fromView:(UIView *)view;")
    public CGRect convertRectFromView(CGRect rect, UIView view) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Connects a list of gesture recognizers to this view.
     *
     * @param gestureRecognizers The list of gesture recognizers that will be
     *                           connected to this view.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<__kindof UIGestureRecognizer *> *gestureRecognizers;")
    public void setGestureRecognizers(List<UIGestureRecognizer> gestureRecognizers) {
        this.gestures = gestureRecognizers;
    }

    /**
     * Returns a list with the gesture recognizer objects that are connected to
     * this view.
     *
     * @return The list of the gesture recognizer objects
     * @see crossmobile.ios.uikit.UIGestureRecognizer
     */
    @CMGetter("@property(nonatomic, copy) NSArray<__kindof UIGestureRecognizer *> *gestureRecognizers;")
    public List<UIGestureRecognizer> gestureRecognizers() {
        return gestures == null ? null : new ArrayList<>(gestures);
    }

    /**
     * Connects a gesture recognizer to this view.
     *
     * @param gesture The gesture recognizer that will be connected.
     * @see crossmobile.ios.uikit.UIGestureRecognizer
     */
    @CMSelector("- (void)addGestureRecognizer:(UIGestureRecognizer *)gestureRecognizer;")
    public void addGestureRecognizer(UIGestureRecognizer gesture) {
        if (gesture != null) {
            UIView oldView = gesture.view();
            if (gestures == null)
                gestures = new ArrayList<>();

            if (oldView != this) {
                if (oldView != null)
                    oldView.removeGestureRecognizer(gesture);
                gesture.setView(this);
                gestures.add(gesture);
            }
        }
    }

    /**
     * Disconnects a gesture recognizer from this view.
     *
     * @param gesture The gesture recognizer that will be disconnected.
     * @see crossmobile.ios.uikit.UIGestureRecognizer
     */
    @CMSelector("- (void)removeGestureRecognizer:(UIGestureRecognizer *)gestureRecognizer;")
    public void removeGestureRecognizer(UIGestureRecognizer gesture) {
        if (gesture != null && gestures != null) {
            int where = gestures.indexOf(gesture);
            if (where >= 0) {
                gestures.remove(where);
                gesture.setView(null);
            }
        }
    }

    String parentList() {
        UIView sview = superview();
        return sview == null ? "Orphan" : selfAndParentList();
    }

    String selfAndParentList() {
        String self = SystemUtilities.getClassName(getClass());
        UIView sview = superview();
        return sview == null ? "/" + self : sview.selfAndParentList() + "/" + self;
    }

    /**
     * Returns a size for this view that fits the specified size in an optimal
     * way.
     *
     * @param size The size for which the view should calculate its
     *             optimal-fitting size.
     * @return A new size that fits the receiver’s subviews.
     */
    @CMSelector("- (CGSize)sizeThatFits:(CGSize)size;")
    public CGSize sizeThatFits(CGSize size) {
        return Geometry.copy(intrinsicContentSize);
    }

    /**
     * Changes view's size and reloates it in order to encircle all its
     * subviews.
     */
    @CMSelector("- (void)sizeToFit;")
    public void sizeToFit() {
    }

    final void drawingSelf(CGContext cx) {
        if (!shouldBeDrawn())
            return;
        GraphicsContext<?> gcx = context(cx);

        // update viewport
        CGRect vFrame = new CGRect(0, 0, frame.getSize().getWidth(), frame.getSize().getHeight());

        if (clipsToBounds)
            cx.clipToRect(vFrame);
        if (layer != null && layer.mask() != null) {
            CALayer mask = layer.mask();
            if (mask instanceof CAShapeLayer) {
                CGPath path = ((CAShapeLayer) mask).path();
                if (path != null)
                    gcx.clip(GraphicsDrill.path(path));
            }
        }

        if (clearcontext && !opaque) {
            gcx.setFillColorWithColor(0xFF000000);
            cx.fillRect(vFrame);
        }

        if (background != null && color(background.cgcolor) != 0) {
            cx.setFillColorWithColor(background.cgcolor);
            cx.fillRect(vFrame);
        }

        drawRect(vFrame);
        if (ENABLE_DEBUG || shouldDrawOnTop())
            // to be sure that subclasses of this method didn't change the metrics
            Geometry.set(vFrame, 0d, 0d, frame.getSize().getWidth(), frame.getSize().getHeight());
        if (ENABLE_DEBUG)
            if ((Live_Graphics_Debug || debugSelf) && !shouldDrawOnTop())
                debugGraphicsFrame(cx, vFrame);

        DrawingDepth++;
        // probably create a matrix of some sort and store it, so that prepareToDraw could be executed only once?
        drawingChildren(cx);
        DrawingDepth--;

        if (shouldDrawOnTop()) {
            cx.setAlpha(parentAlpha * alpha);
            drawOnTop(cx, vFrame);
            if (ENABLE_DEBUG)
                if (Live_Graphics_Debug || debugSelf)
                    debugGraphicsFrame(cx, vFrame);
        }
    }

    @SuppressWarnings("unused") // used by Xray
    private void setDebugSelf(boolean status) {
        this.debugSelf = status;
        NSTimer.scheduledTimerWithTimeInterval(1, timer -> {
            debugSelf = false;
            setNeedsDisplay();
        }, null, false);
        setNeedsDisplay();
    }

    private void debugGraphicsFrame(CGContext cx, CGRect givenViewport) {
        CGColor body = null, border = null;
        if (layer != null && layer.style() != null) {
            body = (CGColor) layer.style().get(Theme.Debug.StyleTags.FILL_COLOR_TAG);
            border = (CGColor) layer.style().get(Theme.Debug.StyleTags.STRIKE_COLOR_TAG);
        }
        boolean isWindow = this instanceof UIWindow;
        GraphicsContext<?> gcx = context(cx);
        gcx.setLineWidth(1);
        gcx.setFillColorWithColor(color(body == null ? (isWindow ? Theme.Debug.WINDOW_FILL_COLOR.cgcolor : Theme.Debug.FILL_COLOR.cgcolor) : body));
        cx.fillRect(givenViewport);
        gcx.setDrawColorWithColor(color(border == null ? (isWindow ? Theme.Debug.WINDOW_STRIKE_COLOR.cgcolor : Theme.Debug.STRIKE_COLOR.cgcolor) : border));
        cx.strokeRect(givenViewport);
    }

    void drawingChildren(CGContext cx) {
        try {
            for (UIView child : children)
                drawingChild(cx, child, true);
        } catch (ConcurrentModificationException ex) {
            Native.system().error("Concurrent view hierarchy modification", null);
            Native.graphics().refreshDisplay();
        }
    }

    @SuppressWarnings("rawtypes")
    final void drawingChild(CGContext cx, UIView child, boolean setAlpha) {
        GraphicsContext gcx = context(cx);
        if (child.shouldBeDrawn()) {    // double check here to save the "save/restore" of context
            cx.saveGState();
            if (child.layer != null && child.layer.anchorPoint() != null)
                gcx.translate(child.frame.getSize().getWidth() * (0.5 - child.layer.anchorPoint().getX()) + child.frame.getOrigin().getX(),
                        child.frame.getSize().getHeight() * (0.5 - child.layer.anchorPoint().getY()) + child.frame.getOrigin().getY());
            else
                gcx.translate(child.frame.getOrigin().getX(), child.frame.getOrigin().getY());

            if (child.transform != null)
                gcx.concatCTM(child.nativeTransformation());
            if (setAlpha) {
                child.parentAlpha = parentAlpha * alpha;
                cx.setAlpha(child.parentAlpha * child.alpha);
            }
            child.drawingSelf(cx);
            cx.restoreGState();
        }
    }

    /**
     * This method is implicitly called when a view is first displayed or when
     * an event occurs that invalidates a visible part of the view and the view
     * needs to be redrawn.
     *
     * @param rect The part of the view that need to be redrawn.
     */
    @CMSelector("- (void)drawRect:(CGRect)rect;")
    public void drawRect(CGRect rect) {
    }

    private boolean shouldBeDrawn() {
        return !hidden && alpha > 0.01;
    }

    boolean shouldDrawOnTop() {
        return false;
    }

    CGRect contentModeRect(CGRect rect) {
        CGSize has = rect.getSize();
        CGSize wants = sizeThatFits(has);
        CGRect result = CGRect.zero();

        switch (contentMode) {
            case ScaleToFill:
                result.getOrigin().setX(0);
                result.getOrigin().setY(0);
                Geometry.set(result.getSize(), has);
                break;
            case ScaleAspectFit:
            case ScaleAspectFill:
                double hasAspect = has.getWidth() / has.getHeight();
                double wantsAspect = wants.getWidth() / wants.getHeight();
                double scale = hasAspect > wantsAspect
                        ? (contentMode == ScaleAspectFill ? has.getWidth() / wants.getWidth() : has.getHeight() / wants.getHeight()) // width is bigger than required
                        : (contentMode == ScaleAspectFill ? has.getHeight() / wants.getHeight() : has.getWidth() / wants.getWidth()); // height is bigger than required
                result.getSize().setWidth(wants.getWidth() * scale);
                result.getSize().setHeight(wants.getHeight() * scale);
                result.getOrigin().setX((has.getWidth() - result.getSize().getWidth()) / 2);
                result.getOrigin().setY((has.getHeight() - result.getSize().getHeight()) / 2);
                break;
            case Top:
                result.getOrigin().setX((has.getWidth() - wants.getWidth()) / 2);
                result.getOrigin().setY(0);
                Geometry.set(result.getSize(), wants);
                break;
            case Bottom:
                result.getOrigin().setX((has.getWidth() - wants.getWidth()) / 2);
                result.getOrigin().setY(has.getHeight() - wants.getHeight());
                Geometry.set(result.getSize(), wants);
                break;
            case Left:
                result.getOrigin().setX(0);
                result.getOrigin().setY((has.getHeight() - wants.getHeight()) / 2);
                Geometry.set(result.getSize(), wants);
                break;
            case Right:
                result.getOrigin().setX(has.getWidth() - wants.getWidth());
                result.getOrigin().setY((has.getHeight() - wants.getHeight()) / 2);
                Geometry.set(result.getSize(), wants);
                break;
            case TopLeft:
                result.getOrigin().setX(0);
                result.getOrigin().setY(0);
                Geometry.set(result.getSize(), wants);
                break;
            case TopRight:
                result.getOrigin().setX(has.getWidth() - wants.getWidth());
                result.getOrigin().setY(0);
                Geometry.set(result.getSize(), wants);
                break;
            case BottomLeft:
                result.getOrigin().setX(0);
                result.getOrigin().setY(has.getHeight() - wants.getHeight());
                Geometry.set(result.getSize(), wants);
                break;
            case BottomRight:
                result.getOrigin().setX(has.getWidth() - wants.getWidth());
                result.getOrigin().setY(has.getHeight() - wants.getHeight());
                Geometry.set(result.getSize(), wants);
                break;
            case Center:
            default:
                result.getOrigin().setY((has.getHeight() - wants.getHeight()) / 2);
                result.getOrigin().setX((has.getWidth() - wants.getWidth()) / 2);
                Geometry.set(result.getSize(), wants);
        }
        if (this instanceof UILabel)
            System.out.println(has + " -> " + result);
        return result;
    }

    /*
     * Use it to draw items above the children, i.e. scrollbars
     */
    void drawOnTop(CGContext cx, CGRect rect) {
    }

    /**
     * Returns the Core Animation layer of this view that is used for rendering.
     *
     * @return the Core Animation layer of this view that is used for
     * rendering.Not null.
     */
    @CMGetter("@property(nonatomic, readonly, strong) CALayer *layer;")
    public CALayer layer() {
        if (layer == null) {
            layer = new CALayer();
            layer.setDelegate(this);
        }
        return layer;
    }

    /**
     * Returns a list with the layout constraints of this view.
     *
     * @return A list with the layout constraints of this view.
     * @see crossmobile.ios.uikit.NSLayoutConstraint
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<__kindof NSLayoutConstraint *> *constraints;")
    public List<NSLayoutConstraint> constraints() {
        return constraints;
    }

    /**
     * Adds the specified constraint to this view.
     *
     * @param constraint The constraint to be added to the view.
     */
    @CMSelector("- (void)addConstraint:(NSLayoutConstraint *)constraint;")
    public void addConstraint(NSLayoutConstraint constraint) {
        if (constraint == null)
            return;
        if (constraint.firstItem() != this && checkConstraintItem(constraint.firstItem()) && (constraint.secondItem() != null && (constraint.secondItem() != this || checkConstraintItem(constraint.secondItem())))) {
            System.out.println("Only constraints with relations to this view and its children may be added. \nThis error may occur if your view hierarchy has not yet been initialized.");
            return;
        }
        if (constraints.contains(constraint))
            return;
        initItemsIfNeeded(constraint);
        constraints.add(constraint);
        constraint.addToSolver(solver());
        needsUpdateConstraints = true;
    }

    private boolean checkConstraintItem(Object item) {
        if (item instanceof UIView)
            return !isAncestor((UIView) item);
        else if (item instanceof UILayoutGuide)
            return ((UILayoutGuide) item).owningView() != this;
        else if (item instanceof UIViewController.LayoutSupport)
            return ((UIViewController.LayoutSupport) item).owningView() != this;
        return false;
    }

    private boolean isAncestor(UIView view) {
        if (view == null)
            return false;
        if (view.superview() == this)
            return true;
        return isAncestor(view.superview());
    }

    void initItemsIfNeeded(NSLayoutConstraint constraint) {
        solver();   // initialize self solver
        if (constraint.firstItem() instanceof UIView) ((UIView) constraint.firstItem()).solver();
        if (constraint.secondItem() != null && constraint.secondItem() instanceof UIView)
            ((UIView) constraint.secondItem()).solver();
    }

    /**
     * Adds the specified list of constraints to this view.
     *
     * @param constraints The list of constraints to be added to the view.
     */
    @CMSelector("- (void)addConstraints:(NSArray<__kindof NSLayoutConstraint *> *)constraints;")
    public void addConstraints(List<NSLayoutConstraint> constraints) {
        for (NSLayoutConstraint constraint : constraints)
            addConstraint(constraint);
    }

    /**
     * Removes the specified constraint from this view.
     *
     * @param constraint The constraint to be removed from this view.
     */
    @CMSelector("- (void)removeConstraint:(NSLayoutConstraint *)constraint;")
    public void removeConstraint(NSLayoutConstraint constraint) {
        if (solver != null)
            constraint.removeFromSolver(solver);
        if (constraint.secondItem() == null && constraint.firstItem() == this) {
            UIView parent = superview();
            if (parent != null && parent.solver != null)
                constraint.removeFromSolver(parent.solver);
        }
        constraints.remove(constraint);
        needsUpdateConstraints = true;
    }

    /**
     * Removes the specified list of constraints from this view.
     *
     * @param constraints The list of constraints to be removed from this view.
     */
    @CMSelector("- (void)removeConstraints:(NSArray<__kindof NSLayoutConstraint *> *)constraints;")
    public void removeConstraints(List<NSLayoutConstraint> constraints) {
        for (NSLayoutConstraint constraint : constraints)
            removeConstraint(constraint);
    }

    /**
     * Returns a value that shows whether this view's autoresizing mask is
     * interpreted in Auto Layout.
     *
     * @return A Boolean value that shows whether this view's autoresizing mask
     * is interpreted in Auto Layout.
     */
    @CMGetter("@property(nonatomic) BOOL translatesAutoresizingMaskIntoConstraints;")
    public boolean translatesAutoresizingMaskIntoConstraints() {
        return translatesAutoresizingMaskIntoConstraints;
    }

    /**
     * Sets a Boolean value that defines whether this view's autoresizing mask
     * is interpreted in Auto Layout.
     *
     * @param translatesAutoresizingMaskIntoConstraints A Boolean value that
     *                                                  defines whether this view's autoresizing mask is interpreted in Auto
     *                                                  Layout.
     */
    @CMSetter("@property(nonatomic) BOOL translatesAutoresizingMaskIntoConstraints;")
    public void setTranslatesAutoresizingMaskIntoConstraints(boolean translatesAutoresizingMaskIntoConstraints) {
        this.translatesAutoresizingMaskIntoConstraints = translatesAutoresizingMaskIntoConstraints;
    }

    /**
     * Returns the natural size of this view.
     *
     * @return The natural size of this view.
     */
    @CMSelector("- (CGSize)intrinsicContentSize;")
    public CGSize intrinsicContentSize() {
        return new CGSize(intrinsicContentSize.getWidth(), intrinsicContentSize.getHeight());
    }

    void setIntrinsicContentSize(double width, double height) {
        intrinsicContentSize.setWidth(width);
        intrinsicContentSize.setHeight(height);
        updateIntrinsicConstraints(true);
    }

    /**
     * Invalidates the intrinsic size of the content.
     */
    @CMSelector("- (void)invalidateIntrinsicContentSize;")
    public void invalidateIntrinsicContentSize() {

    }

    /**
     * Returns the priority with which the content of the view resists to
     * enlarged concerning an axis.
     *
     * @param UILayoutConstraintAxis The axis for which the priority is set.
     * @return The priority with which the content of the view resists to
     * enlarged concerning an axis.
     * @see crossmobile.ios.uikit.UILayoutConstraintAxis
     */
    @CMSelector("- (UILayoutPriority)contentCompressionResistancePriorityForAxis:(UILayoutConstraintAxis)axis;")
    public float contentCompressionResistancePriorityForAxis(int UILayoutConstraintAxis) {
        if (UILayoutConstraintAxis == 0)
            return horizontalCompressionResistancePriority;
        else if (UILayoutConstraintAxis == 1)
            return verticalCompressionResistancePriority;
        return 0;
    }

    /**
     * Sets the priority with which the view resists to shrinking concerning the
     * specified axis.
     *
     * @param UILayoutConstraintAxis The axis for which the priority is set.
     * @param UILayoutPriority       The priority with which the view resists to
     *                               shrinking concerning the specified axis.
     * @see crossmobile.ios.uikit.UILayoutConstraintAxis
     * @see crossmobile.ios.uikit.UILayoutPriority
     */
    @CMSelector("- (void)setContentCompressionResistancePriority:(UILayoutPriority)priority \n"
            + "                                        forAxis:(UILayoutConstraintAxis)axis;")
    public void setContentCompressionResistancePriority(float UILayoutPriority, int UILayoutConstraintAxis) {
        if (UILayoutConstraintAxis == 0)
            horizontalCompressionResistancePriority = UILayoutPriority;
        else if (UILayoutConstraintAxis == 1)
            verticalCompressionResistancePriority = UILayoutPriority;
    }

    /**
     * Returns the priority with which the content of the view resists to
     * shrinking concerning the specified axis.
     *
     * @param UILayoutConstraintAxis The axis for which the priority is
     *                               returned.
     * @return The priority with which the content resists to shrinking
     * concerning the specified axis.
     * @see crossmobile.ios.uikit.UILayoutConstraintAxis
     */
    @CMSelector("- (UILayoutPriority)contentHuggingPriorityForAxis:(UILayoutConstraintAxis)axis;")
    public float contentHuggingPriorityForAxis(int UILayoutConstraintAxis) {
        if (UILayoutConstraintAxis == 0)
            return horizontalHuggingPriority;
        else if (UILayoutConstraintAxis == 1)
            return verticalHuggingPriority;
        return 0;
    }

    /**
     * Sets the priority with which the content of the view resists to enlarged
     * concerning an axis.
     *
     * @param UILayoutConstraintAxis The axis to which the priority is set.
     * @param UILayoutPriority       The priority with which the content resists to be
     *                               enlarged.
     * @see crossmobile.ios.uikit.UILayoutConstraintAxis
     * @see crossmobile.ios.uikit.UILayoutPriority
     */
    @CMSelector("- (void)setContentHuggingPriority:(UILayoutPriority)priority \n"
            + "                          forAxis:(UILayoutConstraintAxis)axis;")
    public void setContentHuggingPriority(float UILayoutPriority, int UILayoutConstraintAxis) {
        if (UILayoutConstraintAxis == 0)
            verticalHuggingPriority = UILayoutPriority;
        else if (UILayoutConstraintAxis == 1)
            horizontalHuggingPriority = UILayoutPriority;
    }

    ClVariable getVariable(int attribute) {
        return variableMap.get(attribute);
    }

    private void initVars() {
        variableMap.put(NSLayoutAttribute.Left, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Left"));
        variableMap.put(NSLayoutAttribute.Top, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Top"));
        variableMap.put(NSLayoutAttribute.Width, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Width"));
        variableMap.put(NSLayoutAttribute.Height, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Height"));
        solver.beginEdit();
        for (Integer attr : variableMap.keySet())
            solver.addEditVar(getVariable(attr));
        solver.resolve();
    }

    private void addDefaultConstraints() {
        updateIntrinsicConstraints(false);
        if (systemConstraints.isEmpty()) {
            systemConstraints.put("width", NSLayoutConstraint.constraintWithItem(this, NSLayoutAttribute.Width, NSLayoutRelation.GreaterThanOrEqual, null, NSLayoutAttribute.NotAnAttribute, 1, 1));
            systemConstraints.put("height", NSLayoutConstraint.constraintWithItem(this, NSLayoutAttribute.Height, NSLayoutRelation.GreaterThanOrEqual, null, NSLayoutAttribute.NotAnAttribute, 1,
                    1));
//            NSLayoutConstraint.activateConstraints(new ArrayList<>(systemConstraints.values()));
        }

    }

    private void updateIntrinsicConstraints(boolean force) {
        if (solver == null)
            return;
        if (intrinsicConstraints.isEmpty() && (intrinsicContentSize.getHeight() != 0 || intrinsicContentSize.getWidth() != 0)) {
            intrinsicConstraints.put("contentHuggingX", NSLayoutConstraint.constraintWithItem(this, NSLayoutAttribute.Width, NSLayoutRelation.LessThanOrEqual, null, NSLayoutAttribute.NotAnAttribute, 1, intrinsicContentSize.getWidth()));
            intrinsicConstraints.put("contentHuggingY", NSLayoutConstraint.constraintWithItem(this, NSLayoutAttribute.Height, NSLayoutRelation.LessThanOrEqual, null, NSLayoutAttribute.NotAnAttribute, 1, intrinsicContentSize.getHeight()));
            intrinsicConstraints.get("contentHuggingX").setPriority(horizontalHuggingPriority);
            intrinsicConstraints.get("contentHuggingY").setPriority(verticalHuggingPriority);
            intrinsicConstraints.put("contentCompressionX", NSLayoutConstraint.constraintWithItem(this, NSLayoutAttribute.Width, NSLayoutRelation.GreaterThanOrEqual, null, NSLayoutAttribute.NotAnAttribute, 1, intrinsicContentSize.getWidth()));
            intrinsicConstraints.put("contentCompressionY", NSLayoutConstraint.constraintWithItem(this, NSLayoutAttribute.Height, NSLayoutRelation.GreaterThanOrEqual, null, NSLayoutAttribute.NotAnAttribute, 1, intrinsicContentSize.getHeight()));
            intrinsicConstraints.get("contentCompressionX").setPriority(horizontalCompressionResistancePriority);
            intrinsicConstraints.get("contentCompressionY").setPriority(verticalCompressionResistancePriority);
            NSLayoutConstraint.activateConstraints(new ArrayList<>(intrinsicConstraints.values()));
        } else if (force) {
            NSLayoutConstraint.deactivateConstraints(new ArrayList<>(intrinsicConstraints.values()));
            intrinsicConstraints.clear();
            updateIntrinsicConstraints(false);
        }
    }

    private void setViewAttributes() {
        if (!Geometry.isZero(frame)) {
            CGSize activeSize = Geometry.isZero(frame.getSize()) ? intrinsicContentSize() : frame.getSize();
            solver().beginEdit();
            for (Integer attribute : variableMap.keySet())
                solver().suggestValue(getVariable(attribute), lookup(attribute, activeSize.getWidth(), activeSize.getHeight()));
            solver().resolve();
            suggestGuide(safeAreaLayoutGuide, safeAreaInsets());
            suggestGuide(layoutMarginsGuide, layoutMargins());
            if (controller != null)
                controller.suggestGuides(safeAreaInsets);
        }
    }

    private void bequeathIrrelevantConstraints() {
        for (NSLayoutConstraint constraint : constraints) {
            Object firstItemO = constraint.firstItem();
            Object secondItemO = constraint.secondItem();
            if (!(firstItemO instanceof UIView) || !(secondItemO instanceof UIView))
                continue;
            UIView firstItem = (UIView) firstItemO;
            UIView secondItem = (UIView) secondItemO;
            UIView superFirsItem = firstItem.superview();
            UIView superSecondItem = secondItem.superview();
            if (superFirsItem == this || superSecondItem == this)
                continue;
            if (firstItem == this && secondItem == this)
                continue;
            if (firstItem.isAncestor(secondItem)) {
                if (superSecondItem != null)
                    constraint.addToSolverStay(superSecondItem.solver());
            } else {
                if (superFirsItem != null)
                    constraint.addToSolverStay(superFirsItem.solver());
            }
        }
    }

    ClSimplexSolver solver() {
        if (solver == null) {
            systemConstraints = new HashMap<>();
            intrinsicConstraints = new HashMap<>();
            solver = new ClSimplexSolver();
            initVars();
            addDefaultConstraints();
        }
        return solver;
    }

    void applyLayout() {
        try {
            Native.lifecycle().runAndWaitOnEventThread(() -> {
                if (!constraints().isEmpty()) {
                    needsUpdateConstraints = false;
                    setViewAttributes();
                    bequeathIrrelevantConstraints();
                    for (UIView child : children)
                        if (!child.translatesAutoresizingMaskIntoConstraints())
                            for (NSLayoutConstraint constraint : child.relevantConstraints(this))
                                constraint.addToSolver(solver());
                    solver().resolve();
                }
                double cWidth = frame.getSize().getWidth();
                double cHeight = frame.getSize().getHeight();
                for (UIView child : children) {
                    if (child.ARMconstraints != null)
                        child.setFrameImpl(child.ARMconstraints.getFrame(cWidth, cHeight));
                    if (!child.translatesAutoresizingMaskIntoConstraints())
                        child.applyResult();
                    child.layoutSubviews();
                    if (solver != null)
                        solver.solve();
                }
                if (layoutGuides != null)
                    for (UILayoutGuide layoutGuide : layoutGuides)
                        layoutGuide.applyResult();
            });
        } catch (ConcurrentModificationException ex) {
            Native.lifecycle().postOnEventThread(this::applyLayout);
        }
    }

    private void applyResult() {
        if (solver == null)
            return;
        setFrameImpl((float) getVariable(NSLayoutAttribute.Left).getValue(),
                (float) getVariable(NSLayoutAttribute.Top).getValue(),
                (float) getVariable(NSLayoutAttribute.Width).getValue(),
                (float) getVariable(NSLayoutAttribute.Height).getValue());
    }

    double lookup(int attr, double rwidth, double rheight) {
        switch (attr) {
            case NSLayoutAttribute.Width:
                return rwidth;
            case NSLayoutAttribute.Height:
                return rheight;
            case NSLayoutAttribute.Top:
            case NSLayoutAttribute.Left:
            default:
                return 0;
        }
    }

    /**
     * Returns the bottom edge of the layout guide frame expressed as layout
     * anchor.
     *
     * @return The bottom edge of the layout guide frame expressed as layout
     * anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutYAxisAnchor *bottomAnchor;")
    public NSLayoutYAxisAnchor bottomAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.bottomAnchor == null)
            anchors.bottomAnchor = new NSLayoutYAxisAnchor(UIView.this, NSLayoutAttribute.Bottom);
        return anchors.bottomAnchor;

    }

    /**
     * Returns the horizontal center of the layout guide frame expressed as
     * layout anchor.
     *
     * @return The horizontal center of the layout guide frame expressed as
     * layout anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *centerXAnchor;")
    public NSLayoutXAxisAnchor centerXAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.centerXAnchor == null)
            anchors.centerXAnchor = new NSLayoutXAxisAnchor(UIView.this, NSLayoutAttribute.CenterX);
        return anchors.centerXAnchor;

    }

    /**
     * Returns the vertical center of the layout guide frame expressed as layout
     * anchor.
     *
     * @return The vertical center of the layout guide frame expressed as layout
     * anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutYAxisAnchor *centerYAnchor;")
    public NSLayoutYAxisAnchor centerYAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.centerYAnchor == null)
            anchors.centerYAnchor = new NSLayoutYAxisAnchor(UIView.this, NSLayoutAttribute.CenterY);
        return anchors.centerYAnchor;
    }

    /**
     * Returns the height of the layout guide frame expressed as layout anchor.
     *
     * @return The height of the layout guide frame expressed as layout anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutDimension *heightAnchor;")
    public NSLayoutDimension heightAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.heightAnchor == null)
            anchors.heightAnchor = new NSLayoutDimension(UIView.this, NSLayoutAttribute.Height);
        return anchors.heightAnchor;
    }

    /**
     * Returns the leading edge of the layout guide frame expressed as layout
     * anchor.
     *
     * @return The leading edge of the layout guide frame expressed as layout
     * anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *leadingAnchor;")
    public NSLayoutXAxisAnchor leadingAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.leadingAnchor == null)
            anchors.leadingAnchor = new NSLayoutXAxisAnchor(UIView.this, NSLayoutAttribute.Leading);
        return anchors.leadingAnchor;
    }

    /**
     * Returns the left edge of the layout guide frame expressed as layout
     * anchor.
     *
     * @return The left edge of the layout guide frame expressed as layout
     * anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *leftAnchor;")
    public NSLayoutXAxisAnchor leftAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.leftAnchor == null)
            anchors.leftAnchor = new NSLayoutXAxisAnchor(UIView.this, NSLayoutAttribute.Left);
        return anchors.leftAnchor;
    }

    /**
     * Returns the right edge of the layout guide frame expressed as layout
     * anchor.
     *
     * @return The right edge of the layout guide frame expressed as layout
     * anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *rightAnchor;")
    public NSLayoutXAxisAnchor rightAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.rightAnchor == null)
            anchors.rightAnchor = new NSLayoutXAxisAnchor(UIView.this, NSLayoutAttribute.Right);
        return anchors.rightAnchor;
    }

    /**
     * Returns the top edge of the layout guide frame expressed as a layout
     * anchor.
     *
     * @return The top edge of the layout guide frame expressed as a layout
     * anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutYAxisAnchor *topAnchor;")
    public NSLayoutYAxisAnchor topAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.topAnchor == null)
            anchors.topAnchor = new NSLayoutYAxisAnchor(UIView.this, NSLayoutAttribute.Top);
        return anchors.topAnchor;
    }

    /**
     * Returns the trailing edge of the layout guide frame expressed as an
     * layout anchor.
     *
     * @return The trailing edge of the layout guide frame expressed as an
     * layout anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *trailingAnchor;")
    public NSLayoutXAxisAnchor trailingAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.trailingAnchor == null)
            anchors.trailingAnchor = new NSLayoutXAxisAnchor(UIView.this, NSLayoutAttribute.Trailing);
        return anchors.trailingAnchor;
    }

    /**
     * Returns the width of the layout guide frame expressed as an layout
     * anchor.
     *
     * @return The width of the layout guide frame expressed as an layout
     * anchor.
     */
    @CMGetter("@property(readonly, strong) NSLayoutDimension *widthAnchor;")
    public NSLayoutDimension widthAnchor() {
        if (anchors == null)
            anchors = new Anchor();
        if (anchors.widthAnchor == null)
            anchors.widthAnchor = new NSLayoutDimension(UIView.this, NSLayoutAttribute.Width);
        return anchors.widthAnchor;
    }

    /**
     * Adds the specified layout guide to this view.
     *
     * @param layoutGuide The layout guide that will be added to the view.
     */
    @CMSelector("- (void)addLayoutGuide:(UILayoutGuide *)layoutGuide;\n"
            + "")
    public void addLayoutGuide(UILayoutGuide layoutGuide) {
        if (layoutGuides == null)
            layoutGuides = new ArrayList<>();
        layoutGuides.add(layoutGuide);
        layoutGuide.setOwningView(this);
    }

    /**
     * Returns the layout margins of this view.
     *
     * @return The layout margins of this view.
     * @see crossmobile.ios.uikit.UIEdgeInsets
     */
    @CMGetter("@property(nonatomic) UIEdgeInsets layoutMargins;")
    public UIEdgeInsets layoutMargins() {
        refreshMarginsIfNeeded();
        return layoutMargins;
    }

    /**
     * Sets the layout margins to the specified UIEdgeInsets value
     *
     * @param layoutMargins The layout margins.
     * @see crossmobile.ios.uikit.UIEdgeInsets
     */
    @CMSetter("@property(nonatomic) UIEdgeInsets layoutMargins;")
    public void setLayoutMargins(UIEdgeInsets layoutMargins) {
        this.layoutMargins = layoutMargins;
        refreshMarginsIfNeeded();
    }

    /**
     * Informs this view that there was a change to its margins.
     */
    @CMSelector("- (void)layoutMarginsDidChange;")
    public void layoutMarginsDidChange() {
    }

    /**
     * Returns a layout guides with this views margins.
     *
     * @return A layout guides with this views margins.
     */
    @CMGetter("@property(readonly, strong) UILayoutGuide *layoutMarginsGuide;")
    public UILayoutGuide layoutMarginsGuide() {
        if (layoutMarginsGuide == null) {
            layoutMarginsGuide = new UILayoutGuide();
            layoutMarginsGuide.setIdentifier("UIViewLayoutMarginsGuide");
            layoutMarginsGuide.setOwningView(this);
            addLayoutGuide(layoutMarginsGuide);
            solver().beginEdit();
            for (Integer attr : variableMap.keySet())
                solver().addEditVar(layoutMarginsGuide.getVariable(attr));
            solver().resolve();
        }
        return layoutMarginsGuide;
    }


    private void suggestGuide(UILayoutGuide guide, UIEdgeInsets insets) {
        if (guide != null) {
            CGSize current = frame.getSize();
            solver().suggestValue(guide.getVariable(NSLayoutAttribute.Left), lookup(NSLayoutAttribute.Left, current.getWidth(), current.getHeight()) + insets.getLeft());
            solver().suggestValue(guide.getVariable(NSLayoutAttribute.Top), lookup(NSLayoutAttribute.Top, current.getWidth(), current.getHeight()) + insets.getTop());
            solver().suggestValue(guide.getVariable(NSLayoutAttribute.Width), lookup(NSLayoutAttribute.Width, current.getWidth(), current.getHeight()) - insets.getLeft() - insets.getRight());
            solver().suggestValue(guide.getVariable(NSLayoutAttribute.Height), lookup(NSLayoutAttribute.Height, current.getWidth(), current.getHeight()) - insets.getTop() - insets.getBottom());
            solver().resolve();
        }
    }


    private void refreshMarginsIfNeeded() {
        UIEdgeInsets edgeInsets = safeAreaInsets;
        UIEdgeInsets newLayoutMargins = layoutMargins;
        if (insetsLayoutMarginsFromSafeArea) {
            if (newLayoutMargins.getTop() < edgeInsets.getTop())
                newLayoutMargins.setTop(edgeInsets.getTop());
            if (newLayoutMargins.getLeft() < edgeInsets.getLeft())
                newLayoutMargins.setLeft(edgeInsets.getLeft());
            if (newLayoutMargins.getBottom() < edgeInsets.getBottom())
                newLayoutMargins.setBottom(edgeInsets.getBottom());
            if (newLayoutMargins.getRight() < edgeInsets.getRight())
                newLayoutMargins.setRight(edgeInsets.getRight());
        }
        UIView parent;
        if (preservesSuperviewLayoutMargins && (parent = superview()) != null) {
            if (newLayoutMargins.getTop() < parent.layoutMargins().getTop() - frame.getOrigin().getY())
                newLayoutMargins.setTop(parent.layoutMargins().getTop() - frame.getOrigin().getY());
            if (newLayoutMargins.getLeft() < parent.layoutMargins().getLeft() - frame.getOrigin().getX())
                newLayoutMargins.setLeft(parent.layoutMargins().getLeft() - frame.getOrigin().getX());
            if (newLayoutMargins.getBottom() < frame.getOrigin().getY() + frame.getSize().getHeight() - parent.frame.getSize().getHeight() + parent.layoutMargins().getBottom())
                newLayoutMargins.setBottom(frame.getOrigin().getY() + frame.getSize().getHeight() - parent.frame.getSize().getHeight() + parent.layoutMargins().getBottom());
            if (newLayoutMargins.getRight() < frame.getOrigin().getX() + frame.getSize().getWidth() - parent.frame.getSize().getWidth() + parent.layoutMargins().getRight())
                newLayoutMargins.setRight(frame.getOrigin().getX() + frame.getSize().getWidth() - parent.frame.getSize().getWidth() + parent.layoutMargins().getRight());
        }
        if (!newLayoutMargins.equals(layoutMargins)) {
            layoutMarginsDidChange();
        }
    }

    /**
     * Retuns a Boolean that show whether this view adapts to its superview
     * margins.
     *
     * @return A Boolean that show whether this view adapts to its superview
     * margins.
     */
    @CMGetter("@property(nonatomic) BOOL preservesSuperviewLayoutMargins;")
    public boolean preservesSuperviewLayoutMargins() {
        return preservesSuperviewLayoutMargins;
    }

    /**
     * Sets a Boolean value that defines whether this view adapts to its
     * superview margins.
     *
     * @param preservesSuperviewLayoutMargins A Boolean value that defines
     *                                        whether this view adapts to its superview margins.
     */
    @CMSetter("@property(nonatomic) BOOL preservesSuperviewLayoutMargins;")
    public void setPreservesSuperviewLayoutMargins(boolean preservesSuperviewLayoutMargins) {
        this.preservesSuperviewLayoutMargins = preservesSuperviewLayoutMargins;
    }

    /**
     * Removes the layout guide from the related array.
     *
     * @param layoutGuide The layout that will be removed.
     */
    @CMSelector("- (void)removeLayoutGuide:(UILayoutGuide *)layoutGuide;")
    public void removeLayoutGuide(UILayoutGuide layoutGuide) {
        layoutGuides.remove(layoutGuide);
        layoutGuide.setOwningView(null);
        for (NSLayoutConstraint constraint : constraints)
            if (constraint.firstItem().equals(layoutGuide) || constraint.secondItem().equals(layoutGuide))
                removeConstraint(constraint);
    }

    /**
     * Returns a view that is suitable for the top row baseline
     *
     * @return A view that is suitable for the top row baseline
     */
    @CMGetter("@property(readonly, strong) UIView *viewForFirstBaselineLayout;")
    public UIView viewForFirstBaselineLayout() {
        return viewForLastBaselineLayout();
    }

    /**
     * Returns a view that is suitable for the bottom row baseline.
     *
     * @return A view that is suitable for the bottom row baseline.
     */
    @CMGetter("@property(readonly, strong) UIView *viewForLastBaselineLayout;")
    public UIView viewForLastBaselineLayout() {
        return this;
    }

    List<NSLayoutConstraint> relevantConstraints(Object view) {
        if (constraints.isEmpty())
            return constraints;
        List<NSLayoutConstraint> relevant = new ArrayList<>();
        for (NSLayoutConstraint constraint : constraints)
            if (constraint.firstItem().equals(view) || (constraint.secondItem() != null && constraint.secondItem().equals(view)))
                relevant.add(constraint);
            else if (constraint.firstItem().equals(this) && (constraint.secondItem() == null))
                relevant.add(constraint);
        return relevant;
    }

    protected final void registerWidget(WidgetWrapper<UIView, NativeWrapper<? extends
            GraphicsContext<?>>, GraphicsContext<?>> peer) {
        this.widget = peer;
        layoutNativeFromRoot();
    }

    protected final WidgetWrapper<UIView, NativeWrapper<? extends GraphicsContext<?>>, GraphicsContext<?>> getWidget() {
        return widget;
    }

    @CMGetter("@property(nonatomic, readonly) UIEdgeInsets safeAreaInsets;")
    public UIEdgeInsets safeAreaInsets() {
        UIEdgeInsets oldInsets = safeAreaInsets;
        UIView superview = superview();
        if (controller != null) {
            if (controller.navigationController() != null)
                safeAreaInsets = controller.navigationController().getTotalSafeAreaInsets();
            else
                safeAreaInsets = controller.getTotalSafeAreaInsets();
        } else if (superview != null) {
            UIEdgeInsets superInsets = superview.safeAreaInsets();
            double top = frame.getOrigin().getY() > superInsets.getTop()
                    ? 0
                    : superInsets.getTop() - frame.getOrigin().getY();
            double left = frame.getOrigin().getX() > superInsets.getLeft()
                    ? 0
                    : superInsets.getLeft() - frame.getOrigin().getX();
            double bottom = frame.getSize().getHeight() < superview.frame.getSize().getHeight() -
                    (frame.getOrigin().getY() > superInsets.getTop()
                            ? frame.getOrigin().getY()
                            : top) - superInsets.getBottom()
                    ? 0
                    : superInsets.getBottom() - superview.frame.getSize().getHeight() - (frame.getOrigin().getY() > superInsets.getTop() ? frame.getOrigin().getY() : top) - frame.getSize().getHeight();
            double right = frame.getSize().getWidth() < superview.frame.getSize().getWidth() -
                    (frame.getOrigin().getX() > superInsets.getLeft()
                            ? frame.getOrigin().getX()
                            : left) - superInsets.getRight()
                    ? 0
                    : superInsets.getRight() - superview.frame.getSize().getWidth() - (frame.getOrigin().getX() > superInsets.getLeft() ? frame.getOrigin().getX() : left) - frame.getSize().getWidth();
            safeAreaInsets = new UIEdgeInsets(top, left, bottom, right);
        } else
            safeAreaInsets = UIEdgeInsets.zero();
        if (!safeAreaInsets.equals(oldInsets)) {
            // Safe area insets changed
            if (controller != null)
                controller.viewSafeAreaInsetsDidChange();
        }
        refreshMarginsIfNeeded();
        return safeAreaInsets;
    }

    @CMGetter("@property(nonatomic) BOOL insetsLayoutMarginsFromSafeArea;")
    public boolean insetsLayoutMarginsFromSafeArea() {
        return insetsLayoutMarginsFromSafeArea;
    }

    @CMSetter("@property(nonatomic) BOOL insetsLayoutMarginsFromSafeArea;")
    public void setInsetsLayoutMarginsFromSafeArea(boolean insetsLayoutMarginsFromSafeArea) {
        this.insetsLayoutMarginsFromSafeArea = insetsLayoutMarginsFromSafeArea;
    }


    @CMGetter("@property(nonatomic, readonly, strong) UILayoutGuide *safeAreaLayoutGuide;")
    public UILayoutGuide safeAreaLayoutGuide() {
        if (safeAreaLayoutGuide == null) {
            safeAreaLayoutGuide = new UILayoutGuide();
            safeAreaLayoutGuide.setIdentifier("UIViewSafeAreaLayoutGuide");
            addLayoutGuide(safeAreaLayoutGuide);
            solver().beginEdit();
            for (Integer attr : variableMap.keySet())
                solver().addEditVar(safeAreaLayoutGuide.getVariable(attr));
            solver().resolve();
        }
        return safeAreaLayoutGuide;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    void setFrameImpl(double x, double y, double width, double height) {
        int pWidth = 0;
        int pHeight = 0;
        if (painter instanceof FixedSizeRequirement<?>) {
            pWidth = ((FixedSizeRequirement) painter).getFixedWidth(this);
            pHeight = ((FixedSizeRequirement) painter).getFixedHeight(this);
        }
        frame.getOrigin().setX(x);
        frame.getOrigin().setY(y);
        frame.getSize().setWidth(pWidth > 0 ? pWidth : width);
        frame.getSize().setHeight(pHeight > 0 ? pHeight : height);
    }

    private void setFrameImpl(CGRect otherFrame) {
        setFrameImpl(otherFrame.getOrigin().getX(), otherFrame.getOrigin().getY(), otherFrame.getSize().getWidth(), otherFrame.getSize().getHeight());
    }

    @Override
    public void setAccessibilityIdentifier(String accessibilityIdentifier) {
        this.accessibilityIdentifier = accessibilityIdentifier;
    }

    @Override
    public String accessibilityIdentifier() {
        return accessibilityIdentifier;
    }

    @Override
    @CMPure
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(SystemUtilities.getClassName(getClass()));
        out.append(" frame=");
        out.append(frame().toString());
        if (tag() != 0)
            out.append(" tag=").append(tag);
        if (!transform().isIdentity())
            out.append(" transf=").append(transform().toString());
        return out.toString();
    }

    private static class Anchor {

        private NSLayoutYAxisAnchor bottomAnchor;
        private NSLayoutXAxisAnchor centerXAnchor;
        private NSLayoutYAxisAnchor centerYAnchor;
        @SuppressWarnings("unused")
        private NSLayoutYAxisAnchor firstBaselineAnchor;
        private NSLayoutDimension heightAnchor;
        @SuppressWarnings("unused")
        private NSLayoutYAxisAnchor lastBaselineAnchor;
        private NSLayoutXAxisAnchor leadingAnchor;
        private NSLayoutXAxisAnchor leftAnchor;
        private NSLayoutXAxisAnchor rightAnchor;
        private NSLayoutYAxisAnchor topAnchor;
        private NSLayoutXAxisAnchor trailingAnchor;
        private NSLayoutDimension widthAnchor;
    }

    @CMGetter("@property(nonatomic, copy) NSString *restorationIdentifier;")
    public String restorationIdentifier() {
        return restorationIdentifier;
    }

    @CMSetter("@property(nonatomic, copy) NSString *restorationIdentifier;")
    public void setRestorationIdentifier(String restorationIdentifier) {
        //TODO what it actually does
        this.restorationIdentifier = restorationIdentifier;
    }

    @CMGetter("@property(nonatomic, readonly) UIUserInterfaceLayoutDirection userInterfaceLayoutDirection;")
    public int userInterfaceLayoutDirection() {
        return UIApplication.sharedApplication() == null
                ? UIUserInterfaceLayoutDirection.LeftToRight
                : UIApplication.sharedApplication().userInterfaceLayoutDirection();
    }

    private void meAndChildren(VoidBlock1<UIView> action, boolean depthFirst) {
        if (!depthFirst)
            action.invoke(this);
        for (UIView child : children)
            child.meAndChildren(action, depthFirst);
        if (depthFirst)
            action.invoke(this);
    }

    static final class DelegateViews {
        private final UIView view;
        private final UIView oldParent;
        private final UIView newParent;
        private final UIWindow oldWindow;
        private final UIWindow newWindow;
        private final int idx;


        private DelegateViews(UIView view, UIView oldParent, UIView newParent, int idx) {
            this.view = view;
            this.oldParent = oldParent;
            this.newParent = newParent;
            this.oldWindow = oldParent == null ? null : oldParent.window();
            this.newWindow = newParent == null ? null : newParent.window();
            this.idx = idx;
        }

        UIView anyParent() {
            if (oldParent == null)
                return newParent;
            if (newParent == null)
                return oldParent;
            return oldParent == newParent ? newParent : null;
        }

        void doAdd() {
            if (oldParent != null)
                oldParent.children.remove(view);
            if (idx >= 0)
                newParent.children.add(idx, view);
            else
                newParent.children.add(view);
            view.parentRef = new WeakReference<>(newParent);
            view.tintColorDidChange();
        }

        void doRemove() {
            if (oldParent != null)
                oldParent.children.remove(view);
            view.parentRef = null;
        }

        void delegateBefore() {
            if (oldWindow != newWindow)
                view.meAndChildren(it -> it.willMoveToWindow(newWindow), false);
            if (oldParent != newParent) {
                view.willMoveToSuperview(newParent);
                if (oldParent != null)
                    oldParent.willRemoveSubview(view);
                if (newParent != null)
                    newParent.willAddSubview(view);
            }
        }

        void delegateAfter() {
            if (oldWindow != newWindow)
                view.meAndChildren(AppearanceRegistry::didMoveToWindow, true);
            if (oldParent != newParent) {
                view.didMoveToSuperview();
                if (newParent != null)
                    newParent.didAddSubview(view);
                if (oldParent != null)
                    oldParent.didRemoveSubview(view);
            }
            view.attachWidget(newParent != null && view.isAttachedToWindow());
            view.updateNativeUserInteraction();
            /* Constraints only change when attaching/detaching - not when
             * hidden/unhidden.
             * So, they can not be called inside attachWidget
             */
            view.updateConstraints();
        }

        UIView view() {
            return view;
        }
    }
}
