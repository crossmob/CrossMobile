/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSIndexPath;
import org.crossmobile.bridge.Native;

import java.util.ArrayList;
import java.util.List;

import static org.crossmobile.bridge.system.BaseUtils.isOverriddenDouble;

@SuppressWarnings("OverridableMethodCallInConstructor")
class cmPickerView extends UIView {

    private UIPickerViewDataSource datasource;
    private UIPickerViewDelegate delegate;
    private final UIPickerView pickerview;
    double widthperwheel;
    List<Wheel> wheels = new ArrayList<>();
    int numberofWheels;

    public cmPickerView(UIPickerViewDataSource datasource, UIPickerViewDelegate delegate, UIPickerView pickerview, CGRect frame) {
        super(frame);
        this.datasource = datasource;
        this.delegate = delegate;
        this.pickerview = pickerview;
        setAutoresizesSubviews(true);
        UIView line = new UIView(new CGRect(0, frame().getSize().getHeight() / 2 - 15, frame().getSize().getWidth(), 1));
        line.setOpaque(true);
        line.setBackgroundColor(UIColor.blackColor());
        addSubview(line);
        UIView line2 = new UIView(new CGRect(0, frame().getSize().getHeight() / 2 + 15, frame().getSize().getWidth(), 1));
        line2.setOpaque(true);
        line2.setBackgroundColor(UIColor.blackColor());
        addSubview(line2);
    }

    void setDataSource(UIPickerViewDataSource datasource) {
        this.datasource = datasource;
        loadWheels();
    }

    void setDelegate(UIPickerViewDelegate delegate) {
        this.delegate = delegate;
    }

    void loadWheels() {
        numberofWheels = datasource.numberOfComponentsInPickerView(pickerview);
        widthperwheel = (cframe().getSize().getWidth() / numberofWheels);
        double originx = 0;
        double width;
        boolean widthInDelegate = delegate != null && isOverriddenDouble(() -> delegate.widthForComponent(pickerview, 0));
        for (int i = 0; i < numberofWheels; i++) {
            width = widthInDelegate ? delegate.widthForComponent(pickerview, i) : widthperwheel;
            wheels.add(new Wheel(new CGRect(originx, 0, width, cframe().getSize().getHeight()), i));
            originx += width;
        }
        for (Wheel wheel : wheels)
            addSubview(wheel);
    }

    void reloadAllComponents() {
        for (Wheel wheel : wheels)
            wheel.reloadData();
    }

    void reloadComponent(int component) {
        wheels.get(component).reloadData();
    }

    void selectRowinComponentanimated(int row, int component, boolean animated) {
        if (row != selectedRowInComponent(component)) {
            wheels.get(component).selectRowAtIndexPath(NSIndexPath.indexPathForRow(row, 0), animated, UITableViewScrollPosition.Top);
            delegate.didSelectRow(pickerview, row, component);
        }
    }

    int selectedRowInComponent(int component) {
        return wheels.get(component).indexPathForSelectedRow() != null ? wheels.get(component).indexPathForSelectedRow().row() : 0;
    }

    CGSize rowSizeForComponent(int component) {
        Native.system().notImplemented();
        return null;
    }

    private class Wheel extends cmPickers.PickerTable {

        public Wheel(CGRect rect, final int component) {
            super(rect);
            final double cellheight = (delegate.rowHeightForComponent(pickerview, component) == 0) ? 30 : delegate.rowHeightForComponent(pickerview, component);
            setContentInset(new UIEdgeInsets(rect.getSize().getHeight() / 2 - cellheight / 2, 0, rect.getSize().getHeight() / 2 - cellheight / 2, 0));
            setShowsVerticalScrollIndicator(false);
            setSeparatorStyle(UITableViewCellSeparatorStyle.None);
            boolean widthInDelegate = delegate != null && isOverriddenDouble(() -> delegate.widthForComponent(pickerview, component));
            setDataSource(new UITableViewDataSource() {
                @Override
                public UITableViewCell cellForRowAtIndexPath(UITableView table, NSIndexPath idx) {
                    Cell cell = new Cell(widthInDelegate ? delegate.widthForComponent(pickerview, component) : widthperwheel, cellheight);
                    Object itemForRow = (delegate.viewForRow(pickerview, idx.row(), component, null) != null)
                            ? delegate.viewForRow(pickerview, idx.row(), component, null)
                            : delegate.titleForRow(pickerview, idx.row(), component);

                    cell.update(itemForRow, idx.row());
                    return cell;
                }

                @Override
                public int numberOfRowsInSection(UITableView table, int section) {
                    return datasource.numberOfRowsInComponent(pickerview, component);
                }
            });
            setDelegate(new UITableViewDelegate() {

                @Override
                public void didSelectRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
                    scrollToRowAtIndexPath(indexPath, UITableViewScrollPosition.Top, true);
                    if (delegate != null)
                        delegate.didSelectRow(pickerview, indexPath.row(), component);
                }
            });
        }

        private class Cell extends UITableViewCell {

            double cellwidth;
            double cellheight;
            UILabel label;
            Object item;
            CGRect subviewrect;

            Cell(double cellwidth, double cellheight) {
                super(UITableViewCellStyle.Default, null);
                this.cellwidth = cellwidth;
                this.cellheight = cellheight;
                setSelectionStyle(UITableViewCellSelectionStyle.None);
                setSize(cellwidth, cellheight);
            }

            void update(Object item, int idx) {
                subviewrect = new CGRect(0, 0, cellwidth, cellheight);
                this.item = item;
                if (item instanceof String) {
                    label = new UILabel(subviewrect);
                    label.setTextAlignment(UITextAlignment.Center);
                    addSubview(label);
                }
                if (item instanceof String)
                    label.setText((String) item);
                else
                    addSubview((UIView) item);
            }

            Object getItem() {
                return item;
            }
        }
    }
}
