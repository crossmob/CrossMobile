// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABRecord definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
#import "crossmobile_ios_foundation_CFType.h"
@class crossmobile_rt_StrongReference;
@class java_lang_Object;
@class java_lang_String;

@interface crossmobile_ios_addressbook_ABRecord : crossmobile_ios_foundation_CFType
- (NSString*) copyCompositeName__;
- (crossmobile_ios_foundation_CFType*) copyValue___int:(int) property ;
- (int) getRecordID__;
- (int) getRecordType__;
- (BOOL) removeValue___int_crossmobile_rt_StrongReference:(int) property :(crossmobile_rt_StrongReference*) error ;
- (BOOL) setValue___int_crossmobile_ios_foundation_CFType_crossmobile_rt_StrongReference:(int) property :(crossmobile_ios_foundation_CFType*) value :(crossmobile_rt_StrongReference*) error ;
- (instancetype) initWithABRecord:(ABRecordRef) reference;
@end
