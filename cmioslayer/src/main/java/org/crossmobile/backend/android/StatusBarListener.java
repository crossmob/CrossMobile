/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import org.crossmobile.bind.graphics.UIStatusBar;
import org.crossmobile.bridge.Native;

class StatusBarListener {
    private PhoneStateListener phoneStateListener;
    private BroadcastReceiver wifiReceiver;
    private final BroadcastReceiver batteryReceiver;
    private final MainActivity activity;

    static StatusBarListener init(MainActivity activity) {
        return UIStatusBar.required ? new StatusBarListener(activity) : null;
    }

    private StatusBarListener(MainActivity activity) {
        this.activity = activity;
        final UIStatusBar statusBar = UIStatusBar.getStatusBar();

        // WiFi listener
        statusBar.setWifi(-1);
        try {
            ((WifiManager) this.activity.getSystemService(Context.WIFI_SERVICE)).getWifiState();
            // No exception, permission granted
            this.activity.registerReceiver(wifiReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context cntxt, Intent intent) {
                    final WifiManager wifi = (WifiManager) StatusBarListener.this.activity.getSystemService(Context.WIFI_SERVICE);
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
        TelephonyManager gsm = (TelephonyManager) this.activity.getSystemService(Context.TELEPHONY_SERVICE);
        statusBar.setReception(-2);
        gsm.listen(phoneStateListener = new PhoneStateListener() {
            @Override
            @SuppressWarnings({"UseSpecificCatch", "deprecation"})
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                boolean isAirport = false;
                if (Build.VERSION.SDK_INT < 17)
                    isAirport = Settings.System.getInt(StatusBarListener.this.activity.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) != 0;
                else
                    try {
                        isAirport = Settings.Global.getInt(StatusBarListener.this.activity.getContentResolver(), "airplane_mode_on", 0) != 0;
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
        this.activity.registerReceiver(batteryReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context cntxt, Intent intent) {
                statusBar.setBatteryLevel((float) intent.getIntExtra("level", -1) / intent.getIntExtra("scale", -1));
            }
        }, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    void unregister() {
        if (phoneStateListener != null)
            ((TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE)).listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);
        if (wifiReceiver != null)
            activity.unregisterReceiver(wifiReceiver);
        if (batteryReceiver != null)
            activity.unregisterReceiver(batteryReceiver);
        phoneStateListener = null;
    }
}
