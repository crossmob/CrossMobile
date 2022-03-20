// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKUserScript definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_webkit_WKUserScript$Ext : WKUserScript
@end

#define crossmobile_ios_webkit_WKUserScript WKUserScript
@interface WKUserScript (cm_crossmobile_ios_webkit_WKUserScript)
- (instancetype) __init_crossmobile_ios_webkit_WKUserScript___java_lang_String_int_boolean:(NSString*) source :(int) injectionTime :(BOOL) forMainFrameOnly ;
- (BOOL) isForMainFrameOnly__;
- (int) injectionTime__;
- (NSString*) source__;
@end
