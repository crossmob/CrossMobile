/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.storekit;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSLocale;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

import static org.crossmobile.bind.system.AbstractLifecycleBridge.errorFromInfo;

@CMLib(target = CMLibTarget.RUNTIME)
public class StoreDrill {

    public static SKProduct newSKProduct(String locDescription, String locTitle, double price, NSLocale locale, String prodId) {
        return new SKProduct(locDescription, locTitle, price, locale == null ? NSLocale.currentLocale() : locale, prodId);
    }

    public static SKPaymentTransaction newSKPaymentTransaction(int state, String productIdentifier, String transactionIdentifier, NSDate transactionDate, byte[] requestData, byte[] transactionReceipt, String errorTxt) {
        if (requestData == null)
            requestData = new byte[]{};
        if (transactionReceipt == null)
            transactionReceipt = new byte[]{};
        if (transactionDate == null)
            transactionDate = NSDate.date();
        if (transactionIdentifier == null)
            transactionIdentifier = "transaction:product=" + productIdentifier;
        SKPayment payment = new SKPayment(productIdentifier, 1, NSData.dataWithBytesNoCopy(requestData));
        NSError error = state == SKPaymentTransactionState.Failed ? NSError.errorWithDomain(NSError.Domain.SKError, SKError.Unknown, errorFromInfo(errorTxt + " (" + state + ")")) : null;
        return new SKPaymentTransaction(payment, state, transactionIdentifier, NSData.dataWithBytesNoCopy(transactionReceipt), transactionDate, null, error);
    }

}
