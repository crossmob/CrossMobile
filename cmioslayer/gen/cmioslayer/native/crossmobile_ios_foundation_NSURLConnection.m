// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSURLConnection implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURLConnection.h"
#import "crossmobile_ios_foundation_NSURLConnectionDelegate.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSURLConnection$Ext

// (NSURLConnection) @property(readonly, copy) NSURLRequest *currentRequest;
- (NSURLRequest*) currentRequest__
{
    NSURLRequest* re$ult = [super currentRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSURLConnection) @property(readonly, copy) NSURLRequest *originalRequest;
- (NSURLRequest*) originalRequest__
{
    NSURLRequest* re$ult = [super originalRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSURLConnection) - (void)cancel;
- (void) cancel__
{
    [super cancel];
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

// (NSURLConnection) - (void)start;
- (void) start__
{
    [super start];
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

@implementation NSURLConnection (cm_crossmobile_ios_foundation_NSURLConnection)

// direct binding of: + (NSURLConnection *)connectionWithRequest:(NSURLRequest *)request delegate:(id)delegate;
+ (NSURLConnection*) connectionWithRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURLConnectionDelegate:(NSURLRequest*) request :(id<NSURLConnectionDelegate>) delegate 
{
    NSURLConnection* re$ult = [NSURLConnection connectionWithRequest:(request == JAVA_NULL ? nil : request) delegate:(delegate == JAVA_NULL ? nil : delegate)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSData *)sendSynchronousRequest:(NSURLRequest *)request returningResponse:(NSURLResponse * _Nullable *)response error:(NSError * _Nullable *)error;
+ (NSData*) sendSynchronousRequest___crossmobile_ios_foundation_NSURLRequest_crossmobile_rt_StrongReference_crossmobile_rt_StrongReference:(NSURLRequest*) request :(crossmobile_rt_StrongReference*) response :(crossmobile_rt_StrongReference*) error 
{
    response = response == JAVA_NULL ? nil : response;
    id response$conv = nil;
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSData* re$ult = [NSURLConnection sendSynchronousRequest:(request == JAVA_NULL ? nil : request) returningResponse:(response ? &response$conv : nil) error:(error ? &error$conv : nil)];
    if (response)
        [response set___java_lang_Object:(response$conv ? response$conv : JAVA_NULL)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithRequest:(NSURLRequest *)request delegate:(id)delegate;
- (instancetype) __init_crossmobile_ios_foundation_NSURLConnection___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURLConnectionDelegate:(NSURLRequest*) request :(id<NSURLConnectionDelegate>) delegate 
{
    return [self initWithRequest:(request == JAVA_NULL ? nil : request) delegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: - (instancetype)initWithRequest:(NSURLRequest *)request delegate:(id)delegate startImmediately:(BOOL)startImmediately;
- (instancetype) __init_crossmobile_ios_foundation_NSURLConnection___crossmobile_ios_foundation_NSURLRequest_crossmobile_ios_foundation_NSURLConnectionDelegate_boolean:(NSURLRequest*) request :(id<NSURLConnectionDelegate>) delegate :(BOOL) startImmediately 
{
    return [self initWithRequest:(request == JAVA_NULL ? nil : request) delegate:(delegate == JAVA_NULL ? nil : delegate) startImmediately:startImmediately];
}

// direct binding of: @property(readonly, copy) NSURLRequest *currentRequest;
- (NSURLRequest*) currentRequest__
{
    NSURLRequest* re$ult = [self currentRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSURLRequest *originalRequest;
- (NSURLRequest*) originalRequest__
{
    NSURLRequest* re$ult = [self originalRequest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)cancel;
- (void) cancel__
{
    [self cancel];
}

// direct binding of: - (void)start;
- (void) start__
{
    [self start];
}

@end
