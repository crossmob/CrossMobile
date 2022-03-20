// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITabBar definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIImage;
@protocol crossmobile_ios_uikit_UITabBarDelegate;
@class crossmobile_ios_uikit_UITabBarItem;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UITabBar$Ext : UITabBar
@end

#define crossmobile_ios_uikit_UITabBar UITabBar
@interface UITabBar (cm_crossmobile_ios_uikit_UITabBar)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UITabBar__;
- (instancetype) __init_crossmobile_ios_uikit_UITabBar___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setBackgroundImage___crossmobile_ios_uikit_UIImage:(UIImage*) backgroundImage ;
- (UIImage*) backgroundImage__;
- (void) setBarStyle___int:(int) barStyle ;
- (int) barStyle__;
- (void) setBarTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) barTintColor ;
- (UIColor*) barTintColor__;
- (void) setDelegate___crossmobile_ios_uikit_UITabBarDelegate:(id<UITabBarDelegate>) delegate ;
- (id<UITabBarDelegate>) delegate__;
- (void) setItemPositioning___int:(int) itemPositioning ;
- (int) itemPositioning__;
- (void) setItemSpacing___double:(double) itemSpacing ;
- (double) itemSpacing__;
- (void) setItemWidth___double:(double) itemWidth ;
- (double) itemWidth__;
- (void) setItems___java_util_List:(NSArray*) items ;
- (NSArray*) items__;
- (void) setSelectedImageTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) selectedImageTintColor ;
- (UIColor*) selectedImageTintColor__;
- (void) setSelectedItem___crossmobile_ios_uikit_UITabBarItem:(UITabBarItem*) selectedItem ;
- (UITabBarItem*) selectedItem__;
- (void) setSelectionIndicatorImage___crossmobile_ios_uikit_UIImage:(UIImage*) selectionIndicatorImage ;
- (UIImage*) selectionIndicatorImage__;
- (void) setShadowImage___crossmobile_ios_uikit_UIImage:(UIImage*) shadowImage ;
- (UIImage*) shadowImage__;
- (void) setTranslucent___boolean:(BOOL) translucent ;
- (BOOL) isTranslucent__;
- (void) beginCustomizingItems___java_util_List:(NSArray*) items ;
- (BOOL) endCustomizingAnimated___boolean:(BOOL) animated ;
- (BOOL) isCustomizing__;
- (void) setItems___java_util_List_boolean:(NSArray*) items :(BOOL) animated ;
@end
