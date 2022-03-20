/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.corelocation;

import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * CLLocation class defines an object that represents device's coordinates and
 * altitude that specify its accurate position.
 */
@CMClass
public class CLLocation extends NSObject implements NSSecureCoding {

    private final CLLocationCoordinate2D coordinate;
    private final double altitude;
    private final double horizontalAccuracy;
    private final double verticalAccuracy;
    private final NSDate timestamp;
    private final double speed;
    private final double course;

    /**
     * Constructs a CLLocation object with the specified latitude and longitude
     * parameters.
     *
     * @param latitude  The latitude of the CLLocation object.
     * @param longitude The longitude of the CLLocation object.
     */
    @CMConstructor("- (instancetype)initWithLatitude:(CLLocationDegrees)latitude \n"
            + "                       longitude:(CLLocationDegrees)longitude;")
    public CLLocation(double latitude, double longitude) {
        this(new CLLocationCoordinate2D(latitude, longitude), 0, 0, -1, 0, 0, NSDate.date());
    }

    /**
     * Constructs a CLLocation object with the specified parameters.
     *
     * @param coordinate         A structure that contains the latitude and longitude.
     * @param altitude           The altitude of the location.
     * @param horizontalAccuracy The accuracy of the coordinate.
     * @param verticalAccuracy   The accuracy of the altitude.
     * @param timestamp          The time to associate with the location object.
     */
    @CMConstructor("- (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate \n"
            + "                          altitude:(CLLocationDistance)altitude \n"
            + "                horizontalAccuracy:(CLLocationAccuracy)hAccuracy \n"
            + "                  verticalAccuracy:(CLLocationAccuracy)vAccuracy \n"
            + "                         timestamp:(NSDate *)timestamp;")
    public CLLocation(CLLocationCoordinate2D coordinate, double altitude, double horizontalAccuracy, double verticalAccuracy, NSDate timestamp) {
        this(coordinate, altitude, horizontalAccuracy, verticalAccuracy, 0, 0, timestamp);
    }

    /**
     * Constructs a CLLocation object with the specified parameters.
     *
     * @param coordinate         A structure that contains the latitude and longitude.
     * @param altitude           The altitude of the location.
     * @param horizontalAccuracy The accuracy of the coordinate.
     * @param verticalAccuracy   The accuracy of the altitude.
     * @param course             The direction of traveling.
     * @param speed              The current speed.
     * @param timestamp          The time to associate with the location object.
     */
    @CMConstructor("- (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate \n"
            + "                          altitude:(CLLocationDistance)altitude \n"
            + "                horizontalAccuracy:(CLLocationAccuracy)hAccuracy \n"
            + "                  verticalAccuracy:(CLLocationAccuracy)vAccuracy \n"
            + "                            course:(CLLocationDirection)course \n"
            + "                             speed:(CLLocationSpeed)speed \n"
            + "                         timestamp:(NSDate *)timestamp;")
    public CLLocation(CLLocationCoordinate2D coordinate, double altitude, double horizontalAccuracy, double verticalAccuracy, double course, double speed, NSDate timestamp) {
        this.coordinate = coordinate;
        this.altitude = altitude;
        this.horizontalAccuracy = horizontalAccuracy;
        this.verticalAccuracy = verticalAccuracy;
        this.timestamp = timestamp;
        this.speed = speed;
        this.course = course;
    }

    // TODO location implementation in android
//    CLLocation(Location lctn) {
//        this(new CLLocationCoordinate2D(lctn.latitude(), lctn.longitude()),
//                lctn.altitude(), lctn.accuracy(), -1, lctn.bearing(), lctn.speed(),
//                NSDate.dateWithTimeIntervalSince1970(lctn.time() / 1000d));
//    }

    /**
     * Returns the altitude of the device expressed in meters.
     *
     * @return The altitude of the device expressed in meters.
     */
    @CMGetter("@property(readonly, nonatomic) CLLocationDistance altitude;")
    public double altitude() {
        return altitude;
    }

    /**
     * Returns the geographical coordinates of the device.
     *
     * @return The geographical coordinates of the device.
     */
    @CMGetter("@property(readonly, nonatomic) CLLocationCoordinate2D coordinate;")
    public CLLocationCoordinate2D coordinate() {
        return coordinate;
    }

    /**
     * Returns device's direction as it moves.
     *
     * @return The direction towards which the device is moving.
     */
    @CMGetter("@property(readonly, nonatomic) CLLocationDirection course;")
    public double course() {
        return course;
    }

    /**
     * Returns the radius of location's uncertainty expressed in meters.
     *
     * @return The radius of location's uncertainty expressed in meters.
     */
    @CMGetter("@property(readonly, nonatomic) CLLocationAccuracy horizontalAccuracy;")
    public double horizontalAccuracy() {
        return horizontalAccuracy;
    }

    /**
     * Returns the instantaneous speed of the device expressed in meters per
     * seconds.
     *
     * @return The instantaneous speed of the device expressed in meters per
     * seconds.
     */
    @CMGetter("@property(readonly, nonatomic) CLLocationSpeed speed;")
    public double speed() {
        return speed;
    }

    /**
     * Returns the timestamp of the location record.
     *
     * @return The timestamp of the location record.
     */
    @CMGetter("@property(readonly, nonatomic, copy) NSDate *timestamp;")
    public NSDate timestamp() {
        return timestamp;
    }

    /**
     * Returns the altitude's accuracy expressed in meters.
     *
     * @return The altitude's accuracy expressed in meters.
     */
    @CMGetter("@property(readonly, nonatomic) CLLocationAccuracy verticalAccuracy;\n"
            + "")
    public double verticalAccuracy() {
        return verticalAccuracy;
    }

    /**
     * Returns the distance between this location object and the specified one,
     * expressed in meters.
     *
     * @param location The location object from which the distance is measured.
     * @return The distance between this location object and the specified one,
     * expressed in meters.
     */
    @CMSelector("- (CLLocationDistance)distanceFromLocation:(const CLLocation *)location;\n"
            + "")
    public double distanceFromLocation(CLLocation location) {
        return 0; //TODO  coordinate.distanceFromCoordinates(location.coordinate);
    }

    @Override
    public String toString() {
        return "CLLocation{" + "coordinate=" + coordinate + " alt=" + altitude + " timestamp=" + timestamp + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.coordinate != null ? this.coordinate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CLLocation other = (CLLocation) obj;
        return !(this.coordinate != other.coordinate && (this.coordinate == null || !this.coordinate.equals(other.coordinate)));
    }
}
