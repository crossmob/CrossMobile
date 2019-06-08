// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSLocale implementation

#import "crossmobile_ios_foundation_NSLocale.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSLocale$Ext

// (NSLocale) @property(readonly, copy) NSString *countryCode;
- (NSString*) countryCode__
{
    NSString* re$ult = [super countryCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLocale) @property(readonly, copy) NSString *languageCode;
- (NSString*) languageCode__
{
    NSString* re$ult = [super languageCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLocale) @property(readonly, copy) NSString *localeIdentifier ;
- (NSString*) localeIdentifier__
{
    NSString* re$ult = [super localeIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLocale) @property(readonly, copy) NSString *variantCode;
- (NSString*) variantCode__
{
    NSString* re$ult = [super variantCode];
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

@implementation NSLocale (cm_crossmobile_ios_foundation_NSLocale)

// direct binding of: + (NSLocale *)currentLocale;
+ (NSLocale*) currentLocale__
{
    NSLocale* re$ult = [NSLocale currentLocale];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSArray<NSString *> *)preferredLanguages;
+ (NSArray*) preferredLanguages__
{
    NSArray* re$ult = [NSLocale preferredLanguages];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSLocale *)systemLocale;
+ (NSLocale*) systemLocale__
{
    NSLocale* re$ult = [NSLocale systemLocale];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithLocaleIdentifier:(NSString *)string;
- (instancetype) __init_crossmobile_ios_foundation_NSLocale___java_lang_String:(NSString*) string 
{
    return [self initWithLocaleIdentifier:(string == JAVA_NULL ? nil : string)];
}

// direct binding of: @property(readonly, copy) NSString *countryCode;
- (NSString*) countryCode__
{
    NSString* re$ult = [self countryCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSString *languageCode;
- (NSString*) languageCode__
{
    NSString* re$ult = [self languageCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSString *localeIdentifier ;
- (NSString*) localeIdentifier__
{
    NSString* re$ult = [self localeIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSString *variantCode;
- (NSString*) variantCode__
{
    NSString* re$ult = [self variantCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
