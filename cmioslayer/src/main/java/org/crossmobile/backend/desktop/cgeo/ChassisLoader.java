/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

import crossmobile.ios.uikit.UIUserInterfaceIdiom;
import net.n3.nanoxml.IXMLElement;
import net.n3.nanoxml.IXMLParser;
import net.n3.nanoxml.StdXMLReader;
import net.n3.nanoxml.XMLParserFactory;
import org.crossmobile.backend.desktop.DesktopLocations;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.system.LazyProperty;
import org.robovm.objc.block.Block0;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Enumeration;

import static crossmobile.ios.uikit.UIInterfaceOrientationMask.*;
import static org.crossmobile.bridge.system.BaseUtils.objectToBoolean;
import static org.crossmobile.bridge.system.BaseUtils.throwException;

@SuppressWarnings("unchecked")
public class ChassisLoader {

    @SuppressWarnings({"UseSpecificCatch", "CharsetObjectCanBeUsed"})
    static void loadSkins(InputStream io, Collection<Chassis> skins) {
        IXMLElement xml;
        try {
            IXMLParser parser = XMLParserFactory.createDefaultXMLParser();
            parser.setReader(new StdXMLReader(new InputStreamReader(io, "UTF-8")));
            xml = (IXMLElement) parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
            throwException(e);
            return;
        }

        if (!xml.getName().equals("skins"))
            throw new IllegalArgumentException("Not a valid skin file");

        Enumeration<IXMLElement> skinEnum = xml.enumerateChildren();
        while (skinEnum.hasMoreElements())
            addSkins(skins, skinEnum.nextElement());

    }

    private static void addSkins(Collection<Chassis> skins, IXMLElement skin) {
        if (!skin.getName().equals("skin"))
            throw new IllegalArgumentException("Not a valid skin: " + skin.getName());
        Chassis chassis = new Chassis(toString(skin, "name"),
                toIdiom(skin),
                toInt(skin, "width"),
                toInt(skin, "height"),
                toString(skin, "device"));
        skins.add(chassis);

        Enumeration<IXMLElement> skinEnum = skin.enumerateChildren();
        while (skinEnum.hasMoreElements()) {
            IXMLElement elm = skinEnum.nextElement();
            switch (elm.getName()) {
                case "meta":
                    chassis.setMeta(toString(elm, "info"),
                            toString(elm, "descr"),
                            toInt(elm, "priority", 50));
                    break;
                case "screen":
                    String statusBarValue = toString(elm, "statusbar");
                    chassis.setScreen(new CScreen(toInt(elm, "x"),
                            toInt(elm, "y"),
                            toInt(elm, "width"),
                            toInt(elm, "height"),
                            toBoolean(elm, "stretch"),
                            objectToBoolean(statusBarValue == null ? "true" : statusBarValue)));
                    break;
                case "led":
                    chassis.setLed(new CDrawable(toInt(elm, "x"),
                            toInt(elm, "y"),
                            toInt(elm, "width"),
                            toInt(elm, "height"),
                            toOrientation(elm),
                            getImage(elm, "imageon"),
                            getImage(elm, "imageoff"),
                            toBoolean(elm, "autorotate")));
                    break;
                case "power":
                    chassis.addArea(new CButton(toInt(elm, "x"),
                            toInt(elm, "y"),
                            toInt(elm, "width"),
                            toInt(elm, "height"),
                            toOrientation(elm),
                            CEvent.power(),
                            getImage(elm, "imagedown"),
                            getImage(elm, "imageup"),
                            toBoolean(elm, "autorotate")));
                    break;
                case "back":
                    chassis.addArea(new CButton(toInt(elm, "x"),
                            toInt(elm, "y"),
                            toInt(elm, "width"),
                            toInt(elm, "height"),
                            toOrientation(elm),
                            CEvent.back(),
                            getImage(elm, "imagedown"),
                            getImage(elm, "imageup"),
                            toBoolean(elm, "autorotate")));
                    break;
                case "home":
                    chassis.addArea(new CButton(toInt(elm, "x"),
                            toInt(elm, "y"),
                            toInt(elm, "width"),
                            toInt(elm, "height"),
                            toOrientation(elm),
                            CEvent.home(),
                            getImage(elm, "imagedown"),
                            getImage(elm, "imageup"),
                            toBoolean(elm, "autorotate")));
                    break;
                case "action":
                    chassis.addArea(new CButton(toInt(elm, "x"),
                            toInt(elm, "y"),
                            toInt(elm, "width"),
                            toInt(elm, "height"),
                            toOrientation(elm),
                            CEvent.action(),
                            getImage(elm, "imagedown"),
                            getImage(elm, "imageup"),
                            toBoolean(elm, "autorotate")));
                    break;
                case "image":
                    chassis.addArea(new CDrawable(toInt(elm, "x"),
                            toInt(elm, "y"),
                            toInt(elm, "width"),
                            toInt(elm, "height"),
                            toOrientation(elm),
                            getImage(elm, "file"),
                            null,
                            toBoolean(elm, "autorotate")));
                    break;
                case "insets":
                    chassis.setInset(toOrientation(elm),
                            toInt(elm, "top"),
                            toInt(elm, "left"),
                            toInt(elm, "bottom"),
                            toInt(elm, "right"));
                    break;
                default:
                    throw new RuntimeException("Unknown entry '" + elm.getName() + "'");
            }
        }
    }

    private static boolean toBoolean(IXMLElement element, String attribute) {
        return objectToBoolean(toString(element, attribute));
    }

    @SuppressWarnings("SameParameterValue")
    private static int toInt(IXMLElement element, String attribute, int deflt) {
        try {
            return toInt(element, attribute);
        } catch (Exception ex) {
            return deflt;
        }
    }

    private static int toInt(IXMLElement element, String attribute) {
        Object value = element.getAttribute(attribute, null);
        if (value == null)
            throw new NullPointerException(error(attribute, "Unable to find attribute"));
        try {
            return Integer.parseInt(value.toString());
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(error(attribute, "Value '" + value + "' is not a number"));
        }
    }

    private static String toString(IXMLElement element, String attribute) {
        Object value = element.getAttribute(attribute, null);
        return value == null ? null : value.toString();
    }

    private static int toOrientation(IXMLElement element) {
        Object orientationO = element.getAttribute("orientation", null);
        String orientation = orientationO == null ? "" : orientationO.toString().trim().toLowerCase();
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

    private static LazyProperty<NativeBitmap> getImage(IXMLElement element, String attribute) {
        Object imageName = element.getAttribute(attribute, null);
        if (imageName == null)
            throw new NullPointerException("Unable to retrieve image name");
        return new LazyProperty<>(new Block0<NativeBitmap>() {
            @Override
            public NativeBitmap invoke() {
                return Native.image().retrieve(Native.image().getClass().getResource(DesktopLocations.SKINS + imageName.toString()).toString());
            }
        });
    }

    private static int toIdiom(IXMLElement element) {
        Object idiomO = element.getAttribute("idiom", null);
        String idiom = idiomO == null ? null : idiomO.toString().trim().toLowerCase();
        if (idiom == null || idiom.isEmpty())
            throw new NullPointerException(error("idiom", "Missing device information"));
        idiom = idiom.trim().toLowerCase();
        if (idiom.equals("phone"))
            return UIUserInterfaceIdiom.Phone;
        if (idiom.equals("pad"))
            return UIUserInterfaceIdiom.Pad;
        throw new IllegalArgumentException(error("idiom", "Unknown device information '" + idiom + "'"));
    }

    private static String error(String attributeName, String reason) {
        return "Wrong attribute " + attributeName + ": " + reason;
    }}