/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
