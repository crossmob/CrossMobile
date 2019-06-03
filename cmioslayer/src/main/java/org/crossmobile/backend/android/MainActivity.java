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
package org.crossmobile.backend.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Global;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.Surface;
import android.view.WindowManager;
import crossmobile.ios.foundation.NSLog;
import crossmobile.ios.uikit.UIDeviceOrientation;
import org.crossmobile.bind.graphics.UIStatusBar;
import org.crossmobile.bind.system.AbstractLifecycleBridge;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

import static org.crossmobile.bind.graphics.GraphicsBridgeConstants.DefaultInitialOrientation;
import static org.crossmobile.bind.system.AbstractLifecycleBridge.memoryWarning;

@CMLib(target = CMLibTarget.ANDROID_PLUGIN)
public class MainActivity extends Activity {

    private final static String[] args = {};
    static MainActivity current;
    private ActivityStateListener stateListener;
    private Bundle instancestate;
    private boolean launchDebug = true;

    public static MainActivity current() {
        return current;
    }

    @Override
    @SuppressWarnings({"UseSpecificCatch"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instancestate = savedInstanceState;
        MainActivity.current = this;
        setContentView(AndroidFileBridge.getResourceID("layout", "crossmobile_core"));
        MainView.current = findViewById(AndroidFileBridge.getResourceID("id", "mainview"));

        Native.destroy();  // Needs a fresh start
        Native.lifecycle().init(args);
        SystemUtilities.launchClass(System.getProperty("cm.main.class"), MainActivity.args);
        OrientationManager.register(this);
        Native.graphics().setOrientation(DefaultInitialOrientation);
        updateOrientation();
        initializeStatusBarListeners();
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
        return instancestate;
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
            if (Native.lifecycle().staysAlive())
                moveTaskToBack(true);
            else
                super.onBackPressed();
        if (launchDebug)
            Native.system().debug("Activity back pressed", null);
    }

    @Override
    public void finish() {
        if (launchDebug)
            NSLog.log("Activity terminated");
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
        if (stateListener != null)
            stateListener.onDestroy();
        MainActivity.current = null;
        MainView.current = null;
        if (launchDebug)
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

    public ActivityStateListener getStateListener() {
        if (stateListener == null)
            stateListener = new ActivityStateListener();
        return stateListener;
    }

    private void initializeStatusBarListeners() {
        if (!UIStatusBar.required)
            return;

        final UIStatusBar statusBar = UIStatusBar.getStatusBar();
        // WiFi listener
        statusBar.setWifi(-1);
        try {
            ((WifiManager) getSystemService(Context.WIFI_SERVICE)).getWifiState();
            // No exception, permission granted
            registerReceiver(new BroadcastReceiver() {
                @Override
                public void onReceive(Context cntxt, Intent intent) {
                    final WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                    try {
                        if (wifi.getWifiState() == WifiManager.WIFI_STATE_ENABLED)
                            for (ScanResult result : wifi.getScanResults())
                                if (result.BSSID.equals(wifi.getConnectionInfo().getBSSID()))
                                    statusBar.setWifi(WifiManager.calculateSignalLevel(wifi.getConnectionInfo().getRssi(), result.level) / (float) result.level);
                    } catch (Exception ignored) {
                    }
                }
            }, new IntentFilter(WifiManager.RSSI_CHANGED_ACTION));
        } catch (Exception ignored) {
        }

        // GSM Listener
        TelephonyManager gsm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        statusBar.setReception(-2);
        gsm.listen(new PhoneStateListener() {

            @Override
            @SuppressWarnings({"UseSpecificCatch"})
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                boolean isAirport = false;
                if (Build.VERSION.SDK_INT < 17)
                    isAirport = Settings.System.getInt(getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) != 0;
                else
                    try {
                        isAirport = Global.getInt(getContentResolver(), "airplane_mode_on", 0) != 0;
                    } catch (Exception ex) {
                        Native.system().debug("Unable to read airport mode", ex);
                    }
                if (isAirport)
                    statusBar.setReception(-1);
                else {
                    int strength = signalStrength.getGsmSignalStrength();
                    if (strength > 31)
                        statusBar.setReception(-2);
                    else
                        statusBar.setReception(strength / 31f);
                }
            }
        }, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);

        // Battery listener
        registerReceiver(new BroadcastReceiver() {

            @Override
            public void onReceive(Context cntxt, Intent intent) {
                statusBar.setBatteryLevel((float) intent.getIntExtra("level", -1) / intent.getIntExtra("scale", -1));
            }
        }, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    public MainApplication getMainApplication() {
        return (MainApplication) getApplication();
    }

}
