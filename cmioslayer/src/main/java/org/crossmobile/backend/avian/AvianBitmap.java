/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.uikit.UIImageOrientation;
import org.crossmobile.bind.graphics.NativeBitmap;

public class AvianBitmap implements NativeBitmap {
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getOrientation() {
        return UIImageOrientation.Up;
    }
}
