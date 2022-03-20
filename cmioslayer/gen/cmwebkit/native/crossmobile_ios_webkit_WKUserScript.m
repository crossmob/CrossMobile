// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKUserScript implementation

#import "crossmobile_ios_webkit_WKUserScript.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_webkit_WKUserScript$Ext

@end

@implementation WKUserScript (cm_crossmobile_ios_webkit_WKUserScript)

// - (instancetype)initWithSource:(NSString *)source injectionTime:(WKUserScriptInjectionTime)injectionTime forMainFrameOnly:(BOOL)forMainFrameOnly;
- (instancetype) __init_crossmobile_ios_webkit_WKUserScript___java_lang_String_int_boolean:(NSString*) source :(int) injectionTime :(BOOL) forMainFrameOnly 
{
    return [self initWithSource:(source == JAVA_NULL ? nil : source) injectionTime:injectionTime forMainFrameOnly:forMainFrameOnly];
}

// @property(nonatomic, readonly, getter=isForMainFrameOnly) BOOL forMainFrameOnly;
- (BOOL) isForMainFrameOnly__
{
    return [self isForMainFrameOnly];
}

// @property(nonatomic, readonly) WKUserScriptInjectionTime injectionTime;
- (int) injectionTime__
{
    return [self injectionTime];
}

// @property(nonatomic, readonly, copy) NSString *source;
- (NSString*) source__
{
    NSString* re$ult = [self source];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
