// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStepper definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIImage;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UIStepper$Ext : UIStepper
@end

#define crossmobile_ios_uikit_UIStepper UIStepper
@interface UIStepper (cm_crossmobile_ios_uikit_UIStepper)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIStepper__;
- (instancetype) __init_crossmobile_ios_uikit_UIStepper___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setAutorepeat___boolean:(BOOL) autorepeat ;
- (BOOL) autorepeat__;
- (void) setContinuous___boolean:(BOOL) continuous ;
- (BOOL) isContinuous__;
- (void) setMaximumValue___double:(double) maximumValue ;
- (double) maximumValue__;
- (void) setMinimumValue___double:(double) minimumValue ;
- (double) minimumValue__;
- (void) setStepValue___double:(double) stepValue ;
- (double) stepValue__;
- (void) setValue___double:(double) value ;
- (double) value__;
- (void) setWraps___boolean:(BOOL) wraps ;
- (BOOL) wraps__;
- (UIImage*) backgroundImageForState___int:(int) state ;
- (UIImage*) decrementImageForState___int:(int) state ;
- (UIImage*) dividerImageForLeftSegmentState___int_int:(int) state :(int) state ;
- (UIImage*) incrementImageForState___int:(int) state ;
- (void) setBackgroundImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state ;
- (void) setDecrementImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state ;
- (void) setDividerImage___crossmobile_ios_uikit_UIImage_int_int:(UIImage*) image :(int) leftState :(int) rightState ;
- (void) setIncrementImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state ;
@end
