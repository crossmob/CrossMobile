// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStoryboard definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSBundle;
@class crossmobile_ios_uikit_UIViewController;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIStoryboard$Ext : UIStoryboard
@end

#define crossmobile_ios_uikit_UIStoryboard UIStoryboard
@interface UIStoryboard (cm_crossmobile_ios_uikit_UIStoryboard)
+ (UIStoryboard*) storyboardWithName___java_lang_String_crossmobile_ios_foundation_NSBundle:(NSString*) name :(NSBundle*) storyboardBundleOrNil ;
- (instancetype) __init_crossmobile_ios_uikit_UIStoryboard__;
- (UIViewController*) instantiateInitialViewController__;
- (UIViewController*) instantiateViewControllerWithIdentifier___java_lang_String:(NSString*) identifier ;
@end
