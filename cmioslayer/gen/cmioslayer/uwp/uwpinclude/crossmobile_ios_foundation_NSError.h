// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSError definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSError$Ext : NSError
@end

#define crossmobile_ios_foundation_NSError NSError
@interface NSError (cm_crossmobile_ios_foundation_NSError)
+ (instancetype) errorWithDomain___java_lang_String_int_java_util_Map:(NSString*) domain :(int) code :(NSDictionary*) dict ;
- (instancetype) __init_crossmobile_ios_foundation_NSError___java_lang_String_int_java_util_Map:(NSString*) domain :(int) code :(NSDictionary*) dict ;
- (int) code__;
- (NSString*) domain__;
- (NSString*) localizedDescription__;
- (NSDictionary*) userInfo__;
@end
