// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSJSONSerialization definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_rt_StrongReference;
@class java_lang_Object;

@interface crossmobile_ios_foundation_NSJSONSerialization$Ext : NSJSONSerialization
@end

#define crossmobile_ios_foundation_NSJSONSerialization NSJSONSerialization
@interface NSJSONSerialization (cm_crossmobile_ios_foundation_NSJSONSerialization)
+ (id) JSONObjectWithData___crossmobile_ios_foundation_NSData_int_crossmobile_rt_StrongReference:(NSData*) data :(int) opt :(crossmobile_rt_StrongReference*) error ;
+ (NSData*) dataWithJSONObject___java_lang_Object_int_crossmobile_rt_StrongReference:(id) obj :(int) opt :(crossmobile_rt_StrongReference*) error ;
+ (BOOL) isValidJSONObject___java_lang_Object:(id) obj ;
- (instancetype) __init_crossmobile_ios_foundation_NSJSONSerialization__;
@end
