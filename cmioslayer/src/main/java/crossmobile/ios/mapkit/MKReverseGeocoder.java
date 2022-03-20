/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

/**
 * MKReverseGeocoder class defines an object whose function is to convert a map
 * coordinate to a full detailed mark place.
 */
@CMClass
@Deprecated
public class MKReverseGeocoder extends NSObject {

    private MKReverseGeocoderDelegate delegate;
    private final CLLocationCoordinate2D coordinate;
    private final MKPlacemark placemark;
    private boolean querying;

    /**
     * Constructs an MKReverseGeocoder object with the specified coordinates.
     *
     * @param coordinate The coordinates of the MKReverseGeocoder object.
     */
    @Deprecated
    @CMConstructor("- (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate;")
    public MKReverseGeocoder(CLLocationCoordinate2D coordinate) {
        this.coordinate = coordinate;
        placemark = null;
    }

    /**
     * Returns the coordinates of place mark that whose reverse-geocoding is
     * needed.
     *
     * @return The coordinates of the place mark to be reverse-geocoded.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readonly) CLLocationCoordinate2D coordinate;")
    public CLLocationCoordinate2D coordinate() {
        return coordinate;
    }

    /**
     * Returns the result of the reverse-geocoding process.
     *
     * @return The result of the reverse-geocoding process.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readonly) MKPlacemark *placemark;")
    public MKPlacemark placemark() {
        return placemark;
    }

    /**
     * Returns a Boolean that shows whether this MKReverseGeocoder is currently
     * reverse-geocoding.
     *
     * @return TRUE the MKReverseGeocoder is currently reverse-geocoding.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readonly, getter=isQuerying) BOOL querying;")
    public boolean isQuerying() {
        return querying;
    }

    /**
     * Returns the delegate for this MKReverseGeocoder object.
     *
     * @return The delegate for this MKReverseGeocoder object.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, weak) id<MKReverseGeocoderDelegate> delegate;")
    public MKReverseGeocoderDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this MKReverseGeocoder object.
     *
     * @param delegate The delegate for this MKReverseGeocoder object.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, weak) id<MKReverseGeocoderDelegate> delegate;")
    public void setDelegate(MKReverseGeocoderDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Starts a reverse-geocoding process.
     */
    @Deprecated
    @CMSelector("- (void)start;")
    public void start() {
        Native.system().notImplemented();
    }

    /**
     * Cancels a reverse-geocoding request.
     */
    @Deprecated
    @CMSelector("- (void)cancel;")
    public void cancel() {
        Native.system().notImplemented();
    }
}
