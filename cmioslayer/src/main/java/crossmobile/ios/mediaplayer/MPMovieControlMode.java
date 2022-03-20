/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mediaplayer;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * MPMovieControlMode class defines different display options for playback
 * controls.
 */
@CMEnum
public final class MPMovieControlMode {

    /**
     * The default display controls.
     */
    public static final int Default = 0;

    /**
     * Display only volume controls.
     */
    public static final int VolumeOnly = 1;

    /**
     * NO controls displayed.
     */
    public static final int Hidden = 2;

    private MPMovieControlMode() {
    }
}
