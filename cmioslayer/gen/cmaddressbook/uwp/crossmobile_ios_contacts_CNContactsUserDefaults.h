// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContactsUserDefaults definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>

@interface crossmobile_ios_contacts_CNContactsUserDefaults$Ext : CNContactsUserDefaults
@end

#define crossmobile_ios_contacts_CNContactsUserDefaults CNContactsUserDefaults
@interface CNContactsUserDefaults (cm_crossmobile_ios_contacts_CNContactsUserDefaults)
+ (instancetype) sharedDefaults__;
@end
