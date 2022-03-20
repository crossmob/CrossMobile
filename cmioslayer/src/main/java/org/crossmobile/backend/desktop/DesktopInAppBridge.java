/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.storekit.SKPayment;
import crossmobile.ios.storekit.SKPaymentTransaction;
import crossmobile.ios.storekit.SKPaymentTransactionState;
import crossmobile.ios.storekit.SKProduct;
import org.crossmobile.bind.io.InAppBridgeExt.ProductList;
import org.crossmobile.bridge.InAppBridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static crossmobile.ios.storekit.StoreDrill.newSKPaymentTransaction;
import static crossmobile.ios.storekit.StoreDrill.newSKProduct;
import static org.crossmobile.bind.system.i18n.I18NSelf.ℑ;

public class DesktopInAppBridge implements InAppBridge {

    @Override
    public boolean isSupported() {
        return true;
    }

    @Override
    public void requestValidProducts(final Set<String> requestedProducts, final NSSelector<ProductList> resultCallback) {
        new Thread(() -> {
            List<String> invalid = new ArrayList<>();
            List<SKProduct> valid = new ArrayList<>();
            Set<String> consumable = ProductList.getProducts(true);
            Set<String> nonConsumable = ProductList.getProducts(true);
            for (String item : requestedProducts)
                if (consumable.contains(item) || nonConsumable.contains(item))
                    valid.add(newSKProduct(ℑ("This is a full description of product") + " " + item, item, 1, null, item));
                else
                    invalid.add(item);
            resultCallback.exec(new ProductList(invalid, valid, null));
        }).start();
    }

    @Override
    public void restoreTransactions(NSSelector<SKPaymentTransaction> singleTransaction, Runnable successCallback, NSSelector<String> errorCallback) {
        errorCallback.exec(ℑ("No history of transactions is monitored in this backend"));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void requestPayment(final SKPayment payment, final NSSelector<SKPaymentTransaction> resultCallback) {
        new crossmobile.ios.uikit.UIAlertView(ℑ("Payment request"), ℑ("Payment request for product:") + " " + payment.productIdentifier(), (crossmobile.ios.uikit.UIAlertView alertView, int buttonIndex) -> {
            if (buttonIndex == 1)
                resultCallback.exec(newSKPaymentTransaction(SKPaymentTransactionState.Purchased, payment.productIdentifier(), null, null, null, null, null));
        }, ℑ("Cancel"), ℑ("Accept")).show();
    }
}
