/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSTimer;
import org.crossmobile.bind.graphics.theme.ActivityIndicatorPainter;
import org.crossmobile.bind.graphics.theme.PainterExtraData;
import org.crossmobile.bridge.ann.*;

/**
 * UIActivityIndicatorView class defines an object that is used to show that an
 * activity is in progress and it is depicted as an spinning gear.
 */
@CMClass
public class UIActivityIndicatorView extends UIView {

    private int activityIndicatorViewStyle;
    private UIColor color = UIColor.whiteColor;
    private boolean hidesWhenStopped = true;

    private boolean animating;
    private NSTimer animateTimer;
    private final PainterExtraData extraData;
    private int currentAnimationFrame;

    /**
     * The default constructor of the UIActivityIndicatorView.
     */
    public UIActivityIndicatorView() {
        this(UIActivityIndicatorViewStyle.White);
    }

    /**
     * Constructs and returns a UIActivityIndicatorView object with the
     * specified style.
     *
     * @param UIActivityIndicatorViewStyle The style of the new object.
     * @see crossmobile.ios.uikit.UIActivityIndicatorViewStyle
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithActivityIndicatorStyle:(UIActivityIndicatorViewStyle)style")
    public UIActivityIndicatorView(int UIActivityIndicatorViewStyle) {
        super(CGRect.zero());
        extraData = painter().initExtraData();
        setActivityIndicatorViewStyle(UIActivityIndicatorViewStyle);
        setFrameImpl(0, 0, 0, 0);    // resize based on style
    }

    @SuppressWarnings("unchecked")
    private ActivityIndicatorPainter<PainterExtraData> painter() {
        return (ActivityIndicatorPainter<PainterExtraData>) painter;
    }

    /**
     * Sets the style for this activity indicator.
     *
     * @param style The style for this activity indicator.
     * @see crossmobile.ios.uikit.UIActivityIndicatorViewStyle
     */
    @CMSetter(" @property(nonatomic) UIActivityIndicatorViewStyle activityIndicatorViewStyle ")
    public void setActivityIndicatorViewStyle(int style) {
        this.activityIndicatorViewStyle = style;
        if (style == UIActivityIndicatorViewStyle.White || style == UIActivityIndicatorViewStyle.WhiteLarge)
            color = UIColor.whiteColor;
        else if (style == UIActivityIndicatorViewStyle.Gray)
            color = UIColor.grayColor;
        setNeedsDisplay();
    }

    /**
     * Sets the color of the animator
     *
     * @param color The desired animator color
     */
    @CMSetter("@property(readwrite, nonatomic, strong) UIColor *color;")
    public void setColor(UIColor color) {
        if (color != null)
            this.color = color;
    }

    /**
     * Returns the color of the animator
     *
     * @return The current animator color
     */
    @CMGetter("@property(readwrite, nonatomic, strong) UIColor *color;")
    public UIColor color() {
        return color;
    }


    /**
     * Returns whether the view is currently animating
     *
     * @return true if it is animating
     */
    @CMGetter("@property(nonatomic, readonly, getter=isAnimating) BOOL animating;")
    public boolean isAnimating() {
        return animating;
    }

    /**
     * Returns a number that represents the style of this activity indicator.
     *
     * @return A number that represents the style of this activity indicator.
     * @see crossmobile.ios.uikit.UIActivityIndicatorViewStyle
     */
    @CMGetter(" @property(nonatomic) UIActivityIndicatorViewStyle activityIndicatorViewStyle ")
    public int activityIndicatorViewStyle() {
        return activityIndicatorViewStyle;
    }

    /**
     * Sets a Boolean value that defines whether this activity indicator is
     * hidden when the animation stops.
     *
     * @param flag A Boolean value that shows whether this activity indicator is
     *             hidden when the animation stops.
     */
    @CMSetter(" @property(nonatomic) BOOL hidesWhenStopped ")
    public void setHidesWhenStopped(boolean flag) {
        this.hidesWhenStopped = flag;
    }

    /**
     * Returns a Boolean value that shows whether this activity indicator is
     * hidden when the animation stops.
     *
     * @return A Boolean value that shows whether this activity indicator is
     * hidden when the animation stops.
     */
    @CMGetter(" @property(nonatomic) BOOL hidesWhenStopped ")
    public boolean hidesWhenStopped() {
        return hidesWhenStopped;
    }

    /**
     * Enables progress indicator's animation.
     */
    @CMSelector("- (void)startAnimating")
    public void startAnimating() {
        synchronized (this) {
            if (hidesWhenStopped)
                super.setHidden(false);
            animating = true;
            if (!isHidden())
                startTimer();
        }
    }

    /**
     * Stops progress indicator's animation.
     */
    @CMSelector("- (void)stopAnimating")
    public void stopAnimating() {
        synchronized (this) {
            if (hidesWhenStopped)
                super.setHidden(true);
            animating = false;
            stopTimer();
        }
    }

    private void startTimer() {
        synchronized (this) {
            if (animateTimer != null)
                return;
            painter().setAnimationFrame(0, extraData);
            animateTimer = NSTimer.scheduledTimerWithTimeInterval(painter().getAnimationFrameDuration(), (NSTimer timer) -> {
                currentAnimationFrame++;
                if (currentAnimationFrame >= painter().getMaximumFrame())
                    currentAnimationFrame = 0;
                painter().setAnimationFrame(currentAnimationFrame, extraData);
                setNeedsDisplay();
            }, null, true);
        }
    }

    private void stopTimer() {
        if (animateTimer != null) {
            animateTimer.invalidate();
            animateTimer = null;
        }
    }

    @Override
    public void setHidden(boolean hidden) {
        super.setHidden(hidden);
        if (animating && !hidden)
            startTimer();
        else
            stopTimer();
    }

    @Override
    public final void drawRect(CGRect rect) {
        painter().draw(this, rect, extraData);
    }
}
