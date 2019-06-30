/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
