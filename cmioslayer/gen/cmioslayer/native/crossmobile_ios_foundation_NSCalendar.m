// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSCalendar implementation

#import "crossmobile_ios_foundation_NSCalendar.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSDateComponents.h"

@implementation crossmobile_ios_foundation_NSCalendar$Ext

@end

@implementation NSCalendar (cm_crossmobile_ios_foundation_NSCalendar)

// + (NSCalendar *)currentCalendar;
+ (NSCalendar*) currentCalendar__
{
    NSCalendar* re$ult = [NSCalendar currentCalendar];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSDateComponents *)components:(NSCalendarUnit)unitFlags fromDate:(NSDate *)date;
- (NSDateComponents*) components___int_crossmobile_ios_foundation_NSDate:(int) unitFlags :(NSDate*) date 
{
    NSDateComponents* re$ult = [self components:unitFlags fromDate:(date == JAVA_NULL ? nil : date)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSDateComponents *)components:(NSCalendarUnit)unitFlags fromDate:(NSDate *)startingDate toDate:(NSDate *)resultDate options:(NSCalendarOptions)opts;
- (NSDateComponents*) components___int_crossmobile_ios_foundation_NSDate_crossmobile_ios_foundation_NSDate_int:(int) unitFlags :(NSDate*) startingDate :(NSDate*) resultDate :(int) opts 
{
    NSDateComponents* re$ult = [self components:unitFlags fromDate:(startingDate == JAVA_NULL ? nil : startingDate) toDate:(resultDate == JAVA_NULL ? nil : resultDate) options:opts];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSDate *)dateByAddingComponents:(NSDateComponents *)comps toDate:(NSDate *)date options:(NSCalendarOptions)opts;
- (NSDate*) dateByAddingComponents___crossmobile_ios_foundation_NSDateComponents_crossmobile_ios_foundation_NSDate_int:(NSDateComponents*) comps :(NSDate*) date :(int) opts 
{
    NSDate* re$ult = [self dateByAddingComponents:(comps == JAVA_NULL ? nil : comps) toDate:(date == JAVA_NULL ? nil : date) options:opts];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSDate *)dateFromComponents:(NSDateComponents *)comps;
- (NSDate*) dateFromComponents___crossmobile_ios_foundation_NSDateComponents:(NSDateComponents*) comps 
{
    NSDate* re$ult = [self dateFromComponents:(comps == JAVA_NULL ? nil : comps)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
