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

import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.backend.desktop.DesktopLifecycleBridge;
import org.crossmobile.bridge.Native;

import javax.swing.*;
import java.awt.*;

import static org.crossmobile.bind.graphics.GraphicsBridgeConstants.DefaultInitialOrientation;

public class SwingLifecycleBridge extends DesktopLifecycleBridge {

    private boolean isQuitting;

    @Override
    public void init(String[] args) {
        /*
         * Initialization of JFrame is required early by CGContext.
         * Decoration though is set later on, after JFrame initialization.
         * As a result,  we perform a bogus JFrame initialization to make
         * CGContext happy, and initialize the actual JFrame later on.
         *
         * In the preArgInit() method, might destroy frame (i.e. when images native
         * items are grabbed). Thus it is important to re-create the frame
         * in the postInit() method.
         */
        if (SwingGraphicsBridge.frame == null) {
            SwingGraphicsBridge.frame = new JEmulatorFrame();
            SwingGraphicsBridge.component = new JEmulatorPanel();
            SwingGraphicsBridge.frame.add(SwingGraphicsBridge.component);
            SwingGraphicsBridge.frame.pack(); // Or else CGContext retrieval of Graphics2D will not work!
        }

        super.init(args);

        SwingGraphicsBridge.frame = new JEmulatorFrame();
        SwingGraphicsBridge.frame.initialize(((DesktopDrawableMetrics) Native.graphics().metrics()).isDecorated());
        SwingGraphicsBridge.component = new JEmulatorPanel();
        SwingGraphicsBridge.frame.setLayout(new BorderLayout());
        SwingGraphicsBridge.frame.add(SwingGraphicsBridge.component, BorderLayout.CENTER);
        SwingGraphicsBridge.frame.setResizable(false);

        double scale = arguments().getScale(Native.graphics().metrics().getIdiom());
        Native.graphics().metrics().setScaling(scale, scale, true);
        Native.graphics().setOrientation(DefaultInitialOrientation);
        Native.graphics().relayoutMainView();
        SwingGraphicsBridge.frame.setLocationRelativeTo(null);  // should center before relayoutMainView, since relayoutMainView shows frame
        SwingGraphicsBridge.frame.addResizeListener();
        SwingGraphicsBridge.frame.setVisible(true);
        enhancer.registerAbout(this::showAbout);
    }

    private void showAbout() {
        new AboutDialog().setVisible(true);
    }

    @Override
    public void quit(String error, Throwable throwable) {
        if (isQuitting)
            return;
        isQuitting = true;
        super.quit(error, throwable);
        if (error != null && !error.isEmpty()) {
            JOptionPane.showMessageDialog(null, error, "Error while executing CrossMobile", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        } else
            System.exit(0);
    }

    @Override
    public void splashTerminated() {
        SwingGraphicsBridge.frame.setResizable(true);
    }
}
