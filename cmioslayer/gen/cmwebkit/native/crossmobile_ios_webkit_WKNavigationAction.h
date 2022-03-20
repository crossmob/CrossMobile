// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKNavigationAction definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_foundation_NSURLRequest;
@class crossmobile_ios_webkit_WKFrameInfo;

@interface crossmobile_ios_webkit_WKNavigationAction$Ext : WKNavigationAction
@end

#define crossmobile_ios_webkit_WKNavigationAction WKNavigationAction
@interface WKNavigationAction (cm_crossmobile_ios_webkit_WKNavigationAction)
- (NSURLRequest*) request__;
- (WKFrameInfo*) sourceFrame__;
- (WKFrameInfo*) targetFrame__;
@end
