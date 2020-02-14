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
package org.crossmobile.build.tools;

import org.crossmobile.utils.FileUtils;

import java.io.File;
import java.util.Properties;

public class GenerateSreenSizeSettings {

    private final static String SIZE_PROPERTIES = "SIZE_PROPERTIES";
    private final static String TAB = "    ";


    public static void exec(File source, Properties properties) {
        String screenSizeFile = FileUtils.readResourceSafe("template/screensize");
        String screenScaleProperty = properties.getProperty("cm.screen.scale");
        StringBuilder prop = new StringBuilder();

        if (screenScaleProperty.startsWith("FIXED")) {
            String[] split = screenScaleProperty.split(":");
            String width = split[1];
            String height = split[2];
            prop.append(TAB).append("mode.fixedWidth = ").append(width).append(";\n")
                    .append(TAB).append("mode.fixedHeight = ").append(height).append(";\n")
                    .append(TAB).append("mode.sizeUIWindowToFit = ").append("TRUE").append(";\n");

        }

        if (screenScaleProperty.startsWith("DPI")) {
            prop.append(TAB).append("mode.fixedWidth = ").append(0).append(";\n")
                    .append(TAB).append("mode.fixedHeight = ").append(0).append(";\n")
                    .append(TAB).append("mode.sizeUIWindowToFit = ").append("TRUE").append(";\n")
                    .append(TAB).append("mode.autoMagnification = ").append("TRUE").append(";\n");
        }

        if (screenScaleProperty.startsWith("NATIVE")) {
            prop.append(TAB).append("mode.fixedWidth = ").append(0).append(";\n")
                    .append(TAB).append("mode.fixedHeight = ").append(0).append(";\n")
                    .append(TAB).append("mode.sizeUIWindowToFit = ").append("TRUE").append(";\n")
                    .append(TAB).append("mode.magnification = ").append("1").append(";\n")
                    .append(TAB).append("mode.autoMagnification = ").append("FALSE").append(";\n")
                    .append(TAB).append("mode.useHostScaleFactor = ").append("TRUE").append(";\n");
        }
        prop.append(TAB).append("mode.presentationTransform = ").append(properties.getProperty("orientations.initial")).append(";\n");

        File write = FileUtils.write(new File(source, "cross_screensize.m"), screenSizeFile.replaceAll(SIZE_PROPERTIES, prop.toString()));
        System.out.println(write);

    }
}
