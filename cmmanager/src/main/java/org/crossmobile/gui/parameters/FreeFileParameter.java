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
package org.crossmobile.gui.parameters;

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

    private static JFileChooser chooser;
    //
    private File file;
    private ActiveTextField filedata;
    private Consumer<HiResPanel> butonPanelCallback;
    private final boolean editable;
    private final boolean allFiles;

    public FreeFileParameter(String location) {
        this(null, null, location, false, false);
    }

    public FreeFileParameter(ParamList list, Param key, boolean editable) {
        this(list, key, null, editable, false);
    }

    public FreeFileParameter(ParamList list, Param key, String deflt, boolean editable, boolean allFiles) {
        super(list, key);
        this.editable = editable;
        this.allFiles = allFiles;

        String pfile = deflt == null ? (key != null ? key.deflt : null) : deflt;
        this.file = pfile == null ? null : (list == null ? new File(pfile) : new File(list.dereferenceValue(pfile, true)));
        if (list != null) {
            String found = list.get(key);
            if (found != null && !found.isEmpty())
                file = new File(list.dereferenceValue(found, true));
        }
    }

    public void setButonPanelCallback(Consumer<HiResPanel> butonPanelCallback) {
        this.butonPanelCallback = butonPanelCallback;
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

        filedata = new ActiveTextField(file == null ? "" : Paths.getPath(file.getPath(), HomeReference.PROPERTY_STYLE));
        filedata.setColumns(10);
        filedata.setEditable(false);
        filedata.setBackground(Theme.current().disabled);

        HiResPanel buttons = new HiResPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        buttons.setOpaque(false);

        if (editable || file != null) {
            HiResButton browse = new HiResButton(editable ? "Browse" : "Open");
            browse.setOpaque(false);
            browse.addActionListener((ActionEvent e) -> {
                if (editable) {
                    if (chooser == null) {
                        chooser = new JFileChooser();
                        chooser.setApproveButtonText("Use");
                        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        chooser.setDialogTitle(getVisualTag());
                        chooser.setFileHidingEnabled(!allFiles);
                    }
                    chooser.setSelectedFile(file);
                    if (chooser.showOpenDialog(comp) == JFileChooser.APPROVE_OPTION)
                        setFile(chooser.getSelectedFile());
                } else
                    try {
                        Desktop.getDesktop().open(file.isDirectory() ? file : file.getParentFile());
                    } catch (IOException ex) {
                        Log.error("Error while opening file location", ex);
                    }
            });
            buttons.add(browse);
        }

        if (butonPanelCallback != null)
            butonPanelCallback.accept(buttons);
        else if (editable) {
            HiResButton clear = new HiResButton("Clear");
            clear.setOpaque(false);
            clear.addActionListener((ActionEvent ae) -> {
                file = null;
                filedata.setText("");
            });
            buttons.add(clear);
        }
        comp.add(filedata, BorderLayout.CENTER);
        comp.add(buttons, BorderLayout.EAST);
        return comp;
    }

    protected boolean isFileAccepted(File givenFile) {
        return true;
    }

    protected void setFile(File newfile) {
        if (isFileAccepted(newfile) && !file.equals(newfile)) {
            file = newfile;
            filedata.setText(Paths.getPath(file.getPath(), HomeReference.PROPERTY_STYLE));
            fireValueUpdated();
        }
    }
}
