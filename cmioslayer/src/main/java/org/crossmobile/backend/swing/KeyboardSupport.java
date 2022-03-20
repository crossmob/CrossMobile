/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import org.crossmobile.backend.desktop.DesktopLifecycleBridge;
import org.crossmobile.backend.desktop.cgeo.CEventCallback;
import org.crossmobile.bridge.Native;

import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

import static java.awt.event.KeyEvent.VK_CONTROL;
import static org.crossmobile.backend.swing.KeyboardSupport.Action.*;
import static org.crossmobile.bind.system.AbstractLifecycleBridge.memoryWarning;

public class KeyboardSupport {

    enum Action {

        QUIT(1),
        PAUSE(1 << 1),
        BACK(1 << 2),
        MENU(1 << 3),
        HOME(1 << 4),
        ROTATE(1 << 5),
        MULTITOUCH(1 << 7);
        private final int mask;

        private Action(int mask) {
            this.mask = mask;
        }
    }

    private static int mask;

    public static void reactToPressEvent(CEventCallback callback, int vk_event, int modifier) {
        switch (vk_event) {
            case VK_CONTROL:
                if ((mask & MULTITOUCH.mask) != 0)
                    callback.startMultiTouch();
                break;
        }
    }

    public static void reactToReleaseEvent(CEventCallback callback, int vk_event, int modifier) {
        switch (vk_event) {
            case KeyEvent.VK_CONTROL:
                if ((mask & MULTITOUCH.mask) != 0)
                    callback.endMultiTouch();
                break;
            case KeyEvent.VK_B:
            case KeyEvent.VK_BACK_SPACE:
                if ((mask & BACK.mask) != 0)
                    callback.back();
                break;
            case KeyEvent.VK_P:
            case KeyEvent.VK_SPACE:
                if ((mask & PAUSE.mask) != 0)
                    ((DesktopLifecycleBridge) Native.lifecycle()).toggleActivation();
                break;
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_Q:
                if ((mask & QUIT.mask) != 0)
                    callback.powerOff();
                break;
            case KeyEvent.VK_M:
                if (modifier == KeyEvent.CTRL_MASK)
                    memoryWarning();
                break;
            case KeyEvent.VK_H:
            case KeyEvent.VK_HOME:
                if ((mask & HOME.mask) != 0)
                    callback.home();
                break;
            case KeyEvent.VK_LEFT:
                if ((mask & ROTATE.mask) != 0)
                    callback.rotateLeft();
                break;
            case KeyEvent.VK_RIGHT:
                if ((mask & ROTATE.mask) != 0)
                    callback.rotateRight();
                break;
        }
    }

    public static void setMask(String selection) {
        selection = selection == null ? null : selection.toUpperCase();
        if (selection == null || selection.equals("ALL")) {
            mask = QUIT.mask | PAUSE.mask | BACK.mask | MENU.mask | HOME.mask | ROTATE.mask | MULTITOUCH.mask;
            return;
        }
        mask = 0;
        StringTokenizer tk = new StringTokenizer(selection, ":");
        while (tk.hasMoreTokens()) {
            String entry = tk.nextToken().trim();
            for (Action a : Action.values())
                if (entry.equals(a.name())) {
                    mask |= a.mask;
                    break;
                }
        }
    }
}
