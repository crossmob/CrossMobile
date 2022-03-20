// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKSecurityOrigin implementation

#import "crossmobile_ios_webkit_WKSecurityOrigin.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_webkit_WKSecurityOrigin$Ext

@end

@implementation WKSecurityOrigin (cm_crossmobile_ios_webkit_WKSecurityOrigin)

// @property(nonatomic, readonly, copy) NSString *host;
- (NSString*) host__
{
    NSString* re$ult = [self host];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSInteger port;
- (int) port__
{
    return [self port];
}

// @property(nonatomic, readonly, copy) NSString *protocol;
- (NSString*) protocol__
{
    NSString* re$ult = [self protocol];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
