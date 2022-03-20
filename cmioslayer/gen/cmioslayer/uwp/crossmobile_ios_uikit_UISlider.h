// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISlider definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIImage;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UISlider$Ext : UISlider
@end

#define crossmobile_ios_uikit_UISlider UISlider
@interface UISlider (cm_crossmobile_ios_uikit_UISlider)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UISlider__;
- (instancetype) __init_crossmobile_ios_uikit_UISlider___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setContinuous___boolean:(BOOL) continuous ;
- (BOOL) isContinuous__;
- (UIImage*) currentMaximumTrackImage__;
- (UIImage*) currentMinimumTrackImage__;
- (UIImage*) currentThumbImage__;
- (void) setMaximumTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) maximumTrackTintColor ;
- (UIColor*) maximumTrackTintColor__;
- (void) setMaximumValue___float:(float) maximumValue ;
- (float) maximumValue__;
- (void) setMaximumValueImage___crossmobile_ios_uikit_UIImage:(UIImage*) maximumValueImage ;
- (UIImage*) maximumValueImage__;
- (void) setMinimumTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) minimumTrackTintColor ;
- (UIColor*) minimumTrackTintColor__;
- (void) setMinimumValue___float:(float) minimumValue ;
- (float) minimumValue__;
- (void) setMinimumValueImage___crossmobile_ios_uikit_UIImage:(UIImage*) minimumValueImage ;
- (UIImage*) minimumValueImage__;
- (void) setThumbTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) thumbTintColor ;
- (UIColor*) thumbTintColor__;
- (void) setValue___float:(float) value ;
- (float) value__;
- (UIImage*) maximumTrackImageForState___int:(int) state ;
- (UIImage*) minimumTrackImageForState___int:(int) state ;
- (void) setMaximumTrackImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state ;
- (void) setMinimumTrackImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state ;
- (void) setThumbImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state ;
- (void) setValue___float_boolean:(float) value :(BOOL) animated ;
- (UIImage*) thumbImageForState___int:(int) state ;
@end
