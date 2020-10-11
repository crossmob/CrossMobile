// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_webkit_WKScriptMessage definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_webkit_WKFrameInfo;
@class crossmobile_ios_webkit_WKWebView;
@class java_lang_Object;
@class java_lang_String;

@interface crossmobile_ios_webkit_WKScriptMessage$Ext : WKScriptMessage
@end

#define crossmobile_ios_webkit_WKScriptMessage WKScriptMessage
@interface WKScriptMessage (cm_crossmobile_ios_webkit_WKScriptMessage)
- (id) body__;
- (WKFrameInfo*) frameInfo__;
- (NSString*) name__;
- (WKWebView*) webView__;
@end