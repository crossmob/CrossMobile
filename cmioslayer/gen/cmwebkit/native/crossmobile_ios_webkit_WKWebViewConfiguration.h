// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKWebViewConfiguration definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_webkit_WKPreferences;
@class crossmobile_ios_webkit_WKUserContentController;
@class java_lang_String;

@interface crossmobile_ios_webkit_WKWebViewConfiguration$Ext : WKWebViewConfiguration
@end

#define crossmobile_ios_webkit_WKWebViewConfiguration WKWebViewConfiguration
@interface WKWebViewConfiguration (cm_crossmobile_ios_webkit_WKWebViewConfiguration)
- (instancetype) __init_crossmobile_ios_webkit_WKWebViewConfiguration__;
- (void) setApplicationNameForUserAgent___java_lang_String:(NSString*) applicationNameForUserAgent ;
- (NSString*) applicationNameForUserAgent__;
- (void) setPreferences___crossmobile_ios_webkit_WKPreferences:(WKPreferences*) preferences ;
- (WKPreferences*) preferences__;
- (void) setUserContentController___crossmobile_ios_webkit_WKUserContentController:(WKUserContentController*) userContentController ;
- (WKUserContentController*) userContentController__;
@end
