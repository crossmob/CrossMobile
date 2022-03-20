/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.storekit.SKPayment;
import crossmobile.ios.storekit.SKPaymentTransaction;
import org.crossmobile.bind.io.InAppBridgeExt.ProductList;

import java.util.Set;

public interface InAppBridge {

    boolean isSupported();

    void requestValidProducts(Set<String> requestedProducts, NSSelector<ProductList> resultCallback);

    void requestPayment(SKPayment payment, NSSelector<SKPaymentTransaction> resultCallback);

    void restoreTransactions(NSSelector<SKPaymentTransaction> singleTransaction, Runnable successCallback, NSSelector<String> errorCallback);

}
