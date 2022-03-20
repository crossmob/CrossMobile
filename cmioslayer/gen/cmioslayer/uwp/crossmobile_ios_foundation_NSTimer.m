// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSTimer implementation

#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSTimer.h"
#import "crossmobile_ios_foundation_NSTimerDelegate.h"
#import "java_lang_Object.h"
#import "java_lang_reflect_Method.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_foundation_NSTimer$Ext

@end

@implementation NSTimer (cm_crossmobile_ios_foundation_NSTimer)

// + (NSTimer *)scheduledTimerWithTimeInterval:(NSTimeInterval)ti target:(id)target selector:(SEL)aSelector userInfo:(id)userInfo repeats:(BOOL)repeats;
+ (NSTimer*) scheduledTimerWithTimeInterval___double_crossmobile_ios_foundation_NSTimerDelegate_java_lang_Object_boolean:(double) ti :(id<crossmobile_ios_foundation_NSTimerDelegate>) target :(id) userInfo :(BOOL) repeats 
{
    NSTimer* re$ult = [NSTimer scheduledTimerWithTimeInterval:ti target:(target == JAVA_NULL ? nil : target) selector:@selector(fireMethod___crossmobile_ios_foundation_NSTimer:) userInfo:(userInfo == JAVA_NULL ? nil : userInfo) repeats:repeats];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSTimer *)timerWithTimeInterval:(NSTimeInterval)ti target:(id)target selector:(SEL)aSelector userInfo:(id)userInfo repeats:(BOOL)repeats;
+ (NSTimer*) timerWithTimeInterval___double_crossmobile_ios_foundation_NSTimerDelegate_java_lang_Object_boolean:(double) ti :(id<crossmobile_ios_foundation_NSTimerDelegate>) target :(id) userInfo :(BOOL) repeats 
{
    NSTimer* re$ult = [NSTimer timerWithTimeInterval:ti target:(target == JAVA_NULL ? nil : target) selector:@selector(fireMethod___crossmobile_ios_foundation_NSTimer:) userInfo:(userInfo == JAVA_NULL ? nil : userInfo) repeats:repeats];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithFireDate:(NSDate *)date interval:(NSTimeInterval)interval repeats:(BOOL)repeats block:(void (^)(NSTimer *timer))block;
- (instancetype) __init_crossmobile_ios_foundation_NSTimer___crossmobile_ios_foundation_NSDate_double_boolean_org_robovm_objc_block_VoidBlock1:(NSDate*) date :(double) interval :(BOOL) repeats :(id<org_robovm_objc_block_VoidBlock1>) block 
{
    return [self initWithFireDate:(date == JAVA_NULL ? nil : date) interval:interval repeats:repeats block:(block == JAVA_NULL ? nil : ^(NSTimer* timer) {
        [block invoke___java_lang_Object:(timer ? timer : JAVA_NULL)];
    })];
}

// - (instancetype)initWithFireDate:(NSDate *)date interval:(NSTimeInterval)ti target:(id)t selector:(SEL)s userInfo:(id)ui repeats:(BOOL)rep;
- (instancetype) __init_crossmobile_ios_foundation_NSTimer___crossmobile_ios_foundation_NSDate_double_crossmobile_ios_foundation_NSTimerDelegate_java_lang_Object_boolean:(NSDate*) date :(double) ti :(id<crossmobile_ios_foundation_NSTimerDelegate>) t :(id) ui :(BOOL) rep 
{
    return [self initWithFireDate:(date == JAVA_NULL ? nil : date) interval:ti target:(t == JAVA_NULL ? nil : t) selector:@selector(fireMethod___crossmobile_ios_foundation_NSTimer:) userInfo:(ui == JAVA_NULL ? nil : ui) repeats:rep];
}

// @property(copy) NSDate *fireDate;
- (void) setFireDate___crossmobile_ios_foundation_NSDate:(NSDate*) fireDate 
{
    [self setFireDate:(fireDate == JAVA_NULL ? nil : fireDate)];
}

// @property(copy) NSDate *fireDate;
- (NSDate*) fireDate__
{
    NSDate* re$ult = [self fireDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) NSTimeInterval timeInterval;
- (double) timeInterval__
{
    return [self timeInterval];
}

// @property(readonly, retain) id userInfo;
- (id) userInfo__
{
    id re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, getter=isValid) BOOL valid;
- (BOOL) isValid__
{
    return [self isValid];
}

// - (void)fire;
- (void) fire__
{
    [self fire];
}

// - (void)invalidate;
- (void) invalidate__
{
    [self invalidate];
}

@end
