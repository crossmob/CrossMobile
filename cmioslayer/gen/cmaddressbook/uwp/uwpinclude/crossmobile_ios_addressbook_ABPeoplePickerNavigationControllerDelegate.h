// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_addressbook_ABPeoplePickerNavigationControllerDelegate definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_addressbook_ABPeoplePickerNavigationController;
@class crossmobile_ios_addressbook_ABRecord;

CM_EXPORT_CLASS
@protocol crossmobile_ios_addressbook_ABPeoplePickerNavigationControllerDelegate
- (void) didCancel___crossmobile_ios_addressbook_ABPeoplePickerNavigationController:(ABPeoplePickerNavigationController*) peoplePicker ;
- (BOOL) shouldContinueAfterSelectingPerson___crossmobile_ios_addressbook_ABPeoplePickerNavigationController_crossmobile_ios_addressbook_ABRecord:(ABPeoplePickerNavigationController*) peoplePicker :(crossmobile_ios_addressbook_ABRecord*) person ;
- (BOOL) shouldContinueAfterSelectingPersonProperty___crossmobile_ios_addressbook_ABPeoplePickerNavigationController_crossmobile_ios_addressbook_ABRecord_int_int:(ABPeoplePickerNavigationController*) peoplePicker :(crossmobile_ios_addressbook_ABRecord*) person :(int) property :(int) identifier ;
@end
