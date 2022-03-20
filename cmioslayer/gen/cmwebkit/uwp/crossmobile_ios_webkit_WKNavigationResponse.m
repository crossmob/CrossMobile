// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKNavigationResponse implementation

#import "crossmobile_ios_foundation_NSURLResponse.h"
#import "crossmobile_ios_webkit_WKNavigationResponse.h"

@implementation crossmobile_ios_webkit_WKNavigationResponse$Ext

@end

@implementation WKNavigationResponse (cm_crossmobile_ios_webkit_WKNavigationResponse)

// @property(nonatomic, readonly) BOOL canShowMIMEType;
- (BOOL) canShowMIMEType__
{
    return [self canShowMIMEType];
}

// @property(nonatomic, readonly, getter=isForMainFrame) BOOL forMainFrame;
- (BOOL) isForMainFrame__
{
    return [self isForMainFrame];
}

// @property(nonatomic, readonly, copy) NSURLResponse *response;
- (NSURLResponse*) response__
{
    NSURLResponse* re$ult = [self response];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
