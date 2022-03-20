/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIView;

public interface FixedSizePainter<T extends UIView> extends ThemePainter<T>, FixedSizeRequirement<T> {
}
