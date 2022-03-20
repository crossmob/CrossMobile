/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.GraphicsDrill;
import crossmobile.ios.uikit.UIGraphics;
import org.crossmobile.bind.graphics.GraphicsContext;

class BrightUtilities {
    static GraphicsContext<?> defaultContext() {
        return GraphicsDrill.context(UIGraphics.getCurrentContext());
    }
}
