// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKWebView implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_ios_uikit_UIScrollView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "crossmobile_ios_webkit_WKNavigation.h"
#import "crossmobile_ios_webkit_WKNavigationDelegate.h"
#import "crossmobile_ios_webkit_WKWebView.h"
#import "crossmobile_ios_webkit_WKWebViewConfiguration.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "org_robovm_objc_block_VoidBlock2.h"

@implementation crossmobile_ios_webkit_WKWebView$Ext

@end

@implementation WKWebView (cm_crossmobile_ios_webkit_WKWebView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[WKWebView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[WKWebView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_webkit_WKWebView__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_webkit_WKWebView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// - (instancetype)initWithFrame:(CGRect)frame configuration:(WKWebViewConfiguration *)configuration;
- (instancetype) __init_crossmobile_ios_webkit_WKWebView___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_webkit_WKWebViewConfiguration:(crossmobile_ios_coregraphics_CGRect*) frame :(WKWebViewConfiguration*) configuration 
{
    return [self initWithFrame:[frame getCGRect] configuration:(configuration == JAVA_NULL ? nil : configuration)];
}

// @property(nullable, nonatomic, readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [self URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL allowsBackForwardNavigationGestures;
- (BOOL) allowsBackForwardNavigationGestures__
{
    return [self allowsBackForwardNavigationGestures];
}

// @property(nonatomic) BOOL allowsLinkPreview;
- (BOOL) allowsLinkPreview__
{
    return [self allowsLinkPreview];
}

// @property(nonatomic, readonly) BOOL canGoBack;
- (BOOL) canGoBack__
{
    return [self canGoBack];
}

// @property(nonatomic, readonly) BOOL canGoForward;
- (BOOL) canGoForward__
{
    return [self canGoForward];
}

// @property(nonatomic, readonly, copy) WKWebViewConfiguration *configuration;
- (WKWebViewConfiguration*) configuration__
{
    WKWebViewConfiguration* re$ult = [self configuration];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nullable, nonatomic, copy) NSString *customUserAgent;
- (NSString*) customUserAgent__
{
    NSString* re$ult = [self customUserAgent];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) double estimatedProgress;
- (double) estimatedProgress__
{
    return [self estimatedProgress];
}

// @property(nonatomic, readonly) BOOL hasOnlySecureContent;
- (BOOL) hasOnlySecureContent__
{
    return [self hasOnlySecureContent];
}

// @property(nonatomic, readonly, getter=isLoading) BOOL loading;
- (BOOL) isLoading__
{
    return [self isLoading];
}

// @property(nullable, nonatomic, weak) id<WKNavigationDelegate> navigationDelegate;
- (void) setNavigationDelegate___crossmobile_ios_webkit_WKNavigationDelegate:(id<WKNavigationDelegate>) navigationDelegate 
{
    objc_setAssociatedObject(self, @selector(setNavigationDelegate:), navigationDelegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setNavigationDelegate:(navigationDelegate == JAVA_NULL ? nil : navigationDelegate)];
}

// @property(nullable, nonatomic, weak) id<WKNavigationDelegate> navigationDelegate;
- (id<WKNavigationDelegate>) navigationDelegate__
{
    id<WKNavigationDelegate> re$ult = [self navigationDelegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UIScrollView *scrollView;
- (UIScrollView*) scrollView__
{
    UIScrollView* re$ult = [self scrollView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nullable, nonatomic, readonly, copy) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)evaluateJavaScript:(NSString *)javaScriptString completionHandler:(void (^)(id, NSError *error))completionHandler;
- (void) evaluateJavaScript___java_lang_String_org_robovm_objc_block_VoidBlock2:(NSString*) javaScriptString :(id<org_robovm_objc_block_VoidBlock2>) completionHandler 
{
    [self evaluateJavaScript:(javaScriptString == JAVA_NULL ? nil : javaScriptString) completionHandler:(completionHandler == JAVA_NULL ? nil : ^(id _unnamed_parameter_0, NSError* error) {
        [completionHandler invoke___java_lang_Object_java_lang_Object:(_unnamed_parameter_0 ? _unnamed_parameter_0 : JAVA_NULL) :(error ? error : JAVA_NULL)];
    })];
}

// - (WKNavigation *)goBack;
- (WKNavigation*) goBack__
{
    WKNavigation* re$ult = [self goBack];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (WKNavigation *)goForward;
- (WKNavigation*) goForward__
{
    WKNavigation* re$ult = [self goForward];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (WKNavigation *)loadData:(NSData *)data MIMEType:(NSString *)MIMEType characterEncodingName:(NSString *)characterEncodingName baseURL:(NSURL *)baseURL;
- (WKNavigation*) loadData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String_crossmobile_ios_foundation_NSURL:(NSData*) data :(NSString*) MIMEType :(NSString*) characterEncodingName :(NSURL*) baseURL 
{
    WKNavigation* re$ult = [self loadData:(data == JAVA_NULL ? nil : data) MIMEType:(MIMEType == JAVA_NULL ? nil : MIMEType) characterEncodingName:(characterEncodingName == JAVA_NULL ? nil : characterEncodingName) baseURL:(baseURL == JAVA_NULL ? nil : baseURL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (WKNavigation *)loadFileURL:(NSURL *)URL allowingReadAccessToURL:(NSURL *)readAccessURL;
- (WKNavigation*) loadFileURL___crossmobile_ios_foundation_NSURL_crossmobile_ios_foundation_NSURL:(NSURL*) URL :(NSURL*) readAccessURL 
{
    WKNavigation* re$ult = [self loadFileURL:(URL == JAVA_NULL ? nil : URL) allowingReadAccessToURL:(readAccessURL == JAVA_NULL ? nil : readAccessURL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (WKNavigation *)loadHTMLString:(NSString *)string baseURL:(NSURL *)baseURL;
- (WKNavigation*) loadHTMLString___java_lang_String_crossmobile_ios_foundation_NSURL:(NSString*) string :(NSURL*) baseURL 
{
    WKNavigation* re$ult = [self loadHTMLString:(string == JAVA_NULL ? nil : string) baseURL:(baseURL == JAVA_NULL ? nil : baseURL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (WKNavigation *)loadRequest:(NSURLRequest *)request;
- (WKNavigation*) loadRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request 
{
    WKNavigation* re$ult = [self loadRequest:(request == JAVA_NULL ? nil : request)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (WKNavigation *)reload;
- (WKNavigation*) reload__
{
    WKNavigation* re$ult = [self reload];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
