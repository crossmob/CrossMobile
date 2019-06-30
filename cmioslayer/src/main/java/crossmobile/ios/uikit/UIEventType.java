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

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIEventType class defines the type of an event.
 */
@CMEnum
public final class UIEventType {

    /**
     * The event is a touch event.
     */
    public static final int Touches = 0;

    /**
     * The event movement event.
     */
    public static final int Motion = 1;

    /**
     * The event is related to a remote control event.
     */
    public static final int RemoteControl = 2;

    private UIEventType() {
    }

}
