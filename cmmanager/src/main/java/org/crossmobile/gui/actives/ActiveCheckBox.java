/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crossmobile.gui.actives;

import com.panayotis.hrgui.HiResCheckBox;
import com.panayotis.hrgui.HiResIcon;
import org.crossmobile.gui.elements.Theme;

import javax.swing.*;
import java.awt.*;

public class ActiveCheckBox extends HiResCheckBox {

    private final TooltipManager ttm = new TooltipManager(this);

    {
        setOpaque(false);
    }

    public ActiveCheckBox() {
    }

    public ActiveCheckBox(HiResIcon icon) {
        super(icon);
    }

    public ActiveCheckBox(HiResIcon icon, boolean selected) {
        super(icon, selected);
    }

    public ActiveCheckBox(String text) {
        super(text);
    }

    public ActiveCheckBox(Action a) {
        super(a);
    }

    public ActiveCheckBox(String text, boolean selected) {
        super(text, selected);
    }

    public ActiveCheckBox(String text, HiResIcon icon) {
        super(text, icon);
    }

    public ActiveCheckBox(String text, HiResIcon icon, boolean selected) {
        super(text, icon, selected);
    }

    @Override
    public Color getForeground() {
        return Theme.current().text;
    }

    @Override
    public void setToolTipText(String text) {
        ttm.setToolTipText(text);
    }

    public void setToolTip(JToolTip toolTip) {
        ttm.setToolTip(toolTip);
    }
}
