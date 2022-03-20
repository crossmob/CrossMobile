/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.social;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * SLComposeViewControllerResult class defines different values for the result
 * of the SLComposeViewControllerCompletionHandler.
 */
@CMEnum
public final class SLComposeViewControllerResult {

    /**
     * The process was canceled, the user canceled composing the post or the
     * service was not available.
     */
    public static final int Cancelled = 0;

    /**
     * The process was completed,the user finished composing the post and
     * selected done.
     */
    public static final int Done = 1;

    private SLComposeViewControllerResult() {
    }
}
