// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNContact implementation

#import "crossmobile_ios_contacts_CNContact.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSDateComponents.h"
#import "crossmobile_ios_foundation_NSPredicate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_contacts_CNContact$Ext

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

// (CNContact) @property(readonly, nonatomic) CNContactType contactType;
- (int) contactType__
{
    return [super contactType];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *departmentName;
- (NSString*) departmentName__
{
    NSString* re$ult = [super departmentName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (CNContact) @property(readonly, copy, nonatomic) NSData *imageData;
- (NSData*) imageData__
{
    NSData* re$ult = [super imageData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// (CNContact) @property(readonly, copy, nonatomic) NSString *jobTitle;
- (NSString*) jobTitle__
{
    NSString* re$ult = [super jobTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *middleName;
- (NSString*) middleName__
{
    NSString* re$ult = [super middleName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(copy, nonatomic) NSString *namePrefix;
- (NSString*) namePrefix__
{
    NSString* re$ult = [super namePrefix];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *nameSuffix;
- (NSString*) nameSuffix__
{
    NSString* re$ult = [super nameSuffix];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *nickname;
- (NSString*) nickname__
{
    NSString* re$ult = [super nickname];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSDateComponents *nonGregorianBirthday;
- (NSDateComponents*) nonGregorianBirthday__
{
    NSDateComponents* re$ult = [super nonGregorianBirthday];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *note;
- (NSString*) note__
{
    NSString* re$ult = [super note];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *organizationName;
- (NSString*) organizationName__
{
    NSString* re$ult = [super organizationName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *phoneticFamilyName;
- (NSString*) phoneticFamilyName__
{
    NSString* re$ult = [super phoneticFamilyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNContact) @property(readonly, copy, nonatomic) NSString *phoneticGivenName;
- (NSString*) phoneticGivenName__
{
    NSString* re$ult = [super phoneticGivenName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation CNContact (cm_crossmobile_ios_contacts_CNContact)

// direct binding of: + (NSPredicate *)predicateForContactsMatchingName:(NSString *)name;
+ (NSPredicate*) predicateForContactsMatchingName___java_lang_String:(NSString*) name 
{
    NSPredicate* re$ult = [CNContact predicateForContactsMatchingName:(name == JAVA_NULL ? nil : name)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSDate *birthday;
- (NSDate*) birthday__
{
    NSDate* re$ult = [self birthday];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNContactRelation *> *> *contactRelations;
- (NSArray*) contactRelations__
{
    NSArray* re$ult = [self contactRelations];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) CNContactType contactType;
- (int) contactType__
{
    return [self contactType];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *departmentName;
- (NSString*) departmentName__
{
    NSString* re$ult = [self departmentName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *familyName;
- (NSString*) familyName__
{
    NSString* re$ult = [self familyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSData *imageData;
- (NSData*) imageData__
{
    NSData* re$ult = [self imageData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) BOOL imageDataAvailable;
- (BOOL) imageDataAvailable__
{
    return [self imageDataAvailable];
}

// direct binding of: @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNInstantMessageAddress *> *> *instantMessageAddresses;
- (NSArray*) instantMessageAddresses__
{
    NSArray* re$ult = [self instantMessageAddresses];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *jobTitle;
- (NSString*) jobTitle__
{
    NSString* re$ult = [self jobTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *middleName;
- (NSString*) middleName__
{
    NSString* re$ult = [self middleName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy, nonatomic) NSString *namePrefix;
- (NSString*) namePrefix__
{
    NSString* re$ult = [self namePrefix];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *nameSuffix;
- (NSString*) nameSuffix__
{
    NSString* re$ult = [self nameSuffix];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *nickname;
- (NSString*) nickname__
{
    NSString* re$ult = [self nickname];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSDateComponents *nonGregorianBirthday;
- (NSDateComponents*) nonGregorianBirthday__
{
    NSDateComponents* re$ult = [self nonGregorianBirthday];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *note;
- (NSString*) note__
{
    NSString* re$ult = [self note];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *organizationName;
- (NSString*) organizationName__
{
    NSString* re$ult = [self organizationName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *phoneticFamilyName;
- (NSString*) phoneticFamilyName__
{
    NSString* re$ult = [self phoneticFamilyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *phoneticGivenName;
- (NSString*) phoneticGivenName__
{
    NSString* re$ult = [self phoneticGivenName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *phoneticMiddleName;
- (NSString*) phoneticMiddleName__
{
    NSString* re$ult = [self phoneticMiddleName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNPostalAddress *> *> *postalAddresses;
- (NSArray*) postalAddresses__
{
    NSArray* re$ult = [self postalAddresses];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *previousFamilyName;
- (NSString*) previousFamilyName__
{
    NSString* re$ult = [self previousFamilyName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNSocialProfile *> *> *socialProfiles;
- (NSArray*) socialProfiles__
{
    NSArray* re$ult = [self socialProfiles];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSData *thumbnailImageData;
- (NSData*) thumbnailImageData__
{
    NSData* re$ult = [self thumbnailImageData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSArray<CNLabeledValue<NSString *> *> *urlAddresses;
- (NSArray*) urlAddresses__
{
    NSArray* re$ult = [self urlAddresses];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
