/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.storekit;

import crossmobile.ios.foundation.NSLocale;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

/**
 * SKProduct class defines an object that represents a product of the App Store.
 */
@CMClass
public class SKProduct extends NSObject {

    private final String localizedDescription;
    private final String localizedTitle;
    private final double price;
    private final NSLocale priceLocale;
    private final String productIdentifier;

    SKProduct(String localizedDescription, String localizedTitle, double price, NSLocale priceLocale, String productIdentifier) {
        this.localizedDescription = localizedDescription;
        this.localizedTitle = localizedTitle;
        this.price = price;
        this.priceLocale = priceLocale;
        this.productIdentifier = productIdentifier;
    }

    /**
     * Returns the description of the product.
     *
     * @return The description of the product.
     */
    @CMGetter("@property(nonatomic, readonly) NSString *localizedDescription;")
    public String localizedDescription() {
        return localizedDescription;
    }

    /**
     * Returns the title of the product.
     *
     * @return The title of the product.
     */
    @CMGetter("@property(nonatomic, readonly) NSString *localizedTitle;")
    public String localizedTitle() {
        return localizedTitle;
    }

    /**
     * Returns the price of the product in the local currency.
     *
     * @return The price of the product in the local currency.
     */
    @CMGetter("@property(nonatomic, readonly) NSDecimalNumber *price;")
    public Number price() {
        return price;
    }

    /**
     * Returns the locale used for the price of the product.
     *
     * @return The locale used for the price of the product.
     */
    @CMGetter("@property(nonatomic, readonly) NSLocale *priceLocale;")
    public NSLocale priceLocale() {
        return priceLocale;
    }

    /**
     * Returns the String id of this product.
     *
     * @return The String id of this product.
     */
    @CMGetter("@property(nonatomic, readonly) NSString *productIdentifier;")
    public String productIdentifier() {
        return productIdentifier;
    }
}
