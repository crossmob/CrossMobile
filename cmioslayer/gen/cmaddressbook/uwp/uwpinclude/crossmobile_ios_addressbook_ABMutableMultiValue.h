// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABMutableMultiValue definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
#import "crossmobile_ios_addressbook_ABMultiValue.h"
@class crossmobile_ios_foundation_CFType;
@class java_lang_Object;
@class java_lang_String;

CM_EXPORT_CLASS
@interface crossmobile_ios_addressbook_ABMutableMultiValue : crossmobile_ios_addressbook_ABMultiValue
- (crossmobile_ios_addressbook_ABMutableMultiValue*) __init_crossmobile_ios_addressbook_ABMutableMultiValue___int:(int) type ;
- (BOOL) addValueAndLabel___crossmobile_ios_foundation_CFType_java_lang_String_int_ARRAYTYPE:(crossmobile_ios_foundation_CFType*) value :(NSString*) label :(XMLVMArray*) outIdentifier ;
- (BOOL) insertValueAndLabelAtIndex___crossmobile_ios_foundation_CFType_java_lang_String_long_int_ARRAYTYPE:(crossmobile_ios_foundation_CFType*) value :(NSString*) label :(JAVA_LONG) index :(XMLVMArray*) outIdentifier ;
- (BOOL) removeValueAndLabelAtIndex___long:(JAVA_LONG) index ;
- (BOOL) replaceLabelAtIndex___java_lang_String_long:(NSString*) label :(JAVA_LONG) index ;
- (BOOL) replaceValueAtIndex___crossmobile_ios_foundation_CFType_long:(crossmobile_ios_foundation_CFType*) value :(JAVA_LONG) index ;
- (instancetype) initWithABMutableMultiValue:(ABMutableMultiValueRef) reference;
@end
