/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.coregraphics.CGAffineTransform;
import org.crossmobile.backend.desktop.cgeo.CDrawable;
import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.backend.desktop.DesktopGraphicsBridge;
import org.crossmobile.bind.graphics.*;
import org.crossmobile.bridge.Native;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static crossmobile.ios.uikit.UIDeviceOrientation.*;

public class SwingGraphicsBridge extends DesktopGraphicsBridge<Graphics2D, AffineTransform> {

    public static JEmulatorFrame frame;
    public static JEmulatorPanel component;
    public static Graphics2D defaultGraphics;

    @Override
    public DrawableMetrics newMetrics() {
        return new SwingDrawableMetrics();
    }

    @Override
    public SwingGraphicsContext newGraphicsContext(Graphics2D graphics, boolean isLive) {
        return new SwingGraphicsContext(graphics == null ? getDefaultGraphics() : graphics, isLive);
    }

    @Override
    public CGAffineTransform nativeToTarget(AffineTransform from, CGAffineTransform to) {
        if (to == null)
            to = new CGAffineTransform(from.getScaleX(),
                    from.getShearY(),
                    from.getShearX(),
                    from.getScaleY(),
                    from.getTranslateX(),
                    from.getTranslateY());
        else {
            to.setA(from.getScaleX());
            to.setB(from.getShearY());
            to.setC(from.getShearX());
            to.setD(from.getScaleY());
            to.setTx(from.getTranslateX());
            to.setTy(from.getTranslateY());
        }
        return to;
    }

    @Override
    public AffineTransform targetToNative(CGAffineTransform from, AffineTransform to) {
        if (to == null)
            to = new AffineTransform(from.getA(), from.getB(), from.getC(), from.getD(), from.getTx(), from.getTy());
        else
            to.setTransform(from.getA(), from.getB(), from.getC(), from.getD(), from.getTx(), from.getTy());
        return to;
    }

    @Override
    protected void requestRepaint() {
        component.repaint();
    }

    @Override
    public NativeFont getFont(String fontName, double size) {
        return SwingFont.getFont(fontName, (float) size);
    }

    @Override
    public NativePath newNativePath() {
        return new SwingNativePath();
    }

    @Override
    public Graphics2D createCanvas(NativeBitmap bitmap) {
        return ((SwingBitmap) bitmap).img.createGraphics();
    }

    @Override
    public void resizeWindow() {
        DesktopDrawableMetrics metrics = (DesktopDrawableMetrics) metrics();
        Dimension wants = new Dimension(metrics.getOrientedFrameWidth(), metrics.getOrientedFrameHeight());
        JEmulatorPanel panel = SwingGraphicsBridge.component;
        if (!panel.getSize().equals(wants)) {
            setComponentSize(panel, wants);
            frame.remove(panel);
            frame.add(panel, BorderLayout.CENTER);
            frame.pack();
        }
        Native.widget().resignFocus();
    }

    public static void setComponentSize(SizableComponent c, Dimension d) {
        c.setPreferredSize(d);
        c.setMaximumSize(d);
        c.setMinimumSize(d);
        c.setSize(d);
    }

    @Override
    public void destroyCanvas(Graphics2D canvas) {
        canvas.dispose();
    }

    @Override
    public void draw(CDrawable drawable, GraphicsContext<?> cxt, int orientation) {
        Graphics2D g = ((SwingGraphicsContext) cxt).g2;
        if ((drawable.orientation & orientation) != 0) {
            AffineTransform t = null;
            if (drawable.autorotate && orientation != Portrait) {
                t = g.getTransform();
                g.rotate(
                        orientation == PortraitUpsideDown ? Math.PI : (orientation == LandscapeLeft ? Math.PI / 2 : Math.PI * 3 / 2),
                        drawable.virtualX() + (drawable.virtualWidth() / 2d), drawable.virtualY() + (drawable.virtualHeight() / 2d));
            }
            g.drawImage(((SwingBitmap) drawable.getImage()).img, drawable.hardwareX(), drawable.hardwareY(), drawable.hardwareWidth(), drawable.hardwareHeight(), null);
            if (t != null)
                g.setTransform(t);
        }
    }

    public static Graphics2D getDefaultGraphics() {
        if (defaultGraphics == null)
            defaultGraphics = (Graphics2D) component.getGraphics();
        return defaultGraphics;
    }

    public interface SizableComponent {

        void setPreferredSize(Dimension size);

        void setMaximumSize(Dimension size);

        void setMinimumSize(Dimension size);

        void setSize(Dimension size);

        void setLocation(int i, int i0);
    }

}
