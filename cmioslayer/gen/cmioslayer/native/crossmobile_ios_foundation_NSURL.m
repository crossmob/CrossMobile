// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURL implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURL$Ext

@end

@implementation NSURL (cm_crossmobile_ios_foundation_NSURL)

// + (instancetype)URLWithString:(NSString *)URLString;
+ (instancetype) URLWithString___java_lang_String:(NSString*) URLString 
{
    id re$ult = [NSURL URLWithString:(URLString == JAVA_NULL ? nil : URLString)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSURL *)fileURLWithPath:(NSString *)path;
+ (NSURL*) fileURLWithPath___java_lang_String:(NSString*) path 
{
    NSURL* re$ult = [NSURL fileURLWithPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSString *absoluteString;
- (NSString*) absoluteString__
{
    NSString* re$ult = [self absoluteString];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
