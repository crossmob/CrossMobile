/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bind.graphics.UIStatusBar;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.uikit.UIToolbar.fillBackground;

/**
 * The UINavigationBar class creates a bar located at the top of the screen.
 * These buttons provide functions for navigating back and forward.
 */
@CMClass
public class UINavigationBar extends UIView {

    private UINavigationBarDelegate delegate;
    private WeakReference<UINavigationController> nbcontroller;
    private List<UINavigationItem> items = new ArrayList<>();
    private boolean translucent = Theme.Bar.ISTRANSLUCENT;
    private int barStyle;
    private UIColor barTintColor;
    private int[] barGradient;
    Map<String, Object> titleTextAttributes;
    private UIBarButtonItem originalLeft;

    /**
     * Constructs a default UINavigation object located at (0,0) with 0 weight
     * and 0 height.
     */
    public UINavigationBar() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UINavigationBar object initialized with the dimensions and
     * position specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of UINavigationBar
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UINavigationBar(CGRect rect) {
        super(rect);
        setBarTintColor(Theme.Color.BARBACK);
    }

    /**
     * Pushes the given item into this stack.
     *
     * @param item     The item to be pushed in the stack.
     * @param animated Boolean defining whether there will be animated change of
     *                 the bar after the insertion of the item in the stack.
     */
    @CMSelector("- (void)pushNavigationItem:(UINavigationItem *)item \n"
            + "                  animated:(BOOL)animated;")
    public void pushNavigationItem(UINavigationItem item, boolean animated) {
        if (delegate != null)
            if (!delegate.shouldPushItem(this, item))
                return;
        items.add(item);
        item.setToolbar(this);
        layoutSubviews();
        if (delegate != null)
            delegate.didPushItem(this, item);
    }

    /**
     * Pops the item at the top of the stack showing animated the change of the
     * stack or not according to the given parameter.
     *
     * @param animated A Boolean that defines whether the pop change of the
     *                 stack is animated.
     * @return The stack after the pop action.
     */
    @CMSelector("- (UINavigationItem *)popNavigationItemAnimated:(BOOL)animated;")
    public UINavigationItem popNavigationItemAnimated(boolean animated) {
        if (delegate != null)
            if (!delegate.shouldPopItem(this, null))
                return null;
        UINavigationItem pop = items.get(items.size() - 1);
        items.remove(items.size() - 1);
        pop.setToolbar(this);
        layoutSubviews();
        if (delegate != null)
            delegate.didPopItem(this, pop);
        return pop;
    }

    /**
     * The given items replace the items of this navigation bar without
     * animation on change.
     *
     * @param items The times to replace the original items of the navigation
     *              bar.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<UINavigationItem *> *items;")
    public void setItems(List<UINavigationItem> items) {
        setItems(items, false);
    }

    /**
     * The given items replace the original items of this navigation bar either
     * with animation on change or not according to the given parameter.
     *
     * @param items    The items to replace the original in this navigation bar.
     * @param animated A Boolean that defines whether the change of items is
     *                 animated or not.
     */
    @CMSelector("- (void)setItems:(NSArray<UINavigationItem *> *)items \n"
            + "        animated:(BOOL)animated;")
    public void setItems(List<UINavigationItem> items, boolean animated) {
        this.items = items;
        for (UINavigationItem item : items)
            item.setToolbar(this);
        layoutSubviews();
    }

    /**
     * Returns the delegate object of the navigation bar.
     *
     * @return The delegate object of the navigation bar.
     */
    @CMGetter("@property(nonatomic, weak) id<UINavigationBarDelegate> delegate;")
    public UINavigationBarDelegate delegate() {
        return delegate;
    }

    /**
     * Sets as the delegate object of this navigation bar the one given.
     *
     * @param delegate The delegate object of the navigation bar.
     */
    @CMSetter("@property(nonatomic, weak) id<UINavigationBarDelegate> delegate;")
    public void setDelegate(UINavigationBarDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the top item at the list of the navigation bar
     *
     * @return The top item at the navigation bar.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UINavigationItem *topItem;")
    public UINavigationItem topItem() {
        if (items == null || items.isEmpty())
            return null;
        return items.get(items.size() - 1);
    }

    /**
     * Returns the item right after the top item of the navigation bar.
     *
     * @return The time after the top item of the navigation bar.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UINavigationItem *backItem;")
    public UINavigationItem backItem() {
        return items.get(items.size() - 2);
    }

    /**
     * Returns the list of the items of this navigation bar.
     *
     * @return The list of the items.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<UINavigationItem *> *items;")
    public List<UINavigationItem> items() {
        return items;
    }

    void backClicked() {
        if (nbcontroller != null && nbcontroller.get() != null)
            nbcontroller.get().popViewControllerAnimated(true);
        else
            popNavigationItemAnimated(true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void layoutSubviews() {
        synchronized (this) {
            UINavigationItem item = topItem();
            if (item == null)
                return;

            // First clear lists and find metrics
            for (UIView old : subviews())
                old.removeFromSuperview();
            double statusBarOffset = UIApplication.sharedApplication().isStatusBarHidden() ? 0 : UIStatusBar.HEIGHT;
            double leftOffset = initLeftItem(item, statusBarOffset);
            double rightOffset = initRightItem(item, statusBarOffset);
            double topOffset = Theme.Bar.Nav.HEIGHTOFFSET + statusBarOffset;
            double widheight = cframe().getSize().getHeight() - topOffset - Theme.Bar.Nav.HEIGHTOFFSET;

            {   // Create title
                UIView title = item.effectiveTitleView();
                addSubview(title);
//                leftOffset = 0;
                if (title != null) {
                    CGSize newSize;
                    if (title instanceof UILabel)
                        newSize = title.intrinsicContentSize();
                    else if (title instanceof UIImageView)
                        newSize = ((UIImageView) title).image() == null ? new CGSize(0, 0) : ((UIImageView) title).image().size();
                    else
                        newSize = new CGSize(title.cframe().getSize().getWidth(), title.cframe().getSize().getHeight());
                    CGRect newFrame;
                    int titleOffset = Theme.Bar.Nav.TITLEOFFSET;
                    if (!item.leftSetByUser && items.size() > 1 && (items.get(items.size() - 2).effectiveTitleView() instanceof UILabel)) {
                        String prevTtitle = ((UILabel) items.get(items.size() - 2).effectiveTitleView()).text();
                        if (prevTtitle != null)
                            item.setLeftBarButtonItem((!"".equals(prevTtitle.trim())) ? new UIBarButtonItem((Native.graphics().getBackChar() + " " + prevTtitle), UIBarButtonItemStyle.Plain, this::backClicked) : null, false, false);
                        item.backBarButtonItem().customView().removeFromSuperview();
                        leftOffset = initLeftItem(item, statusBarOffset);
                    } else if (!item.leftSetByUser && items.size() > 1 && !(items.get(items.size() - 2).effectiveTitleView() instanceof UILabel)) {
                        item.setLeftBarButtonItem(null, false, false);
                        item.backBarButtonItem().customView().removeFromSuperview();
                        leftOffset = initLeftItem(item, statusBarOffset);
                    } else if (!item.leftSetByUser && items.size() > 1 && !(items.get(items.size() - 2).effectiveTitleView() instanceof UILabel)) {
                        item.setLeftBarButtonItem(new UIBarButtonItem(Native.graphics().getBackChar(), UIBarButtonItemStyle.Plain, this::backClicked), false, false);
                        item.backBarButtonItem().customView().removeFromSuperview();
                    }
                    if (!item.leftSetByUser && items.size() > 1 && cframe().getSize().getWidth() - leftOffset - rightOffset - newSize.getWidth() - titleOffset * 2 < 0 && item.leftBarButtonItem() != null) {
                        item.leftBarButtonItem().customView().removeFromSuperview();
                        item.setLeftBarButtonItem(null, false, false);
                        leftOffset = initLeftItem(item, statusBarOffset);
                    }
                    if (!item.leftSetByUser && items.size() > 1 && cframe().getSize().getWidth() - leftOffset - rightOffset - newSize.getWidth() - titleOffset * 2 < 0 && item.leftBarButtonItem() == null) {
                        item.setLeftBarButtonItem(new UIBarButtonItem(Native.graphics().getBackChar(), UIBarButtonItemStyle.Plain, this::backClicked), false, false);
                        item.backBarButtonItem().customView().removeFromSuperview();
                        leftOffset = initLeftItem(item, statusBarOffset);
                    }
                    if (cframe().getSize().getWidth() - leftOffset - rightOffset - newSize.getWidth() - titleOffset * 2 < 0)
                        if (title instanceof UIImageView)
                            newFrame = new CGRect(leftOffset + titleOffset, topOffset, ((UIImageView) title).image().size().getWidth(), ((UIImageView) title).image().size().getHeight());
                        else
                            newFrame = new CGRect(leftOffset + titleOffset, topOffset, cframe().getSize().getWidth() - leftOffset - rightOffset - titleOffset * 2, widheight);
                    else if (cframe().getSize().getWidth() / 2 - newSize.getWidth() / 2 - leftOffset - titleOffset < 0)
                        newFrame = new CGRect(leftOffset + titleOffset, topOffset, newSize.getWidth(), widheight);
                    else if (cframe().getSize().getWidth() / 2 - newSize.getWidth() / 2 - rightOffset - titleOffset < 0)
                        newFrame = new CGRect(cframe().getSize().getWidth() - rightOffset - titleOffset - newSize.getWidth(), topOffset, newSize.getWidth(), widheight);
                    else
                        newFrame = new CGRect(cframe().getSize().getWidth() / 2 - newSize.getWidth() / 2, topOffset, newSize.getWidth(), widheight);
                    title.setFrame(newFrame);
                }
            }
            {   // Create prompt
                UILabel prompt = item.promptView();
                if (prompt != null) {
                    // this is wrong, should be below title
                    prompt.setFrame(new CGRect(leftOffset, topOffset, cframe().getSize().getWidth() - rightOffset - leftOffset, widheight));
                    addSubview(prompt);
                }
            }

            setNeedsDisplay();
        }
    }

    private double initLeftItem(UINavigationItem item, double statusOffset) {   // Create left button item
        UIBarButtonItem left = item.leftBarButtonItem() != null ? item.leftBarButtonItem() : (items.size() > 1 && !item.hidesBackButton() ? item.backBarButtonItem() : null);
        if (left != null) {
            UIView c = left.view();
            addSubview(c);
            c.setFrame(new CGRect(0, statusOffset,
                    c.intrinsicContentSize.getWidth() + 2 * Theme.Bar.Nav.EDGEOFFSET,
                    cframe().getSize().getHeight() - statusOffset));
            return left.width();
        }
        return 0;
    }

    private double initRightItem(UINavigationItem item, double statusOffset) {   // Create right button item
        UIBarButtonItem right = item.rightBarButtonItem();
        if (right != null) {
            UIView c = right.view();
            addSubview(c);
            double width = c.intrinsicContentSize.getWidth() + 2 * Theme.Bar.Nav.EDGEOFFSET;
            c.setFrame(new CGRect(cframe().getSize().getWidth() - width, statusOffset,
                    width, cframe().getSize().getHeight() - statusOffset));
            return width;
        }
        return 0;
    }

    /**
     * Returns the style of this navigation bar.
     *
     * @return The style of the navigation bar.
     */
    @CMGetter("@property(nonatomic, assign) UIBarStyle barStyle;")
    public int barStyle() {
        return barStyle;
    }

    /**
     * Sets the style of the navigation bar as defined by the parameter.
     *
     * @param UIBarStyle The parameter that defines the style of the navigation
     *                   bar.s
     */
    @CMSetter("@property(nonatomic, assign) UIBarStyle barStyle;")
    public void setBarStyle(int UIBarStyle) {
        this.barStyle = UIBarStyle;
        layoutSubviews();
    }

    /**
     * Returns the tint color of the navigation bar's background.
     *
     * @return The tint color of the navigation bar's background.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *barTintColor;\n"
            + "")
    public UIColor barTintColor() {
        return new UIColor((color(barTintColor.cgcolor) & 0xffffff) | 0xff000000);
    }

    /**
     * Sets the tint color of navigation bar's background.
     *
     * @param tintColor The tint color of the navigation bar's background.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *barTintColor;")
    public void setBarTintColor(UIColor tintColor) {
        setBarTintColor(color(tintColor.cgcolor));
    }

    private void setBarTintColor(int tintColor) {
        barTintColor = new UIColor(Native.graphics().colorWithAlpha(tintColor, translucent ? Theme.Bar.TRANSLUCENCY : 1));
        barGradient = Theme.Color.getBarGradientColors(barTintColor);
        setNeedsDisplay();
    }

    /**
     * Returns a value that shows whether the navigation bar is translucent or
     * not.
     *
     * @return A Boolean that shows if the navigation bar is translucent or not.
     */
    @CMGetter("@property(nonatomic, assign, getter=isTranslucent) BOOL translucent;")
    public boolean isTranslucent() {
        return translucent;
    }

    /**
     * Sets the specified attributes for the bar’s title text.
     *
     * @param titleTextAttributes The attributes of the title.
     */
    @CMSetter("@property(nonatomic, copy) NSDictionary<NSString *,id> *titleTextAttributes;")
    public void setTitleTextAttributes(Map<String, Object> titleTextAttributes) {
        this.titleTextAttributes = titleTextAttributes == null ? null : new HashMap<>(titleTextAttributes);
        for (UINavigationItem item : items)
            item.updateTextAttributes(titleTextAttributes);
    }

    /**
     * Returns the attributes of the bar's title text.
     *
     * @return The attributes of the title.
     */
    @CMGetter("@property(nonatomic, copy) NSDictionary<NSString *,id> *titleTextAttributes;")
    public Map<String, Object> titleTextAttributes() {
        return titleTextAttributes == null ? null : new HashMap<>(titleTextAttributes);
    }

    /**
     * Sets navigation bar state as translucent or not according to the
     * parameter.
     *
     * @param translucent A Boolean that defines if the navigation bar is
     *                    translucent or not.
     */
    @CMSetter("@property(nonatomic, assign, getter=isTranslucent) BOOL translucent;")
    public void setTranslucent(boolean translucent) {
        UINavigationController nc = nbcontroller.get();
        if (nc != null && translucent != this.translucent) {
            nc.renewInsets(true);
            this.translucent = translucent;
            nc.renewInsets(false);
            setBarTintColor(barTintColor);
            updateBar();
        }
    }

    @Override
    public void setHidden(boolean hidden) {
        super.setHidden(hidden);
        updateBar();
    }

    void setNavigationController(UINavigationController nc) {
        nbcontroller = nc == null ? null : new WeakReference<>(nc);
    }

    private void updateBar() {
        UINavigationController nbc = nbcontroller == null ? null : nbcontroller.get();
        if (nbc != null && nbc.isViewLoaded())
            nbc.view().layoutSubviews();
    }

    @Override
    public final void drawRect(CGRect rect) {
        fillBackground(barTintColor, barGradient, rect.getOrigin().getX(), rect.getOrigin().getY(), rect.getSize().getWidth(), rect.getSize().getHeight());
    }

    @SuppressWarnings("deprecation")
    void fixMetricsForStatusBar(UIViewController container, UIView parent) {
        UIEdgeInsets insets = container.getActiveInsets();
        setFrameImpl(insets.getLeft(),
                insets.getTop(),
                parent.cframe().getSize().getWidth(),
                Theme.Bar.Nav.HEIGHTNORMAL + (!UIApplication.sharedApplication().isStatusBarHidden() ? UIStatusBar.HEIGHT : 0));
        layoutSubviews();
    }
}
