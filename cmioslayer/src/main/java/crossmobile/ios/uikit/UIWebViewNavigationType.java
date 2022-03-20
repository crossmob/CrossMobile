/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIWebViewNavigationType class contains all the information related to the
 * current user’s action.
 */
@CMEnum
@CMLib(name = "cmwebkit")
public final class UIWebViewNavigationType {

    /**
     * The user tapped a link.
     */
    public static final int LinkClicked = 0;

    /**
     * The user submitted a form.
     */
    public static final int FormSubmitted = 1;

    /**
     * User tapped the back or forward button.
     */
    public static final int BackForward = 2;

    /**
     * The user tapped the reload button.
     */
    public static final int Reload = 3;

    /**
     * The user resubmitted a form.
     */
    public static final int FormResubmitted = 4;

    /**
     * Undefined action occurred.
     */
    public static final int Other = 5;

    private UIWebViewNavigationType() {
    }
}
