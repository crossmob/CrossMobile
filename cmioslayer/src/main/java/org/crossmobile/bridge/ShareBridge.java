/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.uikit.UIActivityViewControllerCompletionWithItemsHandler;

import java.util.List;

public interface ShareBridge {
    void share(List items, List<String> excluded, UIActivityViewControllerCompletionWithItemsHandler completion);
}
