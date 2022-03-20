// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKPaymentTransaction implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_storekit_SKPayment.h"
#import "crossmobile_ios_storekit_SKPaymentTransaction.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_storekit_SKPaymentTransaction$Ext

@end

@implementation SKPaymentTransaction (cm_crossmobile_ios_storekit_SKPaymentTransaction)

// @property(nonatomic, readonly) NSError *error;
- (NSError*) error__
{
    NSError* re$ult = [self error];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) SKPaymentTransaction *originalTransaction;
- (SKPaymentTransaction*) originalTransaction__
{
    SKPaymentTransaction* re$ult = [self originalTransaction];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) SKPayment *payment;
- (SKPayment*) payment__
{
    SKPayment* re$ult = [self payment];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSDate *transactionDate;
- (NSDate*) transactionDate__
{
    NSDate* re$ult = [self transactionDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSString *transactionIdentifier;
- (NSString*) transactionIdentifier__
{
    NSString* re$ult = [self transactionIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSData *transactionReceipt;
- (NSData*) transactionReceipt__
{
    NSData* re$ult = [self transactionReceipt];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) SKPaymentTransactionState transactionState;
- (int) transactionState__
{
    return [self transactionState];
}

@end
