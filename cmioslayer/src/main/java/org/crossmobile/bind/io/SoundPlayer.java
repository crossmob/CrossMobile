/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.io;

public interface SoundPlayer {

    public boolean isPlaying();

    public boolean play();

    public void pause();

    public int getChannels();

    public double getDuration();

    public void setLocation(double time);

    public double getLocation();

    public void setVolume(float volume);

    public float getVolume();

    public interface Delegate {

        public void finishSuccessful();

        public void finishWithError(Exception e);
    }
}
