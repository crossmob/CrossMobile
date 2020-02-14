/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSDateComponents;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSetter;

@CMClass
public class CNMutableContact extends CNContact {

    private CNMutableContact() {
    }

    @CMSetter("@property(nonatomic) CNContactType contactType;")
    public void setContactType(int contactType) {
        this.contactType = contactType;
    }

    @CMSetter("@property(copy, nonatomic) NSString *middleName;")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @CMSetter("@property(copy, nonatomic) NSString *familyName;")
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @CMSetter("@property(copy, nonatomic) NSString *previousFamilyName;")
    public void setPreviousFamilyName(String previousFamilyName) {
        this.previousFamilyName = previousFamilyName;
    }

    @CMSetter("@property(copy, nonatomic) NSString *nameSuffix;")
    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    @CMSetter("@property(copy, nonatomic) NSString *nickname;")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @CMSetter("@property(copy, nonatomic) NSString *phoneticGivenName;")
    public void setPhoneticGivenName(String phoneticGivenName) {
        this.phoneticGivenName = phoneticGivenName;
    }

    @CMSetter("@property(copy, nonatomic) NSString *phoneticMiddleName;")
    public void setPhoneticMiddleName(String phoneticMiddleName) {
        this.phoneticMiddleName = phoneticMiddleName;
    }

    @CMSetter("@property(copy, nonatomic) NSString *phoneticFamilyName;")
    public void setPhoneticFamilyName(String phoneticFamilyName) {
        this.phoneticFamilyName = phoneticFamilyName;
    }

    @CMSetter("@property(copy, nonatomic) NSString *organizationName;")
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @CMSetter("@property(copy, nonatomic) NSString *departmentName;")
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @CMSetter("@property(copy, nonatomic) NSString *jobTitle;")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @CMSetter("@property(copy, nonatomic) NSString *note;")
    public void setNote(String note) {
        this.note = note;
    }

    @CMSetter("@property(copy, nonatomic) NSData *imageData;")
    public void setImageData(NSData imageData) {
        this.imageData = imageData;
    }

    @CMSetter("@property(copy, nonatomic) NSData *thumbnailImageData;")
    public void setThumbnailImageData(NSData thumbnailImageData) {
        this.thumbnailImageData = thumbnailImageData;
    }

    @CMSetter("@property(copy, nonatomic) BOOL imageDataAvailable;;")
    public void setImageDataAvailable(boolean imageDataAvailable) {
        this.imageDataAvailable = imageDataAvailable;
    }

    @CMSetter("@property(copy, nonatomic) NSDate *birthday;")
    public void setBirthday(NSDate birthday) {
        this.birthday = birthday;
    }

    @CMSetter("@property(copy, nonatomic) NSDateComponents *nonGregorianBirthday;")
    public void setNonGregorianBirthday(NSDateComponents nonGregorianBirthday) {
        this.nonGregorianBirthday = nonGregorianBirthday;
    }

    @CMSetter("@property(copy, nonatomic) NSString *namePrefix;")
    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

}
