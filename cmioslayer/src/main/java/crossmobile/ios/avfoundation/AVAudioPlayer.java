/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.avfoundation;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURL;
import crossmobile.rt.StrongReference;
import org.crossmobile.bind.io.SoundPlayer;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import static org.crossmobile.bind.system.AbstractLifecycleBridge.errorFromThrowable;

/**
 * AVAudioPlayer class defines an object that represents the audio player of the
 * application.
 */
@CMClass
public class AVAudioPlayer extends NSObject {

    private SoundPlayer player;
    private AVAudioPlayerDelegate delegate;
    private NSURL url;
    private int loops = 1;
    private int current_loop = 1;
    private final SoundPlayer.Delegate sdelegate = new SoundPlayer.Delegate() {
        @Override
        public void finishWithError(Exception e) {
            if (delegate != null) {
                delegate.decodeErrorDidOccur(AVAudioPlayer.this, NSError.errorWithDomain(NSError.Domain.NSURL, NSError.ErrorCode.Unknown, errorFromThrowable(e)));
                delegate.didFinishPlaying(AVAudioPlayer.this, false);
            }
        }

        @Override
        public void finishSuccessful() {
            if (current_loop < loops) {
                current_loop++;
                player.setLocation(0);
                play();
            } else if (delegate != null)
                delegate.didFinishPlaying(AVAudioPlayer.this, true);
        }
    };

    private AVAudioPlayer(NSURL url, StrongReference<NSError> error) throws Exception {
        if (error != null)
            error.set(null);
        this.url = url;
        this.player = Native.sound().getSoundPlayer(url, sdelegate);
    }

    /**
     * Constructs and returns an AVAudioPlayer with the specified URL for the
     * sound and error handing values.
     *
     * @param url   The URL of the sound to play.
     * @param error The error that occurs in case of failure.
     */
    @CMSelector(value = "- (instancetype)initWithContentsOfURL:(NSURL *)url\n"
            + "                                error:(NSError * _Nullable *)outError", staticMapping = true)
    public static AVAudioPlayer initWithContentsOfURL(NSURL url, StrongReference<NSError> error) {
        try {
            return new AVAudioPlayer(url, error);
        } catch (Exception ex) {
            if (error != null)
                error.set(NSError.errorWithDomain(NSError.Domain.NSURL, NSError.ErrorCode.Unknown, errorFromThrowable(ex)));
            return null;
        }
    }

    /**
     * Constructs and returns an AVAudioPlayer with the specified NSData and
     * error handing values.
     *
     * @param data  The data of the sound to play.
     * @param error The error that occurs in case of failure.
     */
    @CMSelector(value = "- (instancetype)initWithData:(NSData *)data\n"
            + "                       error:(NSError * _Nullable *)outError", staticMapping = true)
    public static AVAudioPlayer initWithData(NSData data, StrongReference<NSError> error) {
        return initWithContentsOfURL(NSURL.fileURLWithPath(SystemUtilities.writeToRandomFile(data.bytes())), error);
    }

    /**
     * Plays a sound.
     *
     * @return TRUE if the operation was successfully completed.
     */
    @CMSelector("- (BOOL)play;")
    public boolean play() {
        if (!player.isPlaying()) {
            current_loop = 1;
            return player.play();
        }
        return true;
    }

    /**
     * Plays a sound at a certain delay.
     *
     * @param time The time to begin playback.
     * @return TRUE if the operation was successfully completed.
     */
    @CMSelector("- (BOOL)playAtTime:(NSTimeInterval)time;")
    public boolean playAtTime(double time) {
        player.setLocation(time);
        return play();
    }

    /**
     * Stops the playback of this AVAudioPlayer.
     */
    @CMSelector("- (void)stop;")
    public void stop() {
        if (player.isPlaying())
            player.pause();
        player.setLocation(0);
    }

    /**
     * Pauses the playback of this AVAudioPlayer.
     */
    @CMSelector("- (void)pause;")
    public void pause() {
        if (player.isPlaying())
            player.pause();
    }

    /**
     * Prepares the buffers of this AVAudioPlayer for playing.
     *
     * @return TRUE if the operation was successfully completed.
     */
    @CMSelector("- (BOOL)prepareToPlay;")
    public boolean prepareToPlay() {
        return true;
    }

    /**
     * Returns the number of repeats of the audio of this AVAudioPlayer.
     *
     * @return The number of repeats of the audio of this AVAudioPlayer.
     */
    @CMGetter("@property NSInteger numberOfLoops;")
    public int numberOfLoops() {
        return loops;
    }

    /**
     * Sets the number of repeats of the audio of this AVAudioPlayer.
     *
     * @param numberOfLoops The number of repeats of the audio of this
     *                      AVAudioPlayer.
     */
    @CMSetter("@property NSInteger numberOfLoops;")
    public void setNumberOfLoops(int numberOfLoops) {
        this.loops = numberOfLoops;
    }

    /**
     * Returns the delegate of this AVAudioPlayer.
     *
     * @return The delegate of this AVAudioPlayer.
     */
    @CMGetter("@property(assign) id<AVAudioPlayerDelegate> delegate;")
    public AVAudioPlayerDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this AVAudioPlayer.
     *
     * @param delegate The delegate for this AVAudioPlayer.
     */
    @CMSetter("@property(assign) id<AVAudioPlayerDelegate> delegate;")
    public void setDelegate(AVAudioPlayerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns a Boolean that shows whether this AVAudioPlayer is playing a
     * sound.
     *
     * @return TRUE then this AVAudioPlayer is playing a sound.
     */
    @CMGetter("@property(readonly, getter=isPlaying) BOOL playing;")
    public boolean isPlaying() {
        return player.isPlaying();
    }

    /**
     * Sets the current location of the playback for this AVAudioPlayer.
     *
     * @param currentTime The current location of the playback of this
     *                    AVAudioPlayer.
     */
    @CMSetter("@property NSTimeInterval currentTime;")
    public void setCurrentTime(double currentTime) {
        player.setLocation(currentTime);
    }

    /**
     * Returns the current location of the playback of this AVAudioPlayer.
     *
     * @return The current location of the playback of this AVAudioPlayer.
     */
    @CMGetter("@property NSTimeInterval currentTime;")
    public double currentTime() {
        return player.getLocation();
    }

    /**
     * Sets the sound of this AVAudioPlayer.
     *
     * @param volume The sound of this AVAudioPlayer.
     */
    @CMSetter("@property float volume;")
    public void setVolume(float volume) {
        player.setVolume(volume);
    }

    /**
     * Returns a number that represents the sound of this AVAudioPlayer.
     *
     * @return A number that represents the sound of this AVAudioPlayer.
     */
    @CMGetter("@property float volume;")
    public float volume() {
        return player.getVolume();
    }

    /**
     * Returns the number of audio channels of this AVAudioPlayer.
     *
     * @return The number of audio channels of this AVAudioPlayer.
     */
    @CMGetter("@property(readonly) NSUInteger numberOfChannels;")
    public int numberOfChannels() {
        return player.getChannels();
    }

    /**
     * Returns the duration of the sound of this AVAudioPlayer expressed in
     * seconds.
     *
     * @return The duration of the sound of this AVAudioPlayer expressed in
     * seconds.
     */
    @CMGetter("@property(readonly) NSTimeInterval duration;")
    public double duration() {
        return player.getDuration();
    }

    /**
     * Returns the URL of the sound of this AVAudioPlayer.
     *
     * @return The URL of the sound of this AVAudioPlayer.
     */
    @CMGetter("@property(readonly) NSURL *url;")
    public NSURL url() {
        return url;
    }

    /**
     * Returns an NSData object that represents the sound of the audio player.
     *
     * @return NULL if the audio player has no audio data.
     */
    @CMGetter("@property(readonly) NSData *data;")
    public NSData data() {
        return NSData.dataWithContentsOfURL(url);
    }
}
