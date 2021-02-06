/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import org.crossmobile.backend.desktop.NativeDesktop;
import org.crossmobile.bridge.*;

public class NativeAvian extends NativeDesktop {

    @Override
    protected ImageBridge initImage() {
        return new AvianImageBridge();
    }

    @Override
    protected SystemBridge initSystem() {
        return new AvianSystemBridge();
    }

    @Override
    protected LifecycleBridge initLifecycle() {
        return new AvianLifecycleBridge();
    }

    @Override
    protected GraphicsBridge initGraphics() {
        return new AvianGraphicsBridge();
    }

    @Override
    protected WrapperUIBridge initWidget() {
        return new AvianWrapperUIBridge();
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
        return new AvianNetworkBridge();
    }

}
