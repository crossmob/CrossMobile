/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.messageui;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * MessageComposeResult class defines different cases concerning the end of
 * message composing.
 */
@CMEnum
public final class MessageComposeResult {

    /**
     * Message composition was canceled by the user.
     */
    public static final int Cancelled = 0;

    /**
     * The user saved or sent the message.
     */
    public static final int Sent = 1;

    /**
     * The user did not succeed to save or send the message.
     */
    public static final int Failed = 2;

    private MessageComposeResult() {
    }
}
