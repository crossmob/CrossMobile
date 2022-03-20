// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKUserContentController implementation

#import "crossmobile_ios_webkit_WKScriptMessageHandler.h"
#import "crossmobile_ios_webkit_WKUserContentController.h"
#import "crossmobile_ios_webkit_WKUserScript.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_webkit_WKUserContentController$Ext

@end

@implementation WKUserContentController (cm_crossmobile_ios_webkit_WKUserContentController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_webkit_WKUserContentController__
{
    return [self init];
}

// - (void)addScriptMessageHandler:(id<WKScriptMessageHandler>)scriptMessageHandler name:(NSString *)name;
- (void) addScriptMessageHandler___crossmobile_ios_webkit_WKScriptMessageHandler_java_lang_String:(id<WKScriptMessageHandler>) scriptMessageHandler :(NSString*) name 
{
    [self addScriptMessageHandler:(scriptMessageHandler == JAVA_NULL ? nil : scriptMessageHandler) name:(name == JAVA_NULL ? nil : name)];
}

// - (void)addUserScript:(WKUserScript *)userScript;
- (void) addUserScript___crossmobile_ios_webkit_WKUserScript:(WKUserScript*) userScript 
{
    [self addUserScript:(userScript == JAVA_NULL ? nil : userScript)];
}

// - (void)removeAllScriptMessageHandlers;
- (void) removeAllScriptMessageHandlers__
{
    [self removeAllScriptMessageHandlers];
}

// - (void)removeAllUserScripts;
- (void) removeAllUserScripts__
{
    [self removeAllUserScripts];
}

// - (void)removeScriptMessageHandlerForName:(NSString *)name;
- (void) removeScriptMessageHandlerForName___java_lang_String:(NSString*) name 
{
    [self removeScriptMessageHandlerForName:(name == JAVA_NULL ? nil : name)];
}

@end
