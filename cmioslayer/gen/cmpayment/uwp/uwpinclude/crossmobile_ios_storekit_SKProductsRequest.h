// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKProductsRequest definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@protocol crossmobile_ios_storekit_SKProductsRequestDelegate;
@protocol java_util_Set;

CM_EXPORT_CLASS
@interface crossmobile_ios_storekit_SKProductsRequest$Ext : SKProductsRequest
@end

#define crossmobile_ios_storekit_SKProductsRequest SKProductsRequest
@interface SKProductsRequest (cm_crossmobile_ios_storekit_SKProductsRequest)
- (instancetype) __init_crossmobile_ios_storekit_SKProductsRequest___java_util_Set:(NSSet*) productIdentifiers ;
- (void) setDelegate___crossmobile_ios_storekit_SKProductsRequestDelegate:(id<SKProductsRequestDelegate>) delegate ;
- (id<SKProductsRequestDelegate>) productsDelegate__;
@end
