/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import com.panayotis.appenh.EnhancerManager;
import crossmobile.ios.foundation.NSTimer;
import crossmobile.ios.uikit.UIGraphics;
import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.backend.desktop.DesktopLifecycleBridge;
import org.crossmobile.bridge.Native;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static crossmobile.ios.coregraphics.GraphicsDrill.convertBaseContextToCGContext;
import static crossmobile.ios.foundation.FoundationDrill.fireMillis;
import static crossmobile.ios.foundation.FoundationDrill.repeats;
import static org.crossmobile.bind.graphics.GraphicsBridgeConstants.DefaultInitialOrientation;

public class SwingLifecycleBridge extends DesktopLifecycleBridge {

    @SuppressWarnings("unchecked")
    @Override
    public void init(String[] args) {
        super.init(args);
        DesktopDrawableMetrics metrics = (DesktopDrawableMetrics) Native.graphics().metrics();
        SwingGraphicsBridge.frame = new JEmulatorFrame(metrics.isFullScreen());
        SwingGraphicsBridge.frame.add(SwingGraphicsBridge.component = new JEmulatorPanel(metrics.isSimulator()), BorderLayout.CENTER);
        Native.graphics().setOrientation(DefaultInitialOrientation);
        SwingGraphicsBridge.frame.setLocationRelativeTo(null);
        SwingGraphicsBridge.frame.setVisible(true);
        SwingGraphicsBridge.frame.postInitialize(metrics.isFullScreen());
        EnhancerManager.getDefault().registerAbout(() -> new AboutDialog(getAppIcons()).setVisible(true));
        UIGraphics.pushContext(convertBaseContextToCGContext(Native.graphics().newGraphicsContext(null, true)));
    }

    @Override
    protected boolean supportsExtendedVisuals() {
        return true;
    }

    @Override
    public void splashTerminated() {
        DesktopDrawableMetrics metrics = (DesktopDrawableMetrics) Native.graphics().metrics();
        if (metrics.isFullScreen() || metrics.isSimulator())
            return;
        SwingGraphicsBridge.frame.setResizable(true);
    }

    @Override
    public boolean isEventThread() {
        return EventQueue.isDispatchThread();
    }

    @Override
    public void postOnEventThread(Runnable r) {
        EventQueue.invokeLater(r);
    }

    @Override
    public SystemTimerHandler createSystemTimer() {
        return new SystemTimerHandler() {

            private final Map<NSTimer, Timer> timers = new HashMap<>();
            boolean active = true;

            @Override
            public synchronized void addTimer(NSTimer timer) {
                if (!active || timer == null || timers.containsKey(timer))
                    return;
                Timer swingTimer = new Timer((int) Math.round(timer.timeInterval() * 1000), e -> {
                    timer.fire();
                    if (!timer.isValid()) {
                        Timer removed = timers.remove(timer);
                        if (removed != null)
                            removed.stop();
                    }
                });
                timers.put(timer, swingTimer);
                swingTimer.setRepeats(repeats(timer));
                swingTimer.setInitialDelay((int) Math.max(fireMillis(timer) - System.currentTimeMillis(), 0));
                swingTimer.start();
            }

            @Override
            public synchronized void quitTimers() {
                active = false;
                for (Timer timer : timers.values())
                    timer.stop();
                timers.clear();
            }
        };
    }
}
