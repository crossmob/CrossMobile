// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABPeoplePickerNavigationController definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_addressbook_ABAddressBook;
@protocol crossmobile_ios_addressbook_ABPeoplePickerNavigationControllerDelegate;
@protocol java_util_List;

@interface crossmobile_ios_addressbook_ABPeoplePickerNavigationController$Ext : ABPeoplePickerNavigationController
@end

#define crossmobile_ios_addressbook_ABPeoplePickerNavigationController ABPeoplePickerNavigationController
@interface ABPeoplePickerNavigationController (cm_crossmobile_ios_addressbook_ABPeoplePickerNavigationController)
- (instancetype) __init_crossmobile_ios_addressbook_ABPeoplePickerNavigationController__;
- (void) setAddressBook___crossmobile_ios_addressbook_ABAddressBook:(crossmobile_ios_addressbook_ABAddressBook*) addressBook ;
- (crossmobile_ios_addressbook_ABAddressBook*) addressBook__;
- (void) setDisplayedProperties___java_util_List:(NSArray*) displayedProperties ;
- (NSArray*) displayedProperties__;
- (void) setPeoplePickerDelegate___crossmobile_ios_addressbook_ABPeoplePickerNavigationControllerDelegate:(id<ABPeoplePickerNavigationControllerDelegate>) peoplePickerDelegate ;
- (id<ABPeoplePickerNavigationControllerDelegate>) peoplePickerDelegate__;
@end
