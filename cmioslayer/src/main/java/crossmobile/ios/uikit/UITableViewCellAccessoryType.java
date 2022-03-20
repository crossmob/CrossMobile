/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITableViewCellAccessoryType class defines different types of the accessory
 * controls that can be used by a UITableViewCell object.
 */
@CMEnum
public final class UITableViewCellAccessoryType {

    /**
     * The default value. A cell with no accessory control.
     */
    public static final int None = 0;

    /**
     * A cell has a V shape on it and after tapping it a push action takes
     * place.
     */
    public static final int DisclosureIndicator = 1;

    /**
     * A cell has a V shape on it and tapping it allows user to edit its
     * contents.
     */
    public static final int DetailDisclosureButton = 2;

    /**
     * A cell that has a tick symbol on it and does not track tapping.
     */
    public static final int Checkmark = 3;

    private UITableViewCellAccessoryType() {
    }
}
