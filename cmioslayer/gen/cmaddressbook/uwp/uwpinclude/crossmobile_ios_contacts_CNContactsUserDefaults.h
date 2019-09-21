// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_contacts_CNContactsUserDefaults definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>

CM_EXPORT_CLASS
@interface crossmobile_ios_contacts_CNContactsUserDefaults$Ext : CNContactsUserDefaults
@end

#define crossmobile_ios_contacts_CNContactsUserDefaults CNContactsUserDefaults
@interface CNContactsUserDefaults (cm_crossmobile_ios_contacts_CNContactsUserDefaults)
+ (instancetype) sharedDefaults__;
@end
