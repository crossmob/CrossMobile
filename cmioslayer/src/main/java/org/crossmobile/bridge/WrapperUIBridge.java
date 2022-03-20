/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.uikit.UITextField;
import crossmobile.ios.uikit.UITextView;
import org.crossmobile.bind.wrapper.NativeDispatcher;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;

public interface WrapperUIBridge<NW> {

    TextWrapper textField(UITextField parent);

    TextWrapper textView(UITextView parent);

    NativeDispatcher newNativeDispatcher(WidgetWrapper nw);

    void resignFocus();

    void requestFocus(NW nativeWidget);

    void setAttached(NW nativeWidget, boolean isAttached);

    void updateNativeGraphics(String button_up, String button_down);
}
