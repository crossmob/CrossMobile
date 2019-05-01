// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNContactFormatter implementation

#import "crossmobile_ios_contacts_CNContact.h"
#import "crossmobile_ios_contacts_CNContactFormatter.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNContactFormatter$Ext

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

@implementation CNContactFormatter (cm_crossmobile_ios_contacts_CNContactFormatter)

// direct binding of: + (NSString *)stringFromContact:(CNContact *)contact style:(CNContactFormatterStyle)style;
+ (NSString*) stringFromContact___crossmobile_ios_contacts_CNContact_int:(CNContact*) contact :(int) style 
{
    NSString* re$ult = [CNContactFormatter stringFromContact:(contact == JAVA_NULL ? nil : contact) style:style];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_contacts_CNContactFormatter__
{
    return [self init];
}

@end
