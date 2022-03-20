/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.*;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.io.*;

/**
 * The UIDevice class defines an object that represents the device on which the
 * application runs.
 */
@CMClass
public class UIDevice extends NSObject {

    private static final UIDevice current = new UIDevice();
    //
    private boolean proximityMonitoringEnabled = false;
    private boolean batteryMonitoringEnabled = false;
    private NSUUID uuid = null;

    private UIDevice() {
    }

    /**
     * Returns the current device.
     *
     * @return The current device.
     */
    @CMSelector("+ (UIDevice *)currentDevice;")
    public static UIDevice currentDevice() {
        return current;
    }

    /**
     * Returns a Boolean number that defines whether the device supports
     * multitasking or not.
     *
     * @return A Boolean number that defines whether the device supports
     * multitasking or not
     */
    @CMGetter("@property(nonatomic, readonly, getter=isMultitaskingSupported) BOOL multitaskingSupported;")
    public boolean isMultitaskingSupported() {
        return false;
    }

    /**
     * Returns the name of the device.
     *
     * @return A String that is the name of the device.
     */
    @CMGetter("@property(nonatomic, readonly, strong) NSString *name;")
    public String name() {
        return systemName();
    }

    /**
     * Returns the name of the system.
     *
     * @return A String that is the name of the system.
     */
    @CMGetter("@property(nonatomic, readonly, strong) NSString *systemName;")
    public String systemName() {
        return "CrossMobile";
    }

    /**
     * Returns the version of the system.
     *
     * @return A String that is the version of the system.
     */
    @CMGetter("@property(nonatomic, readonly, strong) NSString *systemVersion;")
    public String systemVersion() {
        return "13.0";
    }

    /**
     * Returns the model of the device.
     *
     * @return A String that is the model of the device.
     */
    @CMGetter("@property(nonatomic, readonly, strong) NSString *model;")
    public String model() {
        return Native.system().model();
    }

    /**
     * Returns the localized model of the device.
     *
     * @return A String that is the localized model of the device.
     */
    @CMGetter("@property(nonatomic, readonly, strong) NSString *localizedModel;")
    public String localizedModel() {
        return model();
    }

    /**
     * Returns the style of interface for the current device.
     *
     * @return A String that is the style of interface for the current device.
     */
    @CMGetter("@property(nonatomic, readonly) UIUserInterfaceIdiom userInterfaceIdiom;")
    public int userInterfaceIdiom() {
        return Native.graphics().metrics().getIdiom();
    }

    /**
     * Returns the original orientation of the device.
     *
     * @return An integer that represents the original orientation of the
     * device.
     */
    @CMGetter("@property(nonatomic, readonly) UIDeviceOrientation orientation;")
    public int orientation() {
        return Native.graphics().metrics().getOrientation();
    }

    /**
     * Returns a Boolean that defines whether this device generates
     * notifications when the orientation changes.
     *
     * @return A Boolean that defines whether this device generates
     * notifications when the orientation changes.
     */
    @CMGetter("@property(nonatomic, readonly, getter=isGeneratingDeviceOrientationNotifications) BOOL generatesDeviceOrientationNotifications;")
    public boolean isGeneratingDeviceOrientationNotifications() {
        return false;
    }

    /**
     * Enables the accelerometer that identifies orientation of the device.
     */
    @CMSelector("- (void)beginGeneratingDeviceOrientationNotifications;\n"
            + "")
    public void beginGeneratingDeviceOrientationNotifications() {
        Native.system().notImplemented();
    }

    /**
     * Disables the accelerometer that identifies orientation of the device.
     */
    @CMSelector("- (void)endGeneratingDeviceOrientationNotifications;")
    public void endGeneratingDeviceOrientationNotifications() {
        Native.system().notImplemented();
    }

    /**
     * Returns a number that defines the state of the battery.
     *
     * @return A number that defines the state of the battery.
     */
    @CMGetter("@property(nonatomic, readonly) float batteryLevel;")
    public float batteryLevel() {
        if (batteryMonitoringEnabled)
            return 0.5f;
        else
            return -1;
    }

    /**
     * Returns a Boolean that indicates whether battery monitoring is enabled.
     *
     * @return A Boolean that indicates whether battery monitoring is enabled.
     */
    @CMGetter("@property(nonatomic, getter=isBatteryMonitoringEnabled) BOOL batteryMonitoringEnabled;")
    public boolean isBatteryMonitoringEnabled() {
        return batteryMonitoringEnabled;
    }

    /**
     * Sets a Boolean value that enables or disables battery monitoring.
     *
     * @param batteryMonitoringEnabled A Boolean value that enables or disables
     *                                 battery monitoring.
     */
    @CMSetter("@property(nonatomic, getter=isBatteryMonitoringEnabled) BOOL batteryMonitoringEnabled;")
    public void setBatteryMonitoringEnabled(boolean batteryMonitoringEnabled) {
        this.batteryMonitoringEnabled = batteryMonitoringEnabled;
    }

    /**
     * Returns a number that defines the state of the battery.
     *
     * @return An integer that defines the state of the battery.
     */
    @CMGetter("@property(nonatomic, readonly) UIDeviceBatteryState batteryState;")
    public int batteryState() {
        return UIDeviceBatteryState.Unknown;
    }

    /**
     * Returns a Boolean that defines whether the proximity monitoring is
     * enabled.
     *
     * @return A Boolean that defines whether the proximity monitoring is
     * enabled.
     */
    @CMGetter("@property(nonatomic, getter=isProximityMonitoringEnabled) BOOL proximityMonitoringEnabled;")
    public boolean isProximityMonitoringEnabled() {
        return proximityMonitoringEnabled;
    }

    /**
     * Sets a Boolean value that enables or disables proximity monitoring.
     *
     * @param proximityMonitoringEnabled A Boolean value that enables or
     *                                   disables proximity monitoring.
     */
    @CMSetter("@property(nonatomic, getter=isProximityMonitoringEnabled) BOOL proximityMonitoringEnabled;")
    public void setProximityMonitoringEnabled(boolean proximityMonitoringEnabled) {
        this.proximityMonitoringEnabled = proximityMonitoringEnabled;
    }

    /**
     * Returns a Boolean value that defines whether the proximity sensor is near
     * the user.
     *
     * @return Boolean value that defines whether the proximity sensor is near
     * the user (default false).
     */
    @CMGetter("@property(nonatomic, readonly) BOOL proximityState;")
    public boolean proximityState() {
        return false;
    }

    /**
     * Returns the supplier's id of the application.
     *
     * @return The supplier's id of the application.
     */
    @CMGetter("@property(nonatomic, readonly, strong) NSUUID *identifierForVendor;")
    public NSUUID identifierForVendor() {
        if (uuid == null)
            try {
                File idfile = new File(Foundation.NSSearchPathForDirectoriesInDomains(NSSearchPathDirectory.Caches, NSSearchPathDomainMask.UserDomain, true).get(0) + File.separator + ".crossmobile.uuid");
                if (idfile.isFile()) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    Native.file().copyStreamAndClose(new FileInputStream(idfile), out, 16);
                    uuid = new NSUUID(out.toByteArray());
                } else {
                    uuid = NSUUID.UUID();
                    byte[] bytes = new byte[16];
                    NSUUID.UUID().getUUIDBytes(bytes);
                    Native.file().copyStreamAndClose(new ByteArrayInputStream(bytes), new FileOutputStream(idfile), 16);
                }
            } catch (FileNotFoundException ex) {
                Native.system().error("Unable to create identifier", ex);
            } finally {
                if (uuid == null)
                    uuid = NSUUID.UUID();
            }
        return uuid;
    }
}
