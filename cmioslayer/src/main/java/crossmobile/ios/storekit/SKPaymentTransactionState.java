/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.storekit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * SKPaymentTransactionState class defines different states of a transaction.
 */
@CMEnum
public final class SKPaymentTransactionState {

    /**
     * The transaction is being processed by the AppStore.
     */
    public static final int Purchasing = 0;

    /**
     * The payment transaction was successfully completed. The application gives
     * access to the purchased content.
     */
    public static final int Purchased = 1;

    /**
     * The payment transaction failed.
     */
    public static final int Failed = 2;

    /**
     * The transaction restored previously purchased content by the user.
     */
    public static final int Restored = 3;

    private SKPaymentTransactionState() {
    }
}
