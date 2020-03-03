// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.backend.swing;

import crossmobile.ios.coregraphics.CGAffineTransform;
import org.crossmobile.backend.desktop.CDrawable;
import org.crossmobile.backend.desktop.DesktopDrawableMetrics;
import org.crossmobile.backend.desktop.DesktopGraphicsBridge;
import org.crossmobile.bind.graphics.*;
import org.crossmobile.bridge.Native;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static crossmobile.ios.uikit.UIDeviceOrientation.*;

public class SwingGraphicsBridge extends DesktopGraphicsBridge<Graphics2D, SwingNativePath, AffineTransform> {

    public static JEmulatorFrame frame;
    public static JEmulatorPanel component;
    public static Graphics2D defaultGraphics;
    private String backChar;

    @Override
    public DrawableMetrics newMetrics() {
        return new SwingDrawableMetrics();
    }

    @Override
    public GraphicsContext newGraphicsContext(Graphics2D graphics, boolean isLive) {
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
    public NativeFont getFont(String family, double size, boolean bold, boolean italic) {
        return SwingFont.getFont(family, (float) size, bold, italic);
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
    public void relayoutMainView() {
//        Point center = frame.getLocation();
//        center.x += frame.getWidth() / 2;
//        center.y += frame.getHeight() / 2;
        DesktopDrawableMetrics metrics = (DesktopDrawableMetrics) metrics();
        Dimension wants = new Dimension(metrics.getOrientedFrameWidth(), metrics.getOrientedFrameHeight());
        JEmulatorPanel panel = SwingGraphicsBridge.component;
        if (!panel.getSize().equals(wants)) {
            setComponentSize(panel, wants);
            frame.remove(panel);
            frame.add(panel, BorderLayout.CENTER);
            frame.pack();
        }
//        if (OperatingSystem.current != OperatingSystem.Windows)
//            frame.setLocation(center.x - frame.getWidth() / 2, center.y - frame.getHeight() / 2);
        Native.widget().resignFocus();
        super.relayoutMainView();
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
    public void draw(CDrawable drawable, GraphicsContext cxt, int orientation) {
        Graphics2D g = ((SwingGraphicsContext) cxt).g2;
        if ((drawable.orientation & orientation) != 0) {
            AffineTransform t = null;
            if (drawable.autorotate && orientation != Portrait) {
                t = g.getTransform();
                g.rotate(
                        orientation == PortraitUpsideDown ? Math.PI : (orientation == LandscapeLeft ? Math.PI / 2 : Math.PI * 3 / 2),
                        drawable.x() + (drawable.width() / 2d), drawable.y() + (drawable.height() / 2d));
            }
            g.drawImage(drawable.isActive() ? ((SwingBitmap) drawable.active).img : ((SwingBitmap) drawable.inactive).img, drawable.x(), drawable.y(), drawable.width(), drawable.height(), null);
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
