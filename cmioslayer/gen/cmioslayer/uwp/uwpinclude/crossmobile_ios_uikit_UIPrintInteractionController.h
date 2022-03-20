// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPrintInteractionController definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSObject;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_uikit_UIBarButtonItem;
@protocol crossmobile_ios_uikit_UIPrintInteractionCompletionHandler;
@class crossmobile_ios_uikit_UIView;
@protocol java_util_List;
@protocol java_util_Set;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIPrintInteractionController$Ext : UIPrintInteractionController
@end

#define crossmobile_ios_uikit_UIPrintInteractionController UIPrintInteractionController
@interface UIPrintInteractionController (cm_crossmobile_ios_uikit_UIPrintInteractionController)
+ (BOOL) canPrintData___crossmobile_ios_foundation_NSData:(NSData*) data ;
+ (BOOL) canPrintURL___crossmobile_ios_foundation_NSURL:(NSURL*) url ;
+ (BOOL) isPrintingAvailable__;
+ (NSSet*) printableUTIs__;
+ (UIPrintInteractionController*) sharedPrintController__;
- (instancetype) __init_crossmobile_ios_uikit_UIPrintInteractionController__;
- (void) setPrintingItem___crossmobile_ios_foundation_NSObject:(NSObject*) printingItem ;
- (id) printingItem__;
- (void) setPrintingItems___java_util_List:(NSArray*) printingItems ;
- (NSArray*) printingItems__;
- (void) dismissAnimated___boolean:(BOOL) animated ;
- (BOOL) presentAnimated___boolean_crossmobile_ios_uikit_UIPrintInteractionCompletionHandler:(BOOL) animated :(id<crossmobile_ios_uikit_UIPrintInteractionCompletionHandler>) completion ;
- (BOOL) presentFromBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean_crossmobile_ios_uikit_UIPrintInteractionCompletionHandler:(UIBarButtonItem*) item :(BOOL) animated :(id<crossmobile_ios_uikit_UIPrintInteractionCompletionHandler>) completion ;
- (BOOL) presentFromRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView_boolean_crossmobile_ios_uikit_UIPrintInteractionCompletionHandler:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view :(BOOL) animated :(id<crossmobile_ios_uikit_UIPrintInteractionCompletionHandler>) completion ;
@end
