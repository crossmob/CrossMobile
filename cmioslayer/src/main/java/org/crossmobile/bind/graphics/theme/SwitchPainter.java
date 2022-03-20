/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UISwitch;

public interface SwitchPainter<P extends PainterExtraData> extends FixedSizePainterExtra<UISwitch, P> {
    void setThumbColor(UIColor thumpColor, P extraData);

    void setPressed(boolean pressed, P extraData);

    void setValue(boolean status, P extraData);

    boolean setSliderLocation(double x, P extraData);

}
