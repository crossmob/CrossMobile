// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNSaveRequest implementation

#import "crossmobile_ios_contacts_CNMutableContact.h"
#import "crossmobile_ios_contacts_CNSaveRequest.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_contacts_CNSaveRequest$Ext

// (CNSaveRequest) - (void)addContact:(CNMutableContact *)contact toContainerWithIdentifier:(NSString *)identifier;
- (void) addContact___crossmobile_ios_contacts_CNMutableContact_java_lang_String:(CNMutableContact*) contact :(NSString*) identifier 
{
    [super addContact:(contact == JAVA_NULL ? nil : contact) toContainerWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (CNSaveRequest) - (void)deleteContact:(CNMutableContact *)contact;
- (void) deleteContact___crossmobile_ios_contacts_CNMutableContact:(CNMutableContact*) contact 
{
    [super deleteContact:(contact == JAVA_NULL ? nil : contact)];
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

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
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
