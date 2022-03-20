// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSItemProviderLoadHandler definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_foundation_NSItemProviderCompletionHandler;
@class java_lang_Class;
@protocol java_util_Map;

CM_EXPORT_CLASS
@protocol crossmobile_ios_foundation_NSItemProviderLoadHandler
- (void) invoke___crossmobile_ios_foundation_NSItemProviderCompletionHandler_java_lang_Class_java_util_Map:(id<crossmobile_ios_foundation_NSItemProviderCompletionHandler>) completionHandler :(java_lang_Class*) expectedValueClass :(NSDictionary*) options ;
@end
