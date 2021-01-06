// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_storekit_SKPaymentTransaction definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSDate;
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_storekit_SKPayment;
@class java_lang_String;

@interface crossmobile_ios_storekit_SKPaymentTransaction$Ext : SKPaymentTransaction
@end

#define crossmobile_ios_storekit_SKPaymentTransaction SKPaymentTransaction
@interface SKPaymentTransaction (cm_crossmobile_ios_storekit_SKPaymentTransaction)
- (NSError*) error__;
- (SKPaymentTransaction*) originalTransaction__;
- (SKPayment*) payment__;
- (NSDate*) transactionDate__;
- (NSString*) transactionIdentifier__;
- (NSData*) transactionReceipt__;
- (int) transactionState__;
@end
