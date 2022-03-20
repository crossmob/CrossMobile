// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSLocale definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSLocale$Ext : NSLocale
@end

#define crossmobile_ios_foundation_NSLocale NSLocale
@interface NSLocale (cm_crossmobile_ios_foundation_NSLocale)
+ (NSLocale*) currentLocale__;
+ (NSArray*) preferredLanguages__;
+ (NSLocale*) systemLocale__;
- (instancetype) __init_crossmobile_ios_foundation_NSLocale___java_lang_String:(NSString*) string ;
- (NSString*) countryCode__;
- (NSString*) languageCode__;
- (NSString*) localeIdentifier__;
- (NSString*) variantCode__;
@end
