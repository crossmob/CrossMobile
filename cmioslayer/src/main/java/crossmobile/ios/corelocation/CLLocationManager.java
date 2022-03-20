/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.corelocation;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.LocationBridge.LocationChangeDelegate;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.Set;

/**
 * CLLocationManager class is responsible for delivering events related to
 * location, region and heading to the application.
 */
@CMClass
public class CLLocationManager extends NSObject {

    private CLLocationManagerDelegate delegate;
    private double distanceFilter = CLDistanceFilter.None;
    private double desiredAccuracy = CLLocationAccuracy.Best;
    private double headingFilter = CLHeadingFilter.None;
    private int headingOrientation;
    private Set<CLRegion> monitoredRegions;
    private double maximumRegionMonitoringDistance;
    private CLHeading heading;
    private String purpose;
    private CLLocation location = new CLLocation(0, 0);
    private final LocationChangeDelegate lcdelegate = new LocationListenerImpl();

    /**
     * Returns a Boolean that shows whether location services are enabled.
     *
     * @return TRUE then location services are available.
     */
    @CMSelector("+ (BOOL)locationServicesEnabled;")
    public static boolean locationServicesEnabled() {
        return Native.location().supportsFineLocations() || Native.location().supportsCoarseLocations();
    }

    /**
     * Returns a Boolean that shows whether tracking of significant location
     * changes is available.
     *
     * @return TRUE then significant location changes tracking is available.
     */
    @CMSelector("+ (BOOL)significantLocationChangeMonitoringAvailable;")
    public static boolean significantLocationChangeMonitoringAvailable() {
        return Native.location().supportsCoarseLocations();
    }

    /**
     * Allows location updates.
     */
    @CMSelector("- (void)startUpdatingLocation")
    public void startUpdatingLocation() {
        Native.location().preferFineUpdating();
        Native.location().startUpdating(lcdelegate);
    }

    /**
     * Prevents location updates.
     */
    @CMSelector("- (void)stopUpdatingLocation;")
    public void stopUpdatingLocation() {
        Native.location().stopUpdating(lcdelegate);
    }

    /**
     * Allows generating location events triggered by significant location
     * changes.
     */
    @CMSelector("- (void)startMonitoringSignificantLocationChanges;")
    public void startMonitoringSignificantLocationChanges() {
        Native.location().preferCoarseUpdating();
        Native.location().startUpdating(lcdelegate);
    }

    /**
     * Prevents generating location events triggered by significant location
     * changes.
     */
    @CMSelector("- (void)stopMonitoringSignificantLocationChanges;")
    public void stopMonitoringSignificantLocationChanges() {
        Native.location().stopUpdating(lcdelegate);
    }

    /**
     * Returns a Boolean that shows whether heading events are available.
     *
     * @return TRUE then heading events are available.
     */
    @CMSelector("+ (BOOL)headingAvailable;")
    public static boolean headingAvailable() {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Returns a Boolean that shows whether region monitoring is available on
     * this device.
     *
     * @return TRUE then the region monitoring is available on this device.
     */
    @Deprecated
    @CMSelector("+ (BOOL)regionMonitoringAvailable;")
    public static boolean regionMonitoringAvailable() {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Returns a Boolean that shows whether region monitoring is currently
     * activated.
     *
     * @return TRUE then the region monitoring is currently activated.
     */
    @CMSelector("+ (BOOL)regionMonitoringEnabled;")
    public static boolean regionMonitoringEnabled() {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Enables heading updates.
     */
    @CMSelector("- (void)startUpdatingHeading;")
    public void startUpdatingHeading() {
        Native.system().notImplemented();
    }

    /**
     * Disables heading updates.
     */
    @CMSelector("- (void)stopUpdatingHeading;")
    public void stopUpdatingHeading() {
        Native.system().notImplemented();
    }

    /**
     * Stops displaying heading calibration view.
     */
    @CMSelector("- (void)dismissHeadingCalibrationDisplay;")
    public void dismissHeadingCalibrationDisplay() {
        Native.system().notImplemented();
    }

    /**
     * Starts monitoring the specified region.
     *
     * @param region   The region that is about to be monitored.
     * @param accuracy The accuracy of monitoring.
     */
    @Deprecated
    @CMSelector("- (void)startMonitoringForRegion:(CLRegion *)region desiredAccuracy:(CLLocationAccuracy)accuracy;")
    public void startMonitoringForRegion(CLRegion region, double accuracy) {
        Native.system().notImplemented();
    }

    /**
     * Stops monitoring the specified region.
     *
     * @param region The region that is currently being monitored.
     */
    @CMSelector("- (void)stopMonitoringForRegion:(CLRegion *)region;")
    public void stopMonitoringForRegion(CLRegion region) {
        Native.system().notImplemented();
    }

    /**
     * Returns the delegate for handling location data.
     *
     * @return The delegate for handling location data
     */
    @CMGetter("@property(assign, nonatomic) id<CLLocationManagerDelegate> delegate;")
    public CLLocationManagerDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for handling location data.
     *
     * @param delegate The delegate for handling location data
     */
    @CMSetter("@property(assign, nonatomic) id<CLLocationManagerDelegate> delegate;")
    public void setDelegate(CLLocationManagerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the accuracy of the location.
     *
     * @return The accuracy of the location.
     */
    @CMGetter("@property(assign, nonatomic) CLLocationAccuracy desiredAccuracy;")
    public double desiredAccuracy() {
        return desiredAccuracy;
    }

    /**
     * Sets the accuracy of the location.
     *
     * @param desiredAccuracy The accuracy of the location.
     */
    @CMSetter("@property(assign, nonatomic) CLLocationAccuracy desiredAccuracy;")
    public void setDesiredAccuracy(double desiredAccuracy) {
        this.desiredAccuracy = desiredAccuracy;
    }

    /**
     * Returns the minimum horizontal distance that the device must move before
     * it causes a location update.
     *
     * @return The minimum horizontal distance that the device must move before
     * it causes a location update.
     */
    @CMGetter("@property(assign, nonatomic) CLLocationDistance distanceFilter;")
    public double distanceFilter() {
        return distanceFilter;
    }

    /**
     * Sets the minimum horizontal distance that the device must move before it
     * causes a location update.
     *
     * @param distanceFilter The minimum horizontal distance that the device
     *                       must move before it causes a location update.
     */
    @CMSetter("@property(assign, nonatomic) CLLocationDistance distanceFilter;")
    public void setDistanceFilter(double distanceFilter) {
        this.distanceFilter = distanceFilter;
    }

    /**
     * Returns the minimum heading change that causes heading update.
     *
     * @return The minimum heading change that causes heading update.
     */
    @CMGetter("@property(assign, nonatomic) CLLocationDegrees headingFilter;\n"
            + "")
    public double headingFilter() {
        return headingFilter;
    }

    /**
     * Sets the minimum heading change that causes heading update.
     *
     * @param headingFilter The minimum heading change that causes heading
     *                      update.
     */
    @CMSetter("@property(assign, nonatomic) CLLocationDegrees headingFilter;\n"
            + "")
    public void setHeadingFilter(double headingFilter) {
        this.headingFilter = headingFilter;
    }

    /**
     * Returns the orientation used for heading computations.
     *
     * @return The orientation used for heading computations.
     */
    @CMGetter("@property(assign, nonatomic) CLDeviceOrientation headingOrientation;")
    public int headingOrientation() {
        return headingOrientation;
    }

    /**
     * Sets the orientation used for heading computations.
     *
     * @param headingOrientation The orientation used for heading computations.
     */
    @CMSetter("@property(assign, nonatomic) CLDeviceOrientation headingOrientation;")
    public void setHeadingOrientation(int headingOrientation) {
        this.headingOrientation = headingOrientation;
    }

    /**
     * Returns the set of shared CLRegions being monitored by the location
     * manager objects of this application.
     *
     * @return The set of shared CLRegions being monitored by the location
     * manager objects of this application.
     */
    @CMGetter("@property(readonly, nonatomic, copy) NSSet<__kindof CLRegion *> *monitoredRegions;")
    public Set<CLRegion> monitoredRegions() {
        return monitoredRegions;
    }

    /**
     * Returns the maximum distance concerning the bounds of a region.
     *
     * @return The maximum distance concerning the bounds of a region.
     */
    @CMGetter("@property(readonly, nonatomic) CLLocationDistance maximumRegionMonitoringDistance;")
    public double maximumRegionMonitoringDistance() {
        return maximumRegionMonitoringDistance;
    }

    /**
     * Returns the current heading of the device (recently recorded).
     *
     * @return The current heading of the device (recently recorded).
     */
    @CMGetter("@property(readonly, nonatomic, copy) CLHeading *heading;\n"
            + "")
    public CLHeading heading() {
        return heading;
    }

    /**
     * Returns the current location of the device (recently recorded).
     *
     * @return The current location of the device (recently recorded).
     */
    @CMGetter("@property(readonly, nonatomic, copy) CLLocation *location;")
    public CLLocation location() {
        return location;
    }

    /**
     * Returns a string value that determines the purpose of location service
     * use for the particular application.
     *
     * @return The purpose of location service for the application.
     */
    @Deprecated
    @CMGetter("@property(copy, nonatomic) NSString *purpose;")
    public String purpose() {
        return purpose;
    }

    /**
     * Sets a string value that defines the purpose of location service use for
     * the particular application.
     *
     * @param purpose The purpose of location service for the application.
     */
    @CMSetter("@property(copy, nonatomic) NSString *purpose;")
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    private class LocationListenerImpl implements LocationChangeDelegate {

        @SuppressWarnings("deprecation")
        @Override
        public void updateLocation(double latitude, double longitude) {
            if (delegate != null) {
                CLLocation newLocation = new CLLocation(latitude, longitude);
                if (!newLocation.equals(location)) {
                    delegate.didUpdateToLocation(CLLocationManager.this, newLocation, location);
                    location = newLocation;
                }
            }
        }
    }
}
