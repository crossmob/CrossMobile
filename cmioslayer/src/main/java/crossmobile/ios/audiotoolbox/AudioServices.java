/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
