// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLSessionDownloadTask implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSURLSessionDownloadTask.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_foundation_NSURLSessionDownloadTask$Ext

@end

@implementation NSURLSessionDownloadTask (cm_crossmobile_ios_foundation_NSURLSessionDownloadTask)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSURLSessionDownloadTask__
{
    return [self init];
}

// - (void)cancelByProducingResumeData:(void (^)(NSData *resumeData))completionHandler;
- (void) cancelByProducingResumeData___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self cancelByProducingResumeData:(completionHandler == JAVA_NULL ? nil : ^(NSData* resumeData) {
        [completionHandler invoke___java_lang_Object:(resumeData ? resumeData : JAVA_NULL)];
    })];
}

@end
