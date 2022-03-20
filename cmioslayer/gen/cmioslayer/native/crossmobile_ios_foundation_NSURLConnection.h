// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLConnection definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@protocol crossmobile_ios_foundation_NSURLConnectionDelegate;
@class crossmobile_ios_foundation_NSURLRequest;
@class crossmobile_rt_StrongReference;

@interface crossmobile_ios_foundation_NSURLConnection$Ext : NSURLConnection
@end

#define crossmobile_ios_foundation_NSURLConnection NSURLConnection
@interface NSURLConnection (cm_crossmobile_ios_foundation_NSURLConnection)
+ (NSURLConnection*) connectionWithRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURLConnectionDelegate:(NSURLRequest*) request :(id<NSURLConnectionDelegate>) delegate ;
+ (NSData*) sendSynchronousRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_rt_StrongReference_crossmobile_rt_StrongReference:(NSURLRequest*) request :(crossmobile_rt_StrongReference*) response :(crossmobile_rt_StrongReference*) error ;
- (instancetype) __init_crossmobile_ios_foundation_NSURLConnection___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURLConnectionDelegate:(NSURLRequest*) request :(id<NSURLConnectionDelegate>) delegate ;
- (instancetype) __init_crossmobile_ios_foundation_NSURLConnection___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURLConnectionDelegate_boolean:(NSURLRequest*) request :(id<NSURLConnectionDelegate>) delegate :(BOOL) startImmediately ;
- (NSURLRequest*) currentRequest__;
- (NSURLRequest*) originalRequest__;
- (void) cancel__;
- (void) start__;
@end
