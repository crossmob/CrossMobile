/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import org.crossmobile.bridge.Native;

public abstract class DispatchQueue {
    public static DispatchQueue createMainRunLoopDispatchQueue() {
        return new DispatchQueue() {
            @Override
            public void async(Runnable block) {
                Native.lifecycle().postOnEventThread(block);
            }
        };
    }

    public abstract void async(Runnable block);
}
