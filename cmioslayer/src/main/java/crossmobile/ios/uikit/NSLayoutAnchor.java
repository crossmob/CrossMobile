/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * NSLayoutAnchor class defines an object that is used as constraint when
 * applying Auto Layout.
 */
@CMClass(typeAlias = "AnchorType")
public class NSLayoutAnchor extends NSObject {

    final Object item;
    final int attribute;

    /**
     * Constructs an NSLayoutAnchor object for the specified item with the
     * defined NSLayoutAttribute value.
     *
     * @param item
     * @param NSLayoutAttribute
     */
    NSLayoutAnchor(Object item, int NSLayoutAttribute) {
        this.item = item;
        attribute = NSLayoutAttribute;
    }

    /**
     * Returns a constraint that is equal to the constraint of the given anchor.
     *
     * @param anchor The layout anchor of an object.
     * @return The resulting constraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutAnchor *)anchor;")
    public NSLayoutConstraint constraintEqualToAnchor(NSLayoutAnchor anchor) {
        return anchorConstraint(NSLayoutRelation.RelationEqual, anchor, 1, 0);
    }

    /**
     * Returns a constraint that is equal to the constraint of the given anchor
     * plus a constant.
     *
     * @param anchor   The layout anchor of an object.
     * @param constant The constant added to the given anchor.
     * @return The resulting constraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutAnchor *)anchor \n"
            + "                                       constant:(CGFloat)c;")
    public NSLayoutConstraint constraintEqualToAnchor(NSLayoutAnchor anchor, double constant) {
        return anchorConstraint(NSLayoutRelation.RelationEqual, anchor, 1, constant);
    }

    /**
     * Returns a constraint that is greater than or equal to the constraint of
     * the given anchor.
     *
     * @param anchor The layout anchor of an object.
     * @return The resulting constraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutAnchor *)anchor;")
    public NSLayoutConstraint constraintGreaterThanOrEqualToAnchor(NSLayoutAnchor anchor) {
        return anchorConstraint(NSLayoutRelation.GreaterThanOrEqual, anchor, 1, 0);
    }

    /**
     * Returns a constraint that is greater than or equal to the constraint of
     * the given anchor plus a constant.
     *
     * @param anchor   The layout anchor of an object.
     * @param constant The constant added to the given anchor.
     * @return The resulting constraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutAnchor *)anchor \n"
            + "                                                    constant:(CGFloat)c;")
    public NSLayoutConstraint constraintGreaterThanOrEqualToAnchor(NSLayoutAnchor anchor, double constant) {
        return anchorConstraint(NSLayoutRelation.GreaterThanOrEqual, anchor, 1, constant);
    }

    /**
     * Returns a constraint that is less than or equal to the constraint of the
     * given anchor.
     *
     * @param anchor The layout anchor of an object.
     * @return The resulting constraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutAnchor *)anchor;")
    public NSLayoutConstraint constraintLessThanOrEqualToAnchor(NSLayoutAnchor anchor) {
        return anchorConstraint(NSLayoutRelation.LessThanOrEqual, anchor, 1, 0);
    }

    /**
     * Returns a constraint that is less than or equal to the constraint of the
     * given anchor plus a constant.
     *
     * @param anchor   The layout anchor of an object.
     * @param constant The constant added to the given anchor.
     * @return The resulting constraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutAnchor *)anchor \n"
            + "                                                 constant:(CGFloat)c;")
    public NSLayoutConstraint constraintLessThanOrEqualToAnchor(NSLayoutAnchor anchor, double constant) {
        return anchorConstraint(NSLayoutRelation.LessThanOrEqual, anchor, 1, constant);
    }

    NSLayoutConstraint anchorConstraint(int NSLayoutRelation, NSLayoutAnchor anchor, double multiplier, double constant) {
        return NSLayoutConstraint.constraintWithItem(item, attribute, NSLayoutRelation, anchor.item, anchor.attribute, multiplier, constant);
    }

    @Override
    public String toString() {
        return SystemUtilities.getClassName(getClass()) + " attribute=" + attributeToString(attribute) + " item=" + item.toString();

    }

    private static String attributeToString(int attribute) {
        switch (attribute) {
            case 1:
                return "Left";
            case 2:
                return "Right";
            case 3:
                return "Top";
            case 4:
                return "Bottom";
            case 5:
                return "Leading";
            case 6:
                return "Trailing";
            case 7:
                return "Width";
            case 8:
                return "Height";
            case 9:
                return "CenterX";
            case 10:
                return "CenterY";
            case 11:
                return "Baseline";
            case 12:
                return "FirstBaseline";
            case 13:
                return "LeftMargin";
            case 14:
                return "RightMargin";
            case 15:
                return "TopMargin";
            case 16:
                return "BottomMargin";
            case 17:
                return "LeadingMargin";
            case 18:
                return "TrailingMargin";
            case 19:
                return "CenterXWithinMargins";
            case 20:
                return "CenterYWithinMargins";
            case 0:
            default:
                return "NotAnAttribute";
        }
    }
}
