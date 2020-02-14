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
