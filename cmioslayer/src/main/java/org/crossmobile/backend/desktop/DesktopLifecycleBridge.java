/*
 * (c) 2020 by Panayotis Katsaloulis
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

public abstract class DesktopLifecycleBridge extends AbstractLifecycleBridge {

    private static boolean applicationIsInitialized = false;
    private static boolean initial_activation_performed = false;

    /**
     * Desktop backend directly starts this method from the wrapper launcher, so
     * we need to override the default method and provide our own with the
     * required initialization code.
     *
     * @param args
     */
    public void init(String[] args, Enhancer enhancer) {
        if (!applicationIsInitialized) {
            applicationIsInitialized = true;    // Enter only once
            super.init(args);
            ((DesktopDrawableMetrics)Native.graphics().metrics()).updateDPI(enhancer.getDPI());
            enhancer.setApplicationIcons(getAppIcons());
            // ApplicationCatalogue.store();
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
}
