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
package crossmobile.ios.storekit;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSLocale;

import static org.crossmobile.bind.system.AbstractLifecycleBridge.errorFromInfo;

public class $storekit {

    public static SKProduct newSKProduct(String locDescription, String locTitle, double price, NSLocale locale, String prodId) {
        return new SKProduct(locDescription, locTitle, price, locale == null ? NSLocale.currentLocale() : locale, prodId);
    }

    public static SKPaymentTransaction newSKPaymentTransaction(int state, String productIdentifier, String transactionIdentifier, NSDate transactionDate, byte[] requestData, byte[] transactionReceipt, String error) {
        if (requestData == null)
            requestData = new byte[]{};
        if (transactionReceipt == null)
            transactionReceipt = new byte[]{};
        if (transactionDate == null)
            transactionDate = NSDate.date();
        if (transactionIdentifier == null)
            transactionIdentifier = "transaction:product=" + productIdentifier;
        SKPayment payment = new SKPayment(productIdentifier, 1, NSData.dataWithBytesNoCopy(requestData));
        NSError nserror = state == SKPaymentTransactionState.Failed ? NSError.errorWithDomain(NSError.Domain.SKError, SKError.Unknown, errorFromInfo(error + " (" + state + ")")) : null;
        return new SKPaymentTransaction(payment, state, transactionIdentifier, NSData.dataWithBytesNoCopy(transactionReceipt), transactionDate, null, nserror);
    }

}
