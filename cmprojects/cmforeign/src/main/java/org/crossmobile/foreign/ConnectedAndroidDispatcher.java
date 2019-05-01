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
package org.crossmobile.foreign;

import java.io.File;
import java.util.*;

public class ConnectedAndroidDispatcher {

    private final static long SLEEP = 1000;
    private final static ConnectedAndroidDispatcher INSTANCE = new ConnectedAndroidDispatcher();

    private File adb;
    private Collection<AndroidDevice> olddev = null;
    private final Set<AListener> listeners = new HashSet<>();

    private Thread thread;

    public static void addListener(AListener aListener) {
        synchronized (INSTANCE.listeners) {
            INSTANCE.listeners.add(aListener);
            INSTANCE.listeners.notify();
            INSTANCE.initThread();
        }
    }

    public static void removeListener(AListener listener) {
        synchronized (INSTANCE.listeners) {
            INSTANCE.listeners.remove(listener);
            INSTANCE.listeners.notify();
        }
    }

    public static void setAdbLocation(String adb) {
        if (adb != null)
            INSTANCE.adb = new File(adb);
    }

    private ConnectedAndroidDispatcher() {
    }

    private void initThread() {
        if (thread != null || adb == null || !adb.isFile() || listeners.isEmpty())
            return;
        thread = new Thread(() -> {
            while (!thread.isInterrupted() && !listeners.isEmpty()) {
                List<AndroidDevice> devices = new ArrayList<>();
                for (String id : getAndroidIDs()) {
                    AndroidDevice dev = getAndroidDevice(id);
                    if (dev != null)
                        devices.add(dev);
                }
                sendList(devices);
                sleep();
            }
        }, "Android Device Listener");
        thread.setDaemon(true);
        thread.start();
    }

    public interface AListener {

        void onDeviceStateChange(List<AndroidDevice> devices);
    }

    private List<String> getAndroidIDs() {
        Commander cmd = new Commander(adb.getAbsolutePath(), "devices");
        List<String> ids = new ArrayList<>();
        cmd.setOutListener(data -> {
            data = data.trim();
            if (!data.startsWith("*") && !data.toLowerCase().startsWith("list of")) {
                String[] dev = data.split("\\s");
                if (dev.length > 1)
                    ids.add(dev[0].trim());
            }
        });
        cmd.exec();
        cmd.waitFor();
        return ids;
    }

    private AndroidDevice getAndroidDevice(String id) {
        Commander cmd = new Commander(adb.getAbsolutePath(), "-s", id, "shell", "getprop");
        AndroidDevice dev = new AndroidDevice(id);
        cmd.setOutListener(dev::addPropertyLine);
        cmd.exec();
        cmd.waitFor();
        return dev.getName() != null ? dev : null;
    }

    private void sleep() {
        synchronized (listeners) {
            try {
                listeners.wait(listeners.isEmpty() ? 0 : SLEEP);
            } catch (InterruptedException ex) {
            }
        }
    }

    private void sendList(List<AndroidDevice> newdev) {
        Collections.sort(newdev);
        if ((olddev == null ? -1 : olddev.size()) != newdev.size() || !olddev.containsAll(newdev))
            for (AListener listener : listeners)
                listener.onDeviceStateChange(newdev);
        olddev = newdev;
    }
}
