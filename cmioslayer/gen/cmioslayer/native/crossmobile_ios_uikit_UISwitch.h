// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISwitch definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UISwitch$Ext : UISwitch
@end

#define crossmobile_ios_uikit_UISwitch UISwitch
@interface UISwitch (cm_crossmobile_ios_uikit_UISwitch)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UISwitch__;
- (instancetype) __init_crossmobile_ios_uikit_UISwitch___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setOn___boolean:(BOOL) on ;
- (BOOL) isOn__;
- (void) setOnTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) onTintColor ;
- (UIColor*) onTintColor__;
- (void) setThumbTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) thumbTintColor ;
- (UIColor*) thumbTintColor__;
- (void) setOn___boolean_boolean:(BOOL) on :(BOOL) animated ;
@end
