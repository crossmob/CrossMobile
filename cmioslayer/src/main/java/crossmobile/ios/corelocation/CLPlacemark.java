/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.corelocation;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import crossmobile.ios.foundation.NSTimeZone;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;

import java.util.List;
import java.util.Map;

/**
 * CLPlacemark class defines an object that stores and handles data related to a
 * place mark such as country, state and city.
 */
@CMClass
public class CLPlacemark extends NSObject implements NSSecureCoding {

    private final Map<String, Object> addressDictionary;
    private final String thoroughfare;
    private final String subThoroughfare;
    private final String locality;
    private final String subLocality;
    private final String administrativeArea;
    private final String subAdministrativeArea;
    private final String postalCode;
    private final String country;
    private final String ISOcountryCode;
    private final CLRegion region;
    private final NSTimeZone timeZone;
    private final String inlandWater;
    private final String ocean;
    private final List<String> areasOfInterest;
    private final CLLocation location;

    protected CLPlacemark() {
        this.location = null;
        this.addressDictionary = null;
        this.thoroughfare = "";
        this.subThoroughfare = "";
        this.locality = "";
        this.subLocality = "";
        this.administrativeArea = "";
        this.subAdministrativeArea = "";
        this.postalCode = "";
        this.country = "";
        this.ISOcountryCode = "";
        this.region = null;
        this.timeZone = null;
        this.inlandWater = "";
        this.ocean = "";
        this.areasOfInterest = null;
    }

    /**
     * Constructs a new CLPlacemark based on the specified object.
     *
     * @param placemark The CLPlacemark object that is used as a source for new
     *                  one.
     */
    @CMConstructor("- (instancetype)initWithPlacemark:(CLPlacemark *)placemark;")
    public CLPlacemark(CLPlacemark placemark) {
        this.location = placemark.location();
        this.addressDictionary = placemark.addressDictionary();
        this.thoroughfare = placemark.thoroughfare();
        this.subThoroughfare = placemark.subThoroughfare();
        this.locality = placemark.locality();
        this.subLocality = placemark.subLocality();
        this.administrativeArea = placemark.administrativeArea();
        this.subAdministrativeArea = placemark.subAdministrativeArea();
        this.postalCode = placemark.postalCode();
        this.country = placemark.country();
        this.ISOcountryCode = placemark.ISOcountryCode();
        this.region = placemark.region();
        this.timeZone = placemark.timeZone();
        this.inlandWater = placemark.inlandWater();
        this.ocean = placemark.ocean();
        this.areasOfInterest = placemark.areasOfInterest();
    }

    /**
     * Returns a dictionary with keys and values of the address book of this
     * place mark.
     *
     * @return A dictionary with keys and values of the address book of this
     * place mark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSDictionary *addressDictionary")
    public Map<String, Object> addressDictionary() {
        return addressDictionary;
    }

    /**
     * Returns the state or the province of the place mark.
     *
     * @return The state or the province of the place mark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *administrativeArea")
    public String administrativeArea() {
        return administrativeArea;
    }

    /**
     * Returns the country of the place mark.
     *
     * @return The country of the place mark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *country")
    public String country() {
        return country;
    }

    /**
     * Returns the city of the place mark.
     *
     * @return The city of the place mark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *locality")
    public String locality() {
        return locality;
    }

    /**
     * Returns the postal code of the place mark.
     *
     * @return The postal code of the place mark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *postalCode")
    public String postalCode() {
        return postalCode;
    }

    /**
     * Returns additional information related to the administrative area of the
     * place mark.
     *
     * @return Additional information related to the administrative area of the
     * place mark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *subAdministrativeArea")
    public String subAdministrativeArea() {
        return subAdministrativeArea;
    }

    /**
     * Returns additional information related to the city of the place mark.
     *
     * @return Additional information related to the city of the place mark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *subLocality")
    public String subLocality() {
        return subLocality;
    }

    /**
     * Returns additional information related to the address of the place mark.
     *
     * @return Additional information related to the address of the place mark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *subThoroughfare")
    public String subThoroughfare() {
        return subThoroughfare;
    }

    /**
     * Returns the address of the place mark.
     *
     * @return The address of the place mark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *thoroughfare")
    public String thoroughfare() {
        return thoroughfare;
    }

    /**
     * Returns the abbreviated name of the country related to this CLPlacemark.
     *
     * @return The abbreviated name of the country related to this CLPlacemark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *ISOcountryCode")
    public String ISOcountryCode() {
        return ISOcountryCode;
    }

    /**
     * Returns the geographic region related to this CLPlacemark.
     *
     * @return The geographic region related to this CLPlacemark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) CLRegion *region")
    public CLRegion region() {
        return region;
    }

    /**
     * Returns the time zone related to this CLPlacemark.
     *
     * @return The time zone related to this CLPlacemark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSTimeZone *timeZone")
    public NSTimeZone timeZone() {
        return timeZone;
    }

    /**
     * Returns the name of a lake, a river or other inland water related to this
     * CLPlacemark.
     *
     * @return The name of a lake, a river or other inland water related to this
     * CLPlacemark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *inlandWater")
    public String inlandWater() {
        return inlandWater;
    }

    /**
     * Returns the name of the ocean related to this CLPlacemark.
     *
     * @return The name of the ocean related to this CLPlacemark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *ocean")
    public String ocean() {
        return ocean;
    }

    /**
     * Returns a list of areas of interest related to this CLPlacemark.
     *
     * @return A list of areas of interest related to this CLPlacemark.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSArray <NSString *> *areasOfInterest")
    public List<String> areasOfInterest() {
        return areasOfInterest;
    }

    /**
     * Returns a CLLocation object that contains latitude and longitude
     * information.
     *
     * @return A CLLocation object that contains latitude and longitude
     * information.
     */
    @CMGetter("@property(nonatomic, readonly, copy) CLLocation *location")
    public CLLocation location() {
        return location;
    }

}
