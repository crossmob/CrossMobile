// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNMutableContact implementation

#import "crossmobile_ios_contacts_CNMutableContact.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSDateComponents.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_contacts_CNMutableContact$Ext

// (CNMutableContact) @property(copy, nonatomic) NSDate *birthday;
- (void) setBirthday___crossmobile_ios_foundation_NSDate:(NSDate*) birthday 
{
    [super setBirthday:(birthday == JAVA_NULL ? nil : birthday)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSDate *birthday;
- (NSDate*) birthday__
{
    NSDate* re$ult = [super birthday];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNContactRelation *> *> *contactRelations;
- (NSArray*) contactRelations__
{
    NSArray* re$ult = [super contactRelations];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(nonatomic) CNContactType contactType;
- (void) setContactType___int:(int) contactType 
{
    [super setContactType:contactType];
}

// (CNContact) @property(readonly, nonatomic) CNContactType contactType;
- (int) contactType__
{
    return [super contactType];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *departmentName;
- (void) setDepartmentName___java_lang_String:(NSString*) departmentName 
{
    [super setDepartmentName:(departmentName == JAVA_NULL ? nil : departmentName)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *departmentName;
- (NSString*) departmentName__
{
    NSString* re$ult = [super departmentName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *familyName;
- (void) setFamilyName___java_lang_String:(NSString*) familyName 
{
    [super setFamilyName:(familyName == JAVA_NULL ? nil : familyName)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *familyName;
- (NSString*) familyName__
{
    NSString* re$ult = [super familyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSData *imageData;
- (void) setImageData___crossmobile_ios_foundation_NSData:(NSData*) imageData 
{
    [super setImageData:(imageData == JAVA_NULL ? nil : imageData)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSData *imageData;
- (NSData*) imageData__
{
    NSData* re$ult = [super imageData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) BOOL imageDataAvailable;;
- (void) setImageDataAvailable___boolean:(BOOL) imageDataAvailable 
{
    [super setImageDataAvailable:imageDataAvailable];
}

// (CNContact) @property(readonly, nonatomic) BOOL imageDataAvailable;
- (BOOL) imageDataAvailable__
{
    return [super imageDataAvailable];
}

// (CNContact) @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNInstantMessageAddress *> *> *instantMessageAddresses;
- (NSArray*) instantMessageAddresses__
{
    NSArray* re$ult = [super instantMessageAddresses];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *jobTitle;
- (void) setJobTitle___java_lang_String:(NSString*) jobTitle 
{
    [super setJobTitle:(jobTitle == JAVA_NULL ? nil : jobTitle)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *jobTitle;
- (NSString*) jobTitle__
{
    NSString* re$ult = [super jobTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *middleName;
- (void) setMiddleName___java_lang_String:(NSString*) middleName 
{
    [super setMiddleName:(middleName == JAVA_NULL ? nil : middleName)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *middleName;
- (NSString*) middleName__
{
    NSString* re$ult = [super middleName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *namePrefix;
- (void) setNamePrefix___java_lang_String:(NSString*) namePrefix 
{
    [super setNamePrefix:(namePrefix == JAVA_NULL ? nil : namePrefix)];
}

// (CNContact) @property(copy, nonatomic) NSString *namePrefix;
- (NSString*) namePrefix__
{
    NSString* re$ult = [super namePrefix];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *nameSuffix;
- (void) setNameSuffix___java_lang_String:(NSString*) nameSuffix 
{
    [super setNameSuffix:(nameSuffix == JAVA_NULL ? nil : nameSuffix)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *nameSuffix;
- (NSString*) nameSuffix__
{
    NSString* re$ult = [super nameSuffix];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *nickname;
- (void) setNickname___java_lang_String:(NSString*) nickname 
{
    [super setNickname:(nickname == JAVA_NULL ? nil : nickname)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *nickname;
- (NSString*) nickname__
{
    NSString* re$ult = [super nickname];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSDateComponents *nonGregorianBirthday;
- (void) setNonGregorianBirthday___crossmobile_ios_foundation_NSDateComponents:(NSDateComponents*) nonGregorianBirthday 
{
    [super setNonGregorianBirthday:(nonGregorianBirthday == JAVA_NULL ? nil : nonGregorianBirthday)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSDateComponents *nonGregorianBirthday;
- (NSDateComponents*) nonGregorianBirthday__
{
    NSDateComponents* re$ult = [super nonGregorianBirthday];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *note;
- (void) setNote___java_lang_String:(NSString*) note 
{
    [super setNote:(note == JAVA_NULL ? nil : note)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *note;
- (NSString*) note__
{
    NSString* re$ult = [super note];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *organizationName;
- (void) setOrganizationName___java_lang_String:(NSString*) organizationName 
{
    [super setOrganizationName:(organizationName == JAVA_NULL ? nil : organizationName)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *organizationName;
- (NSString*) organizationName__
{
    NSString* re$ult = [super organizationName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *phoneticFamilyName;
- (void) setPhoneticFamilyName___java_lang_String:(NSString*) phoneticFamilyName 
{
    [super setPhoneticFamilyName:(phoneticFamilyName == JAVA_NULL ? nil : phoneticFamilyName)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *phoneticFamilyName;
- (NSString*) phoneticFamilyName__
{
    NSString* re$ult = [super phoneticFamilyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *phoneticGivenName;
- (void) setPhoneticGivenName___java_lang_String:(NSString*) phoneticGivenName 
{
    [super setPhoneticGivenName:(phoneticGivenName == JAVA_NULL ? nil : phoneticGivenName)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *phoneticGivenName;
- (NSString*) phoneticGivenName__
{
    NSString* re$ult = [super phoneticGivenName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *phoneticMiddleName;
- (void) setPhoneticMiddleName___java_lang_String:(NSString*) phoneticMiddleName 
{
    [super setPhoneticMiddleName:(phoneticMiddleName == JAVA_NULL ? nil : phoneticMiddleName)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *phoneticMiddleName;
- (NSString*) phoneticMiddleName__
{
    NSString* re$ult = [super phoneticMiddleName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNPostalAddress *> *> *postalAddresses;
- (NSArray*) postalAddresses__
{
    NSArray* re$ult = [super postalAddresses];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSString *previousFamilyName;
- (void) setPreviousFamilyName___java_lang_String:(NSString*) previousFamilyName 
{
    [super setPreviousFamilyName:(previousFamilyName == JAVA_NULL ? nil : previousFamilyName)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *previousFamilyName;
- (NSString*) previousFamilyName__
{
    NSString* re$ult = [super previousFamilyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNSocialProfile *> *> *socialProfiles;
- (NSArray*) socialProfiles__
{
    NSArray* re$ult = [super socialProfiles];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNMutableContact) @property(copy, nonatomic) NSData *thumbnailImageData;
- (void) setThumbnailImageData___crossmobile_ios_foundation_NSData:(NSData*) thumbnailImageData 
{
    [super setThumbnailImageData:(thumbnailImageData == JAVA_NULL ? nil : thumbnailImageData)];
}

// (CNContact) @property(readonly, copy, nonatomic) NSData *thumbnailImageData;
- (NSData*) thumbnailImageData__
{
    NSData* re$ult = [super thumbnailImageData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<NSString *> *> *urlAddresses;
- (NSArray*) urlAddresses__
{
    NSArray* re$ult = [super urlAddresses];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation CNMutableContact (cm_crossmobile_ios_contacts_CNMutableContact)

// direct binding of: @property(copy, nonatomic) NSDate *birthday;
- (void) setBirthday___crossmobile_ios_foundation_NSDate:(NSDate*) birthday 
{
    [self setBirthday:(birthday == JAVA_NULL ? nil : birthday)];
}

// direct binding of: @property(nonatomic) CNContactType contactType;
- (void) setContactType___int:(int) contactType 
{
    [self setContactType:contactType];
}

// direct binding of: @property(copy, nonatomic) NSString *departmentName;
- (void) setDepartmentName___java_lang_String:(NSString*) departmentName 
{
    [self setDepartmentName:(departmentName == JAVA_NULL ? nil : departmentName)];
}

// direct binding of: @property(copy, nonatomic) NSString *familyName;
- (void) setFamilyName___java_lang_String:(NSString*) familyName 
{
    [self setFamilyName:(familyName == JAVA_NULL ? nil : familyName)];
}

// direct binding of: @property(copy, nonatomic) NSData *imageData;
- (void) setImageData___crossmobile_ios_foundation_NSData:(NSData*) imageData 
{
    [self setImageData:(imageData == JAVA_NULL ? nil : imageData)];
}

// direct binding of: @property(copy, nonatomic) BOOL imageDataAvailable;;
- (void) setImageDataAvailable___boolean:(BOOL) imageDataAvailable 
{
    [self setImageDataAvailable:imageDataAvailable];
}

// direct binding of: @property(copy, nonatomic) NSString *jobTitle;
- (void) setJobTitle___java_lang_String:(NSString*) jobTitle 
{
    [self setJobTitle:(jobTitle == JAVA_NULL ? nil : jobTitle)];
}

// direct binding of: @property(copy, nonatomic) NSString *middleName;
- (void) setMiddleName___java_lang_String:(NSString*) middleName 
{
    [self setMiddleName:(middleName == JAVA_NULL ? nil : middleName)];
}

// direct binding of: @property(copy, nonatomic) NSString *namePrefix;
- (void) setNamePrefix___java_lang_String:(NSString*) namePrefix 
{
    [self setNamePrefix:(namePrefix == JAVA_NULL ? nil : namePrefix)];
}

// direct binding of: @property(copy, nonatomic) NSString *nameSuffix;
- (void) setNameSuffix___java_lang_String:(NSString*) nameSuffix 
{
    [self setNameSuffix:(nameSuffix == JAVA_NULL ? nil : nameSuffix)];
}

// direct binding of: @property(copy, nonatomic) NSString *nickname;
- (void) setNickname___java_lang_String:(NSString*) nickname 
{
    [self setNickname:(nickname == JAVA_NULL ? nil : nickname)];
}

// direct binding of: @property(copy, nonatomic) NSDateComponents *nonGregorianBirthday;
- (void) setNonGregorianBirthday___crossmobile_ios_foundation_NSDateComponents:(NSDateComponents*) nonGregorianBirthday 
{
    [self setNonGregorianBirthday:(nonGregorianBirthday == JAVA_NULL ? nil : nonGregorianBirthday)];
}

// direct binding of: @property(copy, nonatomic) NSString *note;
- (void) setNote___java_lang_String:(NSString*) note 
{
    [self setNote:(note == JAVA_NULL ? nil : note)];
}

// direct binding of: @property(copy, nonatomic) NSString *organizationName;
- (void) setOrganizationName___java_lang_String:(NSString*) organizationName 
{
    [self setOrganizationName:(organizationName == JAVA_NULL ? nil : organizationName)];
}

// direct binding of: @property(copy, nonatomic) NSString *phoneticFamilyName;
- (void) setPhoneticFamilyName___java_lang_String:(NSString*) phoneticFamilyName 
{
    [self setPhoneticFamilyName:(phoneticFamilyName == JAVA_NULL ? nil : phoneticFamilyName)];
}

// direct binding of: @property(copy, nonatomic) NSString *phoneticGivenName;
- (void) setPhoneticGivenName___java_lang_String:(NSString*) phoneticGivenName 
{
    [self setPhoneticGivenName:(phoneticGivenName == JAVA_NULL ? nil : phoneticGivenName)];
}

// direct binding of: @property(copy, nonatomic) NSString *phoneticMiddleName;
- (void) setPhoneticMiddleName___java_lang_String:(NSString*) phoneticMiddleName 
{
    [self setPhoneticMiddleName:(phoneticMiddleName == JAVA_NULL ? nil : phoneticMiddleName)];
}

// direct binding of: @property(copy, nonatomic) NSString *previousFamilyName;
- (void) setPreviousFamilyName___java_lang_String:(NSString*) previousFamilyName 
{
    [self setPreviousFamilyName:(previousFamilyName == JAVA_NULL ? nil : previousFamilyName)];
}

// direct binding of: @property(copy, nonatomic) NSData *thumbnailImageData;
- (void) setThumbnailImageData___crossmobile_ios_foundation_NSData:(NSData*) thumbnailImageData 
{
    [self setThumbnailImageData:(thumbnailImageData == JAVA_NULL ? nil : thumbnailImageData)];
}

@end
