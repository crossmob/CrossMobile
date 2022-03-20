// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSLocale implementation

#import "crossmobile_ios_foundation_NSLocale.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_foundation_NSLocale$Ext

@end

@implementation NSLocale (cm_crossmobile_ios_foundation_NSLocale)

// + (NSLocale *)currentLocale;
+ (NSLocale*) currentLocale__
{
    NSLocale* re$ult = [NSLocale currentLocale];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSArray<NSString *> *)preferredLanguages;
+ (NSArray*) preferredLanguages__
{
    NSArray* re$ult = [NSLocale preferredLanguages];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSLocale *)systemLocale;
+ (NSLocale*) systemLocale__
{
    NSLocale* re$ult = [NSLocale systemLocale];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithLocaleIdentifier:(NSString *)string;
- (instancetype) __init_crossmobile_ios_foundation_NSLocale___java_lang_String:(NSString*) string 
{
    return [self initWithLocaleIdentifier:(string == JAVA_NULL ? nil : string)];
}

// @property(readonly, copy) NSString *countryCode;
- (NSString*) countryCode__
{
    NSString* re$ult = [self countryCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSString *languageCode;
- (NSString*) languageCode__
{
    NSString* re$ult = [self languageCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSString *localeIdentifier ;
- (NSString*) localeIdentifier__
{
    NSString* re$ult = [self localeIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSString *variantCode;
- (NSString*) variantCode__
{
    NSString* re$ult = [self variantCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
