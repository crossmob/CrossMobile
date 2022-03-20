// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNMutableContact definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSDate;
@class crossmobile_ios_foundation_NSDateComponents;
@class java_lang_String;

@interface crossmobile_ios_contacts_CNMutableContact$Ext : CNMutableContact
@end

#define crossmobile_ios_contacts_CNMutableContact CNMutableContact
@interface CNMutableContact (cm_crossmobile_ios_contacts_CNMutableContact)
- (void) setBirthday___crossmobile_ios_foundation_NSDate:(NSDate*) birthday ;
- (void) setContactType___int:(int) contactType ;
- (void) setDepartmentName___java_lang_String:(NSString*) departmentName ;
- (void) setFamilyName___java_lang_String:(NSString*) familyName ;
- (void) setImageData___crossmobile_ios_foundation_NSData:(NSData*) imageData ;
- (void) setImageDataAvailable___boolean:(BOOL) imageDataAvailable ;
- (void) setJobTitle___java_lang_String:(NSString*) jobTitle ;
- (void) setMiddleName___java_lang_String:(NSString*) middleName ;
- (void) setNamePrefix___java_lang_String:(NSString*) namePrefix ;
- (void) setNameSuffix___java_lang_String:(NSString*) nameSuffix ;
- (void) setNickname___java_lang_String:(NSString*) nickname ;
- (void) setNonGregorianBirthday___crossmobile_ios_foundation_NSDateComponents:(NSDateComponents*) nonGregorianBirthday ;
- (void) setNote___java_lang_String:(NSString*) note ;
- (void) setOrganizationName___java_lang_String:(NSString*) organizationName ;
- (void) setPhoneticFamilyName___java_lang_String:(NSString*) phoneticFamilyName ;
- (void) setPhoneticGivenName___java_lang_String:(NSString*) phoneticGivenName ;
- (void) setPhoneticMiddleName___java_lang_String:(NSString*) phoneticMiddleName ;
- (void) setPreviousFamilyName___java_lang_String:(NSString*) previousFamilyName ;
- (void) setThumbnailImageData___crossmobile_ios_foundation_NSData:(NSData*) thumbnailImageData ;
@end
