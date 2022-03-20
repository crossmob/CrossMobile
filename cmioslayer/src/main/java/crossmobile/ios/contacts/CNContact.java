/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.*;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;

@CMClass
public class CNContact extends NSObject {

    public final static String NamePrefixKey = "namePrefix";
    public final static String GivenNameKey = "givenName";
    public final static String MiddleNameKey = "middleName";
    public final static String FamilyNameKey = "familyName";
    public final static String PreviousFamilyNameKey = "previousFamilyName";
    public final static String NameSuffixKey = "nameSuffix";
    public final static String NicknameKey = "nickname";
    public final static String PhoneticGivenNameKey = "phoneticGivenName";
    public final static String PhoneticMiddleNameKey = "phoneticMiddleName";
    public final static String PhoneticFamilyNameKey = "phoneticFamilyName";
    public final static String OrganizationNameKey = "organizationName";
    public final static String DepartmentNameKey = "departmentName";
    public final static String JobTitleKey = "jobTitle";
    public final static String BirthdayKey = "birthday";
    public final static String NonGregorianBirthdayKey = "nonGregorianBirthday";
    public final static String NoteKey = "note";
    public final static String ImageDataKey = "imageData";
    public final static String ThumbnailImageDataKey = "thumbnailImageData";
    public final static String ImageDataAvailableKey = "imageDataAvailable";
    public final static String TypeKey = "contactType";
    public final static String PhoneNumbersKey = "phoneNumbers";
    public final static String EmailAddressesKey = "emailAddresses";
    public final static String PostalAddressesKey = "postalAddresses";
    public final static String DatesKey = "dates";
    public final static String UrlAddressesKey = "urlAddresses";
    public final static String RelationsKey = "contactRelations";
    public final static String SocialProfilesKey = "socialProfiles";
    public final static String InstantMessageAddressesKey = "instantMessageAddresses";

    String identifier;
    int contactType;
    String middleName;
    String familyName;
    String previousFamilyName;
    String nameSuffix;
    String nickname;
    String phoneticGivenName;
    String phoneticMiddleName;
    String phoneticFamilyName;
    String organizationName;
    String departmentName;
    String jobTitle;

    String namePrefix;
    String givenName;

    List<CNLabeledValue<CNPhoneNumber>> phoneNumbers;

    List<CNLabeledValue<CNSocialProfile>> socialProfiles;
    List<CNLabeledValue<String>> urlAddresses;
    List<CNLabeledValue<CNPostalAddress>> postalAddresses;
    List<CNLabeledValue<CNContactRelation>> contactRelations;
    List<CNLabeledValue<CNInstantMessageAddress>> instantMessageAddresses;

    String note;
    NSData imageData;
    NSData thumbnailImageData;
    boolean imageDataAvailable;

    NSDate birthday;
    NSDateComponents nonGregorianBirthday;

    CNContact() {
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNSocialProfile *> *> *socialProfiles;")
    public List<CNLabeledValue<CNSocialProfile>> socialProfiles() {
        return this.socialProfiles;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSArray<CNLabeledValue<NSString *> *> *urlAddresses;")
    public List<CNLabeledValue<String>> urlAddresses() {
        return this.urlAddresses;

    }

    @CMGetter("@property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNPostalAddress *> *> *postalAddresses;")
    public List<CNLabeledValue<CNPostalAddress>> postalAddresses() {
        return this.postalAddresses;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNContactRelation *> *> *contactRelations;")
    public List<CNLabeledValue<CNContactRelation>> contactRelations() {
        return this.contactRelations;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSArray<CNLabeledValue<CNInstantMessageAddress *> *> *instantMessageAddresses;")
    public List<CNLabeledValue<CNInstantMessageAddress>> instantMessageAddresses() {
        return this.instantMessageAddresses;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSDate *birthday;")
    public NSDate birthday() {
        return birthday;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSDateComponents *nonGregorianBirthday;")
    public NSDateComponents nonGregorianBirthday() {
        return nonGregorianBirthday;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *identifier;")
    public String identifier() {
        return identifier;
    }

    @CMGetter("@property(readonly, nonatomic) CNContactType contactType;")
    public int contactType() {
        return contactType;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *middleName;")
    public String middleName() {
        return middleName;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *familyName;")
    public String familyName() {
        return familyName;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *previousFamilyName;")
    public String previousFamilyName() {
        return previousFamilyName;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *nameSuffix;")
    public String nameSuffix() {
        return nameSuffix;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *nickname;")
    public String nickname() {
        return nickname;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *phoneticGivenName;")
    public String phoneticGivenName() {
        return phoneticGivenName;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *phoneticMiddleName;")
    public String phoneticMiddleName() {
        return phoneticMiddleName;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *phoneticFamilyName;")
    public String phoneticFamilyName() {
        return phoneticFamilyName;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *organizationName;")
    public String organizationName() {
        return organizationName;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *departmentName;")
    public String departmentName() {
        return departmentName;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *jobTitle;")
    public String jobTitle() {
        return jobTitle;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *note;")
    public String note() {
        return note;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSData *imageData;")
    public NSData imageData() {
        return imageData;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSData *thumbnailImageData;")
    public NSData thumbnailImageData() {
        return thumbnailImageData;
    }

    @CMGetter("@property(readonly, nonatomic) BOOL imageDataAvailable;")
    public boolean imageDataAvailable() {
        return imageDataAvailable;
    }

    /**
     * The name prefix of this contact
     * @return The value of the name prefix
     */
    @CMGetter("@property(copy, nonatomic) NSString *namePrefix;")
    public String namePrefix() {
        return namePrefix;
    }

    @CMSelector("+ (NSPredicate *)predicateForContactsMatchingName:(NSString *)name;")
    public static NSPredicate predicateForContactsMatchingName(String name) {
        return new NSPredicate();
    }

}
