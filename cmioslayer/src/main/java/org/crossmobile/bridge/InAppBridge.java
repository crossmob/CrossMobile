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
