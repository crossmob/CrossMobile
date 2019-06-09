/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.$coregraphics;
import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPathDrawingMode;
import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.system.Promise;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.List;

/**
 * UISegmentedControl class defines an object that is used in order to provide
 * custom control for special occasions, for example switching between views.
 * Visually it is depicted as a set of sectors (buttons or images) that
 * correspond to controls, placed horizontally.
 */
@CMClass
public class UISegmentedControl extends UIControl {

    private int selection = -1;
    private List<Segment> items = new ArrayList<>();
    private int style = UISegmentedControlStyle.Plain;
    private boolean momentary = false;
    private boolean deferupdate = false;
    private UIColor lastTint = null;
    private UIColor lastLabelColor = null;
    //
    private final UIControlDelegate touchDowmDelegate = (sender, event) -> setSelectedSegmentIndex(sender.tag());

    private final UIControlDelegate touchUpDelegate = (sender, event) -> {
        if (momentary && selection >= 0)
            items.get(selection).setSelected(false);
    };

    /**
     * Constructs a default UISegmentedControl object located at (0,0) with 0
     * weight and 0 height.
     */
    public UISegmentedControl() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIWindow object initialized with the dimensions and position
     * specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of UIWindow.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UISegmentedControl(CGRect rect) {
        super(rect);
        setTintColor(UIColor.blueColor());
    }

    /**
     * Initializes and returns a segmented control with segments having the
     * given titles or images.
     *
     * @param items An List of String objects (for segment titles) or UIImage
     *              objects (for segment images).
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithItems:(NSArray *)items;")
    public UISegmentedControl(List items) {
        if (items != null && !items.isEmpty()) {
            deferupdate = true;
            for (int i = 0; i < items.size(); i++)
                if (items.get(i) instanceof String)
                    insertSegmentWithTitle((String) items.get(i), i, false);
                else if (items.get(i) instanceof UIImage)
                    insertSegmentWithImage((UIImage) items.get(i), i, false);

            deferupdate = false;
            layoutSubviews();
        }
    }

    /**
     * Sets the title of a segment.
     *
     * @param title The title of a segment.
     * @param index The index of the segment.
     */
    @CMSelector("- (void)setTitle:(NSString *)title \n"
            + "forSegmentAtIndex:(NSUInteger)segment;")
    public void setTitle(String title, int index) {
        items.get(index).setTitle(title, UIControlState.Normal);
    }

    /**
     * Returns the title of the segment at the specified index.
     *
     * @param index The index of the segment.
     * @return The title of the segment. NULL if there is no title.
     */
    @CMSelector("- (NSString *)titleForSegmentAtIndex:(NSUInteger)segment;")
    public String titleForSegmentAtIndex(int index) {
        return items.get(index).currentTitle();
    }

    /**
     * Sets the specified image to the segment of the specified index.
     *
     * @param image The image for the segment.
     * @param index The index of the segment.
     */
    @CMSelector("- (void)setImage:(UIImage *)image \n"
            + "forSegmentAtIndex:(NSUInteger)segment;")
    public void setImage(UIImage image, int index) {
        items.get(index).setSegmentedImage(image);
    }

    /**
     * Returns the image for the segment of the specified index.
     *
     * @param index The index of the segment.
     * @return The image of the segment. NULL if there is no image.
     */
    @CMSelector("- (UIImage *)imageForSegmentAtIndex:(NSUInteger)segment;")
    public UIImage imageForSegmentAtIndex(int index) {
        return items.get(index).currentImage();
    }

    /**
     * Inserts the specified title to the segment of the given index, using
     * animation or not.
     *
     * @param title    The title for the segment.
     * @param index    The index that specifies the segment.
     * @param animated TRUE the change is animated.
     */
    @CMSelector("- (void)insertSegmentWithTitle:(NSString *)title \n"
            + "                       atIndex:(NSUInteger)segment \n"
            + "                      animated:(BOOL)animated;")
    public void insertSegmentWithTitle(String title, int index, boolean animated) {
        addSegment(index).setTitle(title, UIControlState.Normal);
    }

    /**
     * Inserts the specified image to the segment of the given index, using
     * animation or not.
     *
     * @param img      The image for the segment.
     * @param index    The index that specifies the segment.
     * @param animated TRUE the change is animated.
     */
    @CMSelector("- (void)insertSegmentWithImage:(UIImage *)image \n"
            + "                       atIndex:(NSUInteger)segment \n"
            + "                      animated:(BOOL)animated;")
    public void insertSegmentWithImage(UIImage img, int index, boolean animated) {
        addSegment(index, img);
    }

    private UIButton addSegment(int index) {
        return addSegment(index, null);
    }

    private class Segment extends UIButton {

        private Promise<UIImage> selectedImage;
        private Promise<UIImage> deselectedImage;

        private Segment(UIImage segmentedImage) {
            super(UIButtonType.Custom);
            setSegmentedImage(segmentedImage);
        }

        //        @Override
//        public void setHighlighted(boolean highlighted) {
//            if (highlighted)
//                setSegmentSelected(this, true, false);
//        }
        @Override
        public void drawRect(CGRect rect) {
            CGContext cx = UIGraphics.getCurrentContext();
            cx.setFillColorWithColor(lastTint.cgcolor);
            cx.beginPath();
            if (this.equals(items.get(0))) {
                cx.beginPath();
                cx.moveToPoint(rect.getOrigin().getX() + 4, rect.getOrigin().getY());
                cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY());
                cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY() + rect.getSize().getHeight());
                cx.addLineToPoint(rect.getOrigin().getX() + 4, rect.getOrigin().getY() + rect.getSize().getHeight());
                cx.addCurveToPoint(rect.getOrigin().getX() + 3, rect.getOrigin().getY() + rect.getSize().getHeight() - 1, rect.getOrigin().getX() + 1, rect.getOrigin().getY() + rect.getSize().getHeight() - 3, rect.getOrigin().getX(), rect.getOrigin().getY() + rect.getSize().getHeight() - 4);
                cx.addLineToPoint(rect.getOrigin().getX(), rect.getOrigin().getY() + 4);
                cx.addCurveToPoint(rect.getOrigin().getX() + 1, rect.getOrigin().getY() + 3, rect.getOrigin().getX() + 3, rect.getOrigin().getY() + 1, rect.getOrigin().getX() + 4, rect.getOrigin().getY());
            } else if (this.equals(items.get(items.size() - 1))) {
                cx.beginPath();
                cx.moveToPoint(rect.getOrigin().getX(), rect.getOrigin().getY());
                cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth() - 4, rect.getOrigin().getY());
                cx.addCurveToPoint(rect.getOrigin().getX() + rect.getSize().getWidth() - 3, rect.getOrigin().getY() + 1, rect.getOrigin().getX() + rect.getSize().getWidth() - 1, rect.getOrigin().getY() + 3, rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY() + 4);
                cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY() + rect.getSize().getHeight() - 4);
                cx.addCurveToPoint(rect.getOrigin().getX() + rect.getSize().getWidth() - 1, rect.getOrigin().getY() + rect.getSize().getHeight() - 3, rect.getOrigin().getX() + rect.getSize().getWidth() - 3, rect.getOrigin().getY() + rect.getSize().getHeight() - 1, rect.getOrigin().getX() + rect.getSize().getWidth() - 4, rect.getOrigin().getY() + rect.getSize().getHeight());
                cx.addLineToPoint(rect.getOrigin().getX(), rect.getOrigin().getY() + rect.getSize().getHeight());
            } else {
                cx.beginPath();
                cx.moveToPoint(rect.getOrigin().getX(), rect.getOrigin().getY());
                cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY());
                cx.addLineToPoint(rect.getOrigin().getX() + rect.getSize().getWidth(), rect.getOrigin().getY() + rect.getSize().getHeight());
                cx.addLineToPoint(rect.getOrigin().getX(), rect.getOrigin().getY() + rect.getSize().getHeight());

            }
            cx.setLineWidth(1);
            cx.setStrokeColorWithColor(lastTint.cgcolor);

            if (this.isSelected() || isHighlighted()) {
                cx.drawPath(CGPathDrawingMode.FillStroke);
                if (deselectedImage != null)
                    drawIn(cx, deselectedImage.get());
                else
                    for (UIButton item : items)
                        item.setTitleColor(lastLabelColor, UIControlState.Normal);
            } //                    setBackgroundColor(tintColor());
            else {
                if (selectedImage != null)
                    drawIn(cx, selectedImage.get());
                else
                    setBackgroundColor(null);
                for (UIButton item : items)
                    item.setTitleColor(lastTint, UIControlState.Normal);
            }
//            if (segmentImage != null)
//                cx.drawImage(new CGRect(frame.getSize().width / 2 - segmentImage.size().width / 2, frame.getSize().height / 2 - segmentImage.size().height / 2, segmentImage.size().width, segmentImage.size().height), segmentImage.getMasked(tintColor().cgcolor.color).CGImage());

            cx.drawPath(CGPathDrawingMode.Stroke);
            cx.closePath();
            super.drawRect(rect);
        }

        private boolean drawIn(CGContext cx, UIImage img) {
            if (img == null)
                return false;
            img.drawInRect(new CGRect(0, 0, getWidth(), getHeight()));
            return true;
        }

        private void setSegmentedImage(UIImage image) {
            selectedImage = image == null ? null : image.cacheTinted(true, this);
            deselectedImage = image == null ? null : image.cacheTinted(true, UIColor.whiteColor.cgcolor);
        }

        private void invalidate() {
            if (selectedImage != null)
                selectedImage.destroy();
            if (deselectedImage != null)
                deselectedImage.destroy();
        }
    }

    private UIButton addSegment(int index, final UIImage img) {
        Segment segment = new Segment(img);
//        segment.titleLabel().setShadowColor(UIColor.blackColor());
//        segment.setAdjustsImageWhenHighlighted(true);
        int cindex = (index < 0) ? 0 : ((index > items.size()) ? items.size() : index);

        segment.setTag(index);
        segment.addTarget(touchDowmDelegate, UIControlEvents.TouchDown);
        segment.addTarget(touchUpDelegate, UIControlEvents.TouchUpInside);
        segment.addTarget(touchUpDelegate, UIControlEvents.TouchUpOutside);
        items.add(cindex, segment);
        if (selection >= cindex)
            selection++;
        if (!deferupdate)
            layoutSubviews();

        return segment;
    }

    @Override
    public void tintColorDidChange() {
        super.tintColorDidChange();
        for (Segment segment : items)
            segment.invalidate();
    }

    /**
     * Removes all the segments.
     */
    @CMSelector("- (void)removeAllSegments;")
    public void removeAllSegments() {
        items.clear();
        setSelectedSegmentIndex(-1);
        layoutSubviews();
    }

    /**
     * Removes the segment at the specified index using animation or not.
     *
     * @param index    The index that specifies the segment.
     * @param animated TRUE the change is animated.
     */
    @CMSelector("- (void)removeSegmentAtIndex:(NSUInteger)segment \n"
            + "                    animated:(BOOL)animated;")
    public void removeSegmentAtIndex(int index, boolean animated) {
        if (selection > index)
            selection--;
        else if (selection == index)
            setSelectedSegmentIndex(-1);
        items.remove(index);
        layoutSubviews();
    }

    /**
     * Returns the number of segments.
     *
     * @return The number of segments.
     */
    @CMGetter("@property(nonatomic, readonly) NSUInteger numberOfSegments;")
    public int numberOfSegments() {
        return items.size();
    }

    /**
     * Returns the index of the selected segment.
     *
     * @return The index of the selected segment.
     */
    @CMGetter("@property(nonatomic) NSInteger selectedSegmentIndex;")
    public int selectedSegmentIndex() {
        return selection;
    }

    /**
     * Sets the index for the selected segment.
     *
     * @param index The index of the selected segment.
     */
    @CMSetter("@property(nonatomic) NSInteger selectedSegmentIndex;")
    public void setSelectedSegmentIndex(int index) {
        if (index < 0 || index >= items.size())
            index = -1;
        if (this.selection == index)
            return;
        if (selection >= 0)
            items.get(selection).setSelected(false);
        this.selection = index;
        if (selection >= 0)
            items.get(selection).setSelected(true);
        sendActionsForControlEvents(UIControlEvents.ValueChanged);
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns the style of the segmented control.
     *
     * @return The style of the segmented control.
     */
    @CMGetter("@property(nonatomic) UISegmentedControlStyle segmentedControlStyle;")
    @Deprecated
    public int segmentedControlStyle() {
        return style;
    }

    /**
     * Sets the style of the segmented control.
     *
     * @param UISegmentedControlStyle The style of the segmented control.
     * @see crossmobile.ios.uikit.UISegmentedControlStyle
     */
    @CMSetter("@property(nonatomic) UISegmentedControlStyle segmentedControlStyle;")
    @Deprecated
    public void setSegmentedControlStyle(int UISegmentedControlStyle) {
        this.style = UISegmentedControlStyle;
        // frame.getSize().height = (style ==
        // UISegmentedControlStyle.UISegmentedControlStyleBar) ?
        // kSegmentedControlHeightBar : kSegmentedControlHeightDefault;
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns a Boolean that show whether segments show the selected state.
     *
     * @return A Boolean that show whether segments show the selected state.
     */
    @CMGetter("@property(nonatomic, getter=isMomentary) BOOL momentary;")
    public boolean isMomentary() {
        return momentary;
    }

    /**
     * Sets a Boolean that defines whether segments show the selected state.
     *
     * @param momentary A Boolean that defines whether segments show the
     *                  selected state.
     */
    @CMSetter("@property(nonatomic, getter=isMomentary) BOOL momentary;")
    public void setMomentary(boolean momentary) {
        if (this.momentary == momentary)
            return;
        this.momentary = momentary;
    }

    @Override
    public void layoutSubviews() {
        if (items == null) // be safe with early initialization, due to overriding of setFrame method
            return;
        for (UIView v : subviews())
            v.removeFromSuperview();

        if (items.size() < 1)
            return;
        Native.system().runAndWaitOnEventThread(() -> {
            CGRect frame1 = frame();
            int actualX = 0;
            int actualWidth;
            double xRunner = 0;
            double desiredWidth = frame1.getSize().getWidth() / (items.size() > 0 ? items.size() : 1);
            double height = frame1.getSize().getHeight();
            int itemmax = items.size() - 1;
            for (int i = 0; i <= itemmax; i++) {
                UIButton button = items.get(i);
                /* Update metrics */
                xRunner += desiredWidth;
                actualWidth = (int) (xRunner - actualX + 0.5);
                button.setFrame(new CGRect(actualX, 0, actualWidth, height));
                addSubview(button);
                actualX += actualWidth;

            }
            Native.graphics().refreshDisplay();
        });
    }

    @Override
    public final void drawRect(CGRect rect) {
        UIColor lastLastTint = lastTint;
        lastTint = tintColor();
        double[] hsva = Native.graphics().colorRGBAtoHSVA($coregraphics.color(lastTint.cgcolor));
        lastLabelColor = hsva[2] > 0.5 ? UIColor.blackColor() : UIColor.whiteColor();
        super.drawRect(rect);
    }

}
