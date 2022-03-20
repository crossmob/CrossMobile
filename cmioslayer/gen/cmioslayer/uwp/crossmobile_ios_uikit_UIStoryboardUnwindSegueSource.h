// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStoryboardUnwindSegueSource definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIViewController;
@class java_lang_Object;
@class java_lang_reflect_Method;

@interface crossmobile_ios_uikit_UIStoryboardUnwindSegueSource$Ext : UIStoryboardUnwindSegueSource
@end

#define crossmobile_ios_uikit_UIStoryboardUnwindSegueSource UIStoryboardUnwindSegueSource
@interface UIStoryboardUnwindSegueSource (cm_crossmobile_ios_uikit_UIStoryboardUnwindSegueSource)
- (id) sender__;
- (UIViewController*) sourceViewController__;
- (java_lang_reflect_Method*) unwindAction__;
@end
