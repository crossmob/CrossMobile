// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_accounts_ACAccountStoreRemoveCompletionHandler definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_foundation_NSError;
@class java_lang_Boolean;

@protocol crossmobile_ios_accounts_ACAccountStoreRemoveCompletionHandler
- (void) invoke___java_lang_Boolean_crossmobile_ios_foundation_NSError:(java_lang_Boolean*) success :(NSError*) error ;
@end
