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

import crossmobile.ios.corelocation.CLLocation;
import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.LocationBridge;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * MKUserLocation class defines an object that represents user's current
 * location on a map.
 */
@CMClass
public class MKUserLocation extends NSObject implements MKAnnotation {

    private final LocationBridge.LocationChangeDelegate delegate = (latitude, longitude) -> {
        location = new CLLocation(latitude, longitude);
    };

    private CLLocation location;
    private boolean updating = true;
    private String title;
    private String subtitle;

    MKUserLocation() {
        this.location = Native.location().lastKnownLocation();
        title = "User location";
        subtitle = "";
        updateLocation();
    }

    void setLocation(CLLocation location) {
        this.location = location;
        updating = false;
        updateLocation();
    }

    /**
     * Returns the current location of the device.
     *
     * @return The current location of the device.
     */
    @CMGetter("@property(readonly, nonatomic) CLLocation *location;")
    public CLLocation location() {
        updateLocation();
        return location;
    }

    /**
     * Returns a Boolean that shows whether user's location is being updated.
     *
     * @return TRUE user's location is being updated.
     */
    @CMGetter("@property(readonly, nonatomic, getter=isUpdating) BOOL updating;")
    public boolean isUpdating() {
        return updating;
    }

    @Override
    public String subtitle() {
        return subtitle;
    }

    /**
     * Sets the subtitle of user's location annotation.
     *
     * @param subtitle The subtitle of user's location annotation.
     */
    @CMSetter("@property(nonatomic, copy) NSString *subtitle;")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public String title() {
        return title;
    }

    /**
     * Sets the title of user's location annotation.
     *
     * @param title The title of user's location annotation.
     */
    @CMSetter("@property(nonatomic, copy) NSString *title;")
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public CLLocationCoordinate2D coordinate() {
        updateLocation();
        return location.coordinate();
    }

    private void updateLocation() {
        if (updating)
            Native.location().startUpdating(delegate);
        else
            Native.location().stopUpdating(delegate);
    }
}
