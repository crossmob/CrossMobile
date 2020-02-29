// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UIPrintInteractionCompletionHandler definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_uikit_UIPrintInteractionController;
@class java_lang_Boolean;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UIPrintInteractionCompletionHandler
- (void) invoke___crossmobile_ios_uikit_UIPrintInteractionController_java_lang_Boolean_crossmobile_ios_foundation_NSError:(UIPrintInteractionController*) printInteractionController :(java_lang_Boolean*) completed :(NSError*) error ;
@end
