/*
 * (c) 2020 by Panayotis Katsaloulis
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
package org.crossmobile.bind.system;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.SystemBridge;

public interface SystemBridgeExt extends SystemBridge {

    boolean Debug = true;

    @Override
    default void runAndWaitOnEventThread(Runnable r) {
        SyncRunnable.start(r);
    }

    @Override
    default String bundleID() {
        return System.getProperty("cm.group.id") + "." + System.getProperty("cm.artifact.id");
    }

    class SyncRunnable implements Runnable {

        private boolean didRun = false; // by default set this thread not to be the same with the caller. If it indeed is, since the runOnUiThread calls directly the "run()" method, this variable is set immediately to "true"
        private final Runnable runnable;

        private SyncRunnable(Runnable runnable) {
            this.runnable = runnable;
        }

        private static void start(Runnable runnable) {
            if (runnable == null)
                return;

            SyncRunnable runner = new SyncRunnable(runnable);
            synchronized (runner) {
                try {
                    Native.system().runOnEventThread(runner); // MAKE SURE that this method will run & return IMMEDIATELY when run from the dispatch thread
                    if (!runner.didRun())
                        runner.wait();
                } catch (InterruptedException ex) {
                }
            }
        }

        @Override
        public synchronized final void run() {
            runnable.run();
            didRun = true;
            notifyAll();
        }

        boolean didRun() {
            return didRun;
        }
    }

}
