// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKScriptMessage definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_webkit_WKFrameInfo;
@class crossmobile_ios_webkit_WKWebView;
@class java_lang_Object;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_webkit_WKScriptMessage$Ext : WKScriptMessage
@end

#define crossmobile_ios_webkit_WKScriptMessage WKScriptMessage
@interface WKScriptMessage (cm_crossmobile_ios_webkit_WKScriptMessage)
- (id) body__;
- (WKFrameInfo*) frameInfo__;
- (NSString*) name__;
- (WKWebView*) webView__;
@end
