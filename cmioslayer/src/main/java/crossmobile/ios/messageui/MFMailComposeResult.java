/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.messageui;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * MFMailComposeResult class defines different cases concerning the end of email
 * message composing, when message sending does not follow.
 */
@CMEnum
public final class MFMailComposeResult {

    /**
     * The operation of composing email message was canceled by the user.
     */
    public static final int Cancelled = 0;

    /**
     * The email message was saved after failure of sending.
     */
    public static final int Saved = 1;

    /**
     * The email message was saved for future use.
     */
    public static final int Sent = 2;

    /**
     * An error occurred and the message was not saved or queued.
     */
    public static final int Failed = 3;

    private MFMailComposeResult() {
    }
}
