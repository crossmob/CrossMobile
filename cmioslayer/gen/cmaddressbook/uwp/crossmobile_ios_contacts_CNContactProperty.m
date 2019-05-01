// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNContactProperty implementation

#import "crossmobile_ios_contacts_CNContact.h"
#import "crossmobile_ios_contacts_CNContactProperty.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNContactProperty$Ext

// (CNContactProperty) @property(readonly, copy, nonatomic) CNContact *contact;
- (CNContact*) contact__
{
    CNContact* re$ult = [super contact];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContactProperty) @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContactProperty) @property(readonly, copy, nonatomic) NSString *key;
- (NSString*) key__
{
    NSString* re$ult = [super key];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContactProperty) @property(readonly, copy, nonatomic) NSString *label;
- (NSString*) label__
{
    NSString* re$ult = [super label];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContactProperty) @property(readonly, nonatomic) id value;
- (id) value__
{
    id re$ult = [super value];
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

@implementation CNContactProperty (cm_crossmobile_ios_contacts_CNContactProperty)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_contacts_CNContactProperty__
{
    return [self init];
}

// direct binding of: @property(readonly, copy, nonatomic) CNContact *contact;
- (CNContact*) contact__
{
    CNContact* re$ult = [self contact];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *key;
- (NSString*) key__
{
    NSString* re$ult = [self key];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *label;
- (NSString*) label__
{
    NSString* re$ult = [self label];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) id value;
- (id) value__
{
    id re$ult = [self value];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
