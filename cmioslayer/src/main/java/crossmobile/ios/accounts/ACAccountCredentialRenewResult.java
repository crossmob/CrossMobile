/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.accounts;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * ACAccountCredentialRenewResult class defines different types of status
 * concerning renewal requests.
 */
@CMEnum
public final class ACAccountCredentialRenewResult {

    /**
     * The request was renewed.
     */
    public static final int Renewed = 0;

    /**
     * Renewal failure due to recall of access to account.
     */
    public static final int Rejected = 1;

    /**
     * The renewal request was canceled.
     */
    public static final int Failed = 2;

    private ACAccountCredentialRenewResult() {
    }
}
