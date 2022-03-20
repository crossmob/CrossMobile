// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLConnection implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSURLConnection.h"
#import "crossmobile_ios_foundation_NSURLConnectionDelegate.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_rt_StrongReference.h"

@implementation crossmobile_ios_foundation_NSURLConnection$Ext

@end

@implementation NSURLConnection (cm_crossmobile_ios_foundation_NSURLConnection)

// + (NSURLConnection *)connectionWithRequest:(NSURLRequest *)request delegate:(id)delegate;
+ (NSURLConnection*) connectionWithRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURLConnectionDelegate:(NSURLRequest*) request :(id<NSURLConnectionDelegate>) delegate 
{
    NSURLConnection* re$ult = [NSURLConnection connectionWithRequest:(request == JAVA_NULL ? nil : request) delegate:(delegate == JAVA_NULL ? nil : delegate)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSData *)sendSynchronousRequest:(NSURLRequest *)request returningResponse:(NSURLResponse * _Nullable *)response error:(NSError * _Nullable *)error;
+ (NSData*) sendSynchronousRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_rt_StrongReference_crossmobile_rt_StrongReference:(NSURLRequest*) request :(crossmobile_rt_StrongReference*) response :(crossmobile_rt_StrongReference*) error 
{
    response = response == JAVA_NULL ? nil : response;
    id response$conv = nil;
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSData* re$ult = [NSURLConnection sendSynchronousRequest:(request == JAVA_NULL ? nil : request) returningResponse:(response ? &response$conv : nil) error:(error ? &error$conv : nil)];
    if (response)
        [response set___java_lang_Object:(response$conv ? response$conv : JAVA_NULL)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithRequest:(NSURLRequest *)request delegate:(id)delegate;
- (instancetype) __init_crossmobile_ios_foundation_NSURLConnection___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURLConnectionDelegate:(NSURLRequest*) request :(id<NSURLConnectionDelegate>) delegate 
{
    return [self initWithRequest:(request == JAVA_NULL ? nil : request) delegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// - (instancetype)initWithRequest:(NSURLRequest *)request delegate:(id)delegate startImmediately:(BOOL)startImmediately;
- (instancetype) __init_crossmobile_ios_foundation_NSURLConnection___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURLConnectionDelegate_boolean:(NSURLRequest*) request :(id<NSURLConnectionDelegate>) delegate :(BOOL) startImmediately 
{
    return [self initWithRequest:(request == JAVA_NULL ? nil : request) delegate:(delegate == JAVA_NULL ? nil : delegate) startImmediately:startImmediately];
}

// @property(readonly, copy) NSURLRequest *currentRequest;
- (NSURLRequest*) currentRequest__
{
    NSURLRequest* re$ult = [self currentRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSURLRequest *originalRequest;
- (NSURLRequest*) originalRequest__
{
    NSURLRequest* re$ult = [self originalRequest];
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
