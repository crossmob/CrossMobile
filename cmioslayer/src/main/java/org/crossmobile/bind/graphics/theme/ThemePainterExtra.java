/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIView;

public interface ThemePainterExtra<T extends UIView, P extends PainterExtraData> extends ThemePainter<T> {
    void draw(T entity, CGRect rect, P extraData);

    default void draw(T entity, CGRect rect) {
        throw new NullPointerException("This method should not be called with " + getClass().getName() + "; use \"draw(T entity, CGRect rect, P extraData)\" instead");
    }

    P initExtraData();
}
