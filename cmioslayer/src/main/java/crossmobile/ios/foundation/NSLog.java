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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMBundle;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

/**
 * NSLog class is used in order to log messages related to errors.
 */
@CMLib(target = CMLibTarget.API_NOUWP)
@CMBundle
public final class NSLog {

    private NSLog() {
    }

    /**
     * Logs the specified arguments by using the provided format.
     *
     * @param format The format to use
     * @param args   The list of arguments
     */
    @CMFunction("void NSLog(NSString *format, ...);")
    public static void log(String format, Object... args) {
        Native.system().error(NSString.initWithFormat(format, args), null);
    }
}
