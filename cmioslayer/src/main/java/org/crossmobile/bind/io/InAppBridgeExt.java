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
