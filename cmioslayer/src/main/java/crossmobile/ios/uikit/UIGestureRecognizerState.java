/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIGestureRecognizerState class contains all the information related to the
 * current state of a gesture recognizer.
 */
@CMEnum
public final class UIGestureRecognizerState {

    /**
     * The gesture recognizer has not recognized a series of touches as an end
     * of a gesture yet.
     */
    public static final int Possible = 0;

    /**
     * The gesture recognizer began to recognize a series of touches as an end
     * of a gesture.
     */
    public static final int Began = 1;

    /**
     * The gesture recognizer recognized a series of touches as a change of a
     * gesture.
     */
    public static final int Changed = 2;

    /**
     * The gesture recognizer recognized a series of touches as an end of a
     * gesture.
     */
    public static final int Ended = 3;

    /**
     * The gesture recognizer canceled the recognition series of touches as a
     * gesture.
     */
    public static final int Cancelled = 4;

    /**
     * The gesture recognizer failed to recognize a series of touches as a
     * gesture.
     */
    public static final int Failed = 5;

    /**
     * The gesture recognizer recognized series of touches as a gesture.
     */
    public static final int Recognized = Ended;

    private UIGestureRecognizerState() {
    }
}
