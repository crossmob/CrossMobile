/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

import org.crossmobile.bridge.Native;

public class CEvent {

    private static final int _UNSET = 0;
    private static final int _WINDOW = 1;
    private static final int _SCREEN = 2;
    private static final int _BUTTON = 3;

    private static final int _POWER = 0;
    private static final int _BACK = 1;
    private static final int _HOME = 2;
    private static final int _ACTION = 3;

    private static final CEvent UNSET = new CEvent(_UNSET, -1, null);
    private static final CEvent WINDOW = new CEvent(_WINDOW, -1, null);
    private static final CEvent SCREEN = new CEvent(_SCREEN, -1, null);

    final int type;
    final int buttonIdx;
    final CButton owner;

    private CEvent(int type, int buttonIdx, CButton owner) {
        this.type = type;
        this.buttonIdx = buttonIdx;
        this.owner = owner;
    }

    public static CEvent unset() {
        return UNSET;
    }

    public static CEvent screen() {
        return SCREEN;
    }

    public static CEvent window() {
        return WINDOW;
    }

    public static CEvent power() {
        return new CEvent(_BUTTON, _POWER, null);
    }

    public static CEvent back() {
        return new CEvent(_BUTTON, _BACK, null);
    }

    public static CEvent home() {
        return new CEvent(_BUTTON, _HOME, null);
    }

    public static CEvent action() {
        return new CEvent(_BUTTON, _ACTION, null);
    }

    public boolean isUnset() {
        return type == _UNSET;
    }

    public boolean isArea() {
        return type == _SCREEN;
    }

    public boolean isWindow() {
        return type == _WINDOW;
    }

    public boolean isButton() {
        return type == _BUTTON;
    }

    public CEvent getEvent(CButton owner) {
        // create a new object to break cycle dependency with EButton
        return new CEvent(type, buttonIdx, owner);
    }

    public void performAction(final CEventCallback callback) {
        if (owner.isActive()) {
            owner.setActive(Integer.MIN_VALUE, Integer.MIN_VALUE);
            Native.lifecycle().postOnEventThread(() -> {
                switch (buttonIdx) {
                    case _POWER:
                        callback.powerOff();
                        break;
                    case _BACK:
                        callback.back();
                        break;
                    case _HOME:
                        callback.home();
                        break;
                    case _ACTION:
                        break;
                    default:
                }
            });
        }
    }

    public CButton getOwner() {
        return owner;
    }
}
