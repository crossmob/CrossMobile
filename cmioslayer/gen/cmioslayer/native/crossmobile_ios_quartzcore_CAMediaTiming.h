// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quartzcore_CAMediaTiming definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;

@protocol crossmobile_ios_quartzcore_CAMediaTiming
- (void) setAutoreverses___boolean:(BOOL) autoreverses ;
- (BOOL) autoreverses__;
- (void) setBeginTime___double:(double) beginTime ;
- (double) beginTime__;
- (void) setDuration___double:(double) duration ;
- (double) duration__;
- (void) setFillMode___java_lang_String:(NSString*) fillMode ;
- (NSString*) fillMode__;
- (void) setRepeatCount___float:(float) repeatCount ;
- (float) repeatCount__;
- (void) setRepeatDuration___double:(double) repeatDuration ;
- (double) repeatDuration__;
- (void) setSpeed___float:(float) speed ;
- (float) speed__;
- (void) setTimeOffset___double:(double) timeOffset ;
- (double) timeOffset__;
@end
