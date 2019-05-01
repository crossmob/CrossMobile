// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIFont definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIFont$Ext : UIFont
@end

#define crossmobile_ios_uikit_UIFont UIFont
@interface UIFont (cm_crossmobile_ios_uikit_UIFont)
+ (UIFont*) boldSystemFontOfSize___double:(double) fontSize ;
+ (double) buttonFontSize__;
+ (NSArray*) familyNames__;
+ (NSArray*) fontNamesForFamilyName___java_lang_String:(NSString*) familyName ;
+ (UIFont*) fontWithName___java_lang_String_double:(NSString*) fontName :(double) fontSize ;
+ (UIFont*) italicSystemFontOfSize___double:(double) fontSize ;
+ (double) labelFontSize__;
+ (double) smallSystemFontSize__;
+ (UIFont*) systemFontOfSize___double:(double) fontSize ;
+ (double) systemFontSize__;
- (NSString*) familyName__;
- (NSString*) fontName__;
- (double) pointSize__;
- (UIFont*) fontWithSize___double:(double) fontSize ;
@end
