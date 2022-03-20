/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.storekit;

import crossmobile.ios.foundation.NSData;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * SKMutablePayment class defines an object that represents a request to the App
 * Store for completion of a payment process.
 */
@CMClass
public class SKMutablePayment extends SKPayment {

    /**
     * Constructs a SKMutablePayment object with the specified parameters.
     *
     * @param productIdentifier The product id.
     * @param quantity          The quantity of the products.
     * @param requestData       Special data for future use.
     */
    SKMutablePayment(String productIdentifier, int quantity, NSData requestData) {
        super(productIdentifier, quantity, requestData);
    }

    /**
     * Sets the String that identifies the product that is purchased.
     *
     * @param productIdentifier The id of the product that is purchased.
     */
    @CMSetter("@property(nonatomic, copy, readwrite) NSString *productIdentifier;")
    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    /**
     * Sets the specified number of requested items.
     *
     * @param quantity The number of requested items.
     */
    @CMSetter("@property(nonatomic, readwrite) NSInteger quantity;")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets special data that will be used in the future.
     *
     * @param requestData Special data that will be used in the future.
     */
    @CMSetter("@property(nonatomic, copy, readwrite) NSData *requestData;")
    public void setRequestData(NSData requestData) {
        this.requestData = requestData;
    }
}
