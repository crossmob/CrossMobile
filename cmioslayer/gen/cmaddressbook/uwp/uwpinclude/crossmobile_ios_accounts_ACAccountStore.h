// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_accounts_ACAccountStore definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_accounts_ACAccount;
@protocol crossmobile_ios_accounts_ACAccountStoreCredentialRenewalHandler;
@protocol crossmobile_ios_accounts_ACAccountStoreRemoveCompletionHandler;
@protocol crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler;
@protocol crossmobile_ios_accounts_ACAccountStoreSaveCompletionHandler;
@class crossmobile_ios_accounts_ACAccountType;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_accounts_ACAccountStore$Ext : ACAccountStore
@end

#define crossmobile_ios_accounts_ACAccountStore ACAccountStore
@interface ACAccountStore (cm_crossmobile_ios_accounts_ACAccountStore)
- (instancetype) __init_crossmobile_ios_accounts_ACAccountStore__;
- (NSArray*) accounts__;
- (ACAccountType*) accountTypeWithAccountTypeIdentifier___java_lang_String:(NSString*) typeIdentifier ;
- (ACAccount*) accountWithIdentifier___java_lang_String:(NSString*) identifier ;
- (NSArray*) accountsWithAccountType___crossmobile_ios_accounts_ACAccountType:(ACAccountType*) accountType ;
- (void) removeAccount___crossmobile_ios_accounts_ACAccount_crossmobile_ios_accounts_ACAccountStoreRemoveCompletionHandler:(ACAccount*) account :(id<crossmobile_ios_accounts_ACAccountStoreRemoveCompletionHandler>) completionHandler ;
- (void) renewCredentialsForAccount___crossmobile_ios_accounts_ACAccount_crossmobile_ios_accounts_ACAccountStoreCredentialRenewalHandler:(ACAccount*) account :(id<crossmobile_ios_accounts_ACAccountStoreCredentialRenewalHandler>) completionHandler ;
- (void) requestAccessToAccountsWithType___crossmobile_ios_accounts_ACAccountType_crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler:(ACAccountType*) accountType :(id<crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler>) handler ;
- (void) requestAccessToAccountsWithType___crossmobile_ios_accounts_ACAccountType_java_util_Map_crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler:(ACAccountType*) accountType :(NSDictionary*) options :(id<crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler>) completion ;
- (void) saveAccount___crossmobile_ios_accounts_ACAccount_crossmobile_ios_accounts_ACAccountStoreSaveCompletionHandler:(ACAccount*) account :(id<crossmobile_ios_accounts_ACAccountStoreSaveCompletionHandler>) completionHandler ;
@end
