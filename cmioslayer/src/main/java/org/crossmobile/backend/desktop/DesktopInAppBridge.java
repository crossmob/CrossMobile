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
package org.crossmobile.backend.desktop;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.storekit.SKPayment;
import crossmobile.ios.storekit.SKPaymentTransaction;
import crossmobile.ios.storekit.SKPaymentTransactionState;
import crossmobile.ios.storekit.SKProduct;
import crossmobile.ios.uikit.UIAlertView;
import org.crossmobile.bind.io.InAppBridgeExt.ProductList;
import org.crossmobile.bridge.InAppBridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static crossmobile.ios.storekit.$storekit.newSKPaymentTransaction;
import static crossmobile.ios.storekit.$storekit.newSKProduct;
import static org.crossmobile.bind.system.i18n.I18NSelf.ℑ;

public class DesktopInAppBridge implements InAppBridge {

    @Override
    public boolean isSupported() {
        return true;
    }

    @Override
    public void requestValidProducts(final Set<String> requestedProducts, final NSSelector<ProductList> resultCallback) {
        new Thread() {
            @Override
            public void run() {
                List<String> invalid = new ArrayList<>();
                List<SKProduct> valid = new ArrayList<>();
                Set<String> consumable = ProductList.getProducts(true);
                Set<String> nonconsumable = ProductList.getProducts(true);
                for (String item : requestedProducts)
                    if (consumable.contains(item) || nonconsumable.contains(item))
                        valid.add(newSKProduct(ℑ("This is a full description of product") + " " + item, item, 1, null, item));
                    else
                        invalid.add(item);
                resultCallback.exec(new ProductList(invalid, valid, null));
            }
        }.start();
    }

    @Override
    public void restoreTransactions(NSSelector<SKPaymentTransaction> singleTransaction, Runnable successCallback, NSSelector<String> errorCallback) {
        errorCallback.exec(ℑ("No history of transactions is monitored in this backend"));
    }

    @Override
    public void requestPayment(final SKPayment payment, final NSSelector<SKPaymentTransaction> resultCallback) {
        new UIAlertView(ℑ("Payment request"), ℑ("Payment request for product:") + " " + payment.productIdentifier(), (UIAlertView alertView, int buttonIndex) -> {
            if (buttonIndex == 1)
                resultCallback.exec(newSKPaymentTransaction(SKPaymentTransactionState.Purchased, payment.productIdentifier(), null, null, null, null, null));
        }, ℑ("Cancel"), ℑ("Accept")).show();
    }
}
