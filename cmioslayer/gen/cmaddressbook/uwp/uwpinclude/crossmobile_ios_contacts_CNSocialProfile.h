// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNSocialProfile definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_contacts_CNSocialProfile$Ext : CNSocialProfile
@end

#define crossmobile_ios_contacts_CNSocialProfile CNSocialProfile
@interface CNSocialProfile (cm_crossmobile_ios_contacts_CNSocialProfile)
- (instancetype) __init_crossmobile_ios_contacts_CNSocialProfile___java_lang_String_java_lang_String_java_lang_String_java_lang_String:(NSString*) urlString :(NSString*) username :(NSString*) userIdentifier :(NSString*) service ;
- (NSString*) service__;
- (NSString*) urlString__;
- (NSString*) userIdentifier__;
- (NSString*) username__;
@end
