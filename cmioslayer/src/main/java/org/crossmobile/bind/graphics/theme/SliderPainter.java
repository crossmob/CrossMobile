/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UISlider;

public interface SliderPainter<P extends PainterExtraData> extends FixedSizePainterExtra<UISlider, P> {
    double setSliderLocation(double x, double width, P extraData);

    void setThumbColor(UIColor thumpColor, P extraData);

    void setPressed(boolean pressed, P extraData);
}
