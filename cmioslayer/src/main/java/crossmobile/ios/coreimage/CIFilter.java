/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coreimage;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.HashMap;
import java.util.Map;

/**
 * CIFilter class defines an object that uses input values as data(as images)
 * and produces images(data).
 */
@CMClass
public class CIFilter extends NSObject implements NSSecureCoding {

    private final Map<String, Object> attributes;

    /**
     * Constructs and returns a CIFilter object for the specified filter.
     *
     * @param name The name of the filter.
     * @return A CIFilter object.
     */
    @CMSelector("+ (CIFilter *)filterWithName:(NSString *)name;")
    public static CIFilter filterWithName(String name) {
        return null;
    }

    /**
     * Constructs and returns a CIFilter object using the specified data and
     * options.
     *
     * @param data    The image data to initialize the CIFilter object.
     * @param options A options dictionary.
     * @return A CIFilter object.
     */
    @CMSelector("+ (CIFilter *)filterWithImageData:(NSData *)data \n"
            + " options:(NSDictionary *)options;")
    public static CIFilter filterWithImageData(NSData data, Map<String, Object> options) {
        return null;
    }

    private CIFilter(Map<String, Object> options) {
        this.attributes = options == null ? new HashMap<>() : options;
    }

    /**
     * Returns the CIImage object for this filter.
     *
     * @return The CIImage object that is the result of applying this CIFilter.
     */
    @CMGetter("@property(readonly, nonatomic) CIImage *outputImage;")
    public CIImage outputImage() {
        return null;
    }

    /**
     * Returns a dictionary with values that describe the filter.
     *
     * @return The dictionary with values that describe the filter.
     */
    @CMGetter("@property(nonatomic, readonly) NSDictionary<NSString *,id> *attributes;")
    public Map<String, Object> attributes() {
        return attributes;
    }

}
