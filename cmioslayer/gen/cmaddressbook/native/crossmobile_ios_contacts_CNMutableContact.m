// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNMutableContact implementation

#import "crossmobile_ios_contacts_CNMutableContact.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSDateComponents.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNMutableContact$Ext

@end

@implementation CNMutableContact (cm_crossmobile_ios_contacts_CNMutableContact)

// @property(copy, nonatomic) NSDate *birthday;
- (void) setBirthday___crossmobile_ios_foundation_NSDate:(NSDate*) birthday 
{
    [self setBirthday:(birthday == JAVA_NULL ? nil : birthday)];
}

// @property(nonatomic) CNContactType contactType;
- (void) setContactType___int:(int) contactType 
{
    [self setContactType:contactType];
}

// @property(copy, nonatomic) NSString *departmentName;
- (void) setDepartmentName___java_lang_String:(NSString*) departmentName 
{
    [self setDepartmentName:(departmentName == JAVA_NULL ? nil : departmentName)];
}

// @property(copy, nonatomic) NSString *familyName;
- (void) setFamilyName___java_lang_String:(NSString*) familyName 
{
    [self setFamilyName:(familyName == JAVA_NULL ? nil : familyName)];
}

// @property(copy, nonatomic) NSData *imageData;
- (void) setImageData___crossmobile_ios_foundation_NSData:(NSData*) imageData 
{
    [self setImageData:(imageData == JAVA_NULL ? nil : imageData)];
}

// @property(copy, nonatomic) BOOL imageDataAvailable;;
- (void) setImageDataAvailable___boolean:(BOOL) imageDataAvailable 
{
    [self setImageDataAvailable:imageDataAvailable];
}

// @property(copy, nonatomic) NSString *jobTitle;
- (void) setJobTitle___java_lang_String:(NSString*) jobTitle 
{
    [self setJobTitle:(jobTitle == JAVA_NULL ? nil : jobTitle)];
}

// @property(copy, nonatomic) NSString *middleName;
- (void) setMiddleName___java_lang_String:(NSString*) middleName 
{
    [self setMiddleName:(middleName == JAVA_NULL ? nil : middleName)];
}

// @property(copy, nonatomic) NSString *namePrefix;
- (void) setNamePrefix___java_lang_String:(NSString*) namePrefix 
{
    [self setNamePrefix:(namePrefix == JAVA_NULL ? nil : namePrefix)];
}

// @property(copy, nonatomic) NSString *nameSuffix;
- (void) setNameSuffix___java_lang_String:(NSString*) nameSuffix 
{
    [self setNameSuffix:(nameSuffix == JAVA_NULL ? nil : nameSuffix)];
}

// @property(copy, nonatomic) NSString *nickname;
- (void) setNickname___java_lang_String:(NSString*) nickname 
{
    [self setNickname:(nickname == JAVA_NULL ? nil : nickname)];
}

// @property(copy, nonatomic) NSDateComponents *nonGregorianBirthday;
- (void) setNonGregorianBirthday___crossmobile_ios_foundation_NSDateComponents:(NSDateComponents*) nonGregorianBirthday 
{
    [self setNonGregorianBirthday:(nonGregorianBirthday == JAVA_NULL ? nil : nonGregorianBirthday)];
}

// @property(copy, nonatomic) NSString *note;
- (void) setNote___java_lang_String:(NSString*) note 
{
    [self setNote:(note == JAVA_NULL ? nil : note)];
}

// @property(copy, nonatomic) NSString *organizationName;
- (void) setOrganizationName___java_lang_String:(NSString*) organizationName 
{
    [self setOrganizationName:(organizationName == JAVA_NULL ? nil : organizationName)];
}

// @property(copy, nonatomic) NSString *phoneticFamilyName;
- (void) setPhoneticFamilyName___java_lang_String:(NSString*) phoneticFamilyName 
{
    [self setPhoneticFamilyName:(phoneticFamilyName == JAVA_NULL ? nil : phoneticFamilyName)];
}

// @property(copy, nonatomic) NSString *phoneticGivenName;
- (void) setPhoneticGivenName___java_lang_String:(NSString*) phoneticGivenName 
{
    [self setPhoneticGivenName:(phoneticGivenName == JAVA_NULL ? nil : phoneticGivenName)];
}

// @property(copy, nonatomic) NSString *phoneticMiddleName;
- (void) setPhoneticMiddleName___java_lang_String:(NSString*) phoneticMiddleName 
{
    [self setPhoneticMiddleName:(phoneticMiddleName == JAVA_NULL ? nil : phoneticMiddleName)];
}

// @property(copy, nonatomic) NSString *previousFamilyName;
- (void) setPreviousFamilyName___java_lang_String:(NSString*) previousFamilyName 
{
    [self setPreviousFamilyName:(previousFamilyName == JAVA_NULL ? nil : previousFamilyName)];
}

// @property(copy, nonatomic) NSData *thumbnailImageData;
- (void) setThumbnailImageData___crossmobile_ios_foundation_NSData:(NSData*) thumbnailImageData 
{
    [self setThumbnailImageData:(thumbnailImageData == JAVA_NULL ? nil : thumbnailImageData)];
}

@end
