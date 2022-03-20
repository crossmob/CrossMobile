// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContainer definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>

CM_EXPORT_CLASS
@interface crossmobile_ios_contacts_CNContainer$Ext : CNContainer
@end

#define crossmobile_ios_contacts_CNContainer CNContainer
@interface CNContainer (cm_crossmobile_ios_contacts_CNContainer)
@end
