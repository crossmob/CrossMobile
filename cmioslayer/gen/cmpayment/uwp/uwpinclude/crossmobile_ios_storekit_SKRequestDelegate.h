// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKRequestDelegate definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_storekit_SKRequest;

CM_EXPORT_CLASS
@protocol crossmobile_ios_storekit_SKRequestDelegate
- (void) didFailWithError___crossmobile_ios_storekit_SKRequest_crossmobile_ios_foundation_NSError:(SKRequest*) request :(NSError*) error ;
- (void) didFinish___crossmobile_ios_storekit_SKRequest:(SKRequest*) request ;
@end
