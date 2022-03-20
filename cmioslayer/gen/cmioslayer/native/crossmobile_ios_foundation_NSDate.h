// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSDate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@interface crossmobile_ios_foundation_NSDate$Ext : NSDate
@end

#define crossmobile_ios_foundation_NSDate NSDate
@interface NSDate (cm_crossmobile_ios_foundation_NSDate)
+ (instancetype) date__;
+ (instancetype) dateWithTimeInterval___double_crossmobile_ios_foundation_NSDate:(double) secsToBeAdded :(NSDate*) date ;
+ (instancetype) dateWithTimeIntervalSince1970___double:(double) secs ;
+ (instancetype) dateWithTimeIntervalSinceNow___double:(double) secs ;
+ (instancetype) dateWithTimeIntervalSinceReferenceDate___double:(double) ti ;
- (double) timeIntervalSince1970__;
- (double) timeIntervalSinceReferenceDate__;
@end
