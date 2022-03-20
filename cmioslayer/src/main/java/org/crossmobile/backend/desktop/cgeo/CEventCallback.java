/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

public interface CEventCallback {

    void home();

    void back();

    void powerOff();

    void endMultiTouch();

    void startMultiTouch();

    void rotateRight();

    void rotateLeft();

    void shake();
}
