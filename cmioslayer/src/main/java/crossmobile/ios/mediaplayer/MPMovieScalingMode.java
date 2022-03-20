/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
