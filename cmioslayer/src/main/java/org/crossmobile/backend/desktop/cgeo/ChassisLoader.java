/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

import crossmobile.ios.uikit.UIUserInterfaceIdiom;
import org.crossmobile.backend.desktop.DesktopImageLocations;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.Native;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static crossmobile.ios.uikit.UIInterfaceOrientationMask.*;
import static crossmobile.ios.uikit.UIInterfaceOrientationMask.All;
import static org.crossmobile.bind.system.SystemUtilities.stringToBoolean;
import static org.crossmobile.bridge.system.BaseUtils.throwExceptionAndReturn;

public class ChassisLoader extends DefaultHandler {

    final String fileName;
    private Chassis ch;
    String chassisInfo = "";
    String attrName;

    @SuppressWarnings("UseSpecificCatch")
    public static Chassis getChassis(String name) {
        if (name == null || name.trim().isEmpty())
            name = "system";
        try {
            ChassisLoader handler = new ChassisLoader(name);
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(new InputSource(Chassis.class.getResourceAsStream(DesktopImageLocations.SKINS + name + ".xml")), handler);
            return handler.ch;
        } catch (Exception ex) {
            return throwExceptionAndReturn(ex);
        }
    }

    private ChassisLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        attrName = qName;
        switch (qName) {
            case "chassis":
                ch = new Chassis(fileName,
                        toIdiom(attributes, "idiom"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        attributes.getValue("device")
                );
                break;
            case "meta":
                ch.setMeta(chassisInfo = attributes.getValue("info"),
                        attributes.getValue("descr"), toInt(attributes, "priority", 50));
                break;
            case "screen":
                ch.setScreen(new CScreen(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        stringToBoolean(attributes.getValue("stretch"), false),
                        stringToBoolean(attributes.getValue("statusbar"), true)));
                break;
            case "led":
                ch.setLed(new CDrawable(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes, "orientation"),
                        getImage(attributes, "imageon"),
                        getImage(attributes, "imageoff"),
                        stringToBoolean(attributes.getValue("autorotate"), false)));
                break;
            case "power":
                ch.addArea(new CButton(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes, "orientation"),
                        CEvent.power(),
                        getImage(attributes, "imagedown"),
                        getImage(attributes, "imageup"),
                        stringToBoolean(attributes.getValue("autorotate"), false)));
                break;
            case "back":
                ch.addArea(new CButton(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes, "orientation"),
                        CEvent.back(),
                        getImage(attributes, "imagedown"),
                        getImage(attributes, "imageup"),
                        stringToBoolean(attributes.getValue("autorotate"), false)));
                break;
            case "home":
                ch.addArea(new CButton(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes, "orientation"),
                        CEvent.home(),
                        getImage(attributes, "imagedown"),
                        getImage(attributes, "imageup"),
                        stringToBoolean(attributes.getValue("autorotate"), false)));
                break;
            case "action":
                ch.addArea(new CButton(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes, "orientation"),
                        CEvent.action(),
                        getImage(attributes, "imagedown"),
                        getImage(attributes, "imageup"),
                        stringToBoolean(attributes.getValue("autorotate"), false)));
                break;
            case "image":
                ch.addArea(new CDrawable(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes, "orientation"),
                        getImage(attributes, "file"),
                        null,
                        stringToBoolean(attributes.getValue("autorotate"), false)));
                break;
            case "insets":
                ch.setInset(toOrientation(attributes, "orientation"),
                        toInt(attributes, "top"),
                        toInt(attributes, "left"),
                        toInt(attributes, "bottom"),
                        toInt(attributes, "right"));
                break;
            default:
                throw new RuntimeException("Unknown entry '" + qName + ";");
        }
    }

    private String error(String tag, String reason) {
        return chassisInfo + "->" + attrName + "->" + tag + " : " + reason;
    }

    private int toInt(Attributes attributes, String tag, int deflt) {
        try {
            return toInt(attributes, tag);
        } catch (Exception ex) {
            return deflt;
        }
    }

    private int toInt(Attributes attributes, String tag) {
        String value = attributes.getValue(tag);
        if (value == null)
            throw new NullPointerException(error(tag, "Unable to find attribute"));
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(error(tag, "Value '" + value + "' is not a number"));
        }
    }

    private int toOrientation(Attributes attributes, String tag) {
        String orientation = attributes.getValue(tag);
        orientation = orientation == null ? "" : orientation.trim().toLowerCase();
        int result = 0;
        for (String part : orientation.split(":"))
            switch (part) {
                case "portrait":
                    result |= Portrait;
                    break;
                case "landscapeleft":
                    result |= LandscapeLeft;
                    break;
                case "landscaperight":
                    result |= LandscapeRight;
                    break;
                case "portraitupsidedown":
                    result |= PortraitUpsideDown;
                    break;
                case "all":
                    result |= All;
                    break;
                case "landscape":
                    result |= Landscape;
                    break;
                case "allbutupsidedown":
                    result |= AllButUpsideDown;
                    break;
                case "":
                    break;
                default:
                    throw new RuntimeException(error(tag, "Unknown orientation: " + part));
            }
        if (result == 0)
            result = All;
        return result;
    }

    private NativeBitmap getImage(Attributes attributes, String tag) {
        String imagename = attributes.getValue(tag);
        if (imagename == null)
            return null;
        try {
            return Native.image().retrieve(getClass().getResource(DesktopImageLocations.SKINS + imagename).toURI().toString());
        } catch (Exception ex) {
            System.err.println(error(tag, "No Image found under '" + imagename + "'"));
        }
        return null;
    }

    private int toIdiom(Attributes attributes, String tag) {
        String idiom = attributes.getValue(tag);
        idiom = idiom == null ? null : idiom.trim().toLowerCase();
        if (idiom == null || idiom.isEmpty())
            throw new NullPointerException(error(tag, "Missing device information"));
        idiom = idiom.trim().toLowerCase();
        if (idiom.equals("phone"))
            return UIUserInterfaceIdiom.Phone;
        if (idiom.equals("pad"))
            return UIUserInterfaceIdiom.Pad;
        throw new IllegalArgumentException(error(tag, "Unknown device information '" + idiom + "'"));
    }
}