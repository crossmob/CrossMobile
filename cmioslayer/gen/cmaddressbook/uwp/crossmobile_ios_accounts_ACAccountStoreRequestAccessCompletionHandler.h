// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_foundation_NSError;
@class java_lang_Boolean;

@protocol crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler
- (void) invoke___java_lang_Boolean_crossmobile_ios_foundation_NSError:(java_lang_Boolean*) granted :(NSError*) error ;
@end
