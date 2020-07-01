/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.GraphicsDrill;
import crossmobile.ios.foundation.NSTimer;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import static crossmobile.ios.coregraphics.GraphicsDrill.context;

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
    private int progress;

    private static final float WIDTH_LARGE = 37;
    private static final float WIDTH_SMALL = 20;

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
        super(new CGRect(0, 0,
                UIActivityIndicatorViewStyle == crossmobile.ios.uikit.UIActivityIndicatorViewStyle.WhiteLarge ? WIDTH_LARGE : WIDTH_SMALL,
                UIActivityIndicatorViewStyle == crossmobile.ios.uikit.UIActivityIndicatorViewStyle.WhiteLarge ? WIDTH_LARGE : WIDTH_SMALL));
        setActivityIndicatorViewStyle(UIActivityIndicatorViewStyle);
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
     * @param color The desired animator color
     */
    @CMSetter("@property(readwrite, nonatomic, strong) UIColor *color;")
    public void setColor(UIColor color) {
        if (color != null)
            this.color = color;
    }

    /**
     * Returns the color of the animator
     * @return The current animator color
     */
    @CMGetter("@property(readwrite, nonatomic, strong) UIColor *color;")
    public UIColor color() {
        return color;
    }


    /**
     * Returns whether the view is currently animating
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
            progress = 0;
            animateTimer = NSTimer.scheduledTimerWithTimeInterval(0.1, (NSTimer timer) -> {
                progress++;
                if (progress >= Theme.ActivityIndicator.SLICES)
                    progress = 0;
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
        CGContext cgc = UIGraphics.getCurrentContext();
        boolean isBig = activityIndicatorViewStyle == UIActivityIndicatorViewStyle.WhiteLarge;
        int baseColor = GraphicsDrill.color(color.cgcolor) & 0xFFFFFF;
        float fullRadius = isBig ? WIDTH_LARGE / 2 : WIDTH_SMALL / 2;
        double height = isBig ? Theme.ActivityIndicator.THICK : Theme.ActivityIndicator.THIN;

        double rest = 1 / 4d;
        double centerX = rect.getOrigin().getX() + rect.getSize().getWidth() / 2;
        double centerY = rect.getOrigin().getY() + rect.getSize().getHeight() / 2;
        double radius = (rest + 1) * fullRadius / 2;
        double length = (1 - rest) * fullRadius;
        for (int i = 0; i < Theme.ActivityIndicator.SLICES; i++) {
            baseColor = baseColor | (((i + Theme.ActivityIndicator.ALPHA_SAFE) * 255 / (Theme.ActivityIndicator.SLICES + Theme.ActivityIndicator.ALPHA_SAFE - 1)) << 24);
            double angle = (2 * Math.PI) * (i + progress) / Theme.ActivityIndicator.SLICES % (Math.PI * 2);
            double dx = centerX + (radius * Math.cos(angle));
            double dy = centerY + (radius * Math.sin(angle));
            angle += Theme.ActivityIndicator.ANGLE;
            cgc.translateCTM(dx, dy);
            cgc.rotateCTM(angle);
            context(cgc).fillRoundRodBar(-length / 2, -height / 2, length, height, baseColor);
            cgc.rotateCTM(-angle);
            cgc.translateCTM(-dx, -dy);
        }
    }
}
