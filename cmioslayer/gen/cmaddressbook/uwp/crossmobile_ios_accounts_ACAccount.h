// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_accounts_ACAccount definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_accounts_ACAccountCredential;
@class crossmobile_ios_accounts_ACAccountType;
@class java_lang_String;

@interface crossmobile_ios_accounts_ACAccount$Ext : ACAccount
@end

#define crossmobile_ios_accounts_ACAccount ACAccount
@interface ACAccount (cm_crossmobile_ios_accounts_ACAccount)
- (instancetype) __init_crossmobile_ios_accounts_ACAccount__;
- (instancetype) __init_crossmobile_ios_accounts_ACAccount___crossmobile_ios_accounts_ACAccountType:(ACAccountType*) type ;
- (void) setAccountDescription___java_lang_String:(NSString*) accountDescription ;
- (NSString*) accountDescription__;
- (void) setAccountType___crossmobile_ios_accounts_ACAccountType:(ACAccountType*) accountType ;
- (ACAccountType*) accountType__;
- (void) setCredential___crossmobile_ios_accounts_ACAccountCredential:(ACAccountCredential*) credential ;
- (ACAccountCredential*) credential__;
- (NSString*) identifier__;
- (void) setUsername___java_lang_String:(NSString*) username ;
- (NSString*) username__;
@end
