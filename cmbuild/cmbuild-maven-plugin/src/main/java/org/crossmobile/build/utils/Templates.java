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

public class Templates {

    public static final String APPLICATIONEXTRAS_ANCHOR = "__APPLICATIONEXTRAS__";
    public static final String BUNDLEID_ANCHOR = "__BUNDLEID__";
    public static final String DISPLAYNAME_ANCHOR = "__DISPLAYNAME__";
    public static final String DEBUGGABLE_ANCHOR = "__DEBUGGABLE__";
    public static final String PERMISSIONS_ANCHOR = "__USES_PERMISSION__";
    public static final String VERSIONCODE_ANCHOR = "__VERSIONCODE__";
    public static final String VERSION_ANCHOR = "__VERSION__";
    public static final String PLUGININITIALIZER_ANCHOR = "__INITIALIZER__";
    public static final String PLUGINEARLYINITIALIZER_ANCHOR = "__EARLY_INITIALIZER__";
    public static final String EXTENSION_ANCHOR = "__EXTENSION__";

    public static final String CURRENT_ACTIVITY = "CMLauncher";
    public static final String CURRENT_APPLICATION = "CMApplication";

    public static final String APPLICATION_ID = "__APPLICATION_ID__";
    public static final String DEPENDENCIES = "__DEPENDENCIES__";
    public static final String ANDROID_ICON = "appicon";

    public static final String AUTOGEN_TEMPLATE
            = "/* AUTO-GENERATED FILE. DO NOT MODIFY.\n"
            + " *\n"
            + " * This file was created automatically by the CrossMobile tools.\n"
            + " * It should not be modified by hand.\n"
            + " */\n"
            + "\n";

    public static final String PLUGININTIALIZER_TEMPLATE
            = AUTOGEN_TEMPLATE
            + "package org.crossmobile.sys;\n"
            + "\n"
            + "public class PluginsLauncherList {\n"
            + "\n"
            + "    @SuppressWarnings(\"UseSpecificCatch\")\n"
            + "    public static void initialize() {\n"
            + PLUGININITIALIZER_ANCHOR
            + "    }\n"
            + "\n"
            + "    @SuppressWarnings(\"UseSpecificCatch\")\n"
            + "    public static void earlyInitialize(Object context) {\n"
            + PLUGINEARLYINITIALIZER_ANCHOR
            + "    }\n"
            + "}\n";

    public static final String LAUNCHACTIVITY_TEMPLATE
            = AUTOGEN_TEMPLATE
            + "package " + BUNDLEID_ANCHOR + ";\n"
            + "public class " + CURRENT_ACTIVITY + " extends org.crossmobile.backend.android.MainActivity {\n"
            + "}\n";

    public static final String LAUNCHAPPLICATION_TEMPLATE
            = AUTOGEN_TEMPLATE
            + "package " + BUNDLEID_ANCHOR + ";\n"
            + "public class " + CURRENT_APPLICATION + " extends org.crossmobile.backend.android.MainApplication {\n"
            + "}\n";

    public static final String INFO_PLIST
            = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n"
            + "<plist version=\"1.0\">\n"
            + "<dict>\n"
            + "\t<key>UIStatusBarHidden</key>\n"
            + "\t<PROPERTY_STATUSBARHIDDEN/>\n"
            + "\t<key>UIViewControllerBasedStatusBarAppearance</key>\n"
            + "\t<PROPERTY_VIEWCONTROLLED_STATUSBAR/>\n"
            + "\t<key>UIFileSharingEnabled</key>\n"
            + "\t<PROPERTY_FILESHARINGENABLED/>\n"
            + "\t<key>CFBundleDevelopmentRegion</key>\n"
            + "\t<string>English</string>\n"
            + "\t<key>CFBundleDisplayName</key>\n"
            + "\t<string>PROPERTY_BUNDLEDISPLAYNAME</string>\n"
            + "\t<key>CFBundleExecutable</key>\n"
            + "\t<string>APP_NAME</string>\n"
            + "\t<key>CFBundleIdentifier</key>\n"
            + "\t<string>PROPERTY_BUNDLEIDENTIFIER</string>\n"
            + "\t<key>CFBundleInfoDictionaryVersion</key>\n"
            + "\t<string>6.0</string>\n"
            + "\t<key>CFBundleName</key>\n"
            + "\t<string>APP_NAME</string>\n"
            + "\t<key>CFBundlePackageType</key>\n"
            + "\t<string>APPL</string>\n"
            + "\t<key>CFBundleSignature</key>\n"
            + "\t<string>????</string>\n"
            + "\t<key>CFBundleVersion</key>\n"
            + "\t<string>PROPERTY_BUNDLEVERSION</string>\n"
            + "\t<key>CFBundleShortVersionString</key>\n"
            + "\t<string>PROPERTY_BUNDLEVERSION_SHORT</string>\n"
            + "\t<key>LSRequiresIPhoneOS</key>\n"
            + "\t<true/>\n"
            + "\t<key>UIInterfaceOrientation</key>\n"
            + "\t<string>PROPERTY_INTERFACE_ORIENTATION</string>\n"
            + "PROPERTY_MAIN_STORYBOARD"
            + "PROPERTY_LAUNCH_STORYBOARD"
            + "PROPERTY_SUPPORTED_INTERFACE_ORIENTATIONS\n"
            + "PROPERTY_FONTS"
            + "PROPERTY_INJECTED"
            + "</dict>\n"
            + "</plist>\n";

    public static final String EXT_INFO_PLIST
            = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
            "<plist version=\"1.0\">\n" +
            "<dict>\n" +
            "\t<key>CFBundleDevelopmentRegion</key>\n" +
            "\t<string>$(DEVELOPMENT_LANGUAGE)</string>\n" +
            "\t<key>CFBundleDisplayName</key>\n" +
            "\t<string>" + DISPLAYNAME_ANCHOR + "</string>\n" +
            "\t<key>CFBundleExecutable</key>\n" +
            "\t<string>$(EXECUTABLE_NAME)</string>\n" +
            "\t<key>CFBundleIdentifier</key>\n" +
            "\t<string>" + BUNDLEID_ANCHOR + "</string>\n" +
            "\t<key>CFBundleInfoDictionaryVersion</key>\n" +
            "\t<string>6.0</string>\n" +
            "\t<key>CFBundleName</key>\n" +
            "\t<string>$(PRODUCT_NAME)</string>\n" +
            "\t<key>CFBundlePackageType</key>\n" +
            "\t<string>XPC!</string>\n" +
            "\t<key>CFBundleShortVersionString</key>\n" +
            "\t<string>1.0</string>\n" +
            "\t<key>CFBundleVersion</key>\n" +
            "\t<string>1</string>\n" +
            "\t<key>NSExtension</key>\n" +
            "\t<dict>\n" + EXTENSION_ANCHOR + "\t</dict>\n" +
            "</dict>\n" +
            "</plist>";

    public static String PROPERTY_MAIN_STORYBOARD =
            "\t<key>UIMainStoryboardFile</key>\n"
                    + "\t<string>PROPERTY_MAIN_STORYBOARD</string>\n";

    public static String PROPERTY_LAUNCH_STORYBOARD =
            "\t<key>UILaunchStoryboardName</key>\n"
                    + "\t<string>PROPERTY_LAUNCH_STORYBOARD</string>\n";

    public static final String ANDROID_MANIFEST = ""
            + "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
            + "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" android:versionCode=\"" + VERSIONCODE_ANCHOR + "\" android:versionName=\"" + VERSION_ANCHOR + "\" package=\"" + BUNDLEID_ANCHOR + "\">\n"
            + "    <application android:hardwareAccelerated=\"true\" android:name=\"" + BUNDLEID_ANCHOR + "." + CURRENT_APPLICATION + "\" android:icon=\"@mipmap/" + ANDROID_ICON + "\"  android:label=\"" + DISPLAYNAME_ANCHOR + "\" android:theme=\"@style/Theme.NoBackground.Fullscreen\">\n"
            + "        <provider\n"
            + "            android:name=\"androidx.core.content.FileProvider\"\n"
            + "            android:authorities=\"" + BUNDLEID_ANCHOR + ".provider\"\n"
            + "            android:exported=\"false\"\n"
            + "            android:grantUriPermissions=\"true\">\n"
            + "            <meta-data\n"
            + "                android:name=\"android.support.FILE_PROVIDER_PATHS\"\n"
            + "                android:resource=\"@xml/base_path\">\n"
            + "                </meta-data>\n"
            + "        </provider>\n"
            + "        <activity android:launchMode=\"singleTask\" android:name=\"" + BUNDLEID_ANCHOR + "." + CURRENT_ACTIVITY + "\" android:configChanges=\"keyboardHidden|orientation|screenSize\" android:screenOrientation=\"portrait\">\n"
            + "            <intent-filter>\n"
            + "                <action android:name=\"android.intent.action.MAIN\"/>\n"
            + "                <category android:name=\"android.intent.category.LAUNCHER\"/>\n"
            + "            </intent-filter>\n"
            + "        </activity>\n"
            //            + "        <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />\n"
            + "        <meta-data android:name=\"android.max_aspect\" android:value=\"2.1\" />\n"
            + APPLICATIONEXTRAS_ANCHOR
            + "    </application>\n"
            + "    <supports-screens android:anyDensity=\"true\" android:smallScreens=\"true\" android:normalScreens=\"true\" android:largeScreens=\"true\" android:xlargeScreens=\"true\"/>\n"
            + PERMISSIONS_ANCHOR
            + "</manifest>\n";

    public static final String BASEPATH_ANDROID = ""
            + "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
            + "<paths xmlns:android=\"http://schemas.android.com/apk/res/android\">\n"
            + "    <external-path name=\"cm_files\" path=\"Android/data/" + BUNDLEID_ANCHOR + "\" />\n"
            + "    <external-path name=\"dl_files\" path=\"Download\"/>\n"
            + "</paths>";

    public static final String CROSSMOBILE_GRADLE = ""
            + "\n"
            + "ext.appId = \"" + APPLICATION_ID + "\"\n"
            + "\n"
            + "dependencies {\n"
            + DEPENDENCIES
            + "}";
}
