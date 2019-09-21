// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_storekit_SKMutablePayment definition

#import "xmlvm.h"
#import <StoreKit/StoreKit.h>
@class crossmobile_ios_foundation_NSData;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_storekit_SKMutablePayment$Ext : SKMutablePayment
@end

#define crossmobile_ios_storekit_SKMutablePayment SKMutablePayment
@interface SKMutablePayment (cm_crossmobile_ios_storekit_SKMutablePayment)
- (void) setProductIdentifier___java_lang_String:(NSString*) productIdentifier ;
- (void) setQuantity___int:(int) quantity ;
- (void) setRequestData___crossmobile_ios_foundation_NSData:(NSData*) requestData ;
@end
