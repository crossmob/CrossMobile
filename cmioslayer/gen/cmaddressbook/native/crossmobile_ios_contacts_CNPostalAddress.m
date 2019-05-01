// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNPostalAddress implementation

#import "crossmobile_ios_contacts_CNPostalAddress.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNPostalAddress$Ext

// (CNPostalAddress) @property(readonly, copy, nonatomic) NSString *ISOCountryCode;
- (NSString*) ISOCountryCode__
{
    NSString* re$ult = [super ISOCountryCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNPostalAddress) @property(readonly, copy, nonatomic) NSString *city;
- (NSString*) city__
{
    NSString* re$ult = [super city];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNPostalAddress) @property(readonly, copy, nonatomic) NSString *country;
- (NSString*) country__
{
    NSString* re$ult = [super country];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNPostalAddress) @property(readonly, copy, nonatomic) NSString *postalCode;
- (NSString*) postalCode__
{
    NSString* re$ult = [super postalCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNPostalAddress) @property(readonly, copy, nonatomic) NSString *state;
- (NSString*) state__
{
    NSString* re$ult = [super state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNPostalAddress) @property(readonly, copy, nonatomic) NSString *street;
- (NSString*) street__
{
    NSString* re$ult = [super street];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNPostalAddress) @property(readonly, copy, nonatomic) NSString *subAdministrativeArea;
- (NSString*) subAdministrativeArea__
{
    NSString* re$ult = [super subAdministrativeArea];
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

@implementation CNPostalAddress (cm_crossmobile_ios_contacts_CNPostalAddress)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_contacts_CNPostalAddress__
{
    return [self init];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *ISOCountryCode;
- (NSString*) ISOCountryCode__
{
    NSString* re$ult = [self ISOCountryCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *city;
- (NSString*) city__
{
    NSString* re$ult = [self city];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *country;
- (NSString*) country__
{
    NSString* re$ult = [self country];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *postalCode;
- (NSString*) postalCode__
{
    NSString* re$ult = [self postalCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *state;
- (NSString*) state__
{
    NSString* re$ult = [self state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *street;
- (NSString*) street__
{
    NSString* re$ult = [self street];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *subAdministrativeArea;
- (NSString*) subAdministrativeArea__
{
    NSString* re$ult = [self subAdministrativeArea];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
