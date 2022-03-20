/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.storekit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * SKError class defines different types of errors related to StroreKit.
 */
@CMEnum
public final class SKError {

    /**
     * Unexpected or unknown error.
     */
    public static final int Unknown = 0;

    /**
     * The client was not allowed.
     */
    public static final int ClientInvalid = 1;

    /**
     * The payment request was canceled by the user.
     */
    public static final int PaymentCancelled = 2;

    /**
     * There was an invalid payment parameter.
     */
    public static final int PaymentInvalid = 3;

    /**
     * The user was not recognized as authorized.
     */
    public static final int PaymentNotAllowed = 4;

    /**
     * The requested product was not available.
     */
    public static final int StoreProductNotAvailable = 5;

    private SKError() {
    }

}
