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

import org.crossmobile.bridge.ann.CMEnum;

/**
 * MPMovieScalingMode class defines different options concerning movie content
 * scaling.
 */
@CMEnum
public final class MPMovieScalingMode {

    /**
     * The movie content is not being scaled.
     */
    public static final int None = 0;

    /**
     * The movie content is uniformly scaled so that one dimension fills its
     * bounds and the other is filled with black.
     */
    public static final int AspectFit = 1;

    /**
     * The movie content is uniformly scaled so that the larger dimension is
     * being cut so that the other dimension fills the view.
     */
    public static final int AspectFill = 2;

    /**
     * The content of the movie is being scaled in order to fill both width and
     * height.
     */
    public static final int Fill = 3;

    private MPMovieScalingMode() {
    }
}
