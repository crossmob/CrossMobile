/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.uikit.UITextField;
import org.crossmobile.backend.desktop.DesktopSystemBridge;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

import static crossmobile.ios.uikit.UserInterfaceDrill.getTextFieldWrapper;

public class SwingSystemBridge extends DesktopSystemBridge {

    @SuppressWarnings("deprecation")
    @Override
    public void showAlert(crossmobile.ios.uikit.UIAlertView view, String title, String message, List<String> buttons, crossmobile.ios.uikit.UIAlertViewDelegate delegate) {
        JPanel visuals = null;
        final Map<JTextField, JTextField> joints = new HashMap<>();
        visuals = appendTextFieldOnAlert(view, 0, visuals, message, joints);
        visuals = appendTextFieldOnAlert(view, 1, visuals, message, joints);
        int buttonCount = buttons.size();
        Object[] orderedButtons = new Object[buttonCount];
        for (int i = 0; i < buttons.size(); i++)
            orderedButtons[i] = buttons.get(buttonCount - 1 - i);
        int what = JOptionPane.showOptionDialog(null, visuals == null ? message : visuals, title, 0, JOptionPane.WARNING_MESSAGE, null, orderedButtons, null);
        for (JTextField key : joints.keySet())
            key.setText(joints.get(key).getText());

        if (delegate == null)
            return;
        if (what < 0)
            what = 0;
        else
            what = buttonCount - 1 - what;
        delegate.clickedButtonAtIndex(view, what);
    }

    @SuppressWarnings("deprecation")
    private JPanel appendTextFieldOnAlert(crossmobile.ios.uikit.UIAlertView alert, int i, JPanel visuals, String message, Map<JTextField, JTextField> joints) {
        if (alert == null)
            return visuals;
        UITextField tf = alert.textFieldAtIndex(i);
        if (tf == null)
            return visuals;
        if (visuals == null) {
            visuals = new JPanel(new GridLayout(0, 1));
            if (message != null)
                visuals.add(new JLabel(message));
        }
        final JTextField attached = (JTextField) getTextFieldWrapper(tf).getNativeWidget();
        final JTextField mirror = new JTextField(attached.getText());
        joints.put(attached, mirror);
        visuals.add(mirror);
        return visuals;
    }

    @Override
    public void showActionSheet(String title, String cancelTitle, String destructiveTitle, List<String> otherTitles, NSSelector<Integer> callback) {
        JPanel selection = null;
        ButtonGroup group = null;

        if (otherTitles != null) {
            selection = new JPanel(new GridLayout(0, 1));
            group = new ButtonGroup();
            for (int i = 0; i < otherTitles.size(); i++) {
                JRadioButton button = new JRadioButton(otherTitles.get(i));
                button.setActionCommand(String.valueOf(i));
                group.add(button);
                selection.add(button);
            }
            group.getElements().nextElement().setSelected(true);
        }

        List<String> selectionButtons = new ArrayList<>();
        List<Integer> selectionIndices = new ArrayList<>();
        if (otherTitles != null) {
            selectionButtons.add(otherTitles.size() > 1 ? "Select" : otherTitles.get(0));
            selectionIndices.add(0);
        }
        if (destructiveTitle != null) {
            selectionButtons.add(destructiveTitle);
            selectionIndices.add(DESTROY_ID);
        }
        if (cancelTitle != null) {
            selectionButtons.add(cancelTitle);
            selectionIndices.add(CANCEL_ID);
        }

        int selected = JOptionPane.showOptionDialog(null, selection == null ? title : selection, title, 0, JOptionPane.INFORMATION_MESSAGE, null,
                selectionButtons.toArray(), null);

        int result = CANCEL_ID;
        if (selected >= 0) {
            result = selectionIndices.get(selected);
            if (result == 0 && otherTitles != null && otherTitles.size() > 1)
                result = Integer.parseInt(group.getSelection().getActionCommand());
        }
        callback.exec(result);
    }

    private static JButton getButton(String title, int id) {
        JButton button = new JButton(title);
        button.setActionCommand(String.valueOf(id));
        button.addActionListener(l -> {
            Component c = button;
            while (c != null && !(c instanceof Dialog))
                c = c.getParent();
            if (c != null)
                c.setVisible(false);
        });
        return button;
    }

    @Override
    public boolean isRTL() {
        return !ComponentOrientation.getOrientation(Locale.getDefault()).isLeftToRight();
    }
}
