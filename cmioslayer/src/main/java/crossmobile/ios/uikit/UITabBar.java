/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.List;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;

/**
 * UITabBar class defines a tab-bar object that visually consists of buttons
 * named tab bar items that provide one-tap access to specific set of views of
 * the application.
 */
@CMClass
public class UITabBar extends UIView {

    private UITabBarDelegate delegate;
    private List<UITabBarItem> items;
    private int selectedIndex = -1;

    private UIImage backgroundImage;
    private UIColor selectedImageTintColor;
    private UIImage selectionIndicatorImage;
    private UIImage shadowImage;
    private int barStyle;
    private double itemSpacing;
    private double itemWidth;
    private int itemPositioning = UITabBarItemPositioning.Automatic;
    private boolean translucent;

    /* For connectivity with UITabBarController */
    UITabBarController tbcontrol;

    /**
     * Constructs a default UITabBar object located at (0,0) with 0 weight and 0
     * height.
     */
    public UITabBar() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UITabBar object initialized with the dimensions and position
     * specified in the rect parameter and the default cyan background color.
     *
     * @param rect CGRect that defines dimension and position of UITabBar.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UITabBar(CGRect rect) {
        super(rect, UIColor.cyanColor);
        setAutoresizesSubviews(false);
    }

    /**
     * Returns the background image of this tab bar.
     *
     * @return The background image.
     */
    @CMGetter("@property(nonatomic, strong) UIImage *backgroundImage;")
    public UIImage backgroundImage() {
        return backgroundImage;
    }

    /**
     * Sets the background image for this tab bar.
     *
     * @param backgroundImage The background image.
     */
    @CMSetter("@property(nonatomic, strong) UIImage *backgroundImage;")
    public void setBackgroundImage(UIImage backgroundImage) {
        this.backgroundImage = backgroundImage;
        setNeedsDisplay();
    }

    /**
     * Returns the tint color of the tab bar's background.
     *
     * @return The tint color of the tab bar's background.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *barTintColor;")
    public UIColor barTintColor() {
        UIColor backColor = backgroundColor();
        return backColor == null ? null : new UIColor((color(backColor.cgcolor) & 0xffffff) | 0xff000000);
    }

    /**
     * Sets the background tint color of this tab bar.
     *
     * @param tintColor Tint color for the background.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *barTintColor;")
    public void setBarTintColor(UIColor tintColor) {
        if (tintColor == null)
            setBackgroundColor(null);
        else
            setBackgroundColor(new UIColor(Native.graphics().colorWithAlpha(color(tintColor.cgcolor), translucent ? Theme.Bar.TRANSLUCENCY : 1)));
        setNeedsDisplay();
    }

    /**
     * Returns the tint color of the selected tab bar item.
     *
     * @return The tint color of the selected tab bar item.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, strong) UIColor *selectedImageTintColor;")
    public UIColor selectedImageTintColor() {
        return selectedImageTintColor;
    }

    /**
     * Sets the tint color of the selected tab bar item of this tab bar.
     *
     * @param selectedImageTintColor Tint color for the selected tab bar item.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, strong) UIColor *selectedImageTintColor;")
    public void setSelectedImageTintColor(UIColor selectedImageTintColor) {
        this.selectedImageTintColor = selectedImageTintColor;
        setNeedsDisplay();
    }

    /**
     * Returns the image used for the selection indicator.
     *
     * @return Image used for the selection indicator.
     */
    @CMGetter("@property(nonatomic, strong) UIImage *selectionIndicatorImage;")
    public UIImage selectionIndicatorImage() {
        return selectionIndicatorImage;
    }

    /**
     * Sets the image used for the selection indicator.
     *
     * @param selectionIndicatorImage Image used for the selection indicator.
     */
    @CMSetter("@property(nonatomic, strong) UIImage *selectionIndicatorImage;")
    public void setSelectionIndicatorImage(UIImage selectionIndicatorImage) {
        this.selectionIndicatorImage = selectionIndicatorImage;
        setNeedsDisplay();
    }

    /**
     * Returns the shadow image of this tab bar.
     *
     * @return The shadow image of the tab bar.
     */
    @CMGetter("@property(nonatomic, strong) UIImage *shadowImage;")
    public UIImage shadowImage() {
        return shadowImage;
    }

    /**
     * Sets the shadow image of this tab bar.
     *
     * @param shadowImage The shadow image of the tab bar.
     */
    @CMSetter("@property(nonatomic, strong) UIImage *shadowImage;")
    public void setShadowImage(UIImage shadowImage) {
        this.shadowImage = shadowImage;
        setNeedsDisplay();
    }

    /**
     * Returns a Boolean that shows whether this tab bar is semi-transparent.
     *
     * @return TRUE then the tab bar is semi-transparent.
     */
    @CMGetter("@property(nonatomic, getter=isTranslucent) BOOL translucent;")
    public boolean isTranslucent() {
        return translucent;
    }

    /**
     * Sets a Boolean that defines whether this tab bar is semi-transparent.
     *
     * @param translucent TRUE then the tab bar is semi-transparent.
     */
    @CMSetter("@property(nonatomic, getter=isTranslucent) BOOL translucent;")
    public void setTranslucent(boolean translucent) {
        if (translucent != this.translucent) {
            this.translucent = translucent;
            setBarTintColor(backgroundColor());
            if (tbcontrol != null)
                tbcontrol.updateView();
        }
    }

    /**
     * Returns the style of this tab bar.
     *
     * @return The style of this tab bar.
     * @see crossmobile.ios.uikit.UIBarStyle
     */
    @CMGetter("@property(nonatomic) UIBarStyle barStyle;")
    public int barStyle() {
        return barStyle;
    }

    /**
     * Sets the style of this tab bar.
     *
     * @param barStyle The style of this tab bar.
     * @see crossmobile.ios.uikit.UIBarStyle
     */
    @CMSetter("@property(nonatomic) UIBarStyle barStyle;")
    public void setBarStyle(int barStyle) {
        this.barStyle = barStyle;
        setNeedsDisplay();
    }

    /**
     * Returns the positioning scheme of the items in this tab bar.
     *
     * @return The positioning scheme of the items in this tab bar.
     * @see crossmobile.ios.uikit.UITabBarItemPositioning
     */
    @CMGetter("@property(nonatomic) UITabBarItemPositioning itemPositioning;")
    public int itemPositioning() {
        return itemPositioning;
    }

    /**
     * Sets the positioning scheme of the items in this tab bar.
     *
     * @param UITabBarItemPositioning The positioning scheme of the items in
     *                                this tab bar.
     * @see crossmobile.ios.uikit.UITabBarItemPositioning
     */
    @CMSetter("@property(nonatomic) UITabBarItemPositioning itemPositioning;")
    public void setItemPositioning(int UITabBarItemPositioning) {
        this.itemPositioning = UITabBarItemPositioning;
        layoutSubviews();
    }

    /**
     * Returns the inter-item spacing of this tab bar expressed in points.
     *
     * @return The inter-item spacing of this tab bar expressed in points.
     */
    @CMGetter("@property(nonatomic) CGFloat itemSpacing;")
    public double itemSpacing() {
        return itemSpacing;
    }

    /**
     * Sets the inter-item spacing of this tab bar expressed in points.
     *
     * @param itemSpacing The inter-item spacing of this tab bar expressed in
     *                    points.
     */
    @CMSetter("@property(nonatomic) CGFloat itemSpacing;")
    public void setItemSpacing(double itemSpacing) {
        if (itemSpacing < 0)
            itemSpacing = 0;
        this.itemSpacing = itemSpacing;
        layoutSubviews();
    }

    /**
     * Returns the width of the center-styled items of the tab bar expressed in
     * points.
     *
     * @return The width of the center-styled items of the tab bar expressed in
     * points.
     */
    @CMGetter("@property(nonatomic) CGFloat itemWidth;")
    public double itemWidth() {
        return itemWidth;
    }

    /**
     * Sets the width of the center-styled items of the tab bar expressed in
     * points.
     *
     * @param itemWidth The width of the center-styled items of the tab bar
     *                  expressed in points.
     */
    @CMSetter("@property(nonatomic) CGFloat itemWidth;")
    public void setItemWidth(double itemWidth) {
        this.itemWidth = itemWidth;
        layoutSubviews();
    }

    /**
     * Returns the delegate object of the tab bar.
     *
     * @return Tab bar’s delegate object.
     */
    @CMGetter("@property(nonatomic, weak) id<UITabBarDelegate> delegate;")
    public UITabBarDelegate delegate() {
        return delegate;
    }

    /**
     * Set the delegate object of this tab bar.
     *
     * @param delegate Tab bar’s delegate object.
     */
    @CMSetter("@property(nonatomic, weak) id<UITabBarDelegate> delegate;")
    public void setDelegate(UITabBarDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Presents a modal view that allows the user to add, remove, and rearrange
     * items on this tab bar.
     *
     * @param items The items that can be customized.
     */
    @CMSelector("- (void)beginCustomizingItems:(NSArray<UITabBarItem *> *)items;")
    public void beginCustomizingItems(List<UITabBarItem> items) {
        if (delegate != null)
            delegate.willBeginCustomizingItems(this, items);
        if (delegate != null)
            delegate.didBeginCustomizingItems(this, items);
    }

    /**
     * Dismisses the modal dialog that customizes the tab bar items with the
     * option to use animation.
     *
     * @param animated TRUE then animation is used.
     * @return TRUE if the items on the tab bar changed
     */
    @CMSelector("- (BOOL)endCustomizingAnimated:(BOOL)animated;")
    public boolean endCustomizingAnimated(boolean animated) {
        boolean changed = false;
        if (delegate != null)
            delegate.willEndCustomizingItems(this, items, changed);
        if (delegate != null)
            delegate.didEndCustomizingItems(this, items, changed);
        return changed;
    }

    /**
     * Returns a Boolean value that shows if the user is customizing the tab
     * bar.
     *
     * @return Boolean value that shows if the user is customizing the tab bar.
     */
    @CMSelector("- (BOOL)isCustomizing;")
    public boolean isCustomizing() {
        return false;
    }

    /**
     * Returns the items displayed on this tab bar.
     *
     * @return List of the items displayed on this tab bar.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<UITabBarItem *> *items;")
    public List<UITabBarItem> items() {
        return new ArrayList<>(items);
    }

    /**
     * Set the items on this tab bar without animation.
     *
     * @param items Items to be displayed on the tab bar.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<UITabBarItem *> *items;")
    public void setItems(List<UITabBarItem> items) {
        setItems(items, false);
    }

    /**
     * Sets the items on the tab bar, using or not animation during the
     * transition.
     *
     * @param items    Items to be displayed on the tab bar.
     * @param animated If true, display items with the transition.
     */
    @CMSelector("- (void)setItems:(NSArray<UITabBarItem *> *)items \n"
            + "        animated:(BOOL)animated;")
    public void setItems(List<UITabBarItem> items, boolean animated) {
        this.items = items;
        if (items != null)
            for (UITabBarItem item : items)
                item.setButtonDelegate(() -> setSelectedItem(item));
        setSelectedIndex(items == null || items.isEmpty() ? -1 : 0);
        layoutSubviews();
    }

    /**
     * Returns the currently selected item of the tab bar.
     *
     * @return The currently selected item.
     */
    @CMGetter("@property(nonatomic, weak) UITabBarItem *selectedItem;")
    public UITabBarItem selectedItem() {
        return selectedIndex < 0 || items == null || items.isEmpty() ? null : items.get(selectedIndex);
    }

    /**
     * Sets as currently selected item of the tab bar the item passed as
     * parameter.
     *
     * @param selectedItem The currently selected item of the tab bar.
     */
    @CMSetter("@property(nonatomic, weak) UITabBarItem *selectedItem;")
    public void setSelectedItem(UITabBarItem selectedItem) {
        if (selectedItem == null || items == null)
            return;
        setSelectedIndex(items.indexOf(selectedItem));
    }

    @Override
    public void layoutSubviews() {
        if (items == null || items.size() < 1)
            return;

        CGRect newFrame = new CGRect(cframe().getOrigin().getX(), cframe().getOrigin().getY(), cframe().getSize().getWidth(), cframe().getSize().getHeight());
        double width = newFrame.getSize().getWidth() / items.size();
        newFrame.getSize().setWidth(width - 1);
        newFrame.getOrigin().setY(0);
        for (int i = 0; i < items.size(); i++) {
            UITabBarItem item = items.get(i);
            UIView view = item.view();
            if (view.superview() != this)
                addSubview(view);
            newFrame.getOrigin().setX(width * i);
            view.setFrame(newFrame);
        }
        Native.graphics().refreshDisplay();
    }

    // this method should always have a valid entry
    void setSelectedIndex(int newIndex) {
        if (newIndex != selectedIndex) {
            selectedIndex = newIndex;// First this
            if (selectedIndex >= 0) {
                if (tbcontrol != null)
                    tbcontrol.setSelectedIndex(selectedIndex); // cycle prevention since value is already checked
                if (delegate != null)
                    delegate.didSelectItem(this, items.get(selectedIndex));
            }
            Native.graphics().refreshDisplay();
        }
    }
}
