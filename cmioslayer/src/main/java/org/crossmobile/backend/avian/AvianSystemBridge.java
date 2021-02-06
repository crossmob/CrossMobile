/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.uikit.UIAlertView;
import crossmobile.ios.uikit.UIAlertViewDelegate;
import org.crossmobile.backend.desktop.DesktopSystemBridge;

import java.util.List;

public class AvianSystemBridge extends DesktopSystemBridge {

    @Override
    public void showAlert(UIAlertView view, String title, String message, List<String> buttons, UIAlertViewDelegate delegate) {

    }

    @Override
    public void showActionSheet(String title, String cancelTitle, String destructiveTitle, List<String> otherTitles, NSSelector<Integer> callback) {

    }

    @Override
    public boolean isRTL() {
        return false;
    }
}
