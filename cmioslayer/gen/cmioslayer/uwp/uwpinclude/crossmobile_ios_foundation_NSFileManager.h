// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSFileManager definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_rt_StrongReference;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSFileManager$Ext : NSFileManager
@end

#define crossmobile_ios_foundation_NSFileManager NSFileManager
@interface NSFileManager (cm_crossmobile_ios_foundation_NSFileManager)
+ (NSFileManager*) defaultManager__;
- (NSArray*) contentsOfDirectoryAtPath___java_lang_String_crossmobile_rt_StrongReference:(NSString*) path :(crossmobile_rt_StrongReference*) error ;
- (BOOL) createDirectoryAtPath___java_lang_String_boolean_java_util_Map_crossmobile_rt_StrongReference:(NSString*) path :(BOOL) createIntermediates :(NSDictionary*) attributes :(crossmobile_rt_StrongReference*) error ;
- (BOOL) fileExistsAtPath___java_lang_String:(NSString*) path ;
@end
