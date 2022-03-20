// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_accounts_ACAccountStore implementation

#import "crossmobile_ios_accounts_ACAccount.h"
#import "crossmobile_ios_accounts_ACAccountStore.h"
#import "crossmobile_ios_accounts_ACAccountStoreCredentialRenewalHandler.h"
#import "crossmobile_ios_accounts_ACAccountStoreRemoveCompletionHandler.h"
#import "crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler.h"
#import "crossmobile_ios_accounts_ACAccountStoreSaveCompletionHandler.h"
#import "crossmobile_ios_accounts_ACAccountType.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_accounts_ACAccountStore$Ext

@end

@implementation ACAccountStore (cm_crossmobile_ios_accounts_ACAccountStore)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_accounts_ACAccountStore__
{
    return [self init];
}

// @property(readonly, weak, nonatomic) NSArray *accounts;
- (NSArray*) accounts__
{
    NSArray* re$ult = [self accounts];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (ACAccountType *)accountTypeWithAccountTypeIdentifier:(NSString *)typeIdentifier;
- (ACAccountType*) accountTypeWithAccountTypeIdentifier___java_lang_String:(NSString*) typeIdentifier 
{
    ACAccountType* re$ult = [self accountTypeWithAccountTypeIdentifier:(typeIdentifier == JAVA_NULL ? nil : typeIdentifier)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (ACAccount *)accountWithIdentifier:(NSString *)identifier;
- (ACAccount*) accountWithIdentifier___java_lang_String:(NSString*) identifier 
{
    ACAccount* re$ult = [self accountWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSArray *)accountsWithAccountType:(ACAccountType *)accountType;
- (NSArray*) accountsWithAccountType___crossmobile_ios_accounts_ACAccountType:(ACAccountType*) accountType 
{
    NSArray* re$ult = [self accountsWithAccountType:(accountType == JAVA_NULL ? nil : accountType)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)removeAccount:(ACAccount *)account withCompletionHandler:(ACAccountStoreRemoveCompletionHandler)completionHandler;
- (void) removeAccount___crossmobile_ios_accounts_ACAccount_crossmobile_ios_accounts_ACAccountStoreRemoveCompletionHandler:(ACAccount*) account :(id<crossmobile_ios_accounts_ACAccountStoreRemoveCompletionHandler>) completionHandler 
{
    [self removeAccount:(account == JAVA_NULL ? nil : account) withCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(BOOL success, NSError* error) {
        java_lang_Boolean* success$conv = [[java_lang_Boolean alloc] initWithBool:success];
        [completionHandler invoke___java_lang_Boolean_crossmobile_ios_foundation_NSError:success$conv :(error ? error : JAVA_NULL)];
        [success$conv release];
    })];
}

// - (void)renewCredentialsForAccount:(ACAccount *)account completion:(ACAccountStoreCredentialRenewalHandler)completionHandler;
- (void) renewCredentialsForAccount___crossmobile_ios_accounts_ACAccount_crossmobile_ios_accounts_ACAccountStoreCredentialRenewalHandler:(ACAccount*) account :(id<crossmobile_ios_accounts_ACAccountStoreCredentialRenewalHandler>) completionHandler 
{
    [self renewCredentialsForAccount:(account == JAVA_NULL ? nil : account) completion:(completionHandler == JAVA_NULL ? nil : ^(ACAccountCredentialRenewResult renewResult, NSError* error) {
        java_lang_Integer* renewResult$conv = [[java_lang_Integer alloc] initWithInt:renewResult];
        [completionHandler invoke___java_lang_Integer_crossmobile_ios_foundation_NSError:renewResult$conv :(error ? error : JAVA_NULL)];
        [renewResult$conv release];
    })];
}

// - (void)requestAccessToAccountsWithType:(ACAccountType *)accountType withCompletionHandler:(ACAccountStoreRequestAccessCompletionHandler)handler;
- (void) requestAccessToAccountsWithType___crossmobile_ios_accounts_ACAccountType_crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler:(ACAccountType*) accountType :(id<crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler>) handler 
{
    [self requestAccessToAccountsWithType:(accountType == JAVA_NULL ? nil : accountType) withCompletionHandler:(handler == JAVA_NULL ? nil : ^(BOOL granted, NSError* error) {
        java_lang_Boolean* granted$conv = [[java_lang_Boolean alloc] initWithBool:granted];
        [handler invoke___java_lang_Boolean_crossmobile_ios_foundation_NSError:granted$conv :(error ? error : JAVA_NULL)];
        [granted$conv release];
    })];
}

// - (void)requestAccessToAccountsWithType:(ACAccountType *)accountType options:(NSDictionary *)options completion:(ACAccountStoreRequestAccessCompletionHandler)completion;
- (void) requestAccessToAccountsWithType___crossmobile_ios_accounts_ACAccountType_java_util_Map_crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler:(ACAccountType*) accountType :(NSDictionary*) options :(id<crossmobile_ios_accounts_ACAccountStoreRequestAccessCompletionHandler>) completion 
{
    [self requestAccessToAccountsWithType:(accountType == JAVA_NULL ? nil : accountType) options:(options == JAVA_NULL ? nil : options) completion:(completion == JAVA_NULL ? nil : ^(BOOL granted, NSError* error) {
        java_lang_Boolean* granted$conv = [[java_lang_Boolean alloc] initWithBool:granted];
        [completion invoke___java_lang_Boolean_crossmobile_ios_foundation_NSError:granted$conv :(error ? error : JAVA_NULL)];
        [granted$conv release];
    })];
}

// - (void)saveAccount:(ACAccount *)account withCompletionHandler:(ACAccountStoreSaveCompletionHandler)completionHandler;
- (void) saveAccount___crossmobile_ios_accounts_ACAccount_crossmobile_ios_accounts_ACAccountStoreSaveCompletionHandler:(ACAccount*) account :(id<crossmobile_ios_accounts_ACAccountStoreSaveCompletionHandler>) completionHandler 
{
    [self saveAccount:(account == JAVA_NULL ? nil : account) withCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(BOOL success, NSError* error) {
        java_lang_Boolean* success$conv = [[java_lang_Boolean alloc] initWithBool:success];
        [completionHandler invoke___java_lang_Boolean_crossmobile_ios_foundation_NSError:success$conv :(error ? error : JAVA_NULL)];
        [success$conv release];
    })];
}

@end
