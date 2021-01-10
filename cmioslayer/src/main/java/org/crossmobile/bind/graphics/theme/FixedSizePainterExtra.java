/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIView;

public interface FixedSizePainterExtra<T extends UIView, P extends PainterExtraData> extends ThemePainterExtra<T, P>, FixedSizeRequirement<T> {
}
