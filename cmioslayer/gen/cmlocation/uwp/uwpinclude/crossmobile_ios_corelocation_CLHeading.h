// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_corelocation_CLHeading definition

#import "xmlvm.h"
#import <CoreLocation/CoreLocation.h>
#import <MapKit/MapKit.h>
@class crossmobile_ios_foundation_NSDate;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_corelocation_CLHeading$Ext : CLHeading
@end

#define crossmobile_ios_corelocation_CLHeading CLHeading
@interface CLHeading (cm_crossmobile_ios_corelocation_CLHeading)
- (NSString*) description__;
- (double) headingAccuracy__;
- (double) magneticHeading__;
- (NSDate*) timestamp__;
- (double) trueHeading__;
- (double) x__;
- (double) y__;
- (double) z__;
@end
