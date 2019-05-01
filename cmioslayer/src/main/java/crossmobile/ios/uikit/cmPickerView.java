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

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSIndexPath;
import org.crossmobile.bridge.Native;

import java.util.ArrayList;
import java.util.List;

import static org.crossmobile.bind.system.Optionals.UIPicker_useDelegateForWidth;
import static org.crossmobile.bind.system.Optionals.supports;

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
        widthperwheel = (getWidth() / numberofWheels);
        double originx = 0;
        double width;
        for (int i = 0; i < numberofWheels; i++) {
            width = supports(delegate, UIPicker_useDelegateForWidth) ? delegate.widthForComponent(pickerview, i) : widthperwheel;
            wheels.add(new Wheel(new CGRect(originx, 0, width, getHeight()), i));
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
        Native.lifecycle().notImplemented();
        return null;
    }

    private class Wheel extends cmPickers.PickerTable {

        public Wheel(CGRect rect, final int component) {
            super(rect);
            final double cellheight = (delegate.rowHeightForComponent(pickerview, component) == 0) ? 30 : delegate.rowHeightForComponent(pickerview, component);
            setContentInset(new UIEdgeInsets(rect.getSize().getHeight() / 2 - cellheight / 2, 0, rect.getSize().getHeight() / 2 - cellheight / 2, 0));
            setShowsVerticalScrollIndicator(false);
            setSeparatorStyle(UITableViewCellSeparatorStyle.None);
            setDataSource(new UITableViewDataSource() {
                @Override
                public UITableViewCell cellForRowAtIndexPath(UITableView table, NSIndexPath idx) {
                    Cell cell;
                    cell = new Cell(
                            supports(delegate, UIPicker_useDelegateForWidth) ? delegate.widthForComponent(pickerview, component) : widthperwheel,
                            cellheight);
                    Object itemforrow = (delegate.viewForRow(pickerview, idx.row(), component, null) != null)
                            ? delegate.viewForRow(pickerview, idx.row(), component, null)
                            : delegate.titleForRow(pickerview, idx.row(), component);

                    cell.update(itemforrow, idx.row());
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
                    if (indexPath != null && delegate != null)
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
                    label.setBackgroundColor(UIColor.clearColor());
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
