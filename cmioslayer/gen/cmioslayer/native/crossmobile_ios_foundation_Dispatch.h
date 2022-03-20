// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_Dispatch definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol java_lang_Runnable;

#define crossmobile_ios_foundation_Dispatch Dispatch
@interface Dispatch (cm_crossmobile_ios_foundation_Dispatch)
+ (id) getMainQueue__;
- (void) async___java_lang_Runnable:(id<java_lang_Runnable>) block ;
@end
