// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSNotificationCenter definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSNotification;
@protocol crossmobile_ios_foundation_NSSelector;
@class java_lang_Object;
@class java_lang_String;
@class java_lang_reflect_Method;
@protocol java_util_Map;

@interface crossmobile_ios_foundation_NSNotificationCenter$Ext : NSNotificationCenter
@end

#define crossmobile_ios_foundation_NSNotificationCenter NSNotificationCenter
@interface NSNotificationCenter (cm_crossmobile_ios_foundation_NSNotificationCenter)
+ (NSNotificationCenter*) defaultCenter__;
- (void) addObserver___crossmobile_ios_foundation_NSSelector_java_lang_String_java_lang_Object:(id<crossmobile_ios_foundation_NSSelector>) observer :(NSString*) aName :(id) anObject ;
- (void) postNotification___crossmobile_ios_foundation_NSNotification:(NSNotification*) notification ;
- (void) postNotificationName___java_lang_String_java_lang_Object:(NSString*) aName :(id) anObject ;
- (void) postNotificationName___java_lang_String_java_lang_Object_java_util_Map:(NSString*) aName :(id) anObject :(NSDictionary*) aUserInfo ;
- (void) removeObserver___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) observer ;
- (void) removeObserver___crossmobile_ios_foundation_NSSelector_java_lang_String_java_lang_Object:(id<crossmobile_ios_foundation_NSSelector>) observer :(NSString*) aName :(id) anObject ;
@end
