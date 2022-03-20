/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.prefs.Preferences;

public class PreferencesUtils {

    public static boolean addPref(Preferences base, String node, String data) {
        if (base == null || node == null || node.isEmpty() || data == null || data.isEmpty())
            return false;
        try {
            removePref(base, node);
            String[] chunks = TextUtils.split(data, Preferences.MAX_VALUE_LENGTH - 1);
            if (chunks.length == 1)
                base.put(node, chunks[0]);
            else
                for (int i = 0; i < chunks.length; i++)
                    base.node(node).put(String.valueOf(i), chunks[i]);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @SuppressWarnings("UseSpecificCatch")
    public static String getPref(Preferences base, String node) {
        if (base == null || node == null || node.isEmpty())
            return null;
        try {
            String val = base.get(node, null);
            if (val != null)
                return val;
        } catch (Exception ex) {
        }
        try {
            base = base.node(node);
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < base.keys().length; i++) {
                String val = base.get(String.valueOf(i), null);
                if (val == null)
                    return null;
                else
                    out.append(val);
            }
            return out.toString();
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("UseSpecificCatch")
    public static void removePref(Preferences base, String node) {
        if (base == null || node == null || node.isEmpty())
            return;
        try {
            base.node(node).removeNode();
        } catch (Exception ex) {
        }
        try {
            base.remove(node);
        } catch (Exception ex) {
        }
    }
}
