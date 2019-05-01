// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSURLResponse implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_foundation_NSURLResponse.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURLResponse$Ext

// (NSURLResponse) @property(readonly, copy) NSString *MIMEType;
- (NSString*) MIMEType__
{
    NSString* re$ult = [super MIMEType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLResponse) @property(readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [super URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLResponse) @property(readonly) long long expectedContentLength;
- (JAVA_LONG) expectedContentLength__
{
    return [super expectedContentLength];
}

// (NSURLResponse) @property(readonly, copy) NSString *textEncodingName;
- (NSString*) textEncodingName__
{
    NSString* re$ult = [super textEncodingName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation NSURLResponse (cm_crossmobile_ios_foundation_NSURLResponse)

// direct binding of: - (instancetype)initWithURL:(NSURL *)URL MIMEType:(NSString *)MIMEType expectedContentLength:(NSInteger)length textEncodingName:(NSString *)name;
- (instancetype) __init_crossmobile_ios_foundation_NSURLResponse___crossmobile_ios_foundation_NSURL_java_lang_String_int_java_lang_String:(NSURL*) URL :(NSString*) MIMEType :(int) length :(NSString*) name 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL) MIMEType:(MIMEType == JAVA_NULL ? nil : MIMEType) expectedContentLength:length textEncodingName:(name == JAVA_NULL ? nil : name)];
}

// direct binding of: @property(readonly, copy) NSString *MIMEType;
- (NSString*) MIMEType__
{
    NSString* re$ult = [self MIMEType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [self URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) long long expectedContentLength;
- (JAVA_LONG) expectedContentLength__
{
    return [self expectedContentLength];
}

// direct binding of: @property(readonly, copy) NSString *textEncodingName;
- (NSString*) textEncodingName__
{
    NSString* re$ult = [self textEncodingName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
