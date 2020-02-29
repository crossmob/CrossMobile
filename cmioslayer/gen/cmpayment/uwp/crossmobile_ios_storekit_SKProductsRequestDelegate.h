// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_storekit_SKProductsRequestDelegate definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@class crossmobile_ios_storekit_SKProductsRequest;
@class crossmobile_ios_storekit_SKProductsResponse;

@protocol crossmobile_ios_storekit_SKProductsRequestDelegate
- (void) didReceiveResponse___crossmobile_ios_storekit_SKProductsRequest_crossmobile_ios_storekit_SKProductsResponse:(SKProductsRequest*) request :(SKProductsResponse*) response ;
@end
