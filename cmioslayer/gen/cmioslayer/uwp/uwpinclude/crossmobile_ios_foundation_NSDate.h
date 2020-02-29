// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_foundation_NSDate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

CM_EXPORT_CLASS
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
