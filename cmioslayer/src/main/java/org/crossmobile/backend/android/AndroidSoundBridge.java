/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Context;
import android.os.Vibrator;
import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bind.io.SoundPlayer;
import org.crossmobile.bridge.SoundBridge;

public class AndroidSoundBridge implements SoundBridge {

    @Override
    public SoundPlayer getSoundPlayer(NSURL url, SoundPlayer.Delegate delegate) throws Exception {
        return new AndroidSoundPlayer(url, delegate);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void vibrate() {
        Vibrator v = (Vibrator) MainActivity.current.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(300);
    }
}
