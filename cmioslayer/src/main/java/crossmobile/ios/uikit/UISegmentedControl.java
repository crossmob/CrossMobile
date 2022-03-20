/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.theme.PainterExtraData;
import org.crossmobile.bind.graphics.theme.SegmentedPainter;
import org.crossmobile.bind.graphics.theme.ThemeUtilities;
import org.crossmobile.bind.system.Promise;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.List;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;

/**
 * UISegmentedControl class defines an object that is used in order to provide
 * custom control for special occasions, for example switching between views.
 * Visually it is depicted as a set of sectors (buttons or images) that
 * correspond to controls, placed horizontally.
 */
@CMClass
public class UISegmentedControl extends UIControl {

    private int selection = -1;
    private final List<Segment> items = new ArrayList<>();
    private int style = UISegmentedControlStyle.Plain;
    private boolean momentary = false;

    private final UIControlDelegate touchDownDelegate = (sender, event) -> setSelectedSegmentIndex(sender.tag());
    private final UIControlDelegate touchUpDelegate = (sender, event) -> {
        if (momentary && selection >= 0) {
            items.get(selection).setSelected(false);
            selection = -1;
        }
    };
    private final PainterExtraData extraData;

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
        extraData = painter().initExtraData();
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
    public UISegmentedControl(List<?> items) {
        if (items != null && !items.isEmpty()) {
            for (int i = 0; i < items.size(); i++)
                if (items.get(i) instanceof String)
                    insertSegmentWithTitle((String) items.get(i), i, false);
                else if (items.get(i) instanceof UIImage)
                    insertSegmentWithImage((UIImage) items.get(i), i, false);
        }
        extraData = painter().initExtraData();
    }

    @SuppressWarnings("unchecked")
    private SegmentedPainter<PainterExtraData> painter() {
        return (SegmentedPainter<PainterExtraData>) painter;
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

    private UIButton addSegment(int index, final UIImage img) {
        Segment segment = new Segment(img);
        int cindex = (index < 0) ? 0 : ((index > items.size()) ? items.size() : index);

        segment.setTag(index);
        segment.addTarget(touchDownDelegate, UIControlEvents.TouchDown);
        segment.addTarget(touchUpDelegate, UIControlEvents.TouchUpInside);
        segment.addTarget(touchUpDelegate, UIControlEvents.TouchUpOutside);
        items.add(cindex, segment);
        if (selection >= cindex)
            selection++;
        setNeedsLayout();
        return segment;
    }

    /**
     * Removes all the segments.
     */
    @CMSelector("- (void)removeAllSegments;")
    public void removeAllSegments() {
        items.clear();
        setSelectedSegmentIndex(-1);
        setNeedsLayout();
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
        setNeedsLayout();
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
        setNeedsDisplay();
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
        setNeedsDisplay();
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
        this.momentary = momentary;
    }

    @Override
    public void layoutSubviews() {
        if (items.size() < 1)
            return;
        for (UIView v : subviews())
            v.removeFromSuperview();
        Native.lifecycle().runAndWaitOnEventThread(() -> {
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
            setNeedsDisplay();
        });
    }

    private class Segment extends UIButton {

        private Promise<UIImage> selectedImage;
        private Promise<UIImage> deselectedImage;

        private Segment(UIImage segmentedImage) {
            super(UIButtonType.Custom);
            setSegmentedImage(segmentedImage);
        }

        @Override
        public void tintColorDidChange() {
            super.tintColorDidChange();
            if (selectedImage != null)
                selectedImage.destroy();
            if (deselectedImage != null)
                deselectedImage.destroy();

            UIColor normal = tintColor();
            UIColor selected = ThemeUtilities.isDark(color(normal.cgcolor)) ? UIColor.whiteColor() : UIColor.blackColor();
            setTitleColor(normal, UIControlState.Normal);
            setTitleColor(selected, UIControlState.Selected);
            setTitleColor(selected, UIControlState.Highlighted);
        }

        @Override
        public void drawRect(CGRect rect) {
            if (this.equals(items.get(0)))
                painter().setAsFirstSegment(extraData);
            else if (this.equals(items.get(items.size() - 1)))
                painter().setAsLastSegment(extraData);
            else
                painter().setAsMiddleSegment(extraData);
            Promise<UIImage> current = isSelected() ? selectedImage : deselectedImage;
            painter().setSegmentImage(current == null ? null : current.get(), extraData);
            painter().draw(this, rect, extraData);
            super.drawRect(rect);
        }

        private void setSegmentedImage(UIImage image) {
            selectedImage = image == null ? null : image.cacheTinted(true, this);
            deselectedImage = image == null ? null : image.cacheTinted(true, UIColor.whiteColor.cgcolor);
        }
    }
}
