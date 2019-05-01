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
    public default boolean intersectsMapRect(MKMapRect mapRect) {
        return false;
    }

    /**
     * Provide if this overlay can replace the content of the underlying map
     *
     * @return true, if the content can be replaced
     */
    @CMSelector("- (BOOL)canReplaceMapContent")
    public default boolean canReplaceMapContent() {
        return true;
    }
}
