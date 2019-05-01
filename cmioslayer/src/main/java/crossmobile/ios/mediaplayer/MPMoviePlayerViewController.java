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
