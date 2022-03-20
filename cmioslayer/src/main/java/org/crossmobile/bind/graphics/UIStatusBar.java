/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGColor;
import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSTimer;
import crossmobile.ios.uikit.*;
import org.crossmobile.bridge.Native;

import java.util.Calendar;
import java.util.Date;

import static crossmobile.ios.uikit.UIDeviceOrientation.*;

public final class UIStatusBar extends UIView {

    public static final int HEIGHT = 20;
    public static final boolean required = Native.uiguidelines().shouldDisplayStatusBar();
    private static UIStatusBar statusBar = new UIStatusBar();

    private final Calendar cal = Calendar.getInstance();
    private UILabel time, appName;
    private UIImageView receiptImg, wifiImg;
    private UIBattery battery;
    private boolean styleDark = true;
    private boolean isStyleSet = false;
    private int receipt = 5;
    private int wifi = 1;

    public static UIStatusBar getStatusBar() {
        if (statusBar == null)
            statusBar = new UIStatusBar();
        return statusBar;
    }

    public UIStatusBar() {
        super(new CGRect(0, 0, 200, HEIGHT));
        setUserInteractionEnabled(true);
        if (!required)
            return;

        appName = new UILabel(new CGRect(0, 0, 200, HEIGHT - 2)); // It is visually more attractive to push labels a pixel up
        appName.setTextColor(UIColor.colorWithWhiteAlpha(0.7, 1));
        appName.setText(System.getProperty("cm.display.name"));
        appName.setTextAlignment(UITextAlignment.Center);
        appName.setFont(UIFont.boldSystemFontOfSize(14));
        appName.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth | UIViewAutoresizing.FlexibleHeight);
        addSubview(appName);

        time = new UILabel(new CGRect(132, 0, 40, HEIGHT - 2));// It is visually more attractive to push labels a pixel up
        time.setTextColor(UIColor.colorWithWhiteAlpha(0.7, 1));
        time.setTextAlignment(UITextAlignment.Right);
        time.setFont(UIFont.boldSystemFontOfSize(14));
        time.setAutoresizingMask(UIViewAutoresizing.FlexibleLeftMargin | UIViewAutoresizing.FlexibleHeight);
        addSubview(time);

        receiptImg = new UIImageView(new CGRect(4, 4, 14, 10));
        receiptImg.setContentMode(UIViewContentMode.ScaleToFill);
        addSubview(receiptImg);

        wifiImg = new UIImageView(new CGRect(24, 4, 11, 10));
        wifiImg.setContentMode(UIViewContentMode.ScaleToFill);
        addSubview(wifiImg);

        battery = new UIBattery(new CGRect(176, 4, 20, 10));
        battery.setAutoresizingMask(UIViewAutoresizing.FlexibleLeftMargin);
        addSubview(battery);

        Date now = new Date();
        cal.setTime(now);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        NSTimer.scheduledTimerWithTimeInterval(60 - (now.getTime() - cal.getTimeInMillis()) / 1000d + 0.001, timer -> {
            updateTime(null);
            NSTimer.scheduledTimerWithTimeInterval(60, (NSTimer timer1) -> updateTime(null), null, true);
        }, null, false);
        updateTime(now);
        updateStyle();
    }

    private void updateTime(Date now) {
        if (now == null)
            now = new Date();
        cal.setTime(now);
        int minute = cal.get(Calendar.MINUTE);
        String tt = cal.get(Calendar.HOUR_OF_DAY) + ":" + (minute < 10 ? "0" : "") + cal.get(Calendar.MINUTE);
        time.setText(tt);
        setNeedsDisplay();
    }

    private void updateStyle() {
        if (!required)
            return;

        UIColor color = styleDark
                ? UIColor.blackColor()
                : UIColor.whiteColor();
        appName.setTextColor(color);
        time.setTextColor(color);

        if (wifi == -1)
            wifiImg.setHidden(true);
        else {
            wifiImg.setHidden(false);
            wifiImg.setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + (styleDark ? Theme.Images.WIFI1_DARK[wifi] : Theme.Images.WIFI1_BRIGHT[wifi])));
        }

        if (receipt == -2)
            receiptImg.setHidden(true);
        else {
            receiptImg.setHidden(false);
            receiptImg.setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + (styleDark ? Theme.Images.REC_DARK[receipt + 1] : Theme.Images.REC_BRIGHT[receipt + 1])));
        }

        setNeedsDisplay();
    }

    public boolean statusBarStyleDark() {
        return styleDark;
    }

    public void setStatusBarStyle(int requestStyle) {
        boolean requestDark = requestStyle != UIStatusBarStyle.LightContent;
        if (isStyleSet && this.styleDark == requestDark)
            return;
        isStyleSet = true;
        this.styleDark = requestDark;
        Native.uiguidelines().setStatusBarDark(requestDark);
        updateStyle();
    }

    public void setWifi(float reception) {
        if (reception < 0)
            wifi = -1;
        else {
            wifi = (int) (reception * 3);
            if (wifi > 2)
                wifi = 2;
        }
        updateStyle();
    }

    public void setReception(float reception) {
        if (reception < -1.5)
            receipt = -2;
        else if (reception < 0)
            receipt = -1;
        else {
            receipt = (int) (reception * 6);
            if (receipt > 5)
                receipt = 5;
        }
        updateStyle();
    }

    public void setBatteryLevel(float percent) {
        if (percent < 0)
            percent = 0;
        else if (percent > 1)
            percent = 1;
        battery.level = percent;
        setNeedsDisplay();
    }

    public boolean isStatusBarHidden() {
        return isHidden();
    }

    public void setStatusBarHidden(boolean statusBarHidden) {
        if (statusBarHidden == isHidden())
            return;
        setHidden(statusBarHidden);
        UIApplication app = UIApplication.sharedApplication();
        if (app == null)
            return;
        UIWindow w = app.keyWindow();
        if (w == null)
            return;
        UIViewController vc = w.rootViewController();
        if (vc != null && vc.isViewLoaded())
            vc.view().layoutSubviews();
    }

    public int statusBarOrientation() {
        return Native.graphics().metrics().orientation;
    }

    public void setStatusBarOrientation(int UIInterfaceOrientation, boolean animated) {
        DrawableMetrics metrics = Native.graphics().metrics();
        int x, y, width;
        switch (metrics.getOrientation()) {
            case LandscapeLeft:
                width = metrics.getVirtualHeight();
                x = metrics.getVirtualWidth() - (width + HEIGHT) / 2;
                y = (width - HEIGHT) / 2;
                setTransform(CGAffineTransform.makeRotation(GraphicsContext._PI_2));
                break;
            case LandscapeRight:
                width = metrics.getVirtualHeight();
                x = (HEIGHT - width) / 2;
                y = (width - HEIGHT) / 2;
                setTransform(CGAffineTransform.makeRotation(-GraphicsContext._PI_2));
                break;
            case PortraitUpsideDown:
                x = 0;
                y = metrics.getVirtualHeight() - HEIGHT;
                width = metrics.getVirtualWidth();
                setTransform(CGAffineTransform.makeRotation(GraphicsContext._PI));
                break;
            default:
            case Portrait:
                x = 0;
                y = 0;
                width = metrics.getVirtualWidth();
                setTransform(null);
                break;
        }
        setFrame(new CGRect(x, y, width, HEIGHT));
    }

    private class UIBattery extends UIView {

        private float level;
        private CGColor color;

        public UIBattery(CGRect frame) {
            super(frame);
            setLevel(0.5f);
        }

        private void setLevel(float newLevel) {
            this.level = newLevel;
            color = level <= 0.2 ? UIColor.redColor().CGColor() : (styleDark ? UIColor.blackColor().CGColor() : UIColor.whiteColor().CGColor());
        }

        @Override
        public final void drawRect(CGRect rect) {
            CGContext cxt = UIGraphics.getCurrentContext();
            cxt.setStrokeColorWithColor(color);
            cxt.setFillColorWithColor(color);

            int batterySize = (int) (rect.getSize().getWidth() * 0.9);
            int pinDiff = (int) (rect.getSize().getHeight() * 0.25);

            cxt.strokeRect(new CGRect(rect.getOrigin().getX(), rect.getOrigin().getY(), batterySize, rect.getSize().getHeight()));
            cxt.fillRect(new CGRect(rect.getOrigin().getX() + batterySize, rect.getOrigin().getY() + pinDiff, rect.getSize().getWidth() - batterySize, rect.getSize().getHeight() - 2 * pinDiff));
            cxt.fillRect(new CGRect(rect.getOrigin().getX(), rect.getOrigin().getY(), level * batterySize, rect.getSize().getHeight()));
        }
    }
}
