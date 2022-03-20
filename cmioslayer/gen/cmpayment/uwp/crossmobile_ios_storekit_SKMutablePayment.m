// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKMutablePayment implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_storekit_SKMutablePayment.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_storekit_SKMutablePayment$Ext

@end

@implementation SKMutablePayment (cm_crossmobile_ios_storekit_SKMutablePayment)

// @property(nonatomic, copy, readwrite) NSString *productIdentifier;
- (void) setProductIdentifier___java_lang_String:(NSString*) productIdentifier 
{
    [self setProductIdentifier:(productIdentifier == JAVA_NULL ? nil : productIdentifier)];
}

// @property(nonatomic, readwrite) NSInteger quantity;
- (void) setQuantity___int:(int) quantity 
{
    [self setQuantity:quantity];
}

// @property(nonatomic, copy, readwrite) NSData *requestData;
- (void) setRequestData___crossmobile_ios_foundation_NSData:(NSData*) requestData 
{
    [self setRequestData:(requestData == JAVA_NULL ? nil : requestData)];
}

@end
