package org.crossmobile.xray;

import com.panayotis.xray.XRayPlugin;

import javax.swing.*;
import java.awt.*;

import static com.panayotis.ce.CEventCommons.CHANGE_DEBUG_TOUCH;
import static com.panayotis.ce.CEventCommons.DEBUG_TOUCH;
import static com.panayotis.ce.CEventManager.addListener;
import static com.panayotis.ce.CEventManager.fireEvent;

public class UIKitTouchPlugin implements XRayPlugin {

    private UIKitTouchPanel panel = new UIKitTouchPanel();

    private DefaultListModel<String> events = new DefaultListModel<>();

    @Override
    public void onInit(Runnable IamReady) {
        UIKitXRayPlugin.registerTouchPlugin(this);
        panel.entriesL.setModel(events);
    }

    @Override
    public String getPluginName() {
        return "Touches";
    }

    @Override
    public JComponent getVisuals() {
        return panel.$$$getRootComponent$$$();
    }

    @Override
    public int priority() {
        return 900;
    }

    void initTouches(ReflectionClassSupport reflection) {
        EventQueue.invokeLater(() -> addListener(meta -> {
            events.addElement(meta.toString());
            int index = events.getSize() - 1;
            panel.entriesL.setSelectedIndex(index);
            panel.entriesL.ensureIndexIsVisible(index);
        }, DEBUG_TOUCH));
        panel.touchB.addActionListener(e -> fireEvent(CHANGE_DEBUG_TOUCH, panel.touchB.isSelected()));
    }
}
