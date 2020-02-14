/*
 * (c) 2020 by Panayotis Katsaloulis
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
package org.crossmobile.backend.swing;

import org.crossmobile.backend.desktop.NativeDesktop;
import org.crossmobile.bridge.*;

public class NativeSwing extends NativeDesktop {

    @Override
    protected WrapperMapBridge initMapWidget() {
        return new SwingWrapperMapBridge();
    }

    @Override
    protected ImageBridge initImage() {
        return new SwingImageBridge();
    }

    @Override
    protected SystemBridge initSystem() {
        return new SwingSystemBridge();
    }

    @Override
    protected LifecycleBridge initLifecycle() {
        return new SwingLifecycleBridge();
    }

    @Override
    protected GraphicsBridge initGraphics() {
        return new SwingGraphicsBridge();
    }

    @Override
    protected WrapperBridge initWidget() {
        return new SwingWrapperBridge();
    }
}
