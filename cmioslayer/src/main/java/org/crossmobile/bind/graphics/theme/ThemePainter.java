/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.graphics.GraphicsContext;

public interface ThemePainter<T extends UIView, E> {
    void draw(T entity, CGRect rect, GraphicsContext<?> gcx, E extraData);

    int getFixedWidth();

    int getFixedHeight();
}
