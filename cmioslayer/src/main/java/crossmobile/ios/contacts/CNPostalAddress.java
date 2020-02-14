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
