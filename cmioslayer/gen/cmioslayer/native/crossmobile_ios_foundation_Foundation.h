// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_Foundation definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "java_lang_Object.h"
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_foundation_Foundation : java_lang_Object
+ (NSString*) NSHomeDirectory__;
+ (void) NSLog___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array ;
+ (NSArray*) NSSearchPathForDirectoriesInDomains___int_int_boolean:(int) directory :(int) domainMask :(BOOL) expandTilde ;
+ (NSString*) NSTemporaryDirectory__;
@end
