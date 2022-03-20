/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

public class Insets {

    public final int top;
    public final int left;
    public final int bottom;
    public final int right;

    public static final Insets zero = new Insets(0, 0, 0, 0);

    public Insets(int top, int left, int bottom, int right) {
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

}
