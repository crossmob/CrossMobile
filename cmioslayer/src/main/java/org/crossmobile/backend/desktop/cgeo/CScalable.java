/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

public class CScalable {
    private double scale = 1;

    public void setScale(double scale) {
        this.scale = scale;
    }

    protected int scaled(int value) {
        return (int) (value * scale + 0.5);
    }

    public int unscaled(int value) {
        return (int) (value / scale + 0.5);
    }
}
