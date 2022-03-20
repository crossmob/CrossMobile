/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UITextSpellCheckingType {
    public static final int Default = 0;
    public static final int No = 1;
    public static final int Yes = 2;

    private UITextSpellCheckingType() {

    }
}
