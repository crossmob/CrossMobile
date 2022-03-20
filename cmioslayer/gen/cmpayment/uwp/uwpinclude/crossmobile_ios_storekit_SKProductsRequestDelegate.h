// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKProductsRequestDelegate definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@class crossmobile_ios_storekit_SKProductsRequest;
@class crossmobile_ios_storekit_SKProductsResponse;

CM_EXPORT_CLASS
@protocol crossmobile_ios_storekit_SKProductsRequestDelegate
- (void) didReceiveResponse___crossmobile_ios_storekit_SKProductsRequest_crossmobile_ios_storekit_SKProductsResponse:(SKProductsRequest*) request :(SKProductsResponse*) response ;
@end
