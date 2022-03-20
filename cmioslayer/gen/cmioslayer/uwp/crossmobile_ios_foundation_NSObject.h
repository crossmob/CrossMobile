// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSObject definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_foundation_NSSelector;
@class java_lang_Object;
@class java_lang_String;
@protocol java_util_Map;

@interface crossmobile_ios_foundation_NSObject$Ext : NSObject
@end

#define crossmobile_ios_foundation_NSObject NSObject
@interface NSObject (cm_crossmobile_ios_foundation_NSObject)
- (instancetype) __init_crossmobile_ios_foundation_NSObject__;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context ;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context ;
- (void) performSelector___crossmobile_ios_foundation_NSSelector_java_lang_Object_double:(id<crossmobile_ios_foundation_NSSelector>) aSelector :(id) anArgument :(double) delay ;
- (void) performSelectorOnMainThread___crossmobile_ios_foundation_NSSelector_java_lang_Object_boolean:(id<crossmobile_ios_foundation_NSSelector>) aSelector :(id) arg :(BOOL) wait ;
- (void) release__;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath ;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context ;
- (instancetype) retain__;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key ;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key ;
- (id) valueForKey___java_lang_String:(NSString*) key ;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key ;
@end
