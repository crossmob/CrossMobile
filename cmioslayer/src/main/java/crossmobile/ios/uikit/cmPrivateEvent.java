/*
 * (c) 2019 by Panayotis Katsaloulis
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
