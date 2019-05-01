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
package org.crossmobile.backend.desktop.cat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ApplicationCatalogue {

    private static final Preferences prefs = Preferences.userNodeForPackage(ApplicationCatalogue.class);

    public static Collection<MobileApp> getApps() {
        Collection<MobileApp> values = new TreeSet<>();
        try {
            Collection<String> obsolete = new ArrayList<>();
            for (String key : prefs.keys()) {
                String node = prefs.get(key, null);
                MobileApp app = MobileApp.fromJSON(node);
                if (app != null)
                    values.add(app);
                else
                    obsolete.add(key);
            }
            for (String key : obsolete)
                remove(key);
        } catch (BackingStoreException ex) {
        }
        return values;
    }

    public static void remove(MobileApp app) {
        remove(app.id());
    }

    private static void remove(String appID) {
        prefs.remove(appID);
        flush();
    }

    public static void store() {
        MobileApp app = MobileApp.current();
        prefs.put(app.id(), app.toJSON());
        flush();
    }

    private static void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
        }
    }

}
