// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSHTTPCookieStorage implementation

#import "crossmobile_ios_foundation_NSHTTPCookie.h"
#import "crossmobile_ios_foundation_NSHTTPCookieStorage.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSHTTPCookieStorage$Ext

// (NSHTTPCookieStorage) @property NSHTTPCookieAcceptPolicy cookieAcceptPolicy;
- (void) setCookieAcceptPolicy___int:(int) cookieAcceptPolicy 
{
    [super setCookieAcceptPolicy:cookieAcceptPolicy];
}

// (NSHTTPCookieStorage) @property NSHTTPCookieAcceptPolicy cookieAcceptPolicy;
- (int) cookieAcceptPolicy__
{
    return [super cookieAcceptPolicy];
}

// (NSHTTPCookieStorage) @property(readonly, copy) NSArray<NSHTTPCookie *> *cookies;
- (NSArray*) cookies__
{
    NSArray* re$ult = [super cookies];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSHTTPCookieStorage) - (NSArray<NSHTTPCookie *> *)cookiesForURL:(NSURL *)URL;
- (NSArray*) cookiesForURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    NSArray* re$ult = [super cookiesForURL:(URL == JAVA_NULL ? nil : URL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSHTTPCookieStorage) - (void)deleteCookie:(NSHTTPCookie *)cookie;
- (void) deleteCookie___crossmobile_ios_foundation_NSHTTPCookie:(NSHTTPCookie*) cookie 
{
    [super deleteCookie:(cookie == JAVA_NULL ? nil : cookie)];
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

// (NSHTTPCookieStorage) - (void)setCookie:(NSHTTPCookie *)cookie;
- (void) setCookie___crossmobile_ios_foundation_NSHTTPCookie:(NSHTTPCookie*) cookie 
{
    [super setCookie:(cookie == JAVA_NULL ? nil : cookie)];
}

// (NSHTTPCookieStorage) - (void)setCookies:(NSArray<NSHTTPCookie *> *)cookies forURL:(NSURL *)URL mainDocumentURL:(NSURL *)mainDocumentURL;
- (void) setCookies___java_util_List_crossmobile_ios_foundation_NSURL_crossmobile_ios_foundation_NSURL:(NSArray*) cookies :(NSURL*) URL :(NSURL*) mainDocumentURL 
{
    [super setCookies:(cookies == JAVA_NULL ? nil : cookies) forURL:(URL == JAVA_NULL ? nil : URL) mainDocumentURL:(mainDocumentURL == JAVA_NULL ? nil : mainDocumentURL)];
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

@implementation NSHTTPCookieStorage (cm_crossmobile_ios_foundation_NSHTTPCookieStorage)

// direct binding of: + (NSHTTPCookieStorage *)sharedHTTPCookieStorage;
+ (NSHTTPCookieStorage*) sharedHTTPCookieStorage__
{
    NSHTTPCookieStorage* re$ult = [NSHTTPCookieStorage sharedHTTPCookieStorage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property NSHTTPCookieAcceptPolicy cookieAcceptPolicy;
- (void) setCookieAcceptPolicy___int:(int) cookieAcceptPolicy 
{
    [self setCookieAcceptPolicy:cookieAcceptPolicy];
}

// direct binding of: @property NSHTTPCookieAcceptPolicy cookieAcceptPolicy;
- (int) cookieAcceptPolicy__
{
    return [self cookieAcceptPolicy];
}

// direct binding of: @property(readonly, copy) NSArray<NSHTTPCookie *> *cookies;
- (NSArray*) cookies__
{
    NSArray* re$ult = [self cookies];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSArray<NSHTTPCookie *> *)cookiesForURL:(NSURL *)URL;
- (NSArray*) cookiesForURL___crossmobile_ios_foundation_NSURL:(NSURL*) URL 
{
    NSArray* re$ult = [self cookiesForURL:(URL == JAVA_NULL ? nil : URL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)deleteCookie:(NSHTTPCookie *)cookie;
- (void) deleteCookie___crossmobile_ios_foundation_NSHTTPCookie:(NSHTTPCookie*) cookie 
{
    [self deleteCookie:(cookie == JAVA_NULL ? nil : cookie)];
}

// direct binding of: - (void)setCookie:(NSHTTPCookie *)cookie;
- (void) setCookie___crossmobile_ios_foundation_NSHTTPCookie:(NSHTTPCookie*) cookie 
{
    [self setCookie:(cookie == JAVA_NULL ? nil : cookie)];
}

// direct binding of: - (void)setCookies:(NSArray<NSHTTPCookie *> *)cookies forURL:(NSURL *)URL mainDocumentURL:(NSURL *)mainDocumentURL;
- (void) setCookies___java_util_List_crossmobile_ios_foundation_NSURL_crossmobile_ios_foundation_NSURL:(NSArray*) cookies :(NSURL*) URL :(NSURL*) mainDocumentURL 
{
    [self setCookies:(cookies == JAVA_NULL ? nil : cookies) forURL:(URL == JAVA_NULL ? nil : URL) mainDocumentURL:(mainDocumentURL == JAVA_NULL ? nil : mainDocumentURL)];
}

@end
