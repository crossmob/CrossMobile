/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;
import crossmobile.ios.uikit.UIDeviceOrientation;
import crossmobile.ios.uikit.UIGraphics;
import org.crossmobile.bind.system.AbstractLifecycleBridge;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

import java.util.*;

import static crossmobile.ios.coregraphics.GraphicsDrill.convertBaseContextToCGContext;
import static org.crossmobile.bind.graphics.GraphicsBridgeConstants.DefaultInitialOrientation;
import static org.crossmobile.bind.system.AbstractLifecycleBridge.memoryWarning;

@CMLib(target = CMLibTarget.ANDROID)
public class MainActivity extends Activity {

    private final static String[] args = {};
    static MainActivity current;
    private ActivityStateListener stateListener;
    private Bundle instanceState;
    private boolean launchDebug;
    private Map<String, Object> launchOptions = null;
    private StatusBarListener statusBarListener;

    public static MainActivity current() {
        return current;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchDebug = (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        instanceState = savedInstanceState;
        MainActivity.current = this;
        setContentView(AndroidFileBridge.getResourceID("layout", "crossmobile_core"));
        MainView.current = findViewById(AndroidFileBridge.getResourceID("id", "mainview"));

        Native.destroy();  // Needs a fresh start
        Native.lifecycle().init(args);
        UIGraphics.pushContext(convertBaseContextToCGContext(Native.graphics().newGraphicsContext(null, true)));

        AndroidUIGuidelinesBridge.setTranslucentStatusBar();
        SystemUtilities.launchClass(System.getProperty("cm.main.class"), MainActivity.args);
        OrientationManager.register(this);
        Native.graphics().setOrientation(DefaultInitialOrientation);
        updateOrientation();
        statusBarListener = StatusBarListener.init(this);
        if (launchDebug)
            Native.system().debug("Activity created", null);
        if (stateListener != null)
            stateListener.onCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateOrientation();
        if (stateListener != null)
            stateListener.onConfigurationChanged(newConfig);
        if (launchDebug)
            Native.system().debug("Activity configuration changed", null);
    }

    public void onOrientationChanged(int orientation) {
        if (stateListener != null)
            stateListener.onOrientationChanged(orientation);
        if (launchDebug)
            Native.system().debug("Activity orientation changed", null);
    }

    void updateOrientation() {
        int newOrientation;
        boolean isPortrait = MainActivity.current.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE;
        switch (((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation()) {
            case Surface.ROTATION_90:
                newOrientation = isPortrait ? UIDeviceOrientation.PortraitUpsideDown : UIDeviceOrientation.LandscapeLeft;
                break;
            case Surface.ROTATION_180:
                newOrientation = isPortrait ? UIDeviceOrientation.PortraitUpsideDown : UIDeviceOrientation.LandscapeRight;
                break;
            case Surface.ROTATION_270:
                newOrientation = isPortrait ? UIDeviceOrientation.Portrait : UIDeviceOrientation.LandscapeRight;
                break;
            case Surface.ROTATION_0:
            default:
                newOrientation = isPortrait ? UIDeviceOrientation.Portrait : UIDeviceOrientation.LandscapeLeft;
        }
        Native.graphics().metrics().setOrientationMetrics(newOrientation);
        Native.graphics().relayoutMainView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (stateListener != null)
            stateListener.onStart();
        if (launchDebug)
            Native.system().debug("Activity started", null);
    }

    public Bundle getInstanceState() {
        return instanceState;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Native.lifecycle().deactivate();
        if (stateListener != null)
            stateListener.onPause();
        if (launchDebug)
            Native.system().debug("Activity paused", null);
    }

    /**
     * Suppress background tasks until find a way to properly start it from the
     * Welcome Activity. What if WelcomeActivity is disabled again?
     */
    @Override
    protected void onStop() {
        super.onStop();
        if (stateListener != null)
            stateListener.onStop();
        if (launchDebug)
            Native.system().debug("Activity stopped", null);
        //   finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Native.lifecycle().activate();
        updateOrientation();
        if (stateListener != null)
            stateListener.onResume();
        if (launchDebug)
            Native.system().debug("Activity resumed", null);
    }

    @Override
    public void onBackPressed() {
        if (!((AbstractLifecycleBridge) Native.lifecycle()).backHandled())
//            moveTaskToBack(true);
            super.onBackPressed();
        if (launchDebug)
            Native.system().debug("Activity back pressed", null);
    }

    @Override
    public void finish() {
        if (launchDebug)
            Native.system().debug("Activity terminated", null);
        super.finish();
    }

    @Override
    public void onLowMemory() {
        memoryWarning();
        if (stateListener != null)
            stateListener.onLowMemory();
        super.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        Native.lifecycle().quit(null, null);
        if (statusBarListener != null)
            statusBarListener.unregister();
        if (stateListener != null)
            stateListener.onDestroy();
        MainActivity.current = null;
        MainView.current = null;
        Native.system().debug("Activity destroyed" + (((AndroidLifecycleBridge) Native.lifecycle()).errorFound ? " with error" : ""), null);
        Native.destroy();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (stateListener != null)
            stateListener.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (stateListener != null)
            stateListener.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (stateListener != null)
            stateListener.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (stateListener != null)
            stateListener.onNewIntent(intent);
        if (launchDebug)
            Native.system().debug("New Intent", null);
    }

    private List<Integer> startSpy;

    void startSpying() {
        if (startSpy != null)
            Toast.makeText(this, "Already requesting to start Intent", 2);
        else
            startSpy = new ArrayList<>();
    }

    Collection<Integer> stopSpying() {
        Collection<Integer> result = startSpy;
        startSpy = null;
        return result;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (startSpy != null)
            startSpy.add(requestCode);
        Native.system().debug("Start Activity with code " + requestCode + " and Intent " + (intent == null ? "null" : intent.toString()), null);
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        if (startSpy != null)
            startSpy.add(requestCode);
        super.startActivityForResult(intent, requestCode, options);
    }

    public ActivityStateListener getStateListener() {
        if (stateListener == null)
            stateListener = new ActivityStateListener();
        return stateListener;
    }

    public MainApplication getMainApplication() {
        return (MainApplication) getApplication();
    }

    Map<String, Object> consumeLaunchOptions() {
        Map<String, Object> result = this.launchOptions;
        launchOptions = null;
        return result;
    }

    void dismissLaunchOptions() {
        launchOptions = null;
    }

    public void addLaunchOption(String key, Object value) {
        if (launchOptions == null)
            launchOptions = new HashMap<>();
        launchOptions.put(key, value);
    }
}
