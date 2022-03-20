/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bind.system.DispatchQueue;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMFunction;

@CMClass
public final class Dispatch extends NSObject {
    private static final Dispatch mainQueue = new Dispatch(DispatchQueue.createMainRunLoopDispatchQueue());

    private final DispatchQueue dispatchQueue;

    private Dispatch(DispatchQueue dispatchQueue) {
        this.dispatchQueue = dispatchQueue;
    }

    @CMFunction("id dispatch_get_main_queue(void);")
    public static Dispatch getMainQueue() {
        return mainQueue;
    }

    @CMFunction("void dispatch_async(id queue, void (^)(void) block);")
    public void async(Runnable block) {
        dispatchQueue.async(block);
    }
}
