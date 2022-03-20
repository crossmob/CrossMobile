// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABUnknownPersonViewController definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_addressbook_ABAddressBook;
@class crossmobile_ios_addressbook_ABRecord;
@protocol crossmobile_ios_addressbook_ABUnknownPersonViewControllerDelegate;
@class java_lang_String;

CM_EXPORT_CLASS
#define crossmobile_ios_addressbook_ABUnknownPersonViewController ABUnknownPersonViewController
@interface ABUnknownPersonViewController (cm_crossmobile_ios_addressbook_ABUnknownPersonViewController)
- (instancetype) __init_crossmobile_ios_addressbook_ABUnknownPersonViewController__;
- (void) setAddressBook___crossmobile_ios_addressbook_ABAddressBook:(crossmobile_ios_addressbook_ABAddressBook*) addressBook ;
- (crossmobile_ios_addressbook_ABAddressBook*) addressBook__;
- (void) setAllowsActions___boolean:(BOOL) allowsActions ;
- (BOOL) allowsActions__;
- (void) setAllowsAddingToAddressBook___boolean:(BOOL) allowsAddingToAddressBook ;
- (BOOL) allowsAddingToAddressBook__;
- (void) setAlternateName___java_lang_String:(NSString*) alternateName ;
- (NSString*) alternateName__;
- (void) setDisplayedPerson___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) displayedPerson ;
- (crossmobile_ios_addressbook_ABRecord*) displayedPerson__;
- (void) setMessage___java_lang_String:(NSString*) message ;
- (NSString*) message__;
- (void) setUnknownPersonViewDelegate___crossmobile_ios_addressbook_ABUnknownPersonViewControllerDelegate:(id<ABUnknownPersonViewControllerDelegate>) unknownPersonViewDelegate ;
- (id<ABUnknownPersonViewControllerDelegate>) unknownPersonViewDelegate__;
@end
