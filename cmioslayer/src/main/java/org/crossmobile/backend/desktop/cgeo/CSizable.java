/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

public class CSizable extends CScalable {
    private int virtualWidth;
    private int virtualHeight;

    public CSizable(int width, int height) {
        this.virtualWidth = width;
        this.virtualHeight = height;
    }

    public int hardwareWidth() {
        return scaled(virtualWidth);
    }

    public int hardwareHeight() {
        return scaled(virtualHeight);
    }

    public int virtualWidth() {
        return virtualWidth;
    }

    public int virtualHeight() {
        return virtualHeight;
    }

    protected void resize(int virtualWidth, int virtualHeight) {
        this.virtualWidth = virtualWidth;
        this.virtualHeight = virtualHeight;
    }
}
