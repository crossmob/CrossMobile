/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
