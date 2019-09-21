// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_contacts_CNLabeledValue definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class java_lang_Object;
@class java_lang_String;

@interface crossmobile_ios_contacts_CNLabeledValue$Ext : CNLabeledValue
@end

#define crossmobile_ios_contacts_CNLabeledValue CNLabeledValue
@interface CNLabeledValue (cm_crossmobile_ios_contacts_CNLabeledValue)
+ (NSString*) localizedStringForLabel___java_lang_String:(NSString*) label ;
- (instancetype) __init_crossmobile_ios_contacts_CNLabeledValue___java_lang_String_java_lang_Object:(NSString*) label :(id) value ;
- (NSString*) label__;
- (id) value__;
- (instancetype) labeledValueBySettingLabel___java_lang_String:(NSString*) label ;
@end
