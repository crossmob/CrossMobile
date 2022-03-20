/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * MKOverlay class defines an object that represents a map annotation for both
 * point and area.
 */
@CMClass
public interface MKOverlay extends MKAnnotation {

    /**
     * Returns the rectangle that encloses the overlay.
     *
     * @return The rectangle that encloses the overlay.
     */
    @CMGetter("@property(nonatomic, readonly) MKMapRect boundingMapRect;")
    public MKMapRect boundingMapRect();

    /**
     * Returns a Boolean that shows whether the given rectangle intersects the
     * receiver.
     *
     * @param mapRect The rectangle that is checked for intersection.
     * @return TRUE then the rectangle intersects the area of the object.
     */
    @CMSelector("- (BOOL)intersectsMapRect:(MKMapRect)mapRect")
    default boolean intersectsMapRect(MKMapRect mapRect) {
        return false;
    }

    /**
     * Provide if this overlay can replace the content of the underlying map
     *
     * @return true, if the content can be replaced
     */
    @CMSelector("- (BOOL)canReplaceMapContent")
    default boolean canReplaceMapContent() {
        return true;
    }
}
