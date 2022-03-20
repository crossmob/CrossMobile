/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIActivityIndicatorView;

public interface ActivityIndicatorPainter<P extends PainterExtraData> extends FixedSizePainterExtra<UIActivityIndicatorView, P> {
    void setAnimationFrame(int percent, P extraData);

    double getAnimationFrameDuration();

    int getMaximumFrame();
}
