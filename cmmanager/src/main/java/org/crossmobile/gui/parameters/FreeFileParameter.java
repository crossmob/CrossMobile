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

import com.panayotis.appenh.AFileChooser;
import com.panayotis.hrgui.HiResButton;
import com.panayotis.hrgui.HiResComponent;
import com.panayotis.hrgui.HiResPanel;
import org.crossmobile.gui.actives.ActiveTextField;
import org.crossmobile.gui.elements.Theme;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.gui.utils.Paths.HomeReference;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

public abstract class FreeFileParameter extends ProjectParameter {
    private File file;
    private ActiveTextField fileData;
    private Consumer<HiResPanel> buttonPanelCallback;
    private final boolean editable;
    private AFileChooser afc = new AFileChooser().setRememberSelection(true);

    public FreeFileParameter(String location) {
        this(null, null, location, false);
    }

    public FreeFileParameter(ParamList list, Param key, boolean editable) {
        this(list, key, null, editable);
    }

    public FreeFileParameter(ParamList list, Param key, String deflt, boolean editable) {
        super(list, key);
        this.editable = editable;
        String pfile = deflt == null ? (key != null ? key.deflt : null) : deflt;
        this.file = pfile == null ? null : (list == null ? new File(pfile) : new File(list.dereferenceValue(pfile, true)));
        if (list != null) {
            String found = list.get(key);
            if (found != null && !found.isEmpty())
                file = new File(list.dereferenceValue(found, true));
        }
    }

    public void setButtonPanelCallback(Consumer<HiResPanel> buttonPanelCallback) {
        this.buttonPanelCallback = buttonPanelCallback;
    }

    @Override
    public String getValue() {
        return file == null ? "" : file.getPath();
    }

    @Override
    protected boolean isSingleLineVisual() {
        return true;
    }

    @Override
    protected HiResComponent initVisuals() {
        HiResPanel comp = new HiResPanel(new BorderLayout());
        comp.setOpaque(false);

        fileData = new ActiveTextField(file == null ? "" : Paths.getPath(file.getPath(), HomeReference.PROPERTY_STYLE));
        fileData.setColumns(10);
        fileData.setEditable(false);
        fileData.setBackground(Theme.current().disabled);

        HiResPanel buttons = new HiResPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        buttons.setOpaque(false);

        if (editable || file != null) {
            HiResButton browse = new HiResButton(editable ? "Browse" : "Open");
            browse.setOpaque(false);
            browse.addActionListener((ActionEvent e) -> {
                if (editable) {
                    File old = new File(getValue());
                    if (old.isFile() || old.isDirectory())
                        afc.setDirectory(old.isFile() ? old.getParentFile() : old);
                    File selection = afc.openSingle();
                    if (selection != null)
                        setFile(selection);
                } else
                    try {
                        Desktop.getDesktop().open(file.isDirectory() ? file : file.getParentFile());
                    } catch (IOException ex) {
                        Log.error("Error while opening file location", ex);
                    }
            });
            buttons.add(browse);
        }

        if (buttonPanelCallback != null)
            buttonPanelCallback.accept(buttons);
        else if (editable) {
            HiResButton clear = new HiResButton("Clear");
            clear.setOpaque(false);
            clear.addActionListener((ActionEvent ae) -> {
                file = null;
                fileData.setText("");
            });
            buttons.add(clear);
        }
        comp.add(fileData, BorderLayout.CENTER);
        comp.add(buttons, BorderLayout.EAST);
        return comp;
    }

    protected boolean isFileAccepted(File givenFile) {
        return true;
    }

    protected void setFile(File newfile) {
        if (isFileAccepted(newfile) && !file.equals(newfile)) {
            file = newfile;
            fileData.setText(Paths.getPath(file.getPath(), HomeReference.PROPERTY_STYLE));
            fireValueUpdated();
        }
    }
}
