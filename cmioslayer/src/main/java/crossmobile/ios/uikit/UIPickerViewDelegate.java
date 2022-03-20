/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIPickerViewDelegate interface is the delegate responsible to collaborate
 * with picker view objects.
 */
@CMClass
public interface UIPickerViewDelegate {

    /**
     * It is used in order to get the height of the row of a particular
     * component for drawing its content.
     *
     * @param view      The picker view that corresponds to this delegate.
     * @param component The component of the picker view defined by its index.
     * @return The height of the row.
     */
    @CMSelector("- (CGFloat)pickerView:(UIPickerView *)pickerView \n"
            + "rowHeightForComponent:(NSInteger)component;")
    default double rowHeightForComponent(UIPickerView view, int component) {
        return 0;
    }

    /**
     * It is used in order to get the width of the row of a particular component
     * for drawing its content.
     *
     * @param view      The picker view that corresponds to this delegate.
     * @param component The component of the picker view defined by its index.
     * @return The width of the row .
     */
    @CMSelector("- (CGFloat)pickerView:(UIPickerView *)pickerView \n"
            + "    widthForComponent:(NSInteger)component;")
    default double widthForComponent(UIPickerView view, int component) {
        return Double.NaN;
    }

    /**
     * It is used in order to display a view in the row of a particular
     * component.
     *
     * @param view       The picker view that corresponds to this delegate.
     * @param row        The row of the picker view.
     * @param component  The component of the picker view defined by its index.
     * @param reusedView A previously used view for this row.
     * @return The view to be displayed in this row.
     */
    @CMSelector("- (UIView *)pickerView:(UIPickerView *)pickerView \n"
            + "            viewForRow:(NSInteger)row \n"
            + "          forComponent:(NSInteger)component \n"
            + "           reusingView:(UIView *)view;")
    default UIView viewForRow(UIPickerView view, int row, int component, UIView reusedView) {
        return null;
    }

    /**
     * It is used when the title of the row of a particular component is needed.
     *
     * @param view      The picker view that corresponds to this delegate.
     * @param row       The row of the picker view.
     * @param component The component of the picker view defined by its index.
     * @return The title of the row.
     */
    @CMSelector("- (NSString *)pickerView:(UIPickerView *)pickerView \n"
            + "             titleForRow:(NSInteger)row \n"
            + "            forComponent:(NSInteger)component;")
    default String titleForRow(UIPickerView view, int row, int component) {
        return null;
    }

    /**
     * It is used in order to handle the fact that the user picked a row of a
     * particular component.
     *
     * @param view      The picker view that corresponds to this delegate.
     * @param row       The row of the picker view.
     * @param component The component of the picker view defined by its index.
     */
    @CMSelector("- (void)pickerView:(UIPickerView *)pickerView \n"
            + "      didSelectRow:(NSInteger)row \n"
            + "       inComponent:(NSInteger)component;")
    default void didSelectRow(UIPickerView view, int row, int component) {
    }
}
