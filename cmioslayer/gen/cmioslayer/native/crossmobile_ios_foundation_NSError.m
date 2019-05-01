// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSError implementation

#import "crossmobile_ios_foundation_NSError.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSError$Ext

// (NSError) @property(readonly) NSInteger code;
- (int) code__
{
    return [super code];
}

// (NSError) @property (readonly, copy) NSString *domain;
- (NSString*) domain__
{
    NSString* re$ult = [super domain];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSError) @property(readonly, copy) NSString *localizedDescription;
- (NSString*) localizedDescription__
{
    NSString* re$ult = [super localizedDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSError) @property(readonly, copy) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [super userInfo];
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

@implementation NSError (cm_crossmobile_ios_foundation_NSError)

// direct binding of: + (instancetype)errorWithDomain:(NSString *)domain code:(NSInteger)code userInfo:(NSDictionary *)dict;
+ (instancetype) errorWithDomain___java_lang_String_int_java_util_Map:(NSString*) domain :(int) code :(NSDictionary*) dict 
{
    id re$ult = [NSError errorWithDomain:(domain == JAVA_NULL ? nil : domain) code:code userInfo:(dict == JAVA_NULL ? nil : dict)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithDomain:(NSString *)domain code:(NSInteger)code userInfo:(NSDictionary *)dict;
- (instancetype) __init_crossmobile_ios_foundation_NSError___java_lang_String_int_java_util_Map:(NSString*) domain :(int) code :(NSDictionary*) dict 
{
    return [self initWithDomain:(domain == JAVA_NULL ? nil : domain) code:code userInfo:(dict == JAVA_NULL ? nil : dict)];
}

// direct binding of: @property(readonly) NSInteger code;
- (int) code__
{
    return [self code];
}

// direct binding of: @property (readonly, copy) NSString *domain;
- (NSString*) domain__
{
    NSString* re$ult = [self domain];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSString *localizedDescription;
- (NSString*) localizedDescription__
{
    NSString* re$ult = [self localizedDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
