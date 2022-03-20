// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABNewPersonViewController definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_addressbook_ABAddressBook;
@protocol crossmobile_ios_addressbook_ABNewPersonViewControllerDelegate;
@class crossmobile_ios_addressbook_ABRecord;

@interface crossmobile_ios_addressbook_ABNewPersonViewController$Ext : ABNewPersonViewController
@end

#define crossmobile_ios_addressbook_ABNewPersonViewController ABNewPersonViewController
@interface ABNewPersonViewController (cm_crossmobile_ios_addressbook_ABNewPersonViewController)
- (instancetype) __init_crossmobile_ios_addressbook_ABNewPersonViewController__;
- (void) setAddressBook___crossmobile_ios_addressbook_ABAddressBook:(crossmobile_ios_addressbook_ABAddressBook*) addressBook ;
- (crossmobile_ios_addressbook_ABAddressBook*) addressBook__;
- (void) setDisplayedPerson___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) displayedPerson ;
- (crossmobile_ios_addressbook_ABRecord*) displayedPerson__;
- (void) setNewPersonViewDelegate___crossmobile_ios_addressbook_ABNewPersonViewControllerDelegate:(id<ABNewPersonViewControllerDelegate>) newPersonViewDelegate ;
- (id<ABNewPersonViewControllerDelegate>) newPersonViewDelegate__;
- (void) setParentGroup___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) parentGroup ;
- (crossmobile_ios_addressbook_ABRecord*) parentGroup__;
@end
