/*
 * (c) 2023 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIView;

public interface FixedSizeRequirement<T extends UIView> {
    int getFixedWidth(T entity);

    int getFixedHeight(T entity);
}
