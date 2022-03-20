/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

import crossmobile.ios.uikit.UIDeviceOrientation;
import org.crossmobile.backend.desktop.DesktopGraphicsBridge;
import org.crossmobile.backend.desktop.DesktopLocations;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.Insets;
import org.crossmobile.bridge.Native;

import java.util.*;

import static crossmobile.ios.uikit.UIInterfaceOrientationMask.*;
import static org.crossmobile.backend.desktop.ResourceResolver.getResources;
import static org.crossmobile.backend.desktop.cgeo.ChassisLoader.loadSkins;

public class Chassis extends CSizable implements Comparable<Chassis> {

    private final int idiom;
    private final boolean fullscreen;
    private final boolean simulator;
    private final List<CArea> areas = new ArrayList<>();
    private final String name;
    private String info;
    private String descr;
    private int priority;

    private CDrawable led;
    private CScreen screen;

    private Insets[] insets;

    public static Collection<Chassis> getSkins() {
        Collection<Chassis> result = new TreeSet<>();
        getResources(DesktopLocations.SKINS + "skins.xml", in -> loadSkins(in, result));
        if (result.isEmpty())
            throw new NullPointerException("No skins found");
        return result;
    }

    public static Chassis getSkin(String name) {
        if (name == null || name.isEmpty())
            name = "system";
        Collection<Chassis> skins = getSkins();
        for (Chassis chassis : skins)
            if (chassis.name.equals(name))
                return chassis;
        Native.system().error("Unable to locate skin named " + name, null);
        return skins.iterator().next();
    }

    Chassis(String fileName, int idiom, int width, int height, String device) {
        super(width, height);
        this.name = fileName;
        this.idiom = idiom;
        this.fullscreen = "fullscreen".equals(device);
        this.simulator = "simulator".equals(device);
        this.info = info == null ? "" : info;
        this.descr = descr == null ? "" : descr;
    }

    void setInset(int orientation, int top, int left, int bottom, int right) {
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

    public Insets getInset(int deviceOrientation) {
        return insets == null || deviceOrientation < UIDeviceOrientation.Portrait || deviceOrientation > UIDeviceOrientation.LandscapeRight || insets[deviceOrientation - 1] == null
                ? Insets.zero
                : insets[deviceOrientation - 1];
    }

    void setMeta(String info, String descr, int priority) {
        this.info = info;
        this.descr = descr;
        this.priority = priority;
    }

    void addArea(CArea area) {
        areas.add(area);
    }

    void setLed(CDrawable led) {
        this.led = led;
        addArea(led);
    }

    void setScreen(CScreen screen) {
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

    public CEvent findArea(int virtualX, int virtualY, int orientation) {
        for (CArea item : CClickable.Reverse.reversed(areas))
            if (item instanceof CClickable && item.contains(virtualX, virtualY, orientation))
                return ((CClickable) item).getEvent();
        return CEvent.window();
    }

    public CScreen screen() {
        return screen;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public boolean isSimulator() {
        return simulator;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void draw(GraphicsContext<?> context, boolean above, int orientation) {
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

    public void setActive(boolean status) {
        if (led != null)
            led.setActive(status);
    }

    public boolean isActive() {
        return led != null && led.isActive();
    }

    @Override
    public int compareTo(Chassis o) {
        if (priority != o.priority)
            return priority > o.priority ? 1 : -1;
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

    @Override
    public void setScale(double scale) {
        super.setScale(scale);
        for (CArea area : areas)
            area.setScale(scale);
    }

    @Override
    public void resize(int virtualWidth, int virtualHeight) {
        super.resize(virtualWidth, virtualHeight);
        screen.resize(virtualWidth, virtualHeight);
    }

    @Override
    public String toString() {
        return "Chassis{" +
                "width=" + virtualWidth() +
                ", height=" + virtualHeight() +
                '}';
    }
}
