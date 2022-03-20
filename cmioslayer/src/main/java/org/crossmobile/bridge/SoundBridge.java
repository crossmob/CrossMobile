/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bind.io.SoundPlayer;

public interface SoundBridge {

    SoundPlayer getSoundPlayer(NSURL url, SoundPlayer.Delegate delegate) throws Exception;

    void vibrate();
}
