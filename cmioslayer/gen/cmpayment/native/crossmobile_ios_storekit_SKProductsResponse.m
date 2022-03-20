// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKProductsResponse implementation

#import "crossmobile_ios_storekit_SKProductsResponse.h"
#import "java_util_List.h"

@implementation crossmobile_ios_storekit_SKProductsResponse$Ext

@end

@implementation SKProductsResponse (cm_crossmobile_ios_storekit_SKProductsResponse)

// @property(nonatomic, readonly) NSArray<NSString *> *invalidProductIdentifiers;
- (NSArray*) invalidProductIdentifiers__
{
    NSArray* re$ult = [self invalidProductIdentifiers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSArray<SKProduct *> *products;
- (NSArray*) products__
{
    NSArray* re$ult = [self products];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
