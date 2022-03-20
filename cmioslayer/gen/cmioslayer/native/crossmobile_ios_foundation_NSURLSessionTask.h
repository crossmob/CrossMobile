// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLSessionTask definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSURLRequest;
@class crossmobile_ios_foundation_NSURLResponse;
@class java_lang_String;

@interface crossmobile_ios_foundation_NSURLSessionTask$Ext : NSURLSessionTask
@end

#define crossmobile_ios_foundation_NSURLSessionTask NSURLSessionTask
@interface NSURLSessionTask (cm_crossmobile_ios_foundation_NSURLSessionTask)
- (instancetype) __init_crossmobile_ios_foundation_NSURLSessionTask__;
- (JAVA_LONG) countOfBytesExpectedToReceive__;
- (JAVA_LONG) countOfBytesExpectedToSend__;
- (JAVA_LONG) countOfBytesReceived__;
- (JAVA_LONG) countOfBytesSent__;
- (NSURLRequest*) currentRequest__;
- (NSError*) error__;
- (NSURLRequest*) originalRequest__;
- (void) setPriority___float:(float) priority ;
- (float) priority__;
- (NSURLResponse*) response__;
- (int) state__;
- (void) setTaskDescription___java_lang_String:(NSString*) taskDescription ;
- (NSString*) taskDescription__;
- (int) taskIdentifier__;
- (void) cancel__;
- (void) resume__;
- (void) suspend__;
@end
