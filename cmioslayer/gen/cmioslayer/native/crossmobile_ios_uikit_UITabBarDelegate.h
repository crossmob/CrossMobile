// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UITabBarDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UITabBar;
@class crossmobile_ios_uikit_UITabBarItem;
@protocol java_util_List;

@protocol crossmobile_ios_uikit_UITabBarDelegate
- (void) didBeginCustomizingItems___crossmobile_ios_uikit_UITabBar_java_util_List:(UITabBar*) tabBar :(NSArray*) items ;
- (void) didEndCustomizingItems___crossmobile_ios_uikit_UITabBar_java_util_List_boolean:(UITabBar*) tabBar :(NSArray*) items :(BOOL) changed ;
- (void) didSelectItem___crossmobile_ios_uikit_UITabBar_crossmobile_ios_uikit_UITabBarItem:(UITabBar*) tabBar :(UITabBarItem*) item ;
- (void) willBeginCustomizingItems___crossmobile_ios_uikit_UITabBar_java_util_List:(UITabBar*) tabBar :(NSArray*) items ;
- (void) willEndCustomizingItems___crossmobile_ios_uikit_UITabBar_java_util_List_boolean:(UITabBar*) tabBar :(NSArray*) items :(BOOL) changed ;
@end
