/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import com.panayotis.appenh.EnhancerManager;
import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.bind.system.AppConstants;
import org.crossmobile.bridge.Native;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JEmulatorFrame extends JFrame {

    public JEmulatorFrame() {
        pack(); // Or else CGContext retrieval of Graphics2D will not work!
    }

    public JEmulatorFrame(boolean fullscreen) {
        setLayout(new BorderLayout());
        if (!fullscreen) {
            setResizable(false);
            setMinimumSize(new Dimension(80, 80));
        }

        setTitle(AppConstants.DISPLAY_NAME);
        EnhancerManager.getDefault().updateFrameIcons(this);

        KeyboardSupport.setMask(System.getProperty("cm.keyboard.support"));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Native.lifecycle().quit(null, null);
            }

            @Override
            public void windowActivated(WindowEvent we) {
                Native.lifecycle().activate();
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
                Native.lifecycle().deactivate();
            }
        });
    }

    public void postInitialize(boolean isFullScreen) {
        DesktopDrawableMetrics metrics = (DesktopDrawableMetrics) Native.graphics().metrics();
        if (isFullScreen) {
            EnhancerManager.getDefault().toggleFullScreen(this);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            metrics.windowResized(screenSize.width, screenSize.height);
        }
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension size = getContentPane().getSize();
                metrics.windowResized(size.width, size.height);
            }
        });
    }

    @SuppressWarnings("SleepWhileInLoop")
    void shake() {
        try {
            int dt = 30;
            int dx = 2;
            Point p = getLocation();
            for (int i = 0; i < 400 / (dt * 2); i++) {
                setLocation(p.x - dx, p.y);
                Thread.sleep(dt);
                setLocation(p.x + dx, p.y);
                Thread.sleep(dt);
            }
            setLocation(p.x, p.y);
        } catch (InterruptedException ignored) {
        }
    }
}
