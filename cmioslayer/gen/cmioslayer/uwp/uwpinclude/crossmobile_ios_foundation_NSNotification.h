// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSNotification definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_Object;
@class java_lang_String;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSNotification$Ext : NSNotification
@end

#define crossmobile_ios_foundation_NSNotification NSNotification
@interface NSNotification (cm_crossmobile_ios_foundation_NSNotification)
+ (instancetype) notificationWithName___java_lang_String_java_lang_Object:(NSString*) aName :(id) anObject ;
+ (instancetype) notificationWithName___java_lang_String_java_lang_Object_java_util_Map:(NSString*) aName :(id) anObject :(NSDictionary*) aUserInfo ;
- (instancetype) __init_crossmobile_ios_foundation_NSNotification___java_lang_String_java_lang_Object_java_util_Map:(NSString*) name :(id) object :(NSDictionary*) userInfo ;
- (NSString*) name__;
- (id) object__;
- (NSDictionary*) userInfo__;
@end
