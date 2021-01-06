/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.graphics.GraphicsContext;

public interface ThemePainter<T extends UIView, P extends PainterExtraData> {
    void draw(T entity, CGRect rect, GraphicsContext<?> gcx, P extraData);

    int getFixedWidth();

    int getFixedHeight();

    P initExtraData();
}
