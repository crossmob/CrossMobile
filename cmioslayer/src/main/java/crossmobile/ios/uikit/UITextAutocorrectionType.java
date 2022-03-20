/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITextAutocorrectionType class defines different types of auto-correction for
 * text objects.
 */
@CMEnum
public final class UITextAutocorrectionType {

    /**
     * Appropriate auto-correction for the current system.
     */
    public static final int Default = 0;

    /**
     * Auto-correction is disabled.
     */
    public static final int No = 1;

    /**
     * Auto-correction is enabled.
     */
    public static final int Yes = 2;

    private UITextAutocorrectionType() {
    }
}
