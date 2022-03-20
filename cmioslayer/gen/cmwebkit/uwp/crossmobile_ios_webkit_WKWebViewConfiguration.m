// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKWebViewConfiguration implementation

#import "crossmobile_ios_webkit_WKPreferences.h"
#import "crossmobile_ios_webkit_WKUserContentController.h"
#import "crossmobile_ios_webkit_WKWebViewConfiguration.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_webkit_WKWebViewConfiguration$Ext

@end

@implementation WKWebViewConfiguration (cm_crossmobile_ios_webkit_WKWebViewConfiguration)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_webkit_WKWebViewConfiguration__
{
    return [self init];
}

// @property(nullable, nonatomic, copy) NSString *applicationNameForUserAgent;
- (void) setApplicationNameForUserAgent___java_lang_String:(NSString*) applicationNameForUserAgent 
{
    [self setApplicationNameForUserAgent:(applicationNameForUserAgent == JAVA_NULL ? nil : applicationNameForUserAgent)];
}

// @property(nullable, nonatomic, copy) NSString *applicationNameForUserAgent;
- (NSString*) applicationNameForUserAgent__
{
    NSString* re$ult = [self applicationNameForUserAgent];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) WKPreferences *preferences;
- (void) setPreferences___crossmobile_ios_webkit_WKPreferences:(WKPreferences*) preferences 
{
    [self setPreferences:(preferences == JAVA_NULL ? nil : preferences)];
}

// @property(nonatomic, strong) WKPreferences *preferences;
- (WKPreferences*) preferences__
{
    WKPreferences* re$ult = [self preferences];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) WKUserContentController *userContentController;
- (void) setUserContentController___crossmobile_ios_webkit_WKUserContentController:(WKUserContentController*) userContentController 
{
    [self setUserContentController:(userContentController == JAVA_NULL ? nil : userContentController)];
}

// @property(nonatomic, strong) WKUserContentController *userContentController;
- (WKUserContentController*) userContentController__
{
    WKUserContentController* re$ult = [self userContentController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
