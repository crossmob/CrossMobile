// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStoryboardSegue definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIViewController;
@protocol java_lang_Runnable;
@class java_lang_String;

@interface crossmobile_ios_uikit_UIStoryboardSegue$Ext : UIStoryboardSegue
@end

#define crossmobile_ios_uikit_UIStoryboardSegue UIStoryboardSegue
@interface UIStoryboardSegue (cm_crossmobile_ios_uikit_UIStoryboardSegue)
+ (instancetype) segueWithIdentifier___java_lang_String_crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIViewController_java_lang_Runnable:(NSString*) identifier :(UIViewController*) source :(UIViewController*) destination :(id<java_lang_Runnable>) performHandler ;
- (instancetype) __init_crossmobile_ios_uikit_UIStoryboardSegue___java_lang_String_crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIViewController:(NSString*) identifier :(UIViewController*) source :(UIViewController*) destination ;
- (UIViewController*) destinationViewController__;
- (NSString*) identifier__;
- (UIViewController*) sourceViewController__;
- (void) perform__;
@end
