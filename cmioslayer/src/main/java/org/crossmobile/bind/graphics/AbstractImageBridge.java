/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGImage;
import crossmobile.ios.uikit.UIScreen;
import org.crossmobile.bind.graphics.ImageBridgeConstants.ImageInfo;
import org.crossmobile.bridge.ImageBridge;

import java.lang.ref.WeakReference;
import java.util.*;

import static crossmobile.ios.coregraphics.GraphicsDrill.trashCGImageMemory;
import static org.crossmobile.bind.graphics.ImageBridgeConstants.SYSNAME;

public abstract class AbstractImageBridge implements ImageBridge {

    private final Map<String, WeakReference<NativeBitmap>> active = new HashMap<>();
    private static List<WeakReference<CGImage>> pool = new ArrayList<>();
    private final static List<String> extList = Arrays.asList("", ".png", ".jpg", ".jpeg", ".gif", ".tif", ".bmp", ".ico", ".cur", ".xbm", ".bmpf", ".tiff");

    @Override
    public ImageInfo lookup(String name) {
        String lowcase = name.toLowerCase();

        String headless;
        String ext;
        if (lowcase.endsWith(".jpg") || lowcase.endsWith(".gif") || lowcase.endsWith(".png") || lowcase.endsWith(".tif") || lowcase.endsWith(".bmp") || lowcase.endsWith(".ico") || lowcase.endsWith(".cur") || lowcase.endsWith(".xbm")) {
            headless = name.substring(0, name.length() - 4);
            ext = name.substring(name.length() - 4);
        } else if (lowcase.endsWith(".jpeg") || lowcase.endsWith(".bmpf") || lowcase.endsWith(".tiff")) {
            headless = name.substring(0, name.length() - 5);
            ext = name.substring(name.length() - 5);
        } else {
            headless = name;
            ext = "";
        }

        String hires, lowres;
        if (lowcase.startsWith(SYSNAME)) {  // treat system files differently
            if (headless.endsWith("_2x")) {
                hires = headless;
                lowres = hires.substring(0, hires.length() - 3);
            } else {
                hires = headless + "_2x";
                lowres = headless;
            }
            if (sysImageNeedsExtension()) {
                hires += ext;
                lowres += ext;
            }
        } else {
            if (headless.endsWith("@2x")) {
                hires = headless;
                lowres = hires.substring(0, hires.length() - 3);
            } else {
                hires = headless + "@2x";
                lowres = headless;
            }
            hires += ext;
            lowres += ext;
        }

        NativeBitmap bmp;
        if (UIScreen.mainScreen().scale() > 1.2) {  // Display is high resolution - search for @2x images first
            bmp = ext.isEmpty() ? searchForExtensionless(hires) : searchFor(hires);
            if (bmp == null) {
                bmp = ext.isEmpty() ? searchForExtensionless(lowres) : searchFor(lowres);
                return bmp == null ? null : new ImageInfo(bmp, lowres, 1);
            } else
                return new ImageInfo(bmp, hires, 2);
        } else {
            bmp = ext.isEmpty() ? searchForExtensionless(lowres) : searchFor(lowres);
            if (bmp == null) {
                bmp = ext.isEmpty() ? searchForExtensionless(hires) : searchFor(hires);
                return bmp == null ? null : new ImageInfo(bmp, hires, 2);
            } else
                return new ImageInfo(bmp, lowres, 1);
        }
    }

    protected boolean sysImageNeedsExtension() {
        return true;
    }

    @Override
    public void register(CGImage image) {
        pool.add(new WeakReference<>(image));
    }

    private NativeBitmap searchFor(String name) {
        NativeBitmap bm;
        WeakReference<NativeBitmap> found = active.get(name);
        if (found != null) {
            bm = found.get();
            if (bm != null)
                return bm;
        }
        bm = retrieve(name);
        if (bm != null)
            active.put(name, new WeakReference<>(bm));
        return bm;
    }

    private NativeBitmap searchForExtensionless(String name) {
        NativeBitmap bm = null;
        WeakReference<NativeBitmap> found = active.get(name);
        if (found != null) {
            bm = found.get();
            if (bm != null)
                return bm;
        }
        for (String ext : extList)
            if ((bm = retrieve(name + ext)) != null)
                break;
        if (bm != null)
            active.put(name, new WeakReference<>(bm));
        return bm;
    }

    @Override
    public void recycle() {
        active.clear();
        List<WeakReference<CGImage>> next = new ArrayList<>();
        for (WeakReference<CGImage> item : pool) {
            CGImage cur = item.get();
            if (cur != null) {
                trashCGImageMemory(cur);
                next.add(item);
            }
        }
        pool = next;
    }
}
