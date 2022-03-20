/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.theme.ProgressPainter;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import static crossmobile.ios.coregraphics.GraphicsDrill.context;

/**
 * UIProgressView class defines an object that represents a visible bar that
 * fills with color over time representing the progress of a task.
 */
@CMClass
public class UIProgressView extends UIView {

    private float progress;
    private int progressViewStyle;
    private UIColor progressTintColor = null;
    private UIColor trackTintColor = null;

    /**
     * Initializes and returns an progress-view object.
     *
     * @param UIProgressViewStyle A constant that specifies the style of the
     *                            object to be created. See UIProgressViewStyle for descriptions of the
     *                            style constants.
     * @see crossmobile.ios.uikit.UIProgressViewStyle
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithProgressViewStyle:(UIProgressViewStyle)style;")
    public UIProgressView(int UIProgressViewStyle) {
        setProgressViewStyle(UIProgressViewStyle);
        progress = 0;
    }

    /**
     * Sets the current progress shown on the bar using a floating number that
     * ranges from 0 to 1.
     *
     * @param val The current progress of the bar.
     */
    @CMSetter("@property(nonatomic) float progress;")
    public void setProgress(float val) {
        progress = val;
        if (progress < 0)
            progress = 0;
        if (progress > 1)
            progress = 1;
        setNeedsDisplay();
    }

    /**
     * Returns a float number that ranges from 0 to 1 and represents the current
     * progress shown on the bar.
     *
     * @return The float number that represents the current progress. .
     */
    @CMGetter("@property(nonatomic) float progress;")
    public float progress() {
        return progress;
    }

    /**
     * Returns the style of this progress bar.
     *
     * @return The style of this progress bar.
     * @see crossmobile.ios.uikit.UIProgressViewStyle
     */
    @CMGetter("@property(nonatomic) UIProgressViewStyle progressViewStyle;")
    public int progressViewStyle() {
        return progressViewStyle;
    }

    /**
     * Sets the graphical style of this progress bar.
     *
     * @param UIProgressViewStyle The graphical style of this progress bar.
     * @see crossmobile.ios.uikit.UIProgressViewStyle
     */
    @CMSetter("@property(nonatomic) UIProgressViewStyle progressViewStyle;")
    public void setProgressViewStyle(int UIProgressViewStyle) {
        progressViewStyle = UIProgressViewStyle;
    }

    /**
     * Sets the color that is used for the remaining part of the progress bar.
     *
     * @param trackTintColor The color that is used for the remaining part of
     *                       the progress bar.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *trackTintColor;")
    public void setTrackTintColor(UIColor trackTintColor) {
        this.trackTintColor = trackTintColor;
    }

    /**
     * Returns the color that is used for the remaining part of the progress
     * bar.
     *
     * @return The color that is used for the remaining part of the progress
     * bar.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *trackTintColor;")
    public UIColor trackTintColor() {
        return trackTintColor;
    }

    /**
     * Sets the color that fills the progress bar.
     *
     * @param progressTintColor The color that fills the progress bar.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *progressTintColor;")
    public void setProgressTintColor(UIColor progressTintColor) {
        this.progressTintColor = progressTintColor;
    }

    /**
     * Returns the color that fills the progress bar.
     *
     * @return The color that fills the progress bar.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *progressTintColor;")
    public UIColor progressTintColor() {
        return progressTintColor;
    }

    @Override
    public final void drawRect(CGRect rect) {
        ((ProgressPainter) painter).draw(this, rect);
    }
}
