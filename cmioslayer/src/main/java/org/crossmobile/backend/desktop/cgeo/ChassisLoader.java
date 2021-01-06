/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

import crossmobile.ios.uikit.UIUserInterfaceIdiom;
import org.crossmobile.backend.desktop.DesktopLocations;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.system.LazyProperty;
import org.crossmobile.bridge.Native;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Collection;

import static crossmobile.ios.uikit.UIInterfaceOrientationMask.*;
import static org.crossmobile.bridge.system.BaseUtils.objectToBoolean;
import static org.crossmobile.bridge.system.BaseUtils.throwException;

public class ChassisLoader extends DefaultHandler {

    private final Collection<Chassis> skins;
    private Chassis current;
    private String chassisInfo = "";
    private String attrName;

    @SuppressWarnings("UseSpecificCatch")
    static void loadSkins(InputStream io, Collection<Chassis> skins) {
        try {
            ChassisLoader handler = new ChassisLoader(skins);
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(io, handler);
        } catch (Exception ex) {
            throwException(ex);
        }
    }

    private ChassisLoader(Collection<Chassis> skins) {
        this.skins = skins;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        attrName = qName;
        switch (qName) {
            case "skin":
                skins.add(current = new Chassis(attributes.getValue("name"),
                        toIdiom(attributes),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        attributes.getValue("device")
                ));
                break;
            case "meta":
                current.setMeta(chassisInfo = attributes.getValue("info"),
                        attributes.getValue("descr"), toInt(attributes, "priority", 50));
                break;
            case "screen":
                String statusBarValue = attributes.getValue("statusbar");
                current.setScreen(new CScreen(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        objectToBoolean(attributes.getValue("stretch")),
                        objectToBoolean(statusBarValue == null ? "true" : statusBarValue)));
                break;
            case "led":
                current.setLed(new CDrawable(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes),
                        getImage(attributes, "imageon"),
                        getImage(attributes, "imageoff"),
                        objectToBoolean(attributes.getValue("autorotate"))));
                break;
            case "power":
                current.addArea(new CButton(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes),
                        CEvent.power(),
                        getImage(attributes, "imagedown"),
                        getImage(attributes, "imageup"),
                        objectToBoolean(attributes.getValue("autorotate"))));
                break;
            case "back":
                current.addArea(new CButton(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes),
                        CEvent.back(),
                        getImage(attributes, "imagedown"),
                        getImage(attributes, "imageup"),
                        objectToBoolean(attributes.getValue("autorotate"))));
                break;
            case "home":
                current.addArea(new CButton(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes),
                        CEvent.home(),
                        getImage(attributes, "imagedown"),
                        getImage(attributes, "imageup"),
                        objectToBoolean(attributes.getValue("autorotate"))));
                break;
            case "action":
                current.addArea(new CButton(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes),
                        CEvent.action(),
                        getImage(attributes, "imagedown"),
                        getImage(attributes, "imageup"),
                        objectToBoolean(attributes.getValue("autorotate"))));
                break;
            case "image":
                current.addArea(new CDrawable(toInt(attributes, "x"),
                        toInt(attributes, "y"),
                        toInt(attributes, "width"),
                        toInt(attributes, "height"),
                        toOrientation(attributes),
                        getImage(attributes, "file"),
                        null,
                        objectToBoolean(attributes.getValue("autorotate"))));
                break;
            case "insets":
                current.setInset(toOrientation(attributes),
                        toInt(attributes, "top"),
                        toInt(attributes, "left"),
                        toInt(attributes, "bottom"),
                        toInt(attributes, "right"));
                break;
            case "skins":
                break;
            default:
                throw new RuntimeException("Unknown entry '" + qName + "'");
        }
    }

    private String error(String tag, String reason) {
        return chassisInfo + "->" + attrName + "->" + tag + " : " + reason;
    }

    @SuppressWarnings("SameParameterValue")
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

    private int toOrientation(Attributes attributes) {
        String orientation = attributes.getValue("orientation");
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
                    throw new RuntimeException(error("orientation", "Unknown orientation: " + part));
            }
        if (result == 0)
            result = All;
        return result;
    }

    private LazyProperty<NativeBitmap> getImage(Attributes attributes, String tag) {
        String imageName = attributes.getValue(tag);
        if (imageName == null)
            throw new NullPointerException("Unable to retrieve image name");
        return new LazyProperty<>(() -> {
            try {
                return Native.image().retrieve(getClass().getResource(DesktopLocations.SKINS + imageName).toURI().toString());
            } catch (URISyntaxException e) {
                System.err.println(error(tag, "No Image found under '" + imageName + "'"));
                return null;
            }
        });
    }

    private int toIdiom(Attributes attributes) {
        String idiom = attributes.getValue("idiom");
        idiom = idiom == null ? null : idiom.trim().toLowerCase();
        if (idiom == null || idiom.isEmpty())
            throw new NullPointerException(error("idiom", "Missing device information"));
        idiom = idiom.trim().toLowerCase();
        if (idiom.equals("phone"))
            return UIUserInterfaceIdiom.Phone;
        if (idiom.equals("pad"))
            return UIUserInterfaceIdiom.Pad;
        throw new IllegalArgumentException(error("idiom", "Unknown device information '" + idiom + "'"));
    }
}