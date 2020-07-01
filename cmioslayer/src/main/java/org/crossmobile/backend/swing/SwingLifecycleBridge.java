/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import com.panayotis.appenh.EnhancerManager;
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
        // This should be called before ANY visuals are being initialized. System properties first.
        String appname = System.getProperty("cm.display.name", "CrossMobileApp");
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", appname);
        System.setProperty("apple.awt.application.name", appname);
        EnhancerManager.getDefault().fixDPI();

        Native.lifecycle().loadSystemProperties(); // Load system properties before any actual initialization

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
            SwingGraphicsBridge.frame.add(SwingGraphicsBridge.component = new JEmulatorPanel());
        }

        super.init(args);

        DesktopDrawableMetrics metrics = (DesktopDrawableMetrics) Native.graphics().metrics();
        SwingGraphicsBridge.frame = new JEmulatorFrame(metrics.isFullScreen());
        SwingGraphicsBridge.frame.add(SwingGraphicsBridge.component = new JEmulatorPanel(metrics.isSimulator()), BorderLayout.CENTER);
        Native.graphics().setOrientation(DefaultInitialOrientation);
        SwingGraphicsBridge.frame.setLocationRelativeTo(null);
        SwingGraphicsBridge.frame.setVisible(true);
        SwingGraphicsBridge.frame.postInitialize(metrics.isFullScreen());
        EnhancerManager.getDefault().registerAbout(() -> new AboutDialog(getAppIcons()).setVisible(true));
    }

    @Override
    public void quit(String error, Throwable throwable) {
        if (isQuitting)
            return;
        isQuitting = true;
        if (error != null && !error.isEmpty()) {
            if (throwable != null)
                throwable.printStackTrace();
            if (JOptionPane.showConfirmDialog(null, "Error while executing " + System.getProperty("cm.display.name") + ":\n  " + error + "\n\nDo you want to continue running the application?"
                    , "Error while executing", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.NO_OPTION) {
                super.quit(error, throwable);
                System.exit(-1);
            } else isQuitting = false;
        } else {
            super.quit(error, throwable);
            System.exit(0);
        }
    }

    @Override
    public void splashTerminated() {
        DesktopDrawableMetrics metrics = (DesktopDrawableMetrics) Native.graphics().metrics();
        if (metrics.isFullScreen() || metrics.isSimulator())
            return;
        SwingGraphicsBridge.frame.setResizable(true);
    }

    /**
     * MAKE SURE that this method will run & return IMMEDIATELY when run from
     * the dispatch thread
     *
     * @param r
     */
    @Override
    public void runOnEventThread(Runnable r) {
        if (EventQueue.isDispatchThread())  // Important!! or else will lock
            r.run();
        else
            EventQueue.invokeLater(r);
    }

    @Override
    public boolean isEventThread() {
        return EventQueue.isDispatchThread();
    }

    @Override
    public void postOnEventThread(Runnable r) {
        EventQueue.invokeLater(r);
    }

}
