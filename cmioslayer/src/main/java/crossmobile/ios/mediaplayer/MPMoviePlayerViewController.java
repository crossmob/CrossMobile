/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mediaplayer;

import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.uikit.UIViewController;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;

/**
 * MPMoviePlayerViewController class extends UIViewController and defines a
 * special view controller used for displaying movies.
 */
@Deprecated
@CMClass
public class MPMoviePlayerViewController extends UIViewController {

    private final MPMoviePlayerController mp;

    /**
     * Constructs a MPMoviePlayerViewController for the specified movie URL.
     *
     * @param url The URL of the movie.
     */
    @Deprecated
    @CMConstructor("- (instancetype)initWithContentURL:(NSURL *)contentURL;")
    public MPMoviePlayerViewController(NSURL url) {
        mp = new MPMoviePlayerController(url);
    }

    /**
     * Constructs and returns the default MPMoviePlayerViewController object.
     *
     * @return A new MPMoviePlayerViewController object.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readonly) MPMoviePlayerController *moviePlayer;")
    public MPMoviePlayerController moviePlayer() {
        return mp;
    }
}
