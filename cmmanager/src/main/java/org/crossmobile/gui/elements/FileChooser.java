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
package org.crossmobile.gui.elements;

import org.crossmobile.prefs.Prefs;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class FileChooser {

    private static JFileChooser chooser;

    public static Collection<File> dialog(String title, String button, boolean showHidden) {
        return dialog(title, button, showHidden, null, false);
    }

    public static Collection<File> dialog(String title, String button, boolean showHidden, boolean singleSelection) {
        return dialog(title, button, showHidden, null, singleSelection);
    }

    public static Collection<File> dialog(String title, String button, boolean showHidden, FileFilter fileFilter) {
        return dialog(title, button, showHidden, fileFilter, false);
    }

    public static Collection<File> dialog(String title, String button, boolean showHidden, FileFilter fileFilter, boolean singleSelection) {
        if (chooser == null) {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(Prefs.getCurrentDir());
            chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        }

        chooser.setFileSelectionMode(
                fileFilter == null
                        ? JFileChooser.FILES_AND_DIRECTORIES
                        : JFileChooser.FILES_ONLY);

        chooser.setDialogTitle(title);
        chooser.setAcceptAllFileFilterUsed(fileFilter == null);
        chooser.setFileFilter(fileFilter);
        chooser.setFileHidingEnabled(!showHidden);
        chooser.setMultiSelectionEnabled(!singleSelection);

        if (chooser.showDialog(null, button) != JFileChooser.APPROVE_OPTION)
            return new ArrayList<>();
        File[] selectedFiles = chooser.getSelectedFiles();
        if (selectedFiles.length < 1 && chooser.getSelectedFile() != null)
            selectedFiles = new File[]{chooser.getSelectedFile()};
        Collection<File> result = new ArrayList<>();
        for (File selected : selectedFiles)
            if (fileFilter == null || fileFilter.accept(selected))
                result.add(selected);
        return result;
    }
}
