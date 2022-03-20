// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLSession definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSOperationQueue;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_foundation_NSURLRequest;
@class crossmobile_ios_foundation_NSURLResponse;
@class crossmobile_ios_foundation_NSURLSessionConfiguration;
@class crossmobile_ios_foundation_NSURLSessionDataTask;
@protocol crossmobile_ios_foundation_NSURLSessionDelegate;
@class crossmobile_ios_foundation_NSURLSessionDownloadTask;
@class crossmobile_ios_foundation_NSURLSessionStreamTask;
@class crossmobile_ios_foundation_NSURLSessionUploadTask;
@protocol java_lang_Runnable;
@class java_lang_String;
@protocol java_util_List;
@protocol org_robovm_objc_block_VoidBlock1;
@protocol org_robovm_objc_block_VoidBlock3;

@interface crossmobile_ios_foundation_NSURLSession$Ext : NSURLSession
@end

#define crossmobile_ios_foundation_NSURLSession NSURLSession
@interface NSURLSession (cm_crossmobile_ios_foundation_NSURLSession)
+ (NSURLSession*) sessionWithConfiguration___crossmobile_ios_foundation_NSURLSessionConfiguration:(NSURLSessionConfiguration*) configuration ;
+ (NSURLSession*) sessionWithConfiguration___crossmobile_ios_foundation_NSURLSessionConfiguration_crossmobile_ios_foundation_NSURLSessionDelegate_crossmobile_ios_foundation_NSOperationQueue:(NSURLSessionConfiguration*) configuration :(id<NSURLSessionDelegate>) delegate :(NSOperationQueue*) queue ;
- (NSURLSessionConfiguration*) configuration__;
- (id<NSURLSessionDelegate>) delegate__;
- (NSOperationQueue*) delegateQueue__;
- (void) setSessionDescription___java_lang_String:(NSString*) sessionDescription ;
- (NSString*) sessionDescription__;
- (NSURLSession*) sharedSession__;
- (NSURLSessionDataTask*) dataTaskWithRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request ;
- (NSURLSessionDataTask*) dataTaskWithRequest___crossmobile_ios_foundation_NSURLRequest_org_robovm_objc_block_VoidBlock3:(NSURLRequest*) request :(id<org_robovm_objc_block_VoidBlock3>) completionHandler ;
- (NSURLSessionDataTask*) dataTaskWithURL___crossmobile_ios_foundation_NSURL:(NSURL*) url ;
- (NSURLSessionDataTask*) dataTaskWithURL___crossmobile_ios_foundation_NSURL_org_robovm_objc_block_VoidBlock3:(NSURL*) url :(id<org_robovm_objc_block_VoidBlock3>) completionHandler ;
- (NSURLSessionDownloadTask*) downloadTaskWithRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request ;
- (NSURLSessionDownloadTask*) downloadTaskWithRequest___crossmobile_ios_foundation_NSURLRequest_org_robovm_objc_block_VoidBlock3:(NSURLRequest*) request :(id<org_robovm_objc_block_VoidBlock3>) completionHandler ;
- (NSURLSessionDownloadTask*) downloadTaskWithResumeData___crossmobile_ios_foundation_NSData:(NSData*) resumeData ;
- (NSURLSessionDownloadTask*) downloadTaskWithResumeData___crossmobile_ios_foundation_NSData_org_robovm_objc_block_VoidBlock3:(NSData*) resumeData :(id<org_robovm_objc_block_VoidBlock3>) completionHandler ;
- (NSURLSessionDownloadTask*) downloadTaskWithURL___crossmobile_ios_foundation_NSURL:(NSURL*) url ;
- (NSURLSessionDownloadTask*) downloadTaskWithURL___crossmobile_ios_foundation_NSURL_org_robovm_objc_block_VoidBlock3:(NSURL*) url :(id<org_robovm_objc_block_VoidBlock3>) completionHandler ;
- (void) finishTasksAndInvalidate__;
- (void) flushWithCompletionHandler___java_lang_Runnable:(id<java_lang_Runnable>) completionHandler ;
- (void) getAllTasksWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
- (void) getTasksWithCompletionHandler___org_robovm_objc_block_VoidBlock3:(id<org_robovm_objc_block_VoidBlock3>) completionHandler ;
- (void) invalidateAndCancel__;
- (void) resetWithCompletionHandler___java_lang_Runnable:(id<java_lang_Runnable>) completionHandler ;
- (NSURLSessionStreamTask*) streamTaskWithHostName___java_lang_String_int:(NSString*) hostname :(int) port ;
- (NSURLSessionUploadTask*) uploadTaskWithRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSData:(NSURLRequest*) request :(NSData*) bodyData ;
- (NSURLSessionUploadTask*) uploadTaskWithRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSData_org_robovm_objc_block_VoidBlock3:(NSURLRequest*) request :(NSData*) bodyData :(id<org_robovm_objc_block_VoidBlock3>) completionHandler ;
- (NSURLSessionUploadTask*) uploadTaskWithRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURL:(NSURLRequest*) request :(NSURL*) fileURL ;
- (NSURLSessionUploadTask*) uploadTaskWithRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURL_org_robovm_objc_block_VoidBlock3:(NSURLRequest*) request :(NSURL*) fileURL :(id<org_robovm_objc_block_VoidBlock3>) completionHandler ;
- (NSURLSessionUploadTask*) uploadTaskWithStreamedRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request ;
@end
