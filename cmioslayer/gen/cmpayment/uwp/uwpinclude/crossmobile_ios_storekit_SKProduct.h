// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKProduct definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@class crossmobile_ios_foundation_NSLocale;
@class java_lang_Number;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_storekit_SKProduct$Ext : SKProduct
@end

#define crossmobile_ios_storekit_SKProduct SKProduct
@interface SKProduct (cm_crossmobile_ios_storekit_SKProduct)
- (NSString*) localizedDescription__;
- (NSString*) localizedTitle__;
- (java_lang_Number*) price__;
- (NSLocale*) priceLocale__;
- (NSString*) productIdentifier__;
@end
