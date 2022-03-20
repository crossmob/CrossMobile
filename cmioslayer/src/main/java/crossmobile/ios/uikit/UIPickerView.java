/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.List;

/**
 * UIPickerView class defines an object that is depicted as one or more spinning
 * wheels containing a sets of values. The user can rotate the wheels and a
 * select values.
 */
@CMClass
public class UIPickerView extends UIView {

    private static final float BORDER = 4;
    //
    private static final UIPickerViewDataSource EMPTYDATASOURCE = new UIPickerViewDataSource() {
        @Override
        public int numberOfComponentsInPickerView(UIPickerView view) {
            return 1;
        }

        @Override
        public int numberOfRowsInComponent(UIPickerView view, int component) {
            return 0;
        }
    };
    private static final UIPickerViewDelegate EMPTYDELEGATE = new UIPickerViewDelegate() {
    };

    private static class SingleWheelView {

        public SingleWheelView() {
        }

        private void removeFromSuperview() {
            Native.system().notImplemented();
        }

        private void reloadData() {
            Native.system().notImplemented();
        }

        private int selectedRow() {
            Native.system().notImplemented();
            return 0;
        }

        private void selectRow(int row, boolean animated) {
            Native.system().notImplemented();
        }
    }

    //
    //
    private UIPickerViewDataSource dataSource = EMPTYDATASOURCE;
    private UIPickerViewDelegate delegate = EMPTYDELEGATE;
    private boolean showsSelectionIndicator;
    //
    //
    private final List<SingleWheelView> wheels = new ArrayList<SingleWheelView>();
    private cmPickerView picker;

    /**
     * Constructs a default UIPickerView object located at (0,0) with 0 weight
     * and 0 height.
     */
    public UIPickerView() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIPickerView object initialized with the dimensions and
     * position specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of UIPickerView.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UIPickerView(CGRect rect) {
        super(rect);
        picker = new cmPickerView(dataSource, delegate, this, new CGRect(0, 0, rect.getSize().getWidth(), rect.getSize().getHeight()));
        addSubview(picker);
    }

    /**
     * Returns the number of components that constitute this picker view.
     *
     * @return The number of components that constitute this picker view.
     */
    @CMGetter("@property(nonatomic, readonly) NSInteger numberOfComponents;")
    public int numberOfComponents() {
        return dataSource.numberOfComponentsInPickerView(this);
    }

    /**
     * Returns the number of rows(set of values) of this component.
     *
     * @param component The component for which is the query.
     * @return The number of rows of this component.
     */
    @CMSelector("- (NSInteger)numberOfRowsInComponent:(NSInteger)component;")
    public int numberOfRowsInComponent(int component) {
        return dataSource.numberOfRowsInComponent(this, component);
    }

    /**
     * Returns the size of the row for this component that corresponds to the
     * largest string or view displayed.
     *
     * @param component The component for which is the query.
     * @return The size of the row for this component.
     */
    @CMSelector("- (CGSize)rowSizeForComponent:(NSInteger)component;")
    public CGSize rowSizeForComponent(int component) {
        return picker.rowSizeForComponent(component);
    }

    /**
     * Returns the view of the specified row and component.Returns NULL if the
     * row is not visible.
     *
     * @param row       The row for which is the query.
     * @param component The component for which is the query.
     * @return The view of the specified row and component
     */
    @CMSelector("- (UIView *)viewForRow:(NSInteger)row \n" +
            "          forComponent:(NSInteger)component;")
    public UIView viewForRow(int row, int component) {
        return delegate.viewForRow(this, row, component, null);
    }

    /**
     * Returns the data source of this picker view.
     *
     * @return The data source of this picker view.
     */
    @CMGetter("@property(nonatomic, weak) id<UIPickerViewDataSource> dataSource;")
    public UIPickerViewDataSource dataSource() {
        return dataSource;
    }

    /**
     * Sets the data source for this picker view.
     *
     * @param dataSource The data source of this picker view.
     */
    @CMSetter("@property(nonatomic, weak) id<UIPickerViewDataSource> dataSource;")
    public void setDataSource(UIPickerViewDataSource dataSource) {
        if (dataSource == null)
            dataSource = EMPTYDATASOURCE;
        if (this.dataSource == dataSource)
            return;

        picker.setDataSource(dataSource);
        this.dataSource = dataSource;
        reloadAllComponents();
    }

    /**
     * Returns the delegate of this picker view.
     *
     * @return The delegate of this picker view.
     */
    @CMGetter("@property(nonatomic, weak) id<UIPickerViewDelegate> delegate;")
    public UIPickerViewDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this picker view.
     *
     * @param delegate The delegate for this picker view.
     */
    @CMSetter("@property(nonatomic, weak) id<UIPickerViewDelegate> delegate;")
    public void setDelegate(UIPickerViewDelegate delegate) {
        if (delegate == null)
            delegate = EMPTYDELEGATE;
        if (this.delegate == delegate)
            return;
        this.delegate = delegate;
        picker.setDelegate(delegate);
        reloadAllComponents();
    }

    /**
     * Returns a Boolean that shows whether selection indicator is displayed.
     *
     * @return A Boolean that shows whether selection indicator is displayed.
     */
    @CMGetter("@property(nonatomic) BOOL showsSelectionIndicator;")
    public boolean showsSelectionIndicator() {
        return showsSelectionIndicator;
    }

    /**
     * Sets a Boolean that defines whether selection indicator is displayed.
     *
     * @param showsSelectionIndicator A Boolean that defines whether selection
     *                                indicator is displayed
     */
    @CMSetter("@property(nonatomic) BOOL showsSelectionIndicator;")
    public void setShowsSelectionIndicator(boolean showsSelectionIndicator) {
        this.showsSelectionIndicator = showsSelectionIndicator;
    }

    /**
     * Reload the data of all components.
     */
    @CMSelector("- (void)reloadAllComponents;")
    public void reloadAllComponents() {
        picker.reloadAllComponents();
    }

    /**
     * Reloads the data of the specified component.
     *
     * @param component The component for which the data are reloaded.
     */
    @CMSelector("- (void)reloadComponent:(NSInteger)component;")
    public void reloadComponent(int component) {
        picker.reloadComponent(component);
    }

    /**
     * Returns the selected row of the specified component.
     *
     * @param component The component for which the selected row is requested.
     * @return The selected row of the component.
     */
    @CMSelector("- (NSInteger)selectedRowInComponent:(NSInteger)component;")
    public int selectedRowInComponent(int component) {
        return picker.selectedRowInComponent(component);
    }

    /**
     * Sets the specified row of this component as selected using animation or not.
     *
     * @param row       The new selected row.
     * @param component The component whose row is selected.
     * @param animated  TRUE if selection is animated.
     */
    @CMSelector("- (void)selectRow:(NSInteger)row \n" +
            "      inComponent:(NSInteger)component \n" +
            "         animated:(BOOL)animated;")
    public void selectRow(int row, int component, boolean animated) {
        picker.selectRowinComponentanimated(row, component, animated);
    }
}
