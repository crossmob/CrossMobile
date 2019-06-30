/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.bridge;

import crossmobile.ios.uikit.UITextField;
import crossmobile.ios.uikit.UITextView;
import crossmobile.ios.uikit.UIWebView;
import org.crossmobile.bind.wrapper.NativeDispatcher;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;

public interface WrapperBridge<NW> {

    WebWrapper webView(UIWebView parent);

    TextWrapper textField(UITextField parent);

    TextWrapper textView(UITextView parent);

    NativeDispatcher newNativeDispatcher(WidgetWrapper nw);

    void resignFocus();

    void requestFocus(NW nativeWidget);

    void setAttached(NW nativeWidget, boolean isAttached);

    void updateNativeGraphics(String button_up, String button_down);
}
