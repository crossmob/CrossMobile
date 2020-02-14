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

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

import java.util.List;

/**
 * SKProductsResponse class represents the list response that is returned by the
 * Apple Store after a request of list of products.
 */
@CMClass
public class SKProductsResponse extends NSObject {

    private final List<String> invalidProductIdentifiers;
    private final List<SKProduct> products;

    SKProductsResponse(List<String> invalidProductIdentifiers, List<SKProduct> products) {
        this.invalidProductIdentifiers = invalidProductIdentifiers;
        this.products = products;
    }

    /**
     * Returns the list of the invalid products ids that were requested.
     *
     * @return The list of the invalid products ids that were requested.
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<NSString *> *invalidProductIdentifiers;")
    public List<String> invalidProductIdentifiers() {
        return invalidProductIdentifiers;
    }

    /**
     * Returns the list of products that correspond to the valid product ids
     * that were requested.
     *
     * @return The list of products that correspond to the valid product ids
     * that were requested.
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<SKProduct *> *products;")
    public List<SKProduct> products() {
        return products;
    }
}
