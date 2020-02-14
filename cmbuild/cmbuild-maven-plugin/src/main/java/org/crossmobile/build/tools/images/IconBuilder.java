/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build.tools.images;

import org.crossmobile.bridge.system.JsonHelper;
import org.crossmobile.build.utils.Templates;
import org.crossmobile.utils.images.IconSize;
import org.crossmobile.utils.images.ImageHound;
import org.crossmobile.utils.images.MetaImage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.crossmobile.prefs.Config.*;
import static org.crossmobile.utils.FileUtils.readResourceSafe;

public class IconBuilder {
    private static final String DEFAULT_FORE = "/buildres/layers/icon_fore.png";
    private static final String DEFAULT_BACK = "/buildres/layers/icon_back.png";

    private static final IconSize aBase = new IconSize(48, "mdpi");
    private static final IconSize aaBase = new IconSize(72, "mdpi");
    private static final IconSize dBase = new IconSize(16);

    private static IconSize[] ANDROID_SIZES = {aBase, aBase.scale(1.5, "hdpi"), aBase.scale(2, "xhdpi"),
            aBase.scale(3, "xxhdpi"), aBase.scale(4, "xxxhdpi")};
    private static IconSize[] ADAPTIVE_SIZES = {aaBase, aaBase.scale(1.5, "hdpi"), aaBase.scale(2, "xhdpi"),
            aaBase.scale(3, "xxhdpi"), aaBase.scale(4, "xxxhdpi")};
    private static IconSize[] DESKTOP_SIZES = {dBase, dBase.scale(1.5, true), dBase.scale(2, true),
            dBase.scale(8, false), dBase.scale(32, false)};
    private static IconSize[] IOS_SIZES = getIosIconSizes("ios");
    private static IconSize[] IPHONE_SIZES = getIosIconSizes("iphone");
    private static IconSize[] IPAD_SIZES = getIosIconSizes("ipad");

    @SuppressWarnings("unchecked")
    private static IconSize[] getIosIconSizes(String idiom) {
        Collection<IconSize> result = new ArrayList<>();
        for (Map<String, String> imageMeta : (List<Map<String, String>>) ((Map<Object, Object>) JsonHelper.decode(readResourceSafe("template/Contents.json"))).get("images")) {
            String imgIdiom = imageMeta.getOrDefault("idiom", "");
            if (idiom.equals("ios") || imgIdiom.equals("ios-marketing") || idiom.equals(imgIdiom)) {
                int scale = Integer.parseInt(imageMeta.get("scale").substring(0, 1));
                double size = Double.parseDouble(imageMeta.get("size").split("x")[0]);
                result.add(new IconSize(size, imgIdiom).scale(scale, true));
            }
        }
        return result.toArray(new IconSize[0]);
    }

    public static ImageHound getDefaultHound(File baseDir) {
        return new ImageHound().addForegroundImages(DEFAULT_FORE, new File(baseDir, FORE_ICONS)).addBackgroundImages(DEFAULT_BACK, new File(baseDir, BACK_ICONS));
    }

    public static ImageHound copyIcons(ImageHound images, File destRoot, IconType iconType) {
        for (IconSize is : iconType.sizes) {
            MetaImage foreImage = images.findFore(is.pixels, is.required);
            if (foreImage.isValid()) {
                MetaImage backImage = images.findBack(is.pixels, true);
                if (iconType.splitBackground) {
                    foreImage.withCanvas(backImage.size).save(new File(destRoot, iconType.toPath(is, "foreground")));
                    backImage.save(new File(destRoot, iconType.toPath(is, "background")));
                } else
                    foreImage.withBackground(backImage).save(new File(destRoot, iconType.toPath(is, "")));
            }
        }
        return images;
    }

    public static void copyMask(ImageHound images, File baseDir, File destRoot) {
        new ImageHound().addForegroundImages(images.findFore(72, true), new File(baseDir, MASK_ICONS))
                .findFore(72, true).asAlpha().save(new File(destRoot, "drawable/masked_icon.png"));
    }

    public enum IconType {
        BASE_ANDROID(ANDROID_SIZES, "mipmap-%N/" + Templates.ANDROID_ICON + ".png"),
        ADAPTIVE_ANDROID(ADAPTIVE_SIZES, "drawable-%N/" + Templates.ANDROID_ICON + "_%T.png", true),
        DESKTOP(DESKTOP_SIZES, "icon_%P.png"),
        IOS(IOS_SIZES, "icon@%N_%Sx%S_%Cx.png"),
        IPHONE(IPHONE_SIZES, "icon@%N_%Sx%S_%Cx.png"),
        IPAD(IPAD_SIZES, "icon@%N_%Sx%S_%Cx.png");

        private final IconSize[] sizes;
        private final String pattern;
        private final boolean splitBackground;

        IconType(IconSize[] sizes, String pattern, boolean splitBackground) {
            this.sizes = sizes;
            this.pattern = pattern;
            this.splitBackground = splitBackground;
        }

        IconType(IconSize[] desktopSizes, String pattern) {
            this(desktopSizes, pattern, false);
        }

        private String toPath(IconSize size, String tag) {
            return pattern.replaceAll("%T", tag)
                    .replaceAll("%S", size.size())
                    .replaceAll("%P", size.pixels())
                    .replaceAll("%N", size.name)
                    .replaceAll("%C", String.valueOf(Math.round(size.scale)));
        }
    }
}
