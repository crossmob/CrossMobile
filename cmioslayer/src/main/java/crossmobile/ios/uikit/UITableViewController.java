/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSIndexPath;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.ArrayList;
import java.util.List;

/**
 * UITableViewController class defines a controller object that handles table
 * views.
 */
@CMClass
public class UITableViewController extends UIViewController implements UITableViewDataSource, UITableViewDelegate {

    private final int style;
    private UITableView tableview;
    private List<UITableViewSection> sections;

    /**
     * The default table view controller constructor.
     */
    public UITableViewController() {
        this(UITableViewStyle.Plain);
    }

    /**
     * Constructs a table view controller with the specified style.
     *
     * @param UITableViewStyle A constant that specifies the style of table view
     *                         that the controller object is to manage (UITableViewStyle.Plain or
     *                         UITableViewStyle.Grouped).
     * @see crossmobile.ios.uikit.UITableViewStyle
     */
    @CMConstructor("- (instancetype)initWithStyle:(UITableViewStyle)style;")
    public UITableViewController(int UITableViewStyle) {
        this.style = UITableViewStyle;
    }

    /**
     * Sets the table view for this view controller.
     *
     * @param tableview The table view for this view controller.
     */
    @CMSetter("@property(nonatomic, strong) UITableView *tableView;")
    public void setTableView(UITableView tableview) {
        this.tableview = tableview;
        tableview.setDataSource(this);
        tableview.setDelegate(this);
    }

    /**
     * Returns the table view of this view controller.
     *
     * @return The table view of this view controller.
     */
    @CMGetter("@property(nonatomic, strong) UITableView *tableView;")
    public UITableView tableView() {
        if (tableview == null)
            setTableView(new UITableView());
        return tableview;
    }

    @Override
    public void loadView() {
        setView(tableView());
        tableView().reloadData();
    }

    @Override
    public String titleForFooterInSection(UITableView table, int section) {
        if (sections == null || sections.isEmpty() || sections.get(section) == null)
            return null;
        return sections.get(section).footerTitle;
    }

    @Override
    public String titleForHeaderInSection(UITableView table, int section) {
        if (sections == null || sections.isEmpty() || sections.get(section) == null)
            return null;
        return sections.get(section).headerTitle;
    }

    @Override
    public UITableViewCell cellForRowAtIndexPath(UITableView tableView, NSIndexPath idx) {
        if (sections == null || sections.isEmpty() || sections.get(idx.section()) == null || sections.get(idx.section()).cells.length < idx.row())
            return null;
        return sections.get(idx.section()).cells[idx.row()];
    }

    @Override
    public int numberOfRowsInSection(UITableView tableView, int section) {
        if (sections == null || sections.isEmpty() || sections.get(section) == null || sections.get(section).cells == null)
            return 0;
        return sections.get(section).cells.length;
    }

    void addSection(String headerTitle, String footerTitle, UITableViewCell[] cells) {
        if (sections == null)
            sections = new ArrayList<>();
        sections.add(new UITableViewSection(headerTitle, footerTitle, cells));
    }

    @Override
    public double heightForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        return -1;
    }

    @Override
    public int numberOfSectionsInTableView(UITableView table) {
        return sections == null || sections.isEmpty() ? 1 : sections.size();
    }

    private static class UITableViewSection {
        String headerTitle;
        String footerTitle;
        UITableViewCell[] cells;

        UITableViewSection(String headerTitle, String footerTitle, UITableViewCell[] cells) {
            this.headerTitle = headerTitle;
            this.footerTitle = footerTitle;
            this.cells = cells == null ? new UITableViewCell[0] : cells;
        }
    }
}
