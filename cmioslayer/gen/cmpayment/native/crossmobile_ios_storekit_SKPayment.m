// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKPayment implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_storekit_SKPayment.h"
#import "crossmobile_ios_storekit_SKProduct.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_storekit_SKPayment$Ext

@end

@implementation SKPayment (cm_crossmobile_ios_storekit_SKPayment)

// + (instancetype)paymentWithProduct:(SKProduct *)product;
+ (instancetype) paymentWithProduct___crossmobile_ios_storekit_SKProduct:(SKProduct*) product 
{
    id re$ult = [SKPayment paymentWithProduct:(product == JAVA_NULL ? nil : product)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy, readonly) NSString *productIdentifier;
- (NSString*) productIdentifier__
{
    NSString* re$ult = [self productIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSInteger quantity;
- (int) quantity__
{
    return [self quantity];
}

// @property(nonatomic, copy, readonly) NSData *requestData;
- (NSData*) requestData__
{
    NSData* re$ult = [self requestData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
