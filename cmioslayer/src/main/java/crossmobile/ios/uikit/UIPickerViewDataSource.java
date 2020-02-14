/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIPickerViewDataSource provides the structure to be implemented when
 * information related to number of components and rows of picker view is
 * needed.
 */
@CMClass
public interface UIPickerViewDataSource {

    /**
     * Used when the number of components of the specified picker view is
     * needed.
     *
     * @param view The picker view for which the number of components is needed.
     * @return The number of components for this picker view.
     */
    @CMSelector("- (NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView;")
    public int numberOfComponentsInPickerView(UIPickerView view);

    /**
     * Used when the number of rows of a specified component of a picker view is
     * needed.
     *
     * @param view      The picker view for which the number of rows is needed.
     * @param component The component of the picker view for which the number of
     *                  rows is needed.
     * @return The number of rows for the specified component of the picker
     * view.
     */
    @CMSelector("- (NSInteger)pickerView:(UIPickerView *)pickerView \n"
            + "numberOfRowsInComponent:(NSInteger)component;")
    public int numberOfRowsInComponent(UIPickerView view, int component);
}
