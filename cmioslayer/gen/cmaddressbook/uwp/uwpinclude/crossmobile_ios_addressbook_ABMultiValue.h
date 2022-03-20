// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABMultiValue definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
#import "crossmobile_ios_foundation_CFType.h"
@class crossmobile_ios_addressbook_ABMutableMultiValue;
@class java_lang_Object;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_addressbook_ABMultiValue : crossmobile_ios_foundation_CFType
- (NSArray*) copyArrayOfAllValues__;
- (NSString*) copyLabelAtIndex___long:(JAVA_LONG) index ;
- (crossmobile_ios_foundation_CFType*) copyValueAtIndex___long:(JAVA_LONG) index ;
- (crossmobile_ios_addressbook_ABMutableMultiValue*) createMutableCopy__;
- (JAVA_LONG) getCount__;
- (JAVA_LONG) getFirstIndexOfValue___crossmobile_ios_foundation_CFType:(crossmobile_ios_foundation_CFType*) value ;
- (int) getIdentifierAtIndex___long:(JAVA_LONG) index ;
- (JAVA_LONG) getIndexForIdentifier___int:(int) identifier ;
- (int) getPropertyType__;
- (instancetype) initWithABMultiValue:(ABMultiValueRef) reference;
@end
