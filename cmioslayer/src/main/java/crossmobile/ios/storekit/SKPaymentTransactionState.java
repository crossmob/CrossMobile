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
