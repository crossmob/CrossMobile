/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import static org.crossmobile.backend.desktop.DesktopLocations.FONT_LIST;

public class ResourceResolver {

    private static Collection<String> getTextResources(String path) {
        Collection<String> result = new ArrayList<>();
        try {
            Enumeration<URL> resources = ResourceResolver.class.getClassLoader().getResources(path);
            while (resources.hasMoreElements()) {
                //noinspection CharsetObjectCanBeUsed
                try (BufferedReader in = new BufferedReader(new InputStreamReader(resources.nextElement().openStream(), "UTF-8"))) {
                    String data;
                    while ((data = in.readLine()) != null)
                        result.add(data);
                } catch (IOException ignored) {
                }
            }
        } catch (Exception ignored) {
        }
        return result;
    }

    public static Collection<String> getSkinFiles() {
        return getTextResources(DesktopLocations.SKINS.substring(1) + "catalog");
    }

    public static Collection<String> getFontFiles() {
        return getTextResources(FONT_LIST);
    }
}
