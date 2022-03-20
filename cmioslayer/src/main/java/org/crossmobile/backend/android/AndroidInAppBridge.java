/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Intent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.storekit.SKPayment;
import crossmobile.ios.storekit.SKPaymentTransaction;
import crossmobile.ios.storekit.SKPaymentTransactionState;
import crossmobile.ios.storekit.SKProduct;
import org.crossmobile.backend.android.billing.*;
import org.crossmobile.backend.android.billing.IabHelper.OnIabSetupFinishedListener;
import org.crossmobile.bind.io.InAppBridgeExt.ProductList;
import org.crossmobile.bridge.InAppBridge;
import org.crossmobile.bridge.ann.CMLib;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static crossmobile.ios.storekit.StoreDrill.newSKPaymentTransaction;
import static crossmobile.ios.storekit.StoreDrill.newSKProduct;
import static org.crossmobile.bind.system.i18n.I18NSelf.ℑ;
import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@SuppressWarnings("deprecation")
@CMLib(target = ANDROID, name = "cmpayment")
public class AndroidInAppBridge implements InAppBridge, OnIabSetupFinishedListener, ActivityResultListener {

    private final IabHelper billingHelper;
    private boolean initialized = false;
    private final int reqCode;

    @SuppressWarnings("LeakingThisInConstructor")
    public AndroidInAppBridge() {
        // As long as this bridge is active (i.e. always) no unregister is required
        reqCode = MainActivity.current.getStateListener().registerGlobally(this);
        billingHelper = new IabHelper(MainActivity.current, System.getProperty("org.crossmobile.cmplugin-cmpayment.key"));
        billingHelper.startSetup(this);
    }

    @Override
    public boolean isSupported() {
        return hasGooglePlay();
    }

    private static Boolean enabledGooglePlay = null;

    private static boolean hasGooglePlay() {
        if (enabledGooglePlay == null)
            enabledGooglePlay = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.current) == ConnectionResult.SUCCESS;
        return enabledGooglePlay == null ? false : enabledGooglePlay;
    }

    @Override
    public void onIabSetupFinished(IabResult result) {
        initialized = result.isSuccess();
    }

    @Override
    public void result(int resultCode, Intent data) {
        billingHelper.handleActivityResult(reqCode, resultCode, data);
    }

    @Override
    public void requestValidProducts(final Set<String> requestedProducts, final NSSelector<ProductList> resultCallback) {
        if (!initialized) {
            new crossmobile.ios.uikit.UIAlertView(ℑ("In App"), ℑ("In App for Android not initialized yet") + "\n" + ℑ("Please try later"), (crossmobile.ios.uikit.UIAlertView alertView, int buttonIndex) -> {
                resultCallback.exec(new ProductList(null, null, ℑ("In App for Android not initialized yet")));
            }, ℑ("Acknowledge")).show();
            return;
        }
        billingHelper.queryInventoryAsync(true, new ArrayList<>(requestedProducts), (IabResult result, Inventory inv) -> {
            if (result.isFailure()) {
                resultCallback.exec(new ProductList(null, null, result.getMessage()));
                return;
            }
            List<SKProduct> valid = new ArrayList<>();
            List<String> invalid = new ArrayList<>();
            for (String item : requestedProducts)
                if (inv.hasDetails(item)) {
                    SkuDetails details = inv.getSkuDetails(item);
                    double price = 1;
                    try {
                        price = Double.parseDouble(details.getPrice().replaceAll("[^0-9.,]", "").replace(',', '.'));
                    } catch (NumberFormatException ex) {
                    }
                    valid.add(newSKProduct(details.getDescription(), details.getTitle(), price, null, item));
                } else
                    invalid.add(item);
            resultCallback.exec(new ProductList(invalid, valid, null));
        });
    }

    @Override
    public void requestPayment(final SKPayment payment, final NSSelector<SKPaymentTransaction> resultCallback) {
        if (!initialized) {
            new crossmobile.ios.uikit.UIAlertView(ℑ("In App"), ℑ("In App for Android not initialized yet") + "\n" + ℑ("Please try later"), (crossmobile.ios.uikit.UIAlertView alertView, int buttonIndex) -> {
                result(resultCallback, null, payment, SKPaymentTransactionState.Failed, "In App for Android not initialized yet");
            }, ℑ("Acknowledge")).show();
            return;
        }
        final String id = payment.productIdentifier();//"android.test.purchased"; // id =
        // First check if we have bought it already
        billingHelper.queryInventoryAsync((IabResult result, Inventory inv) -> {
            if (result.isSuccess() && inv.hasPurchase(id)) {
                // We've bought it already
                result(resultCallback, inv.getPurchase(id), payment, SKPaymentTransactionState.Purchased, null);
                return;
            }
            // We haven't bought it yet: try to buy it
            billingHelper.launchPurchaseFlow(MainActivity.current, id, reqCode, (IabResult result1, Purchase pur) -> {
                if (result1.isFailure())
                    result(resultCallback, pur, payment, SKPaymentTransactionState.Failed, result1.getMessage());
                else if (result1.isSuccess())
                    result(resultCallback, pur, payment, SKPaymentTransactionState.Purchased, null);
            });
        });
    }

    void result(NSSelector<SKPaymentTransaction> resultCallback, Purchase purchase, SKPayment payment, int SKPaymentTransactionState, String error) {
        if (purchase != null)
//            if (ProductList.getProducts(true).contains(purchase.getSku()))
            billingHelper.consumeAsync(purchase, null);
        SKPaymentTransaction trans = purchase == null ? getTransaction(payment, SKPaymentTransactionState, error) : getTransaction(purchase, SKPaymentTransactionState, error);
        resultCallback.exec(trans);
    }

    @Override
    public void restoreTransactions(final NSSelector<SKPaymentTransaction> singleTransaction, final Runnable successCallback, final NSSelector<String> errorCallback) {
        if (!initialized) {
            new crossmobile.ios.uikit.UIAlertView(ℑ("In App"), ℑ("In App for Android not initialized yet") + "\n" + ℑ("Please try later"), (crossmobile.ios.uikit.UIAlertView alertView, int buttonIndex) -> {
                errorCallback.exec(ℑ("In App for Android not initialized yet"));
            }, ℑ("Acknowledge")).show();
            return;
        }
        billingHelper.queryInventoryAsync((IabResult result, Inventory inv) -> {
            if (result.isFailure())
                errorCallback.exec(result.getMessage());
            else {
                for (String item : inv.getAllOwnedSkus())
                    singleTransaction.exec(getTransaction(inv.getPurchase(item), SKPaymentTransactionState.Restored, null));
                successCallback.run();
            }
        });
    }

    private SKPaymentTransaction getTransaction(Purchase pur, int SKPaymentTransactionState, String error) {
        return newSKPaymentTransaction(SKPaymentTransactionState,
                pur.getSku(),
                pur.getOrderId(),
                NSDate.dateWithTimeIntervalSince1970(pur.getPurchaseTime() / 1000d),
                pur.getDeveloperPayload() == null ? null : pur.getDeveloperPayload().getBytes(),
                pur.getOriginalJson().getBytes(),
                error);
    }

    private SKPaymentTransaction getTransaction(SKPayment payment, int SKPaymentTransactionState, String error) {
        return newSKPaymentTransaction(SKPaymentTransactionState,
                payment.productIdentifier(),
                null,
                NSDate.date(),
                null,
                payment.requestData() == null ? null : payment.requestData().bytes(),
                error);
    }

    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws Throwable {
        billingHelper.dispose();
        super.finalize();
    }
}
