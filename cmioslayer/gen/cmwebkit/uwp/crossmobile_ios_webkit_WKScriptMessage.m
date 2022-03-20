// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKScriptMessage implementation

#import "crossmobile_ios_webkit_WKFrameInfo.h"
#import "crossmobile_ios_webkit_WKScriptMessage.h"
#import "crossmobile_ios_webkit_WKWebView.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_webkit_WKScriptMessage$Ext

@end

@implementation WKScriptMessage (cm_crossmobile_ios_webkit_WKScriptMessage)

// @property(nonatomic, readonly, copy) id body;
- (id) body__
{
    id re$ult = [self body];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) WKFrameInfo *frameInfo;
- (WKFrameInfo*) frameInfo__
{
    WKFrameInfo* re$ult = [self frameInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nullable, nonatomic, readonly, weak) WKWebView *webView;
- (WKWebView*) webView__
{
    WKWebView* re$ult = [self webView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
