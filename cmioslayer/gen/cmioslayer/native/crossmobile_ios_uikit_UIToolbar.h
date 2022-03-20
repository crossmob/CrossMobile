// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIToolbar definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UIToolbar$Ext : UIToolbar
@end

#define crossmobile_ios_uikit_UIToolbar UIToolbar
@interface UIToolbar (cm_crossmobile_ios_uikit_UIToolbar)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIToolbar__;
- (instancetype) __init_crossmobile_ios_uikit_UIToolbar___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setBarStyle___int:(int) barStyle ;
- (int) barStyle__;
- (void) setBarTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) barTintColor ;
- (UIColor*) barTintColor__;
- (void) setItems___java_util_List:(NSArray*) items ;
- (NSArray*) items__;
- (void) setTranslucent___boolean:(BOOL) translucent ;
- (BOOL) isTranslucent__;
- (void) setItems___java_util_List_boolean:(NSArray*) items :(BOOL) animated ;
@end
