/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import com.panayotis.appenh.Enhancer;
import com.panayotis.appenh.EnhancerManager;
import org.crossmobile.bind.system.AbstractLifecycleBridge;
import org.crossmobile.bridge.Native;

import java.io.File;
import java.util.Map;

import static java.util.Collections.singletonList;

public abstract class DesktopLifecycleBridge extends AbstractLifecycleBridge {

    private static boolean initial_activation_performed = false;
    private boolean isQuitting;

    /**
     * Desktop backend directly starts this method from the wrapper launcher, so
     * we need to override the default method and provide our own with the
     * required initialization code.
     *
     * @param args initialization arguments
     */
    public void init(String[] args) {
        super.init(args);
        Enhancer enhancer = EnhancerManager.getDefault();
        enhancer.setApplicationName(System.getProperty("cm.display.name", "CrossMobileApp"));
        ((DesktopDrawableMetrics) Native.graphics().metrics()).updateDPI(enhancer.getDPI());
        if (supportsExtendedVisuals()) {
            enhancer.setSafeLookAndFeel();
            enhancer.setApplicationIcons(getAppIcons());
        }
    }

    @Override
    public void parseArguments(String[] args) {
        new DesktopArguments().parse(args);
    }

    @Override
    public void activate() {
        if (initial_activation_performed)
            super.activate();
        initial_activation_performed = true;
        ((DesktopDrawableMetrics) Native.graphics().metrics()).setActive(true);
    }

    @Override
    public void deactivate() {
        super.deactivate();
        ((DesktopDrawableMetrics) Native.graphics().metrics()).setActive(false);
    }

    @Override
    public void quit(String error, Throwable throwable) {
        if (isQuitting)
            return;
        isQuitting = true;
        super.quit(error, throwable);
        if (error != null && !error.isEmpty()) {
            if (throwable != null)
                throwable.printStackTrace(System.err);
            Native.system().showAlert(null, System.getProperty("cm.display.name"),
                    "Error while executing " + System.getProperty("cm.display.name") + ":\n  " + error,
                    singletonList("Close"),
                    (alertView, buttonIndex) -> System.exit(-1)
            );
        } else
            System.exit(0);
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public long currentAgeInMillis() {
        try {
            return new File(Class.forName(System.getProperty("cm.main.class")).getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).lastModified();
        } catch (Exception ex) {
            try {
                return new File(getClass().getClassLoader().getResource(".").toURI().getPath()).lastModified();
            } catch (Exception ex2) {
                return 0;
            }
        }
    }

    @Override
    public void runOnEventThread(Runnable r) {
        if (isEventThread())
            r.run();
        else
            postOnEventThread(r);
    }

    public void toggleActivation() {
        if (((DesktopDrawableMetrics) Native.graphics().metrics()).isActive())
            deactivate();
        else
            activate();
    }

    protected String[] getAppIcons() {
        String systemPrefix = Native.file().getSystemPrefix();
        return new String[]{
                systemPrefix + "icon_16.png", systemPrefix + "icon_24.png",
                systemPrefix + "icon_32.png", systemPrefix + "icon_128.png",
                systemPrefix + "icon_512.png"};
    }

    @Override
    public Map<String, Object> consumeLaunchOptions() {
        return null;
    }

    /**
     * Mark if extended visuals through Enhancer are supported, i.e. application icon and theming.
     *
     * @return false if run under Avian, false otherwise
     */
    abstract protected boolean supportsExtendedVisuals();
}
