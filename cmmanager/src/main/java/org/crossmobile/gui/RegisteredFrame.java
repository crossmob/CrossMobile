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
package org.crossmobile.gui;

import com.panayotis.hrgui.HiResFrame;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class RegisteredFrame extends HiResFrame {

    private final static Set<JFrame> FRAMES = new HashSet<>();
    private static Runnable finishCallback;

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        synchronized (FRAMES) {
            if (visible)
                FRAMES.add(this);
            else {
                FRAMES.remove(this);
                if (FRAMES.isEmpty()) {
                    if (finishCallback != null)
                        finishCallback.run();
                    System.exit(0);
                }
            }
        }
    }

    public static int count() {
        return FRAMES.size();
    }

    public static void setFinishCallback(Runnable finishCallback) {
        RegisteredFrame.finishCallback = finishCallback;
    }
}
