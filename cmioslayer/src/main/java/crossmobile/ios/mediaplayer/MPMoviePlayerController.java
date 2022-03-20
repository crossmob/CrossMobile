/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mediaplayer;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.uikit.UIColor;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

/**
 * MPMoviePlayerController class defines an object that handles the playback of
 * a movie from a file or via streaming.
 */
@Deprecated
@CMClass
public class MPMoviePlayerController extends NSObject {

    private NSURL contentURL;
    private UIColor backgroundColor;
    private double initialPlaybackTime = 0;
    private int scalingMode;

    /**
     * Constructs and returns a MPMoviePlayerController object with specified
     * URL path of the movie file.
     *
     * @param contentURL The URL of the movie file for the new
     *                   MPMoviePlayerController object.
     */
    @Deprecated
    @CMConstructor("- (instancetype)initWithContentURL:(NSURL *)url;")
    public MPMoviePlayerController(NSURL contentURL) {
        this.contentURL = contentURL;
    }

    /**
     * Plays the movie.
     */
    @CMSelector("- (void)play;")
    public void play() {
        Native.system().notImplemented();
    }

    /**
     * Pauses the movie.
     */
    @CMSelector("- (void)pause;")
    public void pause() {
        Native.system().notImplemented();
    }

    /**
     * Stops the movie.
     */
    @CMSelector("- (void)stop;")
    public void stop() {
        Native.system().notImplemented();
    }

    /**
     * Returns the URL of the movie file.
     *
     * @return The URL of the movie file.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSURL *contentURL;")
    public NSURL contentURL() {
        return contentURL;
    }

    /**
     * Returns the background color behind the movie.
     *
     * @return The background color behind the movie.
     */
    @Deprecated
    @CMSelector("- (UIColor *)backgroundColor")
    public UIColor backgroundColor() {
        return backgroundColor;
    }

    /**
     * Returns the starting point of the playback expressed in seconds(within
     * the video timeline).
     *
     * @return The starting point of the playback expressed in seconds(within
     * the video timeline).
     */
    @Deprecated
    @CMGetter("@property(nonatomic) NSTimeInterval initialPlaybackTime;")
    public double initialPlaybackTime() {
        return initialPlaybackTime;
    }

    /**
     * Sets the starting point of the playback expressed in seconds(within the
     * video timeline).
     *
     * @param initialPlaybackTime The starting point of the playback expressed
     *                            in seconds(within the video timeline).
     */
    @Deprecated
    @CMSetter("@property(nonatomic) NSTimeInterval initialPlaybackTime;")
    public void setInitialPlaybackTime(double initialPlaybackTime) {
        this.initialPlaybackTime = initialPlaybackTime;
    }

    /**
     * Returns the scaling mode of the movie content.
     *
     * @return The scaling mode of the movie content.
     * @see crossmobile.ios.mediaplayer.MPMovieScalingMode
     */
    @Deprecated
    @CMGetter("@property(nonatomic) MPMovieScalingMode scalingMode;")
    public int scalingMode() {
        return scalingMode;
    }

    /**
     * Sets the scaling mode of the movie content.
     *
     * @param MPMovieScalingMode The scaling mode of the movie content.
     * @see crossmobile.ios.mediaplayer.MPMovieScalingMode
     */
    @CMSetter("@property(nonatomic) MPMovieScalingMode scalingMode;")
    public void setScalingMode(int MPMovieScalingMode) {
        this.scalingMode = MPMovieScalingMode;
    }

}
