// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSHTTPCookie implementation

#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSHTTPCookie.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSHTTPCookie$Ext

// (NSHTTPCookie) @property(readonly, getter=isHTTPOnly) BOOL HTTPOnly;
- (BOOL) isHTTPOnly__
{
    return [super isHTTPOnly];
}

// (NSHTTPCookie) @property(readonly, copy) NSString *comment;
- (NSString*) comment__
{
    NSString* re$ult = [super comment];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSHTTPCookie) @property(readonly, copy) NSURL *commentURL;
- (NSURL*) commentURL__
{
    NSURL* re$ult = [super commentURL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSHTTPCookie) @property(readonly, copy) NSString *domain;
- (NSString*) domain__
{
    NSString* re$ult = [super domain];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSHTTPCookie) @property(readonly, copy) NSDate *expiresDate;
- (NSDate*) expiresDate__
{
    NSDate* re$ult = [super expiresDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSHTTPCookie) @property(readonly, copy) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [super name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSHTTPCookie) @property(readonly, copy) NSString *path;
- (NSString*) path__
{
    NSString* re$ult = [super path];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSHTTPCookie) @property(readonly, copy) NSArray<NSNumber *> *portList;
- (NSArray*) portList__
{
    NSArray* re$ult = [super portList];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSHTTPCookie) @property(readonly, getter=isSecure) BOOL secure;
- (BOOL) isSecure__
{
    return [super isSecure];
}

// (NSHTTPCookie) @property(readonly, getter=isSessionOnly) BOOL sessionOnly;
- (BOOL) isSessionOnly__
{
    return [super isSessionOnly];
}

// (NSHTTPCookie) @property(readonly, copy) NSString *value;
- (NSString*) value__
{
    NSString* re$ult = [super value];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSHTTPCookie) @property(readonly) NSUInteger version;
- (int) version__
{
    return [super version];
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

@implementation NSHTTPCookie (cm_crossmobile_ios_foundation_NSHTTPCookie)

// direct binding of: @property(readonly, getter=isHTTPOnly) BOOL HTTPOnly;
- (BOOL) isHTTPOnly__
{
    return [self isHTTPOnly];
}

// direct binding of: @property(readonly, copy) NSString *comment;
- (NSString*) comment__
{
    NSString* re$ult = [self comment];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSURL *commentURL;
- (NSURL*) commentURL__
{
    NSURL* re$ult = [self commentURL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSString *domain;
- (NSString*) domain__
{
    NSString* re$ult = [self domain];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSDate *expiresDate;
- (NSDate*) expiresDate__
{
    NSDate* re$ult = [self expiresDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSString *path;
- (NSString*) path__
{
    NSString* re$ult = [self path];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSArray<NSNumber *> *portList;
- (NSArray*) portList__
{
    NSArray* re$ult = [self portList];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, getter=isSecure) BOOL secure;
- (BOOL) isSecure__
{
    return [self isSecure];
}

// direct binding of: @property(readonly, getter=isSessionOnly) BOOL sessionOnly;
- (BOOL) isSessionOnly__
{
    return [self isSessionOnly];
}

// direct binding of: @property(readonly, copy) NSString *value;
- (NSString*) value__
{
    NSString* re$ult = [self value];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) NSUInteger version;
- (int) version__
{
    return [self version];
}

@end
