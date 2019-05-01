// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNSaveRequest implementation

#import "crossmobile_ios_contacts_CNMutableContact.h"
#import "crossmobile_ios_contacts_CNSaveRequest.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNSaveRequest$Ext

// (CNSaveRequest) - (void)addContact:(CNMutableContact *)contact toContainerWithIdentifier:(NSString *)identifier;
- (void) addContact___crossmobile_ios_contacts_CNMutableContact_java_lang_String:(CNMutableContact*) contact :(NSString*) identifier 
{
    [super addContact:(contact == JAVA_NULL ? nil : contact) toContainerWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// (CNSaveRequest) - (void)deleteContact:(CNMutableContact *)contact;
- (void) deleteContact___crossmobile_ios_contacts_CNMutableContact:(CNMutableContact*) contact 
{
    [super deleteContact:(contact == JAVA_NULL ? nil : contact)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (CNSaveRequest) - (void)updateContact:(CNMutableContact *)contact;
- (void) updateContact___crossmobile_ios_contacts_CNMutableContact:(CNMutableContact*) contact 
{
    [super updateContact:(contact == JAVA_NULL ? nil : contact)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation CNSaveRequest (cm_crossmobile_ios_contacts_CNSaveRequest)

// direct binding of: - (void)addContact:(CNMutableContact *)contact toContainerWithIdentifier:(NSString *)identifier;
- (void) addContact___crossmobile_ios_contacts_CNMutableContact_java_lang_String:(CNMutableContact*) contact :(NSString*) identifier 
{
    [self addContact:(contact == JAVA_NULL ? nil : contact) toContainerWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// direct binding of: - (void)deleteContact:(CNMutableContact *)contact;
- (void) deleteContact___crossmobile_ios_contacts_CNMutableContact:(CNMutableContact*) contact 
{
    [self deleteContact:(contact == JAVA_NULL ? nil : contact)];
}

// direct binding of: - (void)updateContact:(CNMutableContact *)contact;
- (void) updateContact___crossmobile_ios_contacts_CNMutableContact:(CNMutableContact*) contact 
{
    [self updateContact:(contact == JAVA_NULL ? nil : contact)];
}

@end
