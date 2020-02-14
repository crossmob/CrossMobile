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
package org.crossmobile.build.utils;

import java.util.Collection;
import java.util.StringTokenizer;

import static org.crossmobile.build.utils.Templates.*;

public class InfoPlist {

    private String text;

    public InfoPlist(String template) {
        text = template;
    }

    public void setIdentifier(String id) {
        text = text.replace("PROPERTY_BUNDLEIDENTIFIER", id);
    }

    public void setVersion(String version) {
        String[] v = version.split("\\.");
        if (v.length > 3)
            setVersionShort(v[0] + "." + v[1] + "." + v[2]);
        else if (v.length > 2)
            setVersionShort(v[0] + "." + v[1]);
        else setVersionShort(version);
        text = text.replace("PROPERTY_BUNDLEVERSION", version);
    }

    public void setVersionShort(String versionshort) {
        text = text.replace("PROPERTY_BUNDLEVERSION_SHORT", versionshort);
    }

    public void setDisplayName(String name) {
        text = text.replace("PROPERTY_BUNDLEDISPLAYNAME", name);
    }

    public void setStatusBarHidden(String statusbarhidden) {
        text = text.replace("PROPERTY_STATUSBARHIDDEN", toBoolean(statusbarhidden));
    }

    public void setViewControlledStatusBar(String viewcontrolledstatusbar) {
        text = text.replace("PROPERTY_VIEWCONTROLLED_STATUSBAR", toBoolean(viewcontrolledstatusbar));
    }

    public void setFileSharing(String filesharingenabled) {
        text = text.replace("PROPERTY_FILESHARINGENABLED", toBoolean(filesharingenabled));
    }

    public void setDefaultOrientation(String defaultorientation) {
        text = text.replace("PROPERTY_INTERFACE_ORIENTATION", defaultorientation);
    }

    public void setSupportedOrientations(String supportedorientations) {
        text = text.replace("PROPERTY_SUPPORTED_INTERFACE_ORIENTATIONS", getPropertyAsArray("UISupportedInterfaceOrientations",
                "string", supportedorientations));
    }

    public void setFonts(Collection<String> fonts) {
        text = text.replace("PROPERTY_FONTS", getCollectionAsArray("UIAppFonts", "string", fonts));
    }

    public void setApplication(String application) {
        text = text.replace("APP_NAME", application);
    }

    public void setLaunchStoryboard(String launch) {
        text = text.replace("PROPERTY_LAUNCH_STORYBOARD", launch.trim().isEmpty() ? "" : PROPERTY_LAUNCH_STORYBOARD.replace("PROPERTY_LAUNCH_STORYBOARD", launch));
    }

    public void setMainStoryboard(String main) {
        text = text.replace("PROPERTY_MAIN_STORYBOARD", main.trim().isEmpty() ? "" : PROPERTY_MAIN_STORYBOARD.replace("PROPERTY_MAIN_STORYBOARD", main));
    }

    public void setInjected(String injected) {
        text = text.replace("PROPERTY_INJECTED", injected);
    }

    private static String getCollectionAsArray(String keyname, String type, Collection<String> entries) {
        if (entries == null)
            return "";
        StringBuilder result = new StringBuilder();
        for (String token : entries)
            if (token.length() != 0) {
                result.append("\t\t<").append(type).append(">");
                result.append(token).append("</").append(type).append(">\n");
            }
        String array = result.toString();
        return array.length() == 0 ? "" : "\t<key>" + keyname + "</key>\n\t<array>\n" + array + "\t</array>";
    }

    /**
     * Convert a list of entries to an Info.plist array
     *
     * @param keyname The name of the plist entry
     * @param type    The type of the plist entry
     * @param entries The array items, each one separated by colon ":"
     * @return The plist array
     */
    private static String getPropertyAsArray(String keyname, String type, String entries) {
        if (entries == null)
            return "";
        StringBuilder result = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(entries, ":");
        while (tk.hasMoreTokens()) {
            String token = tk.nextToken();
            if (token.length() != 0) {
                result.append("\t\t<").append(type).append(">");
                result.append(token).append("</").append(type).append(">\n");
            }
        }
        String array = result.toString();
        return array.length() == 0 ? "" : "\t<key>" + keyname + "</key>\n\t<array>\n" + array + "\t</array>";
    }

    @Override
    public String toString() {
        return text;
    }

    public static String toBoolean(String value) {
        return value.toLowerCase().equals("true") ? "true" : "false";
    }

    public static int getMaskedOrientations(String given) {
        int maskedOrientation = 0;
        StringTokenizer tk = new StringTokenizer(given, ":");
        while (tk.hasMoreTokens())
            maskedOrientation |= getOrientation(tk.nextToken(), true);
        return maskedOrientation;
    }

    public static int getOrientation(String given, boolean masked) {
        switch (given.toLowerCase()) {
            case "uiinterfaceorientationportrait":
                return masked ? 2 : 1;
            case "uiinterfaceorientationportraitupsidedown":
                return masked ? 4 : 2;
            case "uiinterfaceorientationlandscapeleft":
                return masked ? 8 : 3;
            case "uiinterfaceorientationlandscaperight":
                return masked ? 16 : 4;
            default:
                throw new RuntimeException("Orientation should be one of: \"UIInterfaceOrientationPortrait\", \"UIInterfaceOrientationPortraitUpsideDown\", \"UIInterfaceOrientationLandscapeLeft\", \"UIInterfaceOrientationLandscapeRight\"");
        }
    }
}
