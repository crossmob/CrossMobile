/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.gui.parameters;

import com.panayotis.hrgui.HiResComboBox;
import com.panayotis.hrgui.HiResComponent;
import com.panayotis.hrgui.HiResPanel;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.gui.actives.ActiveTextField;
import org.crossmobile.utils.ParamList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

import static org.crossmobile.utils.ParamsCommon.CM_SCREEN_SCALE;

public class ScreenScaleParameter extends ProjectParameter {

    private String[] parameter;
    private String[] display;
    private String[] definition;
    private int value;
    private HiResComboBox item;
    private Consumer<HiResPanel> panelCallback;
    private int width;
    private ActiveTextField widthField;
    private int height;
    private ActiveTextField heightField;
    private HiResPanel sizefields;

    // Defaults
    private int DEFAULTWIDTH = 320;
    private int DEFALTHEIGHT = 568;

    public ScreenScaleParameter(ParamList plist) {
        super(plist, CM_SCREEN_SCALE.tag());

        this.parameter = new String[]{"NATIVE", "DPI", "FIXED"};
        this.display = new String[]{"Native", "Device DPI", "Fixed"};
        this.definition = new String[]{"All sizes will be in Native pixels", "All sizes will be in density-independent pixels", "Sets Screen Size to a fixed size (320x568 by default)"};
        if (this.display == null)
            this.display = this.parameter;
        if (this.parameter.length != this.display.length || (this.definition != null && this.definition.length != this.parameter.length))
            throw new ArrayIndexOutOfBoundsException("Selection list parameters do not match: " + this.parameter.length + "," + this.display.length + (this.definition != null ? "," + this.definition.length : ""));
        this.value = 1;
        try {
            String v = plist.dereferenceProperty(CM_SCREEN_SCALE.tag().name).split(":")[0].trim().toLowerCase();
            for (int i = 0; i < parameter.length; i++)
                if (parameter[i].toLowerCase().startsWith(v)) {
                    value = i;
                    if (v.startsWith("fixed")) {
                        width = Integer.parseInt(plist.dereferenceProperty(CM_SCREEN_SCALE.tag().name).split(":")[1]);
                        height = Integer.parseInt(plist.dereferenceProperty(CM_SCREEN_SCALE.tag().name).split(":")[2]);
                        updateFixed();
                    } else {
                        width = DEFAULTWIDTH;
                        height = DEFALTHEIGHT;
                        updateFixed();
                    }
                    break;
                }
        } catch (Exception ex) {
        }
    }

    @Override
    public String getVisualTag() {
        return "Screen Scaling";
    }

    public void setPanelCallback(Consumer<HiResPanel> panelCallback) {
        this.panelCallback = panelCallback;
    }

    @Override
    public String getValue() {
        return parameter[value];
    }

    @Override
    protected boolean isSingleLineVisual() {
        return true;
    }

    @Override
    protected HiResComponent initVisuals() {
        HiResPanel comp = new HiResPanel();
        comp.setOpaque(false);

        item = new HiResComboBox(display);
        item.setSelectedIndex(value);
        item.setOpaque(false);
        item.addActionListener((ActionEvent ae) -> {
            int newValue = item.getSelectedIndex();
            if (newValue != value) {
                value = newValue;
                if (value == 2)
                    addSizeFields();
                else
                    removeSizeFields();
                fireValueUpdated();
            }
        });
        widthField = new ActiveTextField(String.valueOf(width));
        widthField.setColumns(3);
        widthField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int newwidth = Integer.parseInt(widthField.getText());
                    if (newwidth != width) {
                        if (newwidth / 10000 > 0)
                            throw new NumberFormatException();
                        width = newwidth;
                        updateFixed();
                        fireValueUpdated();
                    }
                } catch (NumberFormatException ex) {
                    widthField.setText(String.valueOf(width));
                }
            }
        });
        heightField = new ActiveTextField(String.valueOf(height));
        heightField.setColumns(3);
        heightField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int newheight = Integer.parseInt(heightField.getText());
                    if (newheight != height) {
                        if (newheight / 10000 > 0)
                            throw new NumberFormatException();
                        height = newheight;
                        updateFixed();
                        fireValueUpdated();
                    }
                } catch (NumberFormatException ex) {
                    heightField.setText(String.valueOf(height));
                }
            }
        });
        ActiveLabel x = new ActiveLabel(" x ");
        sizefields = new HiResPanel(new FlowLayout());
        sizefields.setOpaque(false);
        sizefields.add(widthField);
        sizefields.add(x);
        sizefields.add(heightField);
        comp.setLayout(new BorderLayout());
        comp.add(item, BorderLayout.CENTER);
        comp.add(sizefields, BorderLayout.EAST);
        if (value == 2)
            sizefields.setVisible(true);
        else
            sizefields.setVisible(false);
        if (panelCallback != null)
            panelCallback.accept(comp);
        return comp;
    }

    private void addSizeFields() {
        sizefields.setVisible(true);
    }

    private void removeSizeFields() {
        sizefields.setVisible(false);
    }

    private void updateFixed() {
        parameter[2] = "FIXED" + ":" + width + ":" + height;
    }
}
