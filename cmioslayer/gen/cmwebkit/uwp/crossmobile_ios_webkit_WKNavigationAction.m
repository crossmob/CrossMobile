// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKNavigationAction implementation

#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_ios_webkit_WKFrameInfo.h"
#import "crossmobile_ios_webkit_WKNavigationAction.h"

@implementation crossmobile_ios_webkit_WKNavigationAction$Ext

@end

@implementation WKNavigationAction (cm_crossmobile_ios_webkit_WKNavigationAction)

// @property(nonatomic, readonly, copy) NSURLRequest *request;
- (NSURLRequest*) request__
{
    NSURLRequest* re$ult = [self request];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) WKFrameInfo *sourceFrame;
- (WKFrameInfo*) sourceFrame__
{
    WKFrameInfo* re$ult = [self sourceFrame];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nullable, nonatomic, readonly, copy) WKFrameInfo *targetFrame;
- (WKFrameInfo*) targetFrame__
{
    WKFrameInfo* re$ult = [self targetFrame];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
