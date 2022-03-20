/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.graphics.Bitmap;
import crossmobile.ios.uikit.UIImageOrientation;
import org.crossmobile.bind.graphics.NativeBitmap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AndroidBitmap implements NativeBitmap {

    final Bitmap bitmap;

    public AndroidBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public int getOrientation() {
        return UIImageOrientation.Up;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    /**
     * Create NinePatch chunk under java based on:
     * https://gist.github.com/briangriffey/4391807
     */
    private byte[] createNinePatchChunk(int top, int right, int bottom, int left) {
        ByteBuffer buffer = ByteBuffer.allocate(56).order(ByteOrder.nativeOrder());
        buffer.put((byte) 0x01);
        buffer.put((byte) 0x02);
        buffer.put((byte) 0x02);
        buffer.put((byte) 0x02);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(left);
        buffer.putInt(right);
        buffer.putInt(top);
        buffer.putInt(bottom);
        buffer.putInt(0x00000001);
        buffer.putInt(0x00000001);
        return buffer.array();
    }
}
