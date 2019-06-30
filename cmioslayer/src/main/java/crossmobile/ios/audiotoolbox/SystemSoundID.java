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
package crossmobile.ios.audiotoolbox;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * SystemSoundID class defines option related to alert sounds and alternatives
 * such as vibrations.
 */
@CMEnum
public final class SystemSoundID {

    /**
     * Invokes a brief vibration.
     */
    public static final int Vibrate = 0x00000FFF;

    private SystemSoundID() {
    }
}
