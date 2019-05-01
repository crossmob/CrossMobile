// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSLocale implementation

#import "crossmobile_ios_foundation_NSLocale.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

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
