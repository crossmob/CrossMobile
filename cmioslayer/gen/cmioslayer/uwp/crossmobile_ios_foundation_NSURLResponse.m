// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLResponse implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_foundation_NSURLResponse.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURLResponse$Ext

@end

@implementation NSURLResponse (cm_crossmobile_ios_foundation_NSURLResponse)

// - (instancetype)initWithURL:(NSURL *)URL MIMEType:(NSString *)MIMEType expectedContentLength:(NSInteger)length textEncodingName:(NSString *)name;
- (instancetype) __init_crossmobile_ios_foundation_NSURLResponse___crossmobile_ios_foundation_NSURL_java_lang_String_int_java_lang_String:(NSURL*) URL :(NSString*) MIMEType :(int) length :(NSString*) name 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL) MIMEType:(MIMEType == JAVA_NULL ? nil : MIMEType) expectedContentLength:length textEncodingName:(name == JAVA_NULL ? nil : name)];
}

// @property(readonly, copy) NSString *MIMEType;
- (NSString*) MIMEType__
{
    NSString* re$ult = [self MIMEType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [self URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) long long expectedContentLength;
- (JAVA_LONG) expectedContentLength__
{
    return [self expectedContentLength];
}

// @property(readonly, copy) NSString *textEncodingName;
- (NSString*) textEncodingName__
{
    NSString* re$ult = [self textEncodingName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
