// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIDevice implementation

#import "crossmobile_ios_foundation_NSUUID.h"
#import "crossmobile_ios_uikit_UIDevice.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UIDevice$Ext

@end

@implementation UIDevice (cm_crossmobile_ios_uikit_UIDevice)

// + (UIDevice *)currentDevice;
+ (UIDevice*) currentDevice__
{
    UIDevice* re$ult = [UIDevice currentDevice];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) float batteryLevel;
- (float) batteryLevel__
{
    return [self batteryLevel];
}

// @property(nonatomic, getter=isBatteryMonitoringEnabled) BOOL batteryMonitoringEnabled;
- (void) setBatteryMonitoringEnabled___boolean:(BOOL) batteryMonitoringEnabled 
{
    [self setBatteryMonitoringEnabled:batteryMonitoringEnabled];
}

// @property(nonatomic, getter=isBatteryMonitoringEnabled) BOOL batteryMonitoringEnabled;
- (BOOL) isBatteryMonitoringEnabled__
{
    return [self isBatteryMonitoringEnabled];
}

// @property(nonatomic, readonly) UIDeviceBatteryState batteryState;
- (int) batteryState__
{
    return [self batteryState];
}

// @property(nonatomic, readonly, getter=isGeneratingDeviceOrientationNotifications) BOOL generatesDeviceOrientationNotifications;
- (BOOL) isGeneratingDeviceOrientationNotifications__
{
    return [self isGeneratingDeviceOrientationNotifications];
}

// @property(nonatomic, readonly, strong) NSUUID *identifierForVendor;
- (NSUUID*) identifierForVendor__
{
    NSUUID* re$ult = [self identifierForVendor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) NSString *localizedModel;
- (NSString*) localizedModel__
{
    NSString* re$ult = [self localizedModel];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) NSString *model;
- (NSString*) model__
{
    NSString* re$ult = [self model];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, getter=isMultitaskingSupported) BOOL multitaskingSupported;
- (BOOL) isMultitaskingSupported__
{
    return [self isMultitaskingSupported];
}

// @property(nonatomic, readonly, strong) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIDeviceOrientation orientation;
- (int) orientation__
{
    return [self orientation];
}

// @property(nonatomic, getter=isProximityMonitoringEnabled) BOOL proximityMonitoringEnabled;
- (void) setProximityMonitoringEnabled___boolean:(BOOL) proximityMonitoringEnabled 
{
    [self setProximityMonitoringEnabled:proximityMonitoringEnabled];
}

// @property(nonatomic, getter=isProximityMonitoringEnabled) BOOL proximityMonitoringEnabled;
- (BOOL) isProximityMonitoringEnabled__
{
    return [self isProximityMonitoringEnabled];
}

// @property(nonatomic, readonly) BOOL proximityState;
- (BOOL) proximityState__
{
    return [self proximityState];
}

// @property(nonatomic, readonly, strong) NSString *systemName;
- (NSString*) systemName__
{
    NSString* re$ult = [self systemName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) NSString *systemVersion;
- (NSString*) systemVersion__
{
    NSString* re$ult = [self systemVersion];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIUserInterfaceIdiom userInterfaceIdiom;
- (int) userInterfaceIdiom__
{
    return [self userInterfaceIdiom];
}

// - (void)beginGeneratingDeviceOrientationNotifications;
- (void) beginGeneratingDeviceOrientationNotifications__
{
    [self beginGeneratingDeviceOrientationNotifications];
}

// - (void)endGeneratingDeviceOrientationNotifications;
- (void) endGeneratingDeviceOrientationNotifications__
{
    [self endGeneratingDeviceOrientationNotifications];
}

@end
