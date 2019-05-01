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

import android.content.res.Configuration;
import android.os.Bundle;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.ANDROID_PLUGIN)
public interface ActivityLifecycleListener {

    default void onStart() {
    }

    default void onPause() {
    }

    default void onStop() {
    }

    default void onResume() {
    }

    default void onDestroy() {
    }

    default void onLowMemory() {
    }

    default void onCreate(Bundle savedInstanceState) {
    }

    default void onSaveInstanceState(Bundle outState) {
    }

    default void onConfigurationChanged(Configuration newConfig) {
    }

    default void onOrientationChanged(int newOrientation) {
    }

}
