// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_accounts_ACAccountCredential definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_foundation_NSDate;
@class java_lang_String;

@interface crossmobile_ios_accounts_ACAccountCredential$Ext : ACAccountCredential
@end

#define crossmobile_ios_accounts_ACAccountCredential ACAccountCredential
@interface ACAccountCredential (cm_crossmobile_ios_accounts_ACAccountCredential)
- (instancetype) __init_crossmobile_ios_accounts_ACAccountCredential___java_lang_String_java_lang_String:(NSString*) token :(NSString*) secret ;
- (instancetype) __init_crossmobile_ios_accounts_ACAccountCredential___java_lang_String_java_lang_String_crossmobile_ios_foundation_NSDate:(NSString*) token :(NSString*) refreshToken :(NSDate*) expiryDate ;
- (void) setOauthToken___java_lang_String:(NSString*) oauthToken ;
- (NSString*) oauthToken__;
@end
