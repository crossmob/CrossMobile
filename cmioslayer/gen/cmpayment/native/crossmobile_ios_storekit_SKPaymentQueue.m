// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKPaymentQueue implementation

#import "crossmobile_ios_storekit_SKPayment.h"
#import "crossmobile_ios_storekit_SKPaymentQueue.h"
#import "crossmobile_ios_storekit_SKPaymentTransaction.h"
#import "crossmobile_ios_storekit_SKPaymentTransactionObserver.h"
#import "java_util_List.h"

@implementation crossmobile_ios_storekit_SKPaymentQueue$Ext

@end

@implementation SKPaymentQueue (cm_crossmobile_ios_storekit_SKPaymentQueue)

// + (BOOL)canMakePayments;
+ (BOOL) canMakePayments__
{
    return [SKPaymentQueue canMakePayments];
}

// + (instancetype)defaultQueue;
+ (instancetype) defaultQueue__
{
    id re$ult = [SKPaymentQueue defaultQueue];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSArray<SKPaymentTransaction *> *transactions;
- (NSArray*) transactions__
{
    NSArray* re$ult = [self transactions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)addPayment:(SKPayment *)payment;
- (void) addPayment___crossmobile_ios_storekit_SKPayment:(SKPayment*) payment 
{
    [self addPayment:(payment == JAVA_NULL ? nil : payment)];
}

// - (void)addTransactionObserver:(id<SKPaymentTransactionObserver>)observer;
- (void) addTransactionObserver___crossmobile_ios_storekit_SKPaymentTransactionObserver:(id<SKPaymentTransactionObserver>) observer 
{
    [self addTransactionObserver:(observer == JAVA_NULL ? nil : observer)];
}

// - (void)finishTransaction:(SKPaymentTransaction *)transaction;
- (void) finishTransaction___crossmobile_ios_storekit_SKPaymentTransaction:(SKPaymentTransaction*) transaction 
{
    [self finishTransaction:(transaction == JAVA_NULL ? nil : transaction)];
}

// - (void)removeTransactionObserver:(id<SKPaymentTransactionObserver>)observer;
- (void) removeTransactionObserver___crossmobile_ios_storekit_SKPaymentTransactionObserver:(id<SKPaymentTransactionObserver>) observer 
{
    [self removeTransactionObserver:(observer == JAVA_NULL ? nil : observer)];
}

// - (void)restoreCompletedTransactions;
- (void) restoreCompletedTransactions__
{
    [self restoreCompletedTransactions];
}

@end
