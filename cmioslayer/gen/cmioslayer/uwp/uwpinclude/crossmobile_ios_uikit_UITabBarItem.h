// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITabBarItem definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIImage;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UITabBarItem$Ext : UITabBarItem
@end

#define crossmobile_ios_uikit_UITabBarItem UITabBarItem
@interface UITabBarItem (cm_crossmobile_ios_uikit_UITabBarItem)
- (instancetype) __init_crossmobile_ios_uikit_UITabBarItem___java_lang_String_crossmobile_ios_uikit_UIImage_int:(NSString*) title :(UIImage*) image :(int) tag ;
- (void) setBadgeValue___java_lang_String:(NSString*) badgeValue ;
- (NSString*) badgeValue__;
@end
