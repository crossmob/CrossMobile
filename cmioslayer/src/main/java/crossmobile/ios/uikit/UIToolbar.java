/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.coregraphics.GraphicsDrill.context;

/**
 * UIToolbar class defines a toolbar that visually consists of buttons named
 * items that provide quick access to specific functions of the application. An
 * item when tapped either changes the appearance instantly or not. *
 */
@CMClass
public class UIToolbar extends UIView {

    private List<UIBarButtonItem> items = new ArrayList<>();
    private boolean translucent = Theme.Bar.ISTRANSLUCENT;
    private int barStyle;
    private UIColor barTintColor;
    private int[] barGradient;
    private WeakReference<UINavigationController> nbcontroller;

    /**
     * Constructs a default UIToolbar object located at (0,0) with 0 weight and
     * 0 height.
     */
    public UIToolbar() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIToolbar object initialized with the dimensions and
     * position specified in the frame parameter.
     *
     * @param frame CGRect that defines dimension and position of the UIToolbar.
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UIToolbar(CGRect frame) {
        super(frame);
        setBarTintColor(Theme.Color.BARBACK);
        setAutoresizesSubviews(false);
    }

    /**
     * Returns the list of items that are displayed on this toolbar.
     *
     * @return The list of items that are displayed on this toolbar.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<UIBarButtonItem *> *items;")
    public List<UIBarButtonItem> items() {
        return new ArrayList<>(items);
    }

    /**
     * Set the list of items that will be displayed on this toolbar.
     *
     * @param items The list of items that will be displayed on this toolbar.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<UIBarButtonItem *> *items;")
    public void setItems(List<UIBarButtonItem> items) {
        setItems(items, false);
    }

    /**
     * Sets the items on the toolbar by animating the changes.
     *
     * @param items    The items to display on the toolbar.
     * @param animated A Boolean value if set to true animates the transition
     *                 the items; otherwise, does not.
     */
    @CMSelector("- (void)setItems:(NSArray<UIBarButtonItem *> *)items \n"
            + "        animated:(BOOL)animated;")
    public void setItems(List<UIBarButtonItem> items, boolean animated) {
        if (items == null)
            items = new ArrayList<>();
        this.items = items;
        for (UIBarButtonItem item : items)
            item.setParentCallback(this::layoutSubviews);
        layoutSubviews();
    }

    @Override
    public void layoutSubviews() {
        Native.lifecycle().runAndWaitOnEventThread(() -> {
            if (items == null) // be safe with early initialization, due to overiding of setFrame method
                return;
            for (UIView v : subviews())
                v.removeFromSuperview();

            CGSize size = frame().getSize();
            double[][] metrics = new double[items.size()][2];
            double flexibleSize = 0;
            double cwidth;
            {   // Calculate metrics
                float runningX = Theme.Bar.Tool.EDGEOFFSET;
                int flexibles = 0;
                for (int i = 0; i < items.size(); i++) {
                    UIBarButtonItem item = items.get(i);
                    if (item.systemItem == UIBarButtonSystemItem.FlexibleSpace)
                        flexibles++;
                    cwidth = item.width();
                    metrics[i][0] = runningX;
                    metrics[i][1] = cwidth;
                    runningX += cwidth + Theme.Bar.Tool.BETWEENOFFSET;
                }
                runningX += Theme.Bar.Tool.EDGEOFFSET;
                if (flexibles > 0 && runningX < size.getWidth()) // Only if it makes any sense, or else leave it zero

                    flexibleSize = (int) ((size.getWidth() - runningX) / flexibles); // Should cast to integer since we don't want fractal pixels here
            }

            // Apply metrics
            double height = frame().getSize().getHeight() - Theme.Bar.Tool.HEIGHTOFFSET * 2;
            double flexibleOffset = 0;   // for flexible space;
            for (int i = 0; i < items.size(); i++) {
                UIBarButtonItem item = items.get(i);
                UIView iview = item.view();
                if (iview != null) {
                    iview.setFrame(new CGRect(metrics[i][0] + flexibleOffset, Theme.Bar.Tool.HEIGHTOFFSET, metrics[i][1], height));
                    addSubview(iview);
                } else if (item.systemItem == UIBarButtonSystemItem.FlexibleSpace)
                    flexibleOffset += flexibleSize;
            }
            setNeedsDisplay();
        });
    }

    /**
     * Returns the toolbar appearance style.
     *
     * @return The toolbar style that specifies its appearance.
     * @see crossmobile.ios.uikit.UIBarStyle
     */
    @CMGetter("@property(nonatomic) UIBarStyle barStyle;\n"
            + "")
    public int barStyle() {
        return barStyle;
    }

    /**
     * Sets the toolbar appearance style.
     *
     * @param UIBarStyle The style that specifies its appearance.
     * @see crossmobile.ios.uikit.UIBarStyle
     */
    @CMSetter("@property(nonatomic) UIBarStyle barStyle;\n"
            + "")
    public void setBarStyle(int UIBarStyle) {
        this.barStyle = UIBarStyle;
        layoutSubviews();
    }

    /**
     * Returns the tint color of the toolbar background.
     *
     * @return The tint color of the toolbar background.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *barTintColor;")
    public UIColor barTintColor() {
        return new UIColor((color(barTintColor.cgcolor) & 0xffffff) | 0xff000000);
    }

    /**
     * Sets the tint color of the toolbar background.
     *
     * @param tintColor The tint color for the toolbar background.
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
     * Checks if this toolbar is translucent.
     *
     * @return A Boolean value that shows whether the toolbar is translucent or
     * not.
     */
    @CMGetter("@property(nonatomic, assign, getter=isTranslucent) BOOL translucent;")
    public boolean isTranslucent() {
        return translucent;
    }

    /**
     * Sets a value that shows whether the toolbar is translucent or not.
     *
     * @param translucent A Boolean value that shows whether the toolbar is
     *                    translucent not.
     */
    @CMSetter("@property(nonatomic, assign, getter=isTranslucent) BOOL translucent;")
    public void setTranslucent(boolean translucent) {
        if (translucent != this.translucent) {
            this.translucent = translucent;
            setBarTintColor(barTintColor);
            updateBar();
        }
    }

    @Override
    public void setHidden(boolean hidden) {
        if (isHidden() != hidden) {
            super.setHidden(hidden);
            updateBar();
        }
    }

    @Override
    public final void drawRect(CGRect rect) {
        fillBackground(barTintColor, barGradient, rect.getOrigin().getX(), rect.getOrigin().getY(), rect.getSize().getWidth(), rect.getSize().getHeight());
    }

    void setNavigationController(UINavigationController nc) {
        nbcontroller = nc == null ? null : new WeakReference<>(nc);
    }

    void updateBar() {
        UINavigationController nc = nbcontroller != null ? nbcontroller.get() : null;
        if (nc != null && nc.isViewLoaded())
            nc.view().layoutSubviews();
    }

    static void fillBackground(UIColor barTintColor, int[] barGradient, double x, double y, double width, double height) {
        GraphicsContext cxt = context(UIGraphics.getCurrentContext());
        if (barGradient == null) {
            cxt.setFillColorWithColor(color(barTintColor.cgcolor));
            cxt.fillRect(x, y, x + width, y + height);
        } else
            cxt.drawLinearGradient(barGradient, Theme.Color.BARGRADIENTSTOPS, x, y, x + width, y + height, 0);
        cxt.setDrawColorWithColor(color(UIColor.grayColor.cgcolor));
        cxt.drawLine(x, y + height, x + width, y + height);
    }
}
