// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UINavigationBar definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIColor;
@protocol crossmobile_ios_uikit_UINavigationBarDelegate;
@class crossmobile_ios_uikit_UINavigationItem;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UINavigationBar$Ext : UINavigationBar
@end

#define crossmobile_ios_uikit_UINavigationBar UINavigationBar
@interface UINavigationBar (cm_crossmobile_ios_uikit_UINavigationBar)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UINavigationBar__;
- (instancetype) __init_crossmobile_ios_uikit_UINavigationBar___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (UINavigationItem*) backItem__;
- (void) setBarStyle___int:(int) barStyle ;
- (int) barStyle__;
- (void) setBarTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) barTintColor ;
- (UIColor*) barTintColor__;
- (void) setDelegate___crossmobile_ios_uikit_UINavigationBarDelegate:(id<UINavigationBarDelegate>) delegate ;
- (id<UINavigationBarDelegate>) delegate__;
- (void) setItems___java_util_List:(NSArray*) items ;
- (NSArray*) items__;
- (void) setTitleTextAttributes___java_util_Map:(NSDictionary*) titleTextAttributes ;
- (NSDictionary*) titleTextAttributes__;
- (UINavigationItem*) topItem__;
- (void) setTranslucent___boolean:(BOOL) translucent ;
- (BOOL) isTranslucent__;
- (UINavigationItem*) popNavigationItemAnimated___boolean:(BOOL) animated ;
- (void) pushNavigationItem___crossmobile_ios_uikit_UINavigationItem_boolean:(UINavigationItem*) item :(BOOL) animated ;
- (void) setItems___java_util_List_boolean:(NSArray*) items :(BOOL) animated ;
@end
