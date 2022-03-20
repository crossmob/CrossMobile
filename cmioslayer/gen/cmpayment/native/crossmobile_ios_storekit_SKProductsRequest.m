// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKProductsRequest implementation

#import "crossmobile_ios_storekit_SKProductsRequest.h"
#import "crossmobile_ios_storekit_SKProductsRequestDelegate.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_storekit_SKProductsRequest$Ext

@end

@implementation SKProductsRequest (cm_crossmobile_ios_storekit_SKProductsRequest)

// - (instancetype)initWithProductIdentifiers:(NSSet<NSString *> *)productIdentifiers;
- (instancetype) __init_crossmobile_ios_storekit_SKProductsRequest___java_util_Set:(NSSet*) productIdentifiers 
{
    return [self initWithProductIdentifiers:(productIdentifiers == JAVA_NULL ? nil : productIdentifiers)];
}

// @property(nonatomic, assign) id<SKProductsRequestDelegate> delegate;
- (void) setDelegate___crossmobile_ios_storekit_SKProductsRequestDelegate:(id<SKProductsRequestDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, assign) id<SKProductsRequestDelegate> delegate;
- (id<SKProductsRequestDelegate>) productsDelegate__
{
    id<SKProductsRequestDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
