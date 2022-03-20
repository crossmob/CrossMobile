// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSString definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGSize;
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSLocale;
@class crossmobile_ios_foundation_NSRange;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_uikit_UIFont;
@class crossmobile_rt_StrongReference;
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_foundation_NSString$Ext : NSString
@end

#define crossmobile_ios_foundation_NSString NSString
@interface NSString (cm_crossmobile_ios_foundation_NSString)
+ (BOOL) canBeConvertedToEncoding___java_lang_String_int:(NSString*) this :(int) encoding ;
+ (int) compare___java_lang_String_java_lang_String_int:(NSString*) this :(NSString*) aString :(int) mask ;
+ (NSArray*) componentsSeparatedByString___java_lang_String_java_lang_String:(NSString*) this :(NSString*) separator ;
+ (NSData*) dataUsingEncoding___java_lang_String_int:(NSString*) this :(int) encoding ;
+ (crossmobile_ios_coregraphics_CGSize*) drawAtPoint___java_lang_String_crossmobile_ios_coregraphics_CGPoint_crossmobile_ios_uikit_UIFont:(NSString*) this :(crossmobile_ios_coregraphics_CGPoint*) point :(UIFont*) font ;
+ (instancetype) initWithData___crossmobile_ios_foundation_NSData_int:(NSData*) data :(int) encoding ;
+ (instancetype) initWithFormat___java_lang_String_crossmobile_ios_foundation_NSLocale_java_lang_Object_ARRAYTYPE:(NSString*) format :(NSLocale*) locale :(XMLVMArray*) va_array ;
+ (instancetype) initWithFormat___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array ;
+ (instancetype) localizedStringWithFormat___java_lang_String_java_lang_Object_ARRAYTYPE:(NSString*) format :(XMLVMArray*) va_array ;
+ (crossmobile_ios_coregraphics_CGSize*) sizeWithFont___java_lang_String_crossmobile_ios_uikit_UIFont:(NSString*) this :(UIFont*) font ;
+ (crossmobile_ios_coregraphics_CGSize*) sizeWithFont___java_lang_String_crossmobile_ios_uikit_UIFont_crossmobile_ios_coregraphics_CGSize_int:(NSString*) this :(UIFont*) font :(crossmobile_ios_coregraphics_CGSize*) size :(int) lineBreakMode ;
+ (NSString*) stringByAddingPercentEscapesUsingEncoding___java_lang_String_int:(NSString*) this :(int) encoding ;
+ (NSString*) stringByReplacingCharactersInRange___java_lang_String_crossmobile_ios_foundation_NSRange_java_lang_String:(NSString*) this :(crossmobile_ios_foundation_NSRange*) range :(NSString*) replacement ;
+ (NSString*) stringByReplacingPercentEscapesUsingEncoding___java_lang_String_int:(NSString*) this :(int) encoding ;
+ (id) stringWithContentsOfFile___java_lang_String:(NSString*) path ;
+ (instancetype) stringWithContentsOfFile___java_lang_String_int_crossmobile_rt_StrongReference:(NSString*) path :(int) enc :(crossmobile_rt_StrongReference*) error ;
+ (id) stringWithContentsOfURL___crossmobile_ios_foundation_NSURL:(NSURL*) url ;
+ (instancetype) stringWithContentsOfURL___crossmobile_ios_foundation_NSURL_int_crossmobile_rt_StrongReference:(NSURL*) url :(int) enc :(crossmobile_rt_StrongReference*) error ;
+ (BOOL) writeToFile___java_lang_String_java_lang_String_boolean_int_crossmobile_rt_StrongReference:(NSString*) this :(NSString*) path :(BOOL) useAuxiliaryFile :(int) enc :(crossmobile_rt_StrongReference*) error ;
@end
