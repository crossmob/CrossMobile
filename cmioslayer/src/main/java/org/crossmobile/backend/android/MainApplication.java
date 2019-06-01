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

import android.app.Application;
import android.content.res.Configuration;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

import java.util.Collection;
import java.util.HashSet;

@CMLib(target = CMLibTarget.ANDROID_PLUGIN)
public class MainApplication extends Application {

    private Collection<ApplicationStateListener> appstates;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (appstates != null)
            for (ApplicationStateListener listener : appstates)
                listener.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Native.prepare(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (appstates != null)
            for (ApplicationStateListener listener : appstates)
                listener.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (appstates != null)
            for (ApplicationStateListener listener : appstates)
                listener.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (appstates != null)
            for (ApplicationStateListener listener : appstates)
                listener.onTrimMemory(level);
    }

    public void register(ApplicationStateListener listener) {
        if (listener != null) {
            if (appstates == null)
                appstates = new HashSet<>();
            appstates.add(listener);
        }
    }

    public void unregister(ApplicationStateListener listener) {
        if (listener != null && appstates != null)
            appstates.remove(listener);
    }
}
