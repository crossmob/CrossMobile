/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.audiotoolbox;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMBundle;
import org.crossmobile.bridge.ann.CMFunction;

/**
 * AudioServices class represents an object that is responsible for handling
 * volume and audio related features.
 */
@CMBundle
public final class AudioServices {

    private AudioServices() {
    }

    /**
     * Plays the specified system sound.
     *
     * @param systemSoundID The id of the system sound.
     */
    @CMFunction(" void AudioServicesPlaySystemSound ( SystemSoundID inSystemSoundID ); ")
    public static void playSystemSound(int systemSoundID) {
        if (systemSoundID == SystemSoundID.Vibrate)
            Native.sound().vibrate();
    }
}
