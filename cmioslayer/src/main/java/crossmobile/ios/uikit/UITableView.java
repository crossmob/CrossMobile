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

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSIndexPath;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bind.system.Optionals;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;
import org.crossmobile.bridge.system.BaseUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.crossmobile.bind.system.Optionals.*;

/**
 * UITableView class defines an object that represents a visible table used to
 * display and edit lists of data arranged to rows.
 */
@CMClass
public class UITableView extends UIScrollView {

    private final Map<String, List<UITableViewCell>> recycle = new HashMap<>();
    private final Map<String, Class<? extends UITableViewCell>> reusableCells = new HashMap<>();
    private final SectionMetrics metrics = new SectionMetrics();
    //
    UIColor separatorColor = Theme.Color.SEPARATOR;
    int separatorStyle = UITableViewCellSeparatorStyle.SingleLine;
    private UITableViewDataSource dataSource;
    private UITableViewDelegate delegate;
    //THIS SHOULD BE UITableViewAutomaticDimension = -1
    private double rowHeight = 45;
    private double sectionHeaderHeight = 24;
    private double sectionFooterHeight = 24;
    private boolean allowsSelection = true;
    private boolean allowsMultipleSelection = false;
    private boolean isEditing = false;
    private Map<NSIndexPath, UITableViewCell> active = new HashMap<>();
    private SortedSet<NSIndexPath> selected = new TreeSet<>((p1, p2) -> {
        if (p1.section() < p2.section())
            return -1;
        if (p1.section() > p2.section())
            return 1;
        if (p1.row() < p2.row())
            return -1;
        if (p1.row() > p2.row())
            return 1;
        return 0;
    });
    private List<NSIndexPath> newpaths = new ArrayList<>();
    private final Runnable layoutSubviews = () -> {
        setContentSize(new CGSize(getWidth() - contentInset.getLeft() - contentInset.getRight(), contentSize.getHeight()), false);

        Map<NSIndexPath, UITableViewCell> pending = new HashMap<>();
        List<NSIndexPath> paths = indexPathsForVisibleRows();
        Map<NSIndexPath, UITableViewCell> swap = active;
        active = pending;   // Active is empty
        pending = swap;
        newpaths.clear();

        // Keep already placed cells
        if (paths != null)
            for (NSIndexPath path : paths) {
                UITableViewCell cell = pending.remove(path);
                if (cell == null)
                    newpaths.add(path);
                else {
                    relayoutCell(cell, path);
                    active.put(path, cell);
                    cell.setEditing(isEditing, getEditingStyle(path));
                }
            }

        // Recycle vanished cells
        for (UITableViewCell rec : pending.values())
            recycle(rec);
        pending.clear();

        // Add new cells
        for (NSIndexPath path : newpaths) {
            UITableViewCell cell = dataSource.cellForRowAtIndexPath(UITableView.this, path); // Get new cell
            if (cell != null) {
                if (cell.superview() != UITableView.this)
                    addSubview(cell);
                relayoutCell(cell, path);

                active.put(path, cell);
                cell.setEditing(isEditing, getEditingStyle(path));
                cell.setSelected(selected.contains(path));
                if (delegate != null)
                    delegate.willDisplayCell(UITableView.this, cell, path);
            }
        }
        Native.graphics().refreshDisplay();
    };
    private UIView[] headers;
    private UIView[] footers;
    private double estimatedRowHeight;

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
        super(rect);
        setAutoresizesSubviews(false);
        setBackgroundColor(UIColor.whiteColor);
        setDelegate(new UIScrollViewDelegate() {
            @Override
            public void didScroll(UIScrollView scrollView) {
                layoutSubviewsWithoutMetrics();
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
        this.dataSource = dataSource;
        reloadData();
    }

    /**
     * Sets the delegate of the table view.
     *
     * @param delegate The delegate of the table view.
     */
    @CMSetter("@property(nonatomic, weak) id<UITableViewDelegate> delegate;")
    public void setDelegate(UITableViewDelegate delegate) {
        this.delegate = delegate;
        metrics.update();
        layoutSubviews();
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
        if (identifier == null)
            return null;
        List<UITableViewCell> found = recycle.get(identifier);
        if (found == null)
            return getReusableCell(identifier);
        int size = found.size();
        if (size == 0)
            return getReusableCell(identifier);
        UITableViewCell cell = found.remove(size - 1);
        cell.setSelected(false);
        return cell;
    }

    private UIViewController closestController;

    private UITableViewCell getReusableCell(String id) {
        if ((closestController = getClosestController()) != null) {
            try {
                if(reusableCells.get(id) == null)
                    return null;
                return reusableCells.get(id).getDeclaredConstructor(closestController.getClass()).newInstance(closestController);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException ignore) {
            } catch (InvocationTargetException e) {
                BaseUtils.throwException(e.getCause());
            }
        }
        return null;
    }

    private UIViewController getClosestController() {
        if (closestController != null)
            return closestController;
        UIView pivot = this;
        while (pivot != null && pivot.controller == null)
            pivot = pivot.superview();
        return pivot != null ? pivot.controller : null;
    }

    /**
     * Deletes a list of rows specified by the index paths using animation or
     * not.
     *
     * @param indexPaths                 The list of the index paths of the rows to be deleted.
     * @param UITable​View​Row​Animation The type of the animation
     */
    @CMSelector("- (void)deleteRowsAtIndexPaths:(NSArray<NSIndexPath *> *)indexPaths \n"
            + "              withRowAnimation:(UITableViewRowAnimation)animation;")
    public void deleteRowsAtIndexPaths(List<NSIndexPath> indexPaths, int UITable​View​Row​Animation) {
        Native.lifecycle().notImplemented("will reload table instead");
        reloadData();
    }

    /**
     * Reloads all the rows and sections.
     */
    @CMSelector("- (void)reloadData;")
    public void reloadData() {
        headers = updateSectionLabels(headers, supports(delegate, UITable_viewForHeaderInSection), supports(dataSource, UITable_titleForHeaderInSection), true);
        footers = updateSectionLabels(footers, supports(delegate, UITable_viewForFooterInSection), supports(dataSource, UITable_titleForFooterInSection), false);
        // reload all rows
        for (UITableViewCell cell : active.values())
            recycle(cell);
        active.clear();
        layoutSubviews();
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
        for (NSIndexPath path : indexPaths) {
            section = path.section();
            row = path.row();
            if (!metrics.staticHeight
                    && section >= 0
                    && section < metrics.sections
                    && row >= 0
                    && row < metrics.rowsPerSection[path.section()]
                    && metrics.rowHeight(section, row) != delegate.heightForRowAtIndexPath(UITableView.this, path))
                shouldUpdatelayout = true; // Just in case the change is before the visible part, and might affect the following visible cells
            UITableViewCell vis = active.remove(path);
            if (vis != null) {
                recycle(vis);
                shouldUpdatelayout = true;
            }
        }
        if (shouldUpdatelayout)
            layoutSubviewsWithoutMetrics();
    }

    /**
     * Inserts rows in the table view in the positions specified by the index
     * paths using animation or not.
     *
     * @param indexPaths              A list with index paths of the new rows.
     * @param uiTableViewRowAnimation TRUE if the insertion is animated.
     * @see crossmobile.ios.uikit.UITableViewRowAnimation
     */
    @CMSelector("- (void)insertRowsAtIndexPaths:(NSArray<NSIndexPath *> *)indexPaths \n"
            + "              withRowAnimation:(UITableViewRowAnimation)animation;")
    public void insertRowsAtIndexPaths(List<NSIndexPath> indexPaths, int uiTableViewRowAnimation) {
        Native.lifecycle().notImplemented();
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
        if (selected.isEmpty())
            return null;

        List<NSIndexPath> paths = new ArrayList<>();
        for (NSIndexPath path : selected)
            paths.add(path);
        return paths;
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
        Native.graphics().refreshDisplay();
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
        if (rowHeight >= 0)
            this.rowHeight = rowHeight;
        layoutSubviews();
    }

    /**
     * Sets the height of the headers' section for this table view.
     *
     * @param sectionHeaderHeight The height of the headers' section for this
     *                            table view.
     */
    @CMSetter("@property(nonatomic) CGFloat sectionHeaderHeight;")
    public void setSectionHeaderHeight(double sectionHeaderHeight) {
        this.sectionHeaderHeight = sectionHeaderHeight;
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
        this.sectionFooterHeight = sectionFooterHeight;
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
        float heightToRow = heightToRowAtIndexPath(path);
        switch (UITableViewScrollPosition) {
            case 1:
                setContentOffset(new CGPoint(0, heightToRow), animated);
                break;
            case 2:
                setContentOffset(new CGPoint(0, heightToRow + rowHeight / 2 - getHeight() / 2), animated);
                break;
            case 3:
                setContentOffset(new CGPoint(0, heightToRow - getHeight()), animated);
                break;
        }
    }

    private float heightToRowAtIndexPath(NSIndexPath path) {
        float heightToRow = 0;
        for (int section = 0; section < (path.section() == 0 ? 1 : path.section()); section++) {
            if (supports(delegate, Optionals.UITable_heightForHeaderInSection))
                heightToRow += delegate.heightForHeaderInSection(UITableView.this, section);
            if (supports(delegate, Optionals.UITable_heightForFooterInSection))
                heightToRow += delegate.heightForFooterInSection(UITableView.this, section);
            for (int row = 0; row < (section == path.section() || path.section() == 0 ? path.row() + 1 : dataSource.numberOfRowsInSection(UITableView.this, path.section())); row++)
                heightToRow += supports(delegate, Optionals.UITable_heightForRowAtIndexPath) ? delegate.heightForRowAtIndexPath(UITableView.this, NSIndexPath.indexPathForRow(row, section)) : rowHeight();
        }
        return heightToRow;
    }

    /**
     * Scrolls the table view,with animation or not, so that at the end of the
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

        double remains;
        switch (UITableViewScrollPosition) {
            case 1:
                remains = contentOffset.getY() % rowHeight;
                setContentOffset(new CGPoint(0, contentOffset.getY() + ((remains <= rowHeight / 2) ? -remains : rowHeight - remains)), animated);
                break;
            case 2:
                remains = (contentOffset.getY() + getHeight() / 2 - rowHeight / 2) % rowHeight;
                setContentOffset(new CGPoint(0, contentOffset.getY() + ((remains <= rowHeight / 2) ? -remains : rowHeight - remains)), animated);
                break;
            case 3:
                remains = (contentOffset.getY() + getHeight()) % rowHeight;
                setContentOffset(new CGPoint(0, contentOffset.getY() + ((remains <= rowHeight / 2) ? -remains : rowHeight - remains)), animated);
                break;
        }
    }

    private List<NSIndexPath> indexPathsForRowsBetween(double yfrom, double yto) {
        List<NSIndexPath> res = new ArrayList<>();
        yfrom -= contentInset.getTop();
        yto -= contentInset.getTop();

        if (yfrom < 0)
            yfrom = 0;
        if (yto > contentSize.getHeight())
            yto = contentSize.getHeight();
        /*
         * Fixed rows
         */
        float sfrom, sto;
        float cfrom, cto;   // for variable height cells
        for (int section = 0; section < metrics.sections; section++) {
            sfrom = metrics.headerEnd[section];
            sto = metrics.footerStart[section];

            if (sfrom >= yto) // End of search

                break;
            else if (sto > yfrom) // We have intersection

                if (metrics.staticHeight) {
                    int first = yfrom <= sfrom ? 0 : (int) ((yfrom - sfrom) / rowHeight);
                    int last = yto >= sto ? metrics.rowsPerSection[section] - 1 : (int) ((yto - sfrom) / rowHeight);
                    if (last >= metrics.rowsPerSection[section])
                        last = metrics.rowsPerSection[section] - 1;
                    for (int i = first; i <= last; i++)
                        res.add(NSIndexPath.indexPathForRow(i, section));
                } else
                    for (int i = 0; i < metrics.rowStart[section].length; i++) {
                        cfrom = metrics.rowStart[section][i];
                        cto = i >= (metrics.rowStart[section].length - 1) ? metrics.footerStart[section] : metrics.rowStart[section][i + 1];  // Use footer metrics if last row, else use next rows's start
                        if (yfrom < cto) { // in the (missin) "else" clause, ignore cells that are earlier than the selection
                            if (yto < cfrom) // ignore cells that are later than this section and break the loop

                                break;
                            res.add(NSIndexPath.indexPathForRow(i, section));
                            if (cto > yto) // ignore cells that are later than this cell, which goes beyond the line

                                break;
                        }
                    }
        }
        return res;
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
        List<NSIndexPath> res = indexPathsForRowsBetween(p.getY(), p.getY() + 1);
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
        return indexPathsForRowsBetween(contentOffset.getY(), contentOffset.getY() + getHeight());
    }

    private void relayoutCell(UITableViewCell cell, NSIndexPath path) {
        cell.path = path;
        double y = getYPathLocation(path);
        double height = metrics.staticHeight ? rowHeight
                : (path.row() == (metrics.rowStart[path.section()].length - 1)
                ? metrics.footerStart[path.section()]
                : metrics.rowStart[path.section()][path.row() + 1])
                - y;
        cell.setFrameImpl(0, y, contentSize.getWidth(), height);
        cell.layoutIfNeeded();
    }

    private double getYPathLocation(NSIndexPath path) {
        return metrics.staticHeight ? metrics.headerEnd[path.section()] + path.row() * rowHeight : metrics.rowStart[path.section()][path.row()];
    }

    private void recycle(UITableViewCell cell) {
        cell.removeFromView(cell.superview());
        if (cell.reuseIdentifier != null) {
            List<UITableViewCell> list = recycle.get(cell.reuseIdentifier);
            if (list == null) {
                list = new ArrayList<>();
                recycle.put(cell.reuseIdentifier, list);
            }
            list.add(cell);
        }
    }

    private UIView[] updateSectionLabels(UIView[] labels, boolean useDelegateForView, boolean useDelegateForText, boolean isHeader) {
        if (labels != null)
            for (int i = 0; i < labels.length; i++) {
                if (labels[i] != null)
                    labels[i].removeFromSuperview();
                labels[i] = null;
            }
        labels = null;
        if (useDelegateForView || useDelegateForText) {
            labels = new UIView[dataSource.numberOfSectionsInTableView(UITableView.this)];
            for (int i = 0; i < labels.length; i++) {
                UIView hview = useDelegateForView ? (isHeader ? delegate.viewForHeaderInSection(this, i) : delegate.viewForFooterInSection(this, i)) : null;
                if (hview == null) {
                    String labeltext = useDelegateForText ? (isHeader ? dataSource.titleForHeaderInSection(this, i) : dataSource.titleForFooterInSection(this, i)) : null;
                    if (labeltext != null) {
                        UILabel label = new UILabel();
                        label.setText(labeltext);
                        label.setTextColor(Theme.Cell.HEADERTEXT);
                        label.setBackgroundColor(Theme.Cell.HEADERBACK);
                        hview = label;
                    }
                }
                addSubview(hview);
                labels[i] = hview;
            }
        }
        return labels;
    }

    @Override
    public void layoutSubviews() {
        metrics.update();
        layoutSubviewsWithoutMetrics();
    }

    void layoutSubviewsWithoutMetrics() {
        Native.system().runAndWaitOnEventThread(layoutSubviews);
    }

    @CMSelector("- (void)registerNib:(UINib *)nib forCellReuseIdentifier:(NSString *)identifier;")
    public void registerNib(UINib nib, String identifier) {
        //TODO implementation
    }

    @CMSelector("- (void)registerClass:(Class)cellClass forCellReuseIdentifier:(NSString *)identifier;")
    public void registerClass(Class<? extends UITableViewCell> cellClass, String identifier) {
        if (identifier == null)
            return;
        if (cellClass == null)
            reusableCells.remove(identifier);
        else
            reusableCells.put(identifier, cellClass);
    }

    private class SectionMetrics {

        private float[][] rowStart; // Height of every row in sections, used only when delegate dictates different heights per cell. If table cells have fixed sizes, then heder|footer start|end is used instead
        private float[] headerStart; // Size of each section header
        private float[] headerEnd; // Size of each section header
        private float[] footerStart; // Size of each section header
        private float[] footerEnd; // Size of each section header
        //
        private int sections = -1;
        private int[] rowsPerSection;
        private boolean staticHeight;

        private double rowHeight(int section, int row) {
            return (staticHeight
                    ? rowHeight
                    : ((row + 1) >= rowsPerSection[section] ? footerStart[section] : rowStart[section][row + 1])) // end
                    - rowStart[section][row];
        }

        private void update() {
            float currentHeight = 0;
            int xsections = sections = -1;  // Use this trick, so that "sections" will be valid ONLY if everything is setup correctly

            if (dataSource != null) {       // Only meaninful if we have data source
                boolean useHeaderDelegate = supports(delegate, UITable_heightForHeaderInSection);
                boolean useFooterDelegate = supports(delegate, UITable_heightForFooterInSection);
                xsections = dataSource.numberOfSectionsInTableView(UITableView.this);
                staticHeight = delegate == null || !supports(delegate, UITable_heightForRowAtIndexPath);

                /*
                 * Calculate section headers
                 */
                if (headerStart == null || headerStart.length != xsections) {
                    headerStart = new float[xsections];
                    headerEnd = new float[xsections];
                    footerStart = new float[xsections];
                    footerEnd = new float[xsections];
                    rowsPerSection = new int[xsections];
                }
                for (int i = 0; i < xsections; i++)
                    rowsPerSection[i] = dataSource.numberOfRowsInSection(UITableView.this, i);

                /*
                 * Calculate section rows
                 */
                if (delegate != null && !staticHeight) {
                    if (rowStart == null || rowStart.length != xsections)
                        rowStart = new float[xsections][];
                    for (int pathSection = 0; pathSection < xsections; pathSection++) {
                        // Calculate header
                        headerStart[pathSection] = currentHeight;
                        currentHeight += updateMetricsForLabel(headers, currentHeight, pathSection, useHeaderDelegate, true);
                        headerEnd[pathSection] = currentHeight;

                        // Calculate rows
                        int rowSize = rowsPerSection[pathSection];
                        if (rowStart[pathSection] == null || rowStart[pathSection].length != rowSize)
                            rowStart[pathSection] = new float[rowSize];
                        for (int pathRow = 0; pathRow < rowSize; pathRow++) {
                            rowStart[pathSection][pathRow] = currentHeight;
                            currentHeight += delegate.heightForRowAtIndexPath(UITableView.this, NSIndexPath.indexPathForRow(pathRow, pathSection));
                        }

                        // Calculate footer
                        footerStart[pathSection] = currentHeight;
                        currentHeight += updateMetricsForLabel(footers, currentHeight, pathSection, useFooterDelegate, false);
                        footerEnd[pathSection] = currentHeight;
                    }
                } else {
                    rowStart = null;
                    for (int section = 0; section < xsections; section++) {
                        // Calculate header
                        headerStart[section] = currentHeight;
                        currentHeight += updateMetricsForLabel(headers, currentHeight, section, useHeaderDelegate, true);
                        headerEnd[section] = currentHeight;

                        // Calculate rows
                        currentHeight += rowsPerSection[section] * UITableView.this.rowHeight;

                        // Calculate footer
                        footerStart[section] = currentHeight;
                        currentHeight += updateMetricsForLabel(footers, currentHeight, section, useFooterDelegate, false);
                        footerEnd[section] = currentHeight;
                    }
                }
                // Table is always able to scroll vertically
                double minimumSize = getHeight() - contentInset.getTop() - contentInset.getBottom();
                CGSize newSize = new CGSize(contentSize.getWidth(), getHeight() > 0 && currentHeight < minimumSize ? minimumSize + 0.001f : currentHeight);
                setContentSize(newSize, false);
            } else {
                rowStart = null;
                headerStart = null;
                headerEnd = null;
                footerStart = null;
                footerEnd = null;
            }
            sections = xsections;// everything is OK now
        }

        private double updateMetricsForLabel(UIView[] labels, double currentHeight, int section, boolean useDelegate, boolean isHeader) {
            double height = 0;
            if (labels != null && labels[section] != null) {
                height = useDelegate
                        ? (isHeader ? delegate.heightForHeaderInSection(UITableView.this, section) : delegate.heightForFooterInSection(UITableView.this, section))
                        : (isHeader ? sectionHeaderHeight : sectionFooterHeight);
                labels[section].setFrame(new CGRect(0, currentHeight, getWidth(), height));
                currentHeight += height;
            }
            return height;
        }
    }

    @CMSetter("@property(nonatomic) CGFloat estimatedRowHeight;")
    public void setEstimatedRowHeight(double estimatedRowHeight) {
        this.estimatedRowHeight = estimatedRowHeight;
    }

    @CMGetter("@property(nonatomic) CGFloat estimatedRowHeight;")
    public double estimatedRowHeight() {
        return estimatedRowHeight;
    }

}
