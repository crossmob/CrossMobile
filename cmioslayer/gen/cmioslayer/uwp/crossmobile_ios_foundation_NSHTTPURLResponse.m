// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSHTTPURLResponse implementation

#import "crossmobile_ios_foundation_NSHTTPURLResponse.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSHTTPURLResponse$Ext

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

// (NSHTTPURLResponse) @property(readonly, copy) NSDictionary *allHeaderFields;
- (NSDictionary*) allHeaderFields__
{
    NSDictionary* re$ult = [super allHeaderFields];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLResponse) @property(readonly) long long expectedContentLength;
- (JAVA_LONG) expectedContentLength__
{
    return [super expectedContentLength];
}

// (NSHTTPURLResponse) @property(readonly) NSInteger statusCode;
- (int) statusCode__
{
    return [super statusCode];
}

// (NSURLResponse) @property(readonly, copy) NSString *textEncodingName;
- (NSString*) textEncodingName__
{
    NSString* re$ult = [super textEncodingName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
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

@implementation NSHTTPURLResponse (cm_crossmobile_ios_foundation_NSHTTPURLResponse)

// direct binding of: + (NSString *)localizedStringForStatusCode:(NSInteger)statusCode;
+ (NSString*) localizedStringForStatusCode___int:(int) statusCode 
{
    NSString* re$ult = [NSHTTPURLResponse localizedStringForStatusCode:statusCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithURL:(NSURL *)url statusCode:(NSInteger)statusCode HTTPVersion:(NSString *)HTTPVersion headerFields:(NSDictionary<NSString *,NSString *> *)headerFields;
- (instancetype) __init_crossmobile_ios_foundation_NSHTTPURLResponse___crossmobile_ios_foundation_NSURL_int_java_lang_String_java_util_Map:(NSURL*) url :(int) statusCode :(NSString*) HTTPVersion :(NSDictionary*) headerFields 
{
    return [self initWithURL:(url == JAVA_NULL ? nil : url) statusCode:statusCode HTTPVersion:(HTTPVersion == JAVA_NULL ? nil : HTTPVersion) headerFields:(headerFields == JAVA_NULL ? nil : headerFields)];
}

// direct binding of: @property(readonly, copy) NSDictionary *allHeaderFields;
- (NSDictionary*) allHeaderFields__
{
    NSDictionary* re$ult = [self allHeaderFields];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) NSInteger statusCode;
- (int) statusCode__
{
    return [self statusCode];
}

@end
