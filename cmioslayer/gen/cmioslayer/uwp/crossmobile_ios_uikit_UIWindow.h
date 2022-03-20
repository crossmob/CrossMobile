// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIWindow definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIEvent;
@class crossmobile_ios_uikit_UIViewAppearance;
@class crossmobile_ios_uikit_UIViewController;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UIWindow$Ext : UIWindow
@end

#define crossmobile_ios_uikit_UIWindow UIWindow
@interface UIWindow (cm_crossmobile_ios_uikit_UIWindow)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIWindow__;
- (instancetype) __init_crossmobile_ios_uikit_UIWindow___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setRootViewController___crossmobile_ios_uikit_UIViewController:(UIViewController*) rootViewController ;
- (UIViewController*) rootViewController__;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointFromWindow___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIWindow:(crossmobile_ios_coregraphics_CGPoint*) point :(UIWindow*) window ;
- (crossmobile_ios_coregraphics_CGPoint*) convertPointToWindow___crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIWindow:(crossmobile_ios_coregraphics_CGPoint*) point :(UIWindow*) window ;
- (crossmobile_ios_coregraphics_CGRect*) convertRectFromWindow___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIWindow:(crossmobile_ios_coregraphics_CGRect*) rect :(UIWindow*) window ;
- (crossmobile_ios_coregraphics_CGRect*) convertRectToWindow___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIWindow:(crossmobile_ios_coregraphics_CGRect*) rect :(UIWindow*) window ;
- (void) makeKeyAndVisible__;
- (void) sendEvent___crossmobile_ios_uikit_UIEvent:(UIEvent*) event ;
@end
