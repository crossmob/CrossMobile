// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNPhoneNumber implementation

#import "crossmobile_ios_contacts_CNPhoneNumber.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNPhoneNumber$Ext

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

@implementation CNPhoneNumber (cm_crossmobile_ios_contacts_CNPhoneNumber)

// direct binding of: - (instancetype)initWithStringValue:(NSString *)string;
- (instancetype) __init_crossmobile_ios_contacts_CNPhoneNumber___java_lang_String:(NSString*) string 
{
    return [self initWithStringValue:(string == JAVA_NULL ? nil : string)];
}

@end
