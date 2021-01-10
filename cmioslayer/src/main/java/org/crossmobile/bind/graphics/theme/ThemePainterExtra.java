/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIView;

public interface ThemePainterExtra<T extends UIView, P extends PainterExtraData> extends ThemePainter<T> {
    void draw(T entity, CGRect rect, P extraData);

    default void draw(T entity, CGRect rect) {
        draw(entity, rect, null);
    }

    P initExtraData();
}
