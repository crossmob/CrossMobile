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
package org.crossmobile.gui.project;

import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.ProjectException;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public class OldSourceParser {

    private final static Map<String, String> MAP = new LinkedHashMap<>();

    private final static String[] PROPERTIES = {
            "accessoryType", "accessoryView", "actions", "activityIndicatorViewStyle", "addressDictionary", "addresses", "administrativeArea", "advertisingSection", "alertAction", "alertBody", "alertLaunchImage", "alpha", "altitude", "anchorPoint", "anchorPointZ", "annotation", "annotationVisibleRect", "annotations", "applicationFrame", "applicationIconBadgeNumber", "ascent", "autocapitalizationType", "autocorrectionType", "autoresizingMask", "backBarButtonItem", "backgroundColor", "backgroundFilters", "backgroundView", "backitem", "badgeValue", "barStyle", "barTintColor", "batteryLevel", "batteryState", "beginTime", "body", "borderStyle", "borderWidth", "boundingMapRect", "bounds", "buttonType", "byValue", "bytes", "cGColor", "cGImage", "calendar", "calloutOffset", "cameraCaptureMode", "cameraDevice", "cameraFlashMode", "cameraOverlayView", "cameraViewTransform", "center", "centerCoordinate", "centerOffset", "clip", "compositingFilter", "connectionTypesMask", "contentHorizontalAlignment", "contentMode", "contentOffset", "contentSize", "contentSizeForViewInPopover", "contentURL", "contentVerticalAlignment", "contentView", "contentViewController", "contents", "contentsCenter", "contentsGravity", "contentsRect", "contentsScale", "context", "coordinate", "cornerRadius", "countDownDuration", "country", "countryCode", "course", "current", "currentBackgroundImage", "currentContentSizeIdentifier", "currentContext", "currentImage", "currentMaximumTrackImage", "currentMinimumTrackImage", "currentPage", "currentPreviewItem", "currentPreviewItemIndex", "currentQueue", "currentThumbImage", "currentTime", "currentTitle", "currentTitleColor", "currentTitleShadowColor", "customView", "customizableViewControllers", "data", "dataDetectorTypes", "dataSource", "date", "datePickerMode", "delegate", "dependencies", "descent", "desiredAccuracy", "detailTextLabel", "disconnectTimeout", "displayName", "distanceFilter", "document", "domain", "dragState", "duration", "eAGLLayer", "edgeAntialiasingMask", "editingStyle", "endProgress", "error", "fillMode", "filters", "fireDate", "font", "frame", "fromValue", "gestureRecognizers", "heading", "headingAccuracy", "headingFilter", "headingOrientation", "height", "hidesWhenStopped", "horizontalAccuracy", "hostName", "identifier", "image", "imageFromCurrentImageContext", "imageInsets", "imageView", "initialPlaybackTime", "interfaceOrientation", "invalidProductIdentifiers", "items", "keyPath", "keyWindow", "keyboardAppearance", "keyboardType", "layer", "leftBarButtonItem", "leftCalloutAccessoryView", "lineBreakMode", "locale", "locality", "localizedDescription", "localizedModel", "localizedTitle", "location", "magneticHeading", "magnificationFilter", "mailComposeDelegate", "main", "mainQueue", "mapType", "mask", "masksToBounds", "maximumDate", "maximumRegionMonitoringDistance", "maximumValue", "maximumValueImage", "mediaTypes", "messageComposeDelegate", "messsage", "minificationFilter", "minificationFilterBias", "minimumDate", "minimumValue", "minimumValueImage", "minuteInterval", "modalPresentationStyle", "modalTransitionStyle", "modalViewController", "model", "monitoredRegions", "moreNavigationController", "movieControlMode", "moviePlayer", "multitaskingSupported", "name", "navigationBar", "navigationController", "navigationItem", "needsDisplayOnBoundsChange", "nextResponder", "numberOfChannels", "numberOfComponents", "numberOfLines", "numberOfLoops", "numberOfPages", "opacity", "orientation", "originalTransaction", "overlay", "overlays", "pageNumber", "parentViewController", "passthroughViews", "payment", "peerID", "phase", "pinColor", "placeholder", "placemark", "popoverArrowDirection", "popoverContentSize", "port", "position", "possibleTitles", "postalCode", "previewItemTitle", "previewItemURL", "price", "priceLocale", "printingItem", "printingItems", "productIdentifier", "products", "productsDelegate", "progress", "progressViewStyle", "prompt", "proximityState", "purpose", "quantity", "queuePriority", "radius", "rasterizationScale", "recipients", "region", "repeatCalendar", "repeatCount", "repeatDuration", "repeatInterval", "requestData", "requiredContentSizeIdentifiers", "returnKeyType", "reuseIdentifier", "rightBarButtonItem", "rightCalloutAccessoryView", "rootViewController", "rotationAngle", "row", "rowHeight", "scale", "scalingMode", "scopeButtonTitles", "screen", "scrollView", "section", "segmentedControlStyle", "selectedAnnotations", "selectedBackgroundView", "selectedIndex", "selectedItem", "selectedScopeButtonIndex", "selectedSegmentIndex", "selectedViewController", "selectionStyle", "separatorColor", "separatorStyle", "sessionID", "sessionMode", "shadowColor", "shadowOffset", "shadowOpacity", "shadowRadius", "shouldRasterize", "size", "soundName", "sourceType", "speed", "startProgress", "state", "statusBarStyle", "style", "subAdministrativeArea", "subLocality", "subThoroughfare", "sublayers", "subtitle", "subtype", "subviews", "superlayer", "superview", "systemName", "systemVersion", "tabBar", "tabBarController", "tabBarItem", "tableView", "tableViewDelegate", "tag", "tapCount", "text", "textAlignment", "textColor", "textLabel", "textPosition", "thoroughfare", "threadPriority", "timeOffset", "timeZone", "timestamp", "tintAdjustmentMode", "tintColor", "title", "titleLabel", "titleShadowOffset", "titleView", "toValue", "toolbar", "toolbarItems", "topItem", "topViewController", "transactionDate", "transactionIdentifier", "transactionReceipt", "transactionState", "transactions", "transform", "trueHeading", "type", "typeID", "uRL", "unitsPerEm", "userInfo", "userInterfaceIdiom", "userLocation", "value", "verticalAccuracy", "videoMaximumDuration", "videoQuality", "view", "viewControllers", "visibleMapRect", "visibleRect", "visibleViewController", "volume", "width", "window", "windows", "zPosition"
    };

    static {
        MAP.put("blackColor", "blackColor()");
        MAP.put("darkGrayColor", "darkGrayColor()");
        MAP.put("lightGrayColor", "lightGrayColor()");
        MAP.put("whiteColor", "whiteColor()");
        MAP.put("grayColor", "grayColor()");
        MAP.put("redColor", "redColor()");
        MAP.put("greenColor", "greenColor()");
        MAP.put("blueColor", "blueColor()");
        MAP.put("cyanColor", "cyanColor()");
        MAP.put("yellowColor", "yellowColor()");
        MAP.put("magentaColor", "magentaColor()");
        MAP.put("orangeColor", "orangeColor()");
        MAP.put("purpleColor", "purpleColor()");
        MAP.put("brownColor", "brownColor()");
        MAP.put("clearColor", "clearColor()");
        MAP.put("lightTextColor", "lightTextColor()");
        MAP.put("darkTextColor", "darkTextColor()");
        MAP.put("colorWithRGBA", "colorWithRedGreenBlueAlpha");
        MAP.put("colorWithHSBA", "colorWithHueSaturationBrightnessAlpha");

        MAP.put("raiseEvent", "exec");
        MAP.put("invokeWithArgument", "exec");
        MAP.put("timerEvent", "fireMethod");

        MAP.put("webViewDidFinishLoad", "didFinishLoad");
        MAP.put("textFieldShouldReturn", "shouldReturn");
        MAP.put("addValueForHTTPHeaderField", "addValue");
        MAP.put("textFieldDidBeginEditing", "didBeginEditing");
        MAP.put("textFieldDidEndEditing", "didEndEditing");
        MAP.put("textFieldShouldChangeCharactersInRange", "shouldChangeCharactersInRange");

        MAP.put("org\\.xmlvm\\.iphone", "crossmobile.ios");

        MAP.put("crossmobile\\.ios\\.UI", "crossmobile.ios.uikit.UI");
        MAP.put("crossmobile\\.ios\\.MK", "crossmobile.ios.mapkit.MK");
        MAP.put("crossmobile\\.ios\\.SL", "crossmobile.ios.social.SL");
        MAP.put("crossmobile\\.ios\\.CL", "crossmobile.ios.corelocation.CL");
        MAP.put("crossmobile\\.ios\\.CG", "crossmobile.ios.coregraphics.CG");
        MAP.put("crossmobile\\.ios\\.NSLayout", "crossmobile.ios.uikit.NSLayout");
        MAP.put("crossmobile\\.ios\\.NS", "crossmobile.ios.foundation.NS");
        MAP.put("crossmobile\\.ios\\.CF", "crossmobile.ios.foundation.CF");
        MAP.put("crossmobile\\.ios\\.Foundation", "crossmobile.ios.foundation.Foundation");
        MAP.put("crossmobile\\.ios\\.SK", "crossmobile.ios.storekit.SK");
        MAP.put("crossmobile\\.ios\\.AB", "crossmobile.ios.addressbook.AB");
        MAP.put("crossmobile\\.ios\\.AudioServices", "crossmobile.ios.audiotoolbox.AudioServices");
        MAP.put("crossmobile\\.ios\\.SystemSoundID", "crossmobile.ios.audiotoolbox.SystemSoundID");
        MAP.put("crossmobile\\.ios\\.AV", "crossmobile.ios.avfoundation.AV");
        MAP.put("crossmobile\\.ios\\.CI", "crossmobile.ios.coreimage.CI");
        MAP.put("crossmobile\\.ios\\.AC", "crossmobile.ios.acounts.AC");
        MAP.put("crossmobile\\.ios\\.GK", "crossmobile.ios.gamekit.GK");
        MAP.put("crossmobile\\.ios\\.MP", "crossmobile.ios.mediaplayer.MP");
        MAP.put("crossmobile\\.ios\\.MF", "crossmobile.ios.messageui.MF");
        MAP.put("crossmobile\\.ios\\.MessageComposeResult", "crossmobile.ios.messagegui.MessageComposeResult");
        MAP.put("crossmobile\\.ios\\.UT", "crossmobile.ios.mobilecoreservices.UT");
        MAP.put("crossmobile\\.ios\\.CA", "crossmobile.ios.quartzcore.CA");
        MAP.put("crossmobile\\.ios\\.QL", "crossmobile.ios.quicklook.QL");
        MAP.put("crossmobile\\.ios\\.Block", "crossmobile.rt.Block");
        MAP.put("crossmobile\\.ios\\.StrongReference", "crossmobile.rt.StrongReference");
        MAP.put("org\\.crossmobile\\.bridge\\.ann", "org.robovm.objc.annotation");

        MAP.put("(?<![?])\\sextends\\s+UIApplicationDelegate", " implements UIApplicationDelegate");
        MAP.put("extends\\s+UISplitViewControllerDelegate", "implements UISplitViewControllerDelegate");
        MAP.put("extends\\s+NSXMLParserDelegate", "implements NSXMLParserDelegate");
        MAP.put("UIControlEvent(?![s])", "UIControlEvents");

        MAP.put("NSObject\\.performSelector", "new NSObject().performSelector");
        MAP.put("UIActionSheet\\.init", "new UIActionSheet");

        MAP.put("\\(\\)\\(\\)", "()");
//        
        MAP.put("RoundedRect", "System");
        for (String item : PROPERTIES) {
            String getter = "get" + item.substring(0, 1).toUpperCase() + item.substring(1);
            MAP.put(getter, item);
        }
    }

    public static void updateSources(File basedir, File sourcedir, String projecttype) throws ProjectException {
        if (!sourcedir.exists())
            return;
        if (JOptionPane.showConfirmDialog(null, "The project under\n'" + basedir.getAbsolutePath() + "'\nwas recognized as an old " + projecttype + " project.\n\nIt will be required to update the source files along with the project files.\nNote that this is a one-time update and might break current code.\nMake sure you have a backup of the original source code before proceeding.\n\nDO NOT PROCEED IF YOU DO NOT HAVE A BACKUP OF THIS PROJECT!") == JOptionPane.OK_OPTION)
            updateSourceRecursively(sourcedir);
        else
            throw new ProjectException("Unable to update sources");
    }

    private static void updateSourceRecursively(File sourcedir) throws ProjectException {
        if (sourcedir.isFile())
            updateSourceFile(sourcedir);
        else if (sourcedir.isDirectory())
            for (File sub : sourcedir.listFiles())
                updateSourceRecursively(sub);
    }

    private static void updateSourceFile(File source) throws ProjectException {
        if (!source.getName().toLowerCase().endsWith(".java"))
            return;
        try {
            String result = FileUtils.readSafe(new FileInputStream(source), source.getAbsolutePath());
            if (result == null)
                throw new ProjectException("Unable to load file " + source);
            for (String key : MAP.keySet())
                result = result.replaceAll(key, MAP.get(key));
            FileUtils.write(source, result);
        } catch (FileNotFoundException ex) {
            throw new ProjectException("Unable to parse file " + source.getAbsolutePath(), ex);
        }
    }
}
