/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import org.crossmobile.bind.system.init.PluginsLauncherList;
import org.crossmobile.bridge.resolver.AndroidBridgeResolver;
import org.crossmobile.bridge.resolver.SwingBridgeResolver;

/**
 * Native bridge and method factory
 */
@SuppressWarnings({"UseSpecificCatch"})
public abstract class Native {

    private static boolean runsUnderAndroid = false;
    private static boolean alreadyEarlyInitialized = false;
    private static Native bridge;

    private ImageBridge image;
    private SystemBridge system;
    private FileBridge file;
    private LifecycleBridge lifecycle;
    private GraphicsBridge<?, ?> graphics;
    private SoundBridge sound;
    private WrapperUIBridge<?> widget;
    private WebViewBridge webview;
    private WrapperMapBridge map;
    private InAppBridge inapp;
    private LocationBridge location;
    private NetworkBridge network;
    private SocialBridge social;
    private UIGuidelinesBridge uiguidelines;
    private NotificationBridge notification;
    private ShareBridge share;
    private SecurityBridge security;
    private MessageBridge message;

    static {
        try {
            runsUnderAndroid = AndroidBridgeResolver.isActive();
        } catch (Throwable ignored) {
        }
    }

    public static boolean isAndroid() {
        return runsUnderAndroid;
    }

    public static boolean isSwing() {
        return !runsUnderAndroid;
    }

    public static void prepare(Object context) {
        if (!alreadyEarlyInitialized)
            try {
                alreadyEarlyInitialized = true;
                PluginsLauncherList.earlyInitialize(context);
            } catch (Throwable ex) {
                Native.system().error("Unable to early initialize plugins", ex);
            }
    }

    public static void destroy() {
        bridge = null;
    }

    private static Native bridge() {
        if (bridge == null)
            bridge = runsUnderAndroid
                    ? AndroidBridgeResolver.resolve()
                    : SwingBridgeResolver.resolve();
        return bridge;
    }

    public static LifecycleBridge lifecycle() {
        if (bridge().lifecycle == null)         // WARNING: NEEDS TO BE A METHOD CALL. It's the first to call after prepare
            bridge.lifecycle = bridge.initLifecycle();
        return bridge.lifecycle;
    }

    public static ImageBridge image() {
        if (bridge().image == null)
            bridge.image = bridge.initImage();
        return bridge.image;
    }

    public static SystemBridge system() {
        if (bridge().system == null)
            bridge.system = bridge.initSystem();
        return bridge.system;
    }

    public static FileBridge file() {
        if (bridge().file == null)
            bridge.file = bridge.initFile();
        return bridge.file;
    }

    @SuppressWarnings("rawtypes")
    public static GraphicsBridge graphics() {
        if (bridge().graphics == null)
            bridge.graphics = bridge.initGraphics();
        return bridge.graphics;
    }

    public static SoundBridge sound() {
        if (bridge().sound == null)
            bridge.sound = bridge.initSound();
        return bridge.sound;
    }

    @SuppressWarnings("rawtypes")
    public static WrapperUIBridge widget() {
        if (bridge().widget == null)
            bridge.widget = bridge.initWidget();
        return bridge.widget;
    }

    public static WebViewBridge webview() {
        if (bridge().webview == null)
            bridge.webview = bridge.initWebView();
        return bridge.webview;
    }

    public static WrapperMapBridge mapWidget() {
        if (bridge().map == null)
            bridge.map = bridge().initMapWidget();
        return bridge.map;
    }

    public static InAppBridge inapp() {
        if (bridge().inapp == null)
            bridge.inapp = bridge.initInApp();
        return bridge.inapp;
    }

    public static LocationBridge location() {
        if (bridge().location == null)
            bridge.location = bridge.initLocation();
        return bridge.location;
    }

    public static NetworkBridge network() {
        if (bridge().network == null)
            bridge.network = bridge.initNetwork();
        return bridge.network;
    }

    public static SocialBridge social() {
        if (bridge().social == null)
            bridge.social = bridge.initSocial();
        return bridge.social;
    }

    public static UIGuidelinesBridge uiguidelines() {
        if (bridge().uiguidelines == null)
            bridge.uiguidelines = bridge.initUIGuidelines();
        return bridge.uiguidelines;
    }

    public static NotificationBridge notification() {
        if (bridge().notification == null)
            bridge.notification = bridge.initNotification();
        return bridge.notification;
    }

    public static ShareBridge share() {
        if (bridge().share == null)
            bridge.share = bridge.initShare();
        return bridge.share;

    }

    public static SecurityBridge security() {
        if (bridge().security == null)
            bridge.security = bridge.initSecurity();
        return bridge.security;
    }

    public static MessageBridge message() {
        if (bridge().message == null)
            bridge.message = bridge.initMessage();
        return bridge.message;
    }


    protected abstract WrapperMapBridge initMapWidget();

    protected abstract MessageBridge initMessage();

    protected abstract ImageBridge initImage();

    protected abstract SystemBridge initSystem();

    protected abstract LifecycleBridge initLifecycle();

    protected abstract GraphicsBridge<?, ?> initGraphics();

    protected abstract SoundBridge initSound();

    protected abstract WrapperUIBridge<?> initWidget();

    protected abstract WebViewBridge initWebView();

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
