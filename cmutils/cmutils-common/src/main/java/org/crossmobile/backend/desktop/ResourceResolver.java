/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import org.robovm.objc.block.VoidBlock1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import static org.crossmobile.backend.desktop.DesktopLocations.FONT_LIST;

public class ResourceResolver {

    public static Collection<String> getFontNames() {
        Collection<String> result = new ArrayList<>();
        getResources(FONT_LIST, inputStream -> {
            //noinspection CharsetObjectCanBeUsed
            try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                String data;
                while ((data = in.readLine()) != null)
                    result.add(data);
            } catch (IOException ignored) {
            }
        });
        return result;
    }

    public static void getResources(String path, VoidBlock1<InputStream> streams) {
        Enumeration<URL> resources;
        try {
            resources = ResourceResolver.class.getClassLoader().getResources(path.startsWith("/") ? path.substring(1) : path);
        } catch (IOException e) {
            return;
        }
        while (resources.hasMoreElements()) {
            try (InputStream inputStream = resources.nextElement().openStream()) {
                streams.invoke(inputStream);
            } catch (Exception ignored) {
            }
        }
    }
}
