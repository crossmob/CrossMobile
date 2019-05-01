// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKProductsRequest definition

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
