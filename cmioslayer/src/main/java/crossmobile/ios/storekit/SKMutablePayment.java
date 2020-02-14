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
