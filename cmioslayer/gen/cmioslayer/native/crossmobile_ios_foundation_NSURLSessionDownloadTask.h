// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLSessionDownloadTask definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSData;
@protocol org_robovm_objc_block_VoidBlock1;

@interface crossmobile_ios_foundation_NSURLSessionDownloadTask$Ext : NSURLSessionDownloadTask
@end

#define crossmobile_ios_foundation_NSURLSessionDownloadTask NSURLSessionDownloadTask
@interface NSURLSessionDownloadTask (cm_crossmobile_ios_foundation_NSURLSessionDownloadTask)
- (instancetype) __init_crossmobile_ios_foundation_NSURLSessionDownloadTask__;
- (void) cancelByProducingResumeData___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
@end
