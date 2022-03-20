// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKPaymentTransactionObserver definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_storekit_SKPaymentQueue;
@protocol java_util_List;

CM_EXPORT_CLASS
@protocol crossmobile_ios_storekit_SKPaymentTransactionObserver
- (void) removedTransactions___crossmobile_ios_storekit_SKPaymentQueue_java_util_List:(SKPaymentQueue*) queue :(NSArray*) transactions ;
- (void) restoreCompletedTransactionsFailedWithError___crossmobile_ios_storekit_SKPaymentQueue_crossmobile_ios_foundation_NSError:(SKPaymentQueue*) queue :(NSError*) error ;
- (void) restoreCompletedTransactionsFinished___crossmobile_ios_storekit_SKPaymentQueue:(SKPaymentQueue*) queue ;
- (void) updatedTransactions___crossmobile_ios_storekit_SKPaymentQueue_java_util_List:(SKPaymentQueue*) queue :(NSArray*) transactions ;
@end
