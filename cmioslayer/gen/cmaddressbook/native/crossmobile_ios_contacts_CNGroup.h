// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNGroup definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class java_lang_String;

@interface crossmobile_ios_contacts_CNGroup$Ext : CNGroup
@end

#define crossmobile_ios_contacts_CNGroup CNGroup
@interface CNGroup (cm_crossmobile_ios_contacts_CNGroup)
- (NSString*) identifier__;
- (NSString*) name__;
@end
