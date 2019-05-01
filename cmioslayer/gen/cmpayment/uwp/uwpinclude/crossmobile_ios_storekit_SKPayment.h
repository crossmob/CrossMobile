// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKPayment definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_storekit_SKProduct;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_storekit_SKPayment$Ext : SKPayment
@end

#define crossmobile_ios_storekit_SKPayment SKPayment
@interface SKPayment (cm_crossmobile_ios_storekit_SKPayment)
+ (instancetype) paymentWithProduct___crossmobile_ios_storekit_SKProduct:(SKProduct*) product ;
- (NSString*) productIdentifier__;
- (int) quantity__;
- (NSData*) requestData__;
@end
