// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_contacts_CNContactFormatter definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_contacts_CNContact;
@class java_lang_String;

@interface crossmobile_ios_contacts_CNContactFormatter$Ext : CNContactFormatter
@end

#define crossmobile_ios_contacts_CNContactFormatter CNContactFormatter
@interface CNContactFormatter (cm_crossmobile_ios_contacts_CNContactFormatter)
+ (NSString*) stringFromContact___crossmobile_ios_contacts_CNContact_int:(CNContact*) contact :(int) style ;
- (instancetype) __init_crossmobile_ios_contacts_CNContactFormatter__;
@end
