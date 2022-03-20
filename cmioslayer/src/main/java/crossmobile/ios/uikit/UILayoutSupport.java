/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

/**
 * A set of methods that provide layout support and access to layout anchors.
 */
@CMClass
public interface UILayoutSupport {

    /**
     * Returns the length of the part of the ViewController that
     * is covered by translucent or transparent UIkit bars
     *
     * @return Returns the length of the part of the ViewController that is covered by translucent or transparent UIkit bars
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat length;")
    public double length();

    /**
     * Returns the layout anchor for the bottom edge.
     *
     * @return The layout anchor for the bottom edge.
     */
    @CMGetter("@property(readonly, strong) NSLayoutYAxisAnchor *bottomAnchor;")
    public NSLayoutYAxisAnchor bottomAnchor();

    /**
     * Returns the layout anchor for the height.
     *
     * @return The layout anchor for the height.
     */
    @CMGetter("@property(readonly, strong) NSLayoutDimension *heightAnchor;")
    public NSLayoutDimension heightAnchor();

    /**
     * Returns the layout anchor for the top edge.
     *
     * @return The layout anchor for the top edge.
     */
    @CMGetter("@property(readonly, strong) NSLayoutYAxisAnchor *topAnchor;")
    public NSLayoutYAxisAnchor topAnchor();
}
