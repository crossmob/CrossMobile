/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIScrollView;

public interface ScrollPainter<P extends PainterExtraData> extends ThemePainterExtra<UIScrollView, P> {

    void startFlashing(P extraData);

    void endFlashing(P extraData);

    void setFlashPercent(double progress, P extraData);
}
