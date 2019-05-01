/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.xray;

import com.panayotis.ce.CEventManager;
import com.panayotis.xray.XRayPlugin;
import com.panayotis.xray.utils.Profiling;
import com.panayotis.xray.utils.ThemeLaF;

import javax.swing.*;
import java.awt.*;

import static com.panayotis.ce.CEventCommons.DEBUG_GRAPHICS;
import static javax.swing.SwingUtilities.invokeLater;

public class UIKitXRayPlugin implements XRayPlugin {
    private static JPanel parent;
    private static UIKitVisuals visuals;
    private static Runnable IamReady;
    static boolean editMode;

    private static UIKitTouchPlugin touch;

    private boolean firstTime = true;

    static {
        parent = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Please wait, initializing plugin");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        parent.add(label);
    }

    static {
        ThemeLaF.setLaF();
    }

    @Override
    public void onInit(Runnable IamReady) {
        UIKitXRayPlugin.IamReady = IamReady;
        CEventManager.addListener(meta -> {
            if (firstTime) {
                firstTime = false;
                invokeLater(() -> initVisuals(new ReflectionClassSupport(meta.getClass().getClassLoader())));
            } else
                tick();
        }, DEBUG_GRAPHICS);
        Profiling.addListener(frame -> {
            if (frame != 0)
                System.out.println(frame + "fps");
        });
        Profiling.start();
    }

    static void registerTouchPlugin(UIKitTouchPlugin touch) {
        UIKitXRayPlugin.touch = touch;
    }

    private static void initVisuals(ReflectionClassSupport reflection) {
        parent.removeAll();
        parent.add(visuals = new UIKitVisuals(reflection));
        parent.validate();
        touch.initTouches(reflection);
        IamReady.run();
    }

    private static void tick() {
        Profiling.tick();
    }

    // Used by CrossMobile runtime to check if touches should be ignored - DO NOT REMOVE
    public static boolean shouldIgnoreTouch(Object event) {
        return editMode;
    }

    @Override
    public String getPluginName() {
        return "Views";
    }

    @Override
    public JPanel getVisuals() {
        return parent;
    }

    @Override
    public void onFocus() {
        if (visuals != null)
            visuals.update();
    }

    @Override
    public int priority() {
        return -1000;
    }
}
