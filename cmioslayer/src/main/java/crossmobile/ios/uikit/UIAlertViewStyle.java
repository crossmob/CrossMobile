/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIAlertViewStyle class defines styles for different types of alerts.
 */
@CMEnum
public final class UIAlertViewStyle {

    /**
     * The default alert.
     */
    public static final int Default = 0;

    /**
     * The alert for entering obscured text.
     */
    public static final int SecureTextInput = 1;

    /**
     * The alert for entering plain text.
     */
    public static final int PlainTextInput = 2;

    /**
     * The alert for entering login and password.
     */
    public static final int LoginAndPasswordInput = 3;

    private UIAlertViewStyle() {
    }
}
