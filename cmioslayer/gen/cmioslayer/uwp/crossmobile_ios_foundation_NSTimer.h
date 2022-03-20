// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSTimer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSDate;
@protocol crossmobile_ios_foundation_NSTimerDelegate;
@class java_lang_Object;
@class java_lang_reflect_Method;
@protocol org_robovm_objc_block_VoidBlock1;

@interface crossmobile_ios_foundation_NSTimer$Ext : NSTimer
@end

#define crossmobile_ios_foundation_NSTimer NSTimer
@interface NSTimer (cm_crossmobile_ios_foundation_NSTimer)
+ (NSTimer*) scheduledTimerWithTimeInterval___double_crossmobile_ios_foundation_NSTimerDelegate_java_lang_Object_boolean:(double) ti :(id<crossmobile_ios_foundation_NSTimerDelegate>) target :(id) userInfo :(BOOL) repeats ;
+ (NSTimer*) timerWithTimeInterval___double_crossmobile_ios_foundation_NSTimerDelegate_java_lang_Object_boolean:(double) ti :(id<crossmobile_ios_foundation_NSTimerDelegate>) target :(id) userInfo :(BOOL) repeats ;
- (instancetype) __init_crossmobile_ios_foundation_NSTimer___crossmobile_ios_foundation_NSDate_double_boolean_org_robovm_objc_block_VoidBlock1:(NSDate*) date :(double) interval :(BOOL) repeats :(id<org_robovm_objc_block_VoidBlock1>) block ;
- (instancetype) __init_crossmobile_ios_foundation_NSTimer___crossmobile_ios_foundation_NSDate_double_crossmobile_ios_foundation_NSTimerDelegate_java_lang_Object_boolean:(NSDate*) date :(double) ti :(id<crossmobile_ios_foundation_NSTimerDelegate>) t :(id) ui :(BOOL) rep ;
- (void) setFireDate___crossmobile_ios_foundation_NSDate:(NSDate*) fireDate ;
- (NSDate*) fireDate__;
- (double) timeInterval__;
- (id) userInfo__;
- (BOOL) isValid__;
- (void) fire__;
- (void) invalidate__;
@end
