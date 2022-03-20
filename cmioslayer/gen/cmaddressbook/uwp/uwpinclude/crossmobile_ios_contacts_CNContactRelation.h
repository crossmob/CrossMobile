// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContactRelation definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_contacts_CNContactRelation$Ext : CNContactRelation
@end

#define crossmobile_ios_contacts_CNContactRelation CNContactRelation
@interface CNContactRelation (cm_crossmobile_ios_contacts_CNContactRelation)
- (instancetype) __init_crossmobile_ios_contacts_CNContactRelation___java_lang_String:(NSString*) name ;
@end
