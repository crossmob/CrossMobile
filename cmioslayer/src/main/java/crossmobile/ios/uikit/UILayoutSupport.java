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
