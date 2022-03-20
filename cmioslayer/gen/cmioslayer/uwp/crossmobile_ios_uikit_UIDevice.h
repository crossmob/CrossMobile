// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIDevice definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSUUID;
@class java_lang_String;

@interface crossmobile_ios_uikit_UIDevice$Ext : UIDevice
@end

#define crossmobile_ios_uikit_UIDevice UIDevice
@interface UIDevice (cm_crossmobile_ios_uikit_UIDevice)
+ (UIDevice*) currentDevice__;
- (float) batteryLevel__;
- (void) setBatteryMonitoringEnabled___boolean:(BOOL) batteryMonitoringEnabled ;
- (BOOL) isBatteryMonitoringEnabled__;
- (int) batteryState__;
- (BOOL) isGeneratingDeviceOrientationNotifications__;
- (NSUUID*) identifierForVendor__;
- (NSString*) localizedModel__;
- (NSString*) model__;
- (BOOL) isMultitaskingSupported__;
- (NSString*) name__;
- (int) orientation__;
- (void) setProximityMonitoringEnabled___boolean:(BOOL) proximityMonitoringEnabled ;
- (BOOL) isProximityMonitoringEnabled__;
- (BOOL) proximityState__;
- (NSString*) systemName__;
- (NSString*) systemVersion__;
- (int) userInterfaceIdiom__;
- (void) beginGeneratingDeviceOrientationNotifications__;
- (void) endGeneratingDeviceOrientationNotifications__;
@end
