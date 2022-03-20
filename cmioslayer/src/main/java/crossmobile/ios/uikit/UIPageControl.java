/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bind.graphics.theme.PageControlPainter;
import org.crossmobile.bridge.ann.*;

/**
 * UIPageControl class defines an object that is used for custom control of
 * presenting pages. Visually it is depicted as a sequence of dots that
 * correspond to pages. The currently displayed page belongs to a white dot.
 */
@CMClass
public class UIPageControl extends UIControl {

    private int currentPage;
    private int numberOfPages;
    private boolean hidesForSinglePage;
    private boolean defersCurrentPageDisplay;
    private UIColor pageIndicatorTintColor = new UIColor(0x80FFFFFF);
    private UIColor currentPageIndicatorTintColor = new UIColor(0xFFFFFFFF);

    /**
     * Constructs a default UIPageControl object located at (0,0) with 0 weight
     * and 0 height.
     */
    public UIPageControl() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIPageControl object initialized with the dimensions and
     * position specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of UIPageControl.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UIPageControl(CGRect rect) {
        super(rect);
    }

    private PageControlPainter painter() {
        return (PageControlPainter) painter;
    }

    /**
     * Returns the size of this page control's bounds in order to accomodate the
     * specified number of pages.
     *
     * @param pageCount The number of pages.
     * @return The size required to display appropriate dots for the specified
     * number of pages.
     */
    @CMSelector("- (CGSize)sizeForNumberOfPages:(NSInteger)pageCount;")
    public CGSize sizeForNumberOfPages(int pageCount) {
        return painter().sizeForNumberOfPages(pageCount);
    }

    /**
     * Updates the page indicator so that matches with the current page.
     */
    @CMSelector("- (void)updateCurrentPageDisplay;")
    public void updateCurrentPageDisplay() {
        setNeedsDisplay();
    }

    /**
     * Returns the number that corresponds to the current shown page(white
     * dot).The number of the first page is 0.
     *
     * @return The number that corresponds to the current shown page.
     */
    @CMGetter("@property(nonatomic) NSInteger currentPage;")
    public int currentPage() {
        return currentPage;
    }

    /**
     * Sets the current page shown as a white dot.
     *
     * @param currentPage The current page shown as a white dot.
     */
    @CMSetter("@property(nonatomic) NSInteger currentPage;")
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Returns a Boolean that controls whether indicator's current page is
     * rendered.
     *
     * @return A Boolean that controls whether the current page of the indicator
     * is displayed or not.TRUE delays rendering updateCurrentPageDisplay is
     * called.
     */
    @CMGetter("@property(nonatomic) BOOL defersCurrentPageDisplay;")
    public boolean defersCurrentPageDisplay() {
        return defersCurrentPageDisplay;
    }

    /**
     * Sets a Boolean that controls whether indicator's current page is
     * rendered.
     *
     * @param defersCurrentPageDisplay A Boolean that controls whether the
     *                                 current page of the indicator is displayed or not.TRUE delays rendering
     *                                 updateCurrentPageDisplay is called.
     */
    @CMSetter("@property(nonatomic) BOOL defersCurrentPageDisplay;")
    public void setDefersCurrentPageDisplay(boolean defersCurrentPageDisplay) {
        this.defersCurrentPageDisplay = defersCurrentPageDisplay;
    }

    /**
     * Returns a Boolean that shows whether the page control is hidden for one
     * page.
     *
     * @return A Boolean that shows whether the page control is hidden for one
     * page.
     */
    @CMGetter("@property(nonatomic) BOOL hidesForSinglePage;\n"
            + "")
    public boolean hidesForSinglePage() {
        return hidesForSinglePage;
    }

    /**
     * Sets a Boolean that defines whether the page control is hidden for one
     * page.
     *
     * @param hidesForSinglePage A Boolean that defines whether the page control
     *                           is hidden for one page.
     */
    @CMSetter("@property(nonatomic) BOOL hidesForSinglePage;\n"
            + "")
    public void setHidesForSinglePage(boolean hidesForSinglePage) {
        this.hidesForSinglePage = hidesForSinglePage;
    }

    /**
     * Returns the number of pages represented as dots.
     *
     * @return The number of pages represented as dots.
     */
    @CMGetter("@property(nonatomic) NSInteger numberOfPages")
    public int numberOfPages() {
        return numberOfPages;
    }

    /**
     * Sets the number of pages represented as dots.
     *
     * @param numberOfPages The number of pages the receiver shows
     */
    @CMSetter("@property(nonatomic) NSInteger numberOfPages")
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Returns the number of pages represented as dots.
     *
     * @return The number of pages represented as dots.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *pageIndicatorTintColor;")
    public UIColor pageIndicatorTintColor() {
        return pageIndicatorTintColor;
    }

    /**
     * Sets the color of the page indicator.
     *
     * @param pageIndicatorTintColor The color of the page indicator.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *pageIndicatorTintColor;")
    public void setPageIndicatorTintColor(UIColor pageIndicatorTintColor) {
        this.pageIndicatorTintColor = pageIndicatorTintColor;
    }

    /**
     * Returns the color of the page indicator.
     *
     * @return The color of the page indicator.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *currentPageIndicatorTintColor;")
    public UIColor currentPageIndicatorTintColor() {
        return currentPageIndicatorTintColor;
    }

    /**
     * Sets the color of the current page indicator.
     *
     * @param currentPageIndicatorTintColor The color of the current page
     *                                      indicator.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *currentPageIndicatorTintColor;")
    public void setCurrentPageIndicatorTintColor(UIColor currentPageIndicatorTintColor) {
        this.currentPageIndicatorTintColor = currentPageIndicatorTintColor;
    }

    @Override
    public final void drawRect(CGRect rect) {
        painter().draw(this, rect);
    }
}
