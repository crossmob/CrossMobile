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
