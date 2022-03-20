// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKWebView definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_foundation_NSURLRequest;
@class crossmobile_ios_uikit_UIScrollView;
@class crossmobile_ios_uikit_UIViewAppearance;
@class crossmobile_ios_webkit_WKNavigation;
@protocol crossmobile_ios_webkit_WKNavigationDelegate;
@class crossmobile_ios_webkit_WKWebViewConfiguration;
@class java_lang_Object;
@class java_lang_String;
@protocol java_util_List;
@protocol org_robovm_objc_block_VoidBlock2;

CM_EXPORT_CLASS
@interface crossmobile_ios_webkit_WKWebView$Ext : WKWebView
@end

#define crossmobile_ios_webkit_WKWebView WKWebView
@interface WKWebView (cm_crossmobile_ios_webkit_WKWebView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_webkit_WKWebView__;
- (instancetype) __init_crossmobile_ios_webkit_WKWebView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (instancetype) __init_crossmobile_ios_webkit_WKWebView___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_webkit_WKWebViewConfiguration:(crossmobile_ios_coregraphics_CGRect*) frame :(WKWebViewConfiguration*) configuration ;
- (NSURL*) URL__;
- (BOOL) allowsBackForwardNavigationGestures__;
- (BOOL) allowsLinkPreview__;
- (BOOL) canGoBack__;
- (BOOL) canGoForward__;
- (WKWebViewConfiguration*) configuration__;
- (NSString*) customUserAgent__;
- (double) estimatedProgress__;
- (BOOL) hasOnlySecureContent__;
- (BOOL) isLoading__;
- (void) setNavigationDelegate___crossmobile_ios_webkit_WKNavigationDelegate:(id<WKNavigationDelegate>) navigationDelegate ;
- (id<WKNavigationDelegate>) navigationDelegate__;
- (UIScrollView*) scrollView__;
- (NSString*) title__;
- (void) evaluateJavaScript___java_lang_String_org_robovm_objc_block_VoidBlock2:(NSString*) javaScriptString :(id<org_robovm_objc_block_VoidBlock2>) completionHandler ;
- (WKNavigation*) goBack__;
- (WKNavigation*) goForward__;
- (WKNavigation*) loadData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String_crossmobile_ios_foundation_NSURL:(NSData*) data :(NSString*) MIMEType :(NSString*) characterEncodingName :(NSURL*) baseURL ;
- (WKNavigation*) loadFileURL___crossmobile_ios_foundation_NSURL_crossmobile_ios_foundation_NSURL:(NSURL*) URL :(NSURL*) readAccessURL ;
- (WKNavigation*) loadHTMLString___java_lang_String_crossmobile_ios_foundation_NSURL:(NSString*) string :(NSURL*) baseURL ;
- (WKNavigation*) loadRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request ;
- (WKNavigation*) reload__;
@end
