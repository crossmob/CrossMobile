/*
 * (c) 2019 by Panayotis Katsaloulis
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

/**
 * NSLayoutXAxisAnchor class defines an object that is used as a horizontal
 * constraint when applying Auto Layout.
 */
@CMClass
public class NSLayoutXAxisAnchor extends NSLayoutAnchor {

    /**
     * Constructs an NSLayoutXAxisAnchor object for the specified item with the
     * defined NSLayoutAttribute value.
     *
     * @param item
     * @param NSLayoutAttribute
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    NSLayoutXAxisAnchor(Object item, int NSLayoutAttribute) {
        super(item, NSLayoutAttribute);
    }

    @Override
    public NSLayoutConstraint constraintLessThanOrEqualToAnchor(NSLayoutAnchor anchor, double constant) {
        if (anchor.getClass().equals(this.getClass()))
            return super.constraintLessThanOrEqualToAnchor(anchor, constant);
        return null;
    }

    @Override
    public NSLayoutConstraint constraintLessThanOrEqualToAnchor(NSLayoutAnchor anchor) {
        if (anchor.getClass().equals(this.getClass()))
            return super.constraintLessThanOrEqualToAnchor(anchor);
        return null;
    }

    @Override
    public NSLayoutConstraint constraintGreaterThanOrEqualToAnchor(NSLayoutAnchor anchor, double constant) {
        if (anchor.getClass().equals(this.getClass()))
            return super.constraintGreaterThanOrEqualToAnchor(anchor, constant);
        return null;
    }

    @Override
    public NSLayoutConstraint constraintGreaterThanOrEqualToAnchor(NSLayoutAnchor anchor) {
        if (anchor.getClass().equals(this.getClass()))
            return super.constraintGreaterThanOrEqualToAnchor(anchor);
        return null;
    }

    @Override
    public NSLayoutConstraint constraintEqualToAnchor(NSLayoutAnchor anchor, double constant) {
        if (anchor.getClass().equals(this.getClass()))
            return super.constraintEqualToAnchor(anchor, constant);
        return null;
    }

    @Override
    public NSLayoutConstraint constraintEqualToAnchor(NSLayoutAnchor anchor) {
        if (anchor.getClass().equals(this.getClass()))
            return super.constraintEqualToAnchor(anchor);
        return null;
    }
}
