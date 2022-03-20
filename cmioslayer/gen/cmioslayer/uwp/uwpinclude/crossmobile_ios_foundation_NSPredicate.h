// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSPredicate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_Object;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSPredicate$Ext : NSPredicate
@end

#define crossmobile_ios_foundation_NSPredicate NSPredicate
@interface NSPredicate (cm_crossmobile_ios_foundation_NSPredicate)
+ (NSPredicate*) predicateWithFormat___java_lang_String_java_util_List:(NSString*) predicateFormat :(NSArray*) arguments ;
+ (NSPredicate*) predicateWithValue___boolean:(BOOL) value ;
- (instancetype) __init_crossmobile_ios_foundation_NSPredicate__;
- (NSString*) predicateFormat__;
- (void) allowEvaluation__;
- (BOOL) evaluateWithObject___java_lang_Object:(id) object ;
- (BOOL) evaluateWithObject___java_lang_Object_java_util_Map:(id) object :(NSDictionary*) bindings ;
- (instancetype) predicateWithSubstitutionVariables___java_util_Map:(NSDictionary*) variables ;
@end
