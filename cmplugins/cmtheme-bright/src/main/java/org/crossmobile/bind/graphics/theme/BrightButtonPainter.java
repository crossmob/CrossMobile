/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIButton;
import org.crossmobile.bind.graphics.GraphicsContext;

public class BrightButtonPainter extends GenericBrightPainter implements ButtonPainter<PainterExtraData> {
    @Override
    public void draw(UIButton entity, CGRect rect, GraphicsContext<?> gcx, PainterExtraData metaData) {
    }
}
