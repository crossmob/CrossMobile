// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_webkit_WKUserContentController definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@protocol crossmobile_ios_webkit_WKScriptMessageHandler;
@class crossmobile_ios_webkit_WKUserScript;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_webkit_WKUserContentController$Ext : WKUserContentController
@end

#define crossmobile_ios_webkit_WKUserContentController WKUserContentController
@interface WKUserContentController (cm_crossmobile_ios_webkit_WKUserContentController)
- (instancetype) __init_crossmobile_ios_webkit_WKUserContentController__;
- (void) addScriptMessageHandler___crossmobile_ios_webkit_WKScriptMessageHandler_java_lang_String:(id<WKScriptMessageHandler>) scriptMessageHandler :(NSString*) name ;
- (void) addUserScript___crossmobile_ios_webkit_WKUserScript:(WKUserScript*) userScript ;
- (void) removeAllScriptMessageHandlers__;
- (void) removeAllUserScripts__;
- (void) removeScriptMessageHandlerForName___java_lang_String:(NSString*) name ;
@end
