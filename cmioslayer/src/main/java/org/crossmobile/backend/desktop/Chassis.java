/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import crossmobile.ios.uikit.UIDeviceOrientation;
import crossmobile.ios.uikit.UIUserInterfaceIdiom;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.Insets;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.system.ClassWalker;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.*;

import static crossmobile.ios.uikit.UIInterfaceOrientationMask.*;
import static org.crossmobile.bind.system.SystemUtilities.stringToBoolean;
import static org.crossmobile.bridge.system.BaseUtils.throwExceptionAndReturn;

public class Chassis implements Comparable<Chassis> {

    private static class DefaultChassis extends Chassis {

        @SuppressWarnings("OverridableMethodCallInConstructor")
        private DefaultChassis() {
            super("default", 0, 0, 0, null);
            setMeta("Default skin", "Skin based on project type", 1000);
        }
    }

    public static final Chassis Default = new DefaultChassis();

    private final int idiom;
    private final int width;
    private final int height;
    private final boolean fullscreen;
    private final boolean simulator;
    private final List<CArea> areas = new ArrayList<>();
    private final String name;
    private String info;
    private String descr;
    private float priority;
    //
    private CDrawable led;
    private CScreen screen;
    //
    private Insets[] insets;

    public static List<String>[] getSkinInfo(String classpath) {
        List<String>[] skinlist = new ArrayList[3];
        skinlist[0] = new ArrayList<>();
        skinlist[1] = new ArrayList<>();
        skinlist[2] = new ArrayList<>();
        skinlist[0].add(Default.name);
        skinlist[1].add(Default.info);
        skinlist[2].add(Default.descr);
        for (String name : getSkinNames(classpath))
            try {
                name = name.replace(':', '-');
                ChassisInfoHandler handler = new ChassisInfoHandler();
                SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
                parser.parse(new InputSource(Chassis.class.getResourceAsStream(DesktopImageLocations.SKINS + name + ".xml")), handler);
                skinlist[0].add(name);
                skinlist[1].add(handler.info);
                skinlist[2].add(handler.descr);
            } catch (Exception ex) {
                return throwExceptionAndReturn(ex);
            }
        return skinlist;
    }

    static Collection<Chassis> getSkins(String classpath) {
        Collection<Chassis> result = new TreeSet<>();
        result.add(Default);
        for (String name : getSkinNames(classpath))
            result.add(getChassis(name));
        return result;
    }

    private static Collection<String> getSkinNames(String classpath) {
        String testPackage = DesktopImageLocations.SKINS.substring(1).replace('/', '.');
        Collection<String> names = new ArrayList<>();
        Collection<String> classes = new ArrayList<>();
        ClassWalker.getClasspathEntries(classpath, item -> {
            if (item.startsWith(testPackage))
                classes.add(item);
        }, "xml");
        for (String matchedName : classes)
            names.add(matchedName.substring(testPackage.length()));
        return names;
    }

    @SuppressWarnings("UseSpecificCatch")
    static Chassis getChassis(String chassisName) {
        try {
            chassisName = chassisName.replace(':', '-');
            ChassisHandler handler = new ChassisHandler(chassisName);
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(new InputSource(Chassis.class.getResourceAsStream(DesktopImageLocations.SKINS + chassisName + ".xml")), handler);
            return handler.ch;
        } catch (Exception ex) {
            return throwExceptionAndReturn(ex);
        }
    }

    private Chassis(String fileName, int idiom, int width, int height, String device) {
        this.name = fileName.replace('-', ':');
        this.idiom = idiom;
        this.width = width;
        this.height = height;
        this.fullscreen = "fullscreen".equals(device);
        this.simulator = "simulator".equals(device);
        this.info = info == null ? "" : info;
        this.descr = descr == null ? "" : descr;
    }

    private void setInset(int orientation, int top, int left, int bottom, int right) {
        if (orientation != 0)
            insets = new Insets[4];
        if ((orientation & Portrait) != 0)
            insets[UIDeviceOrientation.Portrait - 1] = new Insets(top, left, bottom, right);
        if ((orientation & LandscapeLeft) != 0)
            insets[UIDeviceOrientation.LandscapeLeft - 1] = new Insets(top, left, bottom, right);
        if ((orientation & LandscapeRight) != 0)
            insets[UIDeviceOrientation.LandscapeRight - 1] = new Insets(top, left, bottom, right);
        if ((orientation & PortraitUpsideDown) != 0)
            insets[UIDeviceOrientation.PortraitUpsideDown - 1] = new Insets(top, left, bottom, right);
    }

    Insets getInset(int deviceOrientation) {
        return insets == null || deviceOrientation < UIDeviceOrientation.Portrait || deviceOrientation > UIDeviceOrientation.LandscapeRight || insets[deviceOrientation - 1] == null
                ? Insets.zero
                : insets[deviceOrientation - 1];
    }

    void setMeta(String info, String descr, float priority) {
        this.info = info;
        this.descr = descr;
        this.priority = priority;
    }

    private void addArea(CArea area) {
        areas.add(area);
    }

    private void setLed(CDrawable led) {
        this.led = led;
        addArea(led);
    }

    private void setScreen(CScreen screen) {
        this.screen = screen;
        addArea(screen);
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getDescr() {
        return descr;
    }

    public int getIdiom() {
        return idiom;
    }

    public CEvent findArea(int x, int y, int orientation) {
        for (CArea item : CClickable.Reverse.reversed(areas))
            if (item instanceof CClickable && item.contains(x, y, orientation))
                return ((CClickable) item).getEvent();
        return CEvent.window();
    }

    int width() {
        return width;
    }

    int height() {
        return height;
    }

    CScreen screen() {
        return screen;
    }

    boolean isFullscreen() {
        return fullscreen;
    }

    boolean isSimulator() {
        return simulator;
    }

    void updateMetrics(int frameWidth, int frameHeight, int hardwareWidth, int hardwareHeight) {
        for (CArea area : areas)
            area.updateWidth(frameWidth, frameHeight, hardwareWidth, hardwareHeight);
    }

    public void draw(GraphicsContext context, boolean above, int orientation) {
        boolean canDraw = !above;
        for (CArea area : areas) {
            if (area == screen)
                if (above)
                    canDraw = true;
                else
                    break;
            if (canDraw && area instanceof CDrawable)
                ((DesktopGraphicsBridge) Native.graphics()).draw((CDrawable) area, context, orientation);
        }
    }

    void setActive(boolean status) {
        if (led != null)
            led.setActive(status);
    }

    boolean isActive() {
        return led != null && led.isActive();
    }

    @Override
    public int compareTo(Chassis o) {
        if (priority != o.priority)
            return priority > o.priority ? -1 : 1;
        return info.compareTo(o.info);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Chassis other = (Chassis) obj;
        return Objects.equals(this.name, other.name);
    }

    private static class ChassisInfoHandler extends DefaultHandler {

        String info = "";
        String descr = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("meta")) {
                info = attributes.getValue("info");
                descr = attributes.getValue("descr");
            }
        }
    }

    private static class ChassisHandler extends DefaultHandler {

        final String fileName;
        private Chassis ch;
        String chassisInfo = "";
        String attrName;

        public ChassisHandler(String fileName) {
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
                    ch.setScreen(new CScreen(toPoint(attributes),
                            toInt(attributes, "width"),
                            toInt(attributes, "height"),
                            stringToBoolean(attributes.getValue("stretch"), false),
                            stringToBoolean(attributes.getValue("statusbar"), true)));
                    break;
                case "led":
                    ch.setLed(new CDrawable(toPoint(attributes),
                            toInt(attributes, "width"),
                            toInt(attributes, "height"),
                            toOrientation(attributes, "orientation"),
                            getImage(attributes, "imageon"),
                            getImage(attributes, "imageoff"),
                            stringToBoolean(attributes.getValue("autorotate"), false)));
                    break;
                case "power":
                    ch.addArea(new CButton(toPoint(attributes),
                            toInt(attributes, "width"),
                            toInt(attributes, "height"),
                            toOrientation(attributes, "orientation"),
                            CEvent.power(),
                            getImage(attributes, "imagedown"),
                            getImage(attributes, "imageup"),
                            stringToBoolean(attributes.getValue("autorotate"), false)));
                    break;
                case "back":
                    ch.addArea(new CButton(toPoint(attributes),
                            toInt(attributes, "width"),
                            toInt(attributes, "height"),
                            toOrientation(attributes, "orientation"),
                            CEvent.back(),
                            getImage(attributes, "imagedown"),
                            getImage(attributes, "imageup"),
                            stringToBoolean(attributes.getValue("autorotate"), false)));
                    break;
                case "home":
                    ch.addArea(new CButton(toPoint(attributes),
                            toInt(attributes, "width"),
                            toInt(attributes, "height"),
                            toOrientation(attributes, "orientation"),
                            CEvent.home(),
                            getImage(attributes, "imagedown"),
                            getImage(attributes, "imageup"),
                            stringToBoolean(attributes.getValue("autorotate"), false)));
                    break;
                case "action":
                    ch.addArea(new CButton(toPoint(attributes),
                            toInt(attributes, "width"),
                            toInt(attributes, "height"),
                            toOrientation(attributes, "orientation"),
                            CEvent.action(),
                            getImage(attributes, "imagedown"),
                            getImage(attributes, "imageup"),
                            stringToBoolean(attributes.getValue("autorotate"), false)));
                    break;
                case "image":
                    ch.addArea(new CDrawable(toPoint(attributes),
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

        private CPoint toPoint(Attributes attributes) {
            try {
                return new CPoint(attributes);
            } catch (CPoint.CPointException ex) {
                throw new NumberFormatException(error(ex.tag, ex.reason));
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
}
