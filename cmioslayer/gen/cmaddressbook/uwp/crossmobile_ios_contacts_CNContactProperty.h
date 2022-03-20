// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContactProperty definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_contacts_CNContact;
@class crossmobile_ios_foundation_NSObject;
@class java_lang_String;

@interface crossmobile_ios_contacts_CNContactProperty$Ext : CNContactProperty
@end

#define crossmobile_ios_contacts_CNContactProperty CNContactProperty
@interface CNContactProperty (cm_crossmobile_ios_contacts_CNContactProperty)
- (instancetype) __init_crossmobile_ios_contacts_CNContactProperty__;
- (CNContact*) contact__;
- (NSString*) identifier__;
- (NSString*) key__;
- (NSString*) label__;
- (id) value__;
@end
