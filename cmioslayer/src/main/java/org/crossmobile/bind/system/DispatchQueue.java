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
