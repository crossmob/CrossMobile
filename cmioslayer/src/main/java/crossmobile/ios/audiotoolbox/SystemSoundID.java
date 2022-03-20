/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.audiotoolbox;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * SystemSoundID class defines option related to alert sounds and alternatives
 * such as vibrations.
 */
@CMEnum
public final class SystemSoundID {

    /**
     * Invokes a brief vibration.
     */
    public static final int Vibrate = 0x00000FFF;

    private SystemSoundID() {
    }
}
