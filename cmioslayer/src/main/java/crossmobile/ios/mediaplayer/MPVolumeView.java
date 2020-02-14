/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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

    @Override
    public final void drawRect(CGRect rect) {
        super.drawRect(rect);
    }

}
