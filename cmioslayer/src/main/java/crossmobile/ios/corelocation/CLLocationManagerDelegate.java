/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.corelocation;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * CLLocationManagerDelegate interface is the delegate that is responsible for
 * handling operations related to CLLocationManager objects.
 */
@CMClass
public interface CLLocationManagerDelegate {

    /**
     * It is used after a location update.
     *
     * @param manager     The manager that corresponds to this delegate.
     * @param newLocation The new location.
     * @param oldLocation The old location.
     */
    @Deprecated
    @CMSelector("- (void)locationManager:(CLLocationManager *)manager \n"
            + "    didUpdateToLocation:(CLLocation *)newLocation \n"
            + "           fromLocation:(CLLocation *)oldLocation;")
    default void didUpdateToLocation(CLLocationManager manager, CLLocation newLocation, CLLocation oldLocation) {
    }

    /**
     * It is used when the retrieval of a location failed.
     *
     * @param manager The manager that corresponds to this delegate.
     * @param error   The error of the retrieval failure.
     */
    @Deprecated
    @CMSelector("- (void)locationManager:(CLLocationManager *)manager \n"
            + "       didFailWithError:(NSError *)error;")
    default void didFailWithError(CLLocationManager manager, NSError error) {
    }

    /**
     * It is used when updated heading information was retrieved.
     *
     * @param manager    The manager that corresponds to this delegate.
     * @param newHeading The new heading.
     */
    @CMSelector("- (void)locationManager:(CLLocationManager *)manager \n"
            + "       didUpdateHeading:(CLHeading *)newHeading;")
    default void didUpdateHeading(CLLocationManager manager, CLHeading newHeading) {
    }

    /**
     * It is used in order to permit the display of a heading calibration alert.
     *
     * @param manager The manager that corresponds to this delegate.
     * @return TRUE then the display of a heading calibration alert is
     * permitted.
     */
    @CMSelector("- (BOOL)locationManagerShouldDisplayHeadingCalibration:(CLLocationManager *)manager;")
    default boolean shouldDisplayHeadingCalibration(CLLocationManager manager) {
        return false;
    }

    /**
     * It is used when the user has entered the specified region.
     *
     * @param manager The manager that corresponds to this delegate.
     * @param region  The region that the user entered.
     */
    @CMSelector("- (void)locationManager:(CLLocationManager *)manager \n"
            + "         didEnterRegion:(CLRegion *)region;")
    default void didEnterRegion(CLLocationManager manager, CLRegion region) {
    }

    /**
     * It is used when the user has left the specified region.
     *
     * @param manager The manager that corresponds to this delegate.
     * @param region  The region that the user has left.
     */
    @CMSelector("- (void)locationManager:(CLLocationManager *)manager \n"
            + "          didExitRegion:(CLRegion *)region;")
    default void didExitRegion(CLLocationManager manager, CLRegion region) {
    }

    /**
     * It is used in order to handle region monitoring error.
     *
     * @param manager The manager that corresponds to this delegate.
     * @param region  The region that was monitored.
     * @param error   The error that occurred.
     */
    @CMSelector("- (void)locationManager:(CLLocationManager *)manager \n"
            + "monitoringDidFailForRegion:(CLRegion *)region \n"
            + "              withError:(NSError *)error;")
    default void monitoringDidFailForRegion(CLLocationManager manager, CLRegion region, NSError error) {
    }
}
