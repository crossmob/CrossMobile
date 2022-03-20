// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABPersonViewControllerDelegate definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_addressbook_ABPersonViewController;
@class crossmobile_ios_addressbook_ABRecord;

@protocol crossmobile_ios_addressbook_ABPersonViewControllerDelegate
- (BOOL) shouldPerformDefaultActionForPerson___crossmobile_ios_addressbook_ABPersonViewController_crossmobile_ios_addressbook_ABRecord_int_int:(ABPersonViewController*) personViewController :(crossmobile_ios_addressbook_ABRecord*) person :(int) property :(int) identifier ;
@end
