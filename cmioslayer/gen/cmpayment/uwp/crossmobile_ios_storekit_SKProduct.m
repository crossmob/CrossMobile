// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKProduct implementation

#import "crossmobile_ios_foundation_NSLocale.h"
#import "crossmobile_ios_storekit_SKProduct.h"
#import "java_lang_Number.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_storekit_SKProduct$Ext

@end

@implementation SKProduct (cm_crossmobile_ios_storekit_SKProduct)

// @property(nonatomic, readonly) NSString *localizedDescription;
- (NSString*) localizedDescription__
{
    NSString* re$ult = [self localizedDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSString *localizedTitle;
- (NSString*) localizedTitle__
{
    NSString* re$ult = [self localizedTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSDecimalNumber *price;
- (java_lang_Number*) price__
{
    java_lang_Number* re$ult = [self price];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSLocale *priceLocale;
- (NSLocale*) priceLocale__
{
    NSLocale* re$ult = [self priceLocale];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSString *productIdentifier;
- (NSString*) productIdentifier__
{
    NSString* re$ult = [self productIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
