// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContact implementation

#import "crossmobile_ios_contacts_CNContact.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSDateComponents.h"
#import "crossmobile_ios_foundation_NSPredicate.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_contacts_CNContact$Ext

@end

@implementation CNContact (cm_crossmobile_ios_contacts_CNContact)

// + (NSPredicate *)predicateForContactsMatchingName:(NSString *)name;
+ (NSPredicate*) predicateForContactsMatchingName___java_lang_String:(NSString*) name 
{
    NSPredicate* re$ult = [CNContact predicateForContactsMatchingName:(name == JAVA_NULL ? nil : name)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSDate *birthday;
- (NSDate*) birthday__
{
    NSDate* re$ult = [self birthday];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNContactRelation *> *> *contactRelations;
- (NSArray*) contactRelations__
{
    NSArray* re$ult = [self contactRelations];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) CNContactType contactType;
- (int) contactType__
{
    return [self contactType];
}

// @property(readonly, copy, nonatomic) NSString *departmentName;
- (NSString*) departmentName__
{
    NSString* re$ult = [self departmentName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *familyName;
- (NSString*) familyName__
{
    NSString* re$ult = [self familyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSData *imageData;
- (NSData*) imageData__
{
    NSData* re$ult = [self imageData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) BOOL imageDataAvailable;
- (BOOL) imageDataAvailable__
{
    return [self imageDataAvailable];
}

// @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNInstantMessageAddress *> *> *instantMessageAddresses;
- (NSArray*) instantMessageAddresses__
{
    NSArray* re$ult = [self instantMessageAddresses];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *jobTitle;
- (NSString*) jobTitle__
{
    NSString* re$ult = [self jobTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *middleName;
- (NSString*) middleName__
{
    NSString* re$ult = [self middleName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy, nonatomic) NSString *namePrefix;
- (NSString*) namePrefix__
{
    NSString* re$ult = [self namePrefix];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *nameSuffix;
- (NSString*) nameSuffix__
{
    NSString* re$ult = [self nameSuffix];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *nickname;
- (NSString*) nickname__
{
    NSString* re$ult = [self nickname];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSDateComponents *nonGregorianBirthday;
- (NSDateComponents*) nonGregorianBirthday__
{
    NSDateComponents* re$ult = [self nonGregorianBirthday];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *note;
- (NSString*) note__
{
    NSString* re$ult = [self note];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *organizationName;
- (NSString*) organizationName__
{
    NSString* re$ult = [self organizationName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *phoneticFamilyName;
- (NSString*) phoneticFamilyName__
{
    NSString* re$ult = [self phoneticFamilyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *phoneticGivenName;
- (NSString*) phoneticGivenName__
{
    NSString* re$ult = [self phoneticGivenName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *phoneticMiddleName;
- (NSString*) phoneticMiddleName__
{
    NSString* re$ult = [self phoneticMiddleName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNPostalAddress *> *> *postalAddresses;
- (NSArray*) postalAddresses__
{
    NSArray* re$ult = [self postalAddresses];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *previousFamilyName;
- (NSString*) previousFamilyName__
{
    NSString* re$ult = [self previousFamilyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNSocialProfile *> *> *socialProfiles;
- (NSArray*) socialProfiles__
{
    NSArray* re$ult = [self socialProfiles];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSData *thumbnailImageData;
- (NSData*) thumbnailImageData__
{
    NSData* re$ult = [self thumbnailImageData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<NSString *> *> *urlAddresses;
- (NSArray*) urlAddresses__
{
    NSArray* re$ult = [self urlAddresses];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
