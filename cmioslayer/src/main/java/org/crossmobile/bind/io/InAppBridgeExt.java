/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.bind.io;

import crossmobile.ios.storekit.SKProduct;
import org.crossmobile.bridge.InAppBridge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public interface InAppBridgeExt extends InAppBridge {

    public static class ProductList {

        public final List<String> invalidIDs;
        public final List<SKProduct> products;
        public final String error;

        public ProductList(List<String> invalidIDs, List<SKProduct> products, String skerror) {
            this.invalidIDs = invalidIDs;
            this.products = products;
            this.error = skerror;
        }

        public static Set<String> getProducts(boolean isConsumable) {
            Set<String> result = new HashSet<>();
            StringTokenizer tk = new StringTokenizer(System.getProperty(isConsumable ? "org.crossmobile.cmplugin-cmpayment.consumable" : "org.crossmobile.cmplugin-cmpayment.noncosumable", ""), ":");
            while (tk.hasMoreTokens())
                result.add(tk.nextToken().trim());
            return result;
        }
    }
}
