/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.cat;

public interface IconSelectionListener {

    void iconSelected(MobileApp app);

    void iconInfo(MobileApp app);
}
