// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABUnknownPersonViewControllerDelegate definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_addressbook_ABRecord;
@class crossmobile_ios_addressbook_ABUnknownPersonViewController;

CM_EXPORT_CLASS
@protocol crossmobile_ios_addressbook_ABUnknownPersonViewControllerDelegate
- (void) didResolveToPerson___crossmobile_ios_addressbook_ABUnknownPersonViewController_crossmobile_ios_addressbook_ABRecord:(ABUnknownPersonViewController*) unknownCardViewController :(crossmobile_ios_addressbook_ABRecord*) person ;
- (BOOL) shouldPerformDefaultActionForPerson___crossmobile_ios_addressbook_ABUnknownPersonViewController_crossmobile_ios_addressbook_ABRecord_int_int:(ABUnknownPersonViewController*) personViewController :(crossmobile_ios_addressbook_ABRecord*) person :(int) property :(int) identifier ;
@end
