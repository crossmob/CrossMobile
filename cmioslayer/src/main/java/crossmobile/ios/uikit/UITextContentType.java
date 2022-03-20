/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UITextContentType {
    public final static String Name = "name";
    public final static String NamePrefix = "honorifix-prefix";
    public final static String GivenName = "given-name";
    public final static String MiddleName = "additional-name";
    public final static String FamilyName = "family-name";
    public final static String NameSuffix = "honorifix-suffix";
    public final static String Nickname = "nickname";
    public final static String JobTitle = "organization-title";
    public final static String OrganizationName = "organization";
    public final static String Location = "location";
    public final static String FullStreetAddress = "street-address";
    public final static String StreetAddressLine1 = "address-line1";
    public final static String StreetAddressLine2 = "address-line2";
    public final static String AddressCity = "address-level2";
    public final static String AddressState = "address-level1";
    public final static String AddressCityAndState = "address-level1+2";
    public final static String Sublocality = "address-level3";
    public final static String CountryName = "country-name";
    public final static String PostalCode = "postal-code";
    public final static String TelephoneNumber = "tel";
    public final static String EmailAddress = "email";
    public final static String URL = "url";
    public final static String CreditCardNumber = "cc-number";
    public final static String Username = "username";
    public final static String Password = "password";
    private UITextContentType() {

    }
}
