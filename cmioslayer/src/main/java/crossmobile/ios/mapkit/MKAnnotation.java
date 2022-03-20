/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * MKAnnotation class defines an object that represents annotation information
 * displayed on a map view.
 */
@CMClass
public interface MKAnnotation {

    /**
     * Define the central point of the annotation.
     *
     * @return The central point as a coordinate.
     */
    @CMGetter("@property(nonatomic, readonly) CLLocationCoordinate2D coordinate")
    public abstract CLLocationCoordinate2D coordinate();

    /**
     * Sets the annotation center's coordinates on the map view.
     *
     * @param newCoordinate The annotation center's coordinates on the map view.
     */
    @CMSelector("- (void)setCoordinate:(CLLocationCoordinate2D) newCoordinate")
    default void setCoordinate(CLLocationCoordinate2D newCoordinate) {
    }

    /**
     * Returns the title of the annotation on the map view.
     *
     * @return The title of the annotation on the map view.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *title")
    default String title() {
        return "";
    }

    /**
     * Returns the subtitle of the annotation on the map view.
     *
     * @return The subtitle of the annotation on the map view.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *subtitle")
    default String subtitle() {
        return "";
    }
}
