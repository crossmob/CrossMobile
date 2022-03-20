/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.accounts;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * ACErrorCode class defines different types of errors related to accessing
 * accounts.
 */
@CMEnum
public final class ACErrorCode {

    /**
     * Unknown error occurred.
     */
    public static final int Unknown = 1;

    /**
     * Unsaved account due to missing property.
     */
    public static final int AccountMissingRequiredProperty = 2;

    /**
     * Unsaved account due to authentication credential failure.
     */
    public static final int AccountAuthenticationFailed = 3;

    /**
     * Unsaved account due to invalid account type.
     */
    public static final int AccountTypeInvalid = 4;

    /**
     * Account already exists.
     */
    public static final int AccountAlreadyExists = 5;

    /**
     * Account could not be found to be deleted.
     */
    public static final int AccountNotFound = 6;

    /**
     * Permission denied to application.
     */
    public static final int PermissionDenied = 7;

    /**
     * Incorrect or missing values to information dictionary.
     */
    public static final int AccessInfoInvalid = 8;

    private ACErrorCode() {
    }
}
