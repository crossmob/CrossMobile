/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * NSLayoutDimension class defines an object that is responsible for creating
 * NSLayoutConstraint objects used for Auto Layout.
 */
@CMClass
public class NSLayoutDimension extends NSLayoutAnchor {

    /**
     * Constructs a NSLayoutDimension object for the specified item with the
     * defined NSLayoutAttribute value.
     *
     * @param item
     * @param NSLayoutAttribute
     * @see crossmobile.ios.uikit.NSLayoutAttribute
     */
    NSLayoutDimension(Object item, int NSLayoutAttribute) {
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

    /**
     * Returns a NSLayoutConstraint that defines the anchor's size to be as
     * equal to the specified anchor's size multiplied by the specified
     * multiplier.
     *
     * @param anchor     The NSLayoutDimension that is used from a UIView, NSView,
     *                   or UILayoutGuide object.
     * @param multiplier The multiplier used.
     * @return The calculated NSLayoutConstraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutDimension *)anchor \n"
            + "                                     multiplier:(CGFloat)m;")
    public NSLayoutConstraint constraintEqualToAnchor(NSLayoutDimension anchor, double multiplier) {
        return super.anchorConstraint(NSLayoutRelation.RelationEqual, anchor, multiplier, 0);
    }

    /**
     * Returns a NSLayoutConstraint that defines the anchor's size to be as
     * equal to the specified anchor's size multiplied by the specified
     * multiplier plus an offset.
     *
     * @param anchor     The NSLayoutDimension that is used from a UIView, NSView,
     *                   or UILayoutGuide object.
     * @param multiplier The multiplier used.
     * @param constant   The constant used as offset.
     * @return The calculated NSLayoutConstraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutDimension *)anchor \n"
            + "                                     multiplier:(CGFloat)m \n"
            + "                                       constant:(CGFloat)c;")
    public NSLayoutConstraint constraintEqualToAnchor(NSLayoutDimension anchor, double multiplier, double constant) {
        return super.anchorConstraint(NSLayoutRelation.RelationEqual, anchor, multiplier, constant);
    }

    /**
     * Returns a NSLayoutConstraint that defines the anchor's size to be as
     * equal to the specified constant.
     *
     * @param constant The size of the anchor.
     * @return The calculated NSLayoutConstraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintEqualToConstant:(CGFloat)c;")
    public NSLayoutConstraint constraintEqualToConstant(double constant) {
        return super.anchorConstraint(NSLayoutRelation.RelationEqual, new NSLayoutAnchor(null, NSLayoutAttribute.NotAnAttribute), 1, constant);
    }

    /**
     * Returns a NSLayoutConstraint that defines the anchor's size to be greater
     * than or equal to the specified anchor's size multiplied by the specified
     * multiplier.
     *
     * @param anchor     The NSLayoutDimension that is used from a UIView, NSView,
     *                   or UILayoutGuide object.
     * @param multiplier The multiplier used.
     * @return The calculated NSLayoutConstraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutDimension *)anchor \n"
            + "                                                  multiplier:(CGFloat)m;")
    public NSLayoutConstraint constraintGreaterThanOrEqualToAnchor(NSLayoutDimension anchor, double multiplier) {
        return super.anchorConstraint(NSLayoutRelation.GreaterThanOrEqual, anchor, multiplier, 0);
    }

    /**
     * Returns a NSLayoutConstraint that defines the anchor's size to be greater
     * than or equal to the specified anchor's size multiplied by the specified
     * multiplier plus an offset.
     *
     * @param anchor     The NSLayoutDimension that is used from a UIView, NSView,
     *                   or UILayoutGuide object.
     * @param multiplier The multiplier used.
     * @param constant   The constant used as offset.
     * @return The calculated NSLayoutConstraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutDimension *)anchor \n"
            + "                                                  multiplier:(CGFloat)m \n"
            + "                                                    constant:(CGFloat)c;")
    public NSLayoutConstraint constraintGreaterThanOrEqualToAnchor(NSLayoutDimension anchor, double multiplier, double constant) {
        return super.anchorConstraint(NSLayoutRelation.GreaterThanOrEqual, anchor, multiplier, constant);
    }

    /**
     * Returns a NSLayoutConstraint that defines the minimum anchor's size equal
     * to specified constant.
     *
     * @param constant The minimum anchor's size.
     * @return The calculated NSLayoutConstraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintGreaterThanOrEqualToConstant:(CGFloat)c;")
    public NSLayoutConstraint constraintGreaterThanOrEqualToConstant(double constant) {
        return super.anchorConstraint(NSLayoutRelation.GreaterThanOrEqual, new NSLayoutAnchor(null, NSLayoutAttribute.NotAnAttribute), 1, constant);
    }

    /**
     * Returns a NSLayoutConstraint that defines the anchor's size to be less
     * than or equal to the specified anchor's size multiplied by the specified
     * multiplier.
     *
     * @param anchor     The NSLayoutDimension that is used from a UIView, NSView,
     *                   or UILayoutGuide object.
     * @param multiplier The multiplier used.
     * @return The calculated NSLayoutConstraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutDimension *)anchor \n"
            + "                                               multiplier:(CGFloat)m;")
    public NSLayoutConstraint constraintLessThanOrEqualToAnchor(NSLayoutDimension anchor, double multiplier) {
        return super.anchorConstraint(NSLayoutRelation.LessThanOrEqual, anchor, multiplier, 0);
    }

    /**
     * Returns a NSLayoutConstraint that defines the anchor's size to be greater
     * than or equal to the specified anchor's size multiplied by the specified
     * multiplier plus an offset.
     *
     * @param anchor     The NSLayoutDimension that is used from a UIView, NSView,
     *                   or UILayoutGuide object.
     * @param multiplier The multiplier used.
     * @param constant   The constant used as an offset.
     * @return The calculated NSLayoutConstraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutDimension *)anchor \n"
            + "                                               multiplier:(CGFloat)m \n"
            + "                                                 constant:(CGFloat)c;")
    public NSLayoutConstraint constraintLessThanOrEqualToAnchor(NSLayoutDimension anchor, double multiplier, double constant) {
        return super.anchorConstraint(NSLayoutRelation.LessThanOrEqual, anchor, multiplier, constant);
    }

    /**
     * Returns a NSLayoutConstraint that defines the maximum anchor's size equal
     * to specified constant.
     *
     * @param constant The maximum size of the anchor.
     * @return The calculated NSLayoutConstraint.
     */
    @CMSelector("- (NSLayoutConstraint *)constraintLessThanOrEqualToConstant:(CGFloat)c;")
    public NSLayoutConstraint constraintLessThanOrEqualToConstant(double constant) {
        return super.anchorConstraint(NSLayoutRelation.LessThanOrEqual, new NSLayoutAnchor(null, NSLayoutAttribute.NotAnAttribute), 1, constant);
    }
}
