// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABNewPersonViewControllerDelegate definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_addressbook_ABNewPersonViewController;
@class crossmobile_ios_addressbook_ABRecord;

CM_EXPORT_CLASS
@protocol crossmobile_ios_addressbook_ABNewPersonViewControllerDelegate
- (void) didCompleteWithNewPerson___crossmobile_ios_addressbook_ABNewPersonViewController_crossmobile_ios_addressbook_ABRecord:(ABNewPersonViewController*) newPersonViewController :(crossmobile_ios_addressbook_ABRecord*) person ;
@end
