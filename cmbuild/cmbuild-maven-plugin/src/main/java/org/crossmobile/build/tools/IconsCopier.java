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
package org.crossmobile.build.tools;

import org.crossmobile.bridge.system.JsonHelper;
import org.crossmobile.utils.images.ImageSet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.crossmobile.build.utils.Templates.ANDROID_ICON;
import static org.crossmobile.utils.FileUtils.readResourceSafe;

public class IconsCopier {

    private static final String defaulticon = "/buildres/layers/defaulticon.png";

    public static final IconRequest[] DesktopIcons = new IconRequest[]{
            new IconRequest(16, "icon_16.png", true),
            new IconRequest(24, "icon_24.png", true),
            new IconRequest(32, "icon_32.png", true),
            new IconRequest(128, "icon_128.png"),
            new IconRequest(512, "icon_512.png"),
    };
    public static final IconRequest[] AndroidIcons = new IconRequest[]{
            new IconRequest(192, "mipmap-xxxhdpi/" + ANDROID_ICON + ".png"),
            new IconRequest(144, "mipmap-xxhdpi/" + ANDROID_ICON + ".png"),
            new IconRequest(96, "mipmap-xhdpi/" + ANDROID_ICON + ".png"),
            new IconRequest(72, "mipmap-hdpi/" + ANDROID_ICON + ".png"),
            new IconRequest(48, "mipmap-mdpi/" + ANDROID_ICON + ".png", true),
    };

    public static IconRequest[] IosIcons(String idiom) {
        List<IconRequest> requests = new ArrayList<>();
        for (Map<String, String> imageType : (List<Map>) ((Map) JsonHelper.decode(readResourceSafe("template/Contents.json"))).get("images"))
            if (idiom.equals("ios") || idiom.equals(imageType.get("idiom")) || imageType.get("idiom").equals("ios-marketing"))
                requests.add(new IconRequest((int) (Integer.parseInt(imageType.get("scale").substring(0, 1)) * Float.parseFloat(imageType.get("size").split("x")[0])),
                        "icon@" + imageType.get("idiom").toUpperCase() + "_" + imageType.get("size").toUpperCase() + "_" + imageType.get("scale").toUpperCase() + ".png"));
        return requests.toArray(new IconRequest[0]);
    }

    public static void copyIcons(File inRoot, File destRoot, IconRequest... iconRequests) {
        ImageSet imageSet = new ImageSet(defaulticon, inRoot);
        for (IconRequest ir : iconRequests)
            imageSet.find(ir.size, ir.required).save(new File(destRoot, ir.path));
    }

    public static class IconRequest {
        private final int size;
        private final String path;
        private final boolean required;

        public IconRequest(int size, String path) {
            this(size, path, false);
        }

        public IconRequest(int size, String path, boolean required) {
            this.size = size;
            this.path = path == null ? "" : path;
            this.required = required;
        }
    }
}
