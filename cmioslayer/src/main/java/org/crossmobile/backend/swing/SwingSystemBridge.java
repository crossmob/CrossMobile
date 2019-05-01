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
package org.crossmobile.backend.swing;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.uikit.NSTextAlignment;
import crossmobile.ios.uikit.UIAlertView;
import crossmobile.ios.uikit.UIAlertViewDelegate;
import crossmobile.ios.uikit.UITextField;
import org.crossmobile.backend.desktop.DesktopSystemBridge;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

import static crossmobile.ios.uikit.$uikit.getTextFieldWrapper;

public class SwingSystemBridge extends DesktopSystemBridge {

    /**
     * MAKE SURE that this method will run & return IMMEDIATELY when run from
     * the dispatch thread
     *
     * @param r
     */
    @Override
    public void runOnEventThread(Runnable r) {
        if (EventQueue.isDispatchThread())  // Important!! or else will lock
            r.run();
        else
            EventQueue.invokeLater(r);
    }

    @Override
    public boolean isEventThread() {
        return EventQueue.isDispatchThread();
    }

    @Override
    public void postOnEventThread(Runnable r) {
        EventQueue.invokeLater(r);
    }

    @Override
    public void showAlert(UIAlertView view, String title, String message, List<String> buttons, UIAlertViewDelegate delegate) {
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

    private JPanel appendTextFieldOnAlert(UIAlertView alert, int i, JPanel visuals, String message, Map<JTextField, JTextField> joints) {
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
    public int getNaturalTextAlignment() {
        Locale locale = new Locale.Builder().setLanguage(System.getProperty("user.language")).setRegion(System.getProperty("user.country")).build();
        return ComponentOrientation.getOrientation(locale).isLeftToRight() ? NSTextAlignment.Left : NSTextAlignment.Right;
    }
}
