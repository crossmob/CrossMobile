// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_accounts_ACAccountType definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_accounts_ACAccountType$Ext : ACAccountType
@end

#define crossmobile_ios_accounts_ACAccountType ACAccountType
@interface ACAccountType (cm_crossmobile_ios_accounts_ACAccountType)
- (instancetype) __init_crossmobile_ios_accounts_ACAccountType__;
- (BOOL) accessGranted__;
- (NSString*) accountTypeDescription__;
- (NSString*) identifier__;
@end
