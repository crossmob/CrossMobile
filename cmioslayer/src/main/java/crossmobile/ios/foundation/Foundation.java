/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMBundle;
import org.crossmobile.bridge.ann.CMFunction;

import java.util.ArrayList;
import java.util.List;

import static org.crossmobile.bind.io.FileBridgeConstants.DEFAULTPATHS;

/**
 * Foundation class provides a set of useful methods for retrieving directory
 * search paths,current user's temporary directory and home directory path.
 */
@CMBundle
public final class Foundation {

    public static final long NSUIntegerMax = 0x7FFFFFFFFFFFFFFFl;

    private Foundation() {
    }

    /**
     * Returns a list of directory search paths.
     *
     * @param NSSearchPathDirectory  The initial path.
     * @param NSSearchPathDomainMask The mask of the initial path.
     * @param expandTilde            True when the expansion of the initial path is based on the stringByExpandingTildeInPath.
     * @return A list of directory search paths.
     */
    @CMFunction("NSArray<NSString *> * NSSearchPathForDirectoriesInDomains ( NSSearchPathDirectory directory, NSSearchPathDomainMask domainMask, BOOL expandTilde );")
    public static List<String> NSSearchPathForDirectoriesInDomains(int NSSearchPathDirectory, int NSSearchPathDomainMask, boolean expandTilde) {
        List<String> res = new ArrayList<>();
        if (NSSearchPathDirectory >= 0 && NSSearchPathDirectory < DEFAULTPATHS.length && DEFAULTPATHS[NSSearchPathDirectory] != null)
            res.add(NSHomeDirectory() + DEFAULTPATHS[NSSearchPathDirectory]);
        return res;
    }

    /**
     * Returns current user's temporary directory.
     *
     * @return The path of the temporary directory of the current user.
     */
    @CMFunction(" NSString * NSTemporaryDirectory ( void ); ")
    public static String NSTemporaryDirectory() {
        return Native.file().getTemporaryLocation();
    }

    /**
     * Returns the path of the home directory.
     *
     * @return The path of the current home directory.
     */
    @CMFunction(" NSString * NSHomeDirectory ( void ); ")
    public static String NSHomeDirectory() {
        return Native.file().getHomeLocation();
    }

    /**
     * Logs the specified arguments by using the provided format.
     *
     * @param format The format to use
     * @param args   The list of arguments
     */
    @CMFunction("void NSLog(NSString *format, ...);")
    public static void NSLog(String format, Object... args) {
        Native.system().log(NSString.initWithFormat(format, args));
    }
}
