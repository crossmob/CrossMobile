// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_storekit_SKRequest implementation

#import "crossmobile_ios_storekit_SKRequest.h"
#import "crossmobile_ios_storekit_SKRequestDelegate.h"

@implementation crossmobile_ios_storekit_SKRequest$Ext

@end

@implementation SKRequest (cm_crossmobile_ios_storekit_SKRequest)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_storekit_SKRequest__
{
    return [self init];
}

// @property(nonatomic, assign) id<SKRequestDelegate> delegate;
- (void) setDelegate___crossmobile_ios_storekit_SKRequestDelegate:(id<SKRequestDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, assign) id<SKRequestDelegate> delegate;
- (id<SKRequestDelegate>) delegate__
{
    id<SKRequestDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)cancel;
- (void) cancel__
{
    [self cancel];
}

// - (void)start;
- (void) start__
{
    [self start];
}

@end
