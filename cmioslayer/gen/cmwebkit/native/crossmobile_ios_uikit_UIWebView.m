// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UIWebView implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_ios_uikit_UIScrollView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "crossmobile_ios_uikit_UIWebView.h"
#import "crossmobile_ios_uikit_UIWebViewDelegate.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIWebView$Ext

@end

@implementation UIWebView (cm_crossmobile_ios_uikit_UIWebView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIWebView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIWebView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIWebView__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIWebView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, readonly, getter=canGoBack) BOOL canGoBack;
- (BOOL) canGoBack__
{
    return [self canGoBack];
}

// @property(nonatomic, readonly, getter=canGoForward) BOOL canGoForward;
- (BOOL) canGoForward__
{
    return [self canGoForward];
}

// @property(nonatomic) UIDataDetectorTypes dataDetectorTypes;
- (void) setDataDetectorTypes___long:(JAVA_LONG) dataDetectorTypes 
{
    [self setDataDetectorTypes:dataDetectorTypes];
}

// @property(nonatomic) UIDataDetectorTypes dataDetectorTypes;
- (JAVA_LONG) dataDetectorTypes__
{
    return [self dataDetectorTypes];
}

// @property(nonatomic, assign) id<UIWebViewDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIWebViewDelegate:(id<UIWebViewDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, assign) id<UIWebViewDelegate> delegate;
- (id<UIWebViewDelegate>) delegate__
{
    id<UIWebViewDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, getter=isLoading) BOOL loading;
- (BOOL) isLoading__
{
    return [self isLoading];
}

// @property(nonatomic) BOOL mediaPlaybackRequiresUserAction;
- (void) setMediaPlaybackRequiresUserAction___boolean:(BOOL) mediaPlaybackRequiresUserAction 
{
    [self setMediaPlaybackRequiresUserAction:mediaPlaybackRequiresUserAction];
}

// @property(nonatomic) BOOL mediaPlaybackRequiresUserAction;
- (BOOL) mediaPlaybackRequiresUserAction__
{
    return [self mediaPlaybackRequiresUserAction];
}

// @property(nonatomic) BOOL scalesPageToFit;
- (void) setScalesPageToFit___boolean:(BOOL) scalesPageToFit 
{
    [self setScalesPageToFit:scalesPageToFit];
}

// @property(nonatomic) BOOL scalesPageToFit;
- (BOOL) scalesPageToFit__
{
    return [self scalesPageToFit];
}

// @property(nonatomic, readonly, strong) UIScrollView *scrollView;
- (UIScrollView*) scrollView__
{
    UIScrollView* re$ult = [self scrollView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)goBack;
- (void) goBack__
{
    [self goBack];
}

// - (void)goForward;
- (void) goForward__
{
    [self goForward];
}

// - (void)loadData:(NSData *)data MIMEType:(NSString *)MIMEType textEncodingName:(NSString *)textEncodingName baseURL:(NSURL *)baseURL;
- (void) loadData___crossmobile_ios_foundation_NSData_java_lang_String_java_lang_String_crossmobile_ios_foundation_NSURL:(NSData*) data :(NSString*) MIMEType :(NSString*) textEncodingName :(NSURL*) baseURL 
{
    [self loadData:(data == JAVA_NULL ? nil : data) MIMEType:(MIMEType == JAVA_NULL ? nil : MIMEType) textEncodingName:(textEncodingName == JAVA_NULL ? nil : textEncodingName) baseURL:(baseURL == JAVA_NULL ? nil : baseURL)];
}

// - (void)loadHTMLString:(NSString *)string baseURL:(NSURL *)baseURL;
- (void) loadHTMLString___java_lang_String_crossmobile_ios_foundation_NSURL:(NSString*) string :(NSURL*) baseURL 
{
    [self loadHTMLString:(string == JAVA_NULL ? nil : string) baseURL:(baseURL == JAVA_NULL ? nil : baseURL)];
}

// - (void)loadRequest:(NSURLRequest *)request;
- (void) loadRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request 
{
    [self loadRequest:(request == JAVA_NULL ? nil : request)];
}

// - (void)reload;
- (void) reload__
{
    [self reload];
}

// - (NSString *)stringByEvaluatingJavaScriptFromString:(NSString *)script;
- (NSString*) stringByEvaluatingJavaScriptFromString___java_lang_String:(NSString*) script 
{
    NSString* re$ult = [self stringByEvaluatingJavaScriptFromString:(script == JAVA_NULL ? nil : script)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
