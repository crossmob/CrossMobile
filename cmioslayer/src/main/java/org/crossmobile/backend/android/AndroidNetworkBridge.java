/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.CookieManager;
import org.crossmobile.bind.io.AbstractNetworkBridge;
import org.crossmobile.bind.io.NativeCookieManager;

public class AndroidNetworkBridge extends AbstractNetworkBridge {

    public AndroidNetworkBridge() {
    }

    @Override
    public boolean openURL(String url) {
        return MainActivity.current.getStateListener().launch(null, new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public NativeCookieManager initNativeManager() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            android.webkit.CookieSyncManager.createInstance(MainActivity.current).sync();
        final CookieManager manager = CookieManager.getInstance();
        manager.setAcceptCookie(true);
        return new NativeCookieManager() {

            @Override
            public void setCookie(String url, String headerValue) {
                manager.setCookie(url, headerValue);
            }

            @Override
            public String getCookie(String url) {
                return manager.getCookie(url);
            }
        };
    }
}
