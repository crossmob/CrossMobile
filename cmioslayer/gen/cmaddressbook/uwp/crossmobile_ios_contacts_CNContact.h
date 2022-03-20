// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContact definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSDate;
@class crossmobile_ios_foundation_NSDateComponents;
@class crossmobile_ios_foundation_NSPredicate;
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_contacts_CNContact$Ext : CNContact
@end

#define crossmobile_ios_contacts_CNContact CNContact
@interface CNContact (cm_crossmobile_ios_contacts_CNContact)
+ (NSPredicate*) predicateForContactsMatchingName___java_lang_String:(NSString*) name ;
- (NSDate*) birthday__;
- (NSArray*) contactRelations__;
- (int) contactType__;
- (NSString*) departmentName__;
- (NSString*) familyName__;
- (NSString*) identifier__;
- (NSData*) imageData__;
- (BOOL) imageDataAvailable__;
- (NSArray*) instantMessageAddresses__;
- (NSString*) jobTitle__;
- (NSString*) middleName__;
- (NSString*) namePrefix__;
- (NSString*) nameSuffix__;
- (NSString*) nickname__;
- (NSDateComponents*) nonGregorianBirthday__;
- (NSString*) note__;
- (NSString*) organizationName__;
- (NSString*) phoneticFamilyName__;
- (NSString*) phoneticGivenName__;
- (NSString*) phoneticMiddleName__;
- (NSArray*) postalAddresses__;
- (NSString*) previousFamilyName__;
- (NSArray*) socialProfiles__;
- (NSData*) thumbnailImageData__;
- (NSArray*) urlAddresses__;
@end
