// (c) 2024 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKProductsResponse definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@protocol java_util_List;

@interface crossmobile_ios_storekit_SKProductsResponse$Ext : SKProductsResponse
@end

#define crossmobile_ios_storekit_SKProductsResponse SKProductsResponse
@interface SKProductsResponse (cm_crossmobile_ios_storekit_SKProductsResponse)
- (NSArray*) invalidProductIdentifiers__;
- (NSArray*) products__;
@end
