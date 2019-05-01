// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNInstantMessageAddress definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class java_lang_String;

@interface crossmobile_ios_contacts_CNInstantMessageAddress$Ext : CNInstantMessageAddress
@end

#define crossmobile_ios_contacts_CNInstantMessageAddress CNInstantMessageAddress
@interface CNInstantMessageAddress (cm_crossmobile_ios_contacts_CNInstantMessageAddress)
- (instancetype) __init_crossmobile_ios_contacts_CNInstantMessageAddress___java_lang_String_java_lang_String:(NSString*) username :(NSString*) service ;
- (NSString*) service__;
- (NSString*) username__;
@end
