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
