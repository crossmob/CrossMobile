/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.bridge;

import org.crossmobile.bridge.resolver.AndroidBridgeResolver;
import org.crossmobile.bridge.resolver.ForeignResolver;
import org.crossmobile.bridge.resolver.SwingBridgeResolver;

import java.io.InputStreamReader;
import java.util.Properties;

import static org.crossmobile.bridge.system.LauncherCommons.OUTPUT_FILE;
import static org.crossmobile.bridge.system.LauncherCommons.OUTPUT_PACKAGE;

/**
 * Native bridge and method factory
 */
@SuppressWarnings({"UseSpecificCatch"})
public abstract class Native {

    private static final boolean runsUnderAndroid;
    private static Native bridge;

    private static ImageBridge image;
    private static SystemBridge system;
    private static FileBridge file;
    private static LifecycleBridge lifecycle;
    private static GraphicsBridge graphics;
    private static SoundBridge sound;
    private static WrapperBridge widget;
    private static WrapperMapBridge map;
    private static InAppBridge inapp;
    private static LocationBridge location;
    private static NetworkBridge network;
    private static SocialBridge social;
    private static UIGuidelinesBridge uiguidelines;
    private static NotificationBridge notification;
    private static ShareBridge share;
    private static SecurityBridge security;
    private static MessageBridge message;

    private static boolean alreadyEarlyInitialized = false;

    static {
        runsUnderAndroid = System.getProperty("java.vm.specification.vendor", "").toLowerCase().contains("android")
                || System.getProperty("java.vm.vendor.url", "").toLowerCase().contains("android")
                || System.getProperty("java.vendor.url", "").toLowerCase().contains("android")
                || System.getProperty("java.vm.name", "").toLowerCase().contains("dalvik")
                || System.getProperty("java.specification.name", "").toLowerCase().contains("dalvik")
                || System.getProperty("java.vm.specification.name", "").toLowerCase().contains("dalvik");
    }

    public static boolean isAndroid() {
        return runsUnderAndroid;
    }

    public static boolean isDesktop() {
        return !runsUnderAndroid;
    }

    private static Native bridge() {
        if (bridge == null)
            if (runsUnderAndroid)
                bridge = AndroidBridgeResolver.resolve();
            else {
                Properties props = new Properties();
                String flavour = "";
                try {
                    props.load(new InputStreamReader(Native.class.getResourceAsStream("/" + OUTPUT_PACKAGE + "/" + OUTPUT_FILE), "UTF-8"));
                    flavour = props.getProperty("flavour", "").toLowerCase().trim();
                } catch (Exception ex) {
                }
                switch (flavour) {
                    case "desktop":
                        bridge = SwingBridgeResolver.resolve();
                        break;
                    case "ios":
                    case "android":
                    case "uwp":
                        ForeignResolver.launch(props, flavour);
                        break;  // will never come here
                    default:
                        if (flavour.isEmpty())
                            throw new RuntimeException("Platform target not set");
                        else
                            throw new RuntimeException("Unable to recognize target '" + flavour + "'");
                }
            }
        return bridge;
    }

    public static ImageBridge image() {
        if (image == null)
            image = bridge().initImage();
        return image;
    }

    public static SystemBridge system() {
        if (system == null)
            system = bridge().initSystem();
        return system;
    }

    public static FileBridge file() {
        if (file == null)
            file = bridge().initFile();
        return file;
    }

    public static LifecycleBridge lifecycle() {
        if (lifecycle == null)
            lifecycle = bridge().initLifecycle();
        return lifecycle;
    }

    public static GraphicsBridge graphics() {
        if (graphics == null)
            graphics = bridge().initGraphics();
        return graphics;
    }

    public static SoundBridge sound() {
        if (sound == null)
            sound = bridge().initSound();
        return sound;
    }

    public static WrapperBridge widget() {
        if (widget == null)
            widget = bridge().initWidget();
        return widget;
    }

    public static WrapperMapBridge mapWidget() {
        if (map == null)
            map = bridge().initMapWidget();
        return map;
    }

    public static InAppBridge inapp() {
        if (inapp == null)
            inapp = bridge().initInApp();
        return inapp;
    }

    public static LocationBridge location() {
        if (location == null)
            location = bridge().initLocation();
        return location;
    }

    public static NetworkBridge network() {
        if (network == null)
            network = bridge().initNetwork();
        return network;
    }

    public static SocialBridge social() {
        if (social == null)
            social = bridge().initSocial();
        return social;
    }

    public static UIGuidelinesBridge uiguidelines() {
        if (uiguidelines == null)
            uiguidelines = bridge().initUIGuidelines();
        return uiguidelines;
    }

    public static NotificationBridge notification() {
        if (notification == null)
            notification = bridge().initNotification();
        return notification;
    }

    public static ShareBridge share() {
        if (share == null)
            share = bridge().initShare();
        return share;

    }

    public static SecurityBridge security() {
        if (security == null)
            security = bridge().initSecurity();
        return security;
    }

    public static MessageBridge message() {
        if (message == null)
            message = bridge().initMessage();
        return message;
    }

    public static void earlyInitialize(Object context) {
        if (!alreadyEarlyInitialized)
            try {
                alreadyEarlyInitialized = true;
                Class.forName("org.crossmobile.sys.PluginsLauncherList").getMethod("earlyInitialize", Object.class).invoke(null, context);
            } catch (Exception ex) {
                Native.system().error("Unable to early initialize plugins", ex);
            }
    }

    protected abstract WrapperMapBridge initMapWidget();

    protected abstract MessageBridge initMessage();

    protected abstract ImageBridge initImage();

    protected abstract SystemBridge initSystem();

    protected abstract LifecycleBridge initLifecycle();

    protected abstract GraphicsBridge initGraphics();

    protected abstract SoundBridge initSound();

    protected abstract WrapperBridge initWidget();

    protected abstract FileBridge initFile();

    protected abstract InAppBridge initInApp();

    protected abstract LocationBridge initLocation();

    protected abstract NetworkBridge initNetwork();

    protected abstract SocialBridge initSocial();

    protected abstract UIGuidelinesBridge initUIGuidelines();

    protected abstract NotificationBridge initNotification();

    protected abstract ShareBridge initShare();

    protected abstract SecurityBridge initSecurity();
}
