/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.gamekit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * GKPeerPickerController class defines an object that is used in order to
 * present to the user options related to the connecting the current device with
 * other devices.
 */
@Deprecated
@CMClass
public class GKPeerPickerController extends NSObject {

    private boolean visible;
    private GKPeerPickerControllerDelegate delegate;
    private int connectionTypesMask = GKPeerPickerConnectionType.Nearby;

    /**
     * Returns the delegate of this GKPeerPickerController.
     *
     * @return The delegate of this GKPeerPickerController.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, assign) id<GKPeerPickerControllerDelegate> delegate;")
    public GKPeerPickerControllerDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this GKPeerPickerController.
     *
     * @param delegate The delegate of this GKPeerPickerController.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, assign) id<GKPeerPickerControllerDelegate> delegate;")
    public void setDelegate(GKPeerPickerControllerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns a Boolean that shows whether the picker dialog is visible.
     *
     * @return A Boolean that shows whether the picker dialog is visible.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readonly, getter=isVisible) BOOL visible;")
    public boolean isVisible() {
        return visible;
    }

    /**
     * Returns a mask for the network connections available to the peer picker
     * dialog that is presented to the user.
     *
     * @return A mask for the network connections available to the peer picker
     * dialog that is presented to the user.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, assign) GKPeerPickerConnectionType connectionTypesMask;")
    public int connectionTypesMask() {
        return connectionTypesMask;
    }

    /**
     * Sets a mask for the network connections available to the peer picker
     * dialog that is presented to the user.
     *
     * @param connectionTypesMask A mask for the network connections available
     *                            to the peer picker dialog that is presented to the user.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, assign) GKPeerPickerConnectionType connectionTypesMask;")
    public void setConnectionTypesMask(int connectionTypesMask) {
        this.connectionTypesMask = connectionTypesMask;
    }

    /**
     * Shows the peer picker dialog to the user.
     */
    @CMSelector("- (void)show;")
    public void show() {
        visible = true;
    }

    /**
     * Closes the peer picker dialog.
     */
    @CMSelector("- (void)dismiss;")
    public void dismiss() {
        visible = false;
    }
}
