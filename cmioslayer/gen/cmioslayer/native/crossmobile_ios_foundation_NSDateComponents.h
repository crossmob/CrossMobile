// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSDateComponents definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@interface crossmobile_ios_foundation_NSDateComponents$Ext : NSDateComponents
@end

#define crossmobile_ios_foundation_NSDateComponents NSDateComponents
@interface NSDateComponents (cm_crossmobile_ios_foundation_NSDateComponents)
- (instancetype) __init_crossmobile_ios_foundation_NSDateComponents__;
- (void) setDay___int:(int) day ;
- (int) day__;
- (void) setEra___int:(int) era ;
- (int) era__;
- (void) setHour___int:(int) hour ;
- (int) hour__;
- (void) setMinute___int:(int) minute ;
- (int) minute__;
- (void) setMonth___int:(int) month ;
- (int) month__;
- (void) setSecond___int:(int) second ;
- (int) second__;
- (void) setWeekday___int:(int) weekday ;
- (int) weekday__;
- (void) setWeekdayOrdinal___int:(int) weekdayOrdinal ;
- (int) weekdayOrdinal__;
- (void) setYear___int:(int) year ;
- (int) year__;
- (void) setWeek___int:(int) v ;
- (int) week__;
@end
