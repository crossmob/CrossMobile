// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSMutableURLRequest implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSMutableURLRequest.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSMutableURLRequest$Ext

// (NSMutableURLRequest) @property(copy) NSData *HTTPBody;
- (void) setHTTPBody___crossmobile_ios_foundation_NSData:(NSData*) HTTPBody 
{
    [super setHTTPBody:(HTTPBody == JAVA_NULL ? nil : HTTPBody)];
}

// (NSMutableURLRequest) @property(copy) NSData *HTTPBody;
- (NSData*) HTTPBody__
{
    NSData* re$ult = [super HTTPBody];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSMutableURLRequest) @property(copy) NSString *HTTPMethod;
- (void) setHTTPMethod___java_lang_String:(NSString*) HTTPMethod 
{
    [super setHTTPMethod:(HTTPMethod == JAVA_NULL ? nil : HTTPMethod)];
}

// (NSMutableURLRequest) @property BOOL HTTPShouldHandleCookies;
- (void) setHTTPShouldHandleCookies___boolean:(BOOL) HTTPShouldHandleCookies 
{
    [super setHTTPShouldHandleCookies:HTTPShouldHandleCookies];
}

// (NSURLRequest) @property(readonly) BOOL HTTPShouldHandleCookies;
- (BOOL) HTTPShouldHandleCookies__
{
    return [super HTTPShouldHandleCookies];
}

// (NSMutableURLRequest) @property(copy) NSURL *URL;
- (void) setURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    [super setURL:(URL == JAVA_NULL ? nil : URL)];
}

// (NSURLRequest) @property(readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [super URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSMutableURLRequest) @property(copy) NSDictionary <NSString *,NSString *> *allHTTPHeaderFields;
- (NSDictionary*) allHTTPHeaderFields__
{
    NSDictionary* re$ult = [super allHTTPHeaderFields];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLRequest) @property(readonly) NSURLRequestCachePolicy cachePolicy;
- (int) cachePolicy__
{
    return [super cachePolicy];
}

// (NSMutableURLRequest) @property NSTimeInterval timeoutInterval;
- (void) setTimeoutInterval___double:(double) timeoutInterval 
{
    [super setTimeoutInterval:timeoutInterval];
}

// (NSURLRequest) @property(readonly) NSTimeInterval timeoutInterval;
- (double) timeoutInterval__
{
    return [super timeoutInterval];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSMutableURLRequest) - (void)addValue:(NSString *)value forHTTPHeaderField:(NSString *)field;
- (void) addValue___java_lang_String_java_lang_String:(NSString*) value :(NSString*) field 
{
    [super addValue:(value == JAVA_NULL ? nil : value) forHTTPHeaderField:(field == JAVA_NULL ? nil : field)];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation NSMutableURLRequest (cm_crossmobile_ios_foundation_NSMutableURLRequest)

// direct binding of: + (instancetype)requestWithURL:(NSURL *)theURL;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL:(NSURL*) theURL 
{
    id re$ult = [NSMutableURLRequest requestWithURL:(theURL == JAVA_NULL ? nil : theURL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)requestWithURL:(NSURL *)theURL cachePolicy:(NSURLRequestCachePolicy)cachePolicy timeoutInterval:(NSTimeInterval)timeoutInterval;
+ (instancetype) requestWithURL___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) theURL :(int) cachePolicy :(double) timeoutInterval 
{
    id re$ult = [NSMutableURLRequest requestWithURL:(theURL == JAVA_NULL ? nil : theURL) cachePolicy:cachePolicy timeoutInterval:timeoutInterval];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithURL:(NSURL *)URL;
- (instancetype) __init_crossmobile_ios_foundation_NSMutableURLRequest___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL)];
}

// direct binding of: - (instancetype)initWithURL:(NSURL *)URL cachePolicy:(NSURLRequestCachePolicy)cachePolicy timeoutInterval:(NSTimeInterval)timeoutInterval;
- (instancetype) __init_crossmobile_ios_foundation_NSMutableURLRequest___crossmobile_ios_foundation_NSURL_int_double:(NSURL*) URL :(int) cachePolicy :(double) timeoutInterval 
{
    return [self initWithURL:(URL == JAVA_NULL ? nil : URL) cachePolicy:cachePolicy timeoutInterval:timeoutInterval];
}

// direct binding of: @property(copy) NSData *HTTPBody;
- (void) setHTTPBody___crossmobile_ios_foundation_NSData:(NSData*) HTTPBody 
{
    [self setHTTPBody:(HTTPBody == JAVA_NULL ? nil : HTTPBody)];
}

// direct binding of: @property(copy) NSData *HTTPBody;
- (NSData*) HTTPBody__
{
    NSData* re$ult = [self HTTPBody];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy) NSString *HTTPMethod;
- (void) setHTTPMethod___java_lang_String:(NSString*) HTTPMethod 
{
    [self setHTTPMethod:(HTTPMethod == JAVA_NULL ? nil : HTTPMethod)];
}

// direct binding of: @property BOOL HTTPShouldHandleCookies;
- (void) setHTTPShouldHandleCookies___boolean:(BOOL) HTTPShouldHandleCookies 
{
    [self setHTTPShouldHandleCookies:HTTPShouldHandleCookies];
}

// direct binding of: @property(copy) NSURL *URL;
- (void) setURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    [self setURL:(URL == JAVA_NULL ? nil : URL)];
}

// direct binding of: @property(copy) NSDictionary <NSString *,NSString *> *allHTTPHeaderFields;
- (NSDictionary*) allHTTPHeaderFields__
{
    NSDictionary* re$ult = [self allHTTPHeaderFields];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property NSTimeInterval timeoutInterval;
- (void) setTimeoutInterval___double:(double) timeoutInterval 
{
    [self setTimeoutInterval:timeoutInterval];
}

// direct binding of: - (void)addValue:(NSString *)value forHTTPHeaderField:(NSString *)field;
- (void) addValue___java_lang_String_java_lang_String:(NSString*) value :(NSString*) field 
{
    [self addValue:(value == JAVA_NULL ? nil : value) forHTTPHeaderField:(field == JAVA_NULL ? nil : field)];
}

@end
