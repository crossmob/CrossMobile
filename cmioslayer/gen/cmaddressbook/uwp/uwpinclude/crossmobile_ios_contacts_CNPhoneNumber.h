// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNPhoneNumber definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_contacts_CNPhoneNumber$Ext : CNPhoneNumber
@end

#define crossmobile_ios_contacts_CNPhoneNumber CNPhoneNumber
@interface CNPhoneNumber (cm_crossmobile_ios_contacts_CNPhoneNumber)
- (instancetype) __init_crossmobile_ios_contacts_CNPhoneNumber___java_lang_String:(NSString*) string ;
@end
