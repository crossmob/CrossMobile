// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNPostalAddress definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class java_lang_String;

@interface crossmobile_ios_contacts_CNPostalAddress$Ext : CNPostalAddress
@end

#define crossmobile_ios_contacts_CNPostalAddress CNPostalAddress
@interface CNPostalAddress (cm_crossmobile_ios_contacts_CNPostalAddress)
- (instancetype) __init_crossmobile_ios_contacts_CNPostalAddress__;
- (NSString*) ISOCountryCode__;
- (NSString*) city__;
- (NSString*) country__;
- (NSString*) postalCode__;
- (NSString*) state__;
- (NSString*) street__;
- (NSString*) subAdministrativeArea__;
@end
