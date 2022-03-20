/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * NSNumberFormatter class defines an object that manages the representation
 * format of numbers.
 */
@CMClass
public class NSNumberFormatter extends NSObject {

    private int numberStyle;
    private int maximumFractionDigits = 2;

    /**
     * Returns the number-format style applied to this object.
     *
     * @return The number-format style applied to this object.
     * @see crossmobile.ios.foundation.NSNumberFormatterStyle
     */
    @CMGetter("@property NSNumberFormatterStyle numberStyle;")
    public int numberStyle() {
        return numberStyle;
    }

    /**
     * Set the number-format style for this object.
     *
     * @param NSNumberFormatterStyle The number-format style for this object.
     * @see crossmobile.ios.foundation.NSNumberFormatterStyle
     */
    @CMSetter("@property NSNumberFormatterStyle numberStyle;")
    public void setNumberStyle(int NSNumberFormatterStyle) {
        this.numberStyle = NSNumberFormatterStyle;
    }

    /**
     * Returns the maximum number of digits after the decimal separator of this
     * object.
     *
     * @return The maximum number of digits after the decimal separator of this
     * object.
     */
    @CMGetter("@property NSUInteger maximumFractionDigits;")
    public int maximumFractionDigits() {
        return maximumFractionDigits;
    }

    /**
     * Sets the maximum number of digits after the decimal separator for this
     * object.
     *
     * @param maximumFractionDigits The maximum number of digits after the
     *                              decimal separator for this object.
     */
    @CMSetter("@property NSUInteger maximumFractionDigits;")
    public void setMaximumFractionDigits(int maximumFractionDigits) {
        this.maximumFractionDigits = maximumFractionDigits;
    }
}
