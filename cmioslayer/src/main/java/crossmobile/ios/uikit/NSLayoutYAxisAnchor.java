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

import org.crossmobile.bridge.ann.CMClass;

/**
 * NSLayoutYAxisAnchor class defines an object that is used as a vertical
 * constraint when applying Auto Layout.
 */
@CMClass
public class NSLayoutYAxisAnchor extends NSLayoutAnchor {

    /**
     * Constructs an NSLayoutYAxisAnchor object for the specified item with the
     * defined NSLayoutAttribute value.
     *
     * @param item
     * @param NSLayoutAttribute
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    NSLayoutYAxisAnchor(Object item, int NSLayoutAttribute) {
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
