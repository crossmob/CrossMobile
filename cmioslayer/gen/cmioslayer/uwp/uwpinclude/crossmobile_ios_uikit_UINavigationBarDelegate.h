// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UINavigationBarDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UINavigationBar;
@class crossmobile_ios_uikit_UINavigationItem;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UINavigationBarDelegate
- (void) didPopItem___crossmobile_ios_uikit_UINavigationBar_crossmobile_ios_uikit_UINavigationItem:(UINavigationBar*) navigationBar :(UINavigationItem*) item ;
- (void) didPushItem___crossmobile_ios_uikit_UINavigationBar_crossmobile_ios_uikit_UINavigationItem:(UINavigationBar*) navigationBar :(UINavigationItem*) item ;
- (BOOL) shouldPopItem___crossmobile_ios_uikit_UINavigationBar_crossmobile_ios_uikit_UINavigationItem:(UINavigationBar*) navigationBar :(UINavigationItem*) item ;
- (BOOL) shouldPushItem___crossmobile_ios_uikit_UINavigationBar_crossmobile_ios_uikit_UINavigationItem:(UINavigationBar*) navigationBar :(UINavigationItem*) item ;
@end
