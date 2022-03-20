/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.uikit.UIView;
import org.crossmobile.backend.swing.SwingGraphicsBridge.SizableComponent;
import org.crossmobile.backend.swing.SwingNativeDispatcher.DesktopNativeWidget;
import org.crossmobile.bind.wrapper.NativeDispatcher;
import org.crossmobile.bind.wrapper.NativeTouch;
import org.crossmobile.bind.wrapper.NativeWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class SwingNativeDispatcher extends NativeDispatcher<UIView, DesktopNativeWidget, MouseEvent, SwingGraphicsContext> {

    private final SwingWrapperClickConsumer consumer;

    public SwingNativeDispatcher(WidgetWrapper<UIView, DesktopNativeWidget, SwingGraphicsContext> holder) {
        super(holder);
        consumer = new SwingWrapperClickConsumer((JComponent) holder.getNativeWidget());
    }

    @Override
    public void setMetrics(int x, int y, int width, int height) {
        DesktopNativeWidget snw = getWidgetWrapper().getNativeWidget();
        Container parent = snw.getParent();
        if (parent != null) {
            Insets insets = parent.getInsets();
            snw.setLocation(x + insets.right, y + insets.right);
        }
        SwingGraphicsBridge.setComponentSize(snw, new Dimension(width, height));
    }

    @Override
    public void sendTouchEvents(MouseEvent originalEvent, NativeTouch[] touches) {
        System.out.println("original event dispatching");
        if (originalEvent != null) {
            DesktopNativeWidget component = getWidgetWrapper().getNativeWidget();
            originalEvent.setSource(component);
            originalEvent.translatePoint((int) (touches[0].x) - originalEvent.getX(), (int) (touches[0].y) - originalEvent.getY());
//            component.dispatchEvent(originalEvent);
        }
    }

    @Override
    public void draw(SwingGraphicsContext cx) {
        getWidgetWrapper().getNativeWidget().superDraw(cx);
    }

    public interface DesktopNativeWidget extends NativeWrapper<SwingGraphicsContext>, SizableComponent {

        WidgetWrapper<?, ?, ?> getWrapper();

        void dispatchEvent(AWTEvent originalEvent);

        Container getParent();
    }
}
