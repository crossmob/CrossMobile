// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIDevice implementation

#import "crossmobile_ios_foundation_NSUUID.h"
#import "crossmobile_ios_uikit_UIDevice.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UIDevice$Ext

// (UIDevice) @property(nonatomic, readonly) float batteryLevel;
- (float) batteryLevel__
{
    return [super batteryLevel];
}

// (UIDevice) @property(nonatomic, getter=isBatteryMonitoringEnabled) BOOL batteryMonitoringEnabled;
- (void) setBatteryMonitoringEnabled___boolean:(BOOL) batteryMonitoringEnabled 
{
    [super setBatteryMonitoringEnabled:batteryMonitoringEnabled];
}

// (UIDevice) @property(nonatomic, getter=isBatteryMonitoringEnabled) BOOL batteryMonitoringEnabled;
- (BOOL) isBatteryMonitoringEnabled__
{
    return [super isBatteryMonitoringEnabled];
}

// (UIDevice) @property(nonatomic, readonly) UIDeviceBatteryState batteryState;
- (int) batteryState__
{
    return [super batteryState];
}

// (UIDevice) @property(nonatomic, readonly, getter=isGeneratingDeviceOrientationNotifications) BOOL generatesDeviceOrientationNotifications;
- (BOOL) isGeneratingDeviceOrientationNotifications__
{
    return [super isGeneratingDeviceOrientationNotifications];
}

// (UIDevice) @property(nonatomic, readonly, strong) NSUUID *identifierForVendor;
- (NSUUID*) identifierForVendor__
{
    NSUUID* re$ult = [super identifierForVendor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIDevice) @property(nonatomic, readonly, strong) NSString *localizedModel;
- (NSString*) localizedModel__
{
    NSString* re$ult = [super localizedModel];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIDevice) @property(nonatomic, readonly, strong) NSString *model;
- (NSString*) model__
{
    NSString* re$ult = [super model];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIDevice) @property(nonatomic, readonly, getter=isMultitaskingSupported) BOOL multitaskingSupported;
- (BOOL) isMultitaskingSupported__
{
    return [super isMultitaskingSupported];
}

// (UIDevice) @property(nonatomic, readonly, strong) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [super name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIDevice) @property(nonatomic, readonly) UIDeviceOrientation orientation;
- (int) orientation__
{
    return [super orientation];
}

// (UIDevice) @property(nonatomic, getter=isProximityMonitoringEnabled) BOOL proximityMonitoringEnabled;
- (void) setProximityMonitoringEnabled___boolean:(BOOL) proximityMonitoringEnabled 
{
    [super setProximityMonitoringEnabled:proximityMonitoringEnabled];
}

// (UIDevice) @property(nonatomic, getter=isProximityMonitoringEnabled) BOOL proximityMonitoringEnabled;
- (BOOL) isProximityMonitoringEnabled__
{
    return [super isProximityMonitoringEnabled];
}

// (UIDevice) @property(nonatomic, readonly) BOOL proximityState;
- (BOOL) proximityState__
{
    return [super proximityState];
}

// (UIDevice) @property(nonatomic, readonly, strong) NSString *systemName;
- (NSString*) systemName__
{
    NSString* re$ult = [super systemName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIDevice) @property(nonatomic, readonly, strong) NSString *systemVersion;
- (NSString*) systemVersion__
{
    NSString* re$ult = [super systemVersion];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIDevice) @property(nonatomic, readonly) UIUserInterfaceIdiom userInterfaceIdiom;
- (int) userInterfaceIdiom__
{
    return [super userInterfaceIdiom];
}

// (UIDevice) - (void)beginGeneratingDeviceOrientationNotifications;
- (void) beginGeneratingDeviceOrientationNotifications__
{
    [super beginGeneratingDeviceOrientationNotifications];
}

// (UIDevice) - (void)endGeneratingDeviceOrientationNotifications;
- (void) endGeneratingDeviceOrientationNotifications__
{
    [super endGeneratingDeviceOrientationNotifications];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UIDevice (cm_crossmobile_ios_uikit_UIDevice)

// direct binding of: + (UIDevice *)currentDevice;
+ (UIDevice*) currentDevice__
{
    UIDevice* re$ult = [UIDevice currentDevice];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) float batteryLevel;
- (float) batteryLevel__
{
    return [self batteryLevel];
}

// direct binding of: @property(nonatomic, getter=isBatteryMonitoringEnabled) BOOL batteryMonitoringEnabled;
- (void) setBatteryMonitoringEnabled___boolean:(BOOL) batteryMonitoringEnabled 
{
    [self setBatteryMonitoringEnabled:batteryMonitoringEnabled];
}

// direct binding of: @property(nonatomic, getter=isBatteryMonitoringEnabled) BOOL batteryMonitoringEnabled;
- (BOOL) isBatteryMonitoringEnabled__
{
    return [self isBatteryMonitoringEnabled];
}

// direct binding of: @property(nonatomic, readonly) UIDeviceBatteryState batteryState;
- (int) batteryState__
{
    return [self batteryState];
}

// direct binding of: @property(nonatomic, readonly, getter=isGeneratingDeviceOrientationNotifications) BOOL generatesDeviceOrientationNotifications;
- (BOOL) isGeneratingDeviceOrientationNotifications__
{
    return [self isGeneratingDeviceOrientationNotifications];
}

// direct binding of: @property(nonatomic, readonly, strong) NSUUID *identifierForVendor;
- (NSUUID*) identifierForVendor__
{
    NSUUID* re$ult = [self identifierForVendor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) NSString *localizedModel;
- (NSString*) localizedModel__
{
    NSString* re$ult = [self localizedModel];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) NSString *model;
- (NSString*) model__
{
    NSString* re$ult = [self model];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, getter=isMultitaskingSupported) BOOL multitaskingSupported;
- (BOOL) isMultitaskingSupported__
{
    return [self isMultitaskingSupported];
}

// direct binding of: @property(nonatomic, readonly, strong) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UIDeviceOrientation orientation;
- (int) orientation__
{
    return [self orientation];
}

// direct binding of: @property(nonatomic, getter=isProximityMonitoringEnabled) BOOL proximityMonitoringEnabled;
- (void) setProximityMonitoringEnabled___boolean:(BOOL) proximityMonitoringEnabled 
{
    [self setProximityMonitoringEnabled:proximityMonitoringEnabled];
}

// direct binding of: @property(nonatomic, getter=isProximityMonitoringEnabled) BOOL proximityMonitoringEnabled;
- (BOOL) isProximityMonitoringEnabled__
{
    return [self isProximityMonitoringEnabled];
}

// direct binding of: @property(nonatomic, readonly) BOOL proximityState;
- (BOOL) proximityState__
{
    return [self proximityState];
}

// direct binding of: @property(nonatomic, readonly, strong) NSString *systemName;
- (NSString*) systemName__
{
    NSString* re$ult = [self systemName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) NSString *systemVersion;
- (NSString*) systemVersion__
{
    NSString* re$ult = [self systemVersion];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UIUserInterfaceIdiom userInterfaceIdiom;
- (int) userInterfaceIdiom__
{
    return [self userInterfaceIdiom];
}

// direct binding of: - (void)beginGeneratingDeviceOrientationNotifications;
- (void) beginGeneratingDeviceOrientationNotifications__
{
    [self beginGeneratingDeviceOrientationNotifications];
}

// direct binding of: - (void)endGeneratingDeviceOrientationNotifications;
- (void) endGeneratingDeviceOrientationNotifications__
{
    [self endGeneratingDeviceOrientationNotifications];
}

@end
