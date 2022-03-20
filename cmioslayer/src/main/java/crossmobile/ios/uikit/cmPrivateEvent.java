/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGPoint;

abstract class cmPrivateEvent extends UIEvent {

    cmPrivateEvent() {
        this(getMinimalTouchEvent(), null);
    }

    cmPrivateEvent(UITouch[] active, Object originalEvent) {
        super(active, originalEvent, UITouchPhase.Began);
    }

    private static UITouch[] getMinimalTouchEvent() {
        UITouch[] touches = new UITouch[1];
        touches[0] = new UITouch(new CGPoint(0, 0), 1, UIApplication.sharedApplication().keyWindow(), 0);
        return touches;
    }

    abstract boolean isHitAllowed(UIView targetView);
}
