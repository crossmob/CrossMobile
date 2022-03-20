// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPrintInteractionCompletionHandler definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_uikit_UIPrintInteractionController;
@class java_lang_Boolean;

@protocol crossmobile_ios_uikit_UIPrintInteractionCompletionHandler
- (void) invoke___crossmobile_ios_uikit_UIPrintInteractionController_java_lang_Boolean_crossmobile_ios_foundation_NSError:(UIPrintInteractionController*) printInteractionController :(java_lang_Boolean*) completed :(NSError*) error ;
@end
