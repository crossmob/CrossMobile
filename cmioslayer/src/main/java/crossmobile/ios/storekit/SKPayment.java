/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.storekit;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * SKPayment class defines an object that represents the payment process of App
 * Store's items provided by the application.
 */
@CMClass
public class SKPayment extends NSObject {

    String productIdentifier;
    int quantity;
    NSData requestData;

    SKPayment(String productIdentifier, int quantity, NSData requestData) {
        this.productIdentifier = productIdentifier;
        this.quantity = quantity;
        this.requestData = requestData;
    }

    /**
     * Returns a new SKPayment object for the specified product.
     *
     * @param product The id of product.
     * @return The new SKPayment object.
     */
    @CMSelector("+ (instancetype)paymentWithProduct:(SKProduct *)product;\n"
            + "")
    public static SKPayment paymentWithProduct(SKProduct product) {
        return new SKPayment(product.productIdentifier(), 1, null);
    }

    /**
     * Returns a String that identifies the product that is purchased.
     *
     * @return The id of the product that is purchased.
     */
    @CMGetter("@property(nonatomic, copy, readonly) NSString *productIdentifier;")
    public String productIdentifier() {
        return productIdentifier;
    }

    /**
     * Returns the number of requested items.
     *
     * @return The number of requested items.
     */
    @CMGetter("@property(nonatomic, readonly) NSInteger quantity;")
    public int quantity() {
        return quantity;
    }

    /**
     * Returns special data that will be used in the future.
     *
     * @return Special data that will be used in the future.
     */
    @CMGetter("@property(nonatomic, copy, readonly) NSData *requestData;")
    public NSData requestData() {
        return requestData;
    }

    @Override
    public String toString() {
        return "SKPayment id=\"" + productIdentifier + "\"" + (quantity != 1 ? " quantity=" + quantity : "");
    }
}
