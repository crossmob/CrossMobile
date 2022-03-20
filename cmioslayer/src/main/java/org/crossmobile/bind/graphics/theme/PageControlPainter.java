/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIPageControl;

public interface PageControlPainter extends ThemePainter<UIPageControl> {
    CGSize sizeForNumberOfPages(int pageCount);
}
