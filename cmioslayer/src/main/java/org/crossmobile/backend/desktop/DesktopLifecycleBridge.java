/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.backend.desktop;

import com.panayotis.appenh.Enhancer;
import com.panayotis.appenh.EnhancerManager;
import crossmobile.ios.uikit.UIDevice;
import crossmobile.ios.uikit.UIUserInterfaceIdiom;
import org.crossmobile.bind.system.AbstractLifecycleBridge;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.system.ClassWalker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class DesktopLifecycleBridge extends AbstractLifecycleBridge {

    private static boolean applicationIsInitialized = false;
    private static boolean initial_activation_performed = false;
    private static DesktopArguments arguments;
    protected Enhancer enhancer;

    /**
     * Desktop backend directly starts this method from the wrapper launcher, so
     * we need to override the default method and provide our own with the
     * required initialization code.
     *
     * @param args
     */
    @Override
    public void init(String[] args) {
        if (!applicationIsInitialized) {
            applicationIsInitialized = true;    // Enter only once
            arguments = new DesktopArguments();
            arguments.parse(args);
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Simple");
            System.setProperty("apple.awt.application.name", "Simple");
            super.init(args);
            enhancer = EnhancerManager.getDefault();
            enhancer.setSafeLookAndFeel();
            enhancer.setApplicationIcons(getAppIcons());
            // ApplicationCatalogue.store();
        }
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

    public static DesktopArguments arguments() {
        return arguments;
    }

    public void toggleActivation() {
        if (((DesktopDrawableMetrics) Native.graphics().metrics()).isActive())
            deactivate();
        else
            activate();
    }

    private static String[] getAppIcons() {
        String systemPrefix = Native.file().getSystemPrefix();
        return new String[]{
                systemPrefix + "icon_16.png", systemPrefix + "icon_24.png",
                systemPrefix + "icon_32.png", systemPrefix + "icon_128.png",
                systemPrefix + "icon_512.png"};
    }

    public static void changeIdiom() {
        Native.lifecycle().quit(null, null);
        try {
            String[] args = new String[]{
                    OperatingSystem.getJavaExec(),
                    "-cp",
                    ClassWalker.getClassPath(),
                    System.getProperty("cm.main.class"),
                    UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Pad ? "--skin=phone" : "--skin=pad"
            };
            Runtime.getRuntime().exec(args);
        } catch (IOException ex) {
        } finally {
            System.exit(0);
        }
    }

    @Override
    public Map<String, Object> launchOptions() {
        return null;
    }
}
