/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.uikit.UITextField;
import crossmobile.ios.uikit.UITextView;
import org.crossmobile.bind.wrapper.NativeDispatcher;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.WrapperUIBridge;

public class AvianWrapperUIBridge implements WrapperUIBridge<Object> {

    @Override
    public TextWrapper textField(UITextField parent) {
        return null;
    }

    @Override
    public TextWrapper textView(UITextView parent) {
        return null;
    }

    @Override
    public NativeDispatcher newNativeDispatcher(WidgetWrapper nw) {
        return null;
    }

    @Override
    public void resignFocus() {

    }

    @Override
    public void requestFocus(Object nativeWidget) {

    }

    @Override
    public void setAttached(Object nativeWidget, boolean isAttached) {

    }

    @Override
    public void updateNativeGraphics(String button_up, String button_down) {

    }
}
