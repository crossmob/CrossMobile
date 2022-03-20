// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSDate implementation

#import "crossmobile_ios_foundation_NSDate.h"

@implementation crossmobile_ios_foundation_NSDate$Ext

@end

@implementation NSDate (cm_crossmobile_ios_foundation_NSDate)

// + (instancetype)date;
+ (instancetype) date__
{
    id re$ult = [NSDate date];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)dateWithTimeInterval:(NSTimeInterval)secsToBeAdded sinceDate:(NSDate *)date;
+ (instancetype) dateWithTimeInterval___double_crossmobile_ios_foundation_NSDate:(double) secsToBeAdded :(NSDate*) date 
{
    id re$ult = [NSDate dateWithTimeInterval:secsToBeAdded sinceDate:(date == JAVA_NULL ? nil : date)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)dateWithTimeIntervalSince1970:(NSTimeInterval)secs;
+ (instancetype) dateWithTimeIntervalSince1970___double:(double) secs 
{
    id re$ult = [NSDate dateWithTimeIntervalSince1970:secs];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)dateWithTimeIntervalSinceNow:(NSTimeInterval)secs;
+ (instancetype) dateWithTimeIntervalSinceNow___double:(double) secs 
{
    id re$ult = [NSDate dateWithTimeIntervalSinceNow:secs];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)dateWithTimeIntervalSinceReferenceDate:(NSTimeInterval)ti;
+ (instancetype) dateWithTimeIntervalSinceReferenceDate___double:(double) ti 
{
    id re$ult = [NSDate dateWithTimeIntervalSinceReferenceDate:ti];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) NSTimeInterval timeIntervalSince1970;
- (double) timeIntervalSince1970__
{
    return [self timeIntervalSince1970];
}

// @property(readonly) NSTimeInterval timeIntervalSinceReferenceDate;
- (double) timeIntervalSinceReferenceDate__
{
    return [self timeIntervalSinceReferenceDate];
}

@end
