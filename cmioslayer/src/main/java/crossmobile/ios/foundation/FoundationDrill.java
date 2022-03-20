/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.LifecycleBridge;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.robovm.objc.block.Block0;

@CMLib(target = CMLibTarget.RUNTIME)
public class FoundationDrill {

    public static NSRunLoop newNSRunLoop(LifecycleBridge.SystemTimerHandler timerHandler) {
        return new NSRunLoop(timerHandler);
    }

    public static void addVirtualUserDefault(String key, Block0<Object> supplier) {
        NSUserDefaults.standardUserDefaults().addVirtualValue(key, supplier);
    }

    public static void quitTimers() {
        NSRunLoop.mainRunLoop().quitTimers();
    }

    public static long fireMillis(NSTimer timer) {
        return timer.fireMillis();
    }

    public static boolean repeats(NSTimer timer) {
        return timer.repeats;
    }
}
