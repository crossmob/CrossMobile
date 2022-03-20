/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class CNPostalAddress extends NSObject {

    public final static String StreetKey = "";
    public final static String CityKey = "";
    public final static String StateKey = "";
    public final static String PostalCodeKey = "";
    public final static String CountryKey = "";
    public final static String ISOCountryCodeKey = "";

    public CNPostalAddress() {
    }

    String street;
    String city;
    String state;
    String postalcode;
    String country;
    String ISOCountryCode;
    String subAdministrativeArea;

    @CMGetter("@property(readonly, copy, nonatomic) NSString *city;")
    public String city() {
        return this.city;

    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *street;")
    public String street() {
        return this.street();
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *state;")
    public String state() {
        return this.state;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *postalCode;")
    public String postalCode() {
        return this.postalcode;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *country;")
    public String country() {
        return this.country;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *ISOCountryCode;")
    public String ISOCountryCode() {
        return this.ISOCountryCode;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *subAdministrativeArea;")
    public String subAdministrativeArea() {
        return this.subAdministrativeArea;
    }

}
