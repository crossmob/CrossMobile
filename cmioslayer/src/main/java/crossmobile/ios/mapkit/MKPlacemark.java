/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import crossmobile.ios.corelocation.CLPlacemark;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;

import java.util.Map;

/**
 * MKPlacemark class defines an object that represents a place mark and contains
 * related data such as address, postal code and other information that define
 * it.
 */
@CMClass
public class MKPlacemark extends CLPlacemark implements MKAnnotation {

    private final String countryCode;
    private final CLLocationCoordinate2D coordinate;
    private final Map<String, Object> addressDictionary;

    /**
     * Constructs a MKPlacement object with the specified parameters.
     *
     * @param coordinate        The coordinate of the placemark.
     * @param addressDictionary A dictionary containing keys and values from the
     *                          address book.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @CMConstructor("- (instancetype)initWithCoordinate:(CLLocationCoordinate2D)coordinate \n"
            + "                 addressDictionary:(NSDictionary<NSString *,id> *)addressDictionary;")
    public MKPlacemark(CLLocationCoordinate2D coordinate, Map addressDictionary) {
        super();
        this.coordinate = coordinate;
        this.addressDictionary = addressDictionary;
        this.countryCode = "";
    }

    /**
     * Returns the country code of the place mark.
     *
     * @return The country code of the place mark.
     */
    @CMGetter("@property(nonatomic, readonly) NSString *countryCode;")
    public String countryCode() {
        return countryCode;
    }

    @Override
    public CLLocationCoordinate2D coordinate() {
        return coordinate;
    }

    @Override
    public Map<String, Object> addressDictionary() {
        return addressDictionary;
    }

}
