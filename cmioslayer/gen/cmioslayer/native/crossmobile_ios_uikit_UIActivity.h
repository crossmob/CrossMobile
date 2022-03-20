// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIActivity definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIImage;
@class crossmobile_ios_uikit_UIViewController;
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UIActivity$Ext : UIActivity
@end

#define crossmobile_ios_uikit_UIActivity UIActivity
@interface UIActivity (cm_crossmobile_ios_uikit_UIActivity)
+ (JAVA_LONG) activityCategory__;
- (instancetype) __init_crossmobile_ios_uikit_UIActivity__;
- (UIImage*) activityImage__;
- (NSString*) activityTitle__;
- (NSString*) activityType__;
- (UIViewController*) activityViewController__;
- (void) activityDidFinish___boolean:(BOOL) completed ;
- (BOOL) canPerformWithActivityItems___java_util_List:(NSArray*) activityItems ;
- (void) performActivity__;
- (void) prepareWithActivityItems___java_util_List:(NSArray*) activityItems ;
@end
