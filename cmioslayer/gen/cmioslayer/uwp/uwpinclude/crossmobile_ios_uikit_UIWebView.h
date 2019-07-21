// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIWebView definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_foundation_NSURLRequest;
@class crossmobile_ios_uikit_UIScrollView;
@class crossmobile_ios_uikit_UIWebViewAppearance;
@protocol crossmobile_ios_uikit_UIWebViewDelegate;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIWebView$Ext : UIWebView
@end

#define crossmobile_ios_uikit_UIWebView UIWebView
@interface UIWebView (cm_crossmobile_ios_uikit_UIWebView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIWebView__;
- (instancetype) __init_crossmobile_ios_uikit_UIWebView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (BOOL) canGoBack__;
- (BOOL) canGoForward__;
- (void) setDataDetectorTypes___long:(JAVA_LONG) dataDetectorTypes ;
- (JAVA_LONG) dataDetectorTypes__;
- (void) setDelegate___crossmobile_ios_uikit_UIWebViewDelegate:(id<UIWebViewDelegate>) delegate ;
- (id<UIWebViewDelegate>) delegate__;
- (BOOL) isLoading__;
- (void) setMediaPlaybackRequiresUserAction___boolean:(BOOL) mediaPlaybackRequiresUserAction ;
- (BOOL) mediaPlaybackRequiresUserAction__;
- (void) setScalesPageToFit___boolean:(BOOL) scalesPageToFit ;
- (BOOL) scalesPageToFit__;
- (UIScrollView*) scrollView__;
- (void) goBack__;
- (void) goForward__;
- (void) loadData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String_crossmobile_ios_foundation_NSURL:(NSData*) data :(NSString*) MIMEType :(NSString*) textEncodingName :(NSURL*) baseURL ;
- (void) loadHTMLString___java_lang_String_crossmobile_ios_foundation_NSURL:(NSString*) string :(NSURL*) baseURL ;
- (void) loadRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request ;
- (void) reload__;
- (NSString*) stringByEvaluatingJavaScriptFromString___java_lang_String:(NSString*) script ;
@end
