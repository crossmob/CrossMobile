// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIControl definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@protocol crossmobile_ios_uikit_UIControlDelegate;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_reflect_Method;
@protocol java_util_List;
@protocol java_util_Set;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIControl$Ext : UIControl
@end

#define crossmobile_ios_uikit_UIControl UIControl
@interface UIControl (cm_crossmobile_ios_uikit_UIControl)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIControl__;
- (instancetype) __init_crossmobile_ios_uikit_UIControl___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (NSSet*) allTargets__;
- (void) setContentHorizontalAlignment___int:(int) contentHorizontalAlignment ;
- (int) contentHorizontalAlignment__;
- (void) setContentVerticalAlignment___int:(int) contentVerticalAlignment ;
- (int) contentVerticalAlignment__;
- (void) setEnabled___boolean:(BOOL) enabled ;
- (BOOL) isEnabled__;
- (void) setHighlighted___boolean:(BOOL) highlighted ;
- (BOOL) isHighlighted__;
- (void) setSelected___boolean:(BOOL) selected ;
- (BOOL) isSelected__;
- (int) state__;
- (void) addTarget___crossmobile_ios_uikit_UIControlDelegate_int:(id<crossmobile_ios_uikit_UIControlDelegate>) target :(int) controlEvents ;
- (void) removeTarget___crossmobile_ios_uikit_UIControlDelegate_int:(id<crossmobile_ios_uikit_UIControlDelegate>) target :(int) controlEvents ;
- (void) sendActionsForControlEvents___int:(int) controlEvents ;
@end
