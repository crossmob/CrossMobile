/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * MKAnnotationViewDragState class defines different current drag states for
 * annotation views on map views.
 */
@CMEnum
public final class MKAnnotationViewDragState {

    /**
     * The annotation view is not dragging. The default drag state.
     */
    public static final int None = 0;

    /**
     * The annotation view is about to start dragging due to a user action.
     */
    public static final int Starting = 1;

    /**
     * The annotation view is dragging.
     */
    public static final int Dragging = 2;

    /**
     * The annotation view is about to cancel its dragging due to an event.
     */
    public static final int Canceling = 3;

    /**
     * The annotation view's dragging was completed because the user dropped the
     * view.
     */
    public static final int Ending = 4;

    private MKAnnotationViewDragState() {
    }
}
