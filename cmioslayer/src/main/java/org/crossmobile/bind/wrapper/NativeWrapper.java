/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.wrapper;

import org.crossmobile.bind.graphics.GraphicsContext;

public interface NativeWrapper<GCX extends GraphicsContext<?>> {

    void superDraw(GCX cxt);

    void setUserInteraction(boolean status);
}
