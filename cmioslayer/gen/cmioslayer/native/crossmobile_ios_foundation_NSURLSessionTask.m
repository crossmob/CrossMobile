// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLSessionTask implementation

#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_ios_foundation_NSURLResponse.h"
#import "crossmobile_ios_foundation_NSURLSessionTask.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURLSessionTask$Ext

@end

@implementation NSURLSessionTask (cm_crossmobile_ios_foundation_NSURLSessionTask)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSURLSessionTask__
{
    return [self init];
}

// @property(readonly) int64_t countOfBytesExpectedToReceive;
- (JAVA_LONG) countOfBytesExpectedToReceive__
{
    return [self countOfBytesExpectedToReceive];
}

// @property(readonly) int64_t countOfBytesExpectedToSend;
- (JAVA_LONG) countOfBytesExpectedToSend__
{
    return [self countOfBytesExpectedToSend];
}

// @property(readonly) int64_t countOfBytesReceived;
- (JAVA_LONG) countOfBytesReceived__
{
    return [self countOfBytesReceived];
}

// @property(readonly) int64_t countOfBytesSent;
- (JAVA_LONG) countOfBytesSent__
{
    return [self countOfBytesSent];
}

// @property(readonly, copy) NSURLRequest *currentRequest;
- (NSURLRequest*) currentRequest__
{
    NSURLRequest* re$ult = [self currentRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSError *error;
- (NSError*) error__
{
    NSError* re$ult = [self error];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSURLRequest *originalRequest;
- (NSURLRequest*) originalRequest__
{
    NSURLRequest* re$ult = [self originalRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property float priority;
- (void) setPriority___float:(float) priority 
{
    [self setPriority:priority];
}

// @property float priority;
- (float) priority__
{
    return [self priority];
}

// @property(readonly, copy) NSURLResponse *response;
- (NSURLResponse*) response__
{
    NSURLResponse* re$ult = [self response];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) NSURLSessionTaskState state;
- (int) state__
{
    return [self state];
}

// @property(copy) NSString *taskDescription;
- (void) setTaskDescription___java_lang_String:(NSString*) taskDescription 
{
    [self setTaskDescription:(taskDescription == JAVA_NULL ? nil : taskDescription)];
}

// @property(copy) NSString *taskDescription;
- (NSString*) taskDescription__
{
    NSString* re$ult = [self taskDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) NSUInteger taskIdentifier;
- (int) taskIdentifier__
{
    return [self taskIdentifier];
}

// - (void)cancel;
- (void) cancel__
{
    [self cancel];
}

// - (void)resume;
- (void) resume__
{
    [self resume];
}

// - (void)suspend;
- (void) suspend__
{
    [self suspend];
}

@end
