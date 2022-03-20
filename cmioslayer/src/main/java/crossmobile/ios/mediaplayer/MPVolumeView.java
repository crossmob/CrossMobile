/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mediaplayer;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * MPVolumeView class defines a special view used in order to present volume
 * options(increase,decrease) of the application.
 */
@CMClass
public class MPVolumeView extends UIView {

    private boolean showsRouteButton = true;
    private boolean showsVolumeSlider = true;

    /**
     * Constructs a new MPVolumeView object with the specified frame.
     *
     * @param frame The frame of the new MPVolumeView object.
     */
    public MPVolumeView(CGRect frame) {
        super(frame);
    }

    /**
     * Returns a Boolean that shows whether the route button(increase and
     * decrease) is visible.
     *
     * @return TRUE then the route button(increase and decrease) is visible.
     */
    @CMGetter("@property(nonatomic) BOOL showsRouteButton;")
    public boolean showsRouteButton() {
        return showsRouteButton;
    }

    /**
     * Sets Boolean that defines whether the route button(increase and decrease)
     * is visible.
     *
     * @param showsRouteButton TRUE then the route button(increase and decrease)
     *                         is visible.
     */
    @CMSetter("@property(nonatomic) BOOL showsRouteButton;")
    public void setShowsRouteButton(boolean showsRouteButton) {
        this.showsRouteButton = showsRouteButton;
    }

    /**
     * Returns a Boolean that shows whether the volume slider is visible.
     *
     * @return TRUE then the volume slider is visible.
     */
    @CMGetter("@property(nonatomic) BOOL showsVolumeSlider;")
    public boolean showsVolumeSlider() {
        return showsVolumeSlider;
    }

    /**
     * Sets Boolean that defines whether the volume slider is visible.
     *
     * @param showsVolumeSlider TRUE then the volume slider is visible.
     */
    @CMSetter("@property(nonatomic) BOOL showsVolumeSlider;")
    public void setShowsVolumeSlider(boolean showsVolumeSlider) {
        this.showsVolumeSlider = showsVolumeSlider;
    }
}
