/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.system.JsonHelper;

import java.util.List;
import java.util.Map;

import static org.crossmobile.bind.system.AbstractLifecycleBridge.errorFromThrowable;

/**
 * NSJSONSerialization class defines methods for conversions between JSON data
 * and Foundation objects.
 */
@CMClass
public class NSJSONSerialization extends NSObject {

    /**
     * Returns a Foundation object originated from the specified JSON data.
     *
     * @param data                 A NSData object that contains the JSON data.
     * @param NSJSONReadingOptions The options for reading the JSON data.
     * @param error                The error that occurs in case of failure.
     * @return The final object.
     * @see crossmobile.ios.foundation.NSJSONReadingOptions
     */
    @CMSelector("+ (id)JSONObjectWithData:(NSData *)data \n"
            + "                 options:(NSJSONReadingOptions)opt \n"
            + "                   error:(NSError * _Nullable *)error;")
    public static Object JSONObjectWithData(NSData data, int NSJSONReadingOptions, StrongReference<NSError> error) {
        if (error != null)
            error.set(null);
        if (data == null || data.length() < 1)
            return null;
        try {
            return JsonHelper.decode(new String(data.data, "UTF-8").trim());
        } catch (Exception ex) {
            if (error != null)
                error.set(NSError.errorWithDomain(NSError.Domain.NSPOSIX, 0, errorFromThrowable(ex)));
            return null;
        }
    }

    /**
     * Returns the JSON data that results from specified Foundation object.
     *
     * @param source               The object to be converted Should be either
     *                             Map&lt;String,Object&gt; or List&lt;Object&gt;.
     * @param NSJSONWritingOptions The NSJSONWritingOptions option.
     * @param error                The error that describes the situation in case of failure.
     * @return The JSON data that results from the conversion.
     * @see crossmobile.ios.foundation.NSJSONWritingOptions
     */
    @CMSelector("+ (NSData *)dataWithJSONObject:(id)obj \n"
            + "                       options:(NSJSONWritingOptions)opt \n"
            + "                         error:(NSError * _Nullable *)error;")
    public static NSData dataWithJSONObject(Object source, int NSJSONWritingOptions, StrongReference<NSError> error) {
        if (error != null)
            error.set(null);
        if (source == null)
            return null;
        if (source instanceof List && ((List) source).isEmpty())
            return null;
        if (source instanceof Map && ((Map) source).isEmpty())
            return null;
        try {
            String data = JsonHelper.encode(source, (NSJSONWritingOptions & crossmobile.ios.foundation.NSJSONWritingOptions.PrettyPrinted) != 0);
            if (data == null || data.isEmpty())
                return null;
            byte[] bytes = data.getBytes("UTF-8");
            return bytes == null ? null : NSData.dataWithBytes(bytes);
        } catch (Exception ex) {
            if (error != null)
                error.set(NSError.errorWithDomain(NSError.Domain.NSPOSIX, 0, errorFromThrowable(ex)));
            return null;
        }
    }

    /**
     * Returns a Boolean that shows whether the specified object is feasible to
     * be converted to JSON data.
     *
     * @param source The object that is checked if the conversion to JSON data
     *               is feasible.
     * @return TRUE then the specified object can be converted to JSON data.
     */
    @CMSelector("+ (BOOL)isValidJSONObject:(id)obj;")
    public static boolean isValidJSONObject(Object source) {
        return source instanceof Map || source instanceof List;
    }
}
