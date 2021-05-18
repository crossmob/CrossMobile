/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.aroma;

import crossmobile.ios.foundation.NSSelector;
import org.crossmobile.backend.desktop.DesktopSystemBridge;

import java.util.List;

public class AromaSystemBridge extends DesktopSystemBridge {

    @SuppressWarnings("deprecation")
    @Override
    public void showAlert(crossmobile.ios.uikit.UIAlertView view, String title, String message, List<String> buttons, crossmobile.ios.uikit.UIAlertViewDelegate delegate) {
    }

    @Override
    public void showActionSheet(String title, String cancelTitle, String destructiveTitle, List<String> otherTitles, NSSelector<Integer> callback) {
    }

    @Override
    public boolean isRTL() {
        return false;
    }
}
