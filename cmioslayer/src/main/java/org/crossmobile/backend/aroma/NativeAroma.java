/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.aroma;

import org.crossmobile.backend.desktop.NativeDesktop;
import org.crossmobile.bridge.*;

public class NativeAroma extends NativeDesktop {

    @Override
    protected ImageBridge initImage() {
        return new AromaImageBridge();
    }

    @Override
    protected SystemBridge initSystem() {
        return new AromaSystemBridge();
    }

    @Override
    protected LifecycleBridge initLifecycle() {
        return new AromaLifecycleBridge();
    }

    @Override
    protected GraphicsBridge initGraphics() {
        return new AromaGraphicsBridge();
    }

    @Override
    protected WrapperUIBridge initWidget() {
        return new AromaWrapperUIBridge();
    }

    @Override
    protected WrapperMapBridge initMapWidget() {
        return parent -> null;
    }

    @Override
    protected WebViewBridge initWebView() {
        return parent -> null;
    }

    @Override
    protected NetworkBridge initNetwork() {
        return new AromaNetworkBridge();
    }

}
