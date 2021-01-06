// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_storekit_SKProductsResponse definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_storekit_SKProductsResponse$Ext : SKProductsResponse
@end

#define crossmobile_ios_storekit_SKProductsResponse SKProductsResponse
@interface SKProductsResponse (cm_crossmobile_ios_storekit_SKProductsResponse)
- (NSArray*) invalidProductIdentifiers__;
- (NSArray*) products__;
@end
