// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_webkit_WKNavigationResponse definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_foundation_NSURLResponse;

CM_EXPORT_CLASS
@interface crossmobile_ios_webkit_WKNavigationResponse$Ext : WKNavigationResponse
@end

#define crossmobile_ios_webkit_WKNavigationResponse WKNavigationResponse
@interface WKNavigationResponse (cm_crossmobile_ios_webkit_WKNavigationResponse)
- (BOOL) canShowMIMEType__;
- (BOOL) isForMainFrame__;
- (NSURLResponse*) response__;
@end
