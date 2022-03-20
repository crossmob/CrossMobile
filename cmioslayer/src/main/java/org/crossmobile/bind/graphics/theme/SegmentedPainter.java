/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIButton;
import crossmobile.ios.uikit.UIImage;

public interface SegmentedPainter<P extends PainterExtraData> extends ThemePainterExtra<UIButton, P> {
    void setAsFirstSegment(P extraData);

    void setAsMiddleSegment(P extraData);

    void setAsLastSegment(P extraData);

    void setSegmentImage(UIImage segmentImage, P extraData);
}
