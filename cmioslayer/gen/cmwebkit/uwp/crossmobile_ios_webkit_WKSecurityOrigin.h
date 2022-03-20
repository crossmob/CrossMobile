// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKSecurityOrigin definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class java_lang_String;

@interface crossmobile_ios_webkit_WKSecurityOrigin$Ext : WKSecurityOrigin
@end

#define crossmobile_ios_webkit_WKSecurityOrigin WKSecurityOrigin
@interface WKSecurityOrigin (cm_crossmobile_ios_webkit_WKSecurityOrigin)
- (NSString*) host__;
- (int) port__;
- (NSString*) protocol__;
@end
