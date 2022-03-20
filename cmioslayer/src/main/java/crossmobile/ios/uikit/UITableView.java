/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSIndexPath;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bind.system.BitField;
import org.crossmobile.bind.system.Recycler;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;
import org.crossmobile.bridge.system.BaseUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.crossmobile.bridge.system.BaseUtils.isOverriddenDouble;

/**
 * UITableView class defines an object that represents a visible table used to
 * display and edit lists of data arranged to rows.
 */
@CMClass
public class UITableView extends UIScrollView {

    private final static Comparator<NSIndexPath> PATH_COMPARATOR = (p1, p2) -> {
        if (p1.section() < p2.section())
            return -1;
        if (p1.section() > p2.section())
            return 1;
        //noinspection UseCompareMethod
        if (p1.row() < p2.row())
            return -1;
        if (p1.row() > p2.row())
            return 1;
        return 0;
    };

    private cmTableViewMetrics metrics;
    private Map<String, Class<? extends UITableViewCell>> reusableCells;
    UIColor separatorColor = Theme.Color.SEPARATOR;
    int separatorStyle = UITableViewCellSeparatorStyle.SingleLine;
    private UITableViewDataSource dataSource;
    private UITableViewDelegate delegate;
    // TODO This should be UITableViewAutomaticDimension = -1
    private double rowHeight = -1;
    private double sectionHeaderHeight = -1;
    private double sectionFooterHeight = -1;
    private double estimatedRowHeight = -1;
    private boolean allowsSelection = true;
    private boolean allowsMultipleSelection = false;
    private boolean isEditing = false;
    private Map<NSIndexPath, UITableViewCell> active = new HashMap<>();
    private final SortedSet<NSIndexPath> selected = new TreeSet<>(PATH_COMPARATOR);

    private UIViewController closestController;
    private final Recycler<String, UITableViewCell> recycle = new Recycler<>(identifier -> {
        if (identifier == null || reusableCells == null)
            return null;
        Class<? extends UITableViewCell> cellClass = reusableCells.get(identifier);
        if (cellClass == null)
            return null;
        if (closestController == null) {
            UIView pivot = this;
            while (pivot != null && pivot.controller == null)
                pivot = pivot.superview();
            if (pivot == null)
                return null;
            closestController = pivot.controller;
        }
        try {
            return cellClass.getDeclaredConstructor(closestController.getClass()).newInstance(closestController);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException ignore) {
        } catch (InvocationTargetException e) {
            BaseUtils.throwException(e.getCause());
        }
        return null;
    }, UIView::removeFromSuperview, item -> {
        item.setSelected(false);
        item.prepareForReuse();
    });

    private final List<NSIndexPath> newpaths = new ArrayList<>();
    private final Runnable layoutSubviews = () -> {
        Map<NSIndexPath, UITableViewCell> pending = new HashMap<>();
        List<NSIndexPath> paths = indexPathsForVisibleRows();
        Map<NSIndexPath, UITableViewCell> swap = active;
        active = pending;   // Active is empty
        pending = swap;
        newpaths.clear();
        boolean needsRelayout = false;
        double width = cframe().getSize().getWidth() - contentInset.getLeft() - contentInset.getRight();

        // Keep already placed cells
        if (paths != null)
            for (NSIndexPath path : paths) {
                UITableViewCell cell = pending.remove(path);
                if (cell == null)
                    newpaths.add(path);
                else {
                    needsRelayout |= relayoutCell(cell, width, path);
                    active.put(path, cell);
                    cell.setEditing(isEditing, getEditingStyle(path));
                }
            }

        // Recycle vanished cells
        for (UITableViewCell rec : pending.values())
            recycle.put(rec.reuseIdentifier, rec);
        pending.clear();

        // Add new cells
        for (NSIndexPath path : newpaths) {
            UITableViewCell cell = dataSource.cellForRowAtIndexPath(UITableView.this, path); // Get new cell
            if (cell != null) {
                if (cell.superview() != UITableView.this)
                    addSubview(cell);
                active.put(path, cell);
                cell.setEditing(isEditing, getEditingStyle(path));
                cell.setSelected(selected.contains(path));
                if (delegate != null)
                    delegate.willDisplayCell(UITableView.this, cell, path);
                needsRelayout |= relayoutCell(cell, width, path);
            }
        }
        metrics().relayoutLabels(true);
        metrics().relayoutLabels(false);
        setContentSize(width, metrics().totalHeight());
        if (needsRelayout)
            setNeedsLayout();
        else
            setNeedsDisplay();
    };

    private boolean relayoutCell(UITableViewCell cell, double width, NSIndexPath path) {
        cell.path = path;
        cmTableViewMetrics tvm = metrics();
        double y = tvm.rowStart(path.section(), path.row());
        boolean needsRelayout = tvm.fixHeightIfNeeded(cell);
        double height = tvm.rowHeight(path.section(), path.row());
        cell.setFrameImpl(0, y, width, height);
        cell.layoutIfNeeded();
        return needsRelayout;
    }

    /**
     * Constructs a default table view object located at (0,0) with 0 weight and
     * 0 height.
     */
    public UITableView() {
        this(CGRect.zero());
    }

    /**
     * Constructs a table view that covers the specified rectangular area.
     *
     * @param rect The rectangular area of the new table view.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UITableView(CGRect rect) {
        this(rect, UITableViewStyle.Plain);
    }

    /**
     * Constructs a table view with the particular style and size.The table view
     * is placed it in the specified position expressed in the coordinate system
     * of its superview.
     *
     * @param rect             The size and position of the table view expressed in the
     *                         coordinate system of its superview.
     * @param UITableViewStyle The style of the table view.
     * @see crossmobile.ios.uikit.UITableViewStyle
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame \n"
            + "                        style:(UITableViewStyle)style;")
    public UITableView(CGRect rect, int UITableViewStyle) {
        super(rect, UIColor.whiteColor);
        setDelegate(new UIScrollViewDelegate() {
            @Override
            public void didScroll(UIScrollView scrollView) {
                layoutSubviews();
            }
        });
    }

    /**
     * Sets the data source of the table view.
     *
     * @param dataSource The the data source of the table view.
     */
    @CMSetter("@property(nonatomic, weak) id<UITableViewDataSource> dataSource;")
    public void setDataSource(UITableViewDataSource dataSource) {
        if (dataSource != this.dataSource) {
            this.dataSource = dataSource;
            invalidate();
        }
    }

    /**
     * Sets the delegate of the table view.
     *
     * @param delegate The delegate of the table view.
     */
    @CMSetter("@property(nonatomic, weak) id<UITableViewDelegate> delegate;")
    public void setDelegate(UITableViewDelegate delegate) {
        if (delegate != this.delegate) {
            this.delegate = delegate;
            invalidate();
        }
    }

    /**
     * Returns the delegate of the table view.
     *
     * @return The delegate of the table view.
     */
    @CMGetter("@property(nonatomic, weak) id<UITableViewDelegate> delegate;")
    public UITableViewDelegate tableViewDelegate() {
        return delegate;
    }

    /**
     * Returns the data source of the table view.
     *
     * @return The data source of the table view.
     */
    @CMGetter("@property(nonatomic, weak) id<UITableViewDataSource> dataSource;")
    public UITableViewDataSource dataSource() {
        return dataSource;
    }

    /**
     * Returns a cell object specified by its identifier that is reused when
     * adding a new cell to the table view.
     *
     * @param identifier The string id of the cell object.NOT NULL.
     * @return The cell object that is reused and already exists, NULL if there
     * is no cell.
     */
    @CMSelector("- (__kindof UITableViewCell *)dequeueReusableCellWithIdentifier:(NSString *)identifier;")
    public UITableViewCell dequeueReusableCellWithIdentifier(String identifier) {
        return recycle.get(identifier);
    }

    /**
     * Deletes a list of rows specified by the index paths using animation or
     * not.
     *
     * @param indexPaths              The list of the index paths of the rows to be deleted.
     * @param UITableViewRowAnimation The type of the animation
     */
    @CMSelector("- (void)deleteRowsAtIndexPaths:(NSArray<NSIndexPath *> *)indexPaths \n"
            + "              withRowAnimation:(UITableViewRowAnimation)animation;")
    public void deleteRowsAtIndexPaths(List<NSIndexPath> indexPaths, int UITableViewRowAnimation) {
        Native.system().notImplemented("will reload table instead");
        reloadData();
    }

    /**
     * Reloads all the rows and sections.
     */
    @CMSelector("- (void)reloadData;")
    public void reloadData() {
        invalidate();
    }

    private void invalidate() {
        if (metrics != null) {
            metrics = metrics.recycle();
            for (UITableViewCell cell : active.values())
                recycle.put(cell.reuseIdentifier, cell);
            active.clear();
        }
        setNeedsDisplay();
    }

    private boolean isInvalid() {
        return metrics == null;
    }

    private cmTableViewMetrics metrics() {
        return metrics == null ? metrics = new cmTableViewMetrics(this) : metrics;
    }

    /**
     * Reloads a list of rows specified by the index paths using animation in
     * order to emphasize the change.
     *
     * @param indexPaths              The list of the rows to be updated.
     * @param UITableViewRowAnimation The animation used for the updating.
     * @see crossmobile.ios.uikit.UITableViewRowAnimation
     */
    @CMSelector("- (void)reloadRowsAtIndexPaths:(NSArray<NSIndexPath *> *)indexPaths \n"
            + "              withRowAnimation:(UITableViewRowAnimation)animation;")
    public void reloadRowsAtIndexPaths(List<NSIndexPath> indexPaths, int UITableViewRowAnimation) {
        if (indexPaths == null || indexPaths.isEmpty())
            return;

        int section, row;
        boolean shouldUpdatelayout = false;
        cmTableViewMetrics tvm = metrics();
        for (NSIndexPath path : indexPaths) {
            section = path.section();
            row = path.row();
            if (section >= 0
                    && section < tvm.sections()
                    && row >= 0
                    && row < tvm.rows(section)
                    && tvm.rowHeight(section, row) != delegate.heightForRowAtIndexPath(UITableView.this, path))
                shouldUpdatelayout = true; // Just in case the change is before the visible part, and might affect the following visible cells
            UITableViewCell vis = active.remove(path);
            if (vis != null) {
                recycle.put(vis.reuseIdentifier, vis);
                shouldUpdatelayout = true;
            }
        }
        if (shouldUpdatelayout)
            layoutSubviews();
    }

    /**
     * Inserts rows in the table view in the positions specified by the index
     * paths using animation or not.
     *
     * @param indexPaths              A list with index paths of the new rows.
     * @param UITableViewRowAnimation TRUE if the insertion is animated.
     * @see crossmobile.ios.uikit.UITableViewRowAnimation
     */
    @CMSelector("- (void)insertRowsAtIndexPaths:(NSArray<NSIndexPath *> *)indexPaths \n"
            + "              withRowAnimation:(UITableViewRowAnimation)animation;")
    public void insertRowsAtIndexPaths(List<NSIndexPath> indexPaths, int UITableViewRowAnimation) {
        Native.system().notImplemented();
        reloadData();
    }

    /**
     * Selects the row of the specified index path with animation or not,
     * scrolling this row according to specified relative position.
     *
     * @param indexpath                 The index path of the row.
     * @param animated                  TRUE if the change is animated.
     * @param UITableViewScrollPosition The relative position of the table
     *                                  view(top, middle, bottom).
     * @see crossmobile.ios.uikit.UITableViewScrollPosition
     */
    @CMSelector("- (void)selectRowAtIndexPath:(NSIndexPath *)indexPath \n"
            + "                    animated:(BOOL)animated \n"
            + "              scrollPosition:(UITableViewScrollPosition)scrollPosition;")
    public void selectRowAtIndexPath(NSIndexPath indexpath, boolean animated, int UITableViewScrollPosition) {
        selectRow(indexpath, false);
        if (animated)
            scrollToRowAtIndexPath(indexpath, UITableViewScrollPosition, animated);
    }

    void selectRow(NSIndexPath indexPath, boolean informDelegate) {
        if (!allowsSelection)
            return;
        if (!allowsMultipleSelection && !selected.isEmpty())
            for (NSIndexPath older : selected)
                deselectRow(older, informDelegate);
        if (!selected.contains(indexPath)) {
            selected.add(indexPath);
            UITableViewCell cell = active.get(indexPath);
            if (cell != null)
                cell.setSelected(true);
        }
        if (informDelegate && delegate != null && !isEditing)
            delegate.didSelectRowAtIndexPath(this, indexPath);

    }

    /**
     * Deselects the row of the specified index path with animation or not.
     *
     * @param indexPath The index path of the row.
     * @param animation TRUE if the change is animated.
     */
    @CMSelector("- (void)deselectRowAtIndexPath:(NSIndexPath *)indexPath \n"
            + "                      animated:(BOOL)animated;")
    public void deselectRowAtIndexPath(NSIndexPath indexPath, boolean animation) {
        deselectRow(indexPath, false);
    }

    void deselectRow(NSIndexPath indexPath, boolean informDelegate) {
        selected.remove(indexPath);
        UITableViewCell cell = active.get(indexPath);
        if (cell != null)
            cell.setSelected(false);
        if (informDelegate && delegate != null)
            delegate.didDeselectRowAtIndexPath(this, indexPath);
    }

    /**
     * Returns the index path of the selected row.
     *
     * @return The index path of the selected row.
     */
    @CMGetter("@property(nonatomic, readonly) NSIndexPath *indexPathForSelectedRow;")
    public NSIndexPath indexPathForSelectedRow() {
        if (selected.isEmpty())
            return null;
        return selected.first();
    }

    /**
     * Returns a list with the index paths of the selected rows.
     *
     * @return A list with the index paths of the selected rows. NULL if there
     * no selected rows.
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<NSIndexPath *> *indexPathsForSelectedRows;")
    public List<NSIndexPath> indexPathsForSelectedRows() {
        return selected.isEmpty() ? null : new ArrayList<>(selected);
    }

    /**
     * Returns the color of the cell separator.
     *
     * @return The color of the cell separator.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *separatorColor;")
    public UIColor separatorColor() {
        return separatorColor;
    }

    /**
     * Sets the color of the cell separator.
     *
     * @param separatorColor The color of the cell separator.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *separatorColor;")
    public void setSeparatorColor(UIColor separatorColor) {
        this.separatorColor = separatorColor;
        setNeedsDisplay();
    }

    /**
     * Returns style of the cell separator.
     *
     * @return The style of the cell separator.
     */
    @CMGetter("@property(nonatomic) UITableViewCellSeparatorStyle separatorStyle;")
    public int separatorStyle() {
        return separatorStyle;
    }

    /**
     * Sets the style of the cell separator.
     *
     * @param UITableViewCellSeparatorStyle The style of the cell separator.
     * @see crossmobile.ios.uikit.UITableViewCellSeparatorStyle
     */
    @CMSetter("@property(nonatomic) UITableViewCellSeparatorStyle separatorStyle;")
    public void setSeparatorStyle(int UITableViewCellSeparatorStyle) {
        this.separatorStyle = UITableViewCellSeparatorStyle;
        setNeedsDisplay();
    }

    /**
     * Returns a Boolean that shows whether the user can select a row.
     *
     * @return A Boolean that shows whether the user can select a row.
     */
    @CMGetter("@property(nonatomic) BOOL allowsSelection;")
    public boolean allowsSelection() {
        return allowsSelection;
    }

    /**
     * Sets a Boolean that defines whether the user can select a row.
     *
     * @param allowsSelection A Boolean that defines whether the user can select
     *                        a row.
     */
    @CMSetter("@property(nonatomic) BOOL allowsSelection;")
    public void setAllowsSelection(boolean allowsSelection) {
        this.allowsSelection = allowsSelection;
    }

    /**
     * Returns a Boolean that shows whether one or more row can be selected when
     * in default mode.
     *
     * @return A Boolean that shows whether one or more row can be selected when
     * in default mode.
     */
    @CMGetter("@property(nonatomic) BOOL allowsMultipleSelection;")
    public boolean allowsMultipleSelection() {
        return allowsMultipleSelection;
    }

    /**
     * Set a Boolean that defines whether one or more row can be selected when
     * in default mode.
     *
     * @param allowsMultipleSelection Boolean that defines whether one or more
     *                                row can be selected when in default mode.
     */
    @CMSetter("@property(nonatomic) BOOL allowsMultipleSelection;")
    public void setAllowsMultipleSelection(boolean allowsMultipleSelection) {
        this.allowsMultipleSelection = allowsMultipleSelection;
    }

    /**
     * Returns a Boolean that shows the mode of the table view(editing or
     * default)
     *
     * @return TRUE if it is set to editing mode.
     */
    @CMGetter("@property(nonatomic, getter=isEditing) BOOL editing;")
    public boolean isEditing() {
        return isEditing;
    }

    /**
     * Sets the mode of the table view(editing or default)
     *
     * @param editing TRUE to set it to editing mode.
     */
    @CMSetter("@property(nonatomic, getter=isEditing) BOOL editing;")
    public void setEditing(boolean editing) {
        setEditing(editing, false);
    }

    /**
     * Switches between table view's editing and default mode with animation or
     * not.
     *
     * @param editing  TRUE for editing mode.
     * @param animated TRUE for animated change.
     */
    @CMSelector("- (void)setEditing:(BOOL)editing \n"
            + "          animated:(BOOL)animated;")
    public void setEditing(boolean editing, boolean animated) {
        this.isEditing = editing;
        for (UITableViewCell cell : active.values())
            cell.setEditing(isEditing, getEditingStyle(cell.path));
        setNeedsDisplay();
    }

    private int getEditingStyle(NSIndexPath path) {
        return delegate == null || path == null
                ? UITableViewCellEditingStyle.Delete
                : delegate.editingStyleForRowAtIndexPath(this, path);
    }

    /**
     * Returns the height of the row.
     *
     * @return The height of the row.
     */
    @CMGetter("@property(nonatomic) CGFloat rowHeight;")
    public double rowHeight() {
        return rowHeight;
    }

    /**
     * Sets the height of the row.
     *
     * @param rowHeight The height of the row.
     */
    @CMSetter("@property(nonatomic) CGFloat rowHeight;")
    public void setRowHeight(double rowHeight) {
        if (Math.abs(rowHeight - this.rowHeight) > 0.001) {
            this.rowHeight = rowHeight;
            invalidate();
        }
    }

    /**
     * Sets the height of the headers' section for this table view.
     *
     * @param sectionHeaderHeight The height of the headers' section for this
     *                            table view.
     */
    @CMSetter("@property(nonatomic) CGFloat sectionHeaderHeight;")
    public void setSectionHeaderHeight(double sectionHeaderHeight) {
        if (Math.abs(sectionHeaderHeight - this.sectionHeaderHeight) > 0.001) {
            this.sectionHeaderHeight = sectionHeaderHeight;
            invalidate();
        }
    }

    /**
     * Returns the height of the headers' section for this table view.
     *
     * @return The height of the headers' section for this table view.
     */
    @CMGetter("@property(nonatomic) CGFloat sectionHeaderHeight;")
    public double sectionHeaderHeight() {
        return sectionHeaderHeight;
    }

    /**
     * Sets the height of the footers' section for this table view.
     *
     * @param sectionFooterHeight The height of the footers' section for this
     *                            table view.
     */
    @CMSetter("@property(nonatomic) CGFloat sectionFooterHeight;")
    public void setSectionFooterHeight(double sectionFooterHeight) {
        if (Math.abs(sectionFooterHeight - this.sectionFooterHeight) > 0.001) {
            this.sectionFooterHeight = sectionFooterHeight;
            invalidate();
        }
    }

    /**
     * Returns the height of the footers for this table view.
     *
     * @return The height of the footers for this table view.
     */
    @CMGetter("@property(nonatomic) CGFloat sectionFooterHeight;")
    public double sectionFooterHeight() {
        return sectionFooterHeight;
    }

    /**
     * Scrolls the table view, with animation or not, so that at the end of the
     * scrolling, the selected row is placed in the specified relative position
     * of the table view.
     *
     * @param UITableViewScrollPosition The relative position of the table view
     *                                  at the end of the scrolling.(top, middle, bottom)
     * @param animated                  TRUE for animated scrolling.
     */
    @CMSelector("- (void)scrollToNearestSelectedRowAtScrollPosition:(UITableViewScrollPosition)scrollPosition \n"
            + "                                          animated:(BOOL)animated;")
    public void scrollToNearestSelectedRowAtScrollPosition(int UITableViewScrollPosition, boolean animated) {
        NSIndexPath found = null;
        double gDelta = Double.MAX_VALUE;
        double currentY = contentOffset.getY();
        cmTableViewMetrics tvm = metrics();
        for (NSIndexPath sel : selected) {
            double cDelta = Math.abs(currentY - tvm.rowMiddle(sel.section(), sel.row()));
            if (cDelta < gDelta) {
                gDelta = cDelta;
                found = sel;
            }
        }
        if (found != null)
            scrollToRowAtIndexPath(found, UITableViewScrollPosition, animated);
    }

    /**
     * Scrolls the table view,with animation or not, so that at the end of the
     * scrolling, the row of that index path is placed in the specified relative
     * position of the table view.
     *
     * @param path                      The index path of the row.
     * @param UITableViewScrollPosition The relative position of the row at the
     *                                  end of the scrolling.(top, middle, bottom)
     * @param animated                  TRUE for animated scrolling.
     * @see crossmobile.ios.uikit.UITableViewScrollPosition
     */
    @CMSelector("- (void)scrollToRowAtIndexPath:(NSIndexPath *)indexPath \n"
            + "              atScrollPosition:(UITableViewScrollPosition)scrollPosition \n"
            + "                      animated:(BOOL)animated;")
    public void scrollToRowAtIndexPath(NSIndexPath path, int UITableViewScrollPosition, boolean animated) {
        setContentOffset(new CGPoint(0, metrics().rowStart(path.section(), path.row())), animated);
    }


    /**
     * Returns the index path that identifies the row and section of the
     * specified point.
     *
     * @param p The point expressed in the coordinate system of the table view.
     * @return The index path of the point.NULL if the point is not within a
     * row.
     */
    @CMSelector("- (NSIndexPath *)indexPathForRowAtPoint:(CGPoint)point;")
    public NSIndexPath indexPathForRowAtPoint(CGPoint p) {
        List<NSIndexPath> res = metrics().indexPathsForRowsBetween(p.getY(), p.getY() + 1);
        if (res == null || res.isEmpty())
            return null;
        return res.get(0);
    }

    /**
     * Returns a list containing the index path of the visible rows of table
     * view.
     *
     * @return A list containing the index path of the visible rows of table
     * view.
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<NSIndexPath *> *indexPathsForVisibleRows;")
    public List<NSIndexPath> indexPathsForVisibleRows() {
        return metrics().indexPathsForRowsBetween(contentOffset.getY(), contentOffset.getY() + cframe().getSize().getHeight());
    }

    @Override
    public void layoutSubviews() {
        Native.lifecycle().runAndWaitOnEventThread(layoutSubviews);
    }

    @CMSelector("- (void)registerNib:(UINib *)nib forCellReuseIdentifier:(NSString *)identifier;")
    public void registerNib(UINib nib, String identifier) {
        Native.system().notImplemented();
    }

    @CMSelector("- (void)registerClass:(Class)cellClass forCellReuseIdentifier:(NSString *)identifier;")
    public void registerClass(@CMParamMod(convertWith = "jclass_to_class") Class<? extends UITableViewCell> cellClass, String identifier) {
        if (identifier == null)
            return;
        if (reusableCells == null)
            reusableCells = new HashMap<>();
        if (cellClass == null)
            reusableCells.remove(identifier);
        else
            reusableCells.put(identifier, cellClass);
    }

    @CMSetter("@property(nonatomic) CGFloat estimatedRowHeight;")
    public void setEstimatedRowHeight(double estimatedRowHeight) {
        this.estimatedRowHeight = estimatedRowHeight;
    }

    @CMGetter("@property(nonatomic) CGFloat estimatedRowHeight;")
    public double estimatedRowHeight() {
        return estimatedRowHeight;
    }

    @Override
    public void drawRect(CGRect rect) {
        if (isInvalid())
            layoutSubviews();
        super.drawRect(rect);
    }
}


class cmTableViewMetrics {
    /**
     * Data representation of the start position of all table elements.
     * <p>
     * Its size is the number of sections, plus one, to be able to define the end of the table.
     * For each section, the values are the start of the header (could be zero), plus the number of rows,
     * plus the footer. Thus, for each section, its values are the number of rows per section plus two.
     * The header and footer are always present, even if the number of rows for this section is zero.
     */
    private final int[] sections;
    private final BitField[] approximateSize;
    private UIView[] headerViews;
    private UIView[] footerViews;
    private final double[] pos;
    private int lastSection = 0;
    private int lastDelta = 0;
    private int calculatedRows;

    private final UITableView tv;
    private final boolean headerHeightInDelegate;
    private final boolean rowHeightInDelegate;
    private final boolean footerHeightInDelegate;

    private static final int MAGIC_ROW_HEIGHT = 44;

    cmTableViewMetrics(UITableView tv) {
        int sectionSize = Math.max(tv.dataSource() == null ? 0 : tv.dataSource().numberOfSectionsInTableView(tv), 0);
        this.tv = tv;

        sections = new int[sectionSize + 1];
        approximateSize = new BitField[sectionSize];
        UITableViewDelegate delegate = tv.tableViewDelegate();
        sections[0] = 0;
        for (int i = 0; i < sectionSize; i++) {
            int size = Math.max(tv.dataSource().numberOfRowsInSection(tv, i), 0);
            sections[i + 1] = sections[i] + size + 2; // header+rows+footer
            approximateSize[i] = new BitField(size, false);
        }
        Arrays.fill(pos = new double[sections[sectionSize] + 1], -1);
        pos[0] = 0;

        headerHeightInDelegate = delegate != null && isOverriddenDouble(() -> delegate.heightForHeaderInSection(tv, 0));
        rowHeightInDelegate = delegate != null && isOverriddenDouble(() -> delegate.heightForRowAtIndexPath(tv, NSIndexPath.indexPathForRow(0, 0)));
        footerHeightInDelegate = delegate != null && isOverriddenDouble(() -> delegate.heightForFooterInSection(tv, 0));
    }

    cmTableViewMetrics recycle() {
        if (headerViews != null)
            for (UIView view : headerViews)
                if (view != null)
                    view.removeFromSuperview();
        if (footerViews != null)
            for (UIView view : footerViews)
                if (view != null)
                    view.removeFromSuperview();
        return null;
    }

    int sections() {
        return sections.length - 1;
    }

    int rows(int section) {
        return sections[section + 1] - sections[section] - 2;   // do not include header and footer
    }

    int rows() {
        return pos.length - 1 - 2 * sections();
    }

    private double get(int section, int delta) {
        return pos[sections[section] + delta];
    }

    private void set(int section, int delta, double value) {
        pos[sections[section] + delta] = value;
    }

    double headerStart(int section) {
        if (get(section, 1) < 0)
            ensure(section, 1);
        return get(section, 0);
    }

    double headerHeight(int section) {
        if (get(section, 1) < 0)
            ensure(section, 1);
        return get(section, 1) - get(section, 0);
    }

    double headerEnd(int section) {
        if (get(section, 1) < 0)
            ensure(section, 1);
        return get(section, 1);
    }

    double rowStart(int section, int row) {
        if (get(section, row + 2) < 0)
            ensure(section, row + 2);
        return get(section, row + 1);
    }

    double rowHeight(int section, int row) {
        if (get(section, row + 2) < 0)
            ensure(section, row + 2);
        return get(section, row + 2) - get(section, row + 1);
    }

    double rowMiddle(int section, int row) {
        if (get(section, row + 2) < 0)
            ensure(section, row + 2);
        return (get(section, row + 1) + get(section, row + 2)) * 0.5;
    }

    double rowEnd(int section, int row) {
        if (get(section, row + 2) < 0)
            ensure(section, row + 2);
        return get(section, row + 2);
    }

    double footerStart(int section) {
        if (get(section + 1, 0) < 0)
            ensure(section + 1, 0);
        return get(section, rows(section) + 1);
    }

    double footerHeight(int section) {
        if (get(section + 1, 0) < 0)
            ensure(section + 1, 0);
        return get(section + 1, 0) - get(section, rows(section) + 1);
    }

    double footerEnd(int section) {
        if (get(section + 1, 0) < 0)
            ensure(section + 1, 0);
        return get(section + 1, 0);
    }


    double totalHeight() {
        int sections = sections();
        int remainingRows = rows() - calculatedRows;
        if (remainingRows == 0) {   // all rows have been calculated
            if (get(sections, 0) < 0)    // only the footer is missing
                ensure(sections, 0);    // calculate footer too
            return get(sections, 0);
        } else {
            double estHeight = tv.rowHeight();
            estHeight = estHeight > 0 ? estHeight : tv.estimatedRowHeight();
            estHeight = estHeight > 0 ? estHeight : MAGIC_ROW_HEIGHT;
            return get(lastSection, lastDelta) + remainingRows * estHeight;
        }
    }

    private void ensure(int section, int delta) {
        if (section >= sections()) {
            if (section > sections() || delta != 0)
                throw new IndexOutOfBoundsException();
        } else if (delta > rows(section) + 1)
            throw new IndexOutOfBoundsException();

        if (lastSection >= sections())
            throw new IndexOutOfBoundsException();
        int startSection = lastSection;
        int startDelta = lastDelta + 1;
        if (startDelta >= rows(startSection) + 2) {
            startDelta = 0;
            startSection++;
        }
        for (int cSection = startSection; cSection <= section; cSection++)
            for (int cDelta = (cSection == startSection ? startDelta : 0); cDelta <= (cSection == section ? delta : rows(cSection) + 1); cDelta++) {
                if (get(cSection, cDelta) >= 0)
                    throw new IndexOutOfBoundsException("Already calculated");
                boolean isRow = lastDelta > 0 && lastDelta <= rows(lastSection);
                double height = isRow
                        ? getRowHeight(lastSection, lastDelta - 1)  // has to substruct 1 since rows start at 1 (header start at 0)
                        : initLabel(lastSection, lastDelta == 0);
                set(cSection, cDelta, get(lastSection, lastDelta) + height);
                if (isRow)
                    calculatedRows++;
                else if (height > 0)
                    tv.addSubview(lastDelta == 0 ? headerViews[lastSection] : footerViews[lastSection]);
                lastSection = cSection; // needs to be here, in case we have a section jump
                lastDelta = cDelta;
            }
    }

    private double initLabel(int section, boolean isHeader) {
        UITableViewDelegate delegate = tv.tableViewDelegate();
        if (delegate == null)
            return 0;
        UIView view = isHeader ? delegate.viewForHeaderInSection(tv, section) : delegate.viewForFooterInSection(tv, section);
        if (view == null) {
            String text = isHeader ? tv.dataSource().titleForHeaderInSection(tv, section) : tv.dataSource().titleForFooterInSection(tv, section);
            if (text != null) {
                UILabel label = new UILabel();
                label.setText(text);
                label.setTextColor(Theme.Cell.HEADERTEXT);
                label.setBackgroundColor(Theme.Cell.HEADERBACK);
                view = label;
            }
        }
        if (view == null)
            return 0;
        if (isHeader) {
            if (headerViews == null)
                headerViews = new UIView[sections()];
        } else {
            if (footerViews == null)
                footerViews = new UIView[sections()];
        }
        (isHeader ? headerViews : footerViews)[section] = view;
        double height = isHeader
                ? (headerHeightInDelegate ? delegate.heightForHeaderInSection(tv, section) : tv.sectionHeaderHeight())
                : (footerHeightInDelegate ? delegate.heightForFooterInSection(tv, section) : tv.sectionFooterHeight());
        return height >= 0 ? height : view.sizeThatFits(new CGSize(0, 0)).getHeight();
    }

    void relayoutLabels(boolean asHeaders) {
        UIView[] views = asHeaders ? headerViews : footerViews;
        double width = tv.cframe().getSize().getWidth();
        if (views != null)
            for (int section = 0; section < views.length; section++)
                if (views[section] != null)
                    views[section].setFrame(new CGRect(0,
                            get(section, asHeaders ? 0 : rows(section) + 1),
                            width,
                            asHeaders ? headerHeight(section) : footerHeight(section)));
    }

    private double getRowHeight(int section, int row) {
        double height = rowHeightInDelegate
                ? tv.tableViewDelegate().heightForRowAtIndexPath(tv, NSIndexPath.indexPathForRow(row, section))
                : tv.rowHeight();
        if (height < 0)
            approximateSize[section].set(row, true);
        return height >= 0 ? height : MAGIC_ROW_HEIGHT;
    }

    boolean fixHeightIfNeeded(UITableViewCell cell) {
        int section = cell.path.section();
        int row = cell.path.row();
        double currentHeight = rowHeight(section, row);
        double delta = 0;
        if (!rowHeightInDelegate && cell.getRowHeight() > 0)
            delta = cell.getRowHeight() - currentHeight;
        else if (approximateSize[section].getAndSet(row, false))
            delta = cell.sizeThatFits(new CGSize(0, 0)).getHeight() - currentHeight;
        if (Math.abs(delta) > 0.5) {
            for (int i = sections[section] + row + 1 + 1; i < pos.length; i++)  // +1 for the header, +1 for the start of next element (i.e. height)
                if (pos[i] >= 0)
                    pos[i] += delta;
                else
                    break;
            return true;
        } else
            return false;
    }

    List<NSIndexPath> indexPathsForRowsBetween(double yFrom, double yTo) {
        List<NSIndexPath> res = new ArrayList<>();
        yFrom -= tv.contentInset.getTop();
        yTo -= tv.contentInset.getTop();
        if (yFrom < 0)
            yFrom = 0;
        int idx = 0;
        end:
        for (int section = 0; section < sections(); section++) {
            idx++;  // ignore header
            int sectionSize = rows(section);
            for (int row = 0; row < sectionSize; row++) {
                if (pos[idx + 1] < 0)
                    ensure(section, row + 1 + 1);   // first 1: header, second 2: right-edge of cell
                if (pos[idx + 1] > yFrom) { // part of the cell is on the right of the lower end
                    if (pos[idx] > yTo) // the cell starts above higher end
                        break end;
                    res.add(NSIndexPath.indexPathForRow(row, section));
                }
                idx++;
            }
            idx++;  // ignore footer
        }
        return res;
    }
}