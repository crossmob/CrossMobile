// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABPersonViewController definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_addressbook_ABAddressBook;
@protocol crossmobile_ios_addressbook_ABPersonViewControllerDelegate;
@class crossmobile_ios_addressbook_ABRecord;
@protocol java_util_List;

@interface crossmobile_ios_addressbook_ABPersonViewController$Ext : ABPersonViewController
@end

#define crossmobile_ios_addressbook_ABPersonViewController ABPersonViewController
@interface ABPersonViewController (cm_crossmobile_ios_addressbook_ABPersonViewController)
- (instancetype) __init_crossmobile_ios_addressbook_ABPersonViewController__;
- (void) setAddressBook___crossmobile_ios_addressbook_ABAddressBook:(crossmobile_ios_addressbook_ABAddressBook*) addressBook ;
- (crossmobile_ios_addressbook_ABAddressBook*) addressBook__;
- (void) setAllowsActions___boolean:(BOOL) allowsActions ;
- (BOOL) allowsActions__;
- (void) setAllowsEditing___boolean:(BOOL) allowsEditing ;
- (BOOL) allowsEditing__;
- (void) setDisplayedPerson___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) displayedPerson ;
- (crossmobile_ios_addressbook_ABRecord*) displayedPerson__;
- (void) setDisplayedProperties___java_util_List:(NSArray*) displayedProperties ;
- (NSArray*) displayedProperties__;
- (void) setPersonViewDelegate___crossmobile_ios_addressbook_ABPersonViewControllerDelegate:(id<ABPersonViewControllerDelegate>) personViewDelegate ;
- (id<ABPersonViewControllerDelegate>) personViewDelegate__;
- (void) setShouldShowLinkedPeople___boolean:(BOOL) shouldShowLinkedPeople ;
- (BOOL) shouldShowLinkedPeople__;
- (void) setHighlightedItemForProperty___int_int:(int) property :(int) identifier ;
@end
