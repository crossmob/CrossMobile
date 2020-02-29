// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_addressbook_ABAddressBookRequestAccessCompletionHandler definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_foundation_NSError;
@class java_lang_Boolean;

CM_EXPORT_CLASS
@protocol crossmobile_ios_addressbook_ABAddressBookRequestAccessCompletionHandler
- (void) invoke___java_lang_Boolean_crossmobile_ios_foundation_NSError:(java_lang_Boolean*) granted :(NSError*) error ;
@end
