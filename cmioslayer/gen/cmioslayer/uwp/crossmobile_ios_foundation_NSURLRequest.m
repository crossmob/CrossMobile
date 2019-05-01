// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSURLRequest implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURLRequest$Ext

// (NSURLRequest) @property(readonly) BOOL HTTPShouldHandleCookies;
- (BOOL) HTTPShouldHandleCookies__
{
    return [super HTTPShouldHandleCookies];
}

// (NSURLRequest) @property(readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [super URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLRequest) @property(readonly) NSURLRequestCachePolicy cachePolicy;
- (int) cachePolicy__
{
    return [super cachePolicy];
}

// (NSURLRequest) @property(readonly) NSTimeInterval timeoutInterval;
- (double) timeoutInterval__
{
    return [super timeoutInterval];
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

@implementation NSURLRequest (cm_crossmobile_ios_foundation_NSURLRequest)

// direct binding of: + (instancetype)requestWithURL:(NSURL *)URL;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    id re$ult = [NSURLRequest requestWithURL:(URL == JAVA_NULL ? nil : URL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)requestWithURL:(NSURL *)URL cachePolicy:(NSURLRequestCachePolicy)cachePolicy timeoutInterval:(NSTimeInterval)timeoutInterval;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) URL :(int) cachePolicy :(double) timeoutInterval 
{
    id re$ult = [NSURLRequest requestWithURL:(URL == JAVA_NULL ? nil : URL) cachePolicy:cachePolicy timeoutInterval:timeoutInterval];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithURL:(NSURL *)URL;
- (instancetype) __init_crossmobile_ios_foundation_NSURLRequest___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL)];
}

// direct binding of: - (instancetype)initWithURL:(NSURL *)URL cachePolicy:(NSURLRequestCachePolicy)cachePolicy timeoutInterval:(NSTimeInterval)timeoutInterval;
- (instancetype) __init_crossmobile_ios_foundation_NSURLRequest___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) URL :(int) cachePolicy :(double) timeoutInterval 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL) cachePolicy:cachePolicy timeoutInterval:timeoutInterval];
}

// direct binding of: @property(readonly) BOOL HTTPShouldHandleCookies;
- (BOOL) HTTPShouldHandleCookies__
{
    return [self HTTPShouldHandleCookies];
}

// direct binding of: @property(readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [self URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) NSURLRequestCachePolicy cachePolicy;
- (int) cachePolicy__
{
    return [self cachePolicy];
}

// direct binding of: @property(readonly) NSTimeInterval timeoutInterval;
- (double) timeoutInterval__
{
    return [self timeoutInterval];
}

@end
